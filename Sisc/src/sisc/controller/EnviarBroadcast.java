
package sisc.controller;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class EnviarBroadcast{
    public static void main(String[] args) {
        try{
            String ip = InetAddress.getLocalHost().getHostAddress();
            byte[] b = ip.getBytes();
            //Definindo o endereço de envio do pacote neste caso o endereço de broadcast
            InetAddress addr = InetAddress.getByName("255.255.255.255");
            DatagramPacket pkg = new DatagramPacket(b, b.length, addr,6001);
            DatagramSocket ds = new DatagramSocket();
            ds.send(pkg);//enviando pacote broadcast
            
            // lógica que vai receber a resposta de todo mundo
	}catch (Exception e) {
            System.out.println("Nao foi possivel enviar a mensagem");
	}
    }
}