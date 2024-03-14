package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BLL.LoaiSanPhamBLL;
import BLL.SanPhamBLL;
import DTO.LoaiSanPhamDTO;
import DTO.SanPhamDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileSystemView;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

@SuppressWarnings("serial")
public class SanPhamGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtMaSP_SP;
	private JTextField textField_1;
	private JTextField txtTenSP_SP;
	private JTextField textField_2;
	private JTextField txtDonGia_SP;
	private JTextField txtSoLuong_SP;
	private JTextField txtMaSPTim_SP;
	private JTextField txtTenLoai_Loai;
	private JTextField txtMaLoai_Loai;
	private JTable tableListSanPham_SP;
	private JTextField txtMaLoaiTim_Loai;
	private JTable tableListLoaiSanPham;
	private JTextField txtHinhAnh_SP;
	private JFileChooser fchHinhAnh;
	private JLabel lblHinhAnhht_SP;
	private JComboBox comboBox;
	private SanPhamDTO spDTO = new SanPhamDTO();
	private SanPhamBLL spBLL = new SanPhamBLL();
	private LoaiSanPhamDTO lspDTO = new LoaiSanPhamDTO();
	private LoaiSanPhamBLL lspBLL = new LoaiSanPhamBLL();

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SanPhamGUI frame = new SanPhamGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SanPhamGUI() {
		setTitle("Quản lý sản phẩm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 700);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelCTSP = new JPanel();
		panelCTSP.setBackground(new Color(192, 192, 192));
		panelCTSP.setLayout(null);
		panelCTSP.setBorder(new TitledBorder(null, "Th\u00F4ng Tin S\u1EA3n Ph\u1EA9m", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(59, 59, 59)));
		panelCTSP.setBounds(6, 6, 650, 584);
		contentPane.add(panelCTSP);

		JLabel lblMaSP_SP = new JLabel("Mã sản phẩm :");
		lblMaSP_SP.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblMaSP_SP.setBounds(28, 25, 132, 25);
		panelCTSP.add(lblMaSP_SP);

		JLabel lblTenSP_SP = new JLabel("Tên sản phẩm :");
		lblTenSP_SP.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTenSP_SP.setBounds(28, 60, 132, 25);
		panelCTSP.add(lblTenSP_SP);

		JLabel lblDonGia_SP = new JLabel("Đơn giá:");
		lblDonGia_SP.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblDonGia_SP.setBounds(360, 25, 101, 25);
		panelCTSP.add(lblDonGia_SP);

		JLabel lblSoLuong_SP = new JLabel("Số lượng:");
		lblSoLuong_SP.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblSoLuong_SP.setBounds(360, 60, 101, 25);
		panelCTSP.add(lblSoLuong_SP);

		JLabel lblMaSPTim_SP = new JLabel("Tìm kiếm:");
		lblMaSPTim_SP.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblMaSPTim_SP.setBounds(360, 200, 101, 25);
		panelCTSP.add(lblMaSPTim_SP);

		txtMaSP_SP = new JTextField();
		txtMaSP_SP.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtMaSP_SP.setColumns(10);
		txtMaSP_SP.setBounds(165, 25, 150, 25);
		panelCTSP.add(txtMaSP_SP);

		txtTenSP_SP = new JTextField();
		txtTenSP_SP.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtTenSP_SP.setColumns(10);
		txtTenSP_SP.setBounds(165, 60, 150, 25);
		panelCTSP.add(txtTenSP_SP);

		txtDonGia_SP = new JTextField();
		txtDonGia_SP.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtDonGia_SP.setColumns(10);
		txtDonGia_SP.setBounds(470, 25, 150, 25);
		panelCTSP.add(txtDonGia_SP);

		txtSoLuong_SP = new JTextField();
		txtSoLuong_SP.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtSoLuong_SP.setColumns(10);
		txtSoLuong_SP.setBounds(470, 60, 150, 25);
		panelCTSP.add(txtSoLuong_SP);

		JLabel lblLoai_SP = new JLabel("Mã loại SP :");
		lblLoai_SP.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblLoai_SP.setBounds(360, 97, 101, 25);
		panelCTSP.add(lblLoai_SP);
//
//		JComboBox comboBoxLoai_SP = new JComboBox();
//		comboBoxLoai_SP.setFont(new Font("Times New Roman", Font.PLAIN, 18));
//		comboBoxLoai_SP.setBounds(470, 130, 150, 29);
//		panelCTSP.add(comboBoxLoai_SP);

		txtMaSPTim_SP = new JTextField();
		txtMaSPTim_SP.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtMaSPTim_SP.setColumns(10);
		txtMaSPTim_SP.setBounds(470, 200, 150, 25);
		panelCTSP.add(txtMaSPTim_SP);
		txtMaSPTim_SP.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				//JOptionPane.showMessageDialog(null, txtMaSPTim_SP.getText());
				ListTableSanPham(spBLL.timkiem(txtMaSPTim_SP.getText()));
			}
		});

		JButton btnThem_SP = new JButton("Thêm");
		btnThem_SP.setForeground(new Color(255, 255, 255));
		btnThem_SP.setBackground(new Color(255, 0, 0));
		btnThem_SP.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\add.png"));
		btnThem_SP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int maSanPham = Integer.parseInt(txtMaSP_SP.getText());
				String maQuyen=(String) comboBox.getSelectedItem();
				int maLoai = Integer.parseInt(maQuyen);
				String tenSanPham = txtTenSP_SP.getText();
				Float donGia = Float.parseFloat(txtDonGia_SP.getText());
				int soLuong = Integer.parseInt(txtSoLuong_SP.getText());
				String duongDan = txtHinhAnh_SP.getText();
				spDTO = new SanPhamDTO(maSanPham, maLoai, tenSanPham, donGia, soLuong, duongDan, 1);
				if (spBLL.InsertThongTinSanPhamDAL(spDTO)) {
					JOptionPane.showMessageDialog(btnThem_SP, "Thêm thành công");
					ListTableSanPham(spBLL.layToanBoSanPham());
					return;
				} else {
					JOptionPane.showMessageDialog(btnThem_SP, "Thêm thất bại");
					return;
				}

			}
		});
		btnThem_SP.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnThem_SP.setBounds(40, 513, 120, 55);
		panelCTSP.add(btnThem_SP);

		JButton btnSua_SP = new JButton("Sửa");
		btnSua_SP.setForeground(new Color(255, 255, 255));
		btnSua_SP.setBackground(new Color(255, 0, 0));
		btnSua_SP.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\update.png"));
		btnSua_SP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int maSanPham = Integer.parseInt(txtMaSP_SP.getText());
				String maQuyen=(String) comboBox.getSelectedItem();
				int maLoai = Integer.parseInt(maQuyen);
				String tenSanPham = txtTenSP_SP.getText();
				Float donGia = Float.parseFloat(txtDonGia_SP.getText());
				int soLuong = Integer.parseInt(txtSoLuong_SP.getText());
				String duongDan = txtHinhAnh_SP.getText();
				spDTO = new SanPhamDTO(maSanPham, maLoai, tenSanPham, donGia, soLuong, duongDan);
				if (spBLL.UpdateThongTinSanPhamDAL(spDTO)) {
					JOptionPane.showMessageDialog(btnSua_SP, "Sửa thành công");
					ListTableSanPham(spBLL.layToanBoSanPham());
					return;
				} else {
					JOptionPane.showMessageDialog(btnSua_SP, "Sửa thất bại");
					return;
				}
			}
		});
		btnSua_SP.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnSua_SP.setBounds(194, 513, 110, 55);
		panelCTSP.add(btnSua_SP);

		JButton btnXoa_SP = new JButton("Xóa");
		btnXoa_SP.setForeground(new Color(255, 255, 255));
		btnXoa_SP.setBackground(new Color(255, 0, 0));
		btnXoa_SP.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\delete.png"));
		btnXoa_SP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int maSanPham = Integer.parseInt(txtMaSP_SP.getText());
				if (spBLL.RemoveThongTinSanPhamDAL(maSanPham)) {
					JOptionPane.showMessageDialog(btnSua_SP, "Xóa thành công");
					ListTableSanPham(spBLL.layToanBoSanPham());
					return;
				} else {
					JOptionPane.showMessageDialog(btnSua_SP, "Xóa thất bại");
					return;
				}
			}
		});
		btnXoa_SP.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnXoa_SP.setBounds(333, 513, 110, 55);
		panelCTSP.add(btnXoa_SP);

		JButton btnReset_SP = new JButton("Reset");
		btnReset_SP.setForeground(new Color(255, 255, 255));
		btnReset_SP.setBackground(new Color(255, 0, 0));
		btnReset_SP.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\reset.png"));
		btnReset_SP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMaSP_SP.setText("");
				txtTenSP_SP.setText("");
				txtDonGia_SP.setText("");
				txtSoLuong_SP.setText("");
				txtHinhAnh_SP.setText("");
				ListTableSanPham(spBLL.layToanBoSanPham());
			}
		});
		btnReset_SP.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnReset_SP.setBounds(470, 513, 120, 55);
		panelCTSP.add(btnReset_SP);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 290, 620, 200);
		panelCTSP.add(scrollPane);

		tableListSanPham_SP = new JTable();
		tableListSanPham_SP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getEventDSSanPham();
				String hinhanh = txtHinhAnh_SP.getText();
				try {
					ImageIcon img = new ImageIcon(hinhanh);
					lblHinhAnhht_SP.setIcon(img);
				} catch (Exception ex) {
					lblHinhAnhht_SP.setText(hinhanh);
				}
			}
		});
		tableListSanPham_SP.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				getEventDSSanPham();
			}
		});
		tableListSanPham_SP.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 SP", "M\u00E3 lo\u1EA1i", "T\u00EAn SP", "\u0110\u01A1n Gi\u00E1",
						"S\u1ED1 L\u01B0\u1EE3ng ", "\u0110\u01B0\u1EDDng d\u1EABn"}));
		scrollPane.setViewportView(tableListSanPham_SP);

		JLabel lblHinhAnh_SP = new JLabel("Hình ảnh :");
		lblHinhAnh_SP.setBounds(28, 95, 132, 25);
		panelCTSP.add(lblHinhAnh_SP);
		lblHinhAnh_SP.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		lblHinhAnhht_SP = new JLabel("");
		
		lblHinhAnhht_SP.setBounds(165, 130, 150, 150);
		lblHinhAnhht_SP.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		panelCTSP.add(lblHinhAnhht_SP);

		JButton btnTaiAnh_SP = new JButton("Tải ảnh");
		btnTaiAnh_SP.setForeground(new Color(255, 255, 255));
		btnTaiAnh_SP.setBackground(new Color(255, 0, 0));
		btnTaiAnh_SP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fchHinhAnh = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				fchHinhAnh.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				int rv = fchHinhAnh.showSaveDialog(null);
				if (rv == JFileChooser.APPROVE_OPTION) {
					txtHinhAnh_SP.setText(fchHinhAnh.getSelectedFile().getAbsolutePath());
					lblHinhAnhht_SP.setIcon(new ImageIcon(fchHinhAnh.getSelectedFile().getAbsolutePath()));
				}
			}
		});
		btnTaiAnh_SP.setBounds(28, 200, 105, 35);
		panelCTSP.add(btnTaiAnh_SP);
		btnTaiAnh_SP.setFont(new Font("Times New Roman", Font.BOLD, 18));

		txtHinhAnh_SP = new JTextField();
		txtHinhAnh_SP.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtHinhAnh_SP.setColumns(10);
		txtHinhAnh_SP.setBounds(165, 95, 150, 25);
		panelCTSP.add(txtHinhAnh_SP);

		
		
		JLabel lblMaSPTim_SP_1 = new JLabel("(Theo tên SP)");
		lblMaSPTim_SP_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMaSPTim_SP_1.setBounds(360, 224, 101, 25);
		panelCTSP.add(lblMaSPTim_SP_1);
		
		comboBox = new JComboBox();
		comboBox.setBackground(new Color(192, 192, 192));
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		comboBox.setBounds(470, 97, 150, 26);
		panelCTSP.add(comboBox);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(192, 192, 192));
		panel_2.setBorder(new TitledBorder(null, "Th\u00F4ng Tin Lo\u1EA1i S\u1EA3n Ph\u1EA9m", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_2.setBounds(662, 6, 413, 584);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblMaLoai_Loai = new JLabel("Mã loại :");
		lblMaLoai_Loai.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblMaLoai_Loai.setBounds(49, 35, 97, 25);
		panel_2.add(lblMaLoai_Loai);

		JLabel lblTenLoai_Loai = new JLabel("Tên loại :");
		lblTenLoai_Loai.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTenLoai_Loai.setBounds(49, 70, 97, 25);
		panel_2.add(lblTenLoai_Loai);

		txtTenLoai_Loai = new JTextField();
		txtTenLoai_Loai.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtTenLoai_Loai.setColumns(10);
		txtTenLoai_Loai.setBounds(160, 70, 180, 25);
		panel_2.add(txtTenLoai_Loai);

		txtMaLoai_Loai = new JTextField();
		txtMaLoai_Loai.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtMaLoai_Loai.setColumns(10);
		txtMaLoai_Loai.setBounds(160, 35, 180, 25);
		panel_2.add(txtMaLoai_Loai);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(17, 182, 378, 273);
		panel_2.add(scrollPane_1);

		tableListLoaiSanPham = new JTable();
		tableListLoaiSanPham.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getEventDSLoaiSanPham();
			}
		});
		tableListLoaiSanPham.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				getEventDSLoaiSanPham();
			}
		});
		tableListLoaiSanPham.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 lo\u1EA1i", "T\u00EAn lo\u1EA1i"}));
		scrollPane_1.setViewportView(tableListLoaiSanPham);

		JLabel lblMaLoaiTim_Loai = new JLabel("Tìm kiếm :");
		lblMaLoaiTim_Loai.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblMaLoaiTim_Loai.setBounds(49, 118, 97, 25);
		panel_2.add(lblMaLoaiTim_Loai);

		txtMaLoaiTim_Loai = new JTextField();
		txtMaLoaiTim_Loai.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				ListTableLoaiSanPham(lspBLL.timkiem(txtMaLoaiTim_Loai.getText()));
			}
		});
		txtMaLoaiTim_Loai.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtMaLoaiTim_Loai.setColumns(10);
		txtMaLoaiTim_Loai.setBounds(160, 118, 180, 25);
		panel_2.add(txtMaLoaiTim_Loai);

		JButton btnThem_Loai = new JButton("Thêm");
		btnThem_Loai.setForeground(new Color(255, 255, 255));
		btnThem_Loai.setBackground(new Color(255, 0, 0));
		btnThem_Loai.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\add.png"));
		btnThem_Loai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//int maLoai = Integer.parseInt(txtMaLoai_Loai.getText());
				String tenLoai = txtTenLoai_Loai.getText();
				lspDTO = new LoaiSanPhamDTO( tenLoai, 1);
				if (lspBLL.InsertThongTinLoaiSanPhamDAL(lspDTO)) {
					JOptionPane.showMessageDialog(btnThem_Loai, "Thêm thành công");
					ListTableLoaiSanPham(lspBLL.layToanBoLoaiSanPham());
					comboBox.removeAllItems();
					spBLL.ListComboboxDAL(comboBox);
					return;
				} else {
					JOptionPane.showMessageDialog(btnThem_Loai, "Thêm thất bại");
					return;
				}
			}
		});
		btnThem_Loai.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnThem_Loai.setBounds(80, 455, 120, 52);
		panel_2.add(btnThem_Loai);

		JButton btnSua_Loai = new JButton("Sửa");
		btnSua_Loai.setForeground(new Color(255, 255, 255));
		btnSua_Loai.setBackground(new Color(255, 0, 0));
		btnSua_Loai.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\update.png"));
		btnSua_Loai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int maLoai = Integer.parseInt(txtMaLoai_Loai.getText());
				String tenLoai = txtTenLoai_Loai.getText();
				lspDTO = new LoaiSanPhamDTO(maLoai, tenLoai);
				if (lspBLL.UpdateThongTinLoaiSanPhamDAL(lspDTO)) {
					JOptionPane.showMessageDialog(btnSua_Loai, "Sửa thành công");
					ListTableLoaiSanPham(lspBLL.layToanBoLoaiSanPham());
					return;
				} else {
					JOptionPane.showMessageDialog(btnSua_Loai, "Sửa thất bại");
					return;
				}
			}
		});
		btnSua_Loai.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnSua_Loai.setBounds(230, 455, 120, 52);
		panel_2.add(btnSua_Loai);

		JButton btnXoa_Loai = new JButton("Xóa");
		btnXoa_Loai.setForeground(new Color(255, 255, 255));
		btnXoa_Loai.setBackground(new Color(255, 0, 0));
		btnXoa_Loai.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\delete.png"));
		btnXoa_Loai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int maLoai = Integer.parseInt(txtMaLoai_Loai.getText());
				if (lspBLL.RemoveThongTinLoaiSanPhamDAL(maLoai)) {
					JOptionPane.showMessageDialog(btnXoa_Loai, "Xóa thành công");
					ListTableLoaiSanPham(lspBLL.layToanBoLoaiSanPham());
					comboBox.removeAllItems();
					spBLL.ListComboboxDAL(comboBox);
					return;
				} else {
					JOptionPane.showMessageDialog(btnXoa_Loai, "Xóa thất bại");
					return;
				}
			}
		});
		btnXoa_Loai.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnXoa_Loai.setBounds(80, 519, 120, 48);
		panel_2.add(btnXoa_Loai);

		JButton btnReset_Loai = new JButton("Reset");
		btnReset_Loai.setForeground(new Color(255, 255, 255));
		btnReset_Loai.setBackground(new Color(255, 0, 0));
		btnReset_Loai.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\reset.png"));
		btnReset_Loai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMaLoai_Loai.setText("");
				txtTenLoai_Loai.setText("");
				ListTableLoaiSanPham(lspBLL.layToanBoLoaiSanPham());
			}
		});
		btnReset_Loai.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnReset_Loai.setBounds(230, 519, 120, 48);
		panel_2.add(btnReset_Loai);
		
		JLabel lblMaSPTim_SP_1_1 = new JLabel("(Theo tên loại SP)");
		lblMaSPTim_SP_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMaSPTim_SP_1_1.setBounds(33, 135, 120, 25);
		panel_2.add(lblMaSPTim_SP_1_1);

		JButton btnNewButton = new JButton("Trang chủ");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrangChuGUI tc=new TrangChuGUI();
				dispose();
				tc.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\home.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(466, 601, 171, 56);
		contentPane.add(btnNewButton);

		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(126, 82, 264, 29);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(126, 147, 264, 29);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(126, 205, 264, 29);

		ListTableSanPham(spBLL.layToanBoSanPham());
		ListTableLoaiSanPham(lspBLL.layToanBoLoaiSanPham());
		spBLL.ListComboboxDAL(comboBox);
	}

	public void ListTableSanPham(ArrayList<SanPhamDTO> sp) {
		DefaultTableModel df = (DefaultTableModel) tableListSanPham_SP.getModel();
		df.setRowCount(0);
		for (SanPhamDTO sanPhamDTO : sp) {
			Object dataRow[] = new Object[6];
			dataRow[0] = sanPhamDTO.getMaSanPham();
			dataRow[1] = sanPhamDTO.getMaLoai();
			dataRow[2] = sanPhamDTO.getTenSanPham().trim();
			dataRow[3] = sanPhamDTO.getDonGia();
			dataRow[4] = sanPhamDTO.getSoLuong();
			dataRow[5] = sanPhamDTO.getDuongDan().trim();
//			dataRow[6] = sanPhamDTO.getTinhTrang();
			df.addRow(dataRow);
		}
	}

	public void getEventDSSanPham() {
		DefaultTableModel df = (DefaultTableModel) tableListSanPham_SP.getModel();
		int indexRow = tableListSanPham_SP.getSelectedRow();
		txtMaSP_SP.setText(df.getValueAt(indexRow, 0).toString());
		txtTenSP_SP.setText(df.getValueAt(indexRow, 2).toString());
		txtDonGia_SP.setText(df.getValueAt(indexRow, 3).toString());
		txtSoLuong_SP.setText(df.getValueAt(indexRow, 4).toString());
		txtHinhAnh_SP.setText(df.getValueAt(indexRow, 5).toString());
		//lblHinhAnhht_SP
	}

	public void ListTableLoaiSanPham(ArrayList<LoaiSanPhamDTO> lsp) {
		DefaultTableModel df = (DefaultTableModel) tableListLoaiSanPham.getModel();
		df.setRowCount(0);
		for (LoaiSanPhamDTO loaiSanPhamDTO : lsp) {
			Object dataRow[] = new Object[7];
			dataRow[0] = loaiSanPhamDTO.getMaLoai();
			dataRow[1] = loaiSanPhamDTO.getTenLoai().trim();
			df.addRow(dataRow);
		}
	}

	public void getEventDSLoaiSanPham() {
		DefaultTableModel df = (DefaultTableModel) tableListLoaiSanPham.getModel();
		int indexRow = tableListLoaiSanPham.getSelectedRow();
		txtMaLoai_Loai.setText(df.getValueAt(indexRow, 0).toString());
		txtTenLoai_Loai.setText(df.getValueAt(indexRow, 1).toString());
	}
}
