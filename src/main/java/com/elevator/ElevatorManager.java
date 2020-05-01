package com.elevator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.TimerTask;

public class ElevatorManager implements ElevatorEvents {

	private Elevator mElevator = null;
	private int numberPassengerFrom4thFloor = 1;
	
	public ElevatorManager() {
		if(mElevator == null)
			mElevator = Elevator._getInstance(this);
		
		mElevator.start();
		displayOption();
	}
	
	private void displayOption() {
		System.out.println("We have implemented the test for two scenarios.");
		System.out.println("***** Scenario 1:");
		System.out.println("step 1: Elevator is at ground (i.e. 0) floor");
		System.out.println("step 2: A user from 4th floor calls the lift and goes down at 0th floor");
		System.out.println("\n*****Scenario 2:");
		System.out.println("step 1: Elevator is at ground (i.e. 0) floor");
		System.out.println("step 2: A user from 4th floor calls the lift and goes down at 0th floor");
		System.out.println("step 3: Before elevator crosses the 1st floor, a user from 2nd floor calls the lift and want's to go to 3rd floor");
		System.out.println("step 4: After elevator crosses the 1st floor, a user from 1nd floor calls the lift and want's to go to 3rd floor");
		System.out.println("step 5: On 4th floor, 6 person (each having 20kg wait) enters to the lift and lift gets overloaded. \nNow the door will keep open unit you press 'x', it will indicate that few person has left the elevator \nThen elevator will close the door and start moving.\n\nPlease select your option (1/2):");
		
		BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
		
		try {
	        String option = reader.readLine();
	        System.out.println("**** Starting the test \n");
	        if(option.equals("1"))
	        	startTest(1);
	        else
	        	startTest(2);
	        
	    } catch(Exception e) {}
	}
	
	private void startTest(int pOption) {
		numberPassengerFrom4thFloor = 1;
		//User presses the Down Elevator call button from 4th floor. 
		Button myButton = ButtonFactory._getButton(4, Direction.DOWN);
		mElevator.buttonPressed(myButton);

		if(pOption == 2) {
			numberPassengerFrom4thFloor = 6;
			//After 9sec, user presses the Up Elevator call button from 1st floor.
			TimerTask task1 = new TimerTask() {
		        public void run() {
		        	Button myButton = ButtonFactory._getButton(1, Direction.UP);
		    		mElevator.buttonPressed(myButton);
		        }
		    };
		    Timer timer1 = new Timer("Timer1");
		    timer1.schedule(task1, 9000);
			
			//After 5sec, user presses the Up Elevator call button from 1st floor.
			TimerTask task2 = new TimerTask() {
		        public void run() {
		        	Button myButton = ButtonFactory._getButton(2, Direction.UP);
		    		mElevator.buttonPressed(myButton);
		        }
		    };
		    Timer timer2 = new Timer("Timer1");
		    timer2.schedule(task2, 5000);
		    
		    try {
		    	BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
		    	String input = reader.readLine();
		    	if(input.equals("x"))
		    		removePassenger();
		    } catch(Exception e) {
		    	
		    }
		}
	}
	
	public void openDoor(int pFloorNumber) {
		// TODO Auto-generated method stub
		System.out.println("** Door Opened at "+pFloorNumber);
		switch(pFloorNumber) {
		case 4: 
			Utility.getInstance().addPassengers(numberPassengerFrom4thFloor);
			Button myButton1 = ButtonFactory._getButton(0);
			mElevator.buttonPressed(myButton1);
			break;
		case 3:
			Utility.getInstance().removePassengers(1);
			break;
		case 2:
			Utility.getInstance().addPassengers(1);
			Button myButton2 = ButtonFactory._getButton(3);
			mElevator.buttonPressed(myButton2);
			break;
		case 1:
			Utility.getInstance().addPassengers(1);
			Button myButton3 = ButtonFactory._getButton(3);
			mElevator.buttonPressed(myButton3);
			break;
		case 0:
			if(numberPassengerFrom4thFloor > 1)
				Utility.getInstance().removePassengers(3);
			else
				Utility.getInstance().removePassengers(1);
			break;
		}
	}

	public void closeDoor(int pFloorNumber) {
		// TODO Auto-generated method stub
		System.out.println("** Door Closed");
	}
	
	public void removePassenger() {
		Utility.getInstance().removePassengers(3);
		mElevator.closeDoor();
	}

	public void display(Display pDisplay) {
		// TODO Auto-generated method stub
		if(pDisplay.getType() == DisplayType.Message) {
			if(pDisplay.getMessage().equalsIgnoreCase("show_option"))
				displayOption();
			else
				System.out.println(pDisplay.getMessage() +" : "+pDisplay.getDirection());
		} else
			System.out.println(pDisplay.getMessage());
	}

}
