/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisul.ad23automacaowebservice.dao;

import br.unisul.ad23automacaowebservice.model.Comida;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Guilherme Noronha
 */
public class ComidaDAO {

    private Connection con;

    public ComidaDAO() {

    }

    public boolean inserir(Comida comida) {
        try {
            Statement smtm = con.createStatement();
            smtm.executeUpdate("insert into comidas values ( '" + comida.getTipo() + "', "
                    + comida.getQuantidade() + ", "
                    + comida.getValidadeMes() + ", "
                    + comida.getValidadeAno() + ")");
            smtm.close();
            return true;
        } catch (SQLException e) { // Falha na Conexão ou no SQL 
            System.out.println("Falha no Sql = " + e);
            return false;
        }
    }

    public Comida consultarID(int key) {
        Comida resultado = new Comida();
        try {
            Statement smtm = con.createStatement();
            ResultSet rs = smtm.executeQuery("select * from comidas where idComidas = " + key);
            while (rs.next()) {
                int id = rs.getInt("idComidas");
                if (id == key) {
                    resultado.setTipo(rs.getString("tipo"));
                    resultado.setQuantidade(rs.getInt("quantidade"));
                    resultado.setQuantidade(rs.getInt("validadeMes"));
                    resultado.setQuantidade(rs.getInt("validadeAno"));
                }
            }
            smtm.close();
        } catch (SQLException e) { // Falha na Conexão ou no SQL 
            System.out.println("Falha no Sql = " + e);
        }
        return resultado;
    }

    public int buscarIDidentico(Comida key) {
        int resultado = 0;
        try {
            Statement smtm = con.createStatement();
            ResultSet rs = smtm.executeQuery("select * from comida where tipo = '" + key.getTipo() + "' and quantidade = " + key.getQuantidade() + "' and validadeMes = " + key.getValidadeMes() + "' and validadeAno = " + key.getValidadeAno());
            while (rs.next()) {
                String idT = rs.getString("tipo");
                int idQ = rs.getInt("quantidade");
                int idM = rs.getInt("validadeMes");
                int idA = rs.getInt("validadeAno");
                if (idT.equals(key.getTipo()) && idQ == key.getQuantidade() && idM == key.getValidadeMes() && idA == key.getValidadeAno()) {
                    resultado = rs.getInt("idComidas");
                }
            }
            smtm.close();
        } catch (SQLException e) { // Falha na Conexão ou no SQL 
            System.out.println("Falha no Sql = " + e);
        }
        return resultado;
    }

    public Comida consultarTipo(String key) {
        Comida resultado = new Comida();
        try {
            Statement smtm = con.createStatement();
            ResultSet rs = smtm.executeQuery("select * from comidas where tipo = " + key);
            while (rs.next()) {
                String tipo = rs.getString("tipo");
                if (tipo.equals(key)) {
                    resultado.setTipo(rs.getString("tipo"));
                    resultado.setQuantidade(rs.getInt("quantidade"));
                    resultado.setQuantidade(rs.getInt("validadeMes"));
                    resultado.setQuantidade(rs.getInt("validadeAno"));
                }
            }
            smtm.close();
        } catch (SQLException e) { // Falha na Conexão ou no SQL 
            System.out.println("Falha no Sql = " + e);
        }
        return resultado;
    }

    public ArrayList<Comida> listarTodos() {
        ArrayList<Comida> lista = new ArrayList<>();
        try {
            Statement smtm = con.createStatement();
            ResultSet rs = smtm.executeQuery("select * from comidas");
            while (rs.next()) {
                Comida resultado = new Comida(rs.getString("tipo"),
                        rs.getInt("quantidade"),
                        rs.getInt("validadeMes"),
                        rs.getInt("validadeAno"));
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
