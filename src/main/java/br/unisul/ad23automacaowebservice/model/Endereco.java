package br.unisul.ad23automacaowebservice.model;

/**
 *
 * @author Guilherme Noronha
 */
public class Endereco {
    
    private int cep;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    
    public Endereco() {
        cep = 0;
        rua = "vazio";
        bairro = "vazio";
        cidade = "vazio";
        estado = "vazio";
    }
    
    public Endereco(int cep, String rua, String bairro, String cidade, String estado) {
        this.cep = cep;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
