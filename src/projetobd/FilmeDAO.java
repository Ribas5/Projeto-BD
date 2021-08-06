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

public class FilmeDAO {


    private static final String URL = "jdbc:postgresql://localhost:5432/projetobd";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "admin";


    public List<Filme> listarTodos() {
        List<Filme> resultado = new ArrayList<Filme>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("SELECT id, nome, duracao, preco, faixa_etaria, id_estudio From filme");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Filme f = new Filme();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setDuracao(rs.getInt("duracao"));
                f.setPreco(rs.getFloat("preco"));
                f.setFaixaetaria(rs.getString("faixa_etaria"));
                f.setIdestudio(rs.getInt("id_estudio"));
                resultado.add(f);

            }

            rs.close();
            ps.close();
            c.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;

    }

    public Filme listar(int id) {
        Filme f = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("SELECT id, nome, duracao, preco, faixa_etaria, id_estudio From Filme WHERE id =?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                f = new Filme();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setDuracao(rs.getInt("duracao"));
                f.setPreco(rs.getFloat("preco"));
                f.setFaixaetaria(rs.getString("faixa_etaria"));
                f.setIdestudio(rs.getInt("id_estudio"));

            }

            rs.close();
            ps.close();
            c.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f;

    }

    public boolean inserir(String nome, int duracao, float preco, String faixa_etaria, int id_estudio) {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("INSERT INTO Filme (nome,duracao,preco,faixa_etaria,id_estudio) VALUES (?,?,?,?,?)");
            ps.setString(1, nome);
            ps.setInt(2, duracao);
            ps.setFloat(3, preco);
            ps.setString(4, faixa_etaria);
            ps.setInt(5, id_estudio);
            int r = ps.executeUpdate();
            sucesso = (r == 1);

            ps.close();
            c.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sucesso;

    }

    public boolean atualizar(int id, String nome, int duracao, float preco, String faixa_etaria, int id_estudio) {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("UPDATE filme SET nome = ?, duracao = ?, preco = ?, faixa_etaria = ?, id_estudio = ? WHERE id = ?");

            ps.setString(1, nome);
            ps.setInt(2, duracao);
            ps.setFloat(3, preco);
            ps.setString(4, faixa_etaria);
            ps.setInt(5, id_estudio);
            ps.setInt(6, id);

            int r = ps.executeUpdate();
            sucesso = (r == 1);

            ps.close();
            c.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sucesso;
    }

    public boolean remover(int id) {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("DELETE FROM Filme WHERE id = ?");

            ps.setInt(1, id);

            int r = ps.executeUpdate();
            sucesso = (r == 1);

            ps.close();
            c.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sucesso;
    }
}
