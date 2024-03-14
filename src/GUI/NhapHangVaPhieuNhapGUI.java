package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BLL.ChiTietPhieuNhapBLL;
import BLL.NhapHangBLL;
import BLL.PhieuNhapBLL;
import DTO.ChiTietPhieuNhapDTO;
import DTO.NhapHangDTO;
import DTO.PhieuNhapDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class NhapHangVaPhieuNhapGUI extends JFrame {

	private JPanel contentPane;
	private JPanel NhapHang;
	private JPanel PhieuNhap;
	private JTextField txtMaPNPhieuNhap;
	private JTextField txtMaNCC;
	private JTextField txtMaNV;
	private JTextField txtTongTien;
	private JTextField txtNgayLap;
	private JTable tableListPhieuNhap;
	private JScrollPane scrollPanePhieuNhap;
	private JTable tableListCTPhieuNhap;
	private JScrollPane scrollPaneKhoHang;
	private JTable tableListKhoHang;
	private JScrollPane scrollPaneHangCho;
	private JTable tableListHangCho;
	private JScrollPane scrollPanectPhieuNhap;
	private JTextField txtSearchNgayLap;
	private JTextField txtMaPNCTPhieuNhap;
	private JTextField txtMaSP_PhieuNhap;
	private JTextField txtSoLuong;
	private JTextField txtDonGia;
	private JTextField txtThanhTien;
	private PhieuNhapBLL pnBLL= new PhieuNhapBLL();
	private PhieuNhapDTO pnDTO=new PhieuNhapDTO();
	private ChiTietPhieuNhapBLL ctpnBLL= new ChiTietPhieuNhapBLL();
	private ChiTietPhieuNhapDTO ctpnDTO=new ChiTietPhieuNhapDTO();
	private NhapHangBLL nhBLL= new NhapHangBLL();
	private NhapHangDTO nhDTO=new NhapHangDTO();
	private JTextField txtMaSP_NhapHang;
	private JTextField txtTenSP;
	private JTextField txtDonGia_NhapHang;
	private JTextField txtTiemKiemTenSP;
	private JTextField txtTongTien_NhapHang;
	private static ToanCuc tc=new ToanCuc();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhapHangVaPhieuNhapGUI frame = new NhapHangVaPhieuNhapGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NhapHangVaPhieuNhapGUI() {
		getContentPane().setBackground(new Color(192, 192, 192));
		setTitle("Quản lý nhập hàng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 700);
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(192, 192, 192));
		tabbedPane.setBounds(0, 0, 1086, 663);
		getContentPane().add(tabbedPane);
		
		NhapHang = new JPanel();
		NhapHang.setBackground(new Color(192, 192, 192));
		tabbedPane.addTab("Nhập hàng", null, NhapHang, null);
		NhapHang.setLayout(null);
		
		JPanel panelKhoHang = new JPanel();
		panelKhoHang.setBackground(new Color(192, 192, 192));
		panelKhoHang.setLayout(null);
		panelKhoHang.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelKhoHang.setBounds(10, 10, 560, 572);
		NhapHang.add(panelKhoHang);
		
		JLabel lbKhoHang = new JLabel("Kho Hàng");
		lbKhoHang.setHorizontalAlignment(SwingConstants.CENTER);
		lbKhoHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbKhoHang.setBounds(10, 10, 540, 25);
		panelKhoHang.add(lbKhoHang);
		
		JLabel lblNewLabel_1_6 = new JLabel("Mã SP :");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_6.setBounds(10, 59, 77, 25);
		panelKhoHang.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Tên SP :");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(10, 94, 77, 25);
		panelKhoHang.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Đơn giá :");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_3_1.setBounds(290, 94, 109, 25);
		panelKhoHang.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Số lượng :");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_4_1.setBounds(290, 59, 109, 25);
		panelKhoHang.add(lblNewLabel_1_4_1);
		
		txtMaSP_NhapHang = new JTextField();
		txtMaSP_NhapHang.setEditable(false);
		txtMaSP_NhapHang.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtMaSP_NhapHang.setColumns(10);
		txtMaSP_NhapHang.setBounds(97, 62, 141, 25);
		panelKhoHang.add(txtMaSP_NhapHang);
		
		txtTenSP = new JTextField();
		txtTenSP.setEditable(false);
		txtTenSP.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTenSP.setColumns(10);
		txtTenSP.setBounds(97, 97, 141, 25);
		panelKhoHang.add(txtTenSP);
		
		txtDonGia_NhapHang = new JTextField();
		txtDonGia_NhapHang.setEditable(false);
		txtDonGia_NhapHang.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtDonGia_NhapHang.setColumns(10);
		txtDonGia_NhapHang.setBounds(409, 97, 141, 25);
		panelKhoHang.add(txtDonGia_NhapHang);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("Tìm kiếm  :");
		lblNewLabel_1_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_1_2.setBounds(97, 143, 116, 25);
		panelKhoHang.add(lblNewLabel_1_2_1_2);
		
		scrollPaneKhoHang = new JScrollPane();
		scrollPaneKhoHang.setBounds(10, 259, 540, 303);
		panelKhoHang.add(scrollPaneKhoHang);
		
		tableListKhoHang=new JTable();
		tableListKhoHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getEventKhoHang();
			}
		});
		tableListKhoHang.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				getEventKhoHang();
			}
		});
		tableListKhoHang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableListKhoHang.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Mã sản phẩm","Tên sản phẩm","Còn lại","Đơn giá"
				}
			));
		
		scrollPaneKhoHang.setViewportView(tableListKhoHang);
		
		JLabel lblNewLabel_1_2_1_1_2 = new JLabel("(Theo tên SP)");
		lblNewLabel_1_2_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1_2.setBounds(97, 167, 103, 19);
		panelKhoHang.add(lblNewLabel_1_2_1_1_2);
		
		txtTiemKiemTenSP = new JTextField();
		txtTiemKiemTenSP.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				ListTableKhoHang(nhBLL.timKiemBLL(txtTiemKiemTenSP.getText()));
				
			}
		});
		txtTiemKiemTenSP.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTiemKiemTenSP.setColumns(10);
		txtTiemKiemTenSP.setBounds(241, 142, 141, 25);
		panelKhoHang.add(txtTiemKiemTenSP);
		
		JSpinner spinnerSoLuong = new JSpinner();
		spinnerSoLuong.setBackground(new Color(192, 192, 192));
		spinnerSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		spinnerSoLuong.setBounds(409, 60, 141, 25);
		panelKhoHang.add(spinnerSoLuong);
		
		
		
		
		
		JButton btnChonNhap = new JButton("Chọn nhập");
		btnChonNhap.setForeground(new Color(255, 255, 255));
		btnChonNhap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnChonNhap.setBackground(Color.RED);
		btnChonNhap.setBounds(200, 205, 148, 44);
		panelKhoHang.add(btnChonNhap);
		
		JPanel panelCTPhieuNhap_1 = new JPanel();
		panelCTPhieuNhap_1.setBackground(new Color(192, 192, 192));
		panelCTPhieuNhap_1.setLayout(null);
		panelCTPhieuNhap_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelCTPhieuNhap_1.setBounds(580, 10, 491, 572);
		NhapHang.add(panelCTPhieuNhap_1);
		
		JLabel lblNhpHng = new JLabel("Nhập Hàng");
		lblNhpHng.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhpHng.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNhpHng.setBounds(10, 10, 471, 25);
		panelCTPhieuNhap_1.add(lblNhpHng);
		
		JPanel panelHangCho = new JPanel();
		panelHangCho.setBackground(new Color(192, 192, 192));
		panelHangCho.setBorder(new TitledBorder(null, "H\u00E0ng ch\u1EDD nh\u1EADp", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelHangCho.setBounds(10, 235, 471, 273);
		panelCTPhieuNhap_1.add(panelHangCho);
		panelHangCho.setLayout(null);
		
		scrollPaneHangCho = new JScrollPane();
		scrollPaneHangCho.setBounds(10, 24, 451, 239);
		panelHangCho.add(scrollPaneHangCho);
		
		tableListHangCho=new JTable();
		tableListHangCho.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableListHangCho.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Mã sản phẩm","Tên sản phẩm","Số lượng","Đơn giá","Thành tiền"
				}
			));
		
		scrollPaneHangCho.setViewportView(tableListHangCho);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin phi\u1EBFu nh\u1EADp", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 45, 471, 180);
		panelCTPhieuNhap_1.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_6_1 = new JLabel("Nhân viên :");
		lblNewLabel_1_6_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_6_1.setBounds(89, 22, 136, 25);
		panel_1.add(lblNewLabel_1_6_1);
		
		JLabel lblNewLabel_1_6_1_1 = new JLabel("Nhà cung cấp :");
		lblNewLabel_1_6_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_6_1_1.setBounds(89, 57, 136, 25);
		panel_1.add(lblNewLabel_1_6_1_1);
		
		JLabel lblNewLabel_1_6_1_2 = new JLabel("Tổng tiền :");
		lblNewLabel_1_6_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_6_1_2.setBounds(89, 92, 136, 25);
		panel_1.add(lblNewLabel_1_6_1_2);
		
		txtTongTien_NhapHang = new JTextField();
		txtTongTien_NhapHang.setText("0");
		txtTongTien_NhapHang.setEditable(false);
		txtTongTien_NhapHang.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTongTien_NhapHang.setColumns(10);
		txtTongTien_NhapHang.setBounds(235, 92, 141, 25);
		panel_1.add(txtTongTien_NhapHang);
		
		JComboBox cbbNhaCungCap = new JComboBox();
		cbbNhaCungCap.setBackground(new Color(192, 192, 192));
		cbbNhaCungCap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbbNhaCungCap.setBounds(235, 60, 141, 25);
		panel_1.add(cbbNhaCungCap);
		
		JLabel lbTenNhanVien = new JLabel("");
		lbTenNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbTenNhanVien.setBounds(235, 22, 226, 25);
		panel_1.add(lbTenNhanVien);
		
		JLabel lbTenNhanVien_1 = new JLabel("VND");
		lbTenNhanVien_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbTenNhanVien_1.setBounds(386, 92, 51, 25);
		panel_1.add(lbTenNhanVien_1);
		
		JButton btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.setForeground(new Color(255, 255, 255));
		btnXacNhan.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\add.png"));
		btnXacNhan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnXacNhan.setBackground(Color.RED);
		btnXacNhan.setBounds(113, 518, 151, 44);
		panelCTPhieuNhap_1.add(btnXacNhan);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setForeground(new Color(255, 255, 255));
		btnXoa.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\delete.png"));
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnXoa.setBackground(Color.RED);
		btnXoa.setBounds(274, 518, 108, 44);
		panelCTPhieuNhap_1.add(btnXoa);
		
		JButton btnHome_NhapHang = new JButton("Home");
		btnHome_NhapHang.setForeground(new Color(255, 255, 255));
		btnHome_NhapHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrangChuGUI t=new TrangChuGUI();
				dispose();
				t.setVisible(true);
			}
		});
		btnHome_NhapHang.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\home.png"));
		btnHome_NhapHang.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnHome_NhapHang.setBackground(Color.RED);
		btnHome_NhapHang.setBounds(499, 588, 148, 44);
		NhapHang.add(btnHome_NhapHang);
		
		PhieuNhap = new JPanel();
		PhieuNhap.setBackground(new Color(192, 192, 192));
		tabbedPane.addTab("Phiếu Nhập", null, PhieuNhap, null);
		PhieuNhap.setLayout(null);
		
		JPanel panelPhieuNhap = new JPanel();
		panelPhieuNhap.setBackground(new Color(192, 192, 192));
		panelPhieuNhap.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelPhieuNhap.setBounds(10, 10, 560, 572);
		PhieuNhap.add(panelPhieuNhap);
		panelPhieuNhap.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Phiếu Nhập");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 10, 540, 25);
		panelPhieuNhap.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã PN :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 59, 77, 25);
		panelPhieuNhap.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã NCC :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(10, 94, 77, 25);
		panelPhieuNhap.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Mã NV :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(10, 129, 77, 25);
		panelPhieuNhap.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Ngày lập :");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_3.setBounds(290, 94, 109, 25);
		panelPhieuNhap.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Tổng tiền :");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_4.setBounds(290, 59, 109, 25);
		panelPhieuNhap.add(lblNewLabel_1_4);
		
		txtMaPNPhieuNhap = new JTextField();
		txtMaPNPhieuNhap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtMaPNPhieuNhap.setBounds(97, 62, 141, 25);
		panelPhieuNhap.add(txtMaPNPhieuNhap);
		txtMaPNPhieuNhap.setColumns(10);
		
		txtMaNCC = new JTextField();
		txtMaNCC.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtMaNCC.setColumns(10);
		txtMaNCC.setBounds(97, 97, 141, 25);
		panelPhieuNhap.add(txtMaNCC);
		
		txtMaNV = new JTextField();
		txtMaNV.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtMaNV.setColumns(10);
		txtMaNV.setBounds(97, 132, 141, 25);
		panelPhieuNhap.add(txtMaNV);
		
		txtTongTien = new JTextField();
		txtTongTien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTongTien.setColumns(10);
		txtTongTien.setBounds(409, 62, 141, 25);
		panelPhieuNhap.add(txtTongTien);
		
		txtNgayLap = new JTextField();
		txtNgayLap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNgayLap.setColumns(10);
		txtNgayLap.setBounds(409, 97, 141, 25);
		panelPhieuNhap.add(txtNgayLap);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Tìm kiếm  :");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_1.setBounds(97, 192, 116, 25);
		panelPhieuNhap.add(lblNewLabel_1_2_1);
		
		JPanel panelCTPhieuNhap = new JPanel();
		panelCTPhieuNhap.setBackground(new Color(192, 192, 192));
		panelCTPhieuNhap.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelCTPhieuNhap.setBounds(580, 10, 491, 572);
		PhieuNhap.add(panelCTPhieuNhap);
		panelCTPhieuNhap.setLayout(null);
		
		JLabel lblChiTitPhiu = new JLabel("Chi Tiết Phiếu Nhập");
		lblChiTitPhiu.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTitPhiu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChiTitPhiu.setBounds(10, 10, 471, 25);
		panelCTPhieuNhap.add(lblChiTitPhiu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		scrollPanePhieuNhap = new JScrollPane();
		scrollPanePhieuNhap.setBounds(10, 259, 540, 303);
		panelPhieuNhap.add(scrollPanePhieuNhap);
		
		tableListPhieuNhap=new JTable();
		tableListPhieuNhap.setBackground(new Color(255, 255, 255));
		
		tableListPhieuNhap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getEventPhieuNhap();
			}
		});
		tableListPhieuNhap.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				getEventPhieuNhap();
			}
		});
		
		tableListPhieuNhap.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableListPhieuNhap.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Mã PN","Mã NCC","Mã NV","Ngày lập","Tổng tiền"
				}
			));
		scrollPanePhieuNhap.setViewportView(tableListPhieuNhap);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("(Theo ngày)");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1.setBounds(97, 215, 95, 19);
		panelPhieuNhap.add(lblNewLabel_1_2_1_1);
		
		txtSearchNgayLap = new JTextField();
		txtSearchNgayLap.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				String NgayLap=txtSearchNgayLap.getText();
				if(NgayLap.equals("")) {
					tableListPhieuNhap.removeAll();
					ListTablePhieuNhap(pnBLL.ListThongTinSinhVienBLL());
				}
				
				try {
					java.sql.Date ngaySinh=null;
					try {
						DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
						java.util.Date date=formatter.parse(NgayLap);
						long temp =date.getTime();
						ngaySinh= new java.sql.Date(temp);
						
						ListTablePhieuNhap(pnBLL.SearchThongTinSinhVienBLL(ngaySinh));

					} catch (ParseException e1) {
						// TODO: handle exception
					}
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		
		txtSearchNgayLap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtSearchNgayLap.setColumns(10);
		txtSearchNgayLap.setBounds(242, 191, 141, 25);
		panelPhieuNhap.add(txtSearchNgayLap);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("(yyyy-mm-dd)");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1_1.setBounds(266, 215, 101, 19);
		panelPhieuNhap.add(lblNewLabel_1_2_1_1_1);
		
		scrollPanectPhieuNhap = new JScrollPane();
		scrollPanectPhieuNhap.setBounds(10, 259, 471, 303);
		panelCTPhieuNhap.add(scrollPanectPhieuNhap);
		tableListCTPhieuNhap=new JTable();
		tableListCTPhieuNhap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getEventChiTietPhieuNhap();
			}
		});
		tableListCTPhieuNhap.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				getEventChiTietPhieuNhap();
			}
		});

		tableListCTPhieuNhap.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableListCTPhieuNhap.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Mã PN","Mã SP","Số lượng","Đơn giá","Thành tiền"
				}
			));
		scrollPanectPhieuNhap.setViewportView(tableListCTPhieuNhap);
		
		JLabel lblNewLabel_1_5 = new JLabel("Mã PN :");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_5.setBounds(85, 60, 107, 25);
		panelCTPhieuNhap.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("Mã SP :");
		lblNewLabel_1_5_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_5_1.setBounds(85, 95, 107, 25);
		panelCTPhieuNhap.add(lblNewLabel_1_5_1);
		
		JLabel lblNewLabel_1_5_2 = new JLabel("Số lượng :");
		lblNewLabel_1_5_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_5_2.setBounds(85, 130, 107, 25);
		panelCTPhieuNhap.add(lblNewLabel_1_5_2);
		
		JLabel lblNewLabel_1_5_3 = new JLabel("Đơn giá :");
		lblNewLabel_1_5_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_5_3.setBounds(85, 165, 107, 25);
		panelCTPhieuNhap.add(lblNewLabel_1_5_3);
		
		JLabel lblNewLabel_1_5_4 = new JLabel("Thành tiền :");
		lblNewLabel_1_5_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_5_4.setBounds(85, 200, 107, 25);
		panelCTPhieuNhap.add(lblNewLabel_1_5_4);
		
		txtMaPNCTPhieuNhap = new JTextField();
		txtMaPNCTPhieuNhap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtMaPNCTPhieuNhap.setColumns(10);
		txtMaPNCTPhieuNhap.setBounds(202, 62, 141, 25);
		panelCTPhieuNhap.add(txtMaPNCTPhieuNhap);
		
		txtMaSP_PhieuNhap = new JTextField();
		txtMaSP_PhieuNhap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtMaSP_PhieuNhap.setColumns(10);
		txtMaSP_PhieuNhap.setBounds(202, 94, 141, 25);
		panelCTPhieuNhap.add(txtMaSP_PhieuNhap);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(202, 130, 141, 25);
		panelCTPhieuNhap.add(txtSoLuong);
		
		txtDonGia = new JTextField();
		txtDonGia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtDonGia.setColumns(10);
		txtDonGia.setBounds(202, 164, 141, 25);
		panelCTPhieuNhap.add(txtDonGia);
		
		txtThanhTien = new JTextField();
		txtThanhTien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtThanhTien.setColumns(10);
		txtThanhTien.setBounds(202, 199, 141, 25);
		panelCTPhieuNhap.add(txtThanhTien);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrangChuGUI t=new TrangChuGUI();
				dispose();
				t.setVisible(true);
			}
		});
		btnHome.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\home.png"));
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnHome.setBackground(Color.RED);
		btnHome.setBounds(499, 588, 148, 44);
		PhieuNhap.add(btnHome);
		
		lbTenNhanVien.setText(String.valueOf(tc.getMaNhanVien())+" "+tc.getTenNhanVien().trim());
		
		btnChonNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int indexRow=tableListKhoHang.getSelectedRow();
				if(indexRow==-1) {
					JOptionPane.showMessageDialog(btnChonNhap, "Chưa chọn giá trị!");
					return;
				}
				
				int value = (Integer) spinnerSoLuong.getValue();
				if(value<=0) {
					JOptionPane.showMessageDialog(btnChonNhap, "Số lượng phải lớn hơn 0!");
					return;
				}
				float donGia=Float.parseFloat(txtDonGia_NhapHang.getText());
				txtTenSP.getText();
				txtDonGia_NhapHang.getText();
				DefaultTableModel df = (DefaultTableModel)tableListHangCho.getModel();
				Object dataRow[] =new Object[5];
				dataRow[0]=txtMaSP_NhapHang.getText();
				dataRow[1]=txtTenSP.getText();
				dataRow[2]=value;
				dataRow[3]=donGia;
				dataRow[4]=value*donGia;
				df.addRow(dataRow);
				
			}
		});
		
		tableListHangCho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel df= (DefaultTableModel) tableListHangCho.getModel();
				int indexRow=tableListHangCho.getSelectedRow();
				
				txtTongTien_NhapHang.setText(df.getValueAt(indexRow, 4).toString());
				
			}
		});
	
		nhBLL.ListComboboxNhapHangBLL(cbbNhaCungCap);
		btnXacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int indexRow1=tableListHangCho.getSelectedRow();
				if(indexRow1==-1) {
					JOptionPane.showMessageDialog(spinnerSoLuong, "Chưa chọn giá trị!");
					return;
				}
				DefaultTableModel df= (DefaultTableModel) tableListHangCho.getModel();
				int indexRow=tableListHangCho.getSelectedRow();
				JTextField msp=new JTextField();
				JTextField sl=new JTextField();
				JTextField dg=new JTextField();
				
				msp.setText(df.getValueAt(indexRow, 0).toString()); 
				sl.setText(df.getValueAt(indexRow, 2).toString()); 
				dg.setText(df.getValueAt(indexRow, 3).toString()); 
				int maSanPham=Integer.parseInt(msp.getText());
				int soLuong=Integer.parseInt(sl.getText());
				float donGia=Float.parseFloat(dg.getText());
				
				String maNhaCCSTring=(String) cbbNhaCungCap.getSelectedItem();
				int maNCC=nhBLL.layMaNhaCCBLL(maNhaCCSTring);
				int maNhanVien=tc.getMaNhanVien();
				
				java.sql.Date date=new java.sql.Date(System.currentTimeMillis());
			    float tongTien=Float.parseFloat(txtTongTien_NhapHang.getText());
			    pnDTO= new PhieuNhapDTO(maNCC, maNhanVien, date, tongTien, 1);
			    
			    if(pnBLL.InsertBLL(pnDTO)==true) {
					JOptionPane.showMessageDialog(btnXacNhan,"Thêm thành công");
					nhBLL.UpdateSanPhamBLL(maSanPham, soLuong);
					int maPhieunhap=pnBLL.getMaPhieuNhapBLL();
					ctpnDTO=new ChiTietPhieuNhapDTO(maPhieunhap, maSanPham, soLuong, donGia, tongTien);
					ctpnBLL.addBLL(ctpnDTO);
					
					
					ListTableKhoHang(nhBLL.layToanBoKhoHangBLL());
					ListTablePhieuNhap(pnBLL.ListThongTinSinhVienBLL());
					ListTableChiTietPhieuNhap(ctpnBLL.ListThongTinSinhVienBLL()); 
					return;	
				}
				else {
					JOptionPane.showMessageDialog(btnXacNhan,"Thêm thất bại");
					return;	
				}
			    
			    
			}
		});
		
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel df= (DefaultTableModel) tableListHangCho.getModel();
				int indexRow=tableListHangCho.getSelectedRow();
				if(indexRow==-1) {
					JOptionPane.showMessageDialog(btnXoa, "Chưa chọn giá trị!");
					return;
				}
				df.removeRow(indexRow);
			}
		});
		
		ListTablePhieuNhap(pnBLL.ListThongTinSinhVienBLL());
		ListTableChiTietPhieuNhap(ctpnBLL.ListThongTinSinhVienBLL());
		ListTableKhoHang(nhBLL.layToanBoKhoHangBLL());
		
	}
	public void ListTablePhieuNhap(ArrayList<PhieuNhapDTO> pn) {
		DefaultTableModel df= (DefaultTableModel) tableListPhieuNhap.getModel();
		//xoa data trong table
		df.setRowCount(0);
		for (PhieuNhapDTO phieuNhapDTO : pn) {
			Object dataRow[] =new Object[5];
			dataRow[0]=phieuNhapDTO.getMaPhieuNhap();
			dataRow[1]=phieuNhapDTO.getMaNhaCungCap();
			dataRow[2]=phieuNhapDTO.getMaNhanVien();
			dataRow[3]=phieuNhapDTO.getNgayLap();
			dataRow[4]=phieuNhapDTO.getTongTien();
			df.addRow(dataRow);
		}
	}
	public void getEventPhieuNhap() {
		DefaultTableModel df= (DefaultTableModel) tableListPhieuNhap.getModel();
		int indexRow=tableListPhieuNhap.getSelectedRow();
		txtMaPNPhieuNhap.setText(df.getValueAt(indexRow, 0).toString());
		txtMaNCC.setText(df.getValueAt(indexRow, 1).toString());
		txtMaNV.setText(df.getValueAt(indexRow, 2).toString());
		txtNgayLap.setText(df.getValueAt(indexRow, 3).toString());
		txtTongTien.setText(df.getValueAt(indexRow, 4).toString());
	}
	public void ListTableChiTietPhieuNhap(ArrayList<ChiTietPhieuNhapDTO> ctpn) {
		DefaultTableModel df= (DefaultTableModel) tableListCTPhieuNhap.getModel();
		//xoa data trong table
		df.setRowCount(0);
		for (ChiTietPhieuNhapDTO chiTietPhieuNhapDTO : ctpn) {
			Object dataRow[] =new Object[5];
			dataRow[0]=chiTietPhieuNhapDTO.getMaPhieuNhap();
			dataRow[1]=chiTietPhieuNhapDTO.getMaSanPham();
			dataRow[2]=chiTietPhieuNhapDTO.getSoLuong();
			dataRow[3]=chiTietPhieuNhapDTO.getDonGia();
			dataRow[4]=chiTietPhieuNhapDTO.getThanhTien();
			df.addRow(dataRow);
		}
	}
	public void getEventChiTietPhieuNhap() {
		DefaultTableModel df= (DefaultTableModel) tableListCTPhieuNhap.getModel();
		int indexRow=tableListCTPhieuNhap.getSelectedRow();
		txtMaPNCTPhieuNhap.setText(df.getValueAt(indexRow, 0).toString());
		txtMaSP_PhieuNhap.setText(df.getValueAt(indexRow, 1).toString());
		txtSoLuong.setText(df.getValueAt(indexRow, 2).toString());
		txtDonGia.setText(df.getValueAt(indexRow, 3).toString());
		txtThanhTien.setText(df.getValueAt(indexRow, 4).toString());

		
	}
	public void ListTableKhoHang(ArrayList<NhapHangDTO> nh) {
		DefaultTableModel df= (DefaultTableModel) tableListKhoHang.getModel();
		//xoa data trong table
		df.setRowCount(0);
		for (NhapHangDTO nhapHangDTO : nh) {
			Object dataRow[] =new Object[4];
			dataRow[0]=nhapHangDTO.getMaSanPham();
			dataRow[1]=nhapHangDTO.getTenSanPham().trim();
			dataRow[2]=nhapHangDTO.getSoLuong();
			dataRow[3]=nhapHangDTO.getDonGia();
			df.addRow(dataRow);
		}
	}
	public void getEventKhoHang() {
		DefaultTableModel df= (DefaultTableModel) tableListKhoHang.getModel();
		int indexRow=tableListKhoHang.getSelectedRow();
		txtMaSP_NhapHang.setText(df.getValueAt(indexRow, 0).toString());
		txtTenSP.setText(df.getValueAt(indexRow, 1).toString());
		txtDonGia_NhapHang.setText(df.getValueAt(indexRow, 3).toString());
	}
}
