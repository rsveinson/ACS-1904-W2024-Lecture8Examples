/**
 * Create two employees.
 * catch-block displays a stack trace if creating an employee fails.
 */
    public class TestNewException
{
    public static void main(String[] args)throws InvalidSINException
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
        }// end try
        /* note that the custom message in the catch block
         * refers to the getter in the checked exception object e
         */
        catch (InvalidSINException e){
            System.out.println("Error creating employee. "+
                "The provided SIN, "+ e.getSin()+" is invalid ");
              System.out.println(e);
              e.printStackTrace();
        }
        
        // System.out.println("Attempting to create employee 046454286");
        // Employee e3 = new Employee("0454286", "Keith Moon", "drummer");
        // System.out.println("Create OK: "+e3);
        
        
        System.out.println("program ended.");
    }
}
