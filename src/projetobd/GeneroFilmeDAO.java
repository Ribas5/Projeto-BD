/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guilhc
 */
public class GeneroFilmeDAO {

    private static final String URL = "jdbc:postgresql://localhost:5432/projetobd";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "admin";



    public List<Genero> listarGenerosFilme(int idFilme) {
        List<Genero> resultado = new ArrayList<Genero>();
        GeneroDAO generoDAO = new GeneroDAO();
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("SELECT id_genero From genero_filme WHERE id_filme =?");
            ps.setInt(1, idFilme);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Genero g = generoDAO.listar(rs.getInt("id_genero"));
                resultado.add(g);
            }

            rs.close();
            ps.close();
            c.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GeneroFilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GeneroFilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultado;
    }
    
    public List<Filme> listarFilmesGenero(int idGenero) {
        List<Filme> resultado = new ArrayList<Filme>();
        FilmeDAO filmeDAO = new FilmeDAO();
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("SELECT id_filme From genero_filme WHERE id_genero =?");
            ps.setInt(1, idGenero);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Filme f = filmeDAO.listar(rs.getInt("id_filme"));
                resultado.add(f);
            }

            rs.close();
            ps.close();
            c.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GeneroFilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GeneroFilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    public boolean inserir(int idFilme, int idGenero) {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("INSERT INTO genero_filme (id_filme, id_genero) VALUES (?,?)");
            ps.setInt(1, idFilme);
            ps.setInt(2, idGenero);
            int r = ps.executeUpdate();
            sucesso = (r == 1);

            ps.close();
            c.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GeneroFilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GeneroFilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sucesso;

    }

    public boolean atualizar(int idFilme, int idGenero, int idNovoGenero) {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("UPDATE genero_filme SET id_genero = ? WHERE id_filme = ? AND id_genero = ?");

            ps.setInt(1, idNovoGenero);
            ps.setInt(2, idFilme);
            ps.setInt(3, idGenero);

            int r = ps.executeUpdate();
            sucesso = (r == 1);

            ps.close();
            c.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GeneroFilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GeneroFilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sucesso;
    }

    public boolean remover(int idFilme, int idGenero) {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("DELETE FROM genero_filme WHERE id_filme = ? AND id_genero = ?");

            ps.setInt(1, idFilme);
            ps.setInt(2, idGenero);

            int r = ps.executeUpdate();
            sucesso = (r == 1);

            ps.close();
            c.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GeneroFilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GeneroFilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sucesso;
    }
}
