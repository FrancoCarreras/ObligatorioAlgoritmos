/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontend;

import backend.ArbolI;
import backend.File;
import backend.SistemaI;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author ezeco
 */
public class Principal extends javax.swing.JFrame {

    private SistemaI sistema;

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        
    }

    private void populateTable(Object[][] data) {
        DefaultTableModel modelo = new DefaultTableModel();
        for (int i = 0; i < data.length; i++) {
            if (i == 0) {
                for (int j = 0; j < data[i].length; j++) {
                    modelo.addColumn(data[i][j]);
                }
            } else {
                modelo.addRow(data[i]);
            }
        }
        this.jTable1.setModel(modelo);
    }

    public void populateTree(ArbolI arbol) {
        if (!arbol.esVacio()) {
            DefaultMutableTreeNode raiz = new DefaultMutableTreeNode(arbol.raiz());
            DefaultTreeModel modelo = new DefaultTreeModel(raiz);
            this.populateTreeSub(arbol.hijo(), raiz);
            this.jTree1.setModel(modelo);
        }

    }

    private void populateTreeSub(ArbolI arbol, DefaultMutableTreeNode padre) {
        if (!arbol.esVacio()) {
            DefaultMutableTreeNode raiz = new DefaultMutableTreeNode(arbol.raiz());
            padre.add(raiz);
            ArbolI hijo = arbol.hijo();
            ArbolI hermano = arbol.hermano();
            if (!hijo.esVacio()) {
                this.populateTreeSub(hijo, raiz);
            }
            if (!hermano.esVacio()) {
                this.populateTreeSub(hermano, padre);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPBack = new javax.swing.JPanel();
        jPLeft = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jPTopOptions = new javax.swing.JPanel();
        jLAdd = new javax.swing.JLabel();
        jLCut = new javax.swing.JLabel();
        jLPaste = new javax.swing.JLabel();
        jLCopy = new javax.swing.JLabel();
        jLRename = new javax.swing.JLabel();
        jLTrash = new javax.swing.JLabel();
        jPTopNav = new javax.swing.JPanel();
        jLBack = new javax.swing.JLabel();
        jLNext = new javax.swing.JLabel();
        jLUP = new javax.swing.JLabel();
        jLUPdate = new javax.swing.JLabel();
        jTFRuta = new javax.swing.JTextField();
        jTFBuscar = new javax.swing.JTextField();
        jLBuscar = new javax.swing.JLabel();
        jPContent = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPBotomInfo = new javax.swing.JPanel();
        jLCantidad = new javax.swing.JLabel();
        jLSize = new javax.swing.JLabel();
        jLCantidadData = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLExit = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPBack.setBackground(new java.awt.Color(0, 0, 153));
        jPBack.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPLeft.setBackground(new java.awt.Color(255, 255, 255));
        jPLeft.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTree1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTree1.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTree1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTree1);

        jPLeft.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 530));

        jPBack.add(jPLeft, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 330, 530));

        jPTopOptions.setBackground(new java.awt.Color(51, 0, 204));
        jPTopOptions.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLAdd.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLAdd.setForeground(new java.awt.Color(255, 255, 255));
        jLAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Add.png"))); // NOI18N
        jLAdd.setText("Nuevo ");
        jPTopOptions.add(jLAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, -1));

        jLCut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Scissors.png"))); // NOI18N
        jPTopOptions.add(jLCut, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        jLPaste.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Paste.png"))); // NOI18N
        jPTopOptions.add(jLPaste, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        jLCopy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Copy.png"))); // NOI18N
        jPTopOptions.add(jLCopy, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        jLRename.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Rename.png"))); // NOI18N
        jPTopOptions.add(jLRename, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, -1));

        jLTrash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Trash.png"))); // NOI18N
        jPTopOptions.add(jLTrash, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        jPBack.add(jPTopOptions, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 990, 40));

        jPTopNav.setBackground(new java.awt.Color(0, 51, 153));
        jPTopNav.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLBack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Left.png"))); // NOI18N
        jPTopNav.add(jLBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLNext.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Right.png"))); // NOI18N
        jPTopNav.add(jLNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jLUP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLUP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Up.png"))); // NOI18N
        jPTopNav.add(jLUP, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        jLUPdate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLUPdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Restart.png"))); // NOI18N
        jPTopNav.add(jLUPdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        jTFRuta.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTFRuta.setText("C:\\");
            jPTopNav.add(jTFRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 600, 20));

            jTFBuscar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
            jTFBuscar.setText("Buscar ...");
            jTFBuscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
            jTFBuscar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jTFBuscarActionPerformed(evt);
                }
            });
            jPTopNav.add(jTFBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 11, 190, 20));

            jLBuscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Search.png"))); // NOI18N
            jPTopNav.add(jLBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 10, -1, -1));

            jPBack.add(jPTopNav, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 990, 40));

            jPContent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jTable1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Nombre", "Tipo", "Tamaño", "Ruta"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
                };
                boolean[] canEdit = new boolean [] {
                    true, false, false, false
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
            jScrollPane2.setViewportView(jTable1);

            jPContent.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 530));

            jPBack.add(jPContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 660, 530));

            jPBotomInfo.setBackground(new java.awt.Color(102, 0, 204));
            jPBotomInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jLCantidad.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
            jLCantidad.setForeground(new java.awt.Color(255, 255, 255));
            jLCantidad.setText("Cantidad :");
            jLCantidad.setMaximumSize(new java.awt.Dimension(100, 15));
            jPBotomInfo.add(jLCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 30));

            jLSize.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
            jLSize.setForeground(new java.awt.Color(255, 255, 255));
            jLSize.setText("Tamaño");
            jLSize.setMaximumSize(new java.awt.Dimension(100, 15));
            jPBotomInfo.add(jLSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 50, 30));

            jLCantidadData.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
            jLCantidadData.setForeground(new java.awt.Color(255, 255, 255));
            jLCantidadData.setText("2");
            jPBotomInfo.add(jLCantidadData, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 5, 60, 20));

            jLabel1.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
            jLabel1.setForeground(new java.awt.Color(255, 255, 255));
            jLabel1.setText("434/1000000");
            jPBotomInfo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 6, 100, 20));

            jPBack.add(jPBotomInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 660, 990, 30));

            jLExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Close.png"))); // NOI18N
            jLExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            jLExit.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jLExitMouseClicked(evt);
                }
            });
            jPBack.add(jLExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 10, -1, -1));

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            setSize(new java.awt.Dimension(986, 690));
            setLocationRelativeTo(null);
        }// </editor-fold>//GEN-END:initComponents

    private void jLExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLExitMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLExitMouseClicked

    private void jTFBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFBuscarActionPerformed

    private void jTree1ValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTree1ValueChanged
        // TODO add your handling code here:
        DefaultMutableTreeNode nseleccionado=(DefaultMutableTreeNode) this.jTree1.getLastSelectedPathComponent();
        if(nseleccionado!=null){
            File file= (File) nseleccionado.getUserObject();
            System.out.println(file.getId());
        }
    }//GEN-LAST:event_jTree1ValueChanged

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLAdd;
    private javax.swing.JLabel jLBack;
    private javax.swing.JLabel jLBuscar;
    private javax.swing.JLabel jLCantidad;
    private javax.swing.JLabel jLCantidadData;
    private javax.swing.JLabel jLCopy;
    private javax.swing.JLabel jLCut;
    private javax.swing.JLabel jLExit;
    private javax.swing.JLabel jLNext;
    private javax.swing.JLabel jLPaste;
    private javax.swing.JLabel jLRename;
    private javax.swing.JLabel jLSize;
    private javax.swing.JLabel jLTrash;
    private javax.swing.JLabel jLUP;
    private javax.swing.JLabel jLUPdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPBack;
    private javax.swing.JPanel jPBotomInfo;
    private javax.swing.JPanel jPContent;
    private javax.swing.JPanel jPLeft;
    private javax.swing.JPanel jPTopNav;
    private javax.swing.JPanel jPTopOptions;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTFBuscar;
    private javax.swing.JTextField jTFRuta;
    private javax.swing.JTable jTable1;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables
}
