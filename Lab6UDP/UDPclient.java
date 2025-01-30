package Lab6UDP;
import java.io.*;
import java.net.*;
public class UDPclient {
    public static void main(String[] args) throws Exception{
        BufferedReader inpFromUser = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];

        System.out.println("Enter the string in lowercase so that you receive the message in upper case: ");
        String sentence = inpFromUser.readLine();
        sendData = sentence.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
        clientSocket.send(sendPacket);

        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);

        String modifiedString = new String(receivePacket.getData());
        System.out.println("FROM SERVER: " + modifiedString);

        clientSocket.close();

    }

}
