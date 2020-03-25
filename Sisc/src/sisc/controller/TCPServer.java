package sisc.controller;

import java.io.*;
import java.net.*;

public class TCPServer extends Thread{
    @Override
    public void run(){
        try{
            ServerSocket outFirstSocket = new ServerSocket(6001);
            while(true){
                Socket connectionSocket = outFirstSocket.accept();
                BufferedReader messagesFromClient =
                    new BufferedReader (new InputStreamReader(connectionSocket.getInputStream()));
                String clientSentence = messagesFromClient.readLine();
                System.out.println(" Recebido: " + clientSentence);
            }
        }catch (Exception e) {
            System.out.println("Erro no servidor!");
        }
    }
}