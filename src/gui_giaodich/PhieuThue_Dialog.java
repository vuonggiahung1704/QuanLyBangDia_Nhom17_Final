/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_giaodich;

import database.Database;
import entities.ChiTietPhieuDat;
import entities.ChiTietPhieuThue;
import entities.Dia;
import entities.KhachHang;
import entities.PhieuDat;
import entities.PhieuThue;
import entities.PhieuTra;
import entities.TaiKhoan;
import entities.TheLoai;
import entities.TieuDe;
import gui_main.Main;

import javax.swing.GroupLayout.Alignment;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.toedter.calendar.JDateChooser;

import dao.CT_PhieuDat_DAO;
import dao.CT_PhieuThue_DAO;
import dao.Dia_DAO;
import dao.KhachHang_DAO;
import dao.PhieuDat_DAO;
import dao.PhieuThue_DAO;
import dao.TaiKhoan_DAO;
import dao.TheLoai_DAO;
import dao.TieuDe_DAO;
import java.awt.Font;

/**
 *
 * @author nmrhu
 */
public class PhieuThue_Dialog extends javax.swing.JDialog {

	/**
	 * Creates new form TaiKhoan_DL
	 */
	public PhieuThue_Dialog(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {
		Database.getInstance().connect();
		qldia = new Dia_DAO();
		qlkh = new KhachHang_DAO();
		qltd = new TieuDe_DAO();
		qltk = new TaiKhoan_DAO();
		qlpt = new PhieuThue_DAO();
		qldh = new PhieuDat_DAO();
		ql_ctpt = new CT_PhieuThue_DAO();
		ql_ctpd = new CT_PhieuDat_DAO();
		qltl = new TheLoai_DAO();

		jLabel5 = new javax.swing.JLabel();
		jLabel5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLuu = new javax.swing.JButton();
		btnXoaTrang = new javax.swing.JButton();
		txtMaPT = new javax.swing.JTextField();
		txtMaPT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtKhachHang = new javax.swing.JTextField();
		txtKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMaDia = new javax.swing.JTextField();
		txtMaDia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTieuDe = new javax.swing.JTextField();
		txtTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jLabel1 = new javax.swing.JLabel();
		jLabel1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jLabel2 = new javax.swing.JLabel();
		jLabel2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jLabel3 = new javax.swing.JLabel();
		jLabel3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jLabel4 = new javax.swing.JLabel();
		jLabel4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jLabel8 = new javax.swing.JLabel();
		jLabel8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTongTien = new javax.swing.JTextField();
		txtTongTien.setFont(new Font("Tahoma", Font.PLAIN, 20));

		setTitle("Lập phiếu thuê");
		setResizable(false);
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setBackground(new java.awt.Color(255, 255, 255));

		jLabel5.setText("Hạn trả");

		btnLuu.setBackground(new java.awt.Color(0, 153, 255));
		btnLuu.setForeground(new java.awt.Color(255, 255, 255));
		btnLuu.setIcon(
				new javax.swing.ImageIcon("D:\\HK1_Nam_4\\XayDungPhanMem\\Netbeans\\DemoGui\\img\\save_30px.png")); // NOI18N
		btnLuu.setText("Lưu");
		btnLuu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if (LapPhieuThue()) {
					main.traCuu_pn.DocDuLieuDatabaseVaoTable("");
					dispose();
				}
				else {
					//main.datHang_pn.ds_DatHang_pn.DocDuLieuDatabaseVaoTable("", 0);
					JOptionPane.showMessageDialog(null, "Vui lòng chọn hạn trả sau hôm nay");
				}
			}
		});

		btnXoaTrang.setBackground(new java.awt.Color(255, 0, 0));
		btnXoaTrang.setForeground(new java.awt.Color(255, 255, 255));
		btnXoaTrang.setIcon(
				new javax.swing.ImageIcon("D:\\HK1_Nam_4\\XayDungPhanMem\\Netbeans\\DemoGui\\img\\delete_30px.png")); // NOI18N
		btnXoaTrang.setText("Đóng");
		btnXoaTrang.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				dispose();
			}
		});

		txtMaPT.setEditable(false);

		txtKhachHang.setEditable(false);

		txtMaDia.setEditable(false);

		txtTieuDe.setEditable(false);

		jLabel1.setText("Mã PT:");

		jLabel2.setText("Khách hàng");

		jLabel3.setText("Mã đĩa");

		jLabel4.setText("Tiêu đề:");

		jLabel8.setText("Tổng tiền:");

		txtTongTien.setEditable(false);

		txtHanTra = new JDateChooser();

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(jLabel8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
						.addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtHanTra, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(txtMaPT).addComponent(txtKhachHang).addComponent(txtMaDia).addComponent(txtTieuDe)
						.addGroup(layout.createSequentialGroup()
								.addComponent(btnLuu, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnXoaTrang, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
						.addComponent(txtTongTien))
				.addContainerGap(23, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(jLabel1).addComponent(txtMaPT,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel2).addComponent(
						txtKhachHang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel3).addComponent(txtMaDia,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel4).addComponent(txtTieuDe,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(jLabel5).addComponent(txtHanTra,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(12)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel8).addComponent(txtTongTien,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(btnLuu).addComponent(btnXoaTrang))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		getContentPane().setLayout(layout);

		pack();
	}

	public void setData(String maPD) {
		getID();

		dh = qldh.chiTietPhieuDat(maPD);
		TieuDe td = qltd.chiTietTieuDe(dh.getTieuDe().getMaTD());
		ChiTietPhieuDat ctpd = ql_ctpd.getCTPDat_TheoMaPD(dh.getMaDH(), 0);

		kh = qlkh.chiTietKhachHang(dh.getKhachHang().getMaKH());
		d = qldia.chiTietDia(ctpd.getDia().getMaDia());
		tl = qltl.chiTietTheLoai(d.getTheLoai().getMaTL());

		txtKhachHang.setText(kh.getTenKH());
		txtMaDia.setText(d.getMaDia());
		txtTieuDe.setText(td.getTenTD());
		txtHanTra.setDate(new Date());
		txtTongTien.setText("" + tl.getGiaThue());
	}

	public void getID() {
		int id = qlpt.getMaPhieuThue();
		maPT = null;
		if (id == 0) {
			maPT = "PT00001";
		} else if (id < 10)
			maPT = "PT0000" + id;
		else if (id < 100)
			maPT = "PT000" + id;
		else if (id < 1000)
			maPT = "PT00" + id;
		else if (id < 10000)
			maPT = "PT0" + id;
		else
			maPT = "PT" + id;

		txtMaPT.setText(maPT);
	}

	public boolean LapPhieuThue() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String ngayLap = sdf.format(new Date());
		String hanTra = sdf.format(txtHanTra.getDate());

		if (txtHanTra.getDate().before(new Date())) {
			return false;
		} else {
			int tongTien = Integer.parseInt(txtTongTien.getText().toString());
			PhieuThue pt = new PhieuThue(kh, ngayLap, tk, tongTien);
			
			qlpt.themPhieuThue(pt);
			
			ChiTietPhieuThue ctpt = new ChiTietPhieuThue(new PhieuThue(txtMaPT.getText()), new Dia(txtMaDia.getText()), hanTra, tongTien);

			ql_ctpt.them_CTPT(ctpt);
			
			qldia.capNhatTinhTrangDia(1, d.getMaDia());

			ChiTietPhieuDat ctpd = new ChiTietPhieuDat(dh, d, 1);
			ql_ctpd.update(ctpd);

			qldh.update_tinhTrang(2, dh.getMaDH());

			JOptionPane.showMessageDialog(null, "Lập phiếu thuê thành công");
			pd_gui.ds_DatHang_pn.DocDuLieuDatabaseVaoTable("", 0);
			pt_gui.DS_Phieu_pn.DocDuLieuDatabaseVaoTable("", 0);
			return true;
		}
	}

	public static void setTaiKhoan(TaiKhoan tk_sql) {
		tk = tk_sql;
	}

//	public static void main(String args[]) {
//		/* Set the Nimbus look and feel */
//		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
//		// (optional) ">
//		/*
//		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
//		 * look and feel. For details see
//		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//		 */
//		try {
//			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//				if ("Nimbus".equals(info.getName())) {
//					javax.swing.UIManager.setLookAndFeel(info.getClassName());
//					break;
//				}
//			}
//		} catch (ClassNotFoundException ex) {
//			java.util.logging.Logger.getLogger(PhieuThue_Dialog.class.getName()).log(java.util.logging.Level.SEVERE,
//					null, ex);
//		} catch (InstantiationException ex) {
//			java.util.logging.Logger.getLogger(PhieuThue_Dialog.class.getName()).log(java.util.logging.Level.SEVERE,
//					null, ex);
//		} catch (IllegalAccessException ex) {
//			java.util.logging.Logger.getLogger(PhieuThue_Dialog.class.getName()).log(java.util.logging.Level.SEVERE,
//					null, ex);
//		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
//			java.util.logging.Logger.getLogger(PhieuThue_Dialog.class.getName()).log(java.util.logging.Level.SEVERE,
//					null, ex);
//		}
//
//		/* Create and display the dialog */
//		java.awt.EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				PhieuThue_Dialog dialog = new PhieuThue_Dialog(new javax.swing.JFrame(), true);
//				dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//					@Override
//					public void windowClosing(java.awt.event.WindowEvent e) {
//						System.exit(0);
//					}
//				});
//				dialog.setVisible(true);
//			}
//		});
//	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnLuu;
	private javax.swing.JButton btnXoaTrang;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JTextField txtKhachHang;
	private javax.swing.JTextField txtMaDia;
	private javax.swing.JTextField txtMaPT;
	private javax.swing.JTextField txtTieuDe;
	private javax.swing.JTextField txtTongTien;
	private JDateChooser txtHanTra;

	private PhieuDat_DAO qldh;
	private Dia_DAO qldia;
	private TieuDe_DAO qltd;
	private TaiKhoan_DAO qltk;
	private KhachHang_DAO qlkh;
	private CT_PhieuThue_DAO ql_ctpt;
	private PhieuThue_DAO qlpt;
	private CT_PhieuDat_DAO ql_ctpd;
	private TheLoai_DAO qltl;

	private TheLoai tl;
	private Dia d;
	private KhachHang kh;
	private String maPT;
	private PhieuDat dh;

	private Main main;

	public static DatHang_Gui pd_gui;
	public static PhieuThue_Gui pt_gui;
	public static TaiKhoan tk;
}
