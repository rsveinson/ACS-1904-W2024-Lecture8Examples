import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
public class HandleFileNotFound {
    public static void main(String[] args)
    {
        String fileName = JOptionPane.showInputDialog("Enter file name:");
        DataInputStream is = null;
        //DataInputStream is;
        
        try {
            is = new DataInputStream( new FileInputStream(fileName));
            JOptionPane.showMessageDialog(null, "Success, file found");
        }
        catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "Error, file not found" + e);
        }
        finally{
            JOptionPane.showMessageDialog(null, "finally clause executing");
            // Normally we would close open files here, but for DataInputStream
            // that involves another exception, and so we leave that to a later
            // example.
        }
        //int n = is.readInt();
        
        System.out.println("end");
    }
}
