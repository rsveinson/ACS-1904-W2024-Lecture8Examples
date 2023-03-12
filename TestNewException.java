/**
 * Create two employees.
 * catch-block displays a stack trace if creating an employee fails.
 */
    public class TestNewException
{
    public static void main(String[] args)
    {
        try {
            // a valid SIN.
            System.out.println("Attempting to create employee 046454286");
            Employee e1 = new Employee("046454286", "Joe Who", "instructor");
            System.out.println("Create OK: "+e1);
            
            // not valid SIN.
            // An exception will be thrown
            System.out.println("\nAttempting to create employee 123456789");
            Employee e2 = new Employee("123456789", "Steve Stephens", "instructor");
            System.out.println("Create OK: "+e2);
        }

        catch (InvalidSINException e){
            System.out.println("Error creating employee. "+
                "The provided SIN, "+ e.getSin()+" is invalid ");
              e.printStackTrace();
        }
        
        System.out.println("program ended.");
    }
}
