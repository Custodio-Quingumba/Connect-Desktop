/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Custódio Quingumba
 */
public class Dados {

    /*     CRIAR SENHA PARA CONTROLE DE ALTERÇÃO DO SISTEMA  */
    public boolean CriarSenhaRaiz(String Senha) {
        String sql = "INSERT INTO senharaiz(senha) VALUE(?)";
        PreparedStatement pstm = null;
        Connection con = null;

        try {

            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, Senha);
            pstm.execute();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar senha Raiz! \nErro: " + e);
            return false;
        } finally {
            JOptionPane.showMessageDialog(null, "Feito ADMINISTRADOR! Sua senha será sempre solocitada \nquando uma alteração perigosa for feita no sistema: ");
            Conexao.FecharConexão(con, pstm);
        }

    }

    public List<TemaOBJ> temas() {
        String sql = "SELECT * FROM tema";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = null;
        List<TemaOBJ> tema = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                tema.add(
                        new TemaOBJ(rs.getInt("id"),
                                rs.getString("nome"),
                                rs.getString("padrao"),
                                rs.getString("texto"),
                                rs.getString("botao")
                        )
                );
            }
            return tema;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Temas! Erro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public TemaOBJ getTema(int idTema) {
        String sql = "SELECT * FROM tema where id = ?";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = null;
        TemaOBJ tema = new TemaOBJ();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, idTema);
            rs = pstm.executeQuery();
            while (rs.next()) {
                tema
                        = new TemaOBJ(rs.getInt("id"),
                                rs.getString("nome"),
                                rs.getString("padrao"),
                                rs.getString("texto"),
                                rs.getString("botao")
                        );
            }
            return tema;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Temas! Erro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    /*     VREIFICAR SE A SENHA RAIZ INTRODUZIDA ESTÁ CERTA  */
    public boolean confirmar(String Senha) {

        String sql = "SELECT * FROM senharaiz where senha = '" + Senha + "'";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = null;
        boolean cf = false;
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "Senha Errada");
            } else {
                cf = true;
            }
            return cf;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Confirmar senha Raiz! Erro: " + e);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    /*     VERIFICAR SE HÁ A EXISTÊNCIA DE UMA CHAVE RAIZ NO SISTEMA      */
    public boolean varrer() {
        String sql = "SELECT * FROM senharaiz";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = null;

        try {

            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "Necessário uma Senha Raiz no sistema");
                return false;
            } else {
                return true;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Senha Raiz! Erro: " + e);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    /*     MÉTODO DE OBTENÇÃO DE TODOS CLIENTES DO SISTEMA   */
    public List<ClientesOBJ> Todos() {
        String sql = "select * from clientes order by clientes.nome asc";
        PreparedStatement pstm = null;
        Connection con = null;
        ResultSet rs = null;
        List<ClientesOBJ> clientes;
        clientes = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                ClientesOBJ novo = new ClientesOBJ(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("nacionalidade"),
                        rs.getString("BI"),
                        rs.getString("telefone"),
                        rs.getString("whatsapp"),
                        rs.getString("endereco"),
                        rs.getString("email"),
                        rs.getString("informacao"),
                        rs.getString("servico"),
                        rs.getInt("pacote"),
                        rs.getString("GPON"),
                        rs.getString("vlan"),
                        rs.getInt("dia")
                );
                clientes.add(novo);
            }
            return clientes;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Todos Clientes! Erro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);

        }
    }

    /*     MÉTODO DE OBTENÇÃO DE TODOS CLIENTES ACTIVOS FORA DE PROCESSO DE DESATIVAÇÃO DO SISTEMA   */
    public List<ClientesOBJ> Ativos() {
        String sql = "select * from clientes WHERE informacao like '%activado%' && r like '%n%' order by clientes.nome asc";
        PreparedStatement pstm = null;
        Connection con = null;
        ResultSet rs = null;
        List<ClientesOBJ> clientes;
        clientes = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                ClientesOBJ novo = new ClientesOBJ(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("nacionalidade"),
                        rs.getString("BI"),
                        rs.getString("telefone"),
                        rs.getString("whatsapp"),
                        rs.getString("endereco"),
                        rs.getString("email"),
                        rs.getString("informacao"),
                        rs.getString("servico"),
                        rs.getInt("pacote"),
                        rs.getString("GPON"),
                        rs.getString("vlan"),
                        rs.getInt("dia")
                );
                clientes.add(novo);
            }
            return clientes;
        } catch (SQLException e) {
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);

        }
    }

    /*     MÉTODO DE PESQUISA DE CLIENTES ATIVOS SEGUNDO O NOME, VLAN, GPON DO SISTEMA   */
    public List<ClientesOBJ> PesquisaClienteAtivos(String nome) {
        String sql = "select * from clientes WHERE (nome like '%" + nome + "%' or (GPON like '%" + nome + "%' or vlan like '%" + nome + "%') )  && INFORMACAO like '%activado%' && r like '%n%' order by clientes.nome asc";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = null;
        List<ClientesOBJ> clientes;
        clientes = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                ClientesOBJ novo = new ClientesOBJ(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("nacionalidade"),
                        rs.getString("BI"),
                        rs.getString("telefone"),
                        rs.getString("whatsapp"),
                        rs.getString("endereco"),
                        rs.getString("email"),
                        rs.getString("informacao"),
                        rs.getString("servico"),
                        rs.getInt("pacote"),
                        rs.getString("GPON"),
                        rs.getString("vlan"),
                        rs.getInt("dia")
                );
                clientes.add(novo);
            }

            return clientes;
        } catch (SQLException e) {
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    /*     MÉTODO DE OBTENÇÃO DE TODOS CLIENTES DESATIVADOS FORA DE PROCESSO DE ATICVAÇÃO DO SISTEMA   */
    public List<ClientesOBJ> Desativados() {
        String sql = "select * from clientes WHERE INFORMACAO like '%Desativado%' && r like '%n%' order by clientes.nome asc";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = null;
        List<ClientesOBJ> clientes;
        clientes = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                ClientesOBJ novo = new ClientesOBJ(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("nacionalidade"),
                        rs.getString("BI"),
                        rs.getString("telefone"),
                        rs.getString("whatsapp"),
                        rs.getString("endereco"),
                        rs.getString("email"),
                        rs.getString("informacao"),
                        rs.getString("servico"),
                        rs.getInt("pacote"),
                        rs.getString("GPON"),
                        rs.getString("vlan"),
                        rs.getInt("dia")
                );
                clientes.add(novo);
            }

            return clientes;
        } catch (SQLException e) {
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    /*     MÉTODO DE PESQUISA DE CLIENTES DESATIVADOS SEGUNDO O NOME, VLAN, GPON DO SISTEMA   */
    public List<ClientesOBJ> PesquisaClienteDesativados(String nome) {
        String sql = "select * from clientes WHERE (nome like '%" + nome + "%' or (GPON like '%" + nome + "%' or vlan like '%" + nome + "%') )  && INFORMACAO like '%Desativado%' && r like '%n%' order by clientes.nome asc";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = null;
        List<ClientesOBJ> clientes;
        clientes = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                ClientesOBJ novo = new ClientesOBJ(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("nacionalidade"),
                        rs.getString("BI"),
                        rs.getString("telefone"),
                        rs.getString("whatsapp"),
                        rs.getString("endereco"),
                        rs.getString("email"),
                        rs.getString("informacao"),
                        rs.getString("servico"),
                        rs.getInt("pacote"),
                        rs.getString("GPON"),
                        rs.getString("vlan"),
                        rs.getInt("dia")
                );
                clientes.add(novo);
            }

            return clientes;
        } catch (SQLException e) {
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    /*    ACTIVAÇÃO DE UM CLIENTE SEGUNDO O SEU ID    */
    public boolean Ativar(String tecnico, int id) {
        String sql = "UPDATE `clientes` SET `informacao` = 'ACTIVADO', `r` = 'n' WHERE `id` = ?";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();
            RegistrarLogs(tecnico, "ATIVOU O(A) CLIENTE " + getCliente(id).getNome());
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ativar Cliente! \nErro: " + e);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    /*    DESACTIVAÇÃO DE UM CLIENTE SEGUNDO O SEU ID    */
    public boolean Desativar(String tecnico, int id) {
        String sql = "UPDATE `clientes` SET `informacao` = 'DESATIVADO', `r` = 'n' WHERE `id` = ?";
        PreparedStatement pstm = null;
        Connection con = null;
        ResultSet rs = null;
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();
            RegistrarLogs(tecnico, "DESACTIVOU O(A) CLIENTE " + getCliente(id).getNome());
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao desativar Cliente! \nErro: " + e);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public boolean CancelarAtivaçãoDesativação(String tecnico, int id) {
        String sql = "UPDATE `clientes` SET `r` = 'n' WHERE `id` = ?";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();
            RegistrarLogs(tecnico, "CANCELOU A ACTIVAÇÃO OU DESATIVAÇÃO DO CLIENTE: " + getCliente(id).getNome());
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Cancelar Cliente! \nErro: " + e);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    /*    OBTER OS DADOS DE UM CLIENTE SEGUNDO O SEU ID      */
    public ClientesOBJ getCliente(int id) {
        String sql = "select * from clientes WHERE ID='" + id + "'";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = null;
        ClientesOBJ clientes = null;
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                clientes = new ClientesOBJ(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("nacionalidade"),
                        rs.getString("BI"),
                        rs.getString("telefone"),
                        rs.getString("whatsapp"),
                        rs.getString("endereco"),
                        rs.getString("email"),
                        rs.getString("informacao"),
                        rs.getString("servico"),
                        rs.getInt("pacote"),
                        rs.getString("GPON"),
                        rs.getString("vlan"),
                        rs.getInt("dia")
                );
            }

            return clientes;
        } catch (SQLException e) {
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    /*     MÉTODO DE PESQUISA DE CLIENTES SEGUNDO O NOME, VLAN, GPON DO SISTEMA   */
    public List<ClientesOBJ> PesquisaCliente(String nome) {
        String sql = "select * from clientes  WHERE (nome like '%" + nome + "%' or (GPON like '%" + nome + "%' or vlan like '%" + nome + "%')) order by clientes.nome asc";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = null;
        List<ClientesOBJ> clientes;
        clientes = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                ClientesOBJ novo = new ClientesOBJ(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("nacionalidade"),
                        rs.getString("BI"),
                        rs.getString("telefone"),
                        rs.getString("whatsapp"),
                        rs.getString("endereco"),
                        rs.getString("email"),
                        rs.getString("informacao"),
                        rs.getString("servico"),
                        rs.getInt("pacote"),
                        rs.getString("GPON"),
                        rs.getString("vlan"),
                        rs.getInt("dia")
                );
                clientes.add(novo);
            }

            return clientes;
        } catch (SQLException e) {
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    /*     APAGAR UM CLIENTE DO SISTEMA    */
    public boolean Apagar(String tecnico, int idCliente) {
        Connection con = null;
        String sql = "DELETE FROM clientes where id = ?";
        String sqlP = "DELETE FROM pagamento where idCliente = ?";
        String sqlR = "DELETE FROM racionar where idCliente = ?";
        PreparedStatement pstm = null;
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sqlR);
            pstm.setInt(1, idCliente);
            pstm.executeUpdate();
            pstm = con.prepareStatement(sqlP);
            pstm.setInt(1, idCliente);
            pstm.executeUpdate();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, idCliente);
            pstm.executeUpdate();
            RegistrarLogs(tecnico, "APAGOU DO SISTEMA O CLIENTE " + getCliente(idCliente).getNome());
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Remover Cliente do Sistema: \nErro:" + e);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm);
        }
    }

    /*   VERFICAR O EMAIL E SENHA E EM SEGUIDA FAZ LOGIN    */
    public boolean Logar(String usuario, String Senha) {
        String sql = "SELECT * FROM login WHERE email = ?";
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        boolean estado = false;

        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, usuario);
            rs = pstm.executeQuery();

            if (rs.next()) {
                if (rs.getString("senha").equals(Senha)) {
                    estado = true;
                    RegistrarLogs(getNomeUsuário(usuario), "FEZ LOGIN NO SISTEMA");
                }
            }
            return estado;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao logar! \nErro: " + e);
            RegistrarLogs(getNomeUsuário(usuario), "SEM SUCESSO NA EXECUÇÃO DE LOGIN NO SISTEMA");
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }

    }

    /*   VERFICAR O NOME E EMAIL E EM SEGUIDA RETORNA TRUE OU FALSE    */
    public boolean VerificarUsuario(String nome, String email) {
        String sql = "SELECT * FROM login WHERE email = ?";
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, email);
            rs = pstm.executeQuery();
            if (!rs.next()) {
                pstm = con.prepareStatement("SELECT * FROM login where nome = ?");
                pstm.setString(1, nome);
                rs = pstm.executeQuery();
                return rs.next();
            } else {
                return true;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao verificar Dados do Usuário! \nErro: " + e);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }

    }

    /*    OBTER PREVILÉGIO DO USUÁRIO SEGUNFO O EMAIL   */
    public String getPrevilegString(String usuario) {
        String sql = "SELECT previlegio FROM login WHERE email = ?";
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String estado = "";

        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, usuario);
            rs = pstm.executeQuery();

            if (rs.next()) {
                estado = rs.getString("previlegio");
            }

            return estado;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar o previlegio! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    /* REGISTRA NOVO USUÁRIO NO SISTEMA  */
    public boolean NovoUsuario(LoginOBJ usuario) {
        String sql = "INSERT INTO login(nome,email, senha, previlegio) values( ?, ?, ?, ?);";
        PreparedStatement pstm = null;
        Connection con = null;
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getEmail());
            pstm.setString(3, usuario.getSenha());
            pstm.setString(4, usuario.getPrevilegio());
            pstm.execute();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário!\nTipo de Erro:\n\t\t" + e);
            return false;
        } finally {
            JOptionPane.showMessageDialog(null, "Bem vindo Sr. " + usuario.getNome());
            Conexao.FecharConexão(con, pstm);
        }
    }

    /*   OBTEM NOME DO USUÁRIO SEGUNDO O SEU EMAIL   */
    public String getNomeUsuário(String email) {
        String sql = "SELECT nome FROM login WHERE email = ?";
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String estado = email;

        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, email);
            rs = pstm.executeQuery();

            if (rs.next()) {
                estado = rs.getString("nome");
            }

            return estado;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar o Nome de Usuário! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    /*   OBTEM NOME DO USUÁRIO SEGUNDO O SEU ID   */
    public String getNomeUsuário(int id) {
        String sql = "SELECT nome FROM login WHERE id = ?";
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String estado = "";

        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            if (rs.next()) {
                estado = rs.getString("nome");
            }

            return estado;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar o Nome de Usuário! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public LoginOBJ getUsuário(int id) {
        String sql = "SELECT * FROM login where id = ?";
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        LoginOBJ logins = new LoginOBJ();

        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            while (rs.next()) {
                logins = new LoginOBJ(rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("previlegio"),
                        rs.getString("categoria")
                );
            }

            return logins;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar Todos Usuários! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    /*  OBTEM TODOS USUARIOS    */
    public List<LoginOBJ> ObterUsuários() {
        String sql = "SELECT * FROM login";
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<LoginOBJ> logins = new ArrayList<>();

        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                logins.add(new LoginOBJ(rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("previlegio"),
                        rs.getString("categoria")
                ));
            }

            return logins;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar Todos Usuários! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    /*   OBTEM ID DO USUÁRIO SEGUNDO O SEU EMAIL   */
    public String getIdUsuário(String email) {
        String sql = "SELECT id FROM login WHERE email = ?";
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String estado = "";

        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, email);
            rs = pstm.executeQuery();

            if (rs.next()) {
                estado = rs.getString("id");
            }

            return estado;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar o Id de Usuário! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public int getIdUsuárioPeloNome(String chave) {
        String sql = "SELECT id FROM login WHERE nome = ?";
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int estado = 0;

        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, chave);
            rs = pstm.executeQuery();

            if (rs.next()) {
                estado = rs.getInt("id");
            }

            return estado;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar o Id de Usuário! \nErro: " + e);
            return -1;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    /*   OBTEM NOME DO CLIENTE SEGUNDO O SEU ID   */
    public String getNomeCliente(int id) {
        String sql = "SELECT nome FROM clientes WHERE id = ?";
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String estado = "";

        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            if (rs.next()) {
                estado = rs.getString("nome");
            }

            return estado;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar o Id de Usuário! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    /*   CRIAR NOVO CLIENTE E EM SEGUIDA RETORNA VERDADEIRO OU FALSO CALGO OCORRA BEM OU MAL   */
    public boolean NovoCliente(String tecnico, ClientesOBJ cliente) {
        String sql = "INSERT INTO clientes(nome, nacionalidade, BI, telefone, whatsapp, endereco, email, servico, pacote, r) "
                + "values( ?, ?, ?, ?, ?, ?, ?, ?, ?, 'n');";
        PreparedStatement pstm = null;
        Connection con = null;
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getNacionalidade());
            pstm.setString(3, cliente.getBI());
            pstm.setString(4, cliente.getTelefone());
            pstm.setString(5, cliente.getWhatsapp());
            pstm.setString(6, cliente.getEndereço());
            pstm.setString(7, cliente.getEmail());
            pstm.setString(8, cliente.getServiço());
            pstm.setInt(9, cliente.getPacote());
            pstm.execute();
            RegistrarLogs(tecnico, "CADASTROU 0 CLIENTE " + cliente.getNome());
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Cliente!\nTipo de Erro:\n\t\t" + e);
            return false;
        } finally {
            JOptionPane.showMessageDialog(null, "Cliente Cadastrado");
            Conexao.FecharConexão(con, pstm);
        }
    }

    /*    ATUALIZA OS DADOS DO CLIENTE   */
    public boolean AtualizarCliente(String tecnico, ClientesOBJ cliente) {
        String sql = "update allcenter.clientes set nome = ?, nacionalidade = ?, BI = ?, telefone = ?, whatsapp = ?, endereco = ?, email =?, servico = ?, pacote = ?, GPON = ?, vlan = ? where id =" + cliente.getId();

        PreparedStatement pstm = null;
        Connection con = null;
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getNacionalidade());
            pstm.setString(3, cliente.getBI());
            pstm.setString(4, cliente.getTelefone());
            pstm.setString(5, cliente.getWhatsapp());
            pstm.setString(6, cliente.getEndereço());
            pstm.setString(7, cliente.getEmail());
            pstm.setString(8, cliente.getServiço());
            pstm.setInt(9, cliente.getPacote());
            pstm.setString(10, cliente.getGPON());
            pstm.setString(11, cliente.getVlan());
            pstm.executeUpdate();
            RegistrarLogs(tecnico, "ATUALIZOU OS DADOS DO CLIENTE " + cliente.getNome());
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar Cliente!\nTipo de Erro:\n\t\t" + e);
            return false;
        } finally {
            JOptionPane.showMessageDialog(null, "Cliente Atualizado");
            Conexao.FecharConexão(con, pstm);
        }
    }

    /*  RETONA UMA LISTA DE TODOS MESES DO ANO  */
    public List<MesesOBJ> TodosMeses() {
        String sql = "SELECT * FROM meses";
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<MesesOBJ> mes;
        mes = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                MesesOBJ m = new MesesOBJ(rs.getInt("id"), rs.getString("nome"));
                mes.add(m);
            }

            return mes;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar os meses na BD! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public int idMes(String chave) {
        String sql = "SELECT id FROM meses where nome like '%" + chave + "%'";
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int id = 0;
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
            }

            return id;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar id do mese na no servidor! \nErro: " + e);
            return 0;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public String getNomeMes(int id) {
        String sql = "SELECT nome FROM meses where id = '" + id + "'";
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String nome = "";
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                nome = rs.getString("nome");
            }

            return nome;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar nome do mes no servidor! \nErro: " + e);
            return "Desconhecido";
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    /*    RETORNA UMA LISTA DE TODOS PAGAMENTOS FEITOS DE UM CLIENTE SEGUNDO O SEU ID    */
    public List<PagamentoOBJ> PagamentosFeitos(int idCliente) {
        String sql = "SELECT * FROM pagamento where idCliente = ? order by idMes";
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<PagamentoOBJ> pagamentos;
        pagamentos = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, idCliente);
            rs = pstm.executeQuery();
            while (rs.next()) {
                PagamentoOBJ pg = new PagamentoOBJ(rs.getInt("id"), rs.getInt("idCliente"), rs.getInt("idMes"), rs.getInt("ano"));
                pagamentos.add(pg);
            }
            return pagamentos;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar pagaemntos feitos! \nErro: " + e);
            Conexao.FecharConexão(con, pstm, rs);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }

    }

    /*    VERIFICA A EXISTÊNCIA DE UM DADO PAGAMENTO    */
    public boolean VerificaPagamento(PagamentoOBJ pagamento) {
        String sql = "select * from pagamento where (idCliente= ? && idMes = ?) && (ano = ?)";
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, pagamento.getIdCliente());
            pstm.setInt(2, pagamento.getIdMes());
            pstm.setInt(3, pagamento.getAno());
            rs = pstm.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao verificar Pagamento! \nErro: " + e);
            Conexao.FecharConexão(con, pstm);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm);
        }
    }

    /*   APAGA UM PAGAEMNTO DO SISTEMA   */
    public boolean ApagarPagamento(String tecnico, PagamentoOBJ pagamento) {
        String sql = "delete from pagamento where (idCliente = ? && idMes = ?) && (ano = ?)";
        Connection con = null;
        String sql2 = "update clientes set m = 0 where id = '" + pagamento.getIdCliente() + "'";
        PreparedStatement pstm = null;
        try {
            con = Conexao.conectar();

            if ((pagamento.getIdMes() == MesServidor()) && (pagamento.getAno() == AnoServidor())) {
                pstm = con.prepareStatement(sql2);
                pstm.executeUpdate();
                pstm = null;
            }
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, pagamento.getIdCliente());
            pstm.setInt(2, pagamento.getIdMes());
            pstm.setInt(3, pagamento.getAno());
            pstm.executeUpdate();
            RegistrarLogs(tecnico, "APAGOU PAGAMENTO DO CLIENTE " + getNomeCliente(pagamento.getIdCliente()) + " REFERENTE AO MÊS " + TodosMeses().get(pagamento.getIdMes()).getNome());
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao apagar Pagamento! \nErro: " + e);
            Conexao.FecharConexão(con, pstm);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm);
        }
    }

    /*     ADICIONA UM NOVO PAGAEMNTO NO SISTEMA      */
    public boolean Pagar(String tecnico, PagamentoOBJ pagamento) {
        String sql = "INSERT INTO pagamento(idCliente, idMes, ano) value(?, ?, ?)";
        String sql2 = "update clientes set m = '" + pagamento.getIdMes() + "' where id = '" + pagamento.getIdCliente() + "'";
        String sql3 = "update clientes set m = '" + MesServidor() + "' where id = '" + pagamento.getIdCliente() + "'";
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = Conexao.conectar();

            if ((pagamento.getIdMes() == MesServidor()) && (pagamento.getAno() == AnoServidor())) {
                pstm = con.prepareStatement(sql2);
                pstm.executeUpdate();
                pstm = null;
            } else {

                int op = JOptionPane.showConfirmDialog(null, ""
                        + "<html>"
                        + "<p>"
                        + "O cliente não será removido da lista de devedores,<br>"
                        + "Pois não Pagou o mês atual, Deseja Removelo da Lista de Avisos?<br><br>"
                        + "OBS: TENHA CERTEZA DA SUA ESCOLHA!<br>"
                        + "</p>"
                        + "</html>");
                if (op == 0) {
                    pstm = con.prepareStatement(sql3);
                    pstm.executeUpdate();
                    pstm = null;
                }
            }
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, pagamento.getIdCliente());
            pstm.setInt(2, pagamento.getIdMes());
            pstm.setInt(3, pagamento.getAno());
            pstm.execute();
            RegistrarLogs(tecnico, "EFETUOU PAGAMENTO DO CLIENTE " + getNomeCliente(pagamento.getIdCliente()) + " REFERENTE AO MÊS " + TodosMeses().get(pagamento.getIdMes()).getNome());
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar os meses na BD! \nErro: " + e);
            Conexao.FecharConexão(con, pstm);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm);
            JOptionPane.showMessageDialog(null, "Pagamento Feito!");
        }
    }

    /*   OBTEM TODOS CLIENTES QUE ESTÃO EM PROCESSO DE ACTIVAÇÃO OU DESACTIVAÇÃO      */
    public List<ClientesOBJ> AllRacionar() {
        String sql = "select * from clientes where r='s'";
        PreparedStatement pstm = null;
        Connection con = null;
        ResultSet rs = null;
        List<ClientesOBJ> clientes;
        clientes = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                ClientesOBJ novo = new ClientesOBJ(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("nacionalidade"),
                        rs.getString("BI"),
                        rs.getString("telefone"),
                        rs.getString("whatsapp"),
                        rs.getString("endereco"),
                        rs.getString("email"),
                        rs.getString("informacao"),
                        rs.getString("servico"),
                        rs.getInt("pacote"),
                        rs.getString("GPON"),
                        rs.getString("vlan"),
                        rs.getInt("dia")
                );
                clientes.add(novo);
            }
            return clientes;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Todos Clientes! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    /*  VERIFICA SE TEM CLIENTES EM PROCESSO DE ACTIVAÇÃO E DESACTIVAÇÃO    */
    public boolean VefificarAllRacionar() {
        String sql = "SELECT * FROM clientes where r='s'";
        PreparedStatement pstm = null;
        Connection con = null;
        ResultSet rs = null;
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Todos Clientes em processamento! \nErro: " + e);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    /*     ADICIONA NOVO CLIENTE NA LISTA DE PROCESSOS PARA ACTIVAÇÃO OU DESACTIVAÇÃO    */
    public boolean Racionar(int id, String ação, String Nota) {
        String sql = "INSERT INTO racionar(idCliente, acao, nota) VALUES (?, ?, ?)";
        String sql2 = "UPDATE clientes SET r = 's' WHERE (id = ?)";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.setString(2, ação);
            pstm.setString(3, Nota);
            pstm.execute();

            pstm = con.prepareStatement(sql2);
            pstm.setInt(1, id);
            pstm.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ativar Cliente! \nErro: " + e);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    /*     BUSCA A NOTA DE ACTIVAÇÃO OU DESACTIVAÇÃO DE UM CLIENTE SEGUNDO O SEU ID     */
    public String BuscarNota(int idCliente) {
        String sql = "select nota from racionar where idCliente = ?";
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        String tem = "-1";
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, idCliente);
            rs = pstm.executeQuery();
            while (rs.next()) {
                tem = rs.getString("nota");
            }
            return tem;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Nota de Ativação ou Desativação! \nErro: " + e);
            Conexao.FecharConexão(con, pstm);
            return "-1";
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    /*     REMOV E UM CLIENTE DA LISTA DE PROCESSOS DE ACTIVAÇÃO OU DESACTIVAÇÃO    */
    public boolean Desracionar(int id) {
        String sql = "DELETE FROM racionar WHERE (idCliente = ?)";
        String sql2 = "UPDATE clientes SET r = 'n' WHERE (id = ?)";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();
            pstm = con.prepareStatement(sql2);
            pstm.setInt(1, id);
            pstm.executeUpdate();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Desracionar cliente! \nErro: " + e);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    /* RECEBE O ID DO HISTÓRICO DE CLIENTE SEGUNDO O SEU ID    */
    public int BuscarIdHistorico(int idCliente) {

        String sql = "select idH from racionar where idCliente = ?";
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        int tem = 0;
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, idCliente);
            rs = pstm.executeQuery();
            while (rs.next()) {
                tem = rs.getInt("idH");
            }
            return tem;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Id do Historico! \nErro: " + e);
            Conexao.FecharConexão(con, pstm);
            return 0;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }

    }

    /*     BUSCA TODOS HISTÓRICOS DE ACTIVAÇÃO E DESACTIVAÇÃO    */
    public List<HistoricoOBJ> HistoricoDetalhado() {
        String sql = "SELECT * FROM historico";
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<HistoricoOBJ> historico;
        historico = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                HistoricoOBJ hist = new HistoricoOBJ(rs.getInt("id"),
                        rs.getString("cliente"),
                        rs.getString("operador"),
                        rs.getString("dataP"),
                        rs.getString("acao"),
                        rs.getString("nota"),
                        rs.getString("tecnico"),
                        rs.getString("dataA"));
                historico.add(hist);
            }

            return historico;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar os meses na BD! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }

    }

    /*    BUSCA HISTÓRICO DE ACTIVAÇÃO E DESACTIVAÇÃO DE UM DETERMINADO CLIENTE SEGUNDO O SEU ID    */
    public HistoricoOBJ DadoHistorico(int id) {
        String sql = "SELECT * FROM historico where id = ?";
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        HistoricoOBJ historico = null;
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                HistoricoOBJ hist = new HistoricoOBJ(
                        rs.getInt("id"),
                        rs.getString("cliente"),
                        rs.getString("operador"),
                        rs.getString("dataP"),
                        rs.getString("acao"),
                        rs.getString("nota"),
                        rs.getString("tecnico"),
                        rs.getString("dataA"));
                historico = hist;
            }

            return historico;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar os meses na BD! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    /*   RETORNA UMA LISTA DE HISTÓRICO SEGUNDO UMA PESQUISA MULTI-FUNCIONAL ENVOLVENDO ID, TECNICO, CLIENTE E OPERADOR */
    public List<HistoricoOBJ> BuscaHistoricoDetalhado(String chave) {
        String sql = "SELECT * FROM historico where ((id like '%" + chave + "%' or tecnico like '%" + chave + "%') or (cliente like '%" + chave + "%' or operador like '%" + chave + "%') )";
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<HistoricoOBJ> historico;
        historico = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                HistoricoOBJ hist = new HistoricoOBJ(
                        rs.getInt("id"),
                        rs.getString("cliente"),
                        rs.getString("operador"),
                        rs.getString("dataP"),
                        rs.getString("acao"),
                        rs.getString("nota"),
                        rs.getString("tecnico"),
                        rs.getString("dataA"));
                historico.add(hist);
            }

            return historico;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar os meses na BD! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    /*  OBTEM HORA ATUAL DO SERVIDOR   */
    public String HoraServidor() {
        String sql = "select now()";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = null;
        String dt = "AGUARDANDO";
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                dt = rs.getString(1);
            }

            return dt;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar data do Servidor: " + e);
            return "AGUARDANDO";
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public int AnoServidor() {
        String sql = "select Year(now())";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = null;
        int dt = 0;
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                dt = rs.getInt(1);
            }

            return dt;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Ano do Servidor: " + e);
            return 0;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public int MesServidor() {
        String sql = "select month(now())";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = null;
        int dt = 0;
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                dt = rs.getInt(1);
            }

            return dt;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Mês do Servidor: " + e);
            return 0;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public int DiaServidor() {
        String sql = "select day(now())";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = null;
        int dt = 0;
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                dt = rs.getInt(1);
            }

            return dt;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Dia do Servidor: " + e);
            return 0;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public Time TempoServidor() {
        String sql = "select CURTIME()";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = null;
        Time dt = null;
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                dt = rs.getTime(1);
            }

            return dt;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Tempo do Servidor: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    /*  ADICIONA UM NOVO HISTORICO NO SISTEMA    */
    public boolean AddHistorico(int idCliente, String cliente, String tecnico, String ação, String Nota) {

        String dataP = HoraServidor();

        String sql = "INSERT INTO historico(cliente,operador,dataP, acao, nota) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, cliente);
            pstm.setString(2, tecnico);
            pstm.setString(3, dataP);
            pstm.setString(4, ação);
            pstm.setString(5, Nota);
            pstm.execute();

            int idH = 0;

            pstm = con.prepareStatement("select id from historico where cliente = ? && operador = ? && dataP = ?");
            pstm.setString(1, cliente);
            pstm.setString(2, tecnico);
            pstm.setString(3, dataP);

            rs = pstm.executeQuery();
            while (rs.next()) {
                idH = rs.getInt("id");
            }

            if (idH != 0) {

                con = Conexao.conectar();
                pstm = con.prepareStatement("update racionar set idH = ? where idCliente = ?");
                pstm.setInt(1, idH);
                pstm.setInt(2, idCliente);
                pstm.executeUpdate();
                RegistrarLogs(tecnico, "PEDIU PARA " + ação.toUpperCase() + " O CLIENTE: " + cliente.toUpperCase());
                return true;

            } else {
                return false;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Adicionar Histórico: " + e);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    /*   ATUALIZA O HISTÓRICO DETERMINADO PELO ID DO HISTÓRICO E O TÉCNICO     */
    public boolean atualizarHistorico(int id, String tecnico) {

        String dataP = HoraServidor();

        String sql = "update historico set tecnico = ?, dataA = ? where id = ?";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, tecnico);
            pstm.setString(2, dataP);
            pstm.setInt(3, id);
            pstm.executeUpdate();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar Histórico: " + e);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    /*   ATUALIZA A DATA DE PAGAMENTOS DE UM CLIENTE    */
    public boolean AtualizarDiaDePagamento(String tecnico, int idCliente, int dia) {
        String sql = "update clientes set dia = ? where id = ?";
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, dia);
            pstm.setInt(2, idCliente);
            pstm.executeUpdate();
            RegistrarLogs(tecnico, "ATUALIZOU O DIA DE PAGAMENTO DO CLIENTE: " + getNomeCliente(idCliente));
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar dia de  Pagamento! \nErro: " + e);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm);
        }
    }

    /*     RETORNA O DIA DE PAGAMENTO DE UM CLIENTE SEGUNDO O SEU ID     */
    public String BuscarDiaDePagamento(int idCliente) {
        String sql = "select dia from clientes where id = ?";
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        String tem = "-1";
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, idCliente);
            rs = pstm.executeQuery();
            while (rs.next()) {
                tem = rs.getString("dia");
            }
            return tem;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Registro de dia de  Pagamento! \nErro: " + e);
            Conexao.FecharConexão(con, pstm);
            return "-1";
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    /*    RETORNA UMA LISTA DE DIAS DE PAGAEMNTO DIFERENTE DE ZERP    */
    public List<DiaPagamentoOBJ> BuscarAllDia() {
        String sql = "select clientes.id, clientes.nome, clientes.informacao, clientes.telefone, `clientes`.dia from clientes where dia != '0' order by clientes.nome asc";
        PreparedStatement pstm = null;
        Connection con = null;
        ResultSet rs = null;
        List<DiaPagamentoOBJ> clientes;
        clientes = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                DiaPagamentoOBJ novo;
                novo = new DiaPagamentoOBJ(
                        rs.getInt("clientes.id"),
                        rs.getString("clientes.nome"),
                        rs.getString("clientes.telefone"),
                        rs.getString("clientes.informacao"),
                        rs.getInt("clientes.dia"));
                clientes.add(novo);
            }
            return clientes;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Dias de pagamentos! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }

    }

    /*    RETORNA UMA LISTA DE DIA DE PAGAMENTO CUJO INTERVALO ATÉ AO DIA NÃO É SUPERIOR A TRÊS DIAS     */
    public List<DiaPagamentoOBJ> BuscarDiaAtual() {
        String sql = "select clientes.id, clientes.nome, clientes.informacao, clientes.telefone, `clientes`.dia from clientes where ((clientes.dia - day(now())) <= 3 && (clientes.dia - day(now())) >= 0) && m <> month(now()) order by clientes.nome asc";
        PreparedStatement pstm = null;
        Connection con = null;
        ResultSet rs = null;
        List<DiaPagamentoOBJ> clientes;
        clientes = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                DiaPagamentoOBJ novo;
                novo = new DiaPagamentoOBJ(
                        rs.getInt("clientes.id"),
                        rs.getString("clientes.nome"),
                        rs.getString("clientes.telefone"),
                        rs.getString("clientes.informacao"),
                        rs.getInt("clientes.dia"));
                clientes.add(novo);
            }
            return clientes;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Dias de pagamentos! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }

    }

    /*     VERIFICA A EXISTENCIA DE CLIENTES A PAGAR DENTRO DE TRÊS OU MENOS DIAS    */
    public boolean VerificarDiaAtual() {
        String sql = "select clientes.id, clientes.nome, clientes.informacao, clientes.telefone, `clientes`.dia from clientes where (clientes.dia - day(now())) <= 3 && (clientes.dia - day(now())) >= 0 order by clientes.nome asc";
        PreparedStatement pstm = null;
        Connection con = null;
        ResultSet rs = null;
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Verificar Dias de pagamentos! \nErro: " + e);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }

    }

    /*  RETORNA UMA LISTA DE DIAS DE PAGAMENTOS SEGUNDO O NOME DO CLIENTE    */
    public List<DiaPagamentoOBJ> BuscarDia(String nome) {
        String sql = "select clientes.id, clientes.nome, clientes.informacao, clientes.telefone, `clientes`.dia from clientes where clientes.nome like '%" + nome + "%' && clientes.dia != '0' order by clientes.nome asc";
        PreparedStatement pstm = null;
        Connection con = null;
        ResultSet rs = null;
        List<DiaPagamentoOBJ> clientes;
        clientes = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                DiaPagamentoOBJ novo;
                novo = new DiaPagamentoOBJ(
                        rs.getInt("clientes.id"),
                        rs.getString("clientes.nome"),
                        rs.getString("clientes.telefone"),
                        rs.getString("clientes.informacao"),
                        rs.getInt("clientes.dia"));
                clientes.add(novo);
            }
            return clientes;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Dias de pagamentos! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }

    }


    /*  IMPRIME UM DOCUMENTO EM PDF COM TODOS CLIENTES REGISTRADOS NO SISTEMA     */
    public boolean ImprimirDados(String tecnico) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Document doc = new Document(PageSize.A4, 31, 31, 72, 31);
        String Arq1 = "Todos_Clientes.pdf";
        try {

            BaseFont baseFont = BaseFont.createFont(SegoeUI, BaseFont.WINANSI, BaseFont.EMBEDDED);
            BaseFont baseFontB = BaseFont.createFont(SegoeUIB, BaseFont.WINANSI, BaseFont.EMBEDDED);

            Font SEGOEUI = new Font(baseFont, 10);
            Font SEGOEUI_C = new Font(baseFont, 12);

            con = Conexao.conectar();
            PdfWriter.getInstance(doc, new FileOutputStream(Arq1));
            doc.setMarginMirroring(true);
            doc.open();
            Paragraph p = new Paragraph("LISTA DE TODOS CLIENTES E PARCEIROS", SEGOEUI_C);
            p.setAlignment(1);
            doc.add(p);
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));

            p = new Paragraph("DATA DE IMPRESSÃO: " + HoraServidor().toUpperCase(), SEGOEUI);
            p.setIndentationLeft(31);
            doc.add(p);
            doc.add(new Paragraph(" "));

            List<ClientesOBJ> clientes = Todos();

            float[] colsWidth = {0.05f, 0.45f, 0.3f, 0.15f, 0.1f, 0.1f};
            PdfPTable tabela = new PdfPTable(colsWidth);

            tabela.setWidthPercentage(90);

            PdfPCell cln = new PdfPCell(new Paragraph("ID", SEGOEUI));
            PdfPCell cln1 = new PdfPCell(new Paragraph("NOME", SEGOEUI));
            PdfPCell cln3 = new PdfPCell(new Paragraph("ENDEREÇO", SEGOEUI));
            PdfPCell cln4 = new PdfPCell(new Paragraph("CONTACTOS", SEGOEUI));
            PdfPCell cln5 = new PdfPCell(new Paragraph("PACOTE", SEGOEUI));
            PdfPCell cln6 = new PdfPCell(new Paragraph("ESTADO", SEGOEUI));
            cln.setHorizontalAlignment(1);
            cln1.setHorizontalAlignment(1);
            cln3.setHorizontalAlignment(1);
            cln4.setHorizontalAlignment(1);
            cln5.setHorizontalAlignment(1);
            cln6.setHorizontalAlignment(1);
            cln1.setVerticalAlignment(1);
            cln3.setVerticalAlignment(1);
            cln4.setVerticalAlignment(1);
            cln5.setVerticalAlignment(1);
            cln6.setVerticalAlignment(1);

            tabela.addCell(cln);
            tabela.addCell(cln1);
            tabela.addCell(cln3);
            tabela.addCell(cln4);
            tabela.addCell(cln5);
            tabela.addCell(cln6);
            int numero = 1;
            for (ClientesOBJ cliente : clientes) {

                cln = new PdfPCell(new Paragraph("" + numero, SEGOEUI));
                cln1 = new PdfPCell(new Paragraph(cliente.getNome().toUpperCase(), SEGOEUI));
                cln3 = new PdfPCell(new Paragraph(cliente.getEndereço().toLowerCase(), SEGOEUI));
                cln4 = new PdfPCell(new Paragraph(cliente.getTelefone().toUpperCase(), SEGOEUI));
                cln5 = new PdfPCell(new Paragraph(cliente.getPacote() + "", SEGOEUI));
                cln6 = new PdfPCell(new Paragraph(cliente.getInformação().toLowerCase(), SEGOEUI));
                cln.setVerticalAlignment(1);
                cln1.setVerticalAlignment(1);
                cln3.setVerticalAlignment(1);
                cln4.setVerticalAlignment(1);
                cln5.setVerticalAlignment(1);
                cln6.setVerticalAlignment(1);
                tabela.addCell(cln);
                tabela.addCell(cln1);
                tabela.addCell(cln3);
                tabela.addCell(cln4);
                tabela.addCell(cln5);
                tabela.addCell(cln6);
                numero++;
            }

            doc.add(tabela);

            doc.close();

            Desktop.getDesktop().open(new File(Arq1));
            RegistrarLogs(tecnico, "IMPRIMIU UM DOCUMENTO COM TODOS CLIENTES ");
            return true;
        } catch (DocumentException | IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Imprimir Clientes! \nErro: " + e);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    private static final String SegoeUI = "Fontes/segoeuiN.ttf";
    private static final String SegoeUIB = "Fontes/segoeuib.ttf";

    /*  IMPRIME UM DOCUMENTO EM PDF COM TODOS CLIENTES SCTIVOS REGISTRADOS NO SISTEMA     */
    public boolean ImprimirActivados(String tecnico) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Document doc = new Document(PageSize.A4, 31, 31, 72, 31);
        String Arq1 = "Clientes_Activados.pdf";
        try {

            BaseFont baseFont = BaseFont.createFont(SegoeUI, BaseFont.WINANSI, BaseFont.EMBEDDED);
            BaseFont baseFontB = BaseFont.createFont(SegoeUIB, BaseFont.WINANSI, BaseFont.EMBEDDED);

            Font SEGOEUI = new Font(baseFont, 10);
            Font SEGOEUI_C = new Font(baseFontB, 13);

            con = Conexao.conectar();
            PdfWriter.getInstance(doc, new FileOutputStream(Arq1));
            doc.setMarginMirroring(true);
            doc.open();
            Paragraph p = new Paragraph("LISTA DE TODOS CLIENTES E PARCEIROS ACTIVADOS", SEGOEUI_C);
            p.setAlignment(1);
            doc.add(p);
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));

            p = new Paragraph("DATA DE IMPRESSÃO: " + HoraServidor().toUpperCase(), SEGOEUI);
            p.setIndentationLeft(31);
            doc.add(p);
            doc.add(new Paragraph(" "));
            List<ClientesOBJ> clientes = Ativos();

            float[] colsWidth = {0.45f, 0.3f, 0.15f, 0.1f};
            PdfPTable tabela = new PdfPTable(colsWidth);

            tabela.setWidthPercentage(90);

            PdfPCell cln1 = new PdfPCell(new Paragraph("NOME", SEGOEUI));
            PdfPCell cln3 = new PdfPCell(new Paragraph("ENDEREÇO", SEGOEUI));
            PdfPCell cln4 = new PdfPCell(new Paragraph("CONTACTOS", SEGOEUI));
            PdfPCell cln5 = new PdfPCell(new Paragraph("PACOTE", SEGOEUI));
            cln1.setHorizontalAlignment(1);
            cln3.setHorizontalAlignment(1);
            cln4.setHorizontalAlignment(1);
            cln5.setHorizontalAlignment(1);
            cln1.setVerticalAlignment(1);
            cln3.setVerticalAlignment(1);
            cln4.setVerticalAlignment(1);
            cln5.setVerticalAlignment(1);

            tabela.addCell(cln1);
            tabela.addCell(cln3);
            tabela.addCell(cln4);
            tabela.addCell(cln5);

            for (ClientesOBJ cliente : clientes) {
                cln1 = new PdfPCell(new Paragraph(cliente.getNome().toUpperCase(), SEGOEUI));
                cln3 = new PdfPCell(new Paragraph(cliente.getEndereço().toLowerCase(), SEGOEUI));
                cln4 = new PdfPCell(new Paragraph(cliente.getTelefone().toUpperCase(), SEGOEUI));
                cln5 = new PdfPCell(new Paragraph(cliente.getPacote() + "", SEGOEUI));
                cln1.setVerticalAlignment(1);
                cln3.setVerticalAlignment(1);
                cln4.setVerticalAlignment(1);
                cln5.setVerticalAlignment(1);
                tabela.addCell(cln1);
                tabela.addCell(cln3);
                tabela.addCell(cln4);
                tabela.addCell(cln5);
            }

            doc.add(tabela);

            doc.close();

            Desktop.getDesktop().open(new File(Arq1));
            RegistrarLogs(tecnico, "IMPRIMIU UM DOCUMENTO COM TODOS CLIENTES activados ");
            return true;
        } catch (DocumentException | IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Imprimir Clientes Ativados! \nErro: " + e);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }

    }

    /*  IMPRIME UM DOCUMENTO EM PDF COM TODOS CLIENTES DESACTIVADOS REGISTRADOS NO SISTEMA     */
    public boolean ImprimirDesactivados(String tecnico) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Document doc = new Document(PageSize.A4, 31, 31, 72, 31);
        String Arq1 = "Clientes_Desactivados.pdf";
        try {

            BaseFont baseFont = BaseFont.createFont(SegoeUI, BaseFont.WINANSI, BaseFont.EMBEDDED);
            BaseFont baseFontB = BaseFont.createFont(SegoeUIB, BaseFont.WINANSI, BaseFont.EMBEDDED);

            Font SEGOEUI = new Font(baseFont, 10);
            Font SEGOEUI_C = new Font(baseFont, 13);

            con = Conexao.conectar();
            PdfWriter.getInstance(doc, new FileOutputStream(Arq1));
            doc.setMarginMirroring(true);
            doc.open();
            Paragraph p = new Paragraph("LISTA DE TODOS CLIENTES E PARCEIROS DESACTIVADOS", SEGOEUI_C);
            p.setAlignment(1);
            doc.add(p);
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            p = new Paragraph("DATA DE IMPRESSÃO: " + HoraServidor().toUpperCase(), SEGOEUI);
            p.setIndentationLeft(31);
            doc.add(p);
            doc.add(new Paragraph(" "));
            List<ClientesOBJ> clientes = Desativados();

            float[] colsWidth = {0.45f, 0.3f, 0.15f, 0.1f};
            PdfPTable tabela = new PdfPTable(colsWidth);

            tabela.setWidthPercentage(90);

            PdfPCell cln1 = new PdfPCell(new Paragraph("NOME", SEGOEUI));
            PdfPCell cln3 = new PdfPCell(new Paragraph("ENDEREÇO", SEGOEUI));
            PdfPCell cln4 = new PdfPCell(new Paragraph("CONTACTOS", SEGOEUI));
            PdfPCell cln5 = new PdfPCell(new Paragraph("PACOTE", SEGOEUI));
            cln1.setHorizontalAlignment(1);
            cln3.setHorizontalAlignment(1);
            cln4.setHorizontalAlignment(1);
            cln5.setHorizontalAlignment(1);
            cln1.setVerticalAlignment(1);
            cln3.setVerticalAlignment(1);
            cln4.setVerticalAlignment(1);
            cln5.setVerticalAlignment(1);

            tabela.addCell(cln1);
            tabela.addCell(cln3);
            tabela.addCell(cln4);
            tabela.addCell(cln5);

            for (ClientesOBJ cliente : clientes) {
                cln1 = new PdfPCell(new Paragraph(cliente.getNome().toUpperCase(), SEGOEUI));
                cln3 = new PdfPCell(new Paragraph(cliente.getEndereço().toLowerCase(), SEGOEUI));
                cln4 = new PdfPCell(new Paragraph(cliente.getTelefone().toUpperCase(), SEGOEUI));
                cln5 = new PdfPCell(new Paragraph(cliente.getPacote() + "", SEGOEUI));
                cln1.setVerticalAlignment(1);
                cln3.setVerticalAlignment(1);
                cln4.setVerticalAlignment(1);
                cln5.setVerticalAlignment(1);
                tabela.addCell(cln1);
                tabela.addCell(cln3);
                tabela.addCell(cln4);
                tabela.addCell(cln5);
            }

            doc.add(tabela);

            doc.close();

            Desktop.getDesktop().open(new File(Arq1));
            RegistrarLogs(tecnico, "IMPRIMIU UM DOCUMENTO COM TODOS CLIENTES DESATIVADOS ");
            return true;
        } catch (DocumentException | IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Imprimir Clientes Desativados! \nErro: " + e);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    /*  IMPRIME UM DOCUMENTO EM PDF COM A FICHA GERAL DE TODOS CLIENTES REGISTRADOS NO SISTEMA     */
    public boolean ImprimirFichaGeral(String tecnico) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Document doc = new Document(PageSize.A4, 72, 31, 72, 72);
        String Arq1 = "Clientes_Allcenter.pdf";
        try {
            BaseFont baseFont = BaseFont.createFont(SegoeUI, BaseFont.WINANSI, BaseFont.EMBEDDED);
            BaseFont baseFontB = BaseFont.createFont(SegoeUIB, BaseFont.WINANSI, BaseFont.EMBEDDED);

            Font SEGOEUI = new Font(baseFont, 12);
            Font SEGOEUI_T = new Font(baseFontB, 14);
            Font SEGOEUI_C = new Font(baseFont, 16);
            Font SEGOEUI_M = new Font(baseFont, 13);

            con = Conexao.conectar();
            PdfWriter.getInstance(doc, new FileOutputStream(Arq1));
            doc.setMarginMirroring(true);
            doc.open();
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            Paragraph p = new Paragraph("DOCUMENTO DETALHADO COM TODOS CLIENTES", SEGOEUI_C);
            p.setAlignment(1);
            doc.add(p);
            doc.newPage();
            List<ClientesOBJ> clientes = Todos();
            int i = 1;
            for (ClientesOBJ cliente : clientes) {

                p = new Paragraph(cliente.getNome(), SEGOEUI_T);
                p.setAlignment(1);
                doc.add(p);

                doc.add(new Paragraph(" "));
                doc.add(new Paragraph("NACIONALIDADE: " + cliente.getNacionalidade(), SEGOEUI));
                doc.add(new Paragraph("CÓDIGO DO DOCUMENTO (BI OU PASSAPORTE): " + cliente.getBI(), SEGOEUI));
                doc.add(new Paragraph("CONTACTOS: " + cliente.getTelefone(), SEGOEUI));
                doc.add(new Paragraph("E-MAIL: " + cliente.getEmail(), SEGOEUI));
                doc.add(new Paragraph("ENDEREÇO: " + cliente.getEndereço(), SEGOEUI));
                doc.add(new Paragraph(" "));
                doc.add(new Paragraph(" "));

                p = new Paragraph("DETALHES TÉCNICOS", SEGOEUI_M);
                p.setAlignment(1);
                doc.add(p);

                doc.add(new Paragraph(" "));
                doc.add(new Paragraph("SERVIÇO: " + cliente.getServiço(), SEGOEUI));
                doc.add(new Paragraph("PACOTE: " + cliente.getPacote(), SEGOEUI));
                doc.add(new Paragraph("DIA DE PAGAMENTO: " + cliente.getDiaPagamento(), SEGOEUI));
                doc.add(new Paragraph("GPON: " + cliente.getGPON(), SEGOEUI));
                doc.add(new Paragraph("VLAN: " + cliente.getVlan(), SEGOEUI));
                doc.add(new Paragraph(" "));
                if (i != 2) {
                    p = new Paragraph("--------------------------------------------------------------------------------------------------------------- ");
                    p.setAlignment(1);
                    doc.add(p);
                    i++;
                } else {
                    doc.newPage();
                    i = 1;
                }
                doc.add(new Paragraph(" "));

            }
            doc.close();

            Desktop.getDesktop().open(new File(Arq1));
            RegistrarLogs(tecnico, "IMPRIMIU UM DOCUMENTO COM OS DADOS DETALHADOS DE CADA CLIENTE ");
            return true;
        } catch (DocumentException | IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Imprimir ficha geral! \nErro: " + e);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    /*  IMPRIME UM DOCUMENTO EM PDF COM O PAGAEMNTO DE TODOS CLIENTES REGISTRADOS NO SISTEMA     */
    public boolean ImprimirFichaIndividual(String tecnico) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Document doc = new Document(PageSize.A4, 72, 31, 72, 72);
        String Arq1 = "Clientes_e_seus_pagamentos.pdf";

        try {
            BaseFont baseFont = BaseFont.createFont(SegoeUI, BaseFont.WINANSI, BaseFont.EMBEDDED);
            BaseFont baseFontB = BaseFont.createFont(SegoeUIB, BaseFont.WINANSI, BaseFont.EMBEDDED);

            Font SEGOEUI = new Font(baseFont, 12);
            Font SEGOEUI_T = new Font(baseFontB, 14);
            Font SEGOEUI_C = new Font(baseFont, 16);
            Font SEGOEUI_M = new Font(baseFont, 13);

            con = Conexao.conectar();
            PdfWriter.getInstance(doc, new FileOutputStream(Arq1));
            doc.setMarginMirroring(true);
            doc.open();

            List<ClientesOBJ> Clientes = Todos();

            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            Paragraph p = new Paragraph("DOCUMENTO COM FICHA INDIVIDUAL DE PAGAMENTO FEITO", SEGOEUI_C);
            p.setAlignment(1);
            doc.add(p);
            doc.newPage();
            List<MesesOBJ> meses = TodosMeses();

            for (ClientesOBJ Cliente : Clientes) {

                List<PagamentoOBJ> pgm = PagamentosFeitos(Cliente.getId());

                if (!pgm.isEmpty()) {
                    p = new Paragraph(Cliente.getNome(), SEGOEUI_T);
                    p.setAlignment(1);
                    doc.add(p);
                    doc.add(new Paragraph(" "));

                    for (PagamentoOBJ pagamento : pgm) {

                        for (MesesOBJ mes : meses) {
                            if (pagamento.getIdMes() == mes.getId()) {
                                p = new Paragraph(mes.getNome() + " DE " + pagamento.getAno(), SEGOEUI);
                            }
                        }
                        doc.add(p);
                    }
                }

                doc.newPage();

            }

            doc.close();
            Desktop.getDesktop().open(new File(Arq1));
            RegistrarLogs(tecnico, "IMPRIMIU UM DOCUMENTO COM OS PAGAMENTOS INDIVIDUAIS DE CADA CLIENTE ");
            return true;
        } catch (DocumentException | IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Imprimir ficha de pagamentos Individual! \nErro: " + e);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    /*       CODIFICAÇÃO DO ESTOQUE       */
    //  ADICIONAR FORNECEDOR NO SISTEMA
    public boolean RegistrarFornecedor(String tecnico, FornecedoresOBJ fornecedor) {
        Connection con = null;
        PreparedStatement pstm = null;
        String sql = "insert into fornecedores(nome,contactos, endereco,bancaria,IBAN) values(?,?,?,?,?)";
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, fornecedor.getNome());
            pstm.setString(2, fornecedor.getContacto());
            pstm.setString(3, fornecedor.getEndereço());
            pstm.setString(4, fornecedor.getConta());
            pstm.setString(5, fornecedor.getIBAN());
            pstm.execute();
            RegistrarLogs(tecnico, "REGISTROU UM FORNECEDOR NOVO ");
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Registrar Fornecedor! \nErro: " + e);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm);
        }

    }

    public boolean AtualizarFornecedor(String tecnico, FornecedoresOBJ fornecedor) {
        Connection con = null;
        PreparedStatement pstm = null;
        String sql = "update fornecedores set nome = ?, contactos = ?, endereco = ?, bancaria = ?, IBAN = ? where id = '" + fornecedor.getId() + "'";
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, fornecedor.getNome());
            pstm.setString(2, fornecedor.getContacto());
            pstm.setString(3, fornecedor.getEndereço());
            pstm.setString(4, fornecedor.getConta());
            pstm.setString(5, fornecedor.getIBAN());
            pstm.executeUpdate();
            RegistrarLogs(tecnico, "ATUALIZOU OS DADOS DO FORNECEDOR " + fornecedor.getNome().toUpperCase());
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar Fornecedor! \nErro: " + e);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm);
        }

    }

    //      TODOS FORNECEDORES
    public List<FornecedoresOBJ> TodosFornecedor() {

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from fornecedores";
        List<FornecedoresOBJ> fornecedores = null;
        fornecedores = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                fornecedores.add(new FornecedoresOBJ(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("contactos"),
                        rs.getString("endereco"),
                        rs.getString("bancaria"),
                        rs.getString("IBAN")
                ));
            }
            return fornecedores;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Fornecedor pelo ID! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }

    }

    //      BUSCAR FORNECEDOR PELO ID
    public FornecedoresOBJ BuscaFornecedor(int idFornecedor) {

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from fornecedores where id = ?";
        FornecedoresOBJ fornecedor = null;
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, idFornecedor);
            rs = pstm.executeQuery();
            while (rs.next()) {
                fornecedor = new FornecedoresOBJ(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("contactos"),
                        rs.getString("endereco"),
                        rs.getString("bancaria"),
                        rs.getString("IBAN")
                );
            }
            return fornecedor;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Fornecedor pelo ID! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }

    }

    //     BUSCAR ID DO FORNECEDOR
    public int IdFornecedor(FornecedoresOBJ fornecedor) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select id from fornecedores where (nome like '%" + fornecedor.getNome() + "%' && endereco like '%" + fornecedor.getEndereço() + "%') && (bancaria like '%" + fornecedor.getConta() + "%' && IBAN like '%" + fornecedor.getIBAN() + "%')";
        try {
            int id = 0;
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
            }
            return id;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar ID do Fornecedor! \nErro: " + e);
            return 0;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public String IbanFornecedor() {
        return "";
    }

    public boolean ExcluirFornecedor(String tecnico, int id) {
        Connection con = null;
        PreparedStatement pstm = null;
        String sql = "delete from fornecedores where id = " + id;
        try {
            RegistrarLogs(tecnico, "EXCLUIU O FORNECEDOR FORNECEDOR: " + BuscaFornecedor(id).getNome().toUpperCase());
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir Equipamento! \nErro: " + e);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm);
        }
    }

    public boolean RegistrarEquipamento(String tecnico, EquipamentoOBJ equipamento) {
        Connection con = null;
        PreparedStatement pstm = null;
        String sql = "insert into stoque(nome,modelo,quantidade, preco,fornecedor) values(?,?,?,?,?)";
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, equipamento.getNome());
            pstm.setString(2, equipamento.getModelo());
            pstm.setString(3, "" + equipamento.getQtd());
            pstm.setString(4, "" + equipamento.getPreço());
            pstm.setString(5, equipamento.getFornecedor());
            pstm.execute();
            RegistrarLogs(tecnico, "REGISTROU UM EQUIPAMENTO NOVO ");
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Registrar Equipamento! \nErro: " + e);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm);
        }
    }

    public boolean AtualizarEquipamento(String tecnico, EquipamentoOBJ equipamento) {
        Connection con = null;
        PreparedStatement pstm = null;
        String sql = "update stoque set nome = ?, modelo = ?, preco = ?,fornecedor = ? where id = " + equipamento.getId();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, equipamento.getNome());
            pstm.setString(2, equipamento.getModelo());
            pstm.setString(3, "" + equipamento.getPreço());
            pstm.setString(4, equipamento.getFornecedor());
            pstm.executeUpdate();
            RegistrarLogs(tecnico, "ATUALIZOU O EQUIPAMENTO CONHECIDO COMO: " + equipamento.getNome());
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar Equipamento! \nErro: " + e);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm);
        }
    }

    public EquipamentoOBJ BuscaEquipamento(int id) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from stoque where id = ?";
        EquipamentoOBJ fornecedor = null;
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                fornecedor = new EquipamentoOBJ(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("modelo"),
                        rs.getInt("quantidade"),
                        rs.getFloat("preco"),
                        rs.getString("fornecedor")
                );
            }
            return fornecedor;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Equipamento pelo ID! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public List<EquipamentoOBJ> BuscaEquipamento(String chave) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from stoque where (nome like '%" + chave + "%') or (modelo like '%" + chave + "%') or (fornecedor like '%" + chave + "%') or (preco like '%" + chave + "%') or (quantidade like '%" + chave + "%')";
        List<EquipamentoOBJ> fornecedor = null;
        fornecedor = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                fornecedor.add(new EquipamentoOBJ(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("modelo"),
                        rs.getInt("quantidade"),
                        rs.getFloat("preco"),
                        rs.getString("fornecedor")
                ));
            }
            return fornecedor;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Equipamento pelo nome! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public List<EquipamentoOBJ> TodosEquipamentos() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from stoque ";
        List<EquipamentoOBJ> fornecedor = null;
        fornecedor = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                fornecedor.add(new EquipamentoOBJ(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("modelo"),
                        rs.getInt("quantidade"),
                        rs.getFloat("preco"),
                        rs.getString("fornecedor")
                ));
            }
            return fornecedor;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Equipamento pelo nome! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public boolean AddEquipamento(String tecnico, int id, int qtd) {
        Connection con = null;
        PreparedStatement pstm = null;
        String sql = "update stoque set quantidade = ? where id = " + id;
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, qtd);
            pstm.executeUpdate();
            RegistrarLogs(tecnico, "ATUALIZOU A QUANTIDADE DO EQUIPAMENTO: " + BuscaEquipamento(id).getNome() + " PARA: " + qtd);
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar Equipamento! \nErro: " + e);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm);
        }
    }

    //     APAGAR DO SISTEMA UM EQUIPAMENTO
    public boolean ExcluirEquipamento(String tecnico, int id) {
        Connection con = null;
        PreparedStatement pstm = null;
        String sql = "delete from stoque where id = " + id;
        try {
            RegistrarLogs(tecnico, "ELIMINOU O EQUIPAMENTO DE NOME:  " + BuscaEquipamento(id).getNome().toUpperCase());
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir Equipamento! \nErro: " + e);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm);
        }
    }

    public boolean RegistrarLogs(String usuario, String ação) {

        Connection con = null;
        PreparedStatement pstm = null;
        String sql = "insert into todoslogs(autor,descricao,momento) values (?,?,?)";
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, usuario);
            pstm.setString(2, ação);
            pstm.setString(3, HoraServidor());
            pstm.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Registrar Log! \nErro: " + e);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm);
        }
    }

    public List<LogsOBJ> HistoricoGlobal() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from todoslogs ";
        List<LogsOBJ> logs = null;
        logs = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                logs.add(new LogsOBJ(rs.getInt("id"), rs.getString("autor"), rs.getString("descricao"), rs.getString("momento")));
            }
            return logs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Historico Global! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public List<LogsOBJ> BuscaHistoricoGlobalDetalhado(String chave) {
        String sql = "SELECT * FROM todoslogs where ((id like '%" + chave + "%' or autor like '%" + chave + "%') or (momento like '%" + chave + "%' or descricao like '%" + chave + "%') )";
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<LogsOBJ> historico;
        historico = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                LogsOBJ hist = new LogsOBJ(
                        rs.getInt("id"),
                        rs.getString("autor"),
                        rs.getString("descricao"),
                        rs.getString("momento"));
                historico.add(hist);
            }

            return historico;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar os meses na BD! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    /*  REGISTRAR CATEGORIAS E SEU SALARIOS, INCLUINDO OS IMPOSTOS     */
    public boolean RegistrarSalário(String usuario, SalarioOBJ salario) {

        Connection con = null;
        PreparedStatement pstm = null;
        String sql = "insert into salario(categoria,valor,IRT,INSS,subsidio) values (?,?,?,?,?)";
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setString(2, salario.getCategoria());
            pstm.setString(1, salario.getValor());
            pstm.setString(3, salario.getIRT());
            pstm.setString(4, salario.getINSS());
            pstm.setString(5, salario.getSubsidio());
            pstm.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Registrar Salario e Categoria! \nErro: " + e);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm);
        }
    }

    public List<SalarioOBJ> Salarios() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from salario";
        List<SalarioOBJ> salario = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                salario.add(new SalarioOBJ(
                        rs.getInt("id"),
                        rs.getString("categoria"),
                        rs.getString("valor"),
                        rs.getString("INSS"),
                        rs.getString("IRT"),
                        rs.getString("subsidio"),
                        rs.getString("moeda")));
            }
            return salario;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Salario e Categoria! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public SalarioOBJ ObterSalario(int id) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from salario where id = ?";
        SalarioOBJ salario = new SalarioOBJ();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                salario = (new SalarioOBJ(
                        rs.getInt("id"),
                        rs.getString("categoria"),
                        rs.getString("valor"),
                        rs.getString("INSS"),
                        rs.getString("IRT"),
                        rs.getString("subsidio"),
                        rs.getString("moeda")));
            }
            return salario;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Salario e Categoria! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public SalarioOBJ ObterSalario(String chave) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from salario where categoria = ?";
        SalarioOBJ salario = new SalarioOBJ();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, chave);
            rs = pstm.executeQuery();
            while (rs.next()) {
                salario = (new SalarioOBJ(
                        rs.getInt("id"),
                        rs.getString("categoria"),
                        rs.getString("valor"),
                        rs.getString("INSS"),
                        rs.getString("IRT"),
                        rs.getString("subsidio"),
                        rs.getString("moeda")));
            }
            return salario;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Salario e Categoria! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public String getCategoria(int id) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select categoria from salario where id = ?";
        String dado = "SEM CORRESPONDÊNCIA";
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                dado = rs.getString(1);
            }
            return dado;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Categoria! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public int getIdCategoria(String chave) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select id from salario where categoria like '%" + chave + "%'";
        int dado = 0;
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                dado = rs.getInt("id");
            }
            return dado;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Id da Categoria! \nErro: " + e);
            return -1;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public String getINSS(int id) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select INSS from salario where id = ?";
        String dado = "SEM CORRESPONDÊNCIA";
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                dado = rs.getString(1);
            }
            return dado;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar INSS! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public String getIRT(int id) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select IRT from salario where id = ?";
        String dado = "SEM CORRESPONDÊNCIA";
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                dado = rs.getString(1);
            }
            return dado;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar IRT! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public String getSubsidio(int id) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select subsidio from salario where id = ?";
        String dado = "SEM CORRESPONDÊNCIA";
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                dado = rs.getString(1);
            }
            return dado;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Subsidio! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public String getValorSalario(int id) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select valor from salario where id = ?";
        String dado = "SEM CORRESPONDÊNCIA";
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                dado = rs.getString(1);
            }
            return dado;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Valor do Salário! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public boolean RegistrarFolhaDeSalario(String Usuario, FolhaOBJ folha) {
        Connection con = null;
        PreparedStatement pstm = null;
        String sql = "insert into folha(nome,idSalario, idMes, ano) values (?,?,?,?)";
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, folha.getNome());
            pstm.setInt(2, folha.getIdSalario());
            pstm.setInt(3, folha.getIdMes());
            pstm.setString(4, folha.getAno());
            pstm.execute();
            RegistrarLogs(Usuario, "REGISTROU UMA FOLHA SALARIAL REFERENTE AOS MES " + folha.getIdMes());
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar folha de Salário! \nErro: " + e);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm);
        }
    }

    public List<FolhaOBJ> Folhas() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<FolhaOBJ> folha = new ArrayList<>();
        String sql = "select * from folha";
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                FolhaOBJ temp = new FolhaOBJ(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("idSalario"),
                        rs.getInt("idMes"),
                        rs.getString("ano"));
                folha.add(temp);
            }
            return folha;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar folhas de Salário! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }

    }

    public List<MesesOBJ> FolhasMeses(int ano) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<MesesOBJ> folha = new ArrayList<>();
        String sqlMes = "select meses.id, meses.nome, folha.ano from folha "
                + "join meses on folha.`idMes` = meses.id "
                + "where folha.ano = " + ano + " "
                + "group BY folha.`idMes`";

        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sqlMes);
            rs = pstm.executeQuery();
            while (rs.next()) {
                MesesOBJ temp = new MesesOBJ(rs.getInt("meses.id"), rs.getString("meses.nome"));
                folha.add(temp);
            }
            return folha;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar folhas de Salário por Mês! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public List<FolhaOBJ> FolhasAno() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<FolhaOBJ> folha = new ArrayList<>();
        String sqlAno = "select * from folha where ano = year(now())";
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sqlAno);
            rs = pstm.executeQuery();
            while (rs.next()) {
                FolhaOBJ temp = new FolhaOBJ(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("idSalario"),
                        rs.getInt("idMes"),
                        rs.getString("ano"));
                folha.add(temp);
            }
            return folha;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro - Salário por Ano! \nErro: " + e.toString());
            System.out.println(e.toString());
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public int getIdFolha(int mes, String ano) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select id from folha where idMes = ? && ano = ?";
        int dado = 0;
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, mes);
            pstm.setString(2, ano);
            rs = pstm.executeQuery();
            while (rs.next()) {
                dado = rs.getInt(1);
            }
            return dado;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Id da folha de Salário! \nErro: " + e);
            return 0;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public int ConfirmaFolha(FolhaOBJ folha) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select id from folha where idMes = ? && ano = ?";
        int dado = 0;
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, folha.getIdMes());
            pstm.setString(2, folha.getAno());
            rs = pstm.executeQuery();
            while (rs.next()) {
                dado = rs.getInt(1);
            }
            return dado;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Id da folha de Salário! \nErro: " + e);
            return 0;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public List<FolhaExtensaOBJ> FolhasAgora(String ano, String idMes) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<FolhaExtensaOBJ> folha = new ArrayList<>();
        String sqlAno = "select "
                + "folha.nome, salario.categoria, meses.nome,salario.valor,salario.IRT, salario.INSS, salario.subsidio, folha.ano "
                + "from folha "
                + "join salario on folha.idSalario = salario.id "
                + "join meses on folha.idMes=meses.id where meses.id = '" + idMes + "' && folha.ano = '" + ano + "'";
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sqlAno);
            rs = pstm.executeQuery();
            while (rs.next()) {
                FolhaExtensaOBJ temp = new FolhaExtensaOBJ(
                        rs.getString("folha.nome"),
                        rs.getString("salario.categoria"),
                        rs.getString("meses.nome"),
                        rs.getString("salario.valor"),
                        rs.getString("salario.IRT"),
                        rs.getString("salario.INSS"),
                        rs.getString("salario.subsidio"));
                folha.add(temp);
            }
            return folha;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar folhas de Salário  Do excto Mes! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public List<PacoteOBJ> Pacotes() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from pacotes";
        List<PacoteOBJ> pac = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                pac.add(
                        new PacoteOBJ(
                                rs.getInt("id"),
                                rs.getString("nome"),
                                rs.getString("preco")
                        ));
            }
            return pac;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Pacotes! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public int getIdPacote(String chave) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select id from pacotes where nome = ?";
        int id = 0;
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, chave);
            rs = pstm.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
            }
            return id;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Pacotes! \nErro: " + e);
            return 0;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public String getPreçoPacote(int id) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select preco from pacotes where id = ?";
        String preço = "0";
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                preço = rs.getString("preco");
            }
            return preço;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar preço Pacotes! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public String getPreçoPacote(String chave) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select preco from pacotes where nome = ?";
        String preço = "0";
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, chave);
            rs = pstm.executeQuery();
            while (rs.next()) {
                preço = rs.getString("preco");
            }
            return preço;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar preço Pacotes! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public String getNomePacote(int id) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select nome from pacotes where preco = ?";
        String preço = "0";
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                preço = rs.getString("nome");
            }
            return preço;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar nome Pacotes! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public String getNomePacote(String chave) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select nome from pacotes where preco = ?";
        String preço = "0";
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, chave);
            rs = pstm.executeQuery();
            while (rs.next()) {
                preço = rs.getString("nome");
            }
            return preço;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar nome Pacotes! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public PacoteOBJ getPacote(String chave) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from pacotes where nome = ?";
        PacoteOBJ preço = null;
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, chave);
            rs = pstm.executeQuery();
            while (rs.next()) {
                preço = new PacoteOBJ(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("preco")
                );
            }
            return preço;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar nome Pacotes! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public PacoteOBJ getPacote(int id) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from pacotes where id = ?";
        PacoteOBJ preço = null;
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                preço = new PacoteOBJ(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("preco")
                );
            }
            return preço;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar nome Pacotes! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public boolean RegistarDespesa(String Usuario, NotaDeDespesaOBJ despesa) {
        Connection con = null;
        PreparedStatement pstm = null;
        String sql = "insert into saidas(idDespesa, descricao, beneficiario, valor, idMes,ano,dia,hora) value (?,?,?,?,?,?,?,?)";

        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, despesa.getIdDespesa());
            pstm.setString(2, despesa.getDescrição());
            pstm.setString(3, despesa.getBeneficiario());
            pstm.setString(4, despesa.getValor());
            pstm.setInt(5, MesServidor());
            pstm.setInt(6, AnoServidor());
            pstm.setInt(7, DiaServidor());
            pstm.setTime(8, TempoServidor());
            pstm.execute();
            RegistrarLogs(Usuario, "REGISTROU UMA SAÍDA");
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar despesa! \nErro: " + e);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm);
        }
    }

    public List<NotaDeDespesaOBJ> TodasDespesas() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from saidas";
        List<NotaDeDespesaOBJ> despesa = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                despesa.add(new NotaDeDespesaOBJ(
                        rs.getInt("id"),
                        rs.getString("descricao"),
                        rs.getString("beneficiario"),
                        rs.getInt("idDespesa"),
                        rs.getString("valor"),
                        rs.getInt("dia"),
                        rs.getInt("idMes"),
                        rs.getInt("ano"),
                        rs.getTime("hora").toString()
                ));
            }
            return despesa;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar ID da despesa! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public List<NotaDeDespesaOBJ> BuscaDespesas(String chave) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from saidas where idMes = '" + chave + "' or beneficiario like '%" + chave + "%' or descricao like '%" + chave + "%'";
        List<NotaDeDespesaOBJ> despesa = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                despesa.add(new NotaDeDespesaOBJ(
                        rs.getInt("id"),
                        rs.getString("descricao"),
                        rs.getString("beneficiario"),
                        rs.getInt("idDespesa"),
                        rs.getString("valor"),
                        rs.getInt("dia"),
                        rs.getInt("idMes"),
                        rs.getInt("ano"),
                        rs.getTime("hora").toString()
                ));
            }
            return despesa;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Despesas do Mes: " + chave + "! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public List<NotaDeDespesaOBJ> TodasDespesasMes(String chave) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from saidas where idMes = " + chave + "";
        List<NotaDeDespesaOBJ> despesa = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                despesa.add(new NotaDeDespesaOBJ(
                        rs.getInt("id"),
                        rs.getString("descricao"),
                        rs.getString("beneficiario"),
                        rs.getInt("idDespesa"),
                        rs.getString("valor"),
                        rs.getInt("dia"),
                        rs.getInt("idMes"),
                        rs.getInt("ano"),
                        rs.getTime("hora").toString()
                ));
            }
            return despesa;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Despesas do Mes: " + chave + "! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public NotaDeDespesaOBJ getDespesa(int id) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from saidas where id = ?";
        NotaDeDespesaOBJ despesa = null;
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                despesa = new NotaDeDespesaOBJ(
                        rs.getInt("id"),
                        rs.getString("descricao"),
                        rs.getString("beneficiario"),
                        rs.getInt("idDespesa"),
                        rs.getString("valor"),
                        rs.getInt("dia"),
                        rs.getInt("idMes"),
                        rs.getInt("ano"),
                        rs.getTime("hora").toString()
                );
            }
            return despesa;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar ID da despesa! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public int getIdDespesa(String chave) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select id from despesa where nome = ?";
        int id = 0;
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, chave);
            rs = pstm.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
            }
            return id;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar ID da despesa! \nErro: " + e);
            return 0;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public String getNomeDespesa(int id) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select nome from despesa where id = ?";
        String dado = "";
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                dado = rs.getString("nome");
            }
            return dado;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Nome da despesa! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public boolean RegistrarTipoDeDespesa(String Usuario, String Despesa) {
        Connection con = null;
        PreparedStatement pstm = null;
        String sql = "insert into despesa(nome) value (?)";

        try {
            con = Conexao.conectar();
            RegistrarLogs(Usuario, "REGISTROU UMA NOVA DESPESA: " + Despesa);
            pstm = con.prepareStatement(sql);
            pstm.setString(1, Despesa);
            return pstm.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar tipo de despesa! \nErro: " + e);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm);
        }
    }

    public List<TipoDeDespesaOBJ> TiposDeDespesas() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from despesa";
        List<TipoDeDespesaOBJ> despesa = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                despesa.add(new TipoDeDespesaOBJ(
                        rs.getInt("id"),
                        rs.getString("nome")
                ));
            }
            return despesa;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar nome Pacotes! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public List<FechoDeContasOBJ> SaidasMensais() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select meses.nome, sum(saidas.valor) "
                + "from saidas join meses on saidas.`idMes` = meses.id "
                + "where saidas.ano = year(now()) group by meses.id";
        List<FechoDeContasOBJ> fecho = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                fecho.add(new FechoDeContasOBJ(0,
                        AnoServidor(),
                        rs.getString("meses.nome"),
                        0,
                        rs.getDouble("sum(saidas.valor)")));
            }
            return fecho;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar saidas Mensais! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public List<FechoDeContasOBJ> SaidasPorAno(String Chave) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select saidas.ano, meses.nome, sum(saidas.valor) "
                + "from saidas join meses on saidas.`idMes` = meses.id "
                + "where saidas.idMes = '" + Chave + "' or meses.nome like '%" + Chave + "%' or saidas.ano ='" + Chave + "'";
        List<FechoDeContasOBJ> fecho = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            if (!rs.next()) {
                fecho.add(new FechoDeContasOBJ(0, AnoServidor(), getNomeMes(MesServidor()), 0, 0));
            }
            while (rs.next()) {
                fecho.add(new FechoDeContasOBJ(0,
                        rs.getInt("saidas.ano"),
                        rs.getString("meses.nome"),
                        0,
                        rs.getDouble("sum(saidas.valor)")));
            }

            return fecho;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Fecho de Contas Anual! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public List<SaidasPoDiaOBJ> SaidasPorDia() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select saidas.ano, meses.nome, sum(saidas.valor), saidas.descricao,saidas.dia, saidas.hora "
                + "from saidas join meses on saidas.`idMes` = meses.id "
                + "group by saidas.dia desc";
        List<SaidasPoDiaOBJ> despesa = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            if (!rs.next()) {
                despesa.add(new SaidasPoDiaOBJ(AnoServidor(), DiaServidor(), getNomeMes(MesServidor()), "", "SEM VALOR", 0, HoraServidor()));
            }
            while (rs.next()) {
                despesa.add(new SaidasPoDiaOBJ(
                        rs.getInt("saidas.ano"),
                        rs.getInt("saidas.dia"),
                        rs.getString("meses.nome"),
                        "Sem descrição",
                        rs.getString("saidas.descricao"),
                        rs.getDouble("sum(saidas.valor)"),
                        rs.getTime("saidas.hora").toString()));
            }

            return despesa;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Saídas por dia! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public List<SaidasPoDiaOBJ> SaidasPorDia(int mes, int ano) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select saidas.ano, meses.nome,saidas.beneficiario, saidas.valor, saidas.descricao,saidas.dia, saidas.hora "
                + "from saidas join meses on saidas.`idMes` = meses.id where saidas.idMes = ? and saidas.ano = ? order by dia asc";
        List<SaidasPoDiaOBJ> despesa = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, mes);
            pstm.setInt(2, ano);
            rs = pstm.executeQuery();
            while (rs.next()) {
                despesa.add(new SaidasPoDiaOBJ(
                        rs.getInt("saidas.ano"),
                        rs.getInt("saidas.dia"),
                        rs.getString("meses.nome"),
                        rs.getString("saidas.beneficiario"),
                        rs.getString("saidas.descricao"),
                        rs.getDouble("saidas.valor"),
                        rs.getTime("saidas.hora").toString()));
            }

            return despesa;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Saídas por dia! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public List<SaidasPoDiaOBJ> SaidasPorDiaEspecifico(int dia, String mes, int ano) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select saidas.ano, meses.nome, saidas.valor,saidas.beneficiario, saidas.descricao,saidas.dia, saidas.hora "
                + "from saidas join meses on saidas.`idMes` = meses.id where saidas.dia = ? and meses.nome = ? and saidas.ano = ?"
                + "order by saidas.hora asc";
        List<SaidasPoDiaOBJ> despesa = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, dia);
            pstm.setString(2, mes);
            pstm.setInt(1, 3);
            rs = pstm.executeQuery();
            if (!rs.next()) {
                despesa.add(new SaidasPoDiaOBJ(AnoServidor(), DiaServidor(), getNomeMes(MesServidor()), "", "SEM VALOR", 0, HoraServidor()));
            }
            while (rs.next()) {
                despesa.add(new SaidasPoDiaOBJ(
                        rs.getInt("saidas.ano"),
                        rs.getInt("saidas.dia"),
                        rs.getString("meses.nome"),
                        rs.getString("saidas.beneficiario"),
                        rs.getString("saidas.descricao"),
                        rs.getDouble("saidas.valor"),
                        rs.getTime("saidas.hora").toString()));
            }

            return despesa;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Saídas por dia! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public List<FechoDeContasOBJ> EntradasPorAno() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select pagamento.ano, sum(pacotes.preco) from pagamento "
                + "	join meses on pagamento.idMes = meses.id"
                + "	join clientes on pagamento.idCliente = clientes.id "
                + "	join pacotes on clientes.pacote = pacotes.id "
                + "	GROUP by ano";
        List<FechoDeContasOBJ> fecho = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                fecho.add(new FechoDeContasOBJ(0,
                        rs.getInt("pagamento.ano"),
                        "",
                        rs.getDouble("sum(pacotes.preco)"),
                        0));
            }
            return fecho;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Fecho de Contas Anual! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public List<FechoDeContasOBJ> EntradaPorMes() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select meses.nome, sum(pacotes.preco) from pagamento "
                + "	join meses on pagamento.idMes = meses.id "
                + "	join clientes on pagamento.idCliente = clientes.id "
                + "	join pacotes on clientes.pacote = pacotes.id where ano = year(now()) "
                + "	GROUP BY idMes "
                + "ORDER BY pagamento.`idMes` asc";
        List<FechoDeContasOBJ> fecho = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                fecho.add(new FechoDeContasOBJ(0,
                        AnoServidor(),
                        rs.getString("meses.nome"),
                        rs.getDouble("sum(pacotes.preco)"),
                        0));
            }
            return fecho;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Fecho de Contas Anual! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public List<FechoDeContasOBJ> EntradaPorMes(int ano) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select meses.nome, sum(pacotes.preco) from pagamento "
                + "join meses on pagamento.idMes = meses.id "
                + "	join clientes on pagamento.idCliente = clientes.id "
                + "	join pacotes on clientes.pacote = pacotes.id where pagamento.ano ='" + ano + "'"
                + "	GROUP BY idMes"
                + " order by ano asc";
        List<FechoDeContasOBJ> fecho = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                fecho.add(new FechoDeContasOBJ(0,
                        ano,
                        rs.getString("meses.nome"),
                        rs.getDouble("sum(pacotes.preco)"),
                        0));
            }
            return fecho;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Fecho de Contas Anual! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public List<FechoDeContasOBJ> EntradaPorMesEspecifico(String Mes, int ano) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select clientes.nome, pacotes.preco from pagamento "
                + "join meses on pagamento.idMes = meses.id "
                + "	join clientes on pagamento.idCliente = clientes.id "
                + "	join pacotes on clientes.pacote = pacotes.id "
                + "where meses.nome like '%" + Mes + "%' and pagamento.ano ='" + ano + "' "
                + "order by clientes.nome";
        List<FechoDeContasOBJ> fecho = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                fecho.add(new FechoDeContasOBJ(0,
                        ano,
                        rs.getString("clientes.nome"),
                        rs.getDouble("pacotes.preco"),
                        0));
            }
            return fecho;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Fecho de Contas Anual! \nErro: " + e);
            return null;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public boolean FecharContas(List<FechoDeContasOBJ> contas) {
        Connection con = null;
        PreparedStatement pstm = null;
        String sql = "insert into fechoDeContas(ano, mes, entrada, saida) value (?,?,?,?)";

        try {
            con = Conexao.conectar();
            for (FechoDeContasOBJ conta : contas) {
                pstm = con.prepareStatement(sql);
                pstm.setInt(1, conta.getAno());
                pstm.setString(2, conta.getMes());
                pstm.setDouble(3, conta.getEntrada());
                pstm.setDouble(4, conta.getSaida());
                pstm.execute();
            }
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Adicionar Fecho de Contas! \nErro: " + e);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm);
        }
    }

    public boolean AtualizarFechoDeContas(List<FechoDeContasOBJ> contas) {
        Connection con = null;
        PreparedStatement pstm = null;
        String sql = "update fechoDeContas set saida = ? where mes = ? and ano = ?";

        try {
            con = Conexao.conectar();
            for (FechoDeContasOBJ conta : contas) {
                pstm = con.prepareStatement(sql);
                pstm.setDouble(1, conta.getSaida());
                pstm.setString(2, conta.getMes());
                pstm.setInt(3, conta.getAno());
                pstm.executeUpdate();
            }
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar as Saídas Fecho de Contas! \nErro: " + e);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm);
        }
    }

    public double DeveriaEntrar() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select sum(pacotes.preco) from pacotes join clientes on clientes.pacote = pacotes.id";
        double entrar = 0;
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                entrar = rs.getDouble("sum(pacotes.preco)");
            }
            return entrar;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Receitas que Deveriam entrar! \nErro: " + e);
            return 0;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public double DeveriaEntrarAtivos() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select sum(pacotes.preco) from pacotes join clientes on clientes.pacote = pacotes.id where clientes.informacao like '%activado%'";
        double entrar = 0;
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                entrar = rs.getDouble("sum(pacotes.preco)");
            }
            return entrar;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Receitas que Deveriam entrar! \nErro: " + e);
            return 0;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public double EstamosPerdendo() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select sum(pacotes.preco) from pacotes join clientes on clientes.pacote = pacotes.id where clientes.informacao like '%desativado%'";
        double entrar = 0;
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                entrar = rs.getDouble("sum(pacotes.preco)");
            }
            return entrar;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Receitas que Deveriam entrar! \nErro: " + e);
            return 0;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public List<CtoOBJ> TodosCtos() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from ctos";
        List<CtoOBJ> cto = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                cto.add(
                        new CtoOBJ(
                                rs.getInt("id"),
                                rs.getInt("idCeo"),
                                rs.getString("nome"),
                                rs.getInt("capacidade"),
                                rs.getInt("pon"),
                                rs.getInt("entrada"),
                                rs.getString("spliter")
                        )
                );
            }
            return cto;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Obter Ctos registrados! \nErro: " + e);
            return cto;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public boolean RegistrarCto(String tecnico, CtoOBJ CtoNovo) {
        Connection con = null;
        PreparedStatement pstm = null;
        String sql = "insert into ctos(idCeo,nome, capacidade, pon, spliter, entrada) value (?,?,?,?,?,?)";

        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, CtoNovo.getIdCeo());
            pstm.setString(2, CtoNovo.getNome());
            pstm.setInt(3, CtoNovo.getCapacidade());
            pstm.setInt(4, CtoNovo.getPon());
            pstm.setString(5, CtoNovo.getSpliter());
            pstm.setInt(6, CtoNovo.getEntrada());
            pstm.execute();
            RegistrarLogs(tecnico, "REGISTROU O CTO: " + CtoNovo.getNome());
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Registrar CTO! \nErro: " + e);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm);
        }
    }

    public boolean AtualizarCto(String tecnico, CtoOBJ CtoNovo) {
        Connection con = null;
        PreparedStatement pstm = null;
        String sql = "update ctos set idCeo = ?,nome = ?,capacidade = ?, pon = ?, spliter = ?, entrada = ? where id = '" + CtoNovo.getId() + "'";

        try {
            con = Conexao.conectar();
            String nome = getCTO(CtoNovo.getId()).getNome();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, CtoNovo.getIdCeo());
            pstm.setString(2, CtoNovo.getNome());
            pstm.setInt(3, CtoNovo.getCapacidade());
            pstm.setInt(4, CtoNovo.getPon());
            pstm.setString(5, CtoNovo.getSpliter());
            pstm.setInt(6, CtoNovo.getEntrada());
            pstm.execute();
            RegistrarLogs(tecnico, "ATUALIZOU O CTO: " + nome);
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar CTO! \nErro: " + e);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm);
        }
    }

    public CtoOBJ getCTO(int id) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from ctos where id = ?";
        CtoOBJ cto = new CtoOBJ();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                cto = new CtoOBJ(
                        rs.getInt("id"),
                        rs.getInt("idCeo"),
                        rs.getString("nome"),
                        rs.getInt("capacidade"),
                        rs.getInt("pon"),
                        rs.getInt("entrada"),
                        rs.getString("spliter")
                );
            }
            return cto;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Obter Ctos registrados! \nErro: " + e);
            return cto;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public List<CtoOBJ> getCTOdoCeo(int idCEO) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from ctos where idCeo = ? order by id";
        List<CtoOBJ> cto = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, idCEO);
            rs = pstm.executeQuery();
            while (rs.next()) {
                cto.add(
                        new CtoOBJ(
                                rs.getInt("id"),
                                rs.getInt("idCeo"),
                                rs.getString("nome"),
                                rs.getInt("capacidade"),
                                rs.getInt("pon"),
                                rs.getInt("entrada"),
                                rs.getString("spliter")
                        )
                );
            }
            return cto;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Obter Ctos registrados! \nErro: " + e);
            return cto;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public int EspaçoRestanteCto(int idCto) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select ctos.capacidade - count(*) as Possiveis from ctos join pc on pc.`idCto` = ctos.id where `idCto`=?";
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, idCto);
            rs = pstm.executeQuery();
            int espaco = 0;
            while (rs.next()) {
                espaco = rs.getInt(1);
            }
            return espaco;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Obter espaço do Cto registrado! \nErro: " + e);
            return 0;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public CtoOBJ getCTO(String nomeCto) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from ctos where nome like '%" + nomeCto + "%'";
        CtoOBJ cto = new CtoOBJ();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                cto = new CtoOBJ(
                        rs.getInt("id"),
                        rs.getInt("idCeo"),
                        rs.getString("nome"),
                        rs.getInt("capacidade"),
                        rs.getInt("pon"),
                        rs.getInt("entrada"),
                        rs.getString("spliter")
                );
            }
            return cto;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Obter Ctos registrados! \nErro: " + e);
            return cto;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public List<CtoOBJ> getCTOs(String chave) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from ctos where nome like '%" + chave + "%' or id = '" + chave + "'";
        List<CtoOBJ> cto = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                cto.add(new CtoOBJ(
                        rs.getInt("id"),
                        rs.getInt("idCeo"),
                        rs.getString("nome"),
                        rs.getInt("capacidade"),
                        rs.getInt("pon"),
                        rs.getInt("entrada"),
                        rs.getString("spliter")
                )
                );
            }
            return cto;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Obter Ctos registrados! \nErro: " + e);
            return cto;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public List<CeoOBJ> getCEOs(String chave) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from ceos where nome like '%" + chave + "%' or id = '" + chave + "'";
        List<CeoOBJ> ceo = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                ceo.add(
                        new CeoOBJ(
                                rs.getInt("id"),
                                rs.getString("nome"),
                                rs.getInt("entrada"),
                                rs.getInt("saida")
                        )
                );
            }
            return ceo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Obter Ctos registrados! \nErro: " + e);
            return ceo;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public boolean RegistrarCeo(String tecnico, CeoOBJ CeoNovo) {
        Connection con = null;
        PreparedStatement pstm = null;
        String sql = "insert into ceos(nome, entrada, saida) value (?,?,?)";

        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, CeoNovo.getNome());
            pstm.setInt(2, CeoNovo.getEntrada());
            pstm.setInt(3, CeoNovo.getSaida());
            pstm.execute();
            RegistrarLogs(tecnico, "REGISTROU O CEO: " + CeoNovo.getNome());
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Registrar CEO! \nErro: " + e);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm);
        }
    }

    public boolean AtualizarCeo(String tecnico, CeoOBJ CeoNovo) {
        Connection con = null;
        PreparedStatement pstm = null;
        String sql = "update ceos set nome = ?, entrada = ?, saida = ? where id = '" + CeoNovo.getId() + "'";

        try {
            String nome = getCEO(CeoNovo.getId()).getNome();
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, CeoNovo.getNome());
            pstm.setInt(2, CeoNovo.getEntrada());
            pstm.setInt(3, CeoNovo.getSaida());
            pstm.execute();
            RegistrarLogs(tecnico, "Atualizou O CEO: " + nome);
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar CEO! \nErro: " + e);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm);
        }
    }

    public boolean AddCtoCliente(int idCliente, int idCto) {
        Connection con = null;
        PreparedStatement pstm = null;
        String sql = "insert into pc(idCliente, idCto) value (?,?)";

        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, idCliente);
            pstm.setInt(2, idCto);
            pstm.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Relacionar Cto a um Cliente! \nErro: " + e);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm);
        }
    }

    public boolean AtualizarCtoCliente(int idCliente, int idCto) {
        Connection con = null;
        PreparedStatement pstm = null;
        String sql = "update pc set idCto = ? where idCliente = ?";

        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, idCto);
            pstm.setInt(2, idCliente);
            pstm.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar Relacionamento Cto a um Cliente! \nErro: " + e);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm);
        }
    }

    public boolean VerificaPC(int idCliente) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from pc where idCliente = ?";
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Verificar cliente em CTOs! \nErro: " + e);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public List<PcOBJ> ParceirosCTO() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select clientes.nome, ctos.nome, ctos.pon from pc "
                + "join clientes on clientes.id = pc.`idCliente` "
                + "join ctos on ctos.id = pc.`idCto`";
        List<PcOBJ> cto = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                cto.add(
                        new PcOBJ(
                                rs.getString("clientes.nome"),
                                rs.getString("ctos.nome"),
                                rs.getInt("ctos.pon")
                        )
                );
            }
            return cto;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Obter Ctos com clientes registrados! \nErro: " + e);
            return cto;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public List<PcOBJ> ParceirosCTO(String chave) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select clientes.nome, ctos.nome, ctos.pon from pc "
                + "join clientes on clientes.id = pc.`idCliente` "
                + "join ctos on ctos.id = pc.`idCto` "
                + "where clientes.nome like '%" + chave + "%' or ctos.nome like '%" + chave + "%'";
        List<PcOBJ> cto = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                cto.add(
                        new PcOBJ(
                                rs.getString("clientes.nome"),
                                rs.getString("ctos.nome"),
                                rs.getInt("ctos.pon")
                        )
                );
            }
            return cto;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Obter Ctos com clientes registrados! \nErro: " + e);
            return cto;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public int ObterCtoPeloCliente(int idCliente) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select pc.idCto from pc "
                + "join clientes on clientes.id = pc.`idCliente` "
                + "join ctos on ctos.id = pc.`idCto` "
                + "where clientes.id = ?";
        int cto = 0;
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, idCliente);
            rs = pstm.executeQuery();
            while (rs.next()) {
                cto = rs.getInt("pc.idCto");
            }
            return cto;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Obter Ctos com clientes registrados! \nErro: " + e);
            return cto;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public List<CeoOBJ> TodosCeos() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from ceos";
        List<CeoOBJ> cto = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                cto.add(
                        new CeoOBJ(
                                rs.getInt("id"),
                                rs.getString("nome"),
                                rs.getInt("entrada"),
                                rs.getInt("saida")
                        )
                );
            }
            return cto;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Obter Ceos registrados! \nErro: " + e);
            return cto;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public CeoOBJ getCEO(int id) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from ceos where id = ?";
        CeoOBJ ceo = new CeoOBJ();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                ceo = new CeoOBJ(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("entrada"),
                        rs.getInt("saida")
                );
            }
            return ceo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Obter Ceos registrados! \nErro: " + e);
            return ceo;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public CeoOBJ getCEO(String chave) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from ceos where nome = ?";
        CeoOBJ ceo = new CeoOBJ();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, chave);
            rs = pstm.executeQuery();
            while (rs.next()) {
                ceo = new CeoOBJ(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("entrada"),
                        rs.getInt("saida")
                );
            }
            return ceo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Obter Ceos registrados! \nErro: " + e);
            return ceo;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public List<ClientesOBJ> ClientesDoCto(String chave) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select clientes.* from pc "
                + "join clientes on clientes.id = pc.`idCliente` "
                + "join ctos on ctos.id = pc.`idCto` "
                + "where ctos.nome like '%" + chave + "%' or ctos.id = '" + chave + "'";
        List<ClientesOBJ> cto = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                ClientesOBJ novo = new ClientesOBJ(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("nacionalidade"),
                        rs.getString("BI"),
                        rs.getString("telefone"),
                        rs.getString("whatsapp"),
                        rs.getString("endereco"),
                        rs.getString("email"),
                        rs.getString("informacao"),
                        rs.getString("servico"),
                        rs.getInt("pacote"),
                        rs.getString("GPON"),
                        rs.getString("vlan"),
                        rs.getInt("dia")
                );
                cto.add(novo);
            }
            return cto;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Obter Ctos com clientes registrados! \nErro: " + e);
            return cto;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public boolean ApagarCto(String tecnico, int idCto) {
        Connection con = null;
        PreparedStatement pstm = null;
        String sql = "delete from ctos where id = " + idCto;
        String sqlPc = "delete from pc where idCto = " + idCto;
        try {
            String nome = getCTO(idCto).getNome().toUpperCase();
            con = Conexao.conectar();
            pstm = con.prepareStatement(sqlPc);
            pstm.executeUpdate();
            pstm = con.prepareStatement(sql);
            pstm.executeUpdate();
            RegistrarLogs(tecnico, "ELIMINOU O CTO:  " + nome);
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir CTO! \nErro: " + e);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm);
        }
    }

    public boolean ApagarCeo(String tecnico, int idCeo) {
        Connection con = null;
        PreparedStatement pstm = null;
        String sql = "delete from ceos where id = " + idCeo;
        String sqlPc = "update cto set idCeo = 1 where idCeo = " + idCeo;
        try {
            String nome = getCEO(idCeo).getNome().toUpperCase();
            con = Conexao.conectar();
            pstm = con.prepareStatement(sqlPc);
            pstm.executeUpdate();
            pstm = con.prepareStatement(sql);
            pstm.executeUpdate();
            RegistrarLogs(tecnico, "ELIMINOU O CEO:  " + nome);
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir CEO! \nErro: " + e);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm);
        }
    }

    public boolean NovaMensagem(ChatOBJ chat) {
        Connection con = null;
        PreparedStatement pstm = null;
        String sql = "insert into chat(origem, destino,mensagem) value (?,?,?)";

        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, chat.getOrigem());
            pstm.setInt(2, chat.getDestino());
            pstm.setString(3, chat.getMensagem());
            pstm.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Enviar Mensagem! \nErro: " + e);
            return false;
        } finally {
            Conexao.FecharConexão(con, pstm);
        }
    }

    public List<ChatOBJ> TodasMensagens() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from chat";
        List<ChatOBJ> chat = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                ChatOBJ c = new ChatOBJ(
                        rs.getInt("id"),
                        rs.getInt("origem"),
                        rs.getInt("destino"),
                        rs.getDate("data").toString(),
                        rs.getTime("hora").toString(),
                        rs.getString("mensagem")
                );
                chat.add(c);
            }
            return chat;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Obter Todas SMS no chat! \nErro: " + e);
            return chat;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public List<ChatOBJ> TodasMensagensEnviadas(int destino, int origem) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from chat where origem = ? and destino = ? order by id desc";
        List<ChatOBJ> chat = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, origem);
            pstm.setInt(2, destino);
            rs = pstm.executeQuery();
            while (rs.next()) {
                ChatOBJ c = new ChatOBJ(
                        rs.getInt("id"),
                        rs.getInt("origem"),
                        rs.getInt("destino"),
                        rs.getDate("data").toString(),
                        rs.getTime("hora").toString(),
                        rs.getString("mensagem")
                );
                chat.add(c);
            }
            return chat;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Obter Todas SMS enviadas! \nErro: " + e);
            return chat;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public List<ChatOBJ> TodasMensagensEnviadasAgrupadas(int codigo) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select origem, destino from chat where origem = '" + codigo + "' group by destino";
        List<ChatOBJ> chat = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                ChatOBJ c = new ChatOBJ(
                        0,
                        rs.getInt("origem"),
                        rs.getInt("destino"),
                        "",
                        "",
                        ""
                );
                chat.add(c);
            }
            return chat;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Obter Todas SMS enviadas! \nErro: " + e);
            return chat;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public List<ChatOBJ> TodasMensagensRecebidas(int origem, int destino) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from chat where origem = ? and destino = ? order by id desc";
        String sql2 = "SET @@sql_mode = SYS.LIST_DROP(@@sql_mode, 'ONLY_FULL_GROUP_BY')";
        List<ChatOBJ> chat = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, origem);
            pstm.setInt(2, destino);
            rs = pstm.executeQuery();
            while (rs.next()) {
                ChatOBJ c = new ChatOBJ(
                        rs.getInt("id"),
                        rs.getInt("origem"),
                        rs.getInt("destino"),
                        rs.getDate("data").toString(),
                        rs.getTime("hora").toString(),
                        rs.getString("mensagem")
                );
                chat.add(c);
            }
            return chat;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Obter Todas SMS recebidas! \nErro: " + e);
            return chat;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }

    public List<ChatOBJ> TodasMensagensRecebidasAgrupadas(int codigo) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select origem, destino from chat where destino ='" + codigo + "' group by origem";
        List<ChatOBJ> chat = new ArrayList<>();
        try {
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                ChatOBJ c = new ChatOBJ(
                        0,
                        rs.getInt("origem"),
                        rs.getInt("destino"),
                        "",
                        "",
                        ""
                );
                chat.add(c);
            }
            return chat;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Obter Todas SMS recebidas! \nErro: " + e);
            return chat;
        } finally {
            Conexao.FecharConexão(con, pstm, rs);
        }
    }
}
