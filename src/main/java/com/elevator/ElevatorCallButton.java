package com.elevator;

public class ElevatorCallButton extends Button {

	private ButtonType mType = ButtonType.ElevatorCall;
	private int mSourceFloorNumber = -1;
	private Direction mButtonDirection;
	
	public ElevatorCallButton(int pSourceFloorNumber, Direction pButtonDirection) {
		mSourceFloorNumber = pSourceFloorNumber;
		mButtonDirection = pButtonDirection;
	}
	
	@Override
	public ButtonType getType() {
		// TODO Auto-generated method stub
		return mType;
	}

	@Override
	public int getFloorNumber() {
		// TODO Auto-generated method stub
		return mSourceFloorNumber;
	}

	@Override
	public Direction getButtonDirection() {
		// TODO Auto-generated method stub
		return mButtonDirection;
	}

}
