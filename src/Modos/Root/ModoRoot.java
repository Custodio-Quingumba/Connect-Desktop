/*
 * Click nb    @Override
    public int getWidth(ImageObserver observer) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getHeight(ImageObserver observer) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ImageProducer getSource() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Graphics getGraphics() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object getProperty(String name, ImageObserver observer) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
fs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Modos.Root;

import Janelas.Chat;
import Janelas.Clientes;
import Janelas.Login;
import Janelas.MeuPerfil;
import Janelas.NovoOp;
import Janelas.PagamentoDeHoje;
import Janelas.Relatorios;
import Janelas.Sobre;
import Janelas.Varredura;
import Modos.Administração.FechoDeContas;
import Modos.Tecnico.GerenciaCTO;
import Objetos.Dados;
import Objetos.TemaOBJ;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author Custódio Quingumba
 */
public final class ModoRoot extends javax.swing.JFrame {

    private String previlegio, usuario;
    private int idUsuario, idTema;
    private Color CorBotao, CorLetra, CorFundo;
    List<TemaOBJ> tema = new ArrayList<>();

    public Color getCorBotao() {
        return CorBotao;
    }

    public void setCorBotao(Color CorBotao) {
        this.CorBotao = CorBotao;
    }

    public Color getCorLetra() {
        return CorLetra;
    }

    public void setCorLetra(Color CorLetra) {
        this.CorLetra = CorLetra;
    }

    public Color getCorFundo() {
        return CorFundo;
    }

    public void setCorFundo(Color CorFundo) {
        this.CorFundo = CorFundo;
        pFundo.setBackground(CorFundo);
    }

    void SetCorBotoes(Color fundo, Color letra) {
        //COR DO FUNDO DO BOTAO

        cbTemas.setBackground(fundo);
        btAtivados.setBackground(fundo);
        btDatas.setBackground(fundo);
        btDesAct.setBackground(fundo);
        btExit.setBackground(fundo);
        btLogout.setBackground(fundo);
        btNovo.setBackground(fundo);
        btRelatorio.setBackground(fundo);
        btSobre.setBackground(fundo);
        btTodos.setBackground(fundo);
        btnCto.setBackground(fundo);
        btnFecho.setBackground(fundo);

        //COR A LETRA
        cbTemas.setForeground(letra);
        btAtivados.setForeground(letra);
        btDatas.setForeground(letra);
        btDesAct.setForeground(letra);
        btExit.setForeground(letra);
        btLogout.setForeground(letra);
        btNovo.setForeground(letra);
        btRelatorio.setForeground(letra);
        btSobre.setForeground(letra);
        btTodos.setForeground(letra);
        btnCto.setForeground(letra);
        btnFecho.setForeground(letra);
    }

    public int getIdTema() {
        return idTema;
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
        lbUsuario.setText("Usuário: " + usuario);
    }

    public String getPrevilegio() {
        return previlegio;
    }

    public void setPrevilegio(String previlegio) {
        this.previlegio = previlegio;
        if (getPrevilegio().equalsIgnoreCase("f")) {
            lbPrevilegio.setText("Previlegio: Área Administrativa");
        }
        if (getPrevilegio().equalsIgnoreCase("t")) {
            lbPrevilegio.setText("Previlegio: Área Técnica");
        }
        if (getPrevilegio().equalsIgnoreCase("a")) {
            lbPrevilegio.setText("Previlegio: Administrador do Sistema - DOPE");
        }
    }

