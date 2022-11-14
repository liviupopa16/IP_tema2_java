import java.io.*;
import java.text.*;
import java.util.*;
import java.net.*;

public class Server {
    public static void main(String args[]) throws IOException {
        int port = 5056;//Integer.parseInt(args[0]);
        ServerSocket server = new ServerSocket(port);

        while(true) {
            Socket client = null;
            try {
                client = server.accept();

                System.out.println("A new client is connected : " + client);
                DataInputStream dis = new DataInputStream(client.getInputStream());
                DataOutputStream dos = new DataOutputStream(client.getOutputStream());
                System.out.println("Assigning new thread for this client");

                Thread new_thread = new ClientHandler(client, dis, dos);
                new_thread.start();
            }
            catch (IOException e) {
                server.close();
                e.printStackTrace();
            }
        }
    }
}

class ClientHandler extends Thread
{
    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;


    // Constructor
    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos)
    {
        this.s = s;
        this.dis = dis;
        this.dos = dos;
    }

    @Override
    public void run()
    {
        ArrayList<Human> Humans = new ArrayList<Human>();
        String received;
        String toreturn;

        while (true)
        {
            try {

                // Ask user what he wants
                dos.writeUTF("Insert new student or professor...or just Exit");
                // receive the answer from client
                received = dis.readUTF();
                //System.out.println(received.toString());
                String split[] = received.split(" ");
                if (split[0].equals("Student")){
                    Humans.add(new Student(split[1], split[2], split[3], Integer.parseInt(split[4]), Integer.parseInt(split[5])));
                    toreturn="A wild student appeared! " + "(" + split[1] + " " + split[2] + ")" + "\n";
                    dos.writeUTF(toreturn);
                }
                else if (split[0].equals("Profesor")){
                    Humans.add(new Profesor(split[1], split[2], split[3], split[4], Integer.parseInt(split[5])));
                    toreturn="A wild professor appeared! " + "(" + split[1] + " " + split[2] + ")" + "\n";
                    dos.writeUTF(toreturn);
                }

                if(received.equals("Exit"))
                {
                    System.out.println("Client " + this.s + " sends exit...");
                    System.out.println("Closing this connection.");
                    this.s.close();
                    System.out.println("Connection closed");
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("<============================= Sorted =============================>");
            Collections.sort(Humans);
            for (Human index : Humans){
                System.out.println(index.toString());
            }
        }
        try
        {
            // closing resources
            this.dis.close();
            this.dos.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}