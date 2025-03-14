import java.util.Scanner;
public class Q2Source
{
    public static void main(String[] args){
        int total = 0;
        Scanner kb = new Scanner(System.in);
        System.out.println("enter a number: ");
        String number = kb.next();
        
        while (!number.equals("q")){
            
            //int n = Integer.parseInt(number); 
            int n = parseInput(number);
            total += n;
            System.out.println("enter a number: ");
            number = kb.next();
        }
        System.out.println("total of numbers is "+total);
    }

    public static int parseInput(String s){
        int n = 0;
        try{
            /*parseInt() throws a NumberFormatException
             * so we can catch the exception to respond
             * gracefully to incorrect input
             */
            //return Integer.parseInt(s);
            n =  Integer.parseInt(s);
        }// end try
        catch (NumberFormatException e){
            System.out.println("oops, not an int");
        }// end catch
        // finally{
            // return 0;
        // }// end finally
        return n;
    }//end parse input
}
