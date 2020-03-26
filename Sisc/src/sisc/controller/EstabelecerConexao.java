package sisc.controller;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import javax.swing.JFileChooser;
import sisc.view.TelaPrincipal;
import sisc.view.TelaExibirMeuArquivo;

//Classe com uns problemas no Compartilhamento
public class EstabelecerConexao extends Thread {
    private static Server servidor;
    private static Client cliente;
    private static Socket socket;
        
    Thread thread = new Thread();
    public void conectaMaquina2() throws Exception {
        servidor.run();
        thread.start();
        socket.setSoTimeout(6000);
        thread.run();                        
        
        //servidor.close();
        servidor.join();    
        //servidor.compartilhandoArquivo();
    }
                
    public void conectaMaquina1() throws Exception{
        servidor.run();    
        thread.start();
        socket.setSoTimeout(6000);
        thread.run();                        

        //servidor.close();
        servidor.join();
        //servidor.compartilhandoArquivo();
    }
        
    public void recebeConexaoMaquina1() {
        cliente = new Client();
    }
        
    public void recebeConexaoMaquina2() {
        cliente = new Client();
    }
    
    /* public void compartilhandoArquivo() {
        
        private String nomeArq;
        private File f;
        private final String diretorioArq = "C:\\Users\\Vanessa\\Desktop";
        private final String extensaoArq = "";
        private DataOutputStream printParaCliente;
        
        public EstabelecerConexao(Socket sckt){
        socket = sckt;
        }
        
        Thread escutaT = new Thread(){
        @Override
        public void run(){
            try {
                BufferedReader lerDoCliente = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                nomeArq = lerDoCliente.readLine();  //aguardando cliente, metódo digitando, implementação do botão
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
        escutaT.start();
    }*/
}   
