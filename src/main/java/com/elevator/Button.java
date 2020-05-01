package com.elevator;

public abstract class Button {

	public abstract ButtonType getType();
	public abstract int getFloorNumber();
	public abstract Direction getButtonDirection();
	
	@Override
	public String toString() {
		return this.getType() +", "+this.getFloorNumber()+", "+this.getButtonDirection();
	}
}
