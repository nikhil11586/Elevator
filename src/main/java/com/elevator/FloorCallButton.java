package com.elevator;

public class FloorCallButton extends Button {
	
	private ButtonType mType = ButtonType.FloorCall;
	private int mDestinationFloorNumber = -1;
	
	public FloorCallButton(int pDestinationFloorNumber) {
		mDestinationFloorNumber = pDestinationFloorNumber;
	}

	@Override
	public ButtonType getType() {
		// TODO Auto-generated method stub
		return mType;
	}

	@Override
	public int getFloorNumber() {
		// TODO Auto-generated method stub
		return mDestinationFloorNumber;
	}

	@Override
	public Direction getButtonDirection() {
		// TODO Auto-generated method stub
		return Direction.NONE;
	}

}
