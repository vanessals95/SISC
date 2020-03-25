package sisc.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.JOptionPane;

public class Client {
    public static void main(String[] args)throws IOException {
        int Port = 6001;

        String IP = InetAddress.getLocalHost().getHostAddress();
        Socket sock = new Socket(IP, Port);
        DataInputStream in= new DataInputStream(sock.getInputStream());
        System.out.println(in.readUTF());
        DataOutputStream out =new DataOutputStream(sock.getOutputStream());
        out.writeUTF("waiting for connection");
        sock.close();
    }
}