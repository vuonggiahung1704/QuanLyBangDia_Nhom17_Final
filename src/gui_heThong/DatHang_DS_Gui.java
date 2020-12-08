/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_heThong;
import javax.swing.GroupLayout.Alignment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.toedter.calendar.JDateChooser;

import dao.CT_PhieuDat_DAO;
import dao.Dia_DAO;
import dao.KhachHang_DAO;
import dao.PhieuDat_DAO;
import dao.PhieuThue_DAO;
import dao.TaiKhoan_DAO;
import dao.TieuDe_DAO;
import database.Database;
import entities.ChiTietPhieuDat;
import entities.Dia;
import entities.KhachHang;
import entities.PhieuDat;
import entities.PhieuThue;
import entities.TaiKhoan;
import entities.TieuDe;
import gui_baocao.BaoCao_Dia_Gui;
import gui_danhMuc.Dia_Gui;
import gui_danhMuc.KhachHang_Dialog;
import gui_giaodich.DatHang_Gui;
import gui_giaodich.PhieuThue_Dialog;
import gui_giaodich.TraCuu_Dia_Gui;
import gui_main.Main;

/**
 *
 * @author nmrhu
 */
public class DatHang_DS_Gui extends javax.swing.JPanel {

    /**
     * Creates new form TraCuu_KhachHang_Gui
     */
    public DatHang_DS_Gui() {
        initComponents();
                
        DocDuLieuDatabaseVaoTable("",0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	Database.getInstance().connect();
		qlkh = new KhachHang_DAO();
		qltd = new TieuDe_DAO();
		qltk = new TaiKhoan_DAO();
		qldh = new PhieuDat_DAO();		
		qldia = new Dia_DAO();
		ql_ctpd = new CT_PhieuDat_DAO();
		
		jPopupMenu1 = new javax.swing.JPopupMenu();
		jPopupMenu1.setFocusable(false);
    	
		mnXemLapPhieu = new javax.swing.JMenuItem();
		mnXemLapPhieu.setText("Xử lý đơn hàng");
		mnXemLapPhieu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        PhieuDat dh = qldh.chiTietPhieuDat(maPD);
		        if(dh.getTinhTrang() == 1) {
		        	PhieuThue_Dialog dialog = new PhieuThue_Dialog(main, true);
		        	dialog.setLocationRelativeTo(main);
		        	dialog.setData(maPD);
		        	dialog.setTaiKhoan(tk);
		        	dialog.setVisible(true);
		        }else if(dh.getTinhTrang() == 2){
		        	JOptionPane.showMessageDialog(null, "Đơn hàng đã được xử lý");
		        }else {
		        	JOptionPane.showMessageDialog(null, "Đơn hàng chưa thể xử lý");
		        }
			}
		});
		jPopupMenu1.add(mnXemLapPhieu);

		mnXoaDatHang = new javax.swing.JMenuItem();
		mnXoaDatHang.setText("Xóa đơn đặt hàng");
		mnXoaDatHang.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PhieuDat dh = qldh.chiTietPhieuDat(maPD);
				if(dh.getTinhTrang() == 0 ) {
					qldh.delete(maPD);
					JOptionPane.showMessageDialog(null, "Xóa đơn đặt hàng thành công");
					DocDuLieuDatabaseVaoTable("",0);
					
					main.dia_pn = new Dia_Gui();
					
				}else if(dh.getTinhTrang() == 1 ){
					String maTD = dh.getTieuDe().getMaTD();
					ChiTietPhieuDat ctpd = ql_ctpd.getCTPDat_TheoMaPD(maPD, 0);
					
					PhieuDat pdh_dubi = qldh.phieuDat_TieuDe_ThuHai(maTD, maPD);
					if(pdh_dubi == null) {
						qldia.capNhatTinhTrangDia(0, ctpd.getDia().getMaDia());
					}else {
						ChiTietPhieuDat ctpd_dubi = new ChiTietPhieuDat(pdh_dubi, new Dia(ctpd.getDia().getMaDia()), 0);
						ql_ctpd.them_CTPD(ctpd_dubi);
						qldia.capNhatTinhTrangDia(2, ctpd.getDia().getMaDia());
						qldh.update_tinhTrang(1, ctpd_dubi.getPhieuDat().getMaDH());
					}
					ql_ctpd.delete(maPD);
					qldh.delete(maPD);
					JOptionPane.showMessageDialog(null, "Xóa đơn đặt hàng thành công");
					DocDuLieuDatabaseVaoTable("",0);
					main.dia_pn.DocDuLieuDatabaseVaoTable("");
					main.traCuu_pn.DocDuLieuDatabaseVaoTable("");
					main.bcDia_pn.DocDuLieuDatabaseVaoTable("");
					
		        }else {
					JOptionPane.showMessageDialog(null, "Đơn hàng không thể xóa");
		        }
			}
		});
		jPopupMenu1.add(mnXoaDatHang);
		
		mnThongTinKhachHang = new javax.swing.JMenuItem();
		mnThongTinKhachHang.setText("Thông tin khách hàng");
		mnThongTinKhachHang.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PhieuDat dh = qldh.chiTietPhieuDat(maPD);
				KhachHang kh = qlkh.chiTietKhachHang(dh.getKhachHang().getMaKH());
		        KhachHang_Dialog dialog = new KhachHang_Dialog(main, true);
		        dialog.setLocationRelativeTo(main);
	        	dialog.lienLacKhachHang(kh);
	        	dialog.setVisible(true);
			}
		});
		jPopupMenu1.add(mnThongTinKhachHang);
    	
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDatHang = new javax.swing.JTable();
        btnTim = new javax.swing.JButton();
        txtTim = new javax.swing.JTextField();
        btnTim1 = new javax.swing.JButton();
        btnLapPhieuDatHang = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1274, 605));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jTableDatHang.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        dm = new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] {"Mã phiếu đặt","Tên đĩa","Tên khách hàng", "Ngày đặt", "Thời gian","Người lập","Trang thái" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false,false,false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		};
		jTableDatHang.setModel(dm);
        jTableDatHang.setRowHeight(40);
        jTableDatHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(SwingUtilities.isRightMouseButton(e)) {
					jPopupMenu1.show(e.getComponent(), e.getX(), e.getY());
				}else {
					int row = jTableDatHang.getSelectedRow();
					TableModel model = jTableDatHang.getModel();
					maPD = model.getValueAt(row, 0).toString();
				}
			}
		});
        jTableDatHang.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jTableDatHang.setFont(new java.awt.Font("Times New Roman", 0, 26)); // NOI18N
        jScrollPane1.setViewportView(jTableDatHang);

        jPanel4.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        btnTim.setBackground(new java.awt.Color(0, 153, 255));
        btnTim.setForeground(new java.awt.Color(255, 255, 255));
        btnTim.setIcon(new javax.swing.ImageIcon("D:\\HK1_Nam_4\\XayDungPhanMem\\Netbeans\\DemoGui\\img\\search_30px.png")); // NOI18N
        btnTim.setText("Tìm kiếm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String txt = txtTim.getText().toString();
                DocDuLieuDatabaseVaoTable(txt, 0);
                dateChooser.setDate(new Date());
            }
        });

        btnTim1.setBackground(new java.awt.Color(0, 153, 255));
        btnTim1.setForeground(new java.awt.Color(255, 255, 255));
        btnTim1.setIcon(new javax.swing.ImageIcon("D:\\HK1_Nam_4\\XayDungPhanMem\\DoAnQuanLyChoThueBangDia\\XayDungPhanMem\\img\\filter_30px.png")); // NOI18N
        btnTim1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               DocDuLieuDatabaseVaoTable("", 1);
               txtTim.setText("");
            }
        });

        btnLapPhieuDatHang.setBackground(new java.awt.Color(51, 153, 255));
        btnLapPhieuDatHang.setForeground(new java.awt.Color(255, 255, 255));
        btnLapPhieuDatHang.setIcon(new javax.swing.ImageIcon("D:\\HK1_Nam_4\\XayDungPhanMem\\Netbeans\\DemoGui\\img\\add_property_30px.png")); // NOI18N
        btnLapPhieuDatHang.setText("Thêm phiếu đặt hàng");
        btnLapPhieuDatHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	dh.lapDatHang();
            }
        });
        
        dateChooser = new JDateChooser();
        dateChooser.setDate(new Date());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jPanel4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1244, Short.MAX_VALUE)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(txtTim, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btnTim, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(btnTim1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, 229, Short.MAX_VALUE)
        					.addComponent(btnLapPhieuDatHang, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(txtTim, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(btnTim, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        					.addGap(15))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(btnLapPhieuDatHang)
        					.addPreferredGap(ComponentPlacement.UNRELATED))
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        						.addComponent(btnTim1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(dateChooser, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        					.addGap(15)))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
        			.addContainerGap())
        );
        this.setLayout(layout);
    }

    public void XoaHetDuLieuTrenTableModel() {
		DefaultTableModel dm = (DefaultTableModel) jTableDatHang.getModel();
		dm.getDataVector().removeAllElements();
	}

