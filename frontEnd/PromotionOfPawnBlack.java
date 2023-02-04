/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontEnd;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 *
 * @author HOME
 */
public class PromotionOfPawnBlack extends javax.swing.JDialog {
    String type;
    /**
     * Creates new form PromotionOfPawnBlack
     * @param parent
     * @param modal
     */
    public PromotionOfPawnBlack(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        type="";
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2-140,20);
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
        Queen = new javax.swing.JLabel();
        Rook = new javax.swing.JLabel();
        Bishop = new javax.swing.JLabel();
        Knight = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(280, 96));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(280, 96));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setLayout(null);

        Queen.setBackground(new java.awt.Color(0, 153, 153));
        Queen.setIcon(to("black queen"));
        Queen.setText("Queen");
        Queen.setOpaque(true);
        Queen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                QueenMouseClicked(evt);
            }
        });
        jPanel1.add(Queen);
        Queen.setBounds(10, 20, 60, 60);

        Rook.setBackground(new java.awt.Color(0, 153, 153));
        Rook.setIcon(to("black rook"));
        Rook.setText("Rook");
        Rook.setOpaque(true);
        Rook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RookMouseClicked(evt);
            }
        });
        jPanel1.add(Rook);
        Rook.setBounds(76, 20, 60, 60);

        Bishop.setBackground(new java.awt.Color(0, 153, 153));
        Bishop.setIcon(to("black bishop"));
        Bishop.setText("Knight");
        Bishop.setOpaque(true);
        Bishop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BishopMouseClicked(evt);
            }
        });
        jPanel1.add(Bishop);
        Bishop.setBounds(210, 20, 60, 60);

        Knight.setBackground(new java.awt.Color(0, 153, 153));
        Knight.setIcon(to("black knight"));
        Knight.setText("Bishop");
        Knight.setMaximumSize(new java.awt.Dimension(60, 60));
        Knight.setMinimumSize(new java.awt.Dimension(60, 60));
        Knight.setOpaque(true);
        Knight.setPreferredSize(new java.awt.Dimension(60, 60));
        Knight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KnightMouseClicked(evt);
            }
        });
        jPanel1.add(Knight);
        Knight.setBounds(140, 20, 60, 60);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 280, 100);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void QueenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_QueenMouseClicked
        type="Queen";
        this.dispose();
    }//GEN-LAST:event_QueenMouseClicked

    private void RookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RookMouseClicked
        type="Rook";
        this.dispose();
    }//GEN-LAST:event_RookMouseClicked

    private void BishopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BishopMouseClicked
        type="Bishop";
        this.dispose();
    }//GEN-LAST:event_BishopMouseClicked

    private void KnightMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KnightMouseClicked
        type="Knight";
        this.dispose();
    }//GEN-LAST:event_KnightMouseClicked

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PromotionOfPawnBlack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            PromotionOfPawnBlack dialog = new PromotionOfPawnBlack(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }
    public boolean isAnythingSelected()
    {
        switch(type)
        {
            case "":
                return false;
            default:
                return true;
        }
    }
    public String Choice()
    {
        return type;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Bishop;
    private javax.swing.JLabel Knight;
    private javax.swing.JLabel Queen;
    private javax.swing.JLabel Rook;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    private ImageIcon getImageIcon(String path)
    {
        ImageIcon Myimage=new ImageIcon(getClass().getResource(path));
        Image img=Myimage.getImage();
        Image newImg=img.getScaledInstance(60,60,Image.SCALE_SMOOTH);
        ImageIcon ico=new ImageIcon(newImg);
        return ico;
    }
    public ImageIcon to(String imageName)
    {
        return getImageIcon("/Images/"+imageName+".png");
    }
    public void setTypeToNull()
    {
        type="";
    }
}
