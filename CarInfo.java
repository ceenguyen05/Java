/* Program Purpose :
 * Implements a Vechile Class and two child classes called car and motorscycle 
 * demonstrates uses of classes and inheritence as well as polymorphism
 */

import java.util.Scanner ; // for user input 

// main class to get essentials 
public class CarInfo 
{
    public static void main (String [] args)
    {
        Scanner input = new Scanner (System.in) ; // create scanner input for user input 
        
        // call get vehicle and assign the return string to vehicle , this will contain car or motorcycle 
        String vehicle = getVehicle(input) ;
        
        // ask how many doors for a car 
        // ask if there is a sidecar for a motorcycle 
        if (vehicle.equals("car")) {
            System.out.print("How many doors does your car have? ") ;
            int doors = input.nextInt() ;
            input.nextLine() ; // clear newline created by nextInt()
            
            // create a Car object , passing the number of doors 
            Car carClass = new Car (doors) ; 
            // call setBrand and setYear from the parent class and pass scanner and string variables 
            carClass.setBrand(input, vehicle) ;
            carClass.setYear(input, vehicle) ;
            // display the info about the users car 
            carClass.displayInfo() ;
        }
        else {
            // call getSidecar to get the users answer to the question
            String sidecar = getSidecar(input) ;
            
            // create a motorcycle object , passing the string if it has a sidecar
            Motorcycle motorcycleClass = new Motorcycle (sidecar) ; 
            // call setBrand and setYear from the parent class and pass scanner and string variables 
            motorcycleClass.setBrand(input, vehicle) ;
            motorcycleClass.setYear(input, vehicle) ;
            // display the info about the users motorcycle
            motorcycleClass.displayInfo() ;
        }
        input.close() ; // close input scanner to prevent leaks 
    }
    
    // method to get what type of vehicle user has 
    // do while loop to ensure user enters a car or motorcycle string 
    public static String getVehicle (Scanner input) {
        String vehicle ;
        do {
            System.out.print("What type of vehicle do you have? ") ;
            vehicle = (input.nextLine()).toLowerCase() ;
            // errors message if car or motorcycle isn't inputted
            if (!vehicle.equals("car") && !vehicle.equals("motorcycle")) {
                System.out.println("Invalid vehicle type, try again.\n") ;
            }
        } while (!vehicle.equals("car") && !vehicle.equals("motorcycle")) ;
        return vehicle ; // return the string to the main function 
    }
    
    // method to ensure yes or no is entered when prompted for sidecar 
    // do while loop until user enters yes or no
    public static String getSidecar (Scanner input) {
        String sidecar ;
        do {
            System.out.print("Does your motorcycle have a sidecar? (yes or no) ") ;
            sidecar = (input.nextLine()).toLowerCase() ;
            // error message if the user doesn't say yes or no
            if (!sidecar.equals("yes") && !sidecar.equals("no")) {
                System.out.println("Invalid choice entered, try again. \n") ;
            }
        }
        while (!sidecar.equals("yes") && !sidecar.equals("no")) ;
        return sidecar ; // returns choie to the main function 
    }
}

// parent class to generalize vehicles 
class Vehicle {
    // private member variables 
    private String brand ;
    private int year ;
    
    // constructor
    // empty variables 
    Vehicle () {
        this.brand = " " ;
        this.year = 0 ;
    }
    
    // setter 
    public void setBrand (Scanner input , String vehicle) {
        System.out.print("What is the brand of your " + vehicle + "? ") ;
        brand = input.nextLine () ;
    }
    
    // setter 
    public void setYear (Scanner input , String vehicle) {
        System.out.print("What is the year of your " + vehicle + "? ") ;
        year = input.nextInt() ;
    }
    
    // display info about the vehicle 
    public void displayInfo () {
        System.out.println("\nVehicle Info: ") ;
        System.out.print("Brand: " + brand + ", Year: " + year) ;
    }
    
}

// child class of vehicle for car type 
class Car extends Vehicle {
    // private member variable 
    private int doors ;
    
    // constructor, initializing doors 
    Car (int doors) {
        this.doors = doors ;
    }
    // Override the initial displayInfo function to add doors 
    @Override 
    public void displayInfo () {
        super.displayInfo() ; // use super to call the original function contents 
        System.out.println(", Number of doors: " + doors) ;
    }
}

// child class of vehicle for motorcycle type 
class Motorcycle extends Vehicle {
    // private member variable 
    private String sidecar ;
    
    // constrcutor, initializing sideCar 
    Motorcycle (String sidecar) {
        this.sidecar = sidecar ;
    }
    
    // Override the original displayInfo function to add the sidecar
    @Override 
    public void displayInfo () {
        super.displayInfo() ; // use super to call original displayInfo function
        System.out.println(", Sidecar: " + sidecar) ;
    }
}
