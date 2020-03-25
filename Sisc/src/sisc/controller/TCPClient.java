package sisc.controller;

import java.io.*;
import java.net.*;

public class TCPClient extends Thread{
    @Override
    public void run(){
        try{
            Socket clientSocket = new Socket("localhost",6001);
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Write: ");
            String sentence = inFromUser.readLine();
            outToServer.writeBytes(sentence + "\n");
            clientSocket.close();
        }catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}