import java.io.*;
import java.net.*;
import java.util.Scanner;

// Client class
public class Client
{
    public static void main(String[] args) throws IOException
    {
        try
        {
            Scanner scn = new Scanner(System.in);
            // getting localhost ip
            String hostName = "localhost";//args[0];
            int portNumber = 5056;//Integer.parseInt(args[1]);

            // establish the connection with server port 5056
            Socket s = new Socket(hostName, portNumber);

            // obtaining input and out streams
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            // the following loop performs the exchange of
            // information between client and client handler
            while (true)
            {
                System.out.println(dis.readUTF());
                String tosend = scn.nextLine();
                dos.writeUTF(tosend);
                String received = dis.readUTF();
                System.out.println(received);

                if(tosend.equals("Exit"))
                {
                    System.out.println("Closing this connection : " + s);
                    s.close();
                    System.out.println("Connection closed");
                    break;
                }
                // printing date or time as requested by client
            }
            // closing resources
            scn.close();
            dis.close();
            dos.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}