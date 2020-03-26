package sisc.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;
import sisc.view.TelaPrincipal;

public class Server extends Thread{
    public void run(){
        TelaPrincipal ob = new TelaPrincipal();
        int Port = 6001;
        try{
            String [] IP;
            IP = ob.ips;
            ServerSocket serverSock = new ServerSocket(6001); //iniciando servidor
            Socket Sock = serverSock .accept(); //estabelecendo conexão
            DataOutputStream out =new DataOutputStream(Sock.getOutputStream());
            out.writeUTF("Conectado!");
            DataInputStream in= new DataInputStream(Sock.getInputStream());
            System.out.println(in.readUTF());
            Sock.close();   
        }catch(Exception e){
            
        }
    }
}