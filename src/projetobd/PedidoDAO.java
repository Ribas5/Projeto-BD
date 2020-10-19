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

public class PedidoDAO {

    private static final String URL = "jdbc:postgresql://localhost:5432/projetobd";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "qwer1234";

    public List<Pedido> listarTodos() {
        List<Pedido> resultado = new ArrayList<Pedido>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("SELECT id, to_char(data, 'DD/MM/YYYY') as data, to_char(expiracao, 'DD/MM/YYYY') as expiracao, id_usuario from pedido");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pedido p = new Pedido();
                p.setId(rs.getInt("id"));
                p.setData(rs.getString("data"));
                p.setExpiracao(rs.getString("expiracao"));
                p.setIDU(rs.getInt("id_usuario"));
                resultado.add(p);

            }

            rs.close();
            ps.close();
            c.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;

    }

    public Pedido listar(int id) {
        Pedido p = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("SELECT id, to_char(data, 'DD/MM/YYYY') as data, to_char(expiracao, 'DD/MM/YYYY') as expiracao, id_usuario from pedido WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p = new Pedido();
                p.setId(rs.getInt("id"));
                p.setData(rs.getString("data"));
                p.setExpiracao(rs.getString("expiracao"));
                p.setIDU(rs.getInt("id_usuario"));

            }

            rs.close();
            ps.close();
            c.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    
    public List<Pedido> listarUsuario (int id_usuario) {
        List<Pedido> resultado = new ArrayList<Pedido>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("SELECT id, to_char(data, 'DD/MM/YYYY') as data, to_char(expiracao, 'DD/MM/YYYY') as expiracao, id_usuario from pedido WHERE id_usuario = ?");
            ps.setInt(1, id_usuario);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pedido p = new Pedido();
                p.setId(rs.getInt("id"));
                p.setData(rs.getString("data"));
                p.setExpiracao(rs.getString("expiracao"));
                p.setIDU(rs.getInt("id_usuario"));
                resultado.add(p);
            }

            rs.close();
            ps.close();
            c.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    public boolean inserir(String data, String expiracao, int id_usuario) {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("INSERT INTO pedido(data, expiracao, id_usuario) VALUES (to_date(?,'DD/MM/YYYY'), to_date(?,'DD-MM-YYYY'), ?)");
            ps.setString(1, data);
            ps.setString(2, expiracao);
            ps.setInt(3, id_usuario);
            int r = ps.executeUpdate();
            sucesso = (r == 1);

            ps.close();
            c.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sucesso;

    }

    public boolean atualizar(int id, String data, String expiracao, int id_usuario) {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("UPDATE pedido SET data = to_date(?, 'DD/MM/YYYY'), expiracao = to_date(?, 'DD/MM/YYYY'), id_usuario = ? WHERE id = ?;");

            ps.setString(1, data);
            ps.setString(2, expiracao);
            ps.setInt(3, id_usuario);
            ps.setInt(4, id);

            int r = ps.executeUpdate();
            sucesso = (r == 1);

            ps.close();
            c.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sucesso;
    }

    public boolean remover(int id) {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("DELETE FROM Pedido WHERE id = ?");

            ps.setInt(1, id);

            int r = ps.executeUpdate();
            sucesso = (r == 1);

            ps.close();
            c.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sucesso;
    }
}
