/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Janelas;

import Objetos.ChatOBJ;
import Objetos.Dados;
import java.awt.Color;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Custódio Quingumba
 */
public final class Chat extends javax.swing.JFrame {
    
    private List<ChatOBJ> chat = new ArrayList<>();
    private String previlegio, usuario;
    private int idUsuario;
    private int idTema;
    private DefaultTableModel modelo = new DefaultTableModel();
    
    public int getIdTema() {
        return idTema;
    }
    
    public void setIdTema(int idTema) {
        this.idTema = idTema;
        if (idTema == 1) {
            tbUsuarios.setBackground(new Color(0x241f24));
//            tbMensagens.setBackground(new Color(0x241f24));
            tbUsuarios.setForeground(new Color(0xCC00CC));
//            tbMensagens.setForeground(new Color(0xCC00CC));
            lbAtualizar.setBackground(new Color(0x241f24));
            lbFechar.setBackground(new Color(0x241f24));
            
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
    
    public String getPrevilegio() {
        return previlegio;
    }
    
    public void setPrevilegio(String previlegio) {
        this.previlegio = previlegio;
    }

    /**
     * Creates new form Chat
     */
    public Chat() {
        initComponents();
        //   COLOCAR O FRAME TRANSPARENTE
        setOpacity(0.8f);

        // COLOCAR A JANELA NO CENTRO DO ECRÃ
        this.setLocation(1056, 325);
        //  COLOCAR OS CANTOS ARREDONDADOS AO ESTILO WINDOWS 11
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 10, 10));
        getRootPane().setBorder(BorderFactory.createLineBorder(new Color(0xcc00cc), 2));
        chat = new Dados().TodasMensagensRecebidasAgrupadas(getIdUsuario());
        csRecebidas.setSelected(true);
        csEnviadas.setSelected(false);
        modelo = (DefaultTableModel) tbUsuarios.getModel();
        modelo.setRowCount(0);
        for (ChatOBJ c : chat) {
            String[] dados = {new Dados().getNomeUsuário(c.getOrigem())};
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

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lbFechar = new javax.swing.JLabel();
        lbAtualizar = new javax.swing.JLabel();
        lbTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsuarios = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbMensagens = new javax.swing.JTable();
        csRecebidas = new javax.swing.JCheckBox();
        csEnviadas = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CHAT - GERAL");
        setMaximumSize(null);
        setMinimumSize(null);
        setUndecorated(true);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 204, 0));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jPanel1.setOpaque(false);
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbFechar.setBackground(new java.awt.Color(241, 241, 241));
        lbFechar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbFechar.setForeground(new java.awt.Color(204, 0, 204));
        lbFechar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFechar.setText("FECHAR");
        lbFechar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        lbFechar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbFechar.setOpaque(true);
        lbFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbFecharMouseClicked(evt);
            }
        });
        jPanel1.add(lbFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 8, 60, -1));

        lbAtualizar.setBackground(new java.awt.Color(241, 241, 241));
        lbAtualizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbAtualizar.setForeground(new java.awt.Color(204, 0, 204));
        lbAtualizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAtualizar.setText("ATUALIZAR");
        lbAtualizar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        lbAtualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbAtualizar.setOpaque(true);
        lbAtualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbAtualizarMouseClicked(evt);
            }
        });
        jPanel1.add(lbAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(379, 8, -1, -1));

        lbTitulo.setBackground(new java.awt.Color(241, 241, 241));
        lbTitulo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbTitulo.setForeground(new java.awt.Color(204, 0, 204));
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTitulo.setText("CHAT - INTERNO");
        lbTitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbTitulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbTituloMouseClicked(evt);
            }
        });
        jPanel1.add(lbTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 10, 140, -1));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 528, 40));

        tbUsuarios.setBackground(new java.awt.Color(241, 241, 241));
        tbUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Usuários"
            }
        ));
        tbUsuarios.setOpaque(false);
        tbUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbUsuarios);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 87, 213, 420));

        tbMensagens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mensagens"
            }
        ));
        tbMensagens.setOpaque(false);
        tbMensagens.setRowHeight(60);
        jScrollPane2.setViewportView(tbMensagens);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 87, 303, 420));

        csRecebidas.setText("RECEBIDAS");
        csRecebidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                csRecebidasMouseClicked(evt);
            }
        });
        jPanel2.add(csRecebidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 97, 30));

        csEnviadas.setText("ENVIADAS");
        csEnviadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                csEnviadasMouseClicked(evt);
            }
        });
        jPanel2.add(csEnviadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 90, 30));

        jButton1.setBackground(new java.awt.Color(241, 241, 241));
        jButton1.setForeground(new java.awt.Color(204, 0, 204));
        jButton1.setText("ENVIAR");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 60, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFecharMouseClicked
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_lbFecharMouseClicked
    
    private int x, y;

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        // TODO add your handling code here:
        this.setLocation(evt.getXOnScreen() - x, evt.getYOnScreen() - y);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void lbAtualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAtualizarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbAtualizarMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        FeedBack fed = new FeedBack();
        fed.setIdTema(idTema);
        fed.setIdUsuario(idUsuario);
        fed.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lbTituloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTituloMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbTituloMouseClicked

    private void csRecebidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_csRecebidasMouseClicked
        // TODO add your handling code here:
        chat = new Dados().TodasMensagensRecebidasAgrupadas(getIdUsuario());
        csRecebidas.setSelected(true);
        csEnviadas.setSelected(false);
        modelo = (DefaultTableModel) tbUsuarios.getModel();
        modelo.setRowCount(0);
        for (ChatOBJ c : chat) {
            String[] dados = {new Dados().getNomeUsuário(c.getOrigem())};
            modelo.addRow(dados);
        }
    }//GEN-LAST:event_csRecebidasMouseClicked

    private void csEnviadasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_csEnviadasMouseClicked
        // TODO add your handling code here:
        chat = new Dados().TodasMensagensEnviadasAgrupadas(getIdUsuario());
        csRecebidas.setSelected(false);
        csEnviadas.setSelected(true);
        modelo = (DefaultTableModel) tbUsuarios.getModel();
        modelo.setRowCount(0);
        for (ChatOBJ c : chat) {
            String[] dados = {new Dados().getNomeUsuário(c.getDestino())};
            modelo.addRow(dados);
        }
    }//GEN-LAST:event_csEnviadasMouseClicked

    private void tbUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUsuariosMouseClicked
        // TODO add your handling code here:
        int linha = tbUsuarios.getSelectedRow();
        if (linha != -1) {
            modelo = (DefaultTableModel) tbUsuarios.getModel();
            int idDestino = new Dados().getIdUsuárioPeloNome(modelo.getValueAt(linha, 0).toString());
            modelo = (DefaultTableModel) tbMensagens.getModel();
            tbMensagens.setAutoResizeMode(4);
            modelo.setRowCount(0);
            if (csEnviadas.isSelected()) {
                chat = new Dados().TodasMensagensEnviadas(idDestino, getIdUsuario());
                for (ChatOBJ c : chat) {
                    String[] dados = {c.getMensagem()};
                    modelo.addRow(dados);
                }
            } else {
                chat = new Dados().TodasMensagensRecebidas(idDestino, getIdUsuario());
                for (ChatOBJ c : chat) {
                    String[] dados = {c.getMensagem()};
                    modelo.addRow(dados);
                }
            }
        }
    }//GEN-LAST:event_tbUsuariosMouseClicked

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
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Chat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox csEnviadas;
    private javax.swing.JCheckBox csRecebidas;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbAtualizar;
    private javax.swing.JLabel lbFechar;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JTable tbMensagens;
    private javax.swing.JTable tbUsuarios;
    // End of variables declaration//GEN-END:variables
}
