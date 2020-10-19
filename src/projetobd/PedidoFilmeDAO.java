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
public class PedidoFilmeDAO {
    private static final String URL = "jdbc:postgresql://localhost:5432/projetobd";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "qwer1234";


    public List<Genero> listarPedidosFilme(int idFilme) {
        List<Genero> resultado = new ArrayList<Genero>();
        GeneroDAO generoDAO = new GeneroDAO();
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("SELECT id_pedido From pedido_filme WHERE id_filme =?");
            ps.setInt(1, idFilme);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Genero g = generoDAO.listar(rs.getInt("id_pedido"));
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
    
    public List<Filme> listarFilmesPedido(int idPedido) {
        List<Filme> resultado = new ArrayList<Filme>();
        FilmeDAO filmeDAO = new FilmeDAO();
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("SELECT id_filme From pedido_filme WHERE id_pedido =?");
            ps.setInt(1, idPedido);
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

    public boolean inserir(int idFilme, int idPedido) {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("INSERT INTO pedido_filme (id_filme, id_pedido) VALUES (?,?)");
            ps.setInt(1, idFilme);
            ps.setInt(2, idPedido);
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

    public boolean atualizar(int idFilme, int idPedido, int idNovoFilme) {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("UPDATE pedido_filme SET id_filme = ? WHERE id_filme = ? AND id_pedido = ?");

            ps.setInt(1, idNovoFilme);
            ps.setInt(2, idFilme);
            ps.setInt(3, idPedido);

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

    public boolean remover(int idFilme, int idPedido) {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("DELETE FROM pedido_filme WHERE id_filme = ? AND id_pedido = ?");

            ps.setInt(1, idFilme);
            ps.setInt(2, idPedido);

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
