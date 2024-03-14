package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import BLL.PhanQuyenBLL;
import BLL.TaiKhoanBLL;
import DTO.KhuyenMaiDTO;
import DTO.PhanQuyenDTO;
import DTO.TaiKhoanDTO;

import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

public class PhanQuyenGUI extends JFrame {

	private JPanel contentPane;
	private PhanQuyenDTO pq=new PhanQuyenDTO();
	private PhanQuyenBLL pqBLL=new PhanQuyenBLL();
	private JScrollPane scrollPane;
	private JTable tableList;
	private JTextField txtMaNhanVien;
	private JTextField txtTenDangNhap;
	private JTextField txtMatKhau;
	private TaiKhoanDTO tkDTo=new TaiKhoanDTO();
	private TaiKhoanBLL tkBLL =new TaiKhoanBLL();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhanQuyenGUI frame = new PhanQuyenGUI();
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
	public PhanQuyenGUI() {
		setTitle("Quản lý");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(192, 192, 192));
		tabbedPane.setBounds(0, 0, 1086, 663);
		getContentPane().add(tabbedPane);
		
		JPanel PhanQuyen = new JPanel();
		PhanQuyen.setBackground(new Color(192, 192, 192));
		tabbedPane.addTab("Phân Quyền", null, PhanQuyen, null);
		PhanQuyen.setLayout(null);
		
		
		//
		
		JLabel lblNewLabel = new JLabel("Quản lý phân quyền");
		lblNewLabel.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\ChiNhanh.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(10, 10, 1066, 89);
		PhanQuyen.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(796, 109, 280, 485);
		PhanQuyen.add(panel);
		panel.setLayout(null);
		
		JButton btnThucThi = new JButton("Thực thi");
		btnThucThi.setForeground(new Color(255, 255, 255));
		btnThucThi.setBackground(new Color(255, 0, 0));
		
		btnThucThi.setIcon(null);
		btnThucThi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThucThi.setBounds(86, 199, 121, 46);
		panel.add(btnThucThi);
		
		JButton btnHome = new JButton("Home");
		btnHome.setForeground(new Color(255, 255, 255));
		btnHome.setBackground(new Color(255, 0, 0));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrangChuGUI t=new TrangChuGUI();
				dispose();
				t.setVisible(true);
			}
		});
		btnHome.setBounds(72, 267, 148, 46);
		panel.add(btnHome);
		btnHome.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\home.png"));
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "C\u00E1c lo\u1EA1i quy\u1EC1n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(267, 109, 519, 485);
		PhanQuyen.add(panel_1);
		
		JCheckBox ckbQuanLyBanHang = new JCheckBox("Quản lý bán hàng");
		ckbQuanLyBanHang.setBackground(new Color(192, 192, 192));
		ckbQuanLyBanHang.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ckbQuanLyBanHang.setBounds(115, 80, 259, 21);
		panel_1.add(ckbQuanLyBanHang);
		
		JCheckBox ckbQuanLyNhapHang = new JCheckBox("Quản lý nhập hàng");
		ckbQuanLyNhapHang.setBackground(new Color(192, 192, 192));
		ckbQuanLyNhapHang.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ckbQuanLyNhapHang.setBounds(115, 130, 259, 21);
		panel_1.add(ckbQuanLyNhapHang);
		
		JCheckBox ckbQuanLyKhachHang = new JCheckBox("Quản lý khách hàng");
		ckbQuanLyKhachHang.setBackground(new Color(192, 192, 192));
		ckbQuanLyKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ckbQuanLyKhachHang.setBounds(115, 180, 259, 21);
		panel_1.add(ckbQuanLyKhachHang);
		
		JCheckBox ckbQuanLyNhanVien = new JCheckBox("Quản lý nhân viên");
		ckbQuanLyNhanVien.setBackground(new Color(192, 192, 192));
		ckbQuanLyNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ckbQuanLyNhanVien.setBounds(115, 230, 259, 21);
		panel_1.add(ckbQuanLyNhanVien);
		
		JCheckBox ckbQuanLySanPham = new JCheckBox("Quản lý sản phẩm");
		ckbQuanLySanPham.setBackground(new Color(192, 192, 192));
		ckbQuanLySanPham.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ckbQuanLySanPham.setBounds(115, 280, 259, 21);
		panel_1.add(ckbQuanLySanPham);
		
		JCheckBox ckbQuanLyXemThongKe = new JCheckBox("Quản lý xem thống kê");
		ckbQuanLyXemThongKe.setBackground(new Color(192, 192, 192));
		ckbQuanLyXemThongKe.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ckbQuanLyXemThongKe.setBounds(115, 330, 259, 21);
		panel_1.add(ckbQuanLyXemThongKe);
		
		JCheckBox ckbQuanLyPhanQuyen = new JCheckBox("Quản lý phân quyền");
		ckbQuanLyPhanQuyen.setBackground(new Color(192, 192, 192));
		ckbQuanLyPhanQuyen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ckbQuanLyPhanQuyen.setBounds(115, 380, 259, 21);
		panel_1.add(ckbQuanLyPhanQuyen);
		
		JCheckBox ckbQuanLyKhuyenMai = new JCheckBox("Quản lý khuyến mãi");
		ckbQuanLyKhuyenMai.setBackground(new Color(192, 192, 192));
		ckbQuanLyKhuyenMai.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ckbQuanLyKhuyenMai.setBounds(115, 430, 259, 21);
		panel_1.add(ckbQuanLyKhuyenMai);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(192, 192, 192));
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "M\u00E3 quy\u1EC1n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(10, 109, 247, 485);
		PhanQuyen.add(panel_2);
		
		JComboBox cbbChucVu = new JComboBox();
		cbbChucVu.setBackground(new Color(192, 192, 192));
		cbbChucVu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maQuyen=(String) cbbChucVu.getSelectedItem();
				
