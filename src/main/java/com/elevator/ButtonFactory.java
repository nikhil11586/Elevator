package com.elevator;

public class ButtonFactory {

	public static Button _getButton(int pFloorNumber) {
		return new FloorCallButton(pFloorNumber);
	}
	
	public static Button _getButton(int pFloorNumber, Direction pButtonDirection) {
		return new ElevatorCallButton(pFloorNumber, pButtonDirection); 
	}
}
