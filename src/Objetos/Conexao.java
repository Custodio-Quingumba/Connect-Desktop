package Objetos;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Custódio Quingumba
 */
public class Conexao {

    private static final String user = "admin";
    private static final String senha = "admin";
    private static final String url = "jdbc:mysql://localhost:3306/allcenter";

    //conex]ao com o banco de dados
    public static Connection conectar() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, senha);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.toString());
        }
        return con;
    }

    public static void FecharConexão(Connection con, PreparedStatement pstm, ResultSet rs) {
        try {
            con = null;
            pstm = null;
            rs = null;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar Conexão!");
        }
    }

    public static void FecharConexão(Connection con, PreparedStatement pstm) {
        try {
            con = null;
            pstm = null;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar Conexão!");
        }
    }

}