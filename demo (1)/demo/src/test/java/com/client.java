import java.io.*;
import java.net.Socket;
 
public class client {
    public static void main (String[] args){
        Socket socket = new Socket("localhost" , 3001);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

        oos.writeObject((new Person("sdad" , "asvd" , 45)));
        Thread.sleep(100000);
    }
}
