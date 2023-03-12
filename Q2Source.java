import java.util.Scanner;
public class Q2Source
{
    public static void main(String[] args){
        int total = 0;
        Scanner kb = new Scanner(System.in);
        System.out.println("enter a number: ");
        while (kb.hasNext()){
            String number = kb.next();
            int n = Integer.parseInt(number);  
            total += n;
            System.out.println("enter a number: ");
        }
        System.out.println("total of numbers is "+total);
    }
}
