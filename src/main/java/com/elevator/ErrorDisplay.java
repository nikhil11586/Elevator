package com.elevator;

public class ErrorDisplay extends Display {

	private DisplayType mType = DisplayType.Error;
	private String mError = null;
	private Direction mDirection = Direction.NONE;
	
	public ErrorDisplay(String pError) {
		mError = pError;
	}
	
	@Override
	public DisplayType getType() {
		// TODO Auto-generated method stub
		return mType;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return mError;
	}

	@Override
	public Direction getDirection() {
		// TODO Auto-generated method stub
		return mDirection;
	}

}