    /**
     * Creates new form AmbienteDeTrabalho
     */
    public ModoRoot() {
        initComponents();
        tema = new Dados().temas();
        cbTemas.removeAllItems();
        for (TemaOBJ t : tema) {
            cbTemas.addItem(t.getNome());
        }
        pFundo.setBackground(new Color(0x303135));
        setIconImage(new ImageIcon(getClass().getResource("/Icones/figicon.png")).getImage());
        idTema = cbTemas.getSelectedIndex();
        if (idTema == 0) {
            setCorBotao(new Color(0xf1f1f1));
            setCorLetra(new Color(0xcc00cc));
            setCorFundo(new Color(0xfbfbfc));
            SetCorBotoes(CorBotao, CorLetra);
        } else {
            setCorBotao(new Color(0x241f24));
            setCorLetra(new Color(0xcc00cc));
            setCorFundo(new Color(0x110e11));
            SetCorBotoes(CorBotao, CorLetra);
        }
        try {
            String imageName = "/imagens/plano" + cbTemas.getSelectedIndex() + ".jpg";
            if (cbTemas.getSelectedIndex() == 1) {
                lbFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource(imageName)));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
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
        jPanel1 = new javax.swing.JPanel();
        btNovo = new javax.swing.JButton();
        btTodos = new javax.swing.JButton();
        btAtivados = new javax.swing.JButton();
        btDesAct = new javax.swing.JButton();
        btExit = new javax.swing.JButton();
        btLogout = new javax.swing.JButton();
        btDatas = new javax.swing.JButton();
        btRelatorio = new javax.swing.JButton();
        btSobre = new javax.swing.JButton();
        btnFecho = new javax.swing.JButton();
        btnCto = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lbPrevilegio = new javax.swing.JLabel();
        lbUsuario = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbTemas = new javax.swing.JComboBox<>();
        btnChat = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ALLCENTER - GERENCIADOR DE CLIENTES E PARCEIROS");
        setExtendedState(6);
        setIconImage(new ImageIcon(getClass().getResource("/Icones/figicon.png")).getImage());
        setMinimumSize(new java.awt.Dimension(1193, 763));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pFundo.setBackground(new java.awt.Color(255, 255, 255));
        pFundo.setOpaque(false);

        jPanel1.setForeground(new java.awt.Color(153, 0, 153));
        jPanel1.setMinimumSize(new java.awt.Dimension(216, 570));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(216, 570));

