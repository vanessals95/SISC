package sisc.controller;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.ServerSocket;
import javax.swing.JFileChooser;
import sisc.view.TelaPrincipal;
import sisc.view.TelaExibirMeuArquivo;

public class EstabelecerConexao extends Thread{
    private static Server servidor;
    static ServerSocket ss;
    Socket socket;
	
    public static void main(String args[]) throws Exception {
        
        Thread thread = new Thread();
        public void conectaMaquina2(){
            ServerSocket ss = new ServerSocket(6001);//inicia servidor
                while(true){
                    Socket socket = ss.accept();//estabelece conexão
                    System.out.println("Conexão aceita - " + socket);
                    thread.start();
                    socket.setSoTimeout(6000);
                    thread.run();                        
                }
            servidor.close();
            servidor.join();    
            servidor.compartilhandoArquivo();
        }
                
        public void conectaMaquina1(){
            ServerSocket ss = new ServerSocket(6001);//inicia servidor
                while(true){
                    Socket socket = ss.accept();//estabelece conexão
                    System.out.println("Conexão aceita - " + socket);
                    thread.start();
                    socket.setSoTimeout(6000);
                    thread.run();                        
                }
            servidor.close();
            servidor.join();
            servidor.compartilhandoArquivo();
            }
                
            /* public void recebeMaquina2(){
                Socket s = new Socket("localhost", 6001);
            } */
                
            /* public void recebeMaquina1(){
                Socket s = new Socket("localhost", 6001);
            } */

    }

    void compartilhandoArquivo(){
            Thread listen = new Thread(){
            @Override
            public void run(){
                try {
                    BufferedReader lerDoCliente = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                    nomeArq = lerDoCliente.readLine();  //aguardando cliente
                    f = new File(diretorioArq + nomeArq + extensaoArq);

                    printParaCliente = new DataOutputStream(socket.getOutputStream());
                    if(!f.exists()){
                        printParaCliente.writeBytes("Arquivo não existe! Solicite novamente. \n");
                        socket.close();
                    }
                    else{
                        byte[] mybytearray = new byte[(int) f.length()];
                        FileInputStream fis = new FileInputStream(f);
                        BufferedInputStream bis = new BufferedInputStream(fis);

                        bis.read(mybytearray, 0, mybytearray.length);
                        fis.close();
                        bis.close();

                        OutputStream os = socket.getOutputStream();
                        os.write(mybytearray);
                        System.out.println("Enviado para o cliente!");
                        socket.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        listen.start();
    }
}
