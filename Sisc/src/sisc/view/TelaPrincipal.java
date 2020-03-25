package sisc.view;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.DatagramPacket;
import java.net.MulticastSocket;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import sisc.controller.Arquivo;
import sisc.controller.ReceberBroadcast;
import sisc.controller.TCPServer;
import sisc.controller.Server;

public class TelaPrincipal extends javax.swing.JFrame{
    public Arquivo ob;
    public String[] ips;
    
    public TelaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTComputadores = new javax.swing.JTable();
        jTextFieldIP = new javax.swing.JTextField();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("File");
        jMenuBar3.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar3.add(jMenu6);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SISTEMA DE SINCRONIZAÇÃO ENTRE COMPUTADORES ORGANIZACIONAIS");
        setAlwaysOnTop(true);
        setResizable(false);

        jButton1.setText("EXIBIR ARQUIVOS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setText("PESQUISAR COMPUTADORES");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTComputadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IP", "NOME"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTComputadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTComputadoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTComputadores);

        jTextFieldIP.setEditable(false);
        jTextFieldIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 207, Short.MAX_VALUE)
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldIP, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jTextFieldIP, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new TelaExibirMeuArquivo().setVisible(true); 
    }//GEN-LAST:event_jButton1ActionPerformed

    
    private void limparTabela() {
        while (jTComputadores.getRowCount() > 0) {
            DefaultTableModel dm = (DefaultTableModel) jTComputadores.getModel();
            dm.getDataVector().removeAllElements();
        }
    }
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

       
        DefaultTableModel dtmComputadores = (DefaultTableModel) jTComputadores.getModel();
        limparTabela();
        try{
            byte[] b = "Ola".getBytes();
            //Definindo o endereço de envio do pacote neste caso o endereço de broadcast
            InetAddress addr = InetAddress.getByName("255.255.255.255");
            DatagramPacket pkg = new DatagramPacket(b, b.length, addr,6001);
            DatagramSocket ds = new DatagramSocket();
            ds.send(pkg);//enviando pacote broadcast
            
            ds.setSoTimeout(5000);
            while(true){
                byte rec[] = new byte[256];
                pkg = new DatagramPacket(rec, rec.length);
                ds.receive(pkg);//recebendo dados enviados via broadcast
                String data = new String(pkg.getData(), 0, pkg.getLength());
            
                String[] dados = new String[]{pkg.getSocketAddress().toString(),data};
                dtmComputadores.addRow(dados);
            }  
            // lógica que vai receber a resposta de todo mundo
	}catch (SocketTimeoutException e1) {
            System.out.println("Acabou tempo de espera de resposta broadcast");
	}catch (Exception e) {
            System.out.println("Nao foi possivel enviar a mensagem");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTComputadoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTComputadoresMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)jTComputadores.getModel();
        int selectedRowIndex = jTComputadores.getSelectedRow();
        String ip;
        
        jTextFieldIP.setText(model.getValueAt(selectedRowIndex, 0).toString());
        ip = jTextFieldIP.getText();
        ips = ip.split(Pattern.quote("/"));
        System.out.println(ips[0]);
        try {
            enviarConexao(ips);
        } catch (IOException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTComputadoresMouseClicked
    /*
    public void enviarConexao(String [] ips){
        try{
            Socket clientSocket = new Socket(ips[0],6001);
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Write: ");
            //
            outToServer.writeBytes("oi" + "\n");
            clientSocket.close();
        }catch (Exception e) {;
            System.out.println("Erro no cliente!");
            //System.out.println("Erro: " + e.getMessage());
        }
    }
    */
    public void enviarConexao(String [] ips) throws IOException{
        int Port = 6001;
        
        String IP = InetAddress.getLocalHost().getHostAddress();
        ServerSocket serverSock = new ServerSocket(Port);
        Socket Sock = serverSock .accept();
        DataOutputStream out =new DataOutputStream(Sock.getOutputStream());
        out.writeUTF("i am fine, thank you");
        DataInputStream in= new DataInputStream(Sock.getInputStream());
        System.out.println(in.readUTF());
        Sock.close();
    }
    
    private void jTextFieldIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIPActionPerformed


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new TelaPrincipal().setVisible(true);
               Arquivo.criarDiretorio();
            }
        });
        
        ReceberBroadcast r = new ReceberBroadcast();
        r.start();
        TCPServer t = new TCPServer();
        t.start();
        Server q = new Server();
        q.start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTComputadores;
    private javax.swing.JTextField jTextFieldIP;
    // End of variables declaration//GEN-END:variables

}
