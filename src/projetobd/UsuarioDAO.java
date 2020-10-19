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

public class UsuarioDAO {

    private static final String URL = "jdbc:postgresql://localhost:5432/projetobd";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "qwer1234";

    public List<Usuario> listarTodos() {
        List<Usuario> resultado = new ArrayList<Usuario>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("SELECT id, nome, idade, senha, email, saldo From Usuario");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setIdade(rs.getInt("idade"));
                u.setSenha(rs.getString("senha"));
                u.setEmail(rs.getString("email"));
                u.setSaldo(rs.getFloat("saldo"));
                resultado.add(u);

            }

            rs.close();
            ps.close();
            c.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;

    }

    public Usuario listar(int id) {
        Usuario u = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("SELECT id, nome, idade, senha, email, saldo From Usuario WHERE id =?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setIdade(rs.getInt("idade"));
                u.setSenha(rs.getString("senha"));
                u.setEmail(rs.getString("email"));
                u.setSaldo(rs.getFloat("saldo"));

            }

            rs.close();
            ps.close();
            c.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;

    }

    public boolean inserir(String nome, int idade, String senha, String email, float saldo) {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("INSERT INTO Usuario (nome,idade,senha,email,saldo) VALUES (?,?,?,?,?)");
            ps.setString(1, nome);
            ps.setInt(2, idade);
            ps.setString(3, senha);
            ps.setString(4, email);
            ps.setFloat(5, saldo);
            int r = ps.executeUpdate();
            sucesso = (r == 1);

            ps.close();
            c.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sucesso;

    }

    public boolean atualizar(int id, String nome, int idade, String senha, String email, float saldo) {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("UPDATE Usuario SET nome =?,idade=?,senha=?,email=?,saldo=? WHERE id = ?");

            ps.setString(1, nome);
            ps.setInt(2, idade);
            ps.setString(3, senha);
            ps.setString(4, email);
            ps.setFloat(5, saldo);
            ps.setInt(6, id);

            int r = ps.executeUpdate();
            sucesso = (r == 1);

            ps.close();
            c.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sucesso;
    }

    public boolean remover(int id) {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("DELETE FROM Usuario WHERE id = ?");

            ps.setInt(1, id);

            int r = ps.executeUpdate();
            sucesso = (r == 1);

            ps.close();
            c.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sucesso;
    }
    
    public boolean alterarSaldo(int id, float novoSaldo) {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("UPDATE Usuario SET saldo=? WHERE id = ?");

            ps.setFloat(1, novoSaldo);
            ps.setInt(2, id);

            int r = ps.executeUpdate();
            sucesso = (r == 1);

            ps.close();
            c.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sucesso;
    }
}
