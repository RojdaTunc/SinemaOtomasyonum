/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sinemaotomasyonum;

import java.sql.Connection;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;





/**
 *
 * @author Rojda
 */

public class sinema extends javax.swing.JFrame {

    
    public sinema() {
        initComponents();
        TabloGETİR();
    }
    
    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";//Sabit
    static final String DOMAIN_NAME="localhost:3306";//Sabit
    static final String DB_NAME="sinemaotomasyonu?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";//Sabit ama database ismini yazmak gerekiyor.
    static final String DB_URL="jdbc:mysql://"+DOMAIN_NAME+"/"+DB_NAME;//Sabit
    static final String USER="root";//MySQL connection user
    static final String PASS="1234";//MySQL connection pass
    private Connection conn =null; //Bağlantı nesnesi
    
    public Statement BaglantiAC() throws Exception{//Mysql Bağlantı Aç
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn=DriverManager.getConnection(DB_URL,USER,PASS);
        return conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
    }
    
    
    public void BaglantiKAPAT() throws Exception{//Mysql Bağlantı Kapat
        conn.close();
    }
    
    
    private void TabloGETİR(){//MySql Tablosunu Getir
        
    try {
            
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn=DriverManager.getConnection(DB_URL,USER,PASS);
        String sql="select * from film_bilgileri";
        PreparedStatement patmt = conn.prepareStatement(sql);
        ResultSet rs=patmt.executeQuery();
        jTable2.setModel(DbUtils.resultSetToTableModel(rs));
        conn.close();
        } 
    
    catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e); 
        }
    }
    
    
    public void FilmSİL(int id){
         
    try {
            
            Statement st=BaglantiAC();
            st.executeUpdate("DELETE FROM sinemaotomasyonu.film_bilgileri where Id="+id);
            BaglantiKAPAT();//Bağlantıyı Kapat
            TabloGETİR();//Penceremdeki tabloyu yeniden doldur (Güncelle)
            JOptionPane.showMessageDialog(null, "Film Silindi");
        }
    catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Film Silinmedi","Hata",JOptionPane.PLAIN_MESSAGE);
        }
        
    }
     
     
    public void FilmDZNLE(String film, String yonetmen, String filmturu, String seans, String salon,int id)throws Exception{
        
        try {
            
            Statement st=BaglantiAC();
            String sql="UPDATE sinemaotomasyonu.film_bilgileri SET "+
            "film_adi='"+film+ "',"+"yonetmen='"+yonetmen+"',"+"film_turu='"+filmturu+"',"
            +"seans='"+seans+"',"+"salon='"+salon+"'"+"WHERE Id="+id;
            st.executeUpdate(sql);//MySQL Sorgusunu Çalıştır
            BaglantiKAPAT();//Bağlantıyı Kapat
            TabloGETİR();//Penceredeki Tabloyu Güncelle
            JOptionPane.showMessageDialog(null, "Yeni Film Kayıt Güncellendi");
            
        } catch (Exception e) {
            
            JOptionPane.showConfirmDialog(null, "Kayıt Güncellenemedi","Error...!!!",JOptionPane.PLAIN_MESSAGE);

        }
    }
    
    
     public void FilmEKLE(String film, String yonetmen, String filmturu, String seans, String salon)throws Exception{
       
        try {
            
            Statement st=BaglantiAC();
            String sql="INSERT INTO film_bilgileri (film_adi, yonetmen, film_turu, seans, salon) VALUES ("+
            "'"+film+ "'," + "'"+yonetmen+"',"+"'"+filmturu+"',"+"'"+seans+"',"+"'"+salon+"')";
            st.executeUpdate(sql); // Sorguyu Çalıştırır.
            BaglantiKAPAT(); // Bağlantıyı Kapat.
            TabloGETİR(); // Penceredeki tabloyu yeniden doldur(Güncelle)
            JOptionPane.showMessageDialog(null, "Film Eklendi");

            } 
        catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Film Eklenirken Hata Oluştu...","Error...!!!",JOptionPane.PLAIN_MESSAGE);
            
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jText_adi = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jText_yontmn = new javax.swing.JTextField();
        jText_seans = new javax.swing.JTextField();
        jText_salon = new javax.swing.JTextField();
        jCombo_tur = new javax.swing.JComboBox<>();
        jButton_ekle = new javax.swing.JButton();
        jButton_duzenle = new javax.swing.JButton();
        jButton_sil = new javax.swing.JButton();
        jButton_temizle = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel1.setText("Fim Adı:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel2.setText("Yönetmen:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel3.setText("Film Türü:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel4.setText("Seans:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel5.setText("Salon:");

        jCombo_tur.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AKSİYON", "BİLİM KURGU", "FANTASTİK", "GERİLİM", "KOMEDİ", "KORKU", "YERLİ" }));

        jButton_ekle.setFont(new java.awt.Font("Stencil", 3, 24)); // NOI18N
        jButton_ekle.setForeground(new java.awt.Color(0, 153, 51));
        jButton_ekle.setText("Ekle");
        jButton_ekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ekleActionPerformed(evt);
            }
        });

        jButton_duzenle.setFont(new java.awt.Font("Stencil", 3, 24)); // NOI18N
        jButton_duzenle.setForeground(new java.awt.Color(153, 153, 255));
        jButton_duzenle.setText("Düzenle");
        jButton_duzenle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_duzenleActionPerformed(evt);
            }
        });

        jButton_sil.setFont(new java.awt.Font("Stencil", 3, 24)); // NOI18N
        jButton_sil.setForeground(new java.awt.Color(204, 0, 0));
        jButton_sil.setText("Sil");
        jButton_sil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_silActionPerformed(evt);
            }
        });

        jButton_temizle.setFont(new java.awt.Font("Stencil", 3, 24)); // NOI18N
        jButton_temizle.setForeground(new java.awt.Color(153, 153, 153));
        jButton_temizle.setText("Temizle");
        jButton_temizle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_temizleActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable2MousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(23, 23, 23))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jText_salon)
                            .addComponent(jText_seans)
                            .addComponent(jText_adi)
                            .addComponent(jText_yontmn)
                            .addComponent(jCombo_tur, 0, 147, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton_temizle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_ekle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_duzenle, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
                    .addComponent(jButton_sil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 884, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton_ekle, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_duzenle, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_sil, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton_temizle, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jText_adi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jText_yontmn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCombo_tur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jText_salon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jText_seans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButton_ekleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ekleActionPerformed
        
        String filmadi,yonetmen,filmturu=null,sure,salon;

        filmadi=jText_adi.getText();
        yonetmen=jText_yontmn.getText();
        sure=jText_seans.getText();
        salon=jText_salon.getText();
        
        switch (jCombo_tur.getSelectedIndex()) {
            case 0:
                filmturu="AKSİYON";
                break;
            case 1:
                filmturu="BİLİM KURGU";
                break;
            case 2:
                filmturu="FANTASTİK";
                break;
            case 3:
                filmturu="GERİLİM";
                break;
            case 4:
                filmturu="KOMEDİ";
                break;
            case 5:
                filmturu="KORKU";
                break;
            case 6:
                filmturu="YERLİ";
                break;     
            default:
                break;
        }

        try {
            
            FilmEKLE(filmadi, yonetmen, filmturu, sure, salon);
        } 
        catch (Exception ex) {
            
            JOptionPane.showMessageDialog(null, ex);
 
        }

                         
    }//GEN-LAST:event_jButton_ekleActionPerformed

    
    private void jButton_duzenleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_duzenleActionPerformed
       
        String filmadi,yonetmen,filmturu=null,sure,salon;

        int id=Integer.parseInt(jTable2.getValueAt(jTable2.getSelectedRow(),0).toString());

        filmadi=jText_adi.getText();
        yonetmen=jText_yontmn.getText();
        sure=jText_seans.getText();
        salon=jText_salon.getText();
        
        switch (jCombo_tur.getSelectedIndex()) {
            case 0:
                filmturu="AKSİYON";
                break;
            case 1:
                filmturu="BİLİM KURGU";
                break;
            case 2:
                filmturu="FANTASTİK";
                break;
            case 3:
                filmturu="GERİLİM";
                break;
            case 4:
                filmturu="KOMEDİ";
                break;
            case 5:
                filmturu="KORKU";
                break;
            case 6:
                filmturu="YERLİ";
                break;     
            default:
                break;
        }
        
        try 
            {
              FilmDZNLE(filmadi, yonetmen, filmturu, sure, salon,id);
            }
        
        catch (Exception ex)
            {
                
              JOptionPane.showMessageDialog(null, ex);

            }
    }//GEN-LAST:event_jButton_duzenleActionPerformed

    
    private void jTable2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MousePressed
       
        jText_adi.setText(jTable2.getValueAt(jTable2.getSelectedRow(),1).toString());
        jText_yontmn.setText(jTable2.getValueAt(jTable2.getSelectedRow(),2).toString());
        jText_seans.setText(jTable2.getValueAt(jTable2.getSelectedRow(),5).toString());
        jText_salon.setText(jTable2.getValueAt(jTable2.getSelectedRow(),4).toString());

        String filmturu=jTable2.getValueAt(jTable2.getSelectedRow(),3).toString();
        
        switch (filmturu) {
            case "AKSİYON":
                jCombo_tur.setSelectedIndex(0);
                break;
            case "BİLİM KURGU":
                jCombo_tur.setSelectedIndex(1);
                break;
            case "FANTASTİK":
                jCombo_tur.setSelectedIndex(2);
                break;
            case "GERİLİM":
                jCombo_tur.setSelectedIndex(3);
                break;
            case "KOMEDİ":
                jCombo_tur.setSelectedIndex(4);
                break;
            case "KORKU":
                jCombo_tur.setSelectedIndex(5);
                break;
            case "YERLİ":
                jCombo_tur.setSelectedIndex(6);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_jTable2MousePressed

    
    private void jButton_silActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_silActionPerformed
            int id=Integer.parseInt(jTable2.getValueAt(jTable2.getSelectedRow(),0).toString()); 
            FilmSİL(id);
    }//GEN-LAST:event_jButton_silActionPerformed

    private void jButton_temizleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_temizleActionPerformed

        jText_adi.setText("");
        jText_salon.setText("");
        jText_seans.setText("");
        jText_yontmn.setText("");
        jCombo_tur.setSelectedIndex(0);
    }//GEN-LAST:event_jButton_temizleActionPerformed

   
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sinema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_duzenle;
    private javax.swing.JButton jButton_ekle;
    private javax.swing.JButton jButton_sil;
    private javax.swing.JButton jButton_temizle;
    private javax.swing.JComboBox<String> jCombo_tur;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jText_adi;
    private javax.swing.JTextField jText_salon;
    private javax.swing.JTextField jText_seans;
    private javax.swing.JTextField jText_yontmn;
    // End of variables declaration//GEN-END:variables
}
