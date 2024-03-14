package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import BLL.BanHangBLL;
import DTO.BanHangDTO;
import DTO.LayThongTinKhuyenMaiDTO;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

@SuppressWarnings("serial")
public class TimKiemKM extends JFrame {
	private JTextField txtMaKM_TKKM;
	private JTextField txtTenKM_TKKM;
	private JTable tableListKhuyenMai;
	private BanHangBLL bhBLL = new BanHangBLL();
	private JDateChooser dateChooserTu;
	private JTextField txtDonViGiam;
	private JTextField txtGiaTriGiam;
	private JTextField txtMaKhuyenMaiTim;
	private JTable tableListCTKM_TKKM;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimKiemKM frame = new TimKiemKM();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TimKiemKM() {
		getContentPane().setBackground(new Color(192, 192, 192));

		getContentPane().setLayout(null);

		JLabel lbl = new JLabel("Tìm Kiếm Khuyến Mãi");
		lbl.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl.setBounds(385, 10, 222, 40);
		getContentPane().add(lbl);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"T\u00ECm ki\u1EBFm khuy\u1EBFn m\u00E3i", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel.setBounds(10, 60, 450, 350);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblMaKM_TKKH = new JLabel("Mã KM:");
		lblMaKM_TKKH.setBounds(20, 25, 92, 25);
		panel.add(lblMaKM_TKKH);
		lblMaKM_TKKH.setFont(new Font("Tahoma", Font.BOLD, 14));

		txtMaKM_TKKM = new JTextField();
		txtMaKM_TKKM.setBounds(110, 27, 120, 25);
		panel.add(txtMaKM_TKKM);
		txtMaKM_TKKM.setColumns(10);

		txtTenKM_TKKM = new JTextField();
		txtTenKM_TKKM.setBounds(310, 25, 120, 25);
		panel.add(txtTenKM_TKKM);
		txtTenKM_TKKM.setColumns(10);

		JLabel lblTenKH_TKKH = new JLabel("Tên KM:");
		lblTenKH_TKKH.setBounds(240, 25, 60, 25);
		panel.add(lblTenKH_TKKH);
		lblTenKH_TKKH.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel lblNewLabel = new JLabel("Lọc theo ngày:");
		lblNewLabel.setBounds(30, 70, 103, 20);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblMaKH_TKKH_1 = new JLabel("Từ:");
		lblMaKH_TKKH_1.setBounds(20, 95, 51, 25);
		panel.add(lblMaKH_TKKH_1);
		lblMaKH_TKKH_1.setFont(new Font("Tahoma", Font.BOLD, 14));

		dateChooserTu = new JDateChooser();
		dateChooserTu.setBounds(60, 95, 120, 25);
		panel.add(dateChooserTu);
		dateChooserTu.setDateFormatString("yyyy-MM-dd");

		JDateChooser dateChooserDen = new JDateChooser();
		dateChooserDen.setBounds(230, 95, 120, 25);
		panel.add(dateChooserDen);
		dateChooserDen.setDateFormatString("yyyy-MM-dd");

		JLabel lblTenKH_TKKH_1 = new JLabel("Đến:");
		lblTenKH_TKKH_1.setBounds(190, 95, 35, 25);
		panel.add(lblTenKH_TKKH_1);
		lblTenKH_TKKH_1.setFont(new Font("Tahoma", Font.BOLD, 14));

		// JButton btnTimKiem = new JButton("Lọc");
		// btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 14));
		// btnTimKiem.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent e) {
		// try {
		// String tenKhachHang = txtTenKHTim_TKKH.getText();
		// if (tenKhachHang.isEmpty()) {
		// JOptionPane.showMessageDialog(btnTimKiem, "Giá trị không được để trống!!!");
		// return;
		// }
		// ArrayList<BanHangDTO> listKH = new BanHangBLL().timkiem(tenKhachHang);
		// ListTableKhachHang(listKH);
		// } catch (Exception e2) {
		// JOptionPane.showMessageDialog(btnTimKiem, "Tìm kiếm thất bại");
		// }
		// }
		// });
		// btnTimKiem.setBounds(204, 199, 80, 30);
		// getContentPane().add(btnTimKiem);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 150, 420, 190);
		panel.add(scrollPane);

		tableListKhuyenMai = new JTable();
		tableListKhuyenMai.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getEventKhachHang();
			}
		});
		tableListKhuyenMai.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				getEventKhachHang();
			}
		});
		tableListKhuyenMai.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 khuy\u1EBFn m\u00E3i", "T\u00EAn khuy\u00EAn m\u00E3i",
						"Ng\u00E0y b\u1EAFt \u0111\u1EA7u", "Ng\u00E0y k\u1EBFt th\u00FAc" }));
		scrollPane.setViewportView(tableListKhuyenMai);

		JButton btnLoc = new JButton("Lọc");
		btnLoc.setBackground(new Color(255, 0, 0));
		btnLoc.setForeground(new Color(255, 255, 255));
		btnLoc.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLoc.setBounds(360, 90, 70, 35);
		panel.add(btnLoc);

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(255, 255, 255));
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBorder(new TitledBorder(null, "T\u00ECm ki\u1EBFm chi ti\u1EBFt khuy\u1EBFn m\u00E3i",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(470, 60, 440, 350);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblMaKH_TKKH_2 = new JLabel("Đơn vị giảm:");
		lblMaKH_TKKH_2.setBounds(15, 25, 110, 25);
		panel_1.add(lblMaKH_TKKH_2);
		lblMaKH_TKKH_2.setFont(new Font("Tahoma", Font.BOLD, 14));

		txtDonViGiam = new JTextField();
		txtDonViGiam.setBounds(135, 27, 100, 25);
		panel_1.add(txtDonViGiam);
		txtDonViGiam.setColumns(10);

		JLabel lblTenKH_TKKH_2 = new JLabel("Giá trị giảm:");
		lblTenKH_TKKH_2.setBounds(245, 25, 88, 25);
		panel_1.add(lblTenKH_TKKH_2);
		lblTenKH_TKKH_2.setFont(new Font("Tahoma", Font.BOLD, 14));

		txtGiaTriGiam = new JTextField();
		txtGiaTriGiam.setBounds(330, 25, 100, 25);
		panel_1.add(txtGiaTriGiam);
		txtGiaTriGiam.setColumns(10);

		JLabel lblMaKH_TKKH_1_1 = new JLabel("Mã khuyến mãi:");
		lblMaKH_TKKH_1_1.setBounds(58, 95, 130, 25);
		panel_1.add(lblMaKH_TKKH_1_1);
		lblMaKH_TKKH_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));

		txtMaKhuyenMaiTim = new JTextField();
		txtMaKhuyenMaiTim.setBounds(200, 95, 130, 25);
		txtMaKhuyenMaiTim.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				//JOptionPane.showMessageDialog(null, txtMaSPTim_SP.getText());
				ListTableCTKhuyenMai(bhBLL.timkiemCTKM(txtMaKhuyenMaiTim.getText()));
			}
		});
		panel_1.add(txtMaKhuyenMaiTim);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 150, 420, 190);
		panel_1.add(scrollPane_1);

		tableListCTKM_TKKM = new JTable();
		tableListCTKM_TKKM.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				getEventCTKhachHang();
			}
		});
		tableListCTKM_TKKM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getEventCTKhachHang();
			}
		});
		tableListCTKM_TKKM.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "M\u00E3 khuy\u1EBFn m\u00E3i",
				"M\u00E3 s\u1EA3n ph\u1EA9m", "Gi\u00E1 tr\u1ECB gi\u1EA3m", "\u0110\u01A1n v\u1ECB gi\u1EA3m" }));
		scrollPane_1.setViewportView(tableListCTKM_TKKM);

		JLabel lblNewLabel_1 = new JLabel("Lọc theo ngày:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(20, 76, 103, 20);
		panel_1.add(lblNewLabel_1);

		JButton btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.setBackground(new Color(255, 0, 0));
		btnXacNhan.setForeground(new Color(255, 255, 255));
		btnXacNhan.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel dfctkm = (DefaultTableModel) tableListCTKM_TKKM.getModel();
				int indexRow_CTKM = tableListCTKM_TKKM.getSelectedRow();
				
				JTextField mkm = new JTextField();
				JTextField msp = new JTextField();
				JTextField gtg = new JTextField();
				JTextField dvg = new JTextField();
				
				mkm.setText(dfctkm.getValueAt(indexRow_CTKM, 0).toString());
				msp.setText(dfctkm.getValueAt(indexRow_CTKM, 1).toString());
				gtg.setText(dfctkm.getValueAt(indexRow_CTKM, 2).toString());
				dvg.setText(dfctkm.getValueAt(indexRow_CTKM, 3).toString());
				
				int makm = Integer.parseInt(mkm.getText());
				int maSanPham = Integer.parseInt(msp.getText());
				int giaTriGiam = Integer.parseInt(gtg.getText());
				String donViGiam = dvg.getText();
				
				LayThongTinKhuyenMaiDTO.setMaKhuyenMai(makm);
				LayThongTinKhuyenMaiDTO.setMaSanPham(maSanPham);
				LayThongTinKhuyenMaiDTO.setGiaTriGiam(giaTriGiam);
				LayThongTinKhuyenMaiDTO.setDonViGiam(donViGiam);
				
				
				
				dispose();
			
			}
		});
		btnXacNhan.setBounds(385, 416, 120, 35);
		getContentPane().add(btnXacNhan);
		
		ListTableKhuyenMai(bhBLL.layToanBoKhuyenMai());
		ListTableCTKhuyenMai(bhBLL.layToanBoCTKhuyenMai());

		setTitle("Tìm kiếm Khuyến mãi");
		setSize(935, 501);
		setLocationRelativeTo(null);

	}

	public void ListTableKhuyenMai(ArrayList<BanHangDTO> bh) {
		DefaultTableModel df = (DefaultTableModel) tableListKhuyenMai.getModel();
		df.setRowCount(0);
		for (BanHangDTO banHangDTO : bh) {
			Object dataRow[] = new Object[4];
			dataRow[0] = banHangDTO.getMaKhuyenMai();
			dataRow[1] = banHangDTO.getTenKhuyenMai().trim();
			dataRow[2] = banHangDTO.getNgayBatDau();
			dataRow[3] = banHangDTO.getNgayKetThuc();
			df.addRow(dataRow);
		}
	}

	public void getEventKhachHang() {
		DefaultTableModel df = (DefaultTableModel) tableListKhuyenMai.getModel();
		int indexRow = tableListKhuyenMai.getSelectedRow();
		txtMaKM_TKKM.setText(df.getValueAt(indexRow, 0).toString());
		txtMaKhuyenMaiTim.setText(df.getValueAt(indexRow, 0).toString());
		txtTenKM_TKKM.setText(df.getValueAt(indexRow, 1).toString());
	}
	
	public void ListTableCTKhuyenMai(ArrayList<BanHangDTO> bh) {
		DefaultTableModel df = (DefaultTableModel) tableListCTKM_TKKM.getModel();
		df.setRowCount(0);
		for (BanHangDTO banHangDTO : bh) {
			Object dataRow[] = new Object[4];
			dataRow[0] = banHangDTO.getMaKhuyenMai();
			dataRow[1] = banHangDTO.getMaSanPham();
			dataRow[2] = banHangDTO.getGiaTriGiam();
			dataRow[3] = banHangDTO.getDonViGiam().trim();
			df.addRow(dataRow);
		}
	}

	public void getEventCTKhachHang() {
		DefaultTableModel df = (DefaultTableModel) tableListCTKM_TKKM.getModel();
		int indexRow = tableListCTKM_TKKM.getSelectedRow();
		
		txtGiaTriGiam.setText(df.getValueAt(indexRow, 2).toString());
		txtDonViGiam.setText(df.getValueAt(indexRow, 3).toString());
	}
}
