package br.unisul.ad23automacaowebservice.model;

/**
 *
 * @author Guilherme Noronha
 */
public class Roupa {
    
    private String tamanho;
    private int quantidade;
    
    public Roupa() {
        tamanho = "vazio";
        quantidade = 0;
    }
    
    public Roupa(String tamanho, int quantidade) {
        this.tamanho = tamanho;
        this.quantidade = quantidade;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
