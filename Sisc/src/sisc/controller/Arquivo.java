package sisc.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;
import sisc.utils.FileUtils;

public class Arquivo {
    private static Object e;
    private static Object fis;
    private long tamanho;
    private String nome;
    private String extensao;
    private String checksum;
    private String caminho;
    private Arquivo ob;
    
    public Arquivo(){ 
    }
    
    public Arquivo(String titulo, String descricao, String caminho) throws NoSuchAlgorithmException, UnknownHostException, FileNotFoundException{

        File file = new File(caminho);
        this.caminho = file.getPath();
        this.tamanho = file.length();
        this.nome = file.getName();
        this.extensao = FileUtils.getFileExtension(file.getName());
        this.checksum = FileUtils.getFileChecksum(file, "MD5");
    }
    
    public static void mover(File file){  
        if (!file.exists()) {
        System.out.println("Arquivo não encontrado");
        } else {
 
        File diretorioDestino = new File("C:\\Users\\Vanessa\\Desktop\\SISC");
        boolean sucesso = file.renameTo(new File(diretorioDestino, file.getName()));
            if (sucesso) {
                System.out.println("Arquivo movido para '" + diretorioDestino.getAbsolutePath() + "'");
            } else {
                System.out.println("Erro ao mover arquivo '" + file.getAbsolutePath() + "' para '"
                        + diretorioDestino.getAbsolutePath() + "'");
            }
        }
    }
         
    public static void criarDiretorio() {
        try {
            File diretorio = new File("C:\\Users\\Vanessa\\Desktop\\SISC");
            diretorio.mkdir();
        } catch (Exception ex) {
            
        }
    }
    
    public long getTamanho() {
        return tamanho;
    }

    public void setTamanho(long tamanho) {
        this.tamanho = tamanho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getExtensao() {
        return extensao;
    }

    public void setExtensao(String extensao) {
        this.extensao = extensao;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }
}
