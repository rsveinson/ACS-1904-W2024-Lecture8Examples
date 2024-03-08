import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;

public class ReadFromBinaryUntilEndOfFile{
    public static void main(String[] args)
    {
        DataInputStream is = getFile();
        int total = 0;
        
        if ( is != null ){
            total = getTotal(is);
            closeFile(is);
        }
        
        JOptionPane.showMessageDialog(null, "total = "+total);
        System.out.println("end");
    }

    public static DataInputStream getFile(){
        String fileName = JOptionPane.showInputDialog("Enter file name:");
        
        // if not set to null 
        // and is not set to null in catch block
        //we get an error
        //DataInputStream is = null;
        DataInputStream is;
        
        try {
            is = new DataInputStream( new FileInputStream(fileName));
            JOptionPane.showMessageDialog(null, "Success, file found");
        }
        catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "Error, file not found");
            is = null;
        }
        return is;
    }// end get file

    public static int getTotal(DataInputStream is){ 
        int total = 0;
        // read integers until there are none left
        boolean endOfFile = false;
        int i;
        while (! endOfFile){
            try{
                // readInt can throw EOFException or an IOException
                i = is.readInt();
                total += i;
                System.out.println(i);
                System.out.println(total);
            }
            catch (EOFException e){
                // force loop to terminate
                System.out.println("eof");
                System.out.println(e.toString());
                endOfFile = true;
            }
            catch (IOException e){
                JOptionPane.showMessageDialog(null, "Error, an IOException occurred reading the file");
                
                endOfFile = true;
            }
        }//end while not eof
        return total;
    }
    public static void closeFile (DataInputStream is){
        // close may throw an IOException
        try{
            is.close();
            JOptionPane.showMessageDialog(null, "program terminated normally");
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(null, "Error, an IOException occurred closing the file");
        }
    }
}

