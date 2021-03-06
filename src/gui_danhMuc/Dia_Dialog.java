package gui_danhMuc;

import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ListModel;

import dao.Dia_DAO;
import dao.TieuDe_DAO;
import database.Database;
import entities.Dia;
import entities.KhachHang;
import entities.TaiKhoan;
import entities.TheLoai;
import entities.TieuDe;
import gui_main.Main;
import java.awt.Font;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nmrhu
 */
public class Dia_Dialog extends javax.swing.JDialog {

	/**
	 * Creates new form NewJDialog
	 */
	public Dia_Dialog(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();

		getID();

		jPopupMenu1.add(jPanel1);
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
		qltd = new TieuDe_DAO();
		qldia = new Dia_DAO();

		jPanel1 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jList1 = new javax.swing.JList<>();
		jPopupMenu1 = new javax.swing.JPopupMenu();
		jLabel1 = new javax.swing.JLabel();
		jLabel1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jLabel6 = new javax.swing.JLabel();
		jLabel6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jLabel7 = new javax.swing.JLabel();
		jLabel7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMaDia = new javax.swing.JTextField();
		txtMaDia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMaDia.setEditable(false);
		radPhim = new javax.swing.JRadioButton();
		radPhim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		radGame = new javax.swing.JRadioButton();
		radGame.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLuu = new javax.swing.JButton();
		btnDong = new javax.swing.JButton();
		txtTieuDe = new javax.swing.JTextField();
		txtTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 20));

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));

		dm = new DefaultListModel<TieuDe>();
		jList1.setModel(dm);
		jList1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = jList1.getSelectedIndex();
				ListModel<TieuDe> model = jList1.getModel();
				td = model.getElementAt(row);
				txtTieuDe.setText(td.getTenTD());
				jPopupMenu1.setVisible(false);
			}
		});
		jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		jScrollPane1.setViewportView(jList1);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
						.addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE));

		jPopupMenu1.setFocusable(false);

		setResizable(false);
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setBackground(new java.awt.Color(255, 255, 255));

		jLabel1.setText("Mã đĩa:");

		jLabel6.setText("Tên đĩa:");

		jLabel7.setText("Thể loại:");

		radPhim.setSelected(true);
		radPhim.setText("Phim");
		radPhim.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				getRad(radPhim);
			}
		});

		radGame.setText("Game");
		radGame.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				getRad(radGame);
			}
		});

		btnLuu.setBackground(new java.awt.Color(0, 153, 255));
		btnLuu.setForeground(new java.awt.Color(255, 255, 255));
		btnLuu.setIcon(
				new javax.swing.ImageIcon("D:\\HK1_Nam_4\\XayDungPhanMem\\Netbeans\\DemoGui\\img\\save_30px.png")); // NOI18N
		btnLuu.setText("Lưu");
		btnLuu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if (td == null)
					JOptionPane.showMessageDialog(null, "Vui lòng nhập tiêu đề");
				else {
					qldia.themDia(getDia());
					JOptionPane.showMessageDialog(null, "Thêm thành công");
					main.dia_pn.DocDuLieuDatabaseVaoTable("");
					
					getID();
					txtTieuDe.setText("");
					td = null;
				}
			}
		});

		btnDong.setBackground(new java.awt.Color(255, 0, 0));
		btnDong.setForeground(new java.awt.Color(255, 255, 255));
		btnDong.setIcon(
				new javax.swing.ImageIcon("D:\\HK1_Nam_4\\XayDungPhanMem\\Netbeans\\DemoGui\\img\\delete_30px.png")); // NOI18N
		btnDong.setText("Đóng");
		btnDong.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				dispose();
			}
		});

		txtTieuDe.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				txtTieuDeKeyReleased(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
								.addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(txtMaDia, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
								.addGroup(layout.createSequentialGroup().addComponent(radPhim)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(radGame))
								.addGroup(layout.createSequentialGroup()
										.addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 159,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(btnDong, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(txtTieuDe))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel1).addComponent(txtMaDia, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel6).addComponent(txtTieuDe, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel7).addComponent(radPhim).addComponent(radGame))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnLuu).addComponent(btnDong))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pack();
	}

	private void txtTieuDeKeyReleased(java.awt.event.KeyEvent evt) {
		String tieuDe = txtTieuDe.getText().trim();
		DocDuLieuDatabaseVaoTable(tieuDe);
		jPopupMenu1.show(txtTieuDe, 0, txtTieuDe.getHeight());
	}

	public void getID() {
		int id = qldia.getMaDia();
		String maTD = null;
		if (id == 0) {
			maTD = "BD00001";
		} else if (id < 10)
			maTD = "BD0000" + id;
		else if (id < 100)
			maTD = "BD000" + id;
		else if (id < 1000)
			maTD = "BD00" + id;
		else if (id < 10000)
			maTD = "BD0" + id;
		else
			maTD = "BD" + id;

		txtMaDia.setText(maTD);
	}

	public void getRad(JRadioButton rad) {
		radGame.setSelected(false);
		radPhim.setSelected(false);
		rad.setSelected(true);
	}

	public Dia getDia() {
		int theLoai;
		if (radPhim.isSelected())
			theLoai = 1;
		else
			theLoai = 2;
		Dia dia = new Dia(new TheLoai(theLoai), td);
		return dia;
	}

	public void DocDuLieuDatabaseVaoTable(String txtTim) {
		dm = (DefaultListModel<TieuDe>) jList1.getModel();
		dm.removeAllElements();
		List<TieuDe> list = new ArrayList<TieuDe>();
		qltd = new TieuDe_DAO();
		if (txtTim.equals(""))
			list = qltd.danhSachTieuDe();
		else
			list = qltd.tim_TieuDe(txtTim);

		if (!list.isEmpty()) {
			for (TieuDe tieuDe : list) {
				dm.addElement(tieuDe);
			}
		}
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnDong;
	private javax.swing.JButton btnLuu;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JList<TieuDe> jList1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPopupMenu jPopupMenu1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JRadioButton radGame;
	private javax.swing.JRadioButton radPhim;
	private javax.swing.JTextField txtMaDia;
	private javax.swing.JTextField txtTieuDe;
	private DefaultListModel<TieuDe> dm;

	private TieuDe td;
	private TieuDe_DAO qltd;
	private Dia_DAO qldia;
	private Main main;
	// End of variables declaration//GEN-END:variables
}