//				ckbQuanLyBanHang.setSelected(false);
//				ckbQuanLyNhapHang.setSelected(false);
//				ckbQuanLyKhachHang.setSelected(false);
//				ckbQuanLyNhanVien.setSelected(false);
//				ckbQuanLySanPham.setSelected(false);
//				ckbQuanLyXemThongKe.setSelected(false);
//				ckbQuanLyPhanQuyen.setSelected(false);
//				ckbQuanLyKhuyenMai.setSelected(false);
				
				for (PhanQuyenDTO pqDTO : pqBLL.layToanBoQuyenTheoMaQuyenBLL(maQuyen.trim())) {
					
					if(pqDTO.getQuanLyBanHang()==1) {
						ckbQuanLyBanHang.setSelected(true);
					}else {
						ckbQuanLyBanHang.setSelected(false);
					}
					if(pqDTO.getQuanLyNhapHang()==1) {
						ckbQuanLyNhapHang.setSelected(true);
					}else {
						ckbQuanLyNhapHang.setSelected(false);
					}
					if(pqDTO.getQuanLyKhachHang()==1) {
						ckbQuanLyKhachHang.setSelected(true);
					}else {
						ckbQuanLyKhachHang.setSelected(false);
					}
					if(pqDTO.getQuanLyNhanVien()==1) {
						ckbQuanLyNhanVien.setSelected(true);
					}else {
						ckbQuanLyNhanVien.setSelected(false);
					}
					if(pqDTO.getQuanLySanPham()==1) {
						ckbQuanLySanPham.setSelected(true);
					}else {
						ckbQuanLySanPham.setSelected(false);
					}
					if(pqDTO.getQuanLyXemThongKe()==1) {
						ckbQuanLyXemThongKe.setSelected(true);
					}else {
						ckbQuanLyXemThongKe.setSelected(false);
					}
					if(pqDTO.getQuanLyPhanQuyen()==1) {
						ckbQuanLyPhanQuyen.setSelected(true);
					}else {
						ckbQuanLyPhanQuyen.setSelected(false);
					}
					if(pqDTO.getQuanLyKhuyenMai()==1) {
						ckbQuanLyKhuyenMai.setSelected(true);
					}else {
						ckbQuanLyKhuyenMai.setSelected(false);
					}
				}
			}
		});
		cbbChucVu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbbChucVu.setBounds(50, 243, 148, 28);
		panel_2.add(cbbChucVu);
		
		pqBLL.ListComboboxDAL(cbbChucVu);
		
		btnThucThi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maQuyen=(String) cbbChucVu.getSelectedItem();
				int QuanLyBanHang;
				int QuanLyNhapHang;
				int QuanLyKhachHang;
				int QuanLyNhanVien;
				int QuanLySanPham;
				int QuanLyXemThongKe;
				int QuanLyPhanQuyen;
				int QuanLyKhuyenMai;
				
				if(ckbQuanLyBanHang.isSelected()==true) {
					QuanLyBanHang=1;
				}else {
					QuanLyBanHang=0;
				}
				if(ckbQuanLyNhapHang.isSelected()==true) {
					QuanLyNhapHang=1;
				}else {
					QuanLyNhapHang=0;
				}
				if(ckbQuanLyKhachHang.isSelected()==true) {
					QuanLyKhachHang=1;
				}else {
					QuanLyKhachHang=0;
				}
				if(ckbQuanLyNhanVien.isSelected()==true) {
					QuanLyNhanVien=1;
				}else {
					QuanLyNhanVien=0;
				}
				if(ckbQuanLySanPham.isSelected()==true) {
					QuanLySanPham=1;
				}else {
					QuanLySanPham=0;
				}
				if(ckbQuanLyXemThongKe.isSelected()==true) {
					QuanLyXemThongKe=1;
				}else {
					QuanLyXemThongKe=0;
				}
				if(ckbQuanLyPhanQuyen.isSelected()==true) {
					QuanLyPhanQuyen=1;
				}else {
					QuanLyPhanQuyen=0;
				}
				if(ckbQuanLyKhuyenMai.isSelected()==true) {
					QuanLyKhuyenMai=1;
				}else {
					QuanLyKhuyenMai=0;
				}
				pq =new PhanQuyenDTO(maQuyen, QuanLyBanHang, QuanLyNhapHang, QuanLyKhachHang, QuanLyNhanVien, QuanLySanPham, QuanLyXemThongKe, QuanLyPhanQuyen, QuanLyKhuyenMai);
				if(pqBLL.thucThiPhanQuyenBLL(pq)==true) {
					JOptionPane.showMessageDialog(btnThucThi,"Phân quyền thành công!");
				}
				else {
					JOptionPane.showMessageDialog(btnThucThi,"Phân quyền thất bại!");
				}
			}
		});
		
		
		JPanel TaiKhoan = new JPanel();
		TaiKhoan.setBackground(new Color(192, 192, 192));
		tabbedPane.addTab("Tài Khoản", null, TaiKhoan, null);
		TaiKhoan.setLayout(null);
		
		JButton btnHomeTK = new JButton("Home");
		btnHomeTK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrangChuGUI tc=new TrangChuGUI();
				dispose();
				tc.setVisible(true);
			}
		});
		btnHomeTK.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\home.png"));
		btnHomeTK.setForeground(Color.WHITE);
		btnHomeTK.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnHomeTK.setBackground(Color.RED);
		btnHomeTK.setBounds(486, 582, 148, 44);
		TaiKhoan.add(btnHomeTK);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 265, 1066, 307);
		TaiKhoan.add(scrollPane);
		
		tableList=new JTable();
		tableList.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				getEvent();
			}
		});
		tableList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getEvent();
			}
		});
		
		
		tableList.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableList.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Mã quyền","Mã nhân viên","Tên đăng nhập","Mật khẩu","Tình trạng"
				}
			));
		scrollPane.setViewportView(tableList);
		
		JLabel lblNewLabel_1 = new JLabel("Mã quyền :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(47, 64, 135, 29);
		TaiKhoan.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã nhân viên :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(47, 130, 135, 29);
		TaiKhoan.add(lblNewLabel_1_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(690, 10, 381, 245);
		TaiKhoan.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		
		btnAdd.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\add.png"));
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAdd.setBackground(Color.RED);
		btnAdd.setBounds(50, 44, 141, 36);
		panel_3.add(btnAdd);
		
		JButton btnUppdate = new JButton("Update");
		
		btnUppdate.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\update.png"));
		btnUppdate.setForeground(Color.WHITE);
		btnUppdate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUppdate.setBackground(Color.RED);
		btnUppdate.setBounds(50, 113, 141, 36);
		panel_3.add(btnUppdate);
		
		JButton btnRemove = new JButton("Remove");
		
		btnRemove.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\delete.png"));
		btnRemove.setForeground(Color.WHITE);
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRemove.setBackground(Color.RED);
		btnRemove.setBounds(50, 178, 141, 36);
		panel_3.add(btnRemove);
		
		JButton btnKhoa = new JButton("Khóa");
		
		btnKhoa.setForeground(Color.WHITE);
		btnKhoa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnKhoa.setBackground(Color.RED);
		btnKhoa.setBounds(230, 44, 141, 36);
		panel_3.add(btnKhoa);
		
		JButton btnMoKhoa = new JButton("Mở khóa");
		
		btnMoKhoa.setForeground(Color.WHITE);
		btnMoKhoa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnMoKhoa.setBackground(Color.RED);
		btnMoKhoa.setBounds(230, 113, 141, 36);
		panel_3.add(btnMoKhoa);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tên đăng nhập :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(350, 64, 135, 29);
		TaiKhoan.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Mật khẩu :");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_3.setBounds(350, 130, 135, 29);
		TaiKhoan.add(lblNewLabel_1_3);
		
		JComboBox cbbMaQuyen = new JComboBox();
		cbbMaQuyen.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Quản trị ", "Quản lý", "Nhân viên"}));
		cbbMaQuyen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbbMaQuyen.setBackground(new Color(192, 192, 192));
		cbbMaQuyen.setBounds(192, 64, 148, 28);
		TaiKhoan.add(cbbMaQuyen);
		
		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtMaNhanVien.setBounds(192, 130, 148, 28);
		TaiKhoan.add(txtMaNhanVien);
		txtMaNhanVien.setColumns(10);
		
		txtTenDangNhap = new JTextField();
		txtTenDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTenDangNhap.setColumns(10);
		txtTenDangNhap.setBounds(486, 64, 148, 28);
		TaiKhoan.add(txtTenDangNhap);
		
		txtMatKhau = new JTextField();
		txtMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtMatKhau.setColumns(10);
		txtMatKhau.setBounds(486, 131, 148, 28);
		TaiKhoan.add(txtMatKhau);
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maQuyen=(String) cbbMaQuyen.getSelectedItem();
				int maNhanVien= Integer.parseInt(txtMaNhanVien.getText());
				if(tkBLL.checkTonTaiMaNhanVien(maNhanVien)!=null) {
					JOptionPane.showMessageDialog(btnAdd, "Mỗi nhân viên chỉ có thể có 1 tài khoản!");
					return;
				}
				String tenDangNhap=txtTenDangNhap.getText();
				if(tkBLL.checkTonTaiTaiKhoanBLL(tenDangNhap)!=null) {
					JOptionPane.showMessageDialog(btnAdd, "Tên tài khoản đã tồn tại!");
					return;
				}
				String makhau=txtMatKhau.getText();
				tkDTo=new TaiKhoanDTO(maQuyen, maNhanVien, tenDangNhap, makhau, 1);
				if(tkBLL.themTaiKhoanBLL(tkDTo)==true) {
					JOptionPane.showMessageDialog(btnAdd, "Thêm thành công!");
					ListTable(tkBLL.getAllTaiKhoan());
				}else {
					JOptionPane.showMessageDialog(btnAdd, "Thêm thất bại!");
					return;
				}
			}
		});
		
		btnUppdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maQuyen=(String) cbbMaQuyen.getSelectedItem();
				int maNhanVien= Integer.parseInt(txtMaNhanVien.getText());
				String makhau="";
				try {
					makhau=txtMatKhau.getText();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				if(txtMaNhanVien.getText().equals("")) {
					JOptionPane.showMessageDialog(btnUppdate, "Mã nhân viên không được để trống!");
					return;
				}
				if(tkBLL.update(maNhanVien,makhau,maQuyen)==true) {
					JOptionPane.showMessageDialog(btnUppdate, "Sửa thành công!");
					ListTable(tkBLL.getAllTaiKhoan());
				}else {
					JOptionPane.showMessageDialog(btnUppdate, "Sửa thất bại!");
					return;
				}
			}
		});
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int maNhanVien= Integer.parseInt(txtMaNhanVien.getText());
				if(txtMaNhanVien.getText().equals("")) {
					JOptionPane.showMessageDialog(btnUppdate, "Mã nhân viên không được để trống!");
					return;
				}
				if(tkBLL.xoaTaiKhoanBLL(maNhanVien)==true) {
					JOptionPane.showMessageDialog(btnRemove, "Xóa thành công!");
					ListTable(tkBLL.getAllTaiKhoan());
				}else {
					JOptionPane.showMessageDialog(btnRemove, "Xóa thất bại!");
					return;
				}
			}
		});
		
		btnKhoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int maNhanVien= Integer.parseInt(txtMaNhanVien.getText());
				if(txtMaNhanVien.getText().equals("")) {
					JOptionPane.showMessageDialog(btnUppdate, "Mã nhân viên không được để trống!");
					return;
				}
				if(tkBLL.khoaTaiKhoan(maNhanVien)==true) {
					JOptionPane.showMessageDialog(btnKhoa, "Khóa tài khoản thành công!");
					ListTable(tkBLL.getAllTaiKhoan());
				}else {
					JOptionPane.showMessageDialog(btnKhoa, "Khóa tài khoản thất bại!");
					return;
				}
			}
		});
		
		btnMoKhoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int maNhanVien= Integer.parseInt(txtMaNhanVien.getText());
				if(txtMaNhanVien.getText().equals("")) {
					JOptionPane.showMessageDialog(btnUppdate, "Mã nhân viên không được để trống!");
					return;
				}
				if(tkBLL.moKhoaTaiKhoan(maNhanVien)==true) {
					JOptionPane.showMessageDialog(btnMoKhoa, "Mở khóa tài khoản thành công!");
					ListTable(tkBLL.getAllTaiKhoan());
				}else {
					JOptionPane.showMessageDialog(btnMoKhoa, "Mở khóa tài khoản thất bại!");
					return;
				}
			}
		});
		
		ListTable(tkBLL.getAllTaiKhoan());
		
	}
	public void ListTable(ArrayList<TaiKhoanDTO> tk) {
		DefaultTableModel df= (DefaultTableModel) tableList.getModel();
		//xoa data trong table
		df.setRowCount(0);
		for (TaiKhoanDTO taiKhoanDTO : tk) {
			Object dataRow[] =new Object[5];
			dataRow[0]=taiKhoanDTO.getMaQuyen();
			dataRow[1]=taiKhoanDTO.getMaNhanVien();
			dataRow[2]=taiKhoanDTO.getTenDangNhap();
			dataRow[3]=taiKhoanDTO.getMatKhau();
			if(taiKhoanDTO.getTinhTrang()==1) {
				dataRow[4]="Hiệu lực";
			}else {
				dataRow[4]="Không hiệu lực";
			}
//			dataRow[4]=taiKhoanDTO.getTinhTrang();
			df.addRow(dataRow);
		}
	}
	public void getEvent() {
		DefaultTableModel df= (DefaultTableModel) tableList.getModel();
		int indexRow=tableList.getSelectedRow();
		txtMaNhanVien.setText(df.getValueAt(indexRow, 1).toString());
		txtTenDangNhap.setText(df.getValueAt(indexRow, 2).toString());
		txtMatKhau.setText(df.getValueAt(indexRow, 3).toString());
	}
}
