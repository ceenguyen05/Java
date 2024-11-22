import java.util.Scanner ; // for user input 
import java.util.ArrayList ; // used for an ArrayList
import java.util.List ; // used for lists

public class EmployeeHierarchy {
    
    // main method 
    public static void main (String [] args)
    {
        Scanner input = new Scanner(System.in) ; // create scanner for input 
        List<String> employees = new ArrayList<>() ; // creates an ArrayList to store employee info
        int numberOfEmployees = numberEmployees(input) ; // call method and store return value 
        input.nextLine() ; // clear newline int 
        
        for (int count = 0 ; count < numberOfEmployees ; count++) {
            String name = getName(input) ; // call method and store return value 
            String id = getId(input) ; // call method and store return value 
            double salary = getSalary(input) ; // call method and store return value
            input.nextLine() ; // clear newline from double 
            String position = getPosition(input) ; // get position, call method
            
            // if it is an employee, just pass the previous infomation to the class 
            // store the string
            if (position.equals("employee")) {
                // creates an object of the class and passes arguments to the constructor
                Employee employeeClass = new Employee (name , id , salary) ; 
                employees.add(employeeClass.displayInfo()) ;
            }
            // if it is a developer, ask for the lanuage and pass all infomation
            // store the display string in the list
            else if (position.equals("developer")) {
                String language = getLanguage(input) ;
                // creates an object , polymorphism as well
                Employee developerClass = new Developer (name , id , salary , language) ;
                employees.add(developerClass.displayInfo()) ;
            }
            // if it isnt the othet two it is a manager, pass all info to constructor 
            // store in arrayList
            else {
                String department = getDepartment(input) ;
                // polymorphism 
                Employee managerClass = new Manager (name , id , salary , department) ;
                employees.add(managerClass.displayInfo()) ;
            }
        
            System.out.println() ; // for formatting
        }
        
        // goes through each string in the list and prints 
        for (String items : employees) {
            System.out.println(items) ;
        } 
    }
    
    // method to get number of employees
    public static int numberEmployees (Scanner input) {
        System.out.print("How many employees are in your company? ") ;
        return input.nextInt() ;
    }
    
    // method to get employee name 
    public static String getName (Scanner input) {
        System.out.print("What is the employee name? ") ;
        return input.nextLine() ;
    }
    
    // method to get employee id
    public static String getId (Scanner input) {
        System.out.print("What is the id? ") ;
        return input.nextLine() ;
    }
    
    // method to get the employee salary
    public static double getSalary (Scanner input) {
        System.out.print("What is the employee salary? ") ;
        return input.nextDouble() ;
    }
    
    // method to get position 
    public static String getPosition (Scanner input) {
        List<String> positions = new ArrayList<>() ;
        positions.add("employee") ;
        positions.add("developer") ;
        positions.add("manager") ;
        String position = "" ;
        while (true) 
        {
            System.out.print("What is your position? ") ;
            position = input.nextLine().toLowerCase() ;
            if (positions.contains(position)) {
            return position ;
            }
            System.out.println("Invalid Position") ;
        }
    }
    
    // method to get prorgamming language 
    public static String getLanguage (Scanner input) {
        System.out.print("What programming language do you use? ") ;
        return input.nextLine() ;
    }
    
    // method to get department
    public static String getDepartment (Scanner input) {
        System.out.print("What department are you in? ") ;
        return input.nextLine() ;
    }
}

// superclass employee
class Employee {
    // member variables
    private String name ;
    private String id ;
    protected double salary ;
    
    // constructor 
    Employee (String name , String id , double salary) {
        this.name = name ;
        this.id = id ;
        this.salary = salary ;
    }
    
    // calculates the bonus of an employee and returns the value 
    public double calculateBonus () {
        return salary * 0.05 ; // regular bonus percentage of a regular employee 
    }
    
    // returns a string that displays the emmployees info 
    public String displayInfo () {
        return "Name: " + name + ", ID: " + id + ", Bonus: " + String.format("%.2f", calculateBonus()) ;
    }
}

// subclass of employee, gets the programming language 
class Developer extends Employee {
    private String language ;
    
    // constructor 
    Developer (String name , String id , double salary , String language) {
        super(name , id , salary) ; // passes to parent class 
        this.language = language ;
    }
    
    @Override 
    public double calculateBonus () {
        return salary * 0.1525 ; // bonus rate for Developer
    }
    
    @Override 
    public String displayInfo () {
        String originalInfo = super.displayInfo() ; // call the parent class method first
        return originalInfo + ", Programming Language: " + language ;
    }
}

class Manager extends Employee {
    private String department ;
    
    // constructor 
    Manager (String name , String id , double salary , String department) {
        super (name , id , salary) ; // passes to parent class 
        this.department = department ;
    }
    
    @Override 
    public double calculateBonus() {
        return salary * .2225 ; // bonus rate for Manager 
    }
    
    @Override 
    public String displayInfo () {
        String originalInfo = super.displayInfo() ;
        return originalInfo + ", Department: " + department ;
    }
}