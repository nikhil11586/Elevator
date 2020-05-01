## Use cases
1. Elevator accessories
    1. Each floor should have an indicator for the elevator moving direction.
    2. Each floor should have an up and down elevator call button, except ground and 4th floor. Ground floor should have only the up elevator call button and the 4th floor should have only the down elevator call button. 
    3. Elevator should have floor call buttons like G, 1, 2, 3 and 4
    4. Elevator should have an alarm and phone call button for emergencies.
    5. Elevator should have a display to indicate the direction of the elevator and the current/upcoming floor number.
    6. Elevator should have a fire extinguisher kit. 
    7. Elevator should have a fan/light and the button to operate the fan/light.
    8. In case the lift is ideal for X amount of time and the fan/light is on, then it should automatically get off.
    9. There has to be a key to open the elevator door of each floor.
    10. Elevator should have the generator and UPS backup systems.
2. Elevator door
    1. If an elevator arrives at the destination floor, then the elevator should open the door.
    2. If passengers are entering or leaving the elevator, then the elevator’s door should be open for X amount of time.
    3. If the elevator door is getting close and passengers still want to enter or leave the elevator, then the door should again be opened for X amount of time (With the help of sensors, the elevator will detect if anyone is entering or leaving the elevator).
3. Elevator buttons
    1. If the user is on the ground floor and the elevator is on some other floor say 4th floor and the user pressed the up elevator call button, then the elevator should come to the ground floor.
    2. If the elevator is travelling from some floor say ground floor to some other floor say 4th floor and if another user presses the up elevator call button from 2nd floor, then the elevator should stop on the 2nd floor. If that user (from 2nd floor) presses the 3rd floor button, then the elevator should first stop on the 3rd floor and then move forward for the 4th floor. Note that the elevator should stop on the 2nd floor if the user from 2nd floor has pressed the elevator call button before the elevator crosses 1st floor. 
    3. If the elevator is travelling from ground floor to 4th floor (i.e. in upward direction) and the user from 2nd floor presses the down elevator call button, then the elevator should not stop while going in upward direction but after dropping the passenger, the elevator should come down to 2nd floor to pick up the passenger from 2nd floor.
    4. If the elevator is travelling from ground floor to 4th floor (i.e. in upward direction) and the user from 2nd floor presses the up elevator call button before the elevator crosses the 1st floor, then the elevator should stop on the 2nd floor and pick up the passenger. If that passenger presses the ground floor button, then the elevator should still go in an upward direction (i.e. towards the 4th floor) and the floor call buttons should get reset after reaching the 4th floor.
    5. While onboarding the passengers, the elevator should calculate the total wait on the elevator and if the total wait is more than 100kg, the elevator should play the sound indicating that it is being overloaded and dorr should not get close.
    6. Elevator doesn't stop in between ( stop request)  while traversing UP n DOWN in case of fully capacitated
4. Elevator display
    1. If an elevator is ideal on some floor, say ground/1/2/3/4, then the display from all the floors should indicate as G/1/2/3/4 respectively on all the displays.
    2. If an elevator is travelling from ground floor to 4th floor, then on the display inside the elevator, it should indicate the upcoming floor and the display outside the elevator should indicate the current floor.
    3. If an elevator is travelling in either upward or downward direction, then should display the respective arrow on inside and outside display.
    4. If there is any failure, then the inside and outside display should indicate the error code.
5. Elevator failure
    1. In case of a power cut, the elevator should automatically switch to a generator.
    2. In case of generator failure or any other failure, the elevator’s door should automatically get opened with the help of UPS. 
    3. In case of any failure (power, generator, UPS), lift should get open with the help of a key.
