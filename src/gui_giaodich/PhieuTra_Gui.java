/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_giaodich;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import entities.TaiKhoan;
import java.awt.Dimension;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

/**
 *
 * @author nmrhu
 */
public class PhieuTra_Gui extends javax.swing.JPanel {

    /**
     * Creates new form TraCuu_Gui
     */
    public PhieuTra_Gui() {
    	setSize(new Dimension(1500, 700));
        initComponents();        
        khoiTao();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel2.setFont(new Font("Tahoma", Font.PLAIN, 28));
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setFont(new Font("Tahoma", Font.PLAIN, 28));

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new Dimension(1500, 700));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1274, 605));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("/ Phiếu trả");

        jLabel1.setForeground(new java.awt.Color(51, 153, 255));
        jLabel1.setText("Giao dịch");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 1470, Short.MAX_VALUE)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
        			.addGap(10))
        );
        this.setLayout(layout);
    }

    public void khoiTao(){
        ds_PhieuTra_pn = new gui_heThong.PhieuTra_DS_Gui();
        ghiNhanTra_pn = new GhiNhanTra_Gui();
        		
        ds_PhieuTra_pn.setData(tk);
        
        jPanel2.add(ds_PhieuTra_pn);
        ds_PhieuTra_pn.setVisible(true);
    }
    
    public static void dsPhieuTra(TaiKhoan tk){
    	ds_PhieuTra_pn.setData(tk);
        ghiNhanTra_pn.setVisible(false);
        
        jPanel2.add(ds_PhieuTra_pn);
        ds_PhieuTra_pn.setVisible(true);
    }
    
    public static void lapPhieuTra(TaiKhoan tk){
    	ghiNhanTra_pn.setData(tk);
        ds_PhieuTra_pn.setVisible(false);
        jPanel2.add(ghiNhanTra_pn);
        ghiNhanTra_pn.setVisible(true);
    }
    
	public static void setData(TaiKhoan tk_sql) {
    	if(!(tk_sql == null)) {
			tk = tk_sql;
		}
    }
    
//    private static PhieuTra_DS_Gui ds_PhieuTra_pn;
    public static gui_heThong.PhieuTra_DS_Gui ds_PhieuTra_pn;
    private static GhiNhanTra_Gui ghiNhanTra_pn;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private static javax.swing.JPanel jPanel2;
    
    public static TaiKhoan tk;
    // End of variables declaration//GEN-END:variables
}
