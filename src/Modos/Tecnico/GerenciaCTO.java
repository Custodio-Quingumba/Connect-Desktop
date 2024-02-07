/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Modos.Tecnico;

import Objetos.CeoOBJ;
import Objetos.ClientesOBJ;
import Objetos.CtoOBJ;
import Objetos.Dados;
import Objetos.PcOBJ;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Custódio Quingumba
 */
public class GerenciaCTO extends javax.swing.JFrame {

    private DefaultTableModel modelo, modelo2, modelo3;
    private List<CtoOBJ> CTO = new ArrayList<>();
    private List<CeoOBJ> CEO = new ArrayList<>();
    private List<ClientesOBJ> clientes = new ArrayList<>();
    /**
     * Creates new form GerenciaCTO
     */

    private String previlegio2, usuario;
    private int idUsuario;
    private int idTema;

    public int getIdTema() {
        return idTema;
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
        String imageName = "/imagens/plano" + idTema + ".jpg";
        lbFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource(imageName)));
        lbFundo1.setIcon(new javax.swing.ImageIcon(getClass().getResource(imageName)));
        lbFundo2.setIcon(new javax.swing.ImageIcon(getClass().getResource(imageName)));
        lbFundo3.setIcon(new javax.swing.ImageIcon(getClass().getResource(imageName)));
        lbFundo4.setIcon(new javax.swing.ImageIcon(getClass().getResource(imageName)));
        if (idTema == 1) {
            jTabbedPane1.setBackground(new Color(0x241f24));
            jTabbedPane1.setOpaque(false);
            pAtribuicao.setBackground(new Color(0x241f24));
            pAtribuicao.setOpaque(true);
            pCEO.setBackground(new Color(0x241f24));
            pCEO.setOpaque(true);
            pCTO.setBackground(new Color(0x241f24));
            pCTO.setOpaque(true);
            pRegistros.setBackground(new Color(0x241f24));
            pRegistros.setOpaque(true);

            lbTitulo.setForeground(new Color(0xCC00CC));
            tbCeo.setBackground(new Color(0x241f24));
            tbClientes.setBackground(new Color(0x241f24));
            tbClientescto.setBackground(new Color(0x241f24));
            tbCto.setBackground(new Color(0x241f24));
            tbCtoCeo.setBackground(new Color(0x241f24));
            tbCeo.setForeground(new Color(0xCC00CC));
            tbClientes.setForeground(new Color(0xCC00CC));
            tbClientescto.setForeground(new Color(0xCC00CC));
            tbCto.setForeground(new Color(0xCC00CC));
            tbCtoCeo.setForeground(new Color(0xCC00CC));
            btnAtribuirCTO.setBackground(new Color(0x241f24));
            btnAtualizarCEO.setBackground(new Color(0x241f24));
            btnAtualizarCTO.setBackground(new Color(0x241f24));
            btnEditarCEO.setBackground(new Color(0x241f24));
            btnEditarCto.setBackground(new Color(0x241f24));
            btnEliminarCTO.setBackground(new Color(0x241f24));
            btnEliminarCeo.setBackground(new Color(0x241f24));
            btnFinalizarCEO.setBackground(new Color(0x241f24));
            btnFinalizarCTO.setBackground(new Color(0x241f24));
            btnLimpar1.setBackground(new Color(0x241f24));
            btnLimpar2.setBackground(new Color(0x241f24));
            btnLimpar3.setBackground(new Color(0x241f24));
            btnNovoCEO.setBackground(new Color(0x241f24));
            btnNovoCto.setBackground(new Color(0x241f24));
            btnTrocaDeCto.setBackground(new Color(0x241f24));
            btnTrocarCEO.setBackground(new Color(0x241f24));
            btnVoltar.setBackground(new Color(0x241f24));
            btnVoltar2.setBackground(new Color(0x241f24));
            btnVoltar3.setBackground(new Color(0x241f24));
            jScrollPane1.setBackground(new Color(0x241f24));
            jScrollPane1.setForeground(new Color(0x241f24));
        }
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPrevilegio2() {
        return previlegio2;
    }

    public void setPrevilegio2(String previlegio) {
        this.previlegio2 = previlegio;
    }

    public GerenciaCTO() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Icones/figicon.png")).getImage());
        lbID.setVisible(false);
        lbTextoCod.setVisible(false);
        cbCEOMouseClicked(null);
        CTO = new Dados().TodosCtos();
        CEO = new Dados().TodosCeos();
        clientes = new Dados().Todos();
        modelo = (DefaultTableModel) tbCto.getModel();
        modelo2 = (DefaultTableModel) tbCeo.getModel();
        modelo3 = (DefaultTableModel) tbClientes.getModel();
        modelo.setRowCount(0);
        modelo2.setRowCount(0);
        modelo3.setRowCount(0);
        cbCtos.removeAllItems();
        for (CtoOBJ cto : CTO) {
            String[] dados = {cto.getId() + "", cto.getNome(), cto.getPon() + "", cto.getCapacidade() + ""};
            modelo.addRow(dados);
            cbCtos.addItem(cto.getNome());
        }
        cbCeos.removeAllItems();
        for (CeoOBJ ceo : CEO) {
            String[] dados = {ceo.getId() + "", ceo.getNome(), ceo.getEntrada() + "", ceo.getSaida() + ""};
            modelo2.addRow(dados);
            cbCeos.addItem(ceo.getNome());
        }
        for (ClientesOBJ cliente : clientes) {
            String[] dados = {cliente.getId() + "", cliente.getNome()};
            modelo3.addRow(dados);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pFundo = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pCTO = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        txtBuscaCto = new javax.swing.JTextField();
        btnLimpar1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCto = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbClientescto = new javax.swing.JTable();
        btnTrocaDeCto = new javax.swing.JButton();
        btnNovoCto = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        btnEditarCto = new javax.swing.JButton();
        btnEliminarCTO = new javax.swing.JButton();
        lbFundo1 = new javax.swing.JLabel();
        pCEO = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        txtBuscaCeo = new javax.swing.JTextField();
        btnLimpar2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbCeo = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbCtoCeo = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnNovoCEO = new javax.swing.JButton();
        btnEditarCEO = new javax.swing.JButton();
        btnEliminarCeo = new javax.swing.JButton();
        btnTrocarCEO = new javax.swing.JButton();
        btnVoltar2 = new javax.swing.JButton();
        lbFundo2 = new javax.swing.JLabel();
        pRegistros = new javax.swing.JPanel();
        cbCTO = new javax.swing.JCheckBox();
        cbCEO = new javax.swing.JCheckBox();
        pCeo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnFinalizarCEO = new javax.swing.JButton();
        txtCeoNome = new javax.swing.JTextField();
        txtCeoEntrada = new javax.swing.JTextField();
        txtCeoSaida = new javax.swing.JTextField();
        btnAtualizarCEO = new javax.swing.JButton();
        pCto = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtCtoNome = new javax.swing.JTextField();
        txtCtoCapacidade = new javax.swing.JTextField();
        txtCtoPon = new javax.swing.JTextField();
        txtCtoEntrada = new javax.swing.JTextField();
        cbCeos = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        csTemSpliter = new javax.swing.JCheckBox();
        csSemSpliter = new javax.swing.JCheckBox();
        btnFinalizarCTO = new javax.swing.JButton();
        btnAtualizarCTO = new javax.swing.JButton();
        lbTextoCod = new javax.swing.JLabel();
        lbID = new javax.swing.JLabel();
        lbFundo3 = new javax.swing.JLabel();
        pAtribuicao = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbClientes = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        cbCtos = new javax.swing.JComboBox<>();
        btnAtribuirCTO = new javax.swing.JButton();
        btnVoltar3 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtGPON = new javax.swing.JTextField();
        txtVlan = new javax.swing.JTextField();
        txtPacote = new javax.swing.JTextField();
        txtBuscaClientes = new javax.swing.JTextField();
        btnLimpar3 = new javax.swing.JButton();
        lbFundo4 = new javax.swing.JLabel();
        barra = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        lbTitulo = new javax.swing.JLabel();
        lbFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pFundo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 204), 2));
        pFundo.setMaximumSize(new java.awt.Dimension(1100, 640));
        pFundo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        jTabbedPane1.setForeground(new java.awt.Color(204, 0, 204));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        pCTO.setBackground(new java.awt.Color(255, 255, 255));
        pCTO.setOpaque(false);
        pCTO.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true), "PESQUISA"));
        jPanel6.setOpaque(false);
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBuscaCto.setFont(new java.awt.Font("sansserif", 1, 21)); // NOI18N
        txtBuscaCto.setForeground(new java.awt.Color(204, 204, 204));
        txtBuscaCto.setText("   Buscar CTO pelo nome ou ID");
        txtBuscaCto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        txtBuscaCto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscaCtoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscaCtoFocusLost(evt);
            }
        });
        txtBuscaCto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaCtoKeyReleased(evt);
            }
        });
        jPanel6.add(txtBuscaCto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 780, 40));

        btnLimpar1.setBackground(new java.awt.Color(242, 242, 242));
        btnLimpar1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnLimpar1.setForeground(new java.awt.Color(204, 0, 204));
        btnLimpar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/filtro-limpo.png"))); // NOI18N
        btnLimpar1.setText("LIMPAR");
        btnLimpar1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        btnLimpar1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnLimpar1.setIconTextGap(20);
        btnLimpar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpar1ActionPerformed(evt);
            }
        });
        jPanel6.add(btnLimpar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 20, 140, 40));

        pCTO.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 964, 76));

        jScrollPane1.setBackground(new java.awt.Color(215, 222, 230));
        jScrollPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));

        tbCto.setBackground(new java.awt.Color(215, 222, 230));
        tbCto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        tbCto.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        tbCto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "COD.", "NOME", "PON", "CAPACIDADE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbCto.setOpaque(false);
        tbCto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCtoMouseClicked(evt);
            }
        });
        tbCto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbCtoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbCto);
        if (tbCto.getColumnModel().getColumnCount() > 0) {
            tbCto.getColumnModel().getColumn(0).setMinWidth(40);
            tbCto.getColumnModel().getColumn(0).setPreferredWidth(40);
            tbCto.getColumnModel().getColumn(0).setMaxWidth(60);
        }

        pCTO.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 88, 385, 343));

        jScrollPane2.setBackground(new java.awt.Color(215, 222, 230));
        jScrollPane2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));

        tbClientescto.setBackground(new java.awt.Color(215, 222, 230));
        tbClientescto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        tbClientescto.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        tbClientescto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CLIENTE", "VLAN", "GPON", "CONTACTO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbClientescto.setOpaque(false);
        jScrollPane2.setViewportView(tbClientescto);
        if (tbClientescto.getColumnModel().getColumnCount() > 0) {
            tbClientescto.getColumnModel().getColumn(0).setMinWidth(200);
            tbClientescto.getColumnModel().getColumn(0).setPreferredWidth(200);
            tbClientescto.getColumnModel().getColumn(1).setMinWidth(80);
            tbClientescto.getColumnModel().getColumn(1).setPreferredWidth(80);
            tbClientescto.getColumnModel().getColumn(1).setMaxWidth(80);
        }

        pCTO.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(397, 88, 573, 343));

        btnTrocaDeCto.setBackground(new java.awt.Color(242, 242, 242));
        btnTrocaDeCto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTrocaDeCto.setForeground(new java.awt.Color(204, 0, 204));
        btnTrocaDeCto.setText("TROCAR DE CTO");
        btnTrocaDeCto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        btnTrocaDeCto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrocaDeCtoActionPerformed(evt);
            }
        });
        pCTO.add(btnTrocaDeCto, new org.netbeans.lib.awtextra.AbsoluteConstraints(593, 443, 196, 52));

        btnNovoCto.setBackground(new java.awt.Color(242, 242, 242));
        btnNovoCto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNovoCto.setForeground(new java.awt.Color(204, 0, 204));
        btnNovoCto.setText("NOVO CTO");
        btnNovoCto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        btnNovoCto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoCtoActionPerformed(evt);
            }
        });
        pCTO.add(btnNovoCto, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 445, 183, 50));

        btnVoltar.setBackground(new java.awt.Color(242, 242, 242));
        btnVoltar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVoltar.setForeground(new java.awt.Color(204, 0, 204));
        btnVoltar.setText("VOLTAR");
        btnVoltar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        pCTO.add(btnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(795, 443, 175, 52));

        btnEditarCto.setBackground(new java.awt.Color(242, 242, 242));
        btnEditarCto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEditarCto.setForeground(new java.awt.Color(204, 0, 204));
        btnEditarCto.setText("EDITAR CTO");
        btnEditarCto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        btnEditarCto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarCtoActionPerformed(evt);
            }
        });
        pCTO.add(btnEditarCto, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 443, 196, 52));

        btnEliminarCTO.setBackground(new java.awt.Color(242, 242, 242));
        btnEliminarCTO.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminarCTO.setForeground(new java.awt.Color(204, 0, 204));
        btnEliminarCTO.setText("ELIMINAR CTO");
        btnEliminarCTO.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        btnEliminarCTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCTOActionPerformed(evt);
            }
        });
        pCTO.add(btnEliminarCTO, new org.netbeans.lib.awtextra.AbsoluteConstraints(397, 443, 190, 52));

        lbFundo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFundo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Fundasso.jpg"))); // NOI18N
        lbFundo1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        pCTO.add(lbFundo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 500));

        jTabbedPane1.addTab("CTO E CLIENTES", pCTO);

        pCEO.setBackground(new java.awt.Color(255, 255, 255));
        pCEO.setOpaque(false);
        pCEO.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pCEOFocusGained(evt);
            }
        });
        pCEO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pCEOMouseClicked(evt);
            }
        });
        pCEO.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true), "PESQUISA"));
        jPanel7.setOpaque(false);
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBuscaCeo.setFont(new java.awt.Font("sansserif", 1, 21)); // NOI18N
        txtBuscaCeo.setForeground(new java.awt.Color(204, 204, 204));
        txtBuscaCeo.setText("   Buscar CEO pelo nome ou ID");
        txtBuscaCeo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        txtBuscaCeo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscaCeoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscaCeoFocusLost(evt);
            }
        });
        txtBuscaCeo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaCeoKeyReleased(evt);
            }
        });
        jPanel7.add(txtBuscaCeo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 800, 40));

        btnLimpar2.setBackground(new java.awt.Color(242, 242, 242));
        btnLimpar2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnLimpar2.setForeground(new java.awt.Color(204, 0, 204));
        btnLimpar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/filtro-limpo.png"))); // NOI18N
        btnLimpar2.setText("LIMPAR");
        btnLimpar2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        btnLimpar2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnLimpar2.setIconTextGap(20);
        btnLimpar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpar2ActionPerformed(evt);
            }
        });
        jPanel7.add(btnLimpar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 20, 130, 40));

        pCEO.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 964, 70));

        jScrollPane3.setBackground(new java.awt.Color(215, 222, 230));
        jScrollPane3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));

        tbCeo.setBackground(new java.awt.Color(215, 222, 230));
        tbCeo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        tbCeo.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        tbCeo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "COD.", "CEO", "ENTRADA", "SAÍDA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbCeo.setOpaque(false);
        tbCeo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCeoMouseClicked(evt);
            }
        });
        tbCeo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbCeoKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tbCeo);
        if (tbCeo.getColumnModel().getColumnCount() > 0) {
            tbCeo.getColumnModel().getColumn(0).setMinWidth(60);
            tbCeo.getColumnModel().getColumn(0).setPreferredWidth(60);
            tbCeo.getColumnModel().getColumn(1).setMinWidth(150);
            tbCeo.getColumnModel().getColumn(1).setPreferredWidth(150);
            tbCeo.getColumnModel().getColumn(2).setMinWidth(80);
            tbCeo.getColumnModel().getColumn(2).setPreferredWidth(80);
            tbCeo.getColumnModel().getColumn(3).setMinWidth(80);
            tbCeo.getColumnModel().getColumn(3).setPreferredWidth(80);
        }

        pCEO.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 82, 385, 351));

        jScrollPane4.setBackground(new java.awt.Color(215, 222, 230));
        jScrollPane4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));

        tbCtoCeo.setBackground(new java.awt.Color(215, 222, 230));
        tbCtoCeo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        tbCtoCeo.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        tbCtoCeo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CTO", "PON", "CAPACIDADE", "ESPAÇO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbCtoCeo.setOpaque(false);
        jScrollPane4.setViewportView(tbCtoCeo);
        if (tbCtoCeo.getColumnModel().getColumnCount() > 0) {
            tbCtoCeo.getColumnModel().getColumn(0).setMinWidth(200);
            tbCtoCeo.getColumnModel().getColumn(0).setPreferredWidth(200);
            tbCtoCeo.getColumnModel().getColumn(1).setMinWidth(50);
            tbCtoCeo.getColumnModel().getColumn(1).setPreferredWidth(50);
            tbCtoCeo.getColumnModel().getColumn(1).setMaxWidth(50);
            tbCtoCeo.getColumnModel().getColumn(2).setMinWidth(80);
            tbCtoCeo.getColumnModel().getColumn(2).setPreferredWidth(80);
            tbCtoCeo.getColumnModel().getColumn(2).setMaxWidth(80);
            tbCtoCeo.getColumnModel().getColumn(3).setMinWidth(60);
            tbCtoCeo.getColumnModel().getColumn(3).setPreferredWidth(60);
            tbCtoCeo.getColumnModel().getColumn(3).setMaxWidth(60);
        }

        pCEO.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(397, 82, 573, 237));

        jScrollPane5.setBackground(new java.awt.Color(215, 222, 230));

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(215, 222, 230));
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        jTextArea1.setOpaque(false);
        jScrollPane5.setViewportView(jTextArea1);

        pCEO.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(397, 325, 573, 108));

        btnNovoCEO.setBackground(new java.awt.Color(242, 242, 242));
        btnNovoCEO.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNovoCEO.setForeground(new java.awt.Color(204, 0, 204));
        btnNovoCEO.setText("NOVO CEO");
        btnNovoCEO.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        btnNovoCEO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoCEOActionPerformed(evt);
            }
        });
        pCEO.add(btnNovoCEO, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 445, 183, 50));

        btnEditarCEO.setBackground(new java.awt.Color(242, 242, 242));
        btnEditarCEO.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEditarCEO.setForeground(new java.awt.Color(204, 0, 204));
        btnEditarCEO.setText("EDITAR CEO");
        btnEditarCEO.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        btnEditarCEO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarCEOActionPerformed(evt);
            }
        });
        pCEO.add(btnEditarCEO, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 445, 183, 50));

        btnEliminarCeo.setBackground(new java.awt.Color(242, 242, 242));
        btnEliminarCeo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminarCeo.setForeground(new java.awt.Color(204, 0, 204));
        btnEliminarCeo.setText("ELIMINAR CEO");
        btnEliminarCeo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        btnEliminarCeo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCeoActionPerformed(evt);
            }
        });
        pCEO.add(btnEliminarCeo, new org.netbeans.lib.awtextra.AbsoluteConstraints(397, 445, 183, 50));

        btnTrocarCEO.setBackground(new java.awt.Color(242, 242, 242));
        btnTrocarCEO.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTrocarCEO.setForeground(new java.awt.Color(204, 0, 204));
        btnTrocarCEO.setText("TROCAR DE CEO");
        btnTrocarCEO.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        btnTrocarCEO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrocarCEOActionPerformed(evt);
            }
        });
        pCEO.add(btnTrocarCEO, new org.netbeans.lib.awtextra.AbsoluteConstraints(592, 445, 183, 50));

        btnVoltar2.setBackground(new java.awt.Color(242, 242, 242));
        btnVoltar2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVoltar2.setForeground(new java.awt.Color(204, 0, 204));
        btnVoltar2.setText("VOLTAR");
        btnVoltar2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        btnVoltar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltar2ActionPerformed(evt);
            }
        });
        pCEO.add(btnVoltar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(787, 445, 183, 50));

        lbFundo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFundo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Fundasso.jpg"))); // NOI18N
        lbFundo2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        pCEO.add(lbFundo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 500));

        jTabbedPane1.addTab("CEO", pCEO);

        pRegistros.setOpaque(false);
        pRegistros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pRegistrosMouseClicked(evt);
            }
        });
        pRegistros.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbCTO.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbCTO.setForeground(new java.awt.Color(204, 0, 204));
        cbCTO.setText("NOVO CTO");
        cbCTO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbCTOMouseClicked(evt);
            }
        });
        pRegistros.add(cbCTO, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 6, 135, -1));

        cbCEO.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbCEO.setForeground(new java.awt.Color(204, 0, 204));
        cbCEO.setSelected(true);
        cbCEO.setText("NOVO CEO");
        cbCEO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbCEOMouseClicked(evt);
            }
        });
        pRegistros.add(cbCEO, new org.netbeans.lib.awtextra.AbsoluteConstraints(806, 6, 164, -1));

        pCeo.setBackground(new java.awt.Color(255, 255, 255));
        pCeo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        pCeo.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 204, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("REGISTRO E ATUALIZAÇÃO DE CEO");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 204, 0));
        jLabel4.setText("NOME:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 204, 0));
        jLabel5.setText("ENTRADA:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 204, 0));
        jLabel6.setText("SAIDA:");

        btnFinalizarCEO.setBackground(new java.awt.Color(244, 244, 244));
        btnFinalizarCEO.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFinalizarCEO.setForeground(new java.awt.Color(204, 0, 204));
        btnFinalizarCEO.setText("FINALIZAR");
        btnFinalizarCEO.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        btnFinalizarCEO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarCEOActionPerformed(evt);
            }
        });

        txtCeoNome.setBackground(new java.awt.Color(215, 222, 230));
        txtCeoNome.setForeground(new java.awt.Color(204, 0, 204));
        txtCeoNome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));

        txtCeoEntrada.setBackground(new java.awt.Color(215, 222, 230));
        txtCeoEntrada.setForeground(new java.awt.Color(204, 0, 204));
        txtCeoEntrada.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        txtCeoEntrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCeoEntradaKeyTyped(evt);
            }
        });

        txtCeoSaida.setBackground(new java.awt.Color(215, 222, 230));
        txtCeoSaida.setForeground(new java.awt.Color(204, 0, 204));
        txtCeoSaida.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        txtCeoSaida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCeoSaidaKeyTyped(evt);
            }
        });

        btnAtualizarCEO.setBackground(new java.awt.Color(244, 244, 244));
        btnAtualizarCEO.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAtualizarCEO.setForeground(new java.awt.Color(204, 0, 204));
        btnAtualizarCEO.setText("ATUALIZAR");
        btnAtualizarCEO.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        btnAtualizarCEO.setEnabled(false);
        btnAtualizarCEO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarCEOActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pCeoLayout = new javax.swing.GroupLayout(pCeo);
        pCeo.setLayout(pCeoLayout);
        pCeoLayout.setHorizontalGroup(
            pCeoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCeoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pCeoLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pCeoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pCeoLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pCeoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCeoNome)
                    .addComponent(txtCeoEntrada)
                    .addComponent(txtCeoSaida))
                .addGap(14, 14, 14))
            .addGroup(pCeoLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(btnFinalizarCEO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAtualizarCEO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pCeoLayout.setVerticalGroup(
            pCeoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCeoLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pCeoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCeoNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(pCeoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCeoEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(pCeoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCeoSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addGroup(pCeoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFinalizarCEO, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtualizarCEO, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pRegistros.add(pCeo, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 70, -1, -1));

        pCto.setBackground(new java.awt.Color(255, 255, 255));
        pCto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        pCto.setOpaque(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 204, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("REGISTRO E ATUALIZAÇÃO DE CTO");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 204, 0));
        jLabel7.setText("NOME:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 204, 0));
        jLabel8.setText("CAPACIDADE:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 204, 0));
        jLabel9.setText("PON:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 204, 0));
        jLabel11.setText("ENTRADA:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 204, 0));
        jLabel13.setText("CEO:");

        txtCtoNome.setBackground(new java.awt.Color(215, 222, 230));
        txtCtoNome.setForeground(new java.awt.Color(204, 0, 204));
        txtCtoNome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));

        txtCtoCapacidade.setBackground(new java.awt.Color(215, 222, 230));
        txtCtoCapacidade.setForeground(new java.awt.Color(204, 0, 204));
        txtCtoCapacidade.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        txtCtoCapacidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCtoCapacidadeKeyTyped(evt);
            }
        });

        txtCtoPon.setBackground(new java.awt.Color(215, 222, 230));
        txtCtoPon.setForeground(new java.awt.Color(204, 0, 204));
        txtCtoPon.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        txtCtoPon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCtoPonKeyTyped(evt);
            }
        });

        txtCtoEntrada.setBackground(new java.awt.Color(215, 222, 230));
        txtCtoEntrada.setForeground(new java.awt.Color(204, 0, 204));
        txtCtoEntrada.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        txtCtoEntrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCtoEntradaKeyTyped(evt);
            }
        });

        cbCeos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbCeos.setForeground(new java.awt.Color(204, 0, 204));
        cbCeos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbCeos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 204, 0));
        jLabel14.setText("SPLITER");

        csTemSpliter.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        csTemSpliter.setForeground(new java.awt.Color(204, 0, 204));
        csTemSpliter.setText("SIM");
        csTemSpliter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                csTemSpliterMouseClicked(evt);
            }
        });

        csSemSpliter.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        csSemSpliter.setForeground(new java.awt.Color(204, 0, 204));
        csSemSpliter.setSelected(true);
        csSemSpliter.setText("NÃO");
        csSemSpliter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                csSemSpliterMouseClicked(evt);
            }
        });

        btnFinalizarCTO.setBackground(new java.awt.Color(244, 244, 244));
        btnFinalizarCTO.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFinalizarCTO.setForeground(new java.awt.Color(204, 0, 204));
        btnFinalizarCTO.setText("FINALIZAR");
        btnFinalizarCTO.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        btnFinalizarCTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarCTOActionPerformed(evt);
            }
        });

        btnAtualizarCTO.setBackground(new java.awt.Color(244, 244, 244));
        btnAtualizarCTO.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAtualizarCTO.setForeground(new java.awt.Color(204, 0, 204));
        btnAtualizarCTO.setText("ATUALIZAR");
        btnAtualizarCTO.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        btnAtualizarCTO.setEnabled(false);
        btnAtualizarCTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarCTOActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pCtoLayout = new javax.swing.GroupLayout(pCto);
        pCto.setLayout(pCtoLayout);
        pCtoLayout.setHorizontalGroup(
            pCtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCtoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pCtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                    .addGroup(pCtoLayout.createSequentialGroup()
                        .addGroup(pCtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pCtoLayout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(csTemSpliter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(csSemSpliter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pCtoLayout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCtoCapacidade))
                            .addGroup(pCtoLayout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCtoPon))
                            .addGroup(pCtoLayout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCtoNome))
                            .addGroup(pCtoLayout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbCeos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pCtoLayout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCtoEntrada)))
                        .addGap(14, 14, 14))
                    .addGroup(pCtoLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(btnFinalizarCTO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAtualizarCTO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pCtoLayout.setVerticalGroup(
            pCtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCtoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pCtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCtoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pCtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCtoCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pCtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCtoPon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pCtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCtoEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(pCtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(csTemSpliter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(csSemSpliter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pCtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCeos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(pCtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFinalizarCTO, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtualizarCTO, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pRegistros.add(pCto, new org.netbeans.lib.awtextra.AbsoluteConstraints(499, 70, -1, -1));

        lbTextoCod.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbTextoCod.setForeground(new java.awt.Color(204, 0, 204));
        lbTextoCod.setText("COD. DO ELEMENTO:");
        pRegistros.add(lbTextoCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 6, 123, 20));

        lbID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbID.setForeground(new java.awt.Color(204, 0, 204));
        lbID.setText("...");
        pRegistros.add(lbID, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 8, 72, -1));

        lbFundo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFundo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Fundasso.jpg"))); // NOI18N
        lbFundo3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        pRegistros.add(lbFundo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 500));

        jTabbedPane1.addTab("REGISTROS", pRegistros);

        pAtribuicao.setOpaque(false);
        pAtribuicao.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane6.setBackground(new java.awt.Color(215, 222, 230));
        jScrollPane6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));

        tbClientes.setBackground(new java.awt.Color(215, 222, 230));
        tbClientes.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        tbClientes.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        tbClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CLIENTE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbClientes.setOpaque(false);
        tbClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbClientesMouseClicked(evt);
            }
        });
        tbClientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbClientesKeyReleased(evt);
            }
        });
        jScrollPane6.setViewportView(tbClientes);
        if (tbClientes.getColumnModel().getColumnCount() > 0) {
            tbClientes.getColumnModel().getColumn(0).setMinWidth(40);
            tbClientes.getColumnModel().getColumn(0).setPreferredWidth(40);
            tbClientes.getColumnModel().getColumn(0).setMaxWidth(40);
            tbClientes.getColumnModel().getColumn(1).setMinWidth(80);
        }

        pAtribuicao.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 77, 482, 393));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 204, 0));
        jLabel12.setText("CTO");
        pAtribuicao.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 312, 68, 30));

        cbCtos.setBackground(new java.awt.Color(215, 222, 230));
        cbCtos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbCtos.setForeground(new java.awt.Color(204, 0, 204));
        cbCtos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbCtos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        pAtribuicao.add(cbCtos, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 348, 351, 30));

        btnAtribuirCTO.setBackground(new java.awt.Color(242, 242, 242));
        btnAtribuirCTO.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAtribuirCTO.setForeground(new java.awt.Color(204, 0, 204));
        btnAtribuirCTO.setText("ATRIBUIÇÃO");
        btnAtribuirCTO.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        btnAtribuirCTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtribuirCTOActionPerformed(evt);
            }
        });
        pAtribuicao.add(btnAtribuirCTO, new org.netbeans.lib.awtextra.AbsoluteConstraints(532, 433, 143, 37));

        btnVoltar3.setBackground(new java.awt.Color(242, 242, 242));
        btnVoltar3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVoltar3.setForeground(new java.awt.Color(204, 0, 204));
        btnVoltar3.setText("VOLTAR");
        btnVoltar3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        btnVoltar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltar3ActionPerformed(evt);
            }
        });
        pAtribuicao.add(btnVoltar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(681, 433, 148, 37));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 204, 0));
        jLabel15.setText("VLAN");
        pAtribuicao.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 155, 68, 30));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 204, 0));
        jLabel17.setText("GPON");
        pAtribuicao.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 77, 68, 30));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 204, 0));
        jLabel18.setText("PACOTE");
        pAtribuicao.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 234, 68, 30));

        txtGPON.setEditable(false);
        txtGPON.setBackground(new java.awt.Color(215, 222, 230));
        txtGPON.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtGPON.setForeground(new java.awt.Color(204, 0, 204));
        txtGPON.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        pAtribuicao.add(txtGPON, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 113, 351, 30));

        txtVlan.setEditable(false);
        txtVlan.setBackground(new java.awt.Color(215, 222, 230));
        txtVlan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtVlan.setForeground(new java.awt.Color(204, 0, 204));
        txtVlan.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        pAtribuicao.add(txtVlan, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 191, 351, 30));

        txtPacote.setEditable(false);
        txtPacote.setBackground(new java.awt.Color(215, 222, 230));
        txtPacote.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtPacote.setForeground(new java.awt.Color(204, 0, 204));
        txtPacote.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        pAtribuicao.add(txtPacote, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 270, 351, 30));

        txtBuscaClientes.setFont(new java.awt.Font("sansserif", 1, 21)); // NOI18N
        txtBuscaClientes.setForeground(new java.awt.Color(204, 204, 204));
        txtBuscaClientes.setText("      Buscar clientes pelo nome, gpon ou vlan");
        txtBuscaClientes.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        txtBuscaClientes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscaClientesFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscaClientesFocusLost(evt);
            }
        });
        txtBuscaClientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaClientesKeyReleased(evt);
            }
        });
        pAtribuicao.add(txtBuscaClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 19, 800, 40));

        btnLimpar3.setBackground(new java.awt.Color(242, 242, 242));
        btnLimpar3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnLimpar3.setForeground(new java.awt.Color(204, 0, 204));
        btnLimpar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/filtro-limpo.png"))); // NOI18N
        btnLimpar3.setText("LIMPAR");
        btnLimpar3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        btnLimpar3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnLimpar3.setIconTextGap(20);
        btnLimpar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpar3ActionPerformed(evt);
            }
        });
        pAtribuicao.add(btnLimpar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(816, 19, 130, 40));

        lbFundo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFundo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Fundasso.jpg"))); // NOI18N
        lbFundo4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        pAtribuicao.add(lbFundo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 500));

        jTabbedPane1.addTab("ATRIBUIÇÃO AOS CTOS", pAtribuicao);

        pFundo.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 980, 540));

        barra.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        barra.setOpaque(false);
        barra.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                barraMouseDragged(evt);
            }
        });
        barra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                barraMousePressed(evt);
            }
        });
        barra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botoes/marca-cruzada.png"))); // NOI18N
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        barra.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 0, -1, 40));

        pFundo.add(barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 980, 40));

        lbTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTitulo.setText("CTO, CEO E SEUS INTEGRANTES");
        pFundo.add(lbTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 470, 39));

        lbFundo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Fundasso.jpg"))); // NOI18N
        lbFundo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        lbFundo.setMaximumSize(new java.awt.Dimension(810, 690));
        lbFundo.setMinimumSize(new java.awt.Dimension(810, 690));
        lbFundo.setPreferredSize(new java.awt.Dimension(810, 690));
        pFundo.add(lbFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 610));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pFundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pFundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private int x, y;

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void pCEOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pCEOMouseClicked
        // TODO add your handling code here:
        modelo2 = (DefaultTableModel) tbCeo.getModel();

    }//GEN-LAST:event_pCEOMouseClicked

    private void pCEOFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pCEOFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_pCEOFocusGained

    private void btnVoltar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVoltar2ActionPerformed

    private void btnTrocarCEOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrocarCEOActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Aba Registros!");
    }//GEN-LAST:event_btnTrocarCEOActionPerformed

    private void btnEliminarCeoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCeoActionPerformed
        // TODO add your handling code here:
        modelo2 = (DefaultTableModel) tbCeo.getModel();
        int linha = tbCeo.getSelectedRow();
        if (linha != -1) {
            int id = Integer.parseInt(modelo2.getValueAt(linha, 0).toString());
            if (new Dados().ApagarCeo(usuario, id)) {
                JOptionPane.showMessageDialog(null, "CEO Apagado!");
                cbCeos.removeAllItems();
                modelo2.setRowCount(0);
                for (CeoOBJ ceo : CEO) {
                    String[] dados = {ceo.getId() + "", ceo.getNome(), ceo.getEntrada() + "", ceo.getSaida() + ""};
                    modelo2.addRow(dados);
                    cbCeos.addItem(ceo.getNome());
                }
            }
        }
    }//GEN-LAST:event_btnEliminarCeoActionPerformed

    private void btnEditarCEOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarCEOActionPerformed
        // TODO add your handling code here:
        if (btnAtualizarCTO.isEnabled()) {
            JOptionPane.showMessageDialog(null, "Tem CTO em processo de atualização,\nPor favor terminar atualização!");
        } else {
            modelo2 = (DefaultTableModel) tbCeo.getModel();
            int linha = tbCeo.getSelectedRow();
            if (linha != -1) {
                int id = Integer.parseInt(modelo.getValueAt(linha, 0).toString());
                CeoOBJ ceo = new Dados().getCEO(id);
                lbTextoCod.setVisible(true);
                lbID.setVisible(true);
                lbID.setText(ceo.getId() + "");
                txtCeoNome.setText(ceo.getNome());
                txtCeoEntrada.setText(ceo.getEntrada() + "");
                txtCeoSaida.setText(ceo.getSaida() + "");
                btnAtualizarCEO.setEnabled(true);
            }
        }
    }//GEN-LAST:event_btnEditarCEOActionPerformed

    private void btnNovoCEOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoCEOActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Aba Registros por favor!");
    }//GEN-LAST:event_btnNovoCEOActionPerformed

    private void tbCeoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCeoMouseClicked
        // TODO add your handling code here:
        modelo2 = (DefaultTableModel) tbCeo.getModel();
        int linha = tbCeo.getSelectedRow();
        if (linha != -1) {
            int id = Integer.parseInt(modelo2.getValueAt(linha, 0).toString());
            List<CtoOBJ> ctos = new Dados().getCTOdoCeo(id);
            modelo2 = (DefaultTableModel) tbCtoCeo.getModel();
            modelo2.setRowCount(0);
            for (CtoOBJ cto : ctos) {
                String dados[] = {cto.getNome(), cto.getPon() + "", cto.getCapacidade() + "", new Dados().EspaçoRestanteCto(cto.getId()) + ""};
                modelo2.addRow(dados);
            }
        }
    }//GEN-LAST:event_tbCeoMouseClicked

    private void btnLimpar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpar2ActionPerformed
        // TODO add your handling code here:
        txtBuscaCeoFocusLost(null);
    }//GEN-LAST:event_btnLimpar2ActionPerformed

    private void txtBuscaCeoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaCeoKeyReleased
        // TODO add your handling code here:
        CEO = new Dados().getCEOs(txtBuscaCeo.getText());
        modelo2 = (DefaultTableModel) tbCeo.getModel();
        modelo2.setRowCount(0);
        for (CeoOBJ ceo : CEO) {
            String[] dados = {ceo.getId() + "", ceo.getNome(), ceo.getEntrada() + "", ceo.getSaida() + ""};
            modelo2.addRow(dados);
        }
    }//GEN-LAST:event_txtBuscaCeoKeyReleased

    private void txtBuscaCeoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscaCeoFocusLost
        // TODO add your handling code here:
        txtBuscaCeo.setText("   Buscar CEO pelo nome ou ID");
        txtBuscaCeo.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_txtBuscaCeoFocusLost

    private void txtBuscaCeoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscaCeoFocusGained
        // TODO add your handling code here:
        txtBuscaCeo.setForeground(new Color(0xcc00cc));
        txtBuscaCeo.setText("");
    }//GEN-LAST:event_txtBuscaCeoFocusGained

    private void btnEliminarCTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCTOActionPerformed
        // TODO add your handling code here:
        int linha = tbCto.getSelectedRow();
        modelo = (DefaultTableModel) tbCto.getModel();
        if (linha != -1) {
            int id = Integer.parseInt(modelo.getValueAt(linha, 0).toString());
            if (new Dados().ApagarCto(usuario, id)) {
                JOptionPane.showMessageDialog(null, "CTO Apagado!");
                cbCtos.removeAllItems();
                CTO = new Dados().TodosCtos();
                for (CtoOBJ cto : CTO) {
                    cbCtos.addItem(cto.getNome());
                    String[] dados = {cto.getId() + "", cto.getNome(), cto.getPon() + "", cto.getCapacidade() + ""};
                    modelo.addRow(dados);
                    cbCtos.addItem(cto.getNome());
                }
            }
        }
    }//GEN-LAST:event_btnEliminarCTOActionPerformed

    private void btnEditarCtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarCtoActionPerformed
        // TODO add your handling code here:

        if (btnAtualizarCEO.isEnabled()) {
            JOptionPane.showMessageDialog(null, "Tem CEO em processo de atualização,\nPor favor terminar atualização!");
        } else {
            int linha = tbCto.getSelectedRow();
            modelo = (DefaultTableModel) tbCto.getModel();
            if (linha != -1) {
                int id = Integer.parseInt(modelo.getValueAt(linha, 0).toString());
                CtoOBJ cto = new Dados().getCTO(id);
                lbID.setVisible(true);
                lbTextoCod.setVisible(true);
                lbID.setText(cto.getId() + "");
                txtCtoNome.setText(cto.getNome());
                txtCtoCapacidade.setText(cto.getCapacidade() + "");
                txtCtoEntrada.setText(cto.getEntrada() + "");
                txtCtoPon.setText(cto.getPon() + "");
                if (cto.getSpliter().equalsIgnoreCase("S")) {
                    csTemSpliter.setSelected(true);
                    csSemSpliter.setSelected(false);
                } else {
                    csSemSpliter.setSelected(true);
                    csTemSpliter.setSelected(false);
                }
                cbCeos.setSelectedIndex(cto.getIdCeo() - 1);
                btnAtualizarCTO.setEnabled(true);
                cbCTOMouseClicked(null);
            }
        }
    }//GEN-LAST:event_btnEditarCtoActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnNovoCtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoCtoActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Aba Registros por favor!");
    }//GEN-LAST:event_btnNovoCtoActionPerformed

    private void btnTrocaDeCtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrocaDeCtoActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Aba Atribuição Aos CTOs!");
    }//GEN-LAST:event_btnTrocaDeCtoActionPerformed

    private void tbCtoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCtoMouseClicked
        // TODO add your handling code here:
        int linha = tbCto.getSelectedRow();
        modelo = (DefaultTableModel) tbCto.getModel();
        if (linha != -1) {
            List<ClientesOBJ> cliente = new Dados().ClientesDoCto(modelo.getValueAt(linha, 0).toString());
            modelo = (DefaultTableModel) tbClientescto.getModel();
            modelo.setRowCount(0);
            for (ClientesOBJ c : cliente) {
                String[] dados = {c.getNome(), c.getVlan(), c.getGPON(), c.getTelefone()};
                modelo.addRow(dados);
            }
        }
    }//GEN-LAST:event_tbCtoMouseClicked

    private void btnLimpar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpar1ActionPerformed
        // TODO add your handling code here:
        txtBuscaCtoFocusLost(null);
    }//GEN-LAST:event_btnLimpar1ActionPerformed

    private void txtBuscaCtoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaCtoKeyReleased
        // TODO add your handling code here:
        CTO = new Dados().getCTOs(txtBuscaCto.getText());
        modelo = (DefaultTableModel) tbCto.getModel();
        modelo.setRowCount(0);
        for (CtoOBJ cto : CTO) {
            String[] dados = {cto.getId() + "", cto.getNome(), cto.getPon() + "", cto.getCapacidade() + ""};
            modelo.addRow(dados);
        }
    }//GEN-LAST:event_txtBuscaCtoKeyReleased

    private void txtBuscaCtoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscaCtoFocusLost
        // TODO add your handling code here:
        txtBuscaCto.setText("   Buscar CTO pelo nome ou ID");
        txtBuscaCto.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_txtBuscaCtoFocusLost

    private void txtBuscaCtoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscaCtoFocusGained
        // TODO add your handling code here:
        txtBuscaCto.setForeground(new Color(0xcc00cc));
        txtBuscaCto.setText("");
    }//GEN-LAST:event_txtBuscaCtoFocusGained

    private void cbCEOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbCEOMouseClicked
        // TODO add your handling code here:
        cbCEO.setSelected(true);
        cbCTO.setSelected(false);
        pCto.setVisible(false);
        pCeo.setVisible(true);
    }//GEN-LAST:event_cbCEOMouseClicked

    private void cbCTOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbCTOMouseClicked
        // TODO add your handling code here:
        cbCEO.setSelected(false);
        cbCTO.setSelected(true);
        pCto.setVisible(true);
        pCeo.setVisible(false);
    }//GEN-LAST:event_cbCTOMouseClicked

    private void btnFinalizarCEOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarCEOActionPerformed
        // TODO add your handling code here:
        if (btnAtualizarCEO.isEnabled()) {
            JOptionPane.showMessageDialog(null, "Tem dados em atualização, \npor favor finalizar o processo!");
        } else {
            String nome = txtCeoNome.getText().toUpperCase();
            int entrada = Integer.parseInt(txtCeoEntrada.getText());
            int saida = Integer.parseInt(txtCeoSaida.getText());
            CeoOBJ CeoNovo = new CeoOBJ(0, nome, entrada, saida);
            if (new Dados().RegistrarCeo(new Dados().getUsuário(getIdUsuario()).getNome(), CeoNovo)) {
                JOptionPane.showMessageDialog(null, "CEO Registrado!");
                txtCeoEntrada.setText("");
                txtCeoNome.setText("");
                txtCeoSaida.setText("");
            }
        }
    }//GEN-LAST:event_btnFinalizarCEOActionPerformed

    private void txtCeoEntradaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCeoEntradaKeyTyped
        // TODO add your handling code here:
        char letra = evt.getKeyChar();
        if (!Character.isDigit(letra)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCeoEntradaKeyTyped

    private void txtCeoSaidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCeoSaidaKeyTyped
        // TODO add your handling code here:
        char letra = evt.getKeyChar();
        if (!Character.isDigit(letra)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCeoSaidaKeyTyped

    private void txtCtoCapacidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCtoCapacidadeKeyTyped
        // TODO add your handling code here:
        char letra = evt.getKeyChar();
        if (!Character.isDigit(letra)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCtoCapacidadeKeyTyped

    private void txtCtoPonKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCtoPonKeyTyped
        // TODO add your handling code here:
        char letra = evt.getKeyChar();
        if (!Character.isDigit(letra)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCtoPonKeyTyped

    private void txtCtoEntradaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCtoEntradaKeyTyped
        // TODO add your handling code here:
        char letra = evt.getKeyChar();
        if (!Character.isDigit(letra)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCtoEntradaKeyTyped

    private void btnFinalizarCTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarCTOActionPerformed
        // TODO add your handling code here:
        if (btnAtualizarCTO.isEnabled()) {
            JOptionPane.showMessageDialog(null, "Tem dados em atualização, \npor favor finalizar o processo!");
        } else {
            int idCeo = cbCeos.getSelectedIndex() + 1;
            String nome = txtCtoNome.getText();
            int capacidade = Integer.parseInt(txtCtoCapacidade.getText());
            int pon = Integer.parseInt(txtCtoPon.getText());
            int entrada = Integer.parseInt(txtCtoEntrada.getText());
            String spliter = "N";
            if (csSemSpliter.isSelected()) {
                spliter = "N";
            } else if (csTemSpliter.isSelected()) {
                spliter = "S";
            }
            CtoOBJ CtoNovo = new CtoOBJ(0, idCeo, nome, capacidade, pon, entrada, spliter);
            if (new Dados().RegistrarCto(new Dados().getNomeUsuário(getIdUsuario()), CtoNovo)) {
                JOptionPane.showMessageDialog(null, "CTO registrado!");
            }
        }

    }//GEN-LAST:event_btnFinalizarCTOActionPerformed

    private void csSemSpliterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_csSemSpliterMouseClicked
        // TODO add your handling code here:
        csSemSpliter.setSelected(true);
        csTemSpliter.setSelected(false);
    }//GEN-LAST:event_csSemSpliterMouseClicked

    private void csTemSpliterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_csTemSpliterMouseClicked
        // TODO add your handling code here:
        csSemSpliter.setSelected(false);
        csTemSpliter.setSelected(true);
    }//GEN-LAST:event_csTemSpliterMouseClicked

    private void btnAtualizarCTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarCTOActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt(lbID.getText());
        int idCeo = cbCeos.getSelectedIndex() + 1;
        String nome = txtCtoNome.getText();
        int capacidade = Integer.parseInt(txtCtoCapacidade.getText());
        int pon = Integer.parseInt(txtCtoPon.getText());
        int entrada = Integer.parseInt(txtCtoEntrada.getText());
        String spliter = "N";
        if (csSemSpliter.isSelected()) {
            spliter = "N";
        } else if (csTemSpliter.isSelected()) {
            spliter = "S";
        }
        CtoOBJ CtoNovo = new CtoOBJ(id, idCeo, nome, capacidade, pon, entrada, spliter);
        if (new Dados().AtualizarCto(new Dados().getUsuário(getIdUsuario()).getNome(), CtoNovo)) {
            JOptionPane.showMessageDialog(null, "CTO Atualizado!");
            btnAtualizarCTO.setEnabled(false);
        }

    }//GEN-LAST:event_btnAtualizarCTOActionPerformed

    private void btnAtualizarCEOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarCEOActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt(lbID.getText());
        String nome = txtCeoNome.getText().toUpperCase();
        int entrada = Integer.parseInt(txtCeoEntrada.getText());
        int saida = Integer.parseInt(txtCeoSaida.getText());
        CeoOBJ CeoNovo = new CeoOBJ(id, nome, entrada, saida);
        if (new Dados().AtualizarCeo(new Dados().getUsuário(getIdUsuario()).getNome(), CeoNovo)) {
            JOptionPane.showMessageDialog(null, "CEO Atualizado!");
            btnAtualizarCTO.setEnabled(false);
        }
        btnAtualizarCEO.setEnabled(false);
    }//GEN-LAST:event_btnAtualizarCEOActionPerformed

    private void btnAtribuirCTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtribuirCTOActionPerformed
        // TODO add your handling code here:
        modelo3 = (DefaultTableModel) tbClientes.getModel();
        int linha = tbClientes.getSelectedRow();
        if (linha != -1) {
            int idCliente = Integer.parseInt(modelo3.getValueAt(linha, 0).toString());
            int idCto = cbCtos.getSelectedIndex() + 1;
            if (new Dados().VerificaPC(idCliente)) {
                int conf = JOptionPane.showConfirmDialog(null, "Deseja Atualizar com estes dados?");
                if (conf == 0) {
                    if (new Dados().AtualizarCtoCliente(idCliente, idCto)) {
                        JOptionPane.showMessageDialog(null, "Feito!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Cancelado!");
                    txtGPON.setText("");
                    txtVlan.setText("");
                    txtPacote.setText("");
                    cbCtos.setSelectedIndex(0);
                }
            } else {
                if (new Dados().AddCtoCliente(idCliente, idCto)) {
                    JOptionPane.showMessageDialog(null, "Feito");
                }
            }

        }
    }//GEN-LAST:event_btnAtribuirCTOActionPerformed

    private void btnVoltar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltar3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnVoltar3ActionPerformed

    private void tbClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbClientesMouseClicked
        // TODO add your handling code here:
        modelo3 = (DefaultTableModel) tbClientes.getModel();
        int linha = tbClientes.getSelectedRow();
        if (linha != -1) {
            int id = Integer.parseInt(modelo3.getValueAt(linha, 0).toString());
            ClientesOBJ c = new Dados().getCliente(id);
            txtGPON.setText(c.getGPON());
            txtVlan.setText(c.getVlan());
            txtPacote.setText(new Dados().getPacote(c.getPacote()).getNome());
            int ind = new Dados().ObterCtoPeloCliente(id);
            cbCtos.setSelectedIndex(ind - 1);
        }
    }//GEN-LAST:event_tbClientesMouseClicked

    private void pRegistrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pRegistrosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_pRegistrosMouseClicked

    private void txtBuscaClientesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscaClientesFocusGained
        // TODO add your handling code here:
        txtBuscaClientes.setForeground(new Color(0xcc00cc));
        txtBuscaClientes.setText("");
    }//GEN-LAST:event_txtBuscaClientesFocusGained

    private void txtBuscaClientesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscaClientesFocusLost
        // TODO add your handling code here:
        txtBuscaClientes.setText("   Buscar clientes pelo nome, gpon ou vlan");
        txtBuscaClientes.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_txtBuscaClientesFocusLost

    private void txtBuscaClientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaClientesKeyReleased
        // TODO add your handling code here:
        modelo3 = (DefaultTableModel) tbClientes.getModel();
        clientes = new Dados().PesquisaCliente(txtBuscaClientes.getText());
        modelo3.setRowCount(0);
        for (ClientesOBJ c : clientes) {
            String dados[] = {c.getId() + "", c.getNome()};
            modelo3.addRow(dados);
        }
    }//GEN-LAST:event_txtBuscaClientesKeyReleased

    private void btnLimpar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpar3ActionPerformed
        // TODO add your handling code here:
        txtBuscaClientesFocusLost(null);
    }//GEN-LAST:event_btnLimpar3ActionPerformed

    private void tbClientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbClientesKeyReleased
        // TODO add your handling code here:
        tbClientesMouseClicked(null);
    }//GEN-LAST:event_tbClientesKeyReleased

    private void tbCtoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbCtoKeyReleased
        // TODO add your handling code here:
        tbCtoMouseClicked(null);
    }//GEN-LAST:event_tbCtoKeyReleased

    private void tbCeoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbCeoKeyReleased
        // TODO add your handling code here:
        tbCeoMouseClicked(null);
    }//GEN-LAST:event_tbCeoKeyReleased

    private void barraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraMouseDragged
        // TODO add your handling code here:
        setLocation(evt.getXOnScreen() - x, evt.getYOnScreen() - y);
    }//GEN-LAST:event_barraMouseDragged

    private void barraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraMousePressed
        // TODO add your handling code here:
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_barraMousePressed

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel16MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GerenciaCTO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerenciaCTO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerenciaCTO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerenciaCTO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GerenciaCTO().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barra;
    private javax.swing.JButton btnAtribuirCTO;
    private javax.swing.JButton btnAtualizarCEO;
    private javax.swing.JButton btnAtualizarCTO;
    private javax.swing.JButton btnEditarCEO;
    private javax.swing.JButton btnEditarCto;
    private javax.swing.JButton btnEliminarCTO;
    private javax.swing.JButton btnEliminarCeo;
    private javax.swing.JButton btnFinalizarCEO;
    private javax.swing.JButton btnFinalizarCTO;
    private javax.swing.JButton btnLimpar1;
    private javax.swing.JButton btnLimpar2;
    private javax.swing.JButton btnLimpar3;
    private javax.swing.JButton btnNovoCEO;
    private javax.swing.JButton btnNovoCto;
    private javax.swing.JButton btnTrocaDeCto;
    private javax.swing.JButton btnTrocarCEO;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JButton btnVoltar2;
    private javax.swing.JButton btnVoltar3;
    private javax.swing.JCheckBox cbCEO;
    private javax.swing.JCheckBox cbCTO;
    private javax.swing.JComboBox<String> cbCeos;
    private javax.swing.JComboBox<String> cbCtos;
    private javax.swing.JCheckBox csSemSpliter;
    private javax.swing.JCheckBox csTemSpliter;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lbFundo;
    private javax.swing.JLabel lbFundo1;
    private javax.swing.JLabel lbFundo2;
    private javax.swing.JLabel lbFundo3;
    private javax.swing.JLabel lbFundo4;
    private javax.swing.JLabel lbID;
    private javax.swing.JLabel lbTextoCod;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JPanel pAtribuicao;
    private javax.swing.JPanel pCEO;
    private javax.swing.JPanel pCTO;
    private javax.swing.JPanel pCeo;
    private javax.swing.JPanel pCto;
    private javax.swing.JPanel pFundo;
    private javax.swing.JPanel pRegistros;
    private javax.swing.JTable tbCeo;
    private javax.swing.JTable tbClientes;
    private javax.swing.JTable tbClientescto;
    private javax.swing.JTable tbCto;
    private javax.swing.JTable tbCtoCeo;
    private javax.swing.JTextField txtBuscaCeo;
    private javax.swing.JTextField txtBuscaClientes;
    private javax.swing.JTextField txtBuscaCto;
    private javax.swing.JTextField txtCeoEntrada;
    private javax.swing.JTextField txtCeoNome;
    private javax.swing.JTextField txtCeoSaida;
    private javax.swing.JTextField txtCtoCapacidade;
    private javax.swing.JTextField txtCtoEntrada;
    private javax.swing.JTextField txtCtoNome;
    private javax.swing.JTextField txtCtoPon;
    private javax.swing.JTextField txtGPON;
    private javax.swing.JTextField txtPacote;
    private javax.swing.JTextField txtVlan;
    // End of variables declaration//GEN-END:variables
}
