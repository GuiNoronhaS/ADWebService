package br.unisul.ad23automacaowebservice.model;

/**
 *
 * @author Guilherme Noronha
 */
public class Itens {
    
    private Comida comida;
    private Roupa roupa;
    private int dinheiro;
    private boolean doacao;
    
    public Itens() {
        comida = new Comida();
        roupa = new Roupa();
        dinheiro = 0;
        doacao = false;
    }
    
    public Itens(Comida comida, Roupa roupa, int dinheiro, boolean doacao ) {
        this.comida = comida;
        this.roupa = roupa;
        this.dinheiro = dinheiro;
        this.doacao = doacao;    
    }
    
        public Itens(int dinheiro, boolean doacao ) {
        comida = new Comida();
        roupa = new Roupa();
        this.dinheiro = dinheiro;
        this.doacao = doacao;    
    }

    public Comida getComida() {
        return comida;
    }

    public void setComida(Comida comida) {
        this.comida = comida;
    }

    public Roupa getRoupa() {
        return roupa;
    }

    public void setRoupa(Roupa roupa) {
        this.roupa = roupa;
    }

    public int getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(int dinheiro) {
        this.dinheiro = dinheiro;
    }

    public boolean isDoacao() {
        return doacao;
    }

    public void setDoacao(boolean doacao) {
        this.doacao = doacao;
    }
    
}