//    public void CapNhatDatabase() {
//    	DocDuLieuDatabaseVaoTable();
//    }
    
	public void DocDuLieuDatabaseVaoTable(String txt, int tim) {
		XoaHetDuLieuTrenTableModel();
		List<PhieuDat> list = new ArrayList<PhieuDat>();
		qldh = new PhieuDat_DAO();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (tim == 1) {
			
			String date = sdf.format(dateChooser.getDate());
			list = qldh.timPhieuDat_Ngay(date);
			
			if (list.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Không tìm thấy");
				dateChooser.setDate(new Date());
				String date1 = sdf.format(dateChooser.getDate());
				list = qldh.timPhieuDat_Ngay(date1);
			}
			
		} else {
//			dateChooser.setDate(new Date());
//			String date = sdf.format(dateChooser.getDate());
			
			if (txt.equals(""))
				list = qldh.dsDatHang();
			else {
				list = qldh.timPhieuDat_Nhap(txt);
				if (list.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Không tìm thấy");
					list = qldh.dsDatHang();
				}
			}
						
		}

		DefaultTableModel dm = (DefaultTableModel) jTableDatHang.getModel();
		for (PhieuDat dh : list) {
			KhachHang kh = qlkh.chiTietKhachHang(dh.getKhachHang().getMaKH());
			TieuDe td = qltd.chiTietTieuDe(dh.getTieuDe().getMaTD());
			TaiKhoan tk = qltk.chiTietTaiKhoan(dh.getTaiKhoan().getTenTK());
			String tinhTrang = "";
			if(dh.getTinhTrang() == 0)
				tinhTrang = "";
			else if(dh.getTinhTrang() == 1)
				tinhTrang = "Chờ khách nhận";
			else	
				tinhTrang = "Hoàn thành";
			
			dm.addRow(new Object[] {dh.getMaDH(),td.getTenTD(),kh.getTenKH(),dh.getNgayDat(),dh.getGioDat(),tk.getHoTen(),tinhTrang});
		}
	}
    
	private void getDia_PhieuDat(String maPD) {
		PhieuDat dh = qldh.chiTietPhieuDat(maPD);
		ChiTietPhieuDat ctpd = ql_ctpd.getCTPDat_TheoMaPD(maPD, 0);
	}
    
	public static void phanQuyen(TaiKhoan tk_sql) {
		tk = tk_sql;
		if(tk.getQuyen() == 1) {
			mnXoaDatHang.setEnabled(false);
		}else {
			mnXoaDatHang.setEnabled(true);
		}
	}
	
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu jPopupMenu1;
	private javax.swing.JMenuItem mnXemLapPhieu;
	public static javax.swing.JMenuItem mnXoaDatHang;
	private javax.swing.JMenuItem mnThongTinKhachHang;
    
    private javax.swing.JButton btnLapPhieuDatHang;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnTim1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDatHang;
    private javax.swing.JTextField txtTim;
    private javax.swing.table.DefaultTableModel dm;
    
    private DatHang_Gui dh;

    private KhachHang_DAO qlkh;
    private TieuDe_DAO qltd;
    private TaiKhoan_DAO qltk;
    private PhieuDat_DAO qldh;
    private Dia_DAO qldia;
    private CT_PhieuDat_DAO ql_ctpd;
    
    private String maPD;
    
    private Main main;
    
    private JDateChooser dateChooser;
    
    public static TaiKhoan tk;
}
