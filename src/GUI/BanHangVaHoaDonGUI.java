package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.toedter.calendar.JDateChooser;


import BLL.BanHangBLL;
import BLL.ChiTietHoaDonBLL;
import BLL.HoaDonBLL;
import DTO.BanHangDTO;
import DTO.ChiTietHoaDonDTO;
import DTO.HoaDonDTO;
import DTO.LayThongTinKhachHangDTO;
import DTO.LayThongTinKhuyenMaiDTO;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JSpinner;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class BanHangVaHoaDonGUI extends JFrame {

	private JPanel contentPane;
	private JPanel BanHang;
	private JPanel HoaDon;
	private JTable tableListDSSP_BH;
	private JTable tableListGioHang;
	private JTable tableListDSHD;
	private JTable tableListChiTietHD;
	private JTextField txtGiaTu_BH;
	private JTextField txtGiaDen_BH;
	public JTextField txtMaKH_BH;
	public JTextField txtTenKH_BH;
	private JTextField txtNhanVienLap_BH;
	private JTextField txtMaSP_BH;
	private JTextField txtTenSP_BH;
	private JTextField txtDonGia_BH;
	private JTextField txtTongTienGiam_BH;
	private JTextField txtTongThanhToan_BH;
	private JTextField txtMaGiamGia_BH;
	private JTextField txtTongTien_BH;

	private JTextField txtMaHD_HD;
	private JTextField txtMaKH_HD;
	private JTextField txtNhanVienLap_HD;
	private JTextField txtTongTien_HD;
	private JTextField txtSoLuong_CTHD;
	private JTextField txtMaSP_CTHD;
	private JTextField txtmaHD_CTHD;
	private JTextField txtThanhTien_CTHD;
	private JTextField txtDonGia_CTHD;
	private JTabbedPane tabbedPane;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_3;
	private JSpinner spinnerSoLuong;
	private BanHangBLL bhBLL = new BanHangBLL();
	private HoaDonDTO hdDTO = new HoaDonDTO();
	private HoaDonBLL hdBLL = new HoaDonBLL();
	private ChiTietHoaDonDTO cthdDTO = new ChiTietHoaDonDTO();
	private ChiTietHoaDonBLL cthdBLL = new ChiTietHoaDonBLL();
	private  ToanCuc tc = new ToanCuc();
	private JDateChooser dateChooserNgayLap_HD;
	private static float tongGiam;

	SimpleDateFormat ft = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BanHangVaHoaDonGUI frame = new BanHangVaHoaDonGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BanHangVaHoaDonGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1084, 661);
		contentPane.add(tabbedPane);

		BanHang = new JPanel();
		BanHang.setForeground(new Color(255, 255, 255));
		BanHang.setBackground(new Color(192, 192, 192));
		tabbedPane.addTab("Bán Hàng", null, BanHang, null);
		BanHang.setLayout(null);

		JLabel lbl = new JLabel("QUẢN LÝ BÁN HÀNG");
		lbl.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl.setBounds(130, 15, 203, 40);
		BanHang.add(lbl);

		JLabel lblLoc = new JLabel("Lọc Sản Phẩm Theo Giá:");
		lblLoc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLoc.setBounds(20, 75, 276, 25);
		BanHang.add(lblLoc);

		JLabel lblGiaTu = new JLabel("Giá từ:");
		lblGiaTu.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGiaTu.setBounds(20, 120, 71, 25);
		BanHang.add(lblGiaTu);

		JLabel lblDen = new JLabel("Đến:");
		lblDen.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDen.setBounds(250, 120, 46, 25);
		BanHang.add(lblDen);

		txtGiaTu_BH = new JTextField();
		txtGiaTu_BH.setBounds(100, 120, 120, 25);
		BanHang.add(txtGiaTu_BH);
		txtGiaTu_BH.setColumns(10);

		txtGiaDen_BH = new JTextField();
		txtGiaDen_BH.setColumns(10);
		txtGiaDen_BH.setBounds(300, 120, 120, 25);
		BanHang.add(txtGiaDen_BH);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(192, 192, 192));
		panel_2.setBorder(new TitledBorder(null, "Danh Sách Sản Phẩm", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(59, 59, 59)));
		panel_2.setBounds(10, 200, 470, 380);
		BanHang.add(panel_2);
		panel_2.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 24, 450, 350);
		panel_2.add(scrollPane);

		tableListDSSP_BH = new JTable();
		tableListDSSP_BH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getEventDSSanPham();
			}
		});
		tableListDSSP_BH.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				getEventDSSanPham();
			}
		});
		tableListDSSP_BH.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "M\u00E3 SP", "T\u00EAn SP",
				"C\u00F2n l\u1EA1i", "\u0110\u01A1n gi\u00E1", "H\u00ECnh \u1EA3nh" }));
		scrollPane.setViewportView(tableListDSSP_BH);

		JButton btnLoc_BH = new JButton("Lọc");
		btnLoc_BH.setForeground(new Color(255, 255, 255));
		btnLoc_BH.setBackground(new Color(255, 0, 0));
		btnLoc_BH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String donGiaTuStr = txtGiaTu_BH.getText();
					String donGiaDenStr = txtGiaDen_BH.getText();

					if (donGiaTuStr.isEmpty() || donGiaDenStr.isEmpty()) {
						JOptionPane.showMessageDialog(btnLoc_BH, "Giá trị không được để trống!!!");
						return;
					}

					Float donGiaTu = Float.parseFloat(donGiaTuStr);
					Float donGiaDen = Float.parseFloat(donGiaDenStr);

					if (donGiaTu >= donGiaDen) {
						JOptionPane.showMessageDialog(btnLoc_BH, "Giá từ phải nhỏ hơn giá đến");
						return;
					}
					ArrayList<BanHangDTO> listSP = new BanHangBLL().locBLL(donGiaTu, donGiaDen);
					ListTableDSSanPham(listSP);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(btnLoc_BH, "Lọc thất bại");
				}
			}
		});
		btnLoc_BH.setBounds(151, 157, 80, 30);
		BanHang.add(btnLoc_BH);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(192, 192, 192));
		panel_3.setBorder(
				new TitledBorder(null, "Thông Tin Đặt Hàng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(485, 10, 595, 615);
		BanHang.add(panel_3);
		panel_3.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(192, 192, 192));
		panel_4.setBorder(
				new TitledBorder(null, "Thông Tin Khách Hàng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(10, 20, 575, 100);
		panel_3.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblMaKH_BH = new JLabel("Mã KH:");
		lblMaKH_BH.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMaKH_BH.setBounds(19, 25, 55, 25);
		panel_4.add(lblMaKH_BH);

		txtMaKH_BH = new JTextField();
		txtMaKH_BH.setBounds(72, 25, 160, 25);
		panel_4.add(txtMaKH_BH);
		txtMaKH_BH.setColumns(10);

		JLabel lblTen = new JLabel("Tên:");
		lblTen.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTen.setBounds(258, 25, 89, 25);
		panel_4.add(lblTen);

		txtTenKH_BH = new JTextField();
		txtTenKH_BH.setColumns(10);
		txtTenKH_BH.setBounds(390, 25, 160, 25);
		panel_4.add(txtTenKH_BH);

		JLabel lblNhanVienLap = new JLabel("Nhân viên lâp:");
		lblNhanVienLap.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNhanVienLap.setBounds(258, 60, 120, 25);
		panel_4.add(lblNhanVienLap);

		txtNhanVienLap_BH = new JTextField();
		txtNhanVienLap_BH.setEditable(false);
		txtNhanVienLap_BH.setColumns(10);
		txtNhanVienLap_BH.setBounds(390, 60, 160, 25);
		panel_4.add(txtNhanVienLap_BH);

		JButton btnTimKH_BH = new JButton("Tìm kiếm");
		btnTimKH_BH.setForeground(new Color(255, 255, 255));
		btnTimKH_BH.setBackground(new Color(255, 0, 0));
		btnTimKH_BH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimKiemKH form = new TimKiemKH();
				form.setVisible(true);
			}
		});
		btnTimKH_BH.setBounds(124, 60, 90, 30);
		panel_4.add(btnTimKH_BH);

		JButton btnRefesh_CTHD_1 = new JButton("Refesh");
		btnRefesh_CTHD_1.setForeground(new Color(255, 255, 255));
		btnRefesh_CTHD_1.setBackground(new Color(255, 0, 0));
		btnRefesh_CTHD_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LayThongTinKhachHangDTO l = new LayThongTinKhachHangDTO();
				txtMaKH_BH.setText(String.valueOf(l.getMaKhachHang()));
				txtTenKH_BH.setText(l.getTenKhachHang());
			}
		});
		btnRefesh_CTHD_1.setBounds(25, 60, 80, 30);
		panel_4.add(btnRefesh_CTHD_1);

		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBackground(new Color(192, 192, 192));
		panel_4_1.setLayout(null);
		panel_4_1.setBorder(new TitledBorder(null, "Thông Tin Sản Phẩm", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(59, 59, 59)));
		panel_4_1.setBounds(10, 120, 575, 135);
		panel_3.add(panel_4_1);

		JLabel lblMaSP = new JLabel("Mã sản phẩm:");
		lblMaSP.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMaSP.setBounds(15, 25, 131, 25);
		panel_4_1.add(lblMaSP);

		txtMaSP_BH = new JTextField();
		txtMaSP_BH.setEditable(false);
		txtMaSP_BH.setColumns(10);
		txtMaSP_BH.setBounds(158, 25, 130, 25);
		panel_4_1.add(txtMaSP_BH);

		JLabel lblTenSP = new JLabel("Tên sản phẩm:");
		lblTenSP.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTenSP.setBounds(15, 55, 131, 25);
		panel_4_1.add(lblTenSP);

		txtTenSP_BH = new JTextField();
		txtTenSP_BH.setEditable(false);
		txtTenSP_BH.setColumns(10);
		txtTenSP_BH.setBounds(158, 55, 130, 25);
		panel_4_1.add(txtTenSP_BH);

		JLabel lblDonGia = new JLabel("Đơn giá:");
		lblDonGia.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDonGia.setBounds(324, 25, 61, 25);
		panel_4_1.add(lblDonGia);

		txtDonGia_BH = new JTextField();
		txtDonGia_BH.setEditable(false);
		txtDonGia_BH.setColumns(10);
		txtDonGia_BH.setBounds(422, 25, 100, 25);
		panel_4_1.add(txtDonGia_BH);

		JLabel lblSoLuong = new JLabel("Số lượng:");
		lblSoLuong.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSoLuong.setBounds(324, 55, 86, 25);
		panel_4_1.add(lblSoLuong);

		JButton btnThemVaoGio_BH = new JButton("Thêm vào giỏ");
		btnThemVaoGio_BH.setForeground(new Color(255, 255, 255));
		btnThemVaoGio_BH.setBackground(new Color(255, 0, 0));
		btnThemVaoGio_BH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int indexRow = tableListDSSP_BH.getSelectedRow();
				if (indexRow == -1) {
					JOptionPane.showMessageDialog(btnThemVaoGio_BH, "Chưa chọn sản phẩm!");
					return;
				}
				int value = (Integer) spinnerSoLuong.getValue();
				if (value <= 0) {
					JOptionPane.showMessageDialog(btnThemVaoGio_BH, "Số lượng phải lớn hơn 0!");
					return;
				}
				float donGia = Float.parseFloat(txtDonGia_BH.getText());
				txtTenSP_BH.getText();
				txtDonGia_BH.getText();
				DefaultTableModel df = (DefaultTableModel) tableListGioHang.getModel();
				Object dataRow[] = new Object[5];
				dataRow[0] = txtMaSP_BH.getText();
				dataRow[1] = txtTenSP_BH.getText();
				dataRow[2] = value;
				dataRow[3] = donGia;
				dataRow[4] = value * donGia;
				df.addRow(dataRow);
				// int indexRow = tableListGioHang.getSelectedRow();
			}
		});
		btnThemVaoGio_BH.setBounds(400, 90, 150, 30);
		panel_4_1.add(btnThemVaoGio_BH);

		spinnerSoLuong = new JSpinner();
		spinnerSoLuong.setBounds(422, 55, 100, 25);
		panel_4_1.add(spinnerSoLuong);

		JPanel panel_4_2 = new JPanel();
		panel_4_2.setBackground(new Color(192, 192, 192));
		panel_4_2.setLayout(null);
		panel_4_2.setBorder(new TitledBorder(null, "Giỏ Hàng", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(59, 59, 59)));
		panel_4_2.setBounds(10, 260, 575, 340);
		panel_3.add(panel_4_2);

		JLabel lblTongTienGiam = new JLabel("Tổng tiền giảm:");
		lblTongTienGiam.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTongTienGiam.setBounds(295, 265, 140, 25);
		panel_4_2.add(lblTongTienGiam);

		txtTongTienGiam_BH = new JTextField();
		txtTongTienGiam_BH.setEditable(false);
		txtTongTienGiam_BH.setColumns(10);
		txtTongTienGiam_BH.setBounds(420, 265, 140, 25);
		panel_4_2.add(txtTongTienGiam_BH);

		JLabel lblTongThanhToan = new JLabel("Tổng thanh toán:");
		lblTongThanhToan.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTongThanhToan.setBounds(295, 295, 140, 25);
		panel_4_2.add(lblTongThanhToan);

		txtTongThanhToan_BH = new JTextField();
		txtTongThanhToan_BH.setEditable(false);
		txtTongThanhToan_BH.setColumns(10);
		txtTongThanhToan_BH.setBounds(420, 295, 140, 25);
		panel_4_2.add(txtTongThanhToan_BH);

		JLabel lblMaGiamGia = new JLabel("Mã giảm giá:");
		lblMaGiamGia.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMaGiamGia.setBounds(20, 200, 120, 25);
		panel_4_2.add(lblMaGiamGia);

		txtMaGiamGia_BH = new JTextField();
		txtMaGiamGia_BH.setColumns(10);
		txtMaGiamGia_BH.setBounds(127, 200, 140, 25);
		panel_4_2.add(txtMaGiamGia_BH);

		JButton btnXoaKhoiGio_BH = new JButton("Xóa khỏi giỏ");
		btnXoaKhoiGio_BH.setForeground(new Color(255, 255, 255));
		btnXoaKhoiGio_BH.setBackground(new Color(255, 0, 0));
		btnXoaKhoiGio_BH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel df = (DefaultTableModel) tableListGioHang.getModel();
				int indexRow = tableListGioHang.getSelectedRow();
				if (indexRow == -1) {
					JOptionPane.showMessageDialog(btnXoaKhoiGio_BH, "Chưa chọn giá trị!");
					return;
				}
				df.removeRow(indexRow);
			}
		});
		btnXoaKhoiGio_BH.setBounds(400, 195, 150, 30);
		panel_4_2.add(btnXoaKhoiGio_BH);

		txtTongTien_BH = new JTextField();
		txtTongTien_BH.setEditable(false);
		txtTongTien_BH.setColumns(10);
		txtTongTien_BH.setBounds(420, 235, 140, 25);
		panel_4_2.add(txtTongTien_BH);

		JLabel lblTongTien = new JLabel("Tổng tiền:");
		lblTongTien.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTongTien.setBounds(295, 235, 140, 25);
		panel_4_2.add(lblTongTien);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(15, 19, 555, 170);
		panel_4_2.add(scrollPane_1);

		tableListGioHang = new JTable();
		tableListGioHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel df = (DefaultTableModel) tableListGioHang.getModel();
			}
		});
		tableListGioHang.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Đơn Giá", "Thành Tiền" }));
		scrollPane_1.setViewportView(tableListGioHang);

		JButton btnThanhToan_BH = new JButton("Thanh toán");
		btnThanhToan_BH.setBounds(80, 280, 100, 40);
		panel_4_2.add(btnThanhToan_BH);
		btnThanhToan_BH.setForeground(new Color(255, 255, 255));
		btnThanhToan_BH.setBackground(new Color(255, 0, 0));
		btnThanhToan_BH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int maNhaVien = tc.getMaNhanVien();
				int maKhachHang = Integer.parseInt(txtMaKH_BH.getText());
				java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
				float thanhTien = Float.parseFloat(txtTongThanhToan_BH.getText());
				hdDTO = new HoaDonDTO(maNhaVien, maKhachHang, date, thanhTien, 1);
				
				DefaultTableModel df = (DefaultTableModel) tableListGioHang.getModel();
				int indexRow = tableListGioHang.getSelectedRow();
				
				
				
				
				if (hdBLL.Insert(hdDTO)) {
					JOptionPane.showMessageDialog(btnThanhToan_BH, "Thanh toán thành công");
					
					
					
					int maHoaDon = hdBLL.getMaHoaDon();
					for (int i = 0; i < tableListGioHang.getRowCount(); i++) {
						int maSanPham = Integer.parseInt(tableListGioHang.getValueAt(i, 0).toString());
						int soLuong = Integer.parseInt(tableListGioHang.getValueAt(i, 2).toString());
						float donGia = Float.parseFloat(tableListGioHang.getValueAt(i, 3).toString());
						//float donGia=Float.parseFloat(txtTongThanhToan_BH.getText());
						float thanhTienCT = Float.parseFloat(tableListGioHang.getValueAt(i, 4).toString());
						LayThongTinKhuyenMaiDTO l = new LayThongTinKhuyenMaiDTO();
						int msp = l.getMaSanPham();
						int mspGH = Integer.parseInt(tableListGioHang.getValueAt(i, 0).toString());
						
						if (msp == mspGH) {
							thanhTienCT=thanhTienCT-tongGiam;
						}
					
						try {
							cthdDTO = new ChiTietHoaDonDTO(maHoaDon, maSanPham, soLuong, donGia, thanhTienCT, 1);
							cthdBLL.Insert(cthdDTO);
							//soluongSp=bhBLL.getSoLuong(maSanPham);
							//int SLold = Integer.parseInt(df.getValueAt(indexRow, 2).toString());
							bhBLL.update(bhBLL.getSoLuong(maSanPham)-soLuong,  maSanPham);
							ListTableDSSanPham(bhBLL.layToanBoSanPhamBLL());
							

						} catch (Exception e2) {
							// TODO: handle exception
							JOptionPane.showMessageDialog(btnThanhToan_BH, "Thanh toán thất bại");
						}
						
					}
					
					int yn = JOptionPane.showConfirmDialog(btnThanhToan_BH, "Bạn có muốn in hóa đơn", "Confirm",
							JOptionPane.YES_NO_OPTION);
					if (yn == JOptionPane.YES_OPTION) {
						int row = tableListGioHang.getRowCount();
						File saveFile = new File("E:\\HD-" + maHoaDon + ".txt");
						try {
//							java.util.Date now = new java.util.Date();
							PrintWriter pw = new PrintWriter("E:\\HD-" + maHoaDon + ".txt", "UTF-8");
							pw.print("\t\t\t\tHÓA ĐƠN BÁN HÀNG\r\n\r\n");
							pw.print("Mã hóa đơn: " + maHoaDon + "\r\n");
							pw.print("Thời gian: " + ft.format(date) + "\r\n");
							pw.print("NHÂN VIÊN: " + String.valueOf(tc.getMaNhanVien())+" "+tc.getTenNhanVien().trim() + "\r\n\r\n");
							pw.print("----------------------------------------------------------------------\r\n");
							pw.print("Mã\tTên sản phẩm\tSố lượng\tĐơn giá\tThành tiền\r\n");
							pw.print("----------------------------------------------------------------------\r\n");

							int tongSoLuongTT = 0;
							for (int i = 0; i < row; i++) {
								String maSPTT = (String) tableListGioHang.getValueAt(i, 0);
								String tenSPTT = (String) tableListGioHang.getValueAt(i, 1);
								String soLuongTT = String.valueOf(tableListGioHang.getValueAt(i, 2));
								String donGiaTT = String.valueOf(tableListGioHang.getValueAt(i, 3));
								String thanhTienTT = String.valueOf(tableListGioHang.getValueAt(i, 4));
								pw.print(maSPTT + "\t" + tenSPTT + "\t" + soLuongTT + "\t\t" + donGiaTT + "\t"
										+ thanhTienTT + "\r\n\r\n");
								tongSoLuongTT += Integer.parseInt(soLuongTT);
							}

							pw.print("----------------------------------------------------------------------\r\n");
							pw.print("Tổng cộng:\t\t" + tongSoLuongTT + "\t\t\t\t" + txtTongTien_BH.getText()
									+ " VNĐ\r\n");
							pw.print("\t\tKhuyến mãi:\t\t\t\t-" + txtTongTienGiam_BH.getText() + " VNĐ\r\n");
							pw.print("\t\t------------------------------------------------------\r\n");
							pw.print("\t\tThành tiền:\t\t\t\t" + txtTongThanhToan_BH.getText() + " VNĐ\r\n");
							pw.print("----------------------------------------------------------------------\r\n");
							pw.print("-------Chương trình khuyến mãi-------\r\n");
							pw.print("Mã khuyến mãi: " + txtMaGiamGia_BH.getText() + "\r\n");
							pw.print("-------Thông tin thành viên-------\r\n");
							pw.print("Mã khách hàng: " + maKhachHang + "\r\n");
							pw.print("Tên khách hàng: " + txtTenKH_BH.getText() + "\r\n");
							pw.print("----------------------------CẢM ƠN QUÝ KHÁCH!-------------------------");
							pw.flush();
							pw.close();
						} catch (Exception ex) {
							ex.printStackTrace();
						}

//							try {
//								FileOutputStream fileOS = new FileOutputStream(new File(saveFile.toString()));
//							} catch (FileNotFoundException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							}
						openFile(saveFile.toString());

					}
					ListTableHoaDon(hdBLL.ListThongTinHoaDonDAL());
					ListTableChiTietHoaDon(cthdBLL.ListThongTinChiTietHoaDonDAL());

				} else {
					JOptionPane.showMessageDialog(btnThanhToan_BH, "Thanh toán thất bại");
				}
				resetAll();
			}
		});

		JButton btnTimKH_BH_1 = new JButton("Tìm kiếm");
		btnTimKH_BH_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimKiemKM form = new TimKiemKM();
				form.setVisible(true);
			}
		});
		btnTimKH_BH_1.setForeground(Color.WHITE);
		btnTimKH_BH_1.setBackground(Color.RED);
		btnTimKH_BH_1.setBounds(140, 230, 90, 30);
		panel_4_2.add(btnTimKH_BH_1);

		JButton btnRefesh_CTHD_1_1 = new JButton("Refesh");
		btnRefesh_CTHD_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LayThongTinKhuyenMaiDTO l = new LayThongTinKhuyenMaiDTO();
				txtMaGiamGia_BH.setText(String.valueOf(l.getMaKhuyenMai()));

				int msp = l.getMaSanPham();
				int gtg = l.getGiaTriGiam();
				String dvg = l.getDonViGiam();
				 tongGiam = 0;
				float sum= 0;
				float sum_t= 0;
				float tienGiam = 0;
				for (int i = 0; i < tableListGioHang.getRowCount(); i++) {
					int mspGH = Integer.parseInt(tableListGioHang.getValueAt(i, 0).toString());
					int soLuongGH = Integer.parseInt(tableListGioHang.getValueAt(i, 2).toString());
					float thanhTienGH = Float.parseFloat(tableListGioHang.getValueAt(i, 4).toString());
					sum = sum + Float.parseFloat(tableListGioHang.getValueAt(i, 4).toString());
					if (msp == mspGH) {
						if (dvg.equals("VND")) {
							tienGiam = gtg*soLuongGH;
						} else if (dvg.equals("%")) {
							tienGiam = thanhTienGH*gtg/100;
						}
					}
					tongGiam = +tienGiam;
				}
				txtTongTienGiam_BH.setText(String.valueOf(tongGiam));

				float tien_km = Float.parseFloat(txtTongTienGiam_BH.getText());
				sum_t = sum - tien_km;
				txtTongTien_BH.setText(String.valueOf(sum));
				txtTongThanhToan_BH.setText(String.valueOf(sum_t));
			}
		});
		btnRefesh_CTHD_1_1.setForeground(Color.WHITE);
		btnRefesh_CTHD_1_1.setBackground(Color.RED);
		btnRefesh_CTHD_1_1.setBounds(45, 230, 80, 30);
		panel_4_2.add(btnRefesh_CTHD_1_1);

		JButton btnNewButton = new JButton("Xác nhận");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float sum = 0;
				for (int i = 0; i < tableListGioHang.getRowCount(); i++) {
					sum = sum + Float.parseFloat(tableListGioHang.getValueAt(i, 4).toString());
					// JOptionPane.showMessageDialog(null, tableListGioHang.getValueAt(i, 4));
				}
				txtTongTien_BH.setText(String.valueOf(sum));
				txtTongThanhToan_BH.setText(String.valueOf(sum));
			}
		});

		btnNewButton.setBounds(295, 195, 86, 28);
		panel_4_2.add(btnNewButton);

		JButton btnTrangChu_BH = new JButton("Trang chủ");
		btnTrangChu_BH.setForeground(new Color(255, 255, 255));
		btnTrangChu_BH.setBackground(new Color(255, 0, 0));
		btnTrangChu_BH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrangChuGUI t = new TrangChuGUI();
				dispose();
				t.setVisible(true);
			}
		});
		btnTrangChu_BH.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTrangChu_BH.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\home.png"));
		btnTrangChu_BH.setBounds(176, 581, 178, 50);
		BanHang.add(btnTrangChu_BH);

		JButton btnRefesh__BH = new JButton("Reset");
		btnRefesh__BH.setForeground(new Color(255, 255, 255));
		btnRefesh__BH.setBackground(new Color(255, 0, 0));
		btnRefesh__BH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListTableDSSanPham(bhBLL.layToanBoSanPhamBLL());
				txtGiaTu_BH.setText("");
				txtGiaDen_BH.setText("");
			}
		});
		btnRefesh__BH.setBounds(260, 158, 80, 30);
		BanHang.add(btnRefesh__BH);

		HoaDon = new JPanel();
		HoaDon.setBackground(new Color(192, 192, 192));
		tabbedPane.addTab("Hóa Đơn", null, HoaDon, null);
		HoaDon.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBorder(
				new TitledBorder(null, "Danh Sách Hóa Đơn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 50, 630, 520);
		HoaDon.add(panel);
		panel.setLayout(null);

		JLabel lblMaHD = new JLabel("Mã Hóa Đơn:");
		lblMaHD.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMaHD.setBounds(20, 30, 130, 25);
		panel.add(lblMaHD);

		txtMaHD_HD = new JTextField();
		txtMaHD_HD.setBounds(140, 30, 160, 25);
		panel.add(txtMaHD_HD);
		txtMaHD_HD.setColumns(10);

		txtMaKH_HD = new JTextField();
		txtMaKH_HD.setColumns(10);
		txtMaKH_HD.setBounds(140, 60, 160, 25);
		panel.add(txtMaKH_HD);

		JLabel lblMaKHHD = new JLabel("Mã Khách Hàng:");
		lblMaKHHD.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMaKHHD.setBounds(20, 60, 130, 25);
		panel.add(lblMaKHHD);

		txtNhanVienLap_HD = new JTextField();
		txtNhanVienLap_HD.setColumns(10);
		txtNhanVienLap_HD.setBounds(140, 90, 160, 25);
		panel.add(txtNhanVienLap_HD);

		JLabel lblNhanVienLapHD = new JLabel("Nhân Viên Lập:");
		lblNhanVienLapHD.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNhanVienLapHD.setBounds(20, 90, 130, 25);
		panel.add(lblNhanVienLapHD);

		dateChooserNgayLap_HD = new JDateChooser();
		dateChooserNgayLap_HD.setDateFormatString("yyyy-MM-dd");
		dateChooserNgayLap_HD.setBounds(450, 30, 160, 25);
		panel.add(dateChooserNgayLap_HD);

		JLabel lblNgayLap = new JLabel("Ngày Lập:");
		lblNgayLap.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNgayLap.setBounds(360, 30, 80, 25);
		panel.add(lblNgayLap);

		txtTongTien_HD = new JTextField();
		txtTongTien_HD.setColumns(10);
		txtTongTien_HD.setBounds(450, 60, 160, 25);
		panel.add(txtTongTien_HD);

		JLabel lblTongTienHD = new JLabel("Tổng Tiền:");
		lblTongTienHD.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTongTienHD.setBounds(360, 60, 80, 25);
		panel.add(lblTongTienHD);

		JLabel lblTu = new JLabel("Từ:");
		lblTu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTu.setBounds(20, 140, 56, 25);
		panel.add(lblTu);

		JDateChooser dateChooserNgayLapTu_HD = new JDateChooser();
		dateChooserNgayLapTu_HD.setDateFormatString("yyyy-MM-dd");
		dateChooserNgayLapTu_HD.setBounds(50, 140, 150, 25);
		panel.add(dateChooserNgayLapTu_HD);

		JLabel lblDen_HD = new JLabel("Đến:");
		lblDen_HD.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDen_HD.setBounds(212, 140, 51, 25);
		panel.add(lblDen_HD);

		JDateChooser dateChooserNgayLapDen_HD = new JDateChooser();
		dateChooserNgayLapDen_HD.setDateFormatString("yyyy-MM-dd");
		dateChooserNgayLapDen_HD.setBounds(270, 140, 150, 25);
		panel.add(dateChooserNgayLapDen_HD);

		JButton btnLoc_HD = new JButton("Lọc");
		btnLoc_HD.setForeground(new Color(255, 255, 255));
		btnLoc_HD.setBackground(new Color(255, 0, 0));
		btnLoc_HD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String ngayLapTuStr = dateChooserNgayLap_HD.getDateFormatString();
					String ngayLapDenStr = dateChooserNgayLap_HD.getDateFormatString();

					if (ngayLapTuStr.isEmpty() || ngayLapDenStr.isEmpty()) {
						JOptionPane.showMessageDialog(btnLoc_BH, "Giá trị không được để trống!!!");
						return;
					}

					Date ngayLapTu = java.sql.Date.valueOf(ngayLapTuStr);
//					Date ngayLapTu = DavalueOf(ngayLapTuStr);
//					Date ngayLapDen = Date.valueOf(ngayLapDenStr);

					if (ngayLapTu.before(ngayLapTu)) {
						JOptionPane.showMessageDialog(btnLoc_BH, "Ngày lập từ phải nhỏ hơn ngày lập đến");
						return;
					}
//					ArrayList<HoaDonDTO> listHD = new HoaDonBLL().locBLL(ngayLapTuStr, ngayLapDenStr);
//				ListTableHoaDon(listHD);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(btnLoc_HD, "Lọc thất bại");
				}
			}
		});
		btnLoc_HD.setBounds(450, 137, 70, 30);
		panel.add(btnLoc_HD);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(20, 190, 590, 260);
		panel.add(scrollPane_2);

		tableListDSHD = new JTable();
		tableListDSHD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getEventHoaDon();
			}
		});
		tableListDSHD.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				getEventHoaDon();
			}
		});
		tableListDSHD.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "M\u00E3 H\u00F3a \u0110\u01A1n",
				"M\u00E3 Kh\u00E1ch H\u00E0ng", "Nh\u00E2n Vi\u00EAn", "Ng\u00E0y L\u1EADp", "T\u1ED5ng Ti\u1EC1n" }));
		scrollPane_2.setViewportView(tableListDSHD);

		JButton btnUpdate_HD = new JButton("Update");
		btnUpdate_HD.setForeground(new Color(255, 255, 255));
		btnUpdate_HD.setBackground(new Color(255, 0, 0));
		btnUpdate_HD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int maHoaDon = Integer.parseInt(txtMaHD_HD.getText());
				int maNhanVien = Integer.parseInt(txtNhanVienLap_HD.getText());
				int maKhachHang = Integer.parseInt(txtMaKH_HD.getText());
				Date ngayLap = Date.valueOf(dateChooserNgayLap_HD.getDateFormatString());
				Float tongTien = Float.parseFloat(txtTongTien_HD.getText());
				hdDTO = new HoaDonDTO(maHoaDon, maNhanVien, maKhachHang, ngayLap, tongTien);
				if (hdBLL.UpdateThongTinHoaDonDAL(hdDTO) == true) {
					JOptionPane.showMessageDialog(btnUpdate_HD, "Sửa thành công");
					ListTableHoaDon(hdBLL.ListThongTinHoaDonDAL());
					return;
				} else {
					JOptionPane.showMessageDialog(btnUpdate_HD, "Sửa thất bại");
					return;
				}
			}
		});
		btnUpdate_HD.setBounds(110, 465, 90, 40);
		panel.add(btnUpdate_HD);

		JButton btnRemove_HD = new JButton("Remove");
		btnRemove_HD.setForeground(new Color(255, 255, 255));
		btnRemove_HD.setBackground(new Color(255, 0, 0));
		btnRemove_HD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int maHoaDon = Integer.parseInt(txtMaHD_HD.getText());
				if (hdBLL.RemoveThongTinHoaDonDAL(maHoaDon) == true) {
					JOptionPane.showMessageDialog(btnRemove_HD, "Xóa thành công");
					ListTableHoaDon(hdBLL.ListThongTinHoaDonDAL());
					return;
				} else {
					JOptionPane.showMessageDialog(btnRemove_HD, "Xóa thất bại");
					return;
				}
			}
		});
		btnRemove_HD.setBounds(270, 465, 90, 40);
		panel.add(btnRemove_HD);

		JButton btnRefesh_HD = new JButton("Reset");
		btnRefesh_HD.setForeground(new Color(255, 255, 255));
		btnRefesh_HD.setBackground(new Color(255, 0, 0));
		btnRefesh_HD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListTableHoaDon(hdBLL.ListThongTinHoaDonDAL());
				txtMaHD_HD.setText("");
				txtMaKH_HD.setText("");
				txtNhanVienLap_HD.setText("");
				dateChooserNgayLap_HD.setDateFormatString("");
				txtTongTien_HD.setText("");
				dateChooserNgayLapTu_HD.setDateFormatString("");
				dateChooserNgayLapDen_HD.setDateFormatString("");
			}
		});
		btnRefesh_HD.setBounds(530, 137, 80, 30);
		panel.add(btnRefesh_HD);

		JButton btnXuat_HD = new JButton("Xuất file");
		btnXuat_HD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					exportExcelHD(tableListDSHD);
					JOptionPane.showMessageDialog(null, "Xuất file thành công");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Lỗi xuất file");
				}
			}
		});
		btnXuat_HD.setForeground(Color.WHITE);
		btnXuat_HD.setBackground(Color.RED);
		btnXuat_HD.setBounds(430, 465, 90, 40);
		panel.add(btnXuat_HD);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBorder(
				new TitledBorder(null, "Chi Tiết Hóa Đơn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(650, 50, 420, 520);
		HoaDon.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblMaHD_1 = new JLabel("Mã Hóa Đơn:");
		lblMaHD_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMaHD_1.setBounds(40, 30, 110, 25);
		panel_1.add(lblMaHD_1);

		JLabel lblMaSPHD = new JLabel("Mã Sản Phẩm:");
		lblMaSPHD.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMaSPHD.setBounds(40, 60, 110, 25);
		panel_1.add(lblMaSPHD);

		JLabel lblSoLuongHD = new JLabel("Số Lượng:");
		lblSoLuongHD.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSoLuongHD.setBounds(40, 90, 110, 25);
		panel_1.add(lblSoLuongHD);

		txtSoLuong_CTHD = new JTextField();
		txtSoLuong_CTHD.setColumns(10);
		txtSoLuong_CTHD.setBounds(160, 90, 160, 25);
		panel_1.add(txtSoLuong_CTHD);

		txtMaSP_CTHD = new JTextField();
		txtMaSP_CTHD.setColumns(10);
		txtMaSP_CTHD.setBounds(160, 60, 160, 25);
		panel_1.add(txtMaSP_CTHD);

		txtmaHD_CTHD = new JTextField();
		txtmaHD_CTHD.setColumns(10);
		txtmaHD_CTHD.setBounds(160, 30, 160, 25);
		panel_1.add(txtmaHD_CTHD);

		JLabel lblThanhTien = new JLabel("Thành Tiền:");
		lblThanhTien.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThanhTien.setBounds(40, 150, 110, 25);
		panel_1.add(lblThanhTien);

		txtThanhTien_CTHD = new JTextField();
		txtThanhTien_CTHD.setColumns(10);
		txtThanhTien_CTHD.setBounds(160, 150, 160, 25);
		panel_1.add(txtThanhTien_CTHD);

		txtDonGia_CTHD = new JTextField();
		txtDonGia_CTHD.setColumns(10);
		txtDonGia_CTHD.setBounds(160, 120, 160, 25);
		panel_1.add(txtDonGia_CTHD);

		JLabel lblDonGiaHD = new JLabel("Đơn Giá:");
		lblDonGiaHD.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDonGiaHD.setBounds(40, 120, 110, 25);
		panel_1.add(lblDonGiaHD);

		JButton btnRefesh_CTHD = new JButton("Reset");
		btnRefesh_CTHD.setForeground(new Color(255, 255, 255));
		btnRefesh_CTHD.setBackground(new Color(255, 0, 0));
		btnRefesh_CTHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtmaHD_CTHD.setText("");
				txtMaSP_CTHD.setText("");
				txtSoLuong_CTHD.setText("");
				txtDonGia_CTHD.setText("");
				txtThanhTien_CTHD.setText("");
			}
		});
		btnRefesh_CTHD.setBounds(325, 175, 80, 30);
		panel_1.add(btnRefesh_CTHD);

		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(15, 210, 390, 250);
		panel_1.add(scrollPane_3);

		tableListChiTietHD = new JTable();
		tableListChiTietHD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getEventChiTietHoaDon();
			}
		});
		tableListChiTietHD.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				getEventChiTietHoaDon();
			}
		});
		tableListChiTietHD.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã HĐ", "Mã SP", "Số Lượng", "Đơn Giá", "Thành Tiền" }));
		scrollPane_3.setViewportView(tableListChiTietHD);

		JButton btnUpdate_CTHD = new JButton("Update");
		btnUpdate_CTHD.setForeground(new Color(255, 255, 255));
		btnUpdate_CTHD.setBackground(new Color(255, 0, 0));
		btnUpdate_CTHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int maHoaDon = Integer.parseInt(txtmaHD_CTHD.getText());
				int maSanPham = Integer.parseInt(txtMaSP_CTHD.getText());
				int soLuong = Integer.parseInt(txtSoLuong_CTHD.getText());
				Float donGia = Float.parseFloat(txtDonGia_CTHD.getText());
				Float thanhTien = Float.parseFloat(txtThanhTien_CTHD.getText());
				cthdDTO = new ChiTietHoaDonDTO(maHoaDon, maSanPham, soLuong, donGia, thanhTien);
				if (cthdBLL.UpdateThongTinChiTietHoaDonDAL(cthdDTO) == true) {
					JOptionPane.showMessageDialog(btnUpdate_CTHD, "Cập nhật thành công");
					ListTableChiTietHoaDon(cthdBLL.ListThongTinChiTietHoaDonDAL());
					return;
				} else {
					JOptionPane.showMessageDialog(btnUpdate_CTHD, "Cập nhật thất bại");
					return;
				}
			}
		});
		btnUpdate_CTHD.setBounds(40, 465, 90, 40);
		panel_1.add(btnUpdate_CTHD);

		JButton btnRemove_CTHD = new JButton("Remove");
		btnRemove_CTHD.setForeground(new Color(255, 255, 255));
		btnRemove_CTHD.setBackground(new Color(255, 0, 0));
		btnRemove_CTHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int maHoaDon = Integer.parseInt(txtmaHD_CTHD.getText());
				int maSanPham = Integer.parseInt(txtMaSP_CTHD.getText());
				if (cthdBLL.RemoveThongTinChiTietHoaDonDAL(maHoaDon, maSanPham) == true) {
					JOptionPane.showMessageDialog(btnRemove_CTHD, "Xóa thành công");
					ListTableChiTietHoaDon(cthdBLL.ListThongTinChiTietHoaDonDAL());
					return;
				} else {
					JOptionPane.showMessageDialog(btnRemove_CTHD, "Xóa thất bại");
					return;
				}
			}
		});
		btnRemove_CTHD.setBounds(160, 465, 90, 40);
		panel_1.add(btnRemove_CTHD);

		JButton btnXuat_CTHD = new JButton("Xuất file");
		btnXuat_CTHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					exportExcelCTHD(tableListChiTietHD);
					JOptionPane.showMessageDialog(null, "Xuất file thành công");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Lỗi xuất file");
				}
			}
		});
		btnXuat_CTHD.setForeground(Color.WHITE);
		btnXuat_CTHD.setBackground(Color.RED);
		btnXuat_CTHD.setBounds(280, 465, 90, 40);
		panel_1.add(btnXuat_CTHD);

		JLabel lblNewLabel = new JLabel("QUẢN LÝ HÓA ĐƠN");
		lblNewLabel.setBounds(400, 10, 192, 30);
		HoaDon.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));

		JButton btnTrangChu_HD = new JButton("Trang Chủ");
		btnTrangChu_HD.setForeground(new Color(255, 255, 255));
		btnTrangChu_HD.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\home.png"));
		btnTrangChu_HD.setBackground(new Color(255, 0, 0));
		btnTrangChu_HD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrangChuGUI t = new TrangChuGUI();
				dispose();
				t.setVisible(true);
			}
		});
		btnTrangChu_HD.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTrangChu_HD.setBounds(428, 580, 181, 40);
		HoaDon.add(btnTrangChu_HD);

		ListTableDSSanPham(bhBLL.layToanBoSanPhamBLL());
		ListTableHoaDon(hdBLL.ListThongTinHoaDonDAL());
		ListTableChiTietHoaDon(cthdBLL.ListThongTinChiTietHoaDonDAL());
		txtNhanVienLap_BH.setText(String.valueOf(tc.getMaNhanVien())+" "+tc.getTenNhanVien().trim());

	}

	public void ListTableDSSanPham(ArrayList<BanHangDTO> sp) {
		DefaultTableModel df = (DefaultTableModel) tableListDSSP_BH.getModel();
		df.setRowCount(0);
		for (BanHangDTO banHangDTO : sp) {
			Object dataRow[] = new Object[7];
			dataRow[0] = banHangDTO.getMaSanPham();
			dataRow[1] = banHangDTO.getTenSanPham().trim();
			dataRow[2] = banHangDTO.getSoLuong();
			dataRow[3] = banHangDTO.getDonGia();
			dataRow[4] = banHangDTO.getLoai();
			dataRow[5] = banHangDTO.getHinhAnh().trim();
			df.addRow(dataRow);
		}
	}

	public void getEventDSSanPham() {
		DefaultTableModel df = (DefaultTableModel) tableListDSSP_BH.getModel();
		int indexRow = tableListDSSP_BH.getSelectedRow();
		txtMaSP_BH.setText(df.getValueAt(indexRow, 0).toString());
		txtTenSP_BH.setText(df.getValueAt(indexRow, 1).toString());
		txtDonGia_BH.setText(df.getValueAt(indexRow, 3).toString());
	}

	public void ListTableHoaDon(ArrayList<HoaDonDTO> hd) {
		DefaultTableModel df = (DefaultTableModel) tableListDSHD.getModel();
		df.setRowCount(0);
		for (HoaDonDTO hoaDonDTO : hd) {
			Object dataRow[] = new Object[5];
			dataRow[0] = hoaDonDTO.getMaHoaDon();
			dataRow[1] = hoaDonDTO.getMaNhanVien();
			dataRow[2] = hoaDonDTO.getMaKhachHang();
			dataRow[3] = hoaDonDTO.getNgayLap();
			dataRow[4] = hoaDonDTO.getTongTien();
			df.addRow(dataRow);
		}
	}

	public void getEventHoaDon() {
		DefaultTableModel df = (DefaultTableModel) tableListDSHD.getModel();
		int indexRow = tableListDSHD.getSelectedRow();
		txtMaHD_HD.setText(df.getValueAt(indexRow, 0).toString());
		txtNhanVienLap_HD.setText(df.getValueAt(indexRow, 1).toString());
		txtMaKH_HD.setText(df.getValueAt(indexRow, 2).toString());
		dateChooserNgayLap_HD.setDateFormatString(df.getValueAt(indexRow, 3).toString());
		txtTongTien_HD.setText(df.getValueAt(indexRow, 4).toString());
	}

	public void ListTableChiTietHoaDon(ArrayList<ChiTietHoaDonDTO> cthd) {
		DefaultTableModel df = (DefaultTableModel) tableListChiTietHD.getModel();
		// xoa data trong table
		df.setRowCount(0);
		for (ChiTietHoaDonDTO chiTietHoaDonDTO : cthd) {
			Object dataRow[] = new Object[5];
			dataRow[0] = chiTietHoaDonDTO.getMaHoaDon();
			dataRow[1] = chiTietHoaDonDTO.getMaSanPham();
			dataRow[2] = chiTietHoaDonDTO.getSoLuong();
			dataRow[3] = chiTietHoaDonDTO.getDonGia();
			dataRow[4] = chiTietHoaDonDTO.getThanhTien();
			df.addRow(dataRow);
		}
	}

	public void getEventChiTietHoaDon() {
		DefaultTableModel df = (DefaultTableModel) tableListChiTietHD.getModel();
		int indexRow = tableListChiTietHD.getSelectedRow();
		txtmaHD_CTHD.setText(df.getValueAt(indexRow, 0).toString());
		txtMaSP_CTHD.setText(df.getValueAt(indexRow, 1).toString());
		txtSoLuong_CTHD.setText(df.getValueAt(indexRow, 2).toString());
		txtDonGia_CTHD.setText(df.getValueAt(indexRow, 3).toString());
		txtThanhTien_CTHD.setText(df.getValueAt(indexRow, 4).toString());
	}

	public void openFile(String file) {
		try {
			File path = new File(file);
			Desktop.getDesktop().open(path);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void exportExcelHD(JTable table) {
		try {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.showSaveDialog(table);

			File saveFile = fileChooser.getSelectedFile();

			if (saveFile != null) {
				saveFile = new File(saveFile.toString() + ".xlsx");
				Workbook workbook = new XSSFWorkbook();
				Sheet sheet = workbook.createSheet("Hóa Đơn");
				Row rowcl = sheet.createRow(0);

				for (int i = 0; i < table.getColumnCount(); i++) {
					Cell cell = rowcl.createCell(i);
					cell.setCellValue(table.getColumnName(i));
				}

				for (int j = 0; j < table.getRowCount(); j++) {
					Row row = sheet.createRow(j + 1);
					for (int k = 0; k < table.getColumnCount(); k++) {
						Cell cell = row.createCell(k);
						if (table.getValueAt(j, k) != null) {
							cell.setCellValue(table.getValueAt(j, k).toString());
						}
					}
				}

				FileOutputStream fileOS = new FileOutputStream(new File(saveFile.toString()));
				workbook.write(fileOS);
				workbook.close();
				fileOS.close();
				openFile(saveFile.toString());
			} else {
				JOptionPane.showMessageDialog(null, "Lỗi xuất file");
			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void exportExcelCTHD(JTable table) {
		try {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.showSaveDialog(table);

			File saveFile = fileChooser.getSelectedFile();

			if (saveFile != null) {
				saveFile = new File(saveFile.toString() + ".xlsx");
				Workbook workbook = new XSSFWorkbook();
				Sheet sheet = workbook.createSheet("Chi tiết Hóa Đơn");
				Row rowcl = sheet.createRow(0);

				for (int i = 0; i < table.getColumnCount(); i++) {
					Cell cell = rowcl.createCell(i);
					cell.setCellValue(table.getColumnName(i));
				}

				for (int j = 0; j < table.getRowCount(); j++) {
					Row row = sheet.createRow(j + 1);
					for (int k = 0; k < table.getColumnCount(); k++) {
						Cell cell = row.createCell(k);
						if (table.getValueAt(j, k) != null) {
							cell.setCellValue(table.getValueAt(j, k).toString());
						}
					}
				}

				FileOutputStream fileOS = new FileOutputStream(new File(saveFile.toString()));
				workbook.write(fileOS);
				workbook.close();
				fileOS.close();
				openFile(saveFile.toString());
			} else {
				JOptionPane.showMessageDialog(null, "Lỗi xuất file");
			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void resetAll() {
		DefaultTableModel df = (DefaultTableModel) tableListGioHang.getModel();
		df.getDataVector().removeAllElements();
		txtGiaTu_BH.setText("");
		txtGiaDen_BH.setText("");
		txtMaKH_BH.setText("");
		txtTenKH_BH.setText("");
		txtMaSP_BH.setText("");
		txtTenSP_BH.setText("");
		txtDonGia_BH.setText("");
		spinnerSoLuong.setValue(0);
		txtMaGiamGia_BH.setText("");
		txtTongTien_BH.setText("");
//		txtTongTienGiam_BH.setText("");
		txtTongThanhToan_BH.setText("");
	}
}
