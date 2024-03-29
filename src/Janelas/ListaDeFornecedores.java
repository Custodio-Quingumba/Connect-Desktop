/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Janelas;

import Objetos.Dados;
import Objetos.FornecedoresOBJ;
import java.awt.Color;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Quingumba
 */
public class ListaDeFornecedores extends javax.swing.JFrame {

    /**
     * Creates new form ListaDeFornecedores
     */
    private int idUsuario;
    private int idTema;

    public int getIdTema() {
        return idTema;
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
        String imageName = "/imagens/plano" + idTema + ".jpg";
        lbFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource(imageName)));
        if (idTema == 1) {
            lbTitulo.setForeground(new Color(0xCC00CC));
            tabela.setBackground(new Color(0x241f24));
            tabela.setForeground(new Color(0xCC00CC));
            btnEliminar.setBackground(new Color(0x241f24));
            btnAtualizar.setBackground(new Color(0x241f24));
            btnNovo.setBackground(new Color(0x241f24));
            btnVoltar.setBackground(new Color(0x241f24));
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

    public ListaDeFornecedores() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Icones/figicon.png")).getImage());
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setRowCount(0);
        List<FornecedoresOBJ> fnd = new Dados().TodosFornecedor();
        for (FornecedoresOBJ fornecedoresOBJ : fnd) {
            Object[] dados = {fornecedoresOBJ.getId(), fornecedoresOBJ.getNome()};
            modelo.addRow(dados);
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

        jPanel1 = new javax.swing.JPanel();
        lbTitulo = new javax.swing.JLabel();
        txtContacto = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        txtContaBancária = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtEndereço = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        txtIban = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        txtContacto2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        lbFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(0, 0));
        setMinimumSize(new java.awt.Dimension(870, 580));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbTitulo.setText("FORNECEDORES");
        jPanel1.add(lbTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 16, 620, 30));

        txtContacto.setEditable(false);
        txtContacto.setBackground(new java.awt.Color(232, 233, 235));
        txtContacto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtContacto.setForeground(new java.awt.Color(204, 0, 204));
        txtContacto.setBorder(null);
        jPanel1.add(txtContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 200, 34));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 200, 10));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 204, 0));
        jLabel1.setText("Contactos:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 170, 40));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 204, 0));
        jLabel10.setText("Nome: ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 160, 30));

        txtNome.setEditable(false);
        txtNome.setBackground(new java.awt.Color(232, 233, 235));
        txtNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNome.setForeground(new java.awt.Color(204, 0, 204));
        txtNome.setBorder(null);
        jPanel1.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 600, 34));

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 600, 10));

        txtContaBancária.setEditable(false);
        txtContaBancária.setBackground(new java.awt.Color(232, 233, 235));
        txtContaBancária.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtContaBancária.setForeground(new java.awt.Color(204, 0, 204));
        txtContaBancária.setBorder(null);
        txtContaBancária.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtContaBancáriaMouseClicked(evt);
            }
        });
        jPanel1.add(txtContaBancária, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 210, 34));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 210, 10));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 204, 0));
        jLabel2.setText("Conta Bancária:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 170, 40));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 204, 0));
        jLabel11.setText("Endereço:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 160, 30));

        txtEndereço.setEditable(false);
        txtEndereço.setBackground(new java.awt.Color(232, 233, 235));
        txtEndereço.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtEndereço.setForeground(new java.awt.Color(204, 0, 204));
        txtEndereço.setBorder(null);
        jPanel1.add(txtEndereço, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 600, 34));

        jSeparator6.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 600, 10));

        txtIban.setEditable(false);
        txtIban.setBackground(new java.awt.Color(232, 233, 235));
        txtIban.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtIban.setForeground(new java.awt.Color(204, 0, 204));
        txtIban.setBorder(null);
        jPanel1.add(txtIban, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 270, 250, 34));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 310, 250, 10));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 204, 0));
        jLabel3.setText("IBAN:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, 70, 40));

        txtContacto2.setEditable(false);
        txtContacto2.setBackground(new java.awt.Color(232, 233, 235));
        txtContacto2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtContacto2.setForeground(new java.awt.Color(204, 0, 204));
        txtContacto2.setBorder(null);
        jPanel1.add(txtContacto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, 200, 34));

        jScrollPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        tabela.setBackground(new java.awt.Color(215, 222, 230));
        tabela.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        tabela.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.setGridColor(new java.awt.Color(204, 0, 204));
        tabela.setOpaque(false);
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setMinWidth(100);
            tabela.getColumnModel().getColumn(0).setPreferredWidth(100);
            tabela.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 590, 200));

        btnNovo.setBackground(new java.awt.Color(241, 241, 241));
        btnNovo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNovo.setForeground(new java.awt.Color(204, 0, 204));
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/adicionar-usuario.png"))); // NOI18N
        btnNovo.setText("NOVO");
        btnNovo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        btnNovo.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnNovo.setIconTextGap(50);
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 370, 180, 40));

        btnAtualizar.setBackground(new java.awt.Color(241, 241, 241));
        btnAtualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAtualizar.setForeground(new java.awt.Color(204, 0, 204));
        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/atualizar.png"))); // NOI18N
        btnAtualizar.setText("ATUALIZAR");
        btnAtualizar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        btnAtualizar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnAtualizar.setIconTextGap(20);
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 420, 180, 40));

        btnEliminar.setBackground(new java.awt.Color(241, 241, 241));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(204, 0, 204));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/botao-apagar.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnEliminar.setIconTextGap(20);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 470, 180, 40));

        btnVoltar.setBackground(new java.awt.Color(241, 241, 241));
        btnVoltar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVoltar.setForeground(new java.awt.Color(204, 0, 204));
        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/voltar.png"))); // NOI18N
        btnVoltar.setText("VOLTAR");
        btnVoltar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        btnVoltar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnVoltar.setIconTextGap(30);
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        jPanel1.add(btnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 520, 180, 40));

        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jPanel4.setOpaque(false);
        jPanel4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel4MouseDragged(evt);
            }
        });
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel4MousePressed(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botoes/marca-cruzada.png"))); // NOI18N
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, -1, 40));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 850, 40));

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 180, 200, 10));

        lbFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Fundo Log.jpg"))); // NOI18N
        lbFundo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        jPanel1.add(lbFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 580));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtContaBancáriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtContaBancáriaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContaBancáriaMouseClicked

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        Fornecedores forn = new Fornecedores();
        forn.setIdUsuario(getIdUsuario());
        forn.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if (tabela.getSelectedRow() != -1) {
            int id = Integer.parseInt(tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
            if (new Dados().ExcluirFornecedor(new Dados().getNomeUsuário(getIdUsuario()), id)) {
                JOptionPane.showMessageDialog(null, "FORNECEDOR EXCLUÍDO!");
                DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
                modelo.setRowCount(0);
                List<FornecedoresOBJ> fnd = new Dados().TodosFornecedor();
                for (FornecedoresOBJ fornecedoresOBJ : fnd) {
                    Object[] dados = {fornecedoresOBJ.getId(), fornecedoresOBJ.getNome()};
                    modelo.addRow(dados);
                }
            }
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        // TODO add your handling code here:
        int id = 0;
        if (btnAtualizar.getText().equalsIgnoreCase("ATUALIZAR")) {
            if (tabela.getSelectedRow() != -1) {
                id = Integer.parseInt(tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
                txtNome.setEditable(true);
                txtEndereço.setEditable(true);
                txtContacto.setEditable(true);
                txtContacto2.setEditable(true);
                txtContaBancária.setEditable(true);
                txtIban.setEditable(true);
                btnNovo.setEnabled(false);
                btnEliminar.setEnabled(false);
                btnVoltar.setEnabled(false);
                tabela.setEnabled(false);
                btnAtualizar.setText("CONCLUIR");
            }
        } else {
            String nome = txtNome.getText();
            String contacto = txtContacto.getText();
            if (!txtContacto2.getText().equalsIgnoreCase("") && !txtContacto2.getText().equalsIgnoreCase(" ")) {
                contacto = txtContacto.getText() + " - " + txtContacto2.getText();
            }
            String enderço = txtEndereço.getText();
            String conta = txtContaBancária.getText();
            String IBAN = txtIban.getText();

            if (!nome.equalsIgnoreCase("")) {
                if (new Dados().AtualizarFornecedor(new Dados().getNomeUsuário(getIdUsuario()), new FornecedoresOBJ(id, nome, contacto, enderço, conta, IBAN))) {
                    JOptionPane.showMessageDialog(null, "Feito");
                    DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
                    modelo.setRowCount(0);
                    List<FornecedoresOBJ> fnd = new Dados().TodosFornecedor();
                    for (FornecedoresOBJ fornecedoresOBJ : fnd) {
                        Object[] dados = {fornecedoresOBJ.getId(), fornecedoresOBJ.getNome()};
                        modelo.addRow(dados);
                    }
                    txtNome.setText("");
                    txtContacto.setText("");
                    txtContacto2.setText("");
                    txtContaBancária.setText("");
                    txtEndereço.setText("");
                    txtIban.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Preencha os campos devidamente!");
            }

            txtNome.setEditable(false);
            txtEndereço.setEditable(false);
            txtContacto.setEditable(false);
            txtContacto2.setEditable(false);
            txtContaBancária.setEditable(false);
            txtIban.setEditable(false);
            btnNovo.setEnabled(true);
            btnEliminar.setEnabled(true);
            btnVoltar.setEnabled(true);
            tabela.setEnabled(true);
            btnAtualizar.setText("ATUALIZAR");
        }

    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
        if (tabela.getSelectedRow() != -1) {
            int id = Integer.parseInt(tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
            DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
            FornecedoresOBJ fnd = new Dados().BuscaFornecedor(id);

            txtNome.setText(fnd.getNome());
            if (fnd.getContacto().contains(" - ")) {
                String[] ctc = fnd.getContacto().split("-");
                txtContacto.setText(ctc[0]);
                txtContacto2.setText(ctc[1]);

            } else {
                txtContacto.setText(fnd.getContacto());
                txtContacto2.setText("");
            }
            txtContaBancária.setText(fnd.getConta());
            txtEndereço.setText(fnd.getEndereço());
            txtIban.setText(fnd.getIBAN());
        }
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        // TODO add your handling code here:
        if (tabela.getSelectedRow() != -1) {
            int id = Integer.parseInt(tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
            DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
            FornecedoresOBJ fnd = new Dados().BuscaFornecedor(id);

            txtNome.setText(fnd.getNome());
            if (fnd.getContacto().contains(" - ")) {
                String[] ctc = fnd.getContacto().split("-");
                txtContacto.setText(ctc[0]);
                txtContacto2.setText(ctc[1]);

            } else {
                txtContacto.setText(fnd.getContacto());
                txtContacto2.setText("");
            }
            txtContaBancária.setText(fnd.getConta());
            txtEndereço.setText(fnd.getEndereço());
            txtIban.setText(fnd.getIBAN());
        }
    }//GEN-LAST:event_tabelaMouseClicked

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed
    int x, y;
    private void jPanel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MousePressed
        // TODO add your handling code here:
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel4MousePressed

    private void jPanel4MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseDragged
        setLocation(evt.getXOnScreen() - x, evt.getYOnScreen() - y);
    }//GEN-LAST:event_jPanel4MouseDragged

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
            java.util.logging.Logger.getLogger(ListaDeFornecedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaDeFornecedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaDeFornecedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaDeFornecedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaDeFornecedores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel lbFundo;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtContaBancária;
    private javax.swing.JTextField txtContacto;
    private javax.swing.JTextField txtContacto2;
    private javax.swing.JTextField txtEndereço;
    private javax.swing.JTextField txtIban;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
