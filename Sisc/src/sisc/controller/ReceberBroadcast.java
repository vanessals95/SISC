package sisc.controller;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ReceberBroadcast extends Thread{
    @Override
    public void run() {
        while (true) {
            try {
                //Classe java para trabalhar com multicast ou broadcast
                MulticastSocket mcs = new MulticastSocket(6001);//porta como parametro
                byte rec[] = new byte[256];
                DatagramPacket pkg = new DatagramPacket(rec, rec.length);
                mcs.receive(pkg);//recebendo dados enviados via broadcast
                String data = new String(pkg.getData(), 0, pkg.getLength());
                System.out.println("Dados recebidos: " + data);
                
                
            String pc = InetAddress.getLocalHost().getHostName();
            byte[] b = pc.getBytes();
            //Definindo o endereço de envio do pacote neste caso o endereço de broadcast
            InetAddress addr = InetAddress.getByName("255.255.255.255");
            pkg = new DatagramPacket(b, b.length,pkg.getSocketAddress());
            mcs.send(pkg);//enviando pacote broadcast     
                
            }catch (Exception e) {
		System.out.println("Erro: " + e.getMessage());
            }
	}
    }
}
