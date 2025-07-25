package virtualMoped;

/**
 * A virtual moped, roaming the streets of New York.
 * The signatures of a few methods are given and must be completed and used as
 * indicated.
 * Create as many additional properties or methods as you want, as long as the
 * given methods behave as indicated in the instructions.
 * Follow good object-oriented design, especially the principles of abstraction
 * (i.e. the black box metaphor) and encapsulation (i.e. methods and properties
 * belonging to specific objects), as we have learned them.
 * The rest is up to you.
 */
public class Moped {
    private int street;
    private int avenue;
    private String orientation;
    private int gasLevel;
    private boolean parked; 
    


    /**
     * Constructs a moped initialized to 10th St. and 5th Ave., facing South.
     * This constructor should not take in any arguments and utilize the other 
     * constructor.
     */

     public Moped() {
        this(10, 5, "south");
        // Start the moped life at 10th St. and 5th Ave., facing South.
     }

     /**
     * Constructs a moped initialized to the provided parameters
     * 
     * @param street int the street the moped is initially placed at
     * @param avenue int avenue the moped is initially placed at
     * @param direction String "north","south","east","west" indicating the initial direction of the moped
     */

     public Moped(int street, int avenue, String direction) {
        this.street = street;
        this.avenue = avenue;
        this.orientation = direction.toLowerCase();
        this.gasLevel = 100;
        this.parked = false;
        
        // please fill this out
     }

    /**
     * Sets the orientation of the moped to a particular cardinal direction.
     * 
     * @param orientation A string representing which cardinal direction at which to
     *                    set the orientation of the moped. E.g. "north", "south",
     *                    "east", or "west".
     */
    public void setOrientation(String orientation) {
        this.orientation = orientation.toLowerCase();


    }

    /**
     * Returns the current orientation of the moped, as a lowercase String.
     * E.g. "north", "south", "east", or "west".
     * 
     * @return The current orientation of the moped, as a lowercase String.
     */
    public String getOrientation() {
        return this.orientation; // dummy return statement
    }

    /**
     * Prints the current location, by default exactly following the format:
     * Now at 12th St. and 5th Ave, facing South.
     *
     * If the current location is associated with location-based advertising, this
     * method should print exactly following format:
     * Now at 12th St. and 4th Ave, facing West. Did you know The Strand has 18 Miles of new, used and rare books, and has been in business since 1927?
     * 
     * Note that the suffixes for the numbers must be correct: i.e. the "st" in
     * "1st", "nd" in "2nd", "rd" in "3rd", "th" in "4th", etc, must be correct.
     */
    public void printLocation() {
        String suffix = getStreetSuffix(street);
        System.out.println("Now at " + street + suffix +  " " + "St. and  " + avenue + "th Ave, facing " + capitalize(orientation) + ".");
        if (street == 12 && avenue == 4 && orientation.equals("west")){
            System.out.println("Did you know The Strand has 18 Miles of new, used and rare books, and has been in business since 1927?");
        }

//Now at 10thSt. and 5th Ave, facing West.
    }

    /**
     * Handles the command, `turn left`.
     * Causes the moped to face the appropriate new cardinal direction.
     * Consumes gas with each turn, and doesn't turn unless there is
     * sufficient gas and it isn't parked, as according to the instructions.
     * This method must not print anything.
     */
    public void turnLeft() {
        if (!canMove()) return;
                switch(orientation){
                    case "north":
                     orientation = "west";
                      break;
            case "west": 
            orientation = "south"; 
            break;
            case "south": 
            orientation = "east"; 
            break;
            case "east": 
            orientation = "north"; 
            break;
                }
                consumeGas();
            }

    

    /**
     * Handles the command, `turn right`.
     * Causes the moped to face the appropriate new cardinal direction.
     * Consumes gas with each turn, and doesn't turn unless there is
     * sufficient gas and isn't parked, as according to the instructions.
     * This method must not print anything.
     */
    public void turnRight() {
        if (!canMove()) return;
            switch(orientation){
                case "north": 
                orientation = "east"; 
                break;
            case "east": 
            orientation = "south";
             break;
            case "south": 
            orientation = "west";
             break;
            case "west": 
            orientation = "north";
             break;
            }
            consumeGas();
        }

    

    /**
     * Handles the command,`straight on`.
     * Moves the moped one block straight ahead.
     * Consumes gas with each block moved, and doesn't move unless there is
     * sufficient gas and isn't parked, as according to the instructions.
     * This method must not print anything.
     */
    public void goStraight() {
                    if (parked || gasLevel < 5) return;
        
            boolean moved = false;
        
            switch (orientation) {
                case "north":
                    if (street < 200) {
                        street++;
                        moved = true;
                    }
                    break;
                case "south":
                    if (street > 1) {
                        street--;
                        moved = true;
                    }
                    break;
                case "east":
                    if (avenue < 10) {
                        avenue++;
                        moved = true;
                    }
                    break;
                case "west":
                    if (avenue > 1) {
                        avenue--;
                        moved = true;
                    }
                    break;
            }
        if(moved) 
        consumeGas();
    }
    public void goBackwards() {
        if (parked || gasLevel < 5) return;
    
        boolean moved = false;
    
        switch (orientation) {
            case "north":
                if (street > 1) {
                    street--;
                    moved = true;
                }
                break;
            case "south":
                if (street < 200) {
                    street++;
                    moved = true;
                }
                break;
                case "east":
                if (avenue < 10) {  
                    avenue++;
                    moved = true;
                }
                break;
            case "west":
                if (avenue > 1) {  
                    avenue--;
                    moved = true;
                }
                break;
            }
                if(moved)
        consumeGas();
                
        }
           
    /**
     * Handles the command,`how we doin'?`.
     * This method must not print anything.
     * 
     * @return The current gas level, as an integer from 0 to 100.
     */
    public int getGasLevel() {
        return gasLevel; // dummy return statement
    }

    /**
     * Prints the current gas level, by default exactly following the format:
     * The gas tank is currently 85% full.
     *
     * If the moped is out of gas, this method should print exactly following
     * format:
     * We have run out of gas. Bye bye!
     */
    public void printGasLevel() {
        if (gasLevel <= 0){
            System.out.println("We have run out of gas. Bye bye!");
        } else {
            System.out.println("The gas tank is currently " + gasLevel + "% full.");
        }

    }

    /**
     * Handles the command, `fill it up`.
     * This method must not print anything.
     * Fills the gas level to the maximum.
     */
    public void fillGas() {
        gasLevel = 100;

    }

    /**
     * Handles the command, `park`.
     * Prints out the statement "We have parked." and makes the vehicle park.
     */
    public void park() {
        parked = true;
        System.out.println("We have parked");

    }

    /**
     * Handles the command, `go to Xi'an Famous Foods`
     * Causes the moped to self-drive, block-by-block, to 8th Ave. and 15th St.
     * Consumes gas with each block, and doesn't move unless there is sufficient
     * gas, as according to the instructions.
     */
    public void goToXianFamousFoods() {
        if (parked) return;

        while (street != 15 || avenue != 8) {
            if (gasLevel <= 0) fillGas();
                
        if (street < 15) {
            while (!orientation.equals("north")) {
                turnRight();
            }
            goStraight();
        } else if (street > 15) {
            while (!orientation.equals("south")) {
                turnRight();
            }
            goStraight();
        } else if (avenue < 8) {
            while (!orientation.equals("west")) {
                turnRight();
            }
            goStraight();
        } else if (avenue > 8) {
            while (!orientation.equals("east")) {
                turnRight();
            }
            goStraight();
        }

        printLocation();
    }
}

    /**
     * Generates a string, containing a list of all the user commands that the
     * program understands.
     * 
     * @return String containing commands that the user can type to control the
     *         moped.
     */
    public String getHelp() {
        return "Commands:\n" + "- turn left\n" + "- turn right\n" + "- straight on\n" + "- back up\n" + "- how we doin'?\n" + "- fill it up\n" + "- park\n" + "- go to Xi'an Famous Foods\n" + "- help";

       
        // dummy return statement
    }

    /**
     * Sets the current location of the moped.
     * 
     * @param location an int array containing the new location at which to place
     *                 the moped, in the order {street, avenue}.
     */
    public void setLocation(int[] location) {
            this.street = location[0];
            this.avenue = location[1];
    }

    /**
     * Gets the current location of the moped.
     *  array in the order
     *         {street, avenue}.
     */
    public int[] getLocation() {
        return new int[]{street, avenue}; // dummy return statement
    }
    private boolean canMove(){
        return gasLevel >=5 && !parked;
    }
    public void consumeGas(){
        gasLevel -= 5;
        if (gasLevel < 0){
            gasLevel = 0;
        }
    }
        private String getStreetSuffix(int n) {
            if (n % 100 >= 11 && n % 100 <= 13) {
                return "th";
            } else {
            switch (n % 10) {
                case 1: return "st";
                case 2: return "nd";
                case 3: return "rd";
                default: return "th";
            }
    } 
}
    private String capitalize(String s) {
        if (s == null || s.length() == 0) return s;
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

}