/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisul.ad23automacaowebservice.dao;

import br.unisul.ad23automacaowebservice.model.Endereco;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Guilherme Noronha
 */
public class EnderecoDAO {
    
        private Connection con;

    public EnderecoDAO() {

    }

    public boolean inserir(Endereco endereco) {
        try {
            Statement smtm = con.createStatement();
            smtm.executeUpdate("insert into endereco values (" + endereco.getCep() + ", "
                    + "'" + endereco.getRua() + "', "
                    + "'" + endereco.getBairro() + "', "
                    + "'" + endereco.getCidade() + "',' "
                    + endereco.getEstado() + "')");
            smtm.close();
            return true;
        } catch (SQLException e) { // Falha na Conexão ou no SQL 
            System.out.println("Falha no Sql = " + e);
            return false;
        }
    }

    public Endereco consultarID(int key) {
        Endereco resultado = new Endereco();
        try {
            Statement smtm = con.createStatement();
            ResultSet rs = smtm.executeQuery("select * from endereco where cep = " + key);
            while (rs.next()) {
                int id = rs.getInt("cep");
                if (id == key) {
                    resultado.setCep(rs.getInt("cep"));
                    resultado.setRua(rs.getString("rua"));
                    resultado.setBairro(rs.getString("bairro"));
                    resultado.setCidade(rs.getString("cidade"));
                    resultado.setEstado(rs.getString("estado"));
                }
            }
            smtm.close();
        } catch (SQLException e) { // Falha na Conexão ou no SQL 
            System.out.println("Falha no Sql = " + e);
        }
        return resultado;
    }

    public ArrayList<Endereco> listarTodos() {
        ArrayList<Endereco> lista = new ArrayList<>();
        try {
            Statement smtm = con.createStatement();
            ResultSet rs = smtm.executeQuery("select * from endereco");
            while (rs.next()) {
                Endereco resultado = new Endereco(rs.getInt("cep"),
                        rs.getString("rua"),
                        rs.getString("bairro"),
                        rs.getString("cidade"),
                        rs.getString("estado"));
                lista.add(resultado);
            }
            smtm.close();
        } catch (SQLException e) { // Falha na Conexão ou no SQL 
            System.out.println("Falha no Sql = " + e);
        }
        return lista;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

}
