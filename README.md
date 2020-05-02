### How to run the program?
Download the code and import it in eclipse as a maven project and then run it as a Java Application.

### More details
* There are multiple use cases and scenarions for elevetor system.
* I have implemented "must have" scenarios (For more details, please go through the usecases document from doc folder)
* For testing I have hard coded 2 scenario's in the program itself.
    * Scenario 1:
        * step 1: Elevator is at ground (i.e. 0th) floor
        * step 2: A user from 4th floor calls the lift and goes down at 0th floor
    * Scenario 2:
        * step 1: Elevator is at ground (i.e. 0th) floor
        * step 2: A user from 4th floor calls the lift and goes down at 0th floor
        * step 3: Before elevator crosses the 1st floor, a user from 2nd floor calls the lift and want's to go to 3rd floor
        * step 4: After elevator crosses the 1st floor, a user from 1nd floor calls the lift and want's to go to 3rd floor
        * step 5: On 4th floor, 6 person (each having 20kg wait) enters to the lift and lift gets **overloaded**. 
        * Now the door will keep open unit you press **'x'** and enter, it will indicate that few person has left the elevator 
        * Then elevator will close the door and start moving.
* For knowing the elevator position 
    * I have displayed the current floor number and direction of the lift like **3 : UP** i.e. lift on the current floor i.e. 3rd floor and going in upward direction.
    * If lift is overloaded, then overloaded message is displayed on the console. When **Overloaded** message is displayed, then the door will not close until "x" character is not entered on the cosole.
    * Whenever the lift stops at any floor, a message **Door opened at {floor_number}** is displed on the console, i.e. the elevator door has been opened on that floor and a message **Door closed** is displayed on the console, acknowledging the door is closed.