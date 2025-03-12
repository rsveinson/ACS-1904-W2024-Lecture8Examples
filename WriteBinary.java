import java.io.ObjectOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteBinary {
    public static void main(String[] args)throws IOException {

        int[] myData = {5, 20, 30, 2, 7, 10, 10};

        DataOutputStream  os = new DataOutputStream(new FileOutputStream("myData.ser"));
        // create an object to reference practitioners.ser
        //ObjectOutputStream os = new ObjectOutputStream( new FileOutputStream("arrayOfInt.ser"));
        //os.writeObject(myData);

        // caution, while something like this will cause an exception in 
        // normal circumstances, since we're reading binary our program just reads the bits and
        // treats them like an int
        //os.writeDouble(4.5);
        //os.writeUTF("hello");
        for (int i=0; i<myData.length; i++){ 
            os.writeInt(myData[i]);
        }

        /* now add some incorrect data
         * to see if we can use the fact that
         * parseInt() throws a NumberFormatException
         * in the same way we did in a previous example
         */
        // os.writeDouble(4.5);
        // os.writeDouble(123.45);
        // os.writeChar('a');

        // // now some more correct data
        // for (int i=0; i<myData.length; i++){ 
            // os.writeInt(myData[i]);
        // }
        System.out.println("data written to file");
        os.close();

        System.out.println("end of program");
    }
}
