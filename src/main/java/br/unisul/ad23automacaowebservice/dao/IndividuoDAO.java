/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisul.ad23automacaowebservice.dao;

import br.unisul.ad23automacaowebservice.model.Individuo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Guilherme Noronha
 */
public class IndividuoDAO {

    private Connection con;

    public IndividuoDAO() {

    }

    public boolean inserir(Individuo individuo) {
        try {
            ItensDAO dao = new ItensDAO();
            dao.setCon(con);
            int idItens = dao.buscarIDidentico(individuo.getItens());
            if (idItens == 0) {
                dao.inserir(individuo.getItens());
                idItens = dao.buscarIDidentico(individuo.getItens());
            }

            Statement smtm = con.createStatement();
            smtm.executeUpdate("insert into individuo values (" + individuo.getCpf() + ", "
                    + individuo.getRg() + ", "
                    + "'" + individuo.getNome() + "', "
                    + individuo.getCelular() + ", "
                    + "'" + individuo.getEmail() + "', "
                    + individuo.getNumeroDoEndereco() + ", "
                    + "'" + individuo.getComplemento() + "', "
                    + individuo.getIdade() + ", "
                    + individuo.getCep() + ", "
                    + idItens + ")");
            smtm.close();
            return true;
        } catch (SQLException e) { // Falha na Conexão ou no SQL 
            System.out.println("Falha no Sql = " + e);
            return false;
        }
    }

    public Individuo consultarID(int key) {
        Individuo resultado = new Individuo();
        try {
            Statement smtm = con.createStatement();
            int idItem = -1;
            int id = 0;
            ResultSet rs = smtm.executeQuery("select * from individuo where cpf = " + key);
            while (rs.next()) {
                id = rs.getInt("cpf");
                if (id == key) {
                    resultado.setCpf(rs.getInt("cpf"));
                    resultado.setRg(rs.getInt("rg"));
                    resultado.setNome(rs.getString("nome"));
                    resultado.setCelular(rs.getInt("celular"));
                    resultado.setEmail(rs.getString("email"));
                    resultado.setNumeroDoEndereco(rs.getInt("numero"));
                    resultado.setComplemento(rs.getString("complemento"));
                    resultado.setIdade(rs.getInt("idade"));
                    resultado.setCep(rs.getInt("cep"));
                    idItem = rs.getInt("itenID");
                }
            }
            smtm.close();
            if (id == key) {
                ItensDAO dao = new ItensDAO();
                dao.setCon(con);
                resultado.setItens(dao.consultarID(idItem));
            }
        } catch (SQLException e) { // Falha na Conexão ou no SQL 
            System.out.println("Falha no Sql = " + e);
        }
        return resultado;
    }

    public ArrayList<Individuo> listarTodos() {
        ArrayList<Individuo> lista = new ArrayList<>();
        try {
            Statement smtm = con.createStatement();
            ResultSet rs = smtm.executeQuery("select * from individuo");
            while (rs.next()) {
                Individuo resultado = new Individuo(rs.getInt("cpf"),
                        rs.getInt("rg"),
                        rs.getString("nome"),
                        rs.getInt("celular"),
                        rs.getString("email"),
                        rs.getInt("numero"),
                        rs.getString("complemento"),
                        rs.getInt("idade"),
                        rs.getInt("cep"));
                lista.add(resultado);
            }
            smtm.close();
        } catch (SQLException e) { // Falha na Conexão ou no SQL 
            System.out.println("Falha no Sql = " + e);
        }
        return lista;
    }

    public ArrayList<Individuo> listarDoadores() {
        ArrayList<Individuo> lista = new ArrayList<>();
        try {
            Statement smtm = con.createStatement();
            ResultSet rs = smtm.executeQuery("select individuo.* , itens.para_Doar from individuo inner join itens on itens.id_itens = individuo.itenID");
            while (rs.next()) {
                if (rs.getInt("para_Doar") == 1) {
                    Individuo resultado = new Individuo(rs.getInt("cpf"),
                            rs.getInt("rg"),
                            rs.getString("nome"),
                            rs.getInt("celular"),
                            rs.getString("email"),
                            rs.getInt("numero"),
                            rs.getString("complemento"),
                            rs.getInt("idade"),
                            rs.getInt("cep"));
                    lista.add(resultado);
                }
            }
            smtm.close();
        } catch (SQLException e) { // Falha na Conexão ou no SQL 
            System.out.println("Falha no Sql = " + e);
        }
        return lista;
    }

    public ArrayList<Individuo> listarVulneraveis() {
        ArrayList<Individuo> lista = new ArrayList<>();
        try {
            Statement smtm = con.createStatement();
            ResultSet rs = smtm.executeQuery("select individuo.* , itens.para_Doar from individuo inner join itens on itens.id_itens = individuo.itenID");
            while (rs.next()) {
                if (rs.getInt("para_Doar") == 0) {
                    Individuo resultado = new Individuo(rs.getInt("cpf"),
                            rs.getInt("rg"),
                            rs.getString("nome"),
                            rs.getInt("celular"),
                            rs.getString("email"),
                            rs.getInt("numero"),
                            rs.getString("complemento"),
                            rs.getInt("idade"),
                            rs.getInt("cep"));
                    lista.add(resultado);
                }
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
