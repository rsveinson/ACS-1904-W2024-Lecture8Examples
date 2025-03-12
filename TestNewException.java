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
            
            // invalid SIN. too long
            // System.out.println("Attempting to create employee 04645428600");
            // Employee e1 = new Employee("04645428600", "Joe Who", "instructor");
            // System.out.println("Create OK: "+e1);
            
            // invalid SIN. too short
            /* the current implemntation doesn't account for
             * a too short SIN, we get an ArrayIndexOutOfBounds
             * exception. How can we fix this problem?
             */
            // System.out.println("Attempting to create employee 434343");
            // Employee e1 = new Employee("434343", "Joe Who", "instructor");
            // System.out.println("Create OK: "+e1);
            
            // not valid SIN. failed check sum
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
        
        /*an invalid sin outside of the try/catch*/
        // System.out.println("Attempting to create employee 046454286");
        // Employee e3 = new Employee("0454286", "Keith Moon", "drummer");
        // System.out.println("Create OK: "+e3);
        
        
        System.out.println("program ended.");
    }
}
