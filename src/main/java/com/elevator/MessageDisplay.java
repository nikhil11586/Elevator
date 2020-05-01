package com.elevator;

public class MessageDisplay extends Display {

	private DisplayType mType = DisplayType.Message;
	private String mMessage = null;
	private Direction mDirection;
	
	public MessageDisplay(String pMessage, Direction pDirection) {
		mMessage = pMessage;
		mDirection = pDirection;
	}
	
	@Override
	public DisplayType getType() {
		// TODO Auto-generated method stub
		return mType;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return mMessage;
	}

	@Override
	public Direction getDirection() {
		// TODO Auto-generated method stub
		return mDirection;
	}

}