        btNovo.setBackground(new java.awt.Color(241, 241, 241));
        btNovo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btNovo.setForeground(new java.awt.Color(204, 0, 204));
        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/adicionar-ficheiro.png"))); // NOI18N
        btNovo.setText("NOVO");
        btNovo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        btNovo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btNovo.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btNovo.setIconTextGap(45);
        btNovo.setMaximumSize(new java.awt.Dimension(129, 36));
        btNovo.setMinimumSize(new java.awt.Dimension(129, 36));
        btNovo.setPreferredSize(new java.awt.Dimension(129, 36));
        btNovo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btNovoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btNovoMouseExited(evt);
            }
        });
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btTodos.setBackground(new java.awt.Color(241, 241, 241));
        btTodos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btTodos.setForeground(new java.awt.Color(204, 0, 204));
        btTodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/adicionar-cliente.png"))); // NOI18N
        btTodos.setText("CLIENTES");
        btTodos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        btTodos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btTodos.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btTodos.setIconTextGap(20);
        btTodos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btTodosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btTodosMouseExited(evt);
            }
        });
        btTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTodosActionPerformed(evt);
            }
        });

        btAtivados.setBackground(new java.awt.Color(241, 241, 241));
        btAtivados.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btAtivados.setForeground(new java.awt.Color(204, 0, 204));
        btAtivados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/varredura-qr.png"))); // NOI18N
        btAtivados.setText("VARREDURA");
        btAtivados.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        btAtivados.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btAtivados.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btAtivados.setMaximumSize(new java.awt.Dimension(129, 36));
        btAtivados.setMinimumSize(new java.awt.Dimension(129, 36));
        btAtivados.setPreferredSize(new java.awt.Dimension(129, 36));
        btAtivados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btAtivadosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btAtivadosMouseExited(evt);
            }
        });
        btAtivados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtivadosActionPerformed(evt);
            }
        });

        btDesAct.setBackground(new java.awt.Color(241, 241, 241));
        btDesAct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btDesAct.setForeground(new java.awt.Color(204, 0, 204));
        btDesAct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/gerenciamento-de-projetos.png"))); // NOI18N
        btDesAct.setText("GERENCIAR");
        btDesAct.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        btDesAct.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btDesAct.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btDesAct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btDesActMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btDesActMouseExited(evt);
            }
        });
        btDesAct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDesActActionPerformed(evt);
            }
        });

        btExit.setBackground(new java.awt.Color(241, 241, 241));
        btExit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btExit.setForeground(new java.awt.Color(204, 0, 204));
        btExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/fechar.png"))); // NOI18N
        btExit.setText("SAIR");
        btExit.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        btExit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btExit.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btExit.setIconTextGap(50);
        btExit.setMaximumSize(new java.awt.Dimension(129, 36));
        btExit.setMinimumSize(new java.awt.Dimension(129, 36));
        btExit.setPreferredSize(new java.awt.Dimension(129, 36));
        btExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btExitMouseExited(evt);
            }
        });
        btExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExitActionPerformed(evt);
            }
        });

        btLogout.setBackground(new java.awt.Color(241, 241, 241));
        btLogout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btLogout.setForeground(new java.awt.Color(204, 0, 204));
        btLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/sair.png"))); // NOI18N
        btLogout.setText("LOGOUT");
        btLogout.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        btLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btLogout.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btLogout.setIconTextGap(25);
        btLogout.setMaximumSize(new java.awt.Dimension(129, 36));
        btLogout.setMinimumSize(new java.awt.Dimension(129, 36));
        btLogout.setPreferredSize(new java.awt.Dimension(129, 36));
        btLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btLogoutMouseExited(evt);
            }
        });
        btLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLogoutActionPerformed(evt);
            }
        });

        btDatas.setBackground(new java.awt.Color(241, 241, 241));
        btDatas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btDatas.setForeground(new java.awt.Color(204, 0, 204));
        btDatas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/data-limite.png"))); // NOI18N
        btDatas.setText("DATAS");
        btDatas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        btDatas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btDatas.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btDatas.setIconTextGap(40);
        btDatas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btDatasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btDatasMouseExited(evt);
            }
        });
        btDatas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDatasActionPerformed(evt);
            }
        });

        btRelatorio.setBackground(new java.awt.Color(241, 241, 241));
        btRelatorio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btRelatorio.setForeground(new java.awt.Color(204, 0, 204));
        btRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/relatorio.png"))); // NOI18N
        btRelatorio.setText("RELATÓRIOS");
        btRelatorio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        btRelatorio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btRelatorio.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btRelatorio.setMaximumSize(new java.awt.Dimension(129, 36));
        btRelatorio.setMinimumSize(new java.awt.Dimension(129, 36));
        btRelatorio.setPreferredSize(new java.awt.Dimension(129, 36));
        btRelatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btRelatorioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btRelatorioMouseExited(evt);
            }
        });
        btRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRelatorioActionPerformed(evt);
            }
        });

        btSobre.setBackground(new java.awt.Color(241, 241, 241));
        btSobre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btSobre.setForeground(new java.awt.Color(204, 0, 204));
        btSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/informacoes.png"))); // NOI18N
        btSobre.setText("SOBRE");
        btSobre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        btSobre.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btSobre.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btSobre.setIconTextGap(40);
        btSobre.setMaximumSize(new java.awt.Dimension(129, 36));
        btSobre.setMinimumSize(new java.awt.Dimension(129, 36));
        btSobre.setPreferredSize(new java.awt.Dimension(129, 36));
        btSobre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btSobreMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btSobreMouseExited(evt);
            }
        });
        btSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSobreActionPerformed(evt);
            }
        });

        btnFecho.setBackground(new java.awt.Color(241, 241, 241));
        btnFecho.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFecho.setForeground(new java.awt.Color(204, 0, 204));
        btnFecho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/quantidade.png"))); // NOI18N
        btnFecho.setText("FECHO");
        btnFecho.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        btnFecho.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnFecho.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnFecho.setIconTextGap(25);
        btnFecho.setMaximumSize(new java.awt.Dimension(129, 36));
        btnFecho.setMinimumSize(new java.awt.Dimension(129, 36));
        btnFecho.setPreferredSize(new java.awt.Dimension(129, 36));
        btnFecho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFechoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFechoMouseExited(evt);
            }
        });
        btnFecho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFechoActionPerformed(evt);
            }
        });

        btnCto.setBackground(new java.awt.Color(241, 241, 241));
        btnCto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCto.setForeground(new java.awt.Color(204, 0, 204));
        btnCto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/caixa-de-entrega.png"))); // NOI18N
        btnCto.setText("CTO E CEO");
        btnCto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        btnCto.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnCto.setIconTextGap(10);
        btnCto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCtoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCtoMouseExited(evt);
            }
        });
        btnCto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCtoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btNovo, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                    .addComponent(btTodos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btAtivados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btDatas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btDesAct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFecho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btSobre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAtivados, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btDatas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btDesAct, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(btnCto, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFecho, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSobre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btExit, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setOpaque(false);

        lbPrevilegio.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbPrevilegio.setForeground(new java.awt.Color(204, 0, 204));
        lbPrevilegio.setText("Previlégio:");

        lbUsuario.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbUsuario.setForeground(new java.awt.Color(204, 0, 204));
        lbUsuario.setText("Usuário:");

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/do-utilizador.png"))); // NOI18N
        jLabel2.setText("Perfil");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 204));
        jLabel3.setText("Tema:");

        cbTemas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbTemas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        cbTemas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTemasItemStateChanged(evt);
            }
        });

        btnChat.setBackground(new java.awt.Color(241, 241, 241));
        btnChat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnChat.setForeground(new java.awt.Color(204, 0, 204));
        btnChat.setText("Chat");
        btnChat.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        btnChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbTemas, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChat, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPrevilegio, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnChat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbPrevilegio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbTemas, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addGap(11, 11, 11))
        );

        jPanel4.setOpaque(false);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Logo Empresa.png"))); // NOI18N
        jLabel1.setText(" ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pFundoLayout = new javax.swing.GroupLayout(pFundo);
        pFundo.setLayout(pFundoLayout);
        pFundoLayout.setHorizontalGroup(
            pFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFundoLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(pFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pFundoLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pFundoLayout.setVerticalGroup(
            pFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFundoLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 564, Short.MAX_VALUE))
                .addContainerGap(327, Short.MAX_VALUE))
        );

        getContentPane().add(pFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lbFundo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/A0.jpg"))); // NOI18N
        lbFundo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbFundo.setMaximumSize(new java.awt.Dimension(0, 0));
        lbFundo.setMinimumSize(new java.awt.Dimension(0, 0));
        lbFundo.setPreferredSize(new java.awt.Dimension(0, 0));
        getContentPane().add(lbFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, -4, 2256, 1504));
        lbFundo.getAccessibleContext().setAccessibleParent(pFundo);

        setSize(new java.awt.Dimension(1402, 699));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLogoutActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Dados().RegistrarLogs(getUsuario(), "FEZ LOGOUT DO SISTEMA");
        new Login().setVisible(true);
    }//GEN-LAST:event_btLogoutActionPerformed

    private void btExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExitActionPerformed
        // TODO add your handling code here:
        new Dados().RegistrarLogs(getUsuario(), "ENCERROU O SISTEMA");
        System.exit(0);
    }//GEN-LAST:event_btExitActionPerformed

    private void btNovoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btNovoMouseEntered
        // TODO add your handling code here:
        btNovo.setBackground(Color.GREEN);
        btNovo.setForeground(Color.BLACK);
    }//GEN-LAST:event_btNovoMouseEntered


    private void btNovoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btNovoMouseExited
        // TODO add your handling code here:
        btNovo.setBackground(CorBotao);
        btNovo.setForeground(CorLetra);
    }//GEN-LAST:event_btNovoMouseExited

    private void btTodosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btTodosMouseEntered
        // TODO add your handling code here:
        btTodos.setBackground(Color.GREEN);
        btTodos.setForeground(Color.BLACK);
    }//GEN-LAST:event_btTodosMouseEntered

    private void btTodosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btTodosMouseExited
        // TODO add your handling code here:
        btTodos.setBackground(CorBotao);
        btTodos.setForeground(CorLetra);
    }//GEN-LAST:event_btTodosMouseExited

    private void btAtivadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAtivadosMouseEntered
        // TODO add your handling code here:
        btAtivados.setBackground(Color.GREEN);
        btAtivados.setForeground(Color.BLACK);
    }//GEN-LAST:event_btAtivadosMouseEntered

    private void btAtivadosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAtivadosMouseExited
        // TODO add your handling code here:
        btAtivados.setBackground(CorBotao);
        btAtivados.setForeground(CorLetra);
    }//GEN-LAST:event_btAtivadosMouseExited

    private void btDesActMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDesActMouseEntered
        // TODO add your handling code here:
        btDesAct.setBackground(Color.GREEN);
        btDesAct.setForeground(Color.BLACK);
    }//GEN-LAST:event_btDesActMouseEntered

    private void btDesActMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDesActMouseExited
        // TODO add your handling code here:
        btDesAct.setBackground(CorBotao);
        btDesAct.setForeground(CorLetra);
    }//GEN-LAST:event_btDesActMouseExited

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        // TODO add your handling code here:
        NovoOp nop = new NovoOp();
        nop.setIdUsuario(idUsuario);
        nop.SetCorBotoes(CorBotao, CorLetra);
        nop.setCorBotao(CorBotao);
        nop.setCorLetra(CorLetra);
        nop.setCorFundo(CorFundo);
        nop.setIdTema(cbTemas.getSelectedIndex());
        nop.setVisible(true);

    }//GEN-LAST:event_btNovoActionPerformed

    private void btLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btLogoutMouseEntered
        // TODO add your handling code here:
        btLogout.setBackground(Color.GREEN);
        btLogout.setForeground(Color.BLACK);
    }//GEN-LAST:event_btLogoutMouseEntered

    private void btLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btLogoutMouseExited
        // TODO add your handling code here:
        btLogout.setBackground(CorBotao);
        btLogout.setForeground(CorLetra);
    }//GEN-LAST:event_btLogoutMouseExited

    private void btExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btExitMouseEntered
        // TODO add your handling code here:
        btExit.setBackground(Color.RED);
        btExit.setForeground(Color.GREEN);
    }//GEN-LAST:event_btExitMouseEntered

    private void btExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btExitMouseExited
        // TODO add your handling code here:
        btExit.setBackground(CorBotao);
        btExit.setForeground(CorLetra);
    }//GEN-LAST:event_btExitMouseExited

    private void btTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTodosActionPerformed
        // TODO add your handling code here:
        Clientes client = new Clientes();
        client.setIdUsuario(getIdUsuario());
        client.setPrevilegio(getPrevilegio());
        client.setIdTema(idTema);
        client.setVisible(true);
    }//GEN-LAST:event_btTodosActionPerformed

    private void btAtivadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtivadosActionPerformed
        // TODO add your handling code here:
        Varredura Varrer = new Varredura();
        Varrer.setIdUsuario(getIdUsuario());
        Varrer.setIdTema(idTema);
        Varrer.setVisible(true);
    }//GEN-LAST:event_btAtivadosActionPerformed

    private void btDesActActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDesActActionPerformed
        // TODO add your handling code here:

        Gerenciar ce = new Gerenciar();
        ce.setPrevilegio(this.previlegio);
        ce.setIdUsuario(getIdUsuario());
        ce.setIdTema(idTema);
        ce.SetCorBotoes(CorBotao, CorLetra);
        ce.setCorFundo(CorFundo);
        ce.setVisible(true);

    }//GEN-LAST:event_btDesActActionPerformed

    private void btDatasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDatasMouseEntered
        // TODO add your handling code here:
        btDatas.setBackground(Color.GREEN);
        btDatas.setForeground(Color.BLACK);
    }//GEN-LAST:event_btDatasMouseEntered

    private void btDatasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDatasMouseExited
        // TODO add your handling code here:
        btDatas.setBackground(CorBotao);
        btDatas.setForeground(CorLetra);
    }//GEN-LAST:event_btDatasMouseExited

    private void btDatasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDatasActionPerformed
        // TODO add your handling code here:
        PagamentoDeHoje ph = new PagamentoDeHoje();
        ph.setVisible(true);
        ph.setIdTema(idTema);
    }//GEN-LAST:event_btDatasActionPerformed

    private void btRelatorioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btRelatorioMouseEntered
        // TODO add your handling code here:
        btRelatorio.setBackground(Color.GREEN);
        btRelatorio.setForeground(Color.BLACK);
    }//GEN-LAST:event_btRelatorioMouseEntered

    private void btRelatorioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btRelatorioMouseExited
        // TODO add your handling code here:
        btRelatorio.setBackground(CorBotao);
        btRelatorio.setForeground(CorLetra);
    }//GEN-LAST:event_btRelatorioMouseExited

    private void btRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRelatorioActionPerformed
        // TODO add your handling code here:
        Relatorios relat = new Relatorios();
        relat.setIdUsuario(getIdUsuario());
        relat.setIdTema(idTema);
        relat.setVisible(true);
    }//GEN-LAST:event_btRelatorioActionPerformed

    private void btSobreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSobreMouseEntered
        // TODO add your handling code here:
        btSobre.setBackground(Color.GREEN);
        btSobre.setForeground(Color.BLACK);
    }//GEN-LAST:event_btSobreMouseEntered

    private void btSobreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSobreMouseExited
        // TODO add your handling code here:
        btSobre.setBackground(CorBotao);
        btSobre.setForeground(CorLetra);
    }//GEN-LAST:event_btSobreMouseExited

    private void btSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSobreActionPerformed
        // TODO add your handling code here:X
        Sobre s = new Sobre();
        s.setVisible(true);
    }//GEN-LAST:event_btSobreActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        MeuPerfil perfil = new MeuPerfil();
        perfil.setIdUsuario(getIdUsuario());
        perfil.setIdTema(idTema);
        perfil.setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void btnFechoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFechoMouseEntered
        // TODO add your handling code here:btSobre.setBackground(Color.GREEN);
        btnFecho.setBackground(Color.GREEN);
        btnFecho.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnFechoMouseEntered

    private void btnFechoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFechoMouseExited
        // TODO add your handling code here:
        btnFecho.setBackground(CorBotao);
        btnFecho.setForeground(CorLetra);
    }//GEN-LAST:event_btnFechoMouseExited

    private void btnFechoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFechoActionPerformed
        // TODO add your handling code here:
        FechoDeContas fecho = new FechoDeContas();
        fecho.setIdUsuario(idUsuario);
        fecho.setPrevilegio2(previlegio);
        fecho.setIdTema(idTema);
        fecho.setVisible(true);
    }//GEN-LAST:event_btnFechoActionPerformed

    private void btnCtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCtoActionPerformed
        // TODO add your handling code here:
        GerenciaCTO cto = new GerenciaCTO();
        cto.setIdUsuario(idUsuario);
        cto.setPrevilegio2(previlegio);
        cto.setIdTema(idTema);
        cto.setVisible(true);
    }//GEN-LAST:event_btnCtoActionPerformed

    private void btnCtoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCtoMouseEntered
        // TODO add your handling code here:
        btnCto.setBackground(Color.GREEN);
        btnCto.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnCtoMouseEntered

    private void btnCtoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCtoMouseExited
        // TODO add your handling code here:
        btnCto.setBackground(CorBotao);
        btnCto.setForeground(CorLetra);
    }//GEN-LAST:event_btnCtoMouseExited

    private void cbTemasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTemasItemStateChanged
        // TODO add your handling code here:
        idTema = cbTemas.getSelectedIndex();
        if (idTema == 0) {
            setCorBotao(new Color(0xf1f1f1));
            setCorLetra(new Color(0xcc00cc));
            setCorFundo(new Color(0xfbfbfc));
            SetCorBotoes(CorBotao, CorLetra);
            String imageName = "/imagens/A" + cbTemas.getSelectedIndex() + ".jpg";
            if (cbTemas.getSelectedIndex() == 0) {
                lbFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource(imageName)));
            }
        } else {
            setCorBotao(new Color(0x241f24));
            setCorLetra(new Color(0xcc00cc));
            setCorFundo(new Color(0x110e11));
            SetCorBotoes(CorBotao, CorLetra);
            String imageName = "/imagens/A" + cbTemas.getSelectedIndex() + ".jpg";
            if (cbTemas.getSelectedIndex() == 1) {
                lbFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource(imageName)));
            }
        }

    }//GEN-LAST:event_cbTemasItemStateChanged

    private void btnChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChatActionPerformed
        // TODO add your handling code here:
        Chat c = new Chat();
        c.setIdUsuario(idUsuario);
        c.setIdTema(idTema);
        c.setVisible(true);
    }//GEN-LAST:event_btnChatActionPerformed

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
            java.util.logging.Logger.getLogger(ModoRoot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModoRoot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModoRoot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModoRoot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModoRoot().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtivados;
    private javax.swing.JButton btDatas;
    private javax.swing.JButton btDesAct;
    private javax.swing.JButton btExit;
    private javax.swing.JButton btLogout;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btRelatorio;
    private javax.swing.JButton btSobre;
    private javax.swing.JButton btTodos;
    private javax.swing.JButton btnChat;
    private javax.swing.JButton btnCto;
    private javax.swing.JButton btnFecho;
    private javax.swing.JComboBox<String> cbTemas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbFundo;
    private javax.swing.JLabel lbPrevilegio;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JPanel pFundo;
    // End of variables declaration//GEN-END:variables
}
