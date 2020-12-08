/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_giaodich;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.GroupLayout.Alignment;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dao.KhachHang_DAO;
import dao.PhieuDat_DAO;
import dao.TaiKhoan_DAO;
import dao.TieuDe_DAO;
import database.Database;
import entities.KhachHang;
import entities.PhieuDat;
import entities.TaiKhoan;
import entities.TieuDe;
import gui_baocao.BaoCao_Dia_Gui;
import gui_danhMuc.KhachHang_Dialog;
import gui_main.Main;

import javax.swing.JLabel;
import java.awt.Font;

/**
 *
 * @author nmrhu
 */
public class DatHang_Lap_Gui extends javax.swing.JPanel {

	/**
	 * Creates new form PhieuThue_Lap_Gui
	 */
	public DatHang_Lap_Gui() {
		setSize(new Dimension(1274, 605));
		initComponents();
		
		jPopupMenu1.add(jPanel3);

		clear();

		DocDuLieuDatabaseVaoTable("");
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
		qlkh = new KhachHang_DAO();
		qltk = new TaiKhoan_DAO();
		qldh = new PhieuDat_DAO();
		qltd = new TieuDe_DAO();

		jPopupMenu1 = new javax.swing.JPopupMenu();
		jPopupMenu1.setFocusable(false);
		
		jPanel3 = new javax.swing.JPanel();
		jScrollPane3 = new javax.swing.JScrollPane();
		jList1 = new javax.swing.JList<>();
		jLabel7 = new javax.swing.JLabel();
		jLabel7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jLabel8 = new javax.swing.JLabel();
		jLabel8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMaDH = new javax.swing.JTextField();
		txtMaDH.setEditable(false);
		txtMaDH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtKhachHang = new javax.swing.JTextField();
		txtKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtKhachHang.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				txtKhachHangKeyPressed(evt);
			}
		});
		
		btnThemKhachHang = new javax.swing.JButton();
		btnThemKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KhachHang_Dialog dialog = new KhachHang_Dialog(main, true);
				dialog.setTitle("Thêm khách hàng");
				dialog.setLocationRelativeTo(main);
				dialog.quyen = 1;
				dialog.setVisible(true);
			}
		});
		
		btnDatHang = new javax.swing.JButton();
		jLabel11 = new javax.swing.JLabel();
		jLabel11.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNhanVien1 = new javax.swing.JTextField();
		txtNhanVien1.setEditable(false);
		txtNhanVien1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jLabel12 = new javax.swing.JLabel();
		jLabel12.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNgayLap = new javax.swing.JTextField();
		txtNgayLap.setEditable(false);
		jPanel1 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		tableTenDia = new javax.swing.JTable();
		txtTim = new javax.swing.JTextField();
		txtTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jLabel2 = new javax.swing.JLabel();
		jLabel2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTim = new javax.swing.JButton();
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBack = new javax.swing.JButton();
		jLabel3 = new javax.swing.JLabel();
		jLabel3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jLabel4 = new javax.swing.JLabel();
		jLabel4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMaTD = new javax.swing.JTextField();
		txtMaTD.setEditable(false);
		txtMaTD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTieuDe = new javax.swing.JTextField();
		txtTieuDe.setEditable(false);
		txtTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 20));

		jPanel3.setBackground(new java.awt.Color(255, 255, 255));
		jPanel3.setLayout(new java.awt.BorderLayout());

		jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		jList1.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jScrollPane3.setViewportView(jList1);

		jPanel3.add(jScrollPane3, java.awt.BorderLayout.CENTER);

		setBackground(new java.awt.Color(255, 255, 255));

		jLabel7.setText("Mã Đặt hàng:");

		jLabel8.setText("Khách hàng:");

		btnThemKhachHang.setText("Thêm Khách hàng");

		btnDatHang.setBackground(new java.awt.Color(51, 153, 255));
		btnDatHang.setForeground(new java.awt.Color(255, 255, 255));
		btnDatHang.setIcon(
				new javax.swing.ImageIcon("D:\\HK1_Nam_4\\XayDungPhanMem\\Netbeans\\DemoGui\\img\\save_30px.png")); // NOI18N
		btnDatHang.setText("Đặt hàng");
		btnDatHang.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if (kh == null) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng");
				} else {
					themDatHang();
					main.dia_pn = new gui_danhMuc.Dia_Gui();
					main.traCuu_pn = new TraCuu_Dia_Gui();
					main.bcDia_pn = new BaoCao_Dia_Gui();
				}
			}
		});

		DefaultListModel<KhachHang> dm_khachHang = new DefaultListModel<KhachHang>();
		jList1.setModel(dm_khachHang);
		jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		jList1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ChiTietKhachHang();
			}
		});
		
		jLabel11.setText("Người lập:");
		jLabel11.setFont(new Font("Tahoma", Font.PLAIN, 20));

		jLabel12.setText("Ngày lập:");
		jLabel12.setFont(new Font("Tahoma", Font.PLAIN, 20));

		jPanel1.setLayout(new java.awt.BorderLayout());

		tableTenDia.setRowHeight(40);
		tableTenDia.setFont(new java.awt.Font("Times New Roman", 0, 26)); // NOI18N
		dm = new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Mã tiêu đề", "Tên đĩa"}) {
			boolean[] canEdit = new boolean[] { false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		};
		tableTenDia.setModel(dm);
		tableTenDia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableTenDia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = tableTenDia.getSelectedRow();
				TableModel model = tableTenDia.getModel();
				txtMaTD.setText(model.getValueAt(row, 0).toString());
				txtTieuDe.setText(model.getValueAt(row, 1).toString());
				btnDatHang.setEnabled(true);
			}
		});
		
		jScrollPane1.setViewportView(tableTenDia);

		jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

		jLabel2.setForeground(new java.awt.Color(51, 153, 255));
		jLabel2.setText("Danh sách đĩa:");
		

		btnTim.setBackground(new java.awt.Color(51, 153, 255));
		btnTim.setIcon(
				new javax.swing.ImageIcon("D:\\HK1_Nam_4\\XayDungPhanMem\\Netbeans\\QuanLy\\img\\search_30px.png")); // NOI18N
		btnTim.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				String txt = txtTim.getText();
				DocDuLieuDatabaseVaoTable(txt);
			}
		});
		
		
		btnBack.setBackground(new java.awt.Color(255, 255, 255));
		btnBack.setIcon(new javax.swing.ImageIcon(
				"D:\\HK1_Nam_4\\XayDungPhanMem\\Netbeans\\QuanLy\\img\\icons8-back-arrow-30.png")); // NOI18N
		
		btnBack.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnBackActionPerformed(evt);
			}
		});

		jLabel3.setText("Mã tiêu đề:");

		jLabel4.setText("Tiêu đề:");
		
		JLabel jLabel4_1 = new JLabel();
		jLabel4_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		jLabel4_1.setText("dsa");
		
		jLabel4_2 = new JLabel();

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
					.addGap(24)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 1235, Short.MAX_VALUE)
						.addGroup(layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
									.addGroup(layout.createParallelGroup(Alignment.LEADING)
										.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(jLabel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(jLabel8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addComponent(jLabel12, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel2))
									.addGap(23)
									.addGroup(layout.createParallelGroup(Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
											.addGroup(layout.createParallelGroup(Alignment.TRAILING)
												.addGroup(layout.createSequentialGroup()
													.addComponent(txtKhachHang, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
													.addGap(11)
													.addComponent(btnThemKhachHang, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
												.addGroup(layout.createSequentialGroup()
													.addGap(1)
													.addComponent(txtMaDH, GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE))
												.addGroup(layout.createSequentialGroup()
													.addGroup(layout.createParallelGroup(Alignment.TRAILING)
														.addComponent(txtNgayLap, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
														.addComponent(txtNhanVien1, GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE))
													.addGap(1)))
											.addGap(18))
										.addGroup(layout.createSequentialGroup()
											.addComponent(txtTim, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
											.addGap(18)
											.addComponent(btnTim, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
											.addGap(19)))
									.addGroup(layout.createParallelGroup(Alignment.TRAILING)
										.addGroup(layout.createSequentialGroup()
											.addComponent(jLabel4_2, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.RELATED))
										.addComponent(jLabel4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
										.addComponent(jLabel3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addComponent(jLabel11, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
							.addGroup(layout.createParallelGroup(Alignment.TRAILING)
								.addGroup(layout.createSequentialGroup()
									.addGap(37)
									.addGroup(layout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnDatHang, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
										.addComponent(txtTieuDe, GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
										.addComponent(txtMaTD, GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)))
								.addGroup(layout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap())
				.addGroup(layout.createSequentialGroup()
					.addContainerGap(609, Short.MAX_VALUE)
					.addComponent(jLabel4_1, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
					.addGap(494))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(jLabel7)
						.addComponent(txtMaDH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBack))
					.addGap(12)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(jLabel8)
								.addComponent(txtKhachHang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnThemKhachHang))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(jLabel11)
								.addComponent(txtNhanVien1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(22)
							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLabel12)
								.addComponent(txtNgayLap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLabel3)
								.addComponent(txtMaTD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(20)
							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLabel4)
								.addComponent(txtTieuDe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnDatHang)
								.addComponent(jLabel4_1, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtTim)
							.addComponent(jLabel2))
						.addComponent(jLabel4_2)
						.addComponent(btnTim, 0, 0, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
					.addGap(9))
		);
		this.setLayout(layout);
	}

	private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {
		dh_gui.dsDatHang();
	}

	public void getID() {
		int id = qldh.getMaPhieuDat();
		String maPT = null;
		if (id == 0) {
			maPT = "PD00001";
		} else if (id < 10)
			maPT = "PD0000" + id;
		else if (id < 100)
			maPT = "PD000" + id;
		else if (id < 1000)
			maPT = "PD00" + id;
		else if (id < 10000)
			maPT = "PD0" + id;
		else
			maPT = "PD" + id;

		txtMaDH.setText(maPT);
	}

	private void txtKhachHangKeyPressed(java.awt.event.KeyEvent evt) {
		String khachHang_tim = txtKhachHang.getText().trim();
		if (khachHang_tim.equals("") || khachHang_tim.isEmpty()) {
			DocDuLieuDatabaseVaoList("");
			jPopupMenu1.show(txtKhachHang, 0, txtKhachHang.getHeight());
		} else {
			DocDuLieuDatabaseVaoList(khachHang_tim);
			jPopupMenu1.show(txtKhachHang, 0, txtKhachHang.getHeight());
		}
	}

	public void XoaHetDuLieuTrenListModel() {
		DefaultListModel<KhachHang> dm = (DefaultListModel<KhachHang>) jList1.getModel();
		dm.clear();
	}

	public void DocDuLieuDatabaseVaoList(String txt) {
		XoaHetDuLieuTrenListModel();
		List<KhachHang> list = new ArrayList<KhachHang>();
		qlkh = new KhachHang_DAO();
		if (txt.equals("") || txt.isEmpty()) {
			list = qlkh.dsKhachHang();
		} else {
			try {
				list = qlkh.tim_KhachHang(txt);
			} catch (Exception e) {
				XoaHetDuLieuTrenListModel();
			}
			DefaultListModel<KhachHang> dm = (DefaultListModel<KhachHang>) jList1.getModel();
			for (KhachHang khachHang : list) {
				dm.addElement(khachHang);
			}
		}
	}

	public void ChiTietKhachHang() {
		int row = jList1.getSelectedIndex();
		ListModel<KhachHang> model = jList1.getModel();
		kh = model.getElementAt(row);
		txtKhachHang.setText(kh.getTenKH());
		jPopupMenu1.setVisible(false);
	}

	public void DocDuLieuDatabaseVaoTable(String txt) {
		dm = (DefaultTableModel) tableTenDia.getModel();
		dm.setRowCount(0);
		List<TieuDe> list = new ArrayList<TieuDe>();
		qltd = new TieuDe_DAO();

		if (txt.equals("")) {
			list = qltd.danhSach_Dia_KhongCoSan();
		} else {
			list = qltd.tim_TieuDe_KhongCoSan(txt);
		}
		
		for (TieuDe td : list) {
			dm.addRow(new Object[] { td.getMaTD(), td.getTenTD() });
		}
	}

	public void themDatHang() {
		SimpleDateFormat sdf1 = new SimpleDateFormat("hh:mm:ss");
		String time = sdf1.format(new Date());

		String maTD = txtMaTD.getText();
		String ngaydat = txtNgayLap.getText();

		
		try {
			PhieuDat dh = new PhieuDat(kh, new TieuDe(maTD), ngaydat, time, tk, 0);
			qldh.themDatHang(dh);
			JOptionPane.showMessageDialog(null, "Thêm đơn đặt hàng thành công");
			dh_gui.ds_DatHang_pn.DocDuLieuDatabaseVaoTable("", 0);
			clear();
		} catch (HeadlessException e) {
			JOptionPane.showMessageDialog(null, "Thêm đơn đặt hàng không thành công");
		}
	}

	public void clear() {
		getID();
		btnDatHang.setEnabled(false);
		DocDuLieuDatabaseVaoTable("");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("hh:mm:ss");
		String date = sdf.format(new Date());
		txtNgayLap.setText(date);

		txtKhachHang.setText("");
		txtTieuDe.setText("");
		txtMaTD.setText("");
		if(tk != null)
		txtNhanVien1.setText(tk.getHoTen());
		
		kh = null;
	}
	
	public static void setData(TaiKhoan tk_sql) {
		tk = tk_sql;
		txtNhanVien1.setText(tk.getHoTen());
	}
	
	private DatHang_Gui dh_gui;
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnBack;
	private javax.swing.JButton btnDatHang;
	private javax.swing.JButton btnThemKhachHang;
	private javax.swing.JButton btnTim;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JList<KhachHang> jList1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPopupMenu jPopupMenu1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JTable tableTenDia;
	private javax.swing.JTextField txtKhachHang;
	private javax.swing.JTextField txtMaDH;
	private javax.swing.JTextField txtMaTD;
	private javax.swing.JTextField txtNgayLap;
	private static javax.swing.JTextField txtNhanVien1;
	private javax.swing.JTextField txtTieuDe;
	private javax.swing.JTextField txtTim;
	
	private javax.swing.table.DefaultTableModel dm;
	
	private TaiKhoan_DAO qltk;
	private TieuDe_DAO qltd;
	private KhachHang_DAO qlkh;
	private PhieuDat_DAO qldh;
	private KhachHang kh;

	private Main main;
	
	public static TaiKhoan tk;
	private JLabel jLabel4_2;
}