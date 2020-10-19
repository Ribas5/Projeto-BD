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

public class EstudioDAO {

    private static final String URL = "jdbc:postgresql://localhost:5432/projetobd";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "qwer1234";

    public List<Estudio> listarTodos() {
        List<Estudio> resultado = new ArrayList<Estudio>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("SELECT id, nome From estudio");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Estudio e = new Estudio();
                e.setId(rs.getInt("id"));
                e.setNome(rs.getString("nome"));
                resultado.add(e);

            }

            rs.close();
            ps.close();
            c.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EstudioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EstudioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;

    }

    public Estudio listar(int id) {
        Estudio e = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("SELECT id, nome From estudio WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                e = new Estudio();
                e.setId(rs.getInt("id"));
                e.setNome(rs.getString("nome"));
            }

            rs.close();
            ps.close();
            c.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EstudioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EstudioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;

    }

    public boolean inserir(String nome) {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("INSERT INTO Estudio (nome) VALUES (?)");
            ps.setString(1, nome);
            int r = ps.executeUpdate();
            sucesso = (r == 1);

            ps.close();
            c.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EstudioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EstudioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sucesso;

    }

    public boolean atualizar(int id , String nome) {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("UPDATE Estudio SET nome =? WHERE id = ?");

            ps.setString(1, nome);
            ps.setInt(2, id);

            int r = ps.executeUpdate();
            sucesso = (r == 1);

            ps.close();
            c.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EstudioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EstudioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sucesso;
    }

    public boolean remover(int id) {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("DELETE FROM Estudio WHERE id = ?");

            ps.setInt(1, id);

            int r = ps.executeUpdate();
            sucesso = (r == 1);

            ps.close();
            c.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EstudioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EstudioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sucesso;
    }
}
