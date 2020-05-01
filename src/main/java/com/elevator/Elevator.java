package com.elevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Elevator {
	
	private State mState = State.STOPPED;
	private Direction mDirection = Direction.NONE;
	private int mCurrentFloor = 0;
	private final int mMinFloor = 0;
	private final int mMaxFloor = 4;
	private List<Integer> mCurrentListOfFloors = new ArrayList<Integer>();
	private List<Integer> mNextListOfFloors = new ArrayList<Integer>();
	private final int mMaxWeightOnElevator = 100;
	private ElevatorEvents mEventHandler = null;
	private static Elevator _elevator = null;
	
	private Elevator(ElevatorEvents pElevatorEvents) {
		mEventHandler = pElevatorEvents;
	}
	
	public static Elevator _getInstance(ElevatorEvents pElevatorEvents) {
		if(_elevator == null)
			_elevator = new Elevator(pElevatorEvents);
		return _elevator;
	}
	
	public void start() {
		mState = State.IDEAL;
//		handler.display(DisplayFactory.getDisplay(""+mCurrentFloor, mDirection));
	}
	
	public void stop() {
		mState = State.STOPPED;
	}
	
	public void reset() {
		start();
		stop();
	}
	
	public void closeDoor() {
		//Close the door if the passenger weight is less than defined max weight
		if(Utility.getInstance().calculateCurrentWeight() < mMaxWeightOnElevator) {
        	moveElevator();
            mEventHandler.closeDoor(mCurrentFloor);
    	} else {
    		//If the elevator is overloaded then display the error message. 
    		mEventHandler.display(DisplayFactory._getDisplay(ErrorCode.E01.label));
    	}
		
		if(mState == State.IDEAL && mDirection == Direction.NONE)
			mEventHandler.display(DisplayFactory._getDisplay("show_option", mDirection));
	}
	
	public void openDoor() {
		TimerTask task = new TimerTask() {
	        public void run() {
	        	closeDoor();
	        }
	    };
	    Timer timer = new Timer("DoorOpenTimer");
	    mState = State.STOPPED; 
	    mEventHandler.openDoor(mCurrentFloor);
	    timer.schedule(task, 5000);
	}
	
	private void moveElevator() {
		//If current list of floor is empty, then start processing the next list of floors.
		if(mCurrentListOfFloors.size() == 0) {
			if(mNextListOfFloors.size() > 0) {
				mCurrentListOfFloors.addAll(mNextListOfFloors);
				mNextListOfFloors.clear();
			} else { //If current and next list of floors are empty, then set the state is ideal and direction as none.
				mDirection = Direction.NONE;
				mState = State.IDEAL;
				return;
			}
		}
		
		mState = State.MOVING;
		//Set the elevator direction based on next floor.
		if(mCurrentFloor < mCurrentListOfFloors.get(0))
			mDirection = Direction.UP;
		else mDirection = Direction.DOWN;
		moveElevatorTimer();
	}
	
	private void moveElevatorTimer() {
		TimerTask task = new TimerTask() {
	        public void run() {
	        	if(mDirection == Direction.DOWN)
	        		--mCurrentFloor;
	        	else ++mCurrentFloor;	        	
	        	
	        	mEventHandler.display(DisplayFactory._getDisplay(""+mCurrentFloor, mDirection));
	        	
	        	if(mCurrentFloor == mCurrentListOfFloors.get(0)) {
	        		mCurrentListOfFloors.remove(0);
	        		openDoor();
	        	} else moveElevator();
	        }
	    };
	    Timer timer = new Timer("ElevatorMoveTimer"); 
	    timer.schedule(task, 3000);
	}
	
	public void buttonPressed(Button pButton) {

		if(pButton.getFloorNumber() < mMinFloor || pButton.getFloorNumber() > mMaxFloor)
			return;
		
		//If that floor number is already in the list
		if(mCurrentListOfFloors.contains(pButton.getFloorNumber()))
			return;

		//If the elevator is ideal/stopped on the same floor, then open the door
		if(pButton.getFloorNumber() == mCurrentFloor && (mState == State.STOPPED || mState == State.IDEAL)) {
			openDoor();
			return;
		}

		//If the elevator is ideal/stopped on some other floor, just move the elevator towards the requested floor
		if(mDirection == Direction.NONE) {
			mCurrentListOfFloors.add(pButton.getFloorNumber());
			moveElevator();
			return;
		}

		//If the user has pressed the elevator call button and the elevator's current direction is different than the
		//elevator call direction, then add this request in the next queue.
		if(pButton.getType() == ButtonType.ElevatorCall && mDirection != pButton.getButtonDirection()) {
			if(mNextListOfFloors.contains(pButton.getFloorNumber()))
				return;
			switch(pButton.getButtonDirection()) {
				case DOWN:
						mNextListOfFloors.add(pButton.getFloorNumber());
						Collections.sort(mNextListOfFloors, Collections.reverseOrder());
					break;
				default:
						mNextListOfFloors.add(pButton.getFloorNumber());
						Collections.sort(mNextListOfFloors);
					break;
			}
			return;
		} 

		//Based on elevator's current direction, add the ongoing request in current floor list and sort the list.
		switch(mDirection) {
			case DOWN:
				//If the requested floor is within the range then add it current floor list
				//Else add to next floor list
				if(mCurrentFloor > pButton.getFloorNumber()) {
					mCurrentListOfFloors.add(pButton.getFloorNumber());
					Collections.sort(mCurrentListOfFloors, Collections.reverseOrder());
				} else {
					mNextListOfFloors.add(pButton.getFloorNumber());
					Collections.sort(mNextListOfFloors);
				}
				break;
			default:
				//If the requested floor is within the range then add it current floor list
				//Else add to next floor list
				if(mCurrentFloor < pButton.getFloorNumber()) {
					mCurrentListOfFloors.add(pButton.getFloorNumber());
					Collections.sort(mCurrentListOfFloors);
				} else {
					mNextListOfFloors.add(pButton.getFloorNumber());
					Collections.sort(mNextListOfFloors, Collections.reverseOrder());
				}
				break;
		}
	}
}
