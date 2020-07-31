/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisul.ad23automacaowebservice.dao;

import br.unisul.ad23automacaowebservice.model.Roupa;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Guilherme Noronha
 */
public class RoupaDAO {
    
        private Connection con;

    public RoupaDAO() {

    }

    public boolean inserir(Roupa roupa) {
        try {
            Statement smtm = con.createStatement();
            smtm.executeUpdate("insert into roupas values ( null, "
                    + "'" + roupa.getTamanho() + "', "
                    + roupa.getQuantidade() + ")");
            smtm.close();
            return true;
        } catch (SQLException e) { // Falha na Conexão ou no SQL 
            System.out.println("Falha no Sql = " + e);
            return false;
        }
    }

    public Roupa consultarID(int key) {
        Roupa resultado = new Roupa();
        try {
            Statement smtm = con.createStatement();
            ResultSet rs = smtm.executeQuery("select * from roupas where idRoupas = " + key);
            while (rs.next()) {
                int id = rs.getInt("idRoupas");
                if (id == key) {
                    resultado.setTamanho(rs.getString("tamanho"));
                    resultado.setQuantidade(rs.getInt("quantidade"));
                }
            }
            smtm.close();
        } catch (SQLException e) { // Falha na Conexão ou no SQL 
            System.out.println("Falha no Sql = " + e);
        }
        return resultado;
    }
    
        public int buscarIDidentico(Roupa key) {
        int resultado = 0;
        try {
            Statement smtm = con.createStatement();
            ResultSet rs = smtm.executeQuery("select * from roupas where tamanho = '" + key.getTamanho()+"'and quantidade = "+key.getQuantidade());
            while (rs.next()) {
                String idT = rs.getString("tamanho");
                int idQ = rs.getInt("quantidade");
                if (idT.equals(key.getTamanho()) && idQ == key.getQuantidade()) {
                    resultado = rs.getInt("idRoupas");
                }
            }
            smtm.close();
        } catch (SQLException e) { // Falha na Conexão ou no SQL 
            System.out.println("Falha no Sql = " + e);
        }
        return resultado;
    }
    
        public Roupa consultarTamanho(String key) {
        Roupa resultado = new Roupa();
        try {
            Statement smtm = con.createStatement();
            ResultSet rs = smtm.executeQuery("select * from roupas where tamanho = " + key);
            while (rs.next()) {
                String tamanho = rs.getString("tamanho");
                if (tamanho.equals(key)) {
                    resultado.setTamanho(rs.getString("tamanho"));
                    resultado.setQuantidade(rs.getInt("quantidade"));
                }
            }
            smtm.close();
        } catch (SQLException e) { // Falha na Conexão ou no SQL 
            System.out.println("Falha no Sql = " + e);
        }
        return resultado;
    }

    public ArrayList<Roupa> listarTodos() {
        ArrayList<Roupa> lista = new ArrayList<>();
        try {
            Statement smtm = con.createStatement();
            ResultSet rs = smtm.executeQuery("select * from roupas");
            while (rs.next()) {
                Roupa resultado = new Roupa(rs.getString("tamanho"),
                        rs.getInt("quantidade"));
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
