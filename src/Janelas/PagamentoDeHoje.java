/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Janelas;

import Objetos.Dados;
import Objetos.DiaPagamentoOBJ;
import java.awt.Color;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Custódio Quingumba
 */
public class PagamentoDeHoje extends javax.swing.JFrame {

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
            btnVoltar.setBackground(new Color(0x241f24));
            btnTodos.setBackground(new Color(0x241f24));
            jScrollPane1.setBackground(new Color(0x241f24));
            jScrollPane1.setForeground(new Color(0x241f24));
        }
    }

    /**
     * Creates new form PagamentoDeHoje
     */
    public PagamentoDeHoje() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Icones/figicon.png")).getImage());
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setRowCount(0);

        List<DiaPagamentoOBJ> dados = new Dados().BuscarDiaAtual();
        for (DiaPagamentoOBJ dado : dados) {
            String[] valor = {dado.getNome(), "" + dado.getDia(), dado.getInformação(), dado.getTelefone()};
            modelo.addRow(valor);
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
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnTodos = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        textoPesquisa = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        lbFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CLIENTES NO LIMITE DE PAGAMENTO");
        setMaximumSize(new java.awt.Dimension(0, 0));
        setMinimumSize(new java.awt.Dimension(670, 500));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(680, 563));
        jPanel1.setPreferredSize(new java.awt.Dimension(680, 563));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbTitulo.setText("CLIENTES E SUAS DATAS DE ATIVAÇÃO");
        jPanel1.add(lbTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 440, 50));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));

        tabela.setBackground(new java.awt.Color(215, 222, 230));
        tabela.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        tabela.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOME", "DIA DE PAGAMENTO", "ESTADO", "CONTACTO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.setGridColor(new java.awt.Color(204, 0, 204));
        tabela.setOpaque(false);
        jScrollPane1.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setMinWidth(250);
            tabela.getColumnModel().getColumn(0).setPreferredWidth(250);
            tabela.getColumnModel().getColumn(0).setMaxWidth(250);
            tabela.getColumnModel().getColumn(1).setMinWidth(150);
            tabela.getColumnModel().getColumn(1).setPreferredWidth(150);
            tabela.getColumnModel().getColumn(1).setMaxWidth(150);
            tabela.getColumnModel().getColumn(2).setMinWidth(100);
            tabela.getColumnModel().getColumn(2).setPreferredWidth(100);
            tabela.getColumnModel().getColumn(2).setMaxWidth(100);
            tabela.getColumnModel().getColumn(3).setMinWidth(150);
            tabela.getColumnModel().getColumn(3).setPreferredWidth(150);
            tabela.getColumnModel().getColumn(3).setMaxWidth(150);
        }

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 620, 310));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTodos.setBackground(new java.awt.Color(242, 242, 242));
        btnTodos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTodos.setForeground(new java.awt.Color(204, 0, 204));
        btnTodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/adicionar-cliente.png"))); // NOI18N
        btnTodos.setText("TODOS");
        btnTodos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        btnTodos.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodosActionPerformed(evt);
            }
        });
        jPanel2.add(btnTodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 90, 41));

        btnVoltar.setBackground(new java.awt.Color(242, 242, 242));
        btnVoltar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVoltar.setForeground(new java.awt.Color(204, 0, 204));
        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/voltar.png"))); // NOI18N
        btnVoltar.setText("VOLTAR");
        btnVoltar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        btnVoltar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnVoltar.setIconTextGap(10);
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        jPanel2.add(btnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 130, 41));

        textoPesquisa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textoPesquisa.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        textoPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textoPesquisaKeyReleased(evt);
            }
        });
        jPanel2.add(textoPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 380, 41));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 630, 60));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 650, 410));

        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jPanel5.setOpaque(false);
        jPanel5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel5MouseDragged(evt);
            }
        });
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel5MousePressed(evt);
            }
        });
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botoes/marca-cruzada.png"))); // NOI18N
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, -1, 40));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 650, -1));

        lbFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Fundo Log.jpg"))); // NOI18N
        lbFundo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        jPanel1.add(lbFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 500));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed
    int x, y;
    private void btnTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodosActionPerformed
        // TODO add your handling code here:

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setRowCount(0);

        List<DiaPagamentoOBJ> dados = new Dados().BuscarAllDia();
        for (DiaPagamentoOBJ dado : dados) {
            String[] valor = {dado.getNome(), "" + dado.getDia(), dado.getInformação(), dado.getTelefone()};
            modelo.addRow(valor);
        }
    }//GEN-LAST:event_btnTodosActionPerformed

    private void textoPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoPesquisaKeyReleased
        // TODO add your handling code here:
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setRowCount(0);
        List<DiaPagamentoOBJ> dados = new Dados().BuscarDia(textoPesquisa.getText());
        if (textoPesquisa.getText().equalsIgnoreCase("")) {
            dados = new Dados().BuscarAllDia();
        }
        for (DiaPagamentoOBJ dado : dados) {
            String[] valor = {dado.getNome(), "" + dado.getDia(), dado.getInformação(), dado.getTelefone()};
            modelo.addRow(valor);
        }
    }//GEN-LAST:event_textoPesquisaKeyReleased

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jPanel5MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseDragged
        // TODO add your handling code here:
        setLocation(evt.getXOnScreen() - x, evt.getYOnScreen() - y);
    }//GEN-LAST:event_jPanel5MouseDragged

    private void jPanel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MousePressed
        // TODO add your handling code here:
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel5MousePressed

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
            java.util.logging.Logger.getLogger(PagamentoDeHoje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PagamentoDeHoje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PagamentoDeHoje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PagamentoDeHoje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PagamentoDeHoje().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTodos;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbFundo;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField textoPesquisa;
    // End of variables declaration//GEN-END:variables
}
