/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetakipsistemi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author X550V
 */
public class personelOzellikDegistir extends javax.swing.JFrame {

    String kullanıcıId;
    DefaultListModel dlm = new DefaultListModel();
    Connection con;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjeTakipSistemiPU");

    /**
     * Creates new form personelOzellikDegistir
     */
    public personelOzellikDegistir(String kullanıcıId) {
        try {
            initComponents();
            this.kullanıcıId = kullanıcıId;
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/Database", "enes", "123");
            Statement s = con.createStatement();
            Statement s2 = con.createStatement();
            ResultSet rs1 = s.executeQuery("select * from PROJE");

            ArrayList<String> projekodları = new ArrayList();
            while (rs1.next()) {
                if (rs1.getString("KULLANICIID").equals(kullanıcıId)) {
                    projekodları.add(rs1.getString("PROJEKODU"));
                }

            }
            for (int i = 0; i < projekodları.size(); i++) {
                ResultSet rs2 = s2.executeQuery("select * from PERSONEL");
                while (rs2.next()) {
                    if (projekodları.get(i).equals(rs2.getString("CALISACAGIPROJE"))) {
                        dlm.addElement(rs2.getString("TCKIMLIK"));
                    }
                }
            }

            personelList.setModel(dlm);
        } catch (SQLException ex) {
            Logger.getLogger(personelOzellikDegistir.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public personelOzellikDegistir() {
        initComponents();
    }

    boolean desenKontrol(String desenMetni, String icindeDesenArananMetin) {

        Pattern desen = Pattern.compile(desenMetni);
        Matcher arama = desen.matcher(icindeDesenArananMetin);
        return arama.find();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        personelList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        personelRutbesi = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        personelOzelligi = new javax.swing.JComboBox<>();
        personelAdı = new javax.swing.JTextField();
        personelMaas = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        degistir = new javax.swing.JButton();
        personelSoyadı = new javax.swing.JTextField();

        personelList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                personelListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(personelList);

        jLabel1.setText("Personeller");

        jLabel3.setText("Personel Soyadı");

        jLabel4.setText("Personel Rütbesi");

        jLabel13.setText("Personel Maaşı");

        personelRutbesi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Şef", "İşçi", "Usta", "Koordinatör", "Tekniker", "Şef Yardımcısı", "Teknisyen", "Mühendis" }));

        jLabel14.setText("Personel Özelliği");

        personelOzelligi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mimar", "İnşaat Mühendisi", "İşçi", "Elektrik Mühendisi" }));

        jLabel5.setText("Personel Adı");

        degistir.setText("Degistir");
        degistir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                degistirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(personelOzelligi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(personelMaas)
                    .addComponent(personelRutbesi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(personelAdı)
                    .addComponent(personelSoyadı))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(degistir, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(personelAdı, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(personelSoyadı, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(personelRutbesi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(personelOzelligi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(personelMaas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(degistir, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1))
                .addContainerGap(90, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void personelListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_personelListValueChanged
        try {
            // TODO add your handling code here:
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select * from PERSONEL");
            while (rs.next()) {
                if (rs.getString("TCKIMLIK").equalsIgnoreCase(personelList.getSelectedValue())) {
                    personelAdı.setText(rs.getString("ADI"));
                    personelMaas.setText(rs.getString("MAAS"));
                    personelSoyadı.setText(rs.getString("SOYADI"));
                    personelOzelligi.setSelectedItem(rs.getString("OZELLIGI"));
                    personelRutbesi.setSelectedItem(rs.getString("RUTBESI"));
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(personelOzellikDegistir.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_personelListValueChanged

    private void degistirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_degistirActionPerformed
        // TODO add your handling code here:
        EntityManager em = emf.createEntityManager();
        Query q1 = em.createQuery("select p from Personel p");
        Query q2 = em.createQuery("select p from Proje p");
        List<Personel> personeller = q1.getResultList();
        List<Proje> projeler = q2.getResultList();
        if (personelList.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Personel Seçmediniz ...");
        } else {
            if (!desenKontrol("[^a-zA-Z]", personelAdı.getText())) {
                if (!desenKontrol("[^a-zA-Z]", personelSoyadı.getText())) {
                    for (Personel personel : personeller) {
                        if (personel.getTckimlik().equalsIgnoreCase(personelList.getSelectedValue())) {
                            personel.setAdi(personelAdı.getText());
                            personel.setMaas(personelMaas.getText());
                            personel.setSoyadi(personelSoyadı.getText());
                            personel.setOzelligi((String) personelOzelligi.getSelectedItem());
                            personel.setRutbesi((String) personelRutbesi.getSelectedItem());
                            em.getTransaction().begin();
                            em.getTransaction().commit();
                            for (int k = 0; k < projeYönetim.dtm.getRowCount(); k++) {
                                if (projeYönetim.dtm.getValueAt(k, 5).equals(personelList.getSelectedValue())) {
                                    projeYönetim.dtm.setValueAt((String) personelAdı.getText(), k, 0);
                                    projeYönetim.dtm.setValueAt((String) personelSoyadı.getText(), k, 1);
                                    projeYönetim.dtm.setValueAt((String) personelOzelligi.getSelectedItem(), k, 2);
                                    projeYönetim.dtm.setValueAt((String) personelRutbesi.getSelectedItem(), k, 3);
                                }
                            }
                            JOptionPane.showMessageDialog(this, "Başarıyla Değiştirdiniz.");
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(rootPane, "Personel Soyadı Özel Karakter Ve Rakam İçeremez ...");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Personel Asdı Özel Karakter Ve Rakam İçeremez ...");
            }
        }

    }//GEN-LAST:event_degistirActionPerformed

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
            java.util.logging.Logger.getLogger(personelOzellikDegistir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(personelOzellikDegistir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(personelOzellikDegistir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(personelOzellikDegistir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new personelOzellikDegistir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton degistir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField personelAdı;
    private javax.swing.JList<String> personelList;
    private javax.swing.JTextField personelMaas;
    private javax.swing.JComboBox<String> personelOzelligi;
    private javax.swing.JComboBox<String> personelRutbesi;
    private javax.swing.JTextField personelSoyadı;
    // End of variables declaration//GEN-END:variables
}
