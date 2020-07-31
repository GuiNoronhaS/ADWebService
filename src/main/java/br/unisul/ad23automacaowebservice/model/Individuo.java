package br.unisul.ad23automacaowebservice.model;

/**
 *
 * @author Guilherme Noronha
 */
public class Individuo {

    private int rg;
    private int cpf;
    private String nome;
    private int idade;
    private int celular;
    private String email;
    private int cep;
    private int numeroDoEndereco;
    private String complemento;
    private Itens itens;

    public Individuo() {
        rg = 0;
        cpf = 0;
        nome = "vazio";
        idade = 0;
        celular = 0;
        email = "vazio";
        cep = 0;
        numeroDoEndereco = 0;
        complemento = "vazio";
        itens = new Itens();
    }

    public Individuo(int rg, int cpf, String nome, int idade, int celular, String email, int cep, int numeroDoEndereco, String complemento, Itens itens) {
        this.rg = rg;
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
        this.celular = celular;
        this.email = email;
        this.cep = cep;
        this.numeroDoEndereco = numeroDoEndereco;
        this.complemento = complemento;
        this.itens = itens;
    }

    public Individuo(int cpf, int rg, String nome, int celular, String email, int numeroDoEndereco, String complemento, int idade, int cep) {
        this.cpf = cpf;
        this.rg = rg;
        this.nome = nome;
        this.idade = idade;
        this.celular = celular;
        this.email = email;
        this.cep = cep;
        this.numeroDoEndereco = numeroDoEndereco;
        this.complemento = complemento;
        itens = new Itens();
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public int getNumeroDoEndereco() {
        return numeroDoEndereco;
    }

    public void setNumeroDoEndereco(int numeroDoEndereco) {
        this.numeroDoEndereco = numeroDoEndereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Itens getItens() {
        return itens;
    }

    public void setItens(Itens itens) {
        this.itens = itens;
    }
}
