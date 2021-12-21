
package javaexample103closingstream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class JavaExample103ClosingStream {

    
    public static void main(String[] args) {
        
        
        FileReader fr = null;
        FileWriter fw = null;
        
        //======================================================================
        //==== Using Finally Block =============================================
        //======================================================================
        
        try{
            fr = new FileReader("fil1.txt");
            fw = new FileWriter("fil2.txt");
            
            // read a char
            /*
            Returns:
            The character read, as an integer in the range
            0 to 65535 (0x00-0xffff), or -1 if the end of 
            the stream has been reached
            */
            int ch = fr.read();
            
            while (ch != -1) {                
                fw.write(ch);
                ch = fr.read();
            }// end-while
        }// end-try
        catch(IOException e)
        {
            e.printStackTrace();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        finally
        {
            try{
            fr.close();
            fw.close();
            }
            catch(IOException e)
            {
                System.out.println(e.toString());
            }
        }// end-finally
        
        //======================================================================
        //==== Using Try-with-resources ========================================
        //======================================================================
        
        System.out.println("-------------------------------------------------");
        
        try (
                FileReader fr1 = new FileReader("fil3.txt");
                FileWriter fw1 = new FileWriter("fil4.txt", true);)
        {
            // read a char
            /*
            Returns:
            The character read, as an integer in the range
            0 to 65535 (0x00-0xffff), or -1 if the end of 
            the stream has been reached
            */
            int ch = fr1.read();
            
            while (ch != -1) {                
                fw1.write(ch);
                ch = fr1.read();
            }// end-while
        }// end-try
        catch(IOException e)
        {
            e.printStackTrace();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
    
}
