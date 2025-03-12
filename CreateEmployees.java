import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.File;

/**
 * Create two employees.
 * catch-block displays a stack trace if creating an employee fails.
 */
public class CreateEmployees
{
    public static void main(String[] args)throws InvalidSINException, FileNotFoundException
    {
        Scanner scanner = null;
        String sin;
        String name;
        String position;

        String strin;
        String delim = "[ ]+";      // delmiter
        String[] tokens;

        ArrayList<Employee> employees = new ArrayList<>();

        // try to open the file stream
        try{
            scanner = new Scanner(new File("SinData.txt"));
        }// end try
        catch(FileNotFoundException e){
            scanner = null;     // just in case
            System.out.println("Opps, file not found");
        }// end catch

        // start reading the records from the file and adding
        while(scanner.hasNextLine()){
            strin = scanner.nextLine();
            //System.out.println(strin);

            // deal with the input record
            tokens = strin.split(delim);
            // now we have ["sin" "name" "position"]
            
            sin = tokens[0];
            name = tokens[1];
            position = tokens[2];
            
            //System.out.println(sin + " " + name + " " + position);

            // use the tokens array to create and add new employees
            try{
                employees.add(new Employee(sin, name, position));
                System.out.println("employee added");
            }// end try
            catch (InvalidSINException e){
                System.out.println("Error creating employee. "+
                    "The provided SIN, "+ e.getSin()+" is invalid ");
                System.out.println(e);
                e.printStackTrace();
            }// end catch

        }// end while
        
        // print the list or employees
        System.out.println("\nEmployee list");
        System.out.println(employees);
        

        System.out.println("program ended.");
    }
}
