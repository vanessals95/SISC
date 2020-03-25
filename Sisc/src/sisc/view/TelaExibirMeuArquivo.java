package sisc.view;

import java.awt.Desktop;
import java.io.File;
import javax.swing.JOptionPane;
import sisc.persistence.FileSystemModel;

public class TelaExibirMeuArquivo extends javax.swing.JFrame{
    
    public TelaExibirMeuArquivo() {
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
        abrir_arquivo_btn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jMenuBar1 = new javax.swing.JMenuBar();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("File");
        jMenuBar3.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar3.add(jMenu6);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SISTEMA DE SINCRONIZAÇÃO ENTRE COMPUTADORES ORGANIZACIONAIS");
        setAlwaysOnTop(true);
        setResizable(false);

        abrir_arquivo_btn.setText("Abrir arquivo");
        abrir_arquivo_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                abrir_arquivo_btnMouseClicked(evt);
            }
        });

        jTree1.setModel(new FileSystemModel(new File("C:\\Users\\")));
            jTree1.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jTree1MouseClicked(evt);
                }
            });
            jScrollPane2.setViewportView(jTree1);

            setJMenuBar(jMenuBar1);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(abrir_arquivo_btn)
                    .addContainerGap())
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(abrir_arquivo_btn)
                            .addGap(0, 473, Short.MAX_VALUE))
                        .addComponent(jScrollPane2))
                    .addContainerGap())
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void abrir_arquivo_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abrir_arquivo_btnMouseClicked
        try{
            File Selection = new File(Jtreevar);
            if (Selection.exists()){
                if (Desktop.isDesktopSupported()){
                    Desktop.getDesktop().open(Selection);
                }else{
                    JOptionPane.showMessageDialog(this,"Awt desktop não é suportado!","Error",JOptionPane.INFORMATION_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(this,"Awt desktop não existe!","Error",JOptionPane.INFORMATION_MESSAGE);
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_abrir_arquivo_btnMouseClicked

    private void jTree1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTree1MouseClicked
       Jtreevar = jTree1.getSelectionPath().toString().replaceAll("[\\[\\]]", "").replace(", ", "\\");
    }//GEN-LAST:event_jTree1MouseClicked


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaExibirMeuArquivo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abrir_arquivo_btn;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables
    String Jtreevar;
}
