package com.elevator;

public interface ElevatorEvents {
	void openDoor(int pFloorNumber);
	void closeDoor(int pFloorNumber);
	void display(Display pDisplay);
}
