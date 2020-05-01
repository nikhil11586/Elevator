package com.elevator;

public abstract class Display {

	public abstract DisplayType getType();
	public abstract String getMessage();
	public abstract Direction getDirection();
	
	@Override
	public String toString() {
		return this.getType() +", "+this.getMessage()+", "+this.getDirection();
	}
	
}
