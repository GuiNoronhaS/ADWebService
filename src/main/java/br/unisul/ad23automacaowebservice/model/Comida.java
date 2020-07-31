package br.unisul.ad23automacaowebservice.model;

/**
 *
 * @author Guilherme Noronha
 */
public class Comida {

    private String tipo;
    private int quantidade;
    private int validadeMes;
    private int validadeAno;
    
    public Comida() {
        tipo = "vazio";
        quantidade = 0;
        validadeMes = 00;
        validadeAno = 0000;
    }
    
        public Comida(String tipo, int quantidade, int mes, int ano) {
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.validadeMes = mes;
        this.validadeAno = ano;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getValidadeMes() {
        return validadeMes;
    }

    public void setValidadeMes(int validadeMes) {
        this.validadeMes = validadeMes;
    }

    public int getValidadeAno() {
        return validadeAno;
    }

    public void setValidadeAno(int validadeAno) {
        this.validadeAno = validadeAno;
    }

}
