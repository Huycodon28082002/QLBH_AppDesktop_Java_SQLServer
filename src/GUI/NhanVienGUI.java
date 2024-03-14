package GUI;


import java.awt.EventQueue;

import javax.swing.JFrame;


import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableModel;

import DTO.NhanVienDTO;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import BLL.NhanVienBLL;

import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;

import javax.swing.border.EmptyBorder;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class NhanVienGUI extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPaneNhanVien;
	private JTable tableListNhanVien;
	private JTextField txtMaNV;
	private JTextField txtTenNV;
	private JTextField txtNgaySinh;
	private JTextField txtSoDT;
	private JButton btnUpdate;
	private JButton btnRemove;
	private JLabel lblNewLabel_2;
	private JTextField txtTimKiem;
	private JLabel lblNewLabel_1_3;
	private JButton btnHome;
	private JLabel lblNewLabel_1_4;
	private NhanVienDTO nvDTO=new NhanVienDTO();
	private NhanVienBLL nvBLL=new NhanVienBLL();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVienGUI frame = new NhanVienGUI();
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
	public NhanVienGUI() {
		setTitle("Quản lý Nhân Viên");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPaneNhanVien = new JScrollPane();
		scrollPaneNhanVien.setBounds(10, 265, 1066, 340);
		contentPane.add(scrollPaneNhanVien);
		
		JLabel lblNewLabel = new JLabel("Mã nhân viên :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(43, 44, 153, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên nhân viên :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(43, 94, 153, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ngày sinh :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(43, 144, 153, 28);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Số điện thoại :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(414, 44, 138, 28);
		contentPane.add(lblNewLabel_1_2);
		
		txtMaNV = new JTextField();
		txtMaNV.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtMaNV.setBounds(206, 44, 162, 27);
		contentPane.add(txtMaNV);
		txtMaNV.setColumns(10);
		
		txtTenNV = new JTextField();
		txtTenNV.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(206, 94, 162, 27);
		contentPane.add(txtTenNV);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(206, 144, 162, 27);
		contentPane.add(txtNgaySinh);
		
		txtSoDT = new JTextField();
		txtSoDT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtSoDT.setColumns(10);
		txtSoDT.setBounds(553, 44, 162, 27);
		contentPane.add(txtSoDT);
		
		JButton btnADD = new JButton("Add");
		btnADD.setBackground(new Color(255, 0, 0));
		
		btnADD.setForeground(new Color(255, 255, 255));
		btnADD.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnADD.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\add.png"));
		btnADD.setBounds(856, 38, 138, 38);
		contentPane.add(btnADD);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setBackground(new Color(255, 0, 0));
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\update.png"));
		
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUpdate.setBounds(856, 88, 138, 38);
		contentPane.add(btnUpdate);
		
		btnRemove = new JButton("Remove");
		
		btnRemove.setBackground(new Color(255, 0, 0));
		btnRemove.setForeground(new Color(255, 255, 255));
		btnRemove.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\delete.png"));
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRemove.setBounds(856, 138, 138, 38);
		contentPane.add(btnRemove);
		
		lblNewLabel_2 = new JLabel("Tìm kiếm :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(750, 193, 119, 28);
		contentPane.add(lblNewLabel_2);
		
		txtTimKiem = new JTextField();
		txtTimKiem.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				String tenNhanVien=txtTimKiem.getText();
				ListTable(nvBLL.SearchThongTinDAL(tenNhanVien));
			}
		});
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTimKiem.setColumns(10);
		txtTimKiem.setBounds(856, 193, 156, 28);
		contentPane.add(txtTimKiem);
		
		lblNewLabel_1_3 = new JLabel("(theo tên nhân viên)");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(727, 214, 162, 28);
		contentPane.add(lblNewLabel_1_3);
		tableListNhanVien=new JTable();
		tableListNhanVien.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				getEventKhoHang();
			}
		});
		tableListNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getEventKhoHang();
			}
		});
		
		
		tableListNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableListNhanVien.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Mã Nhân Viên","Tên Nhân Viên","Ngày sinh","Số điện thoại","Chức vụ"					
				}
			));
		scrollPaneNhanVien.setViewportView(tableListNhanVien);
		
		btnHome = new JButton("Home");
		btnHome.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\home.png"));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrangChuGUI tc=new TrangChuGUI();
				dispose();
				tc.setVisible(true);
			}
		});
		btnHome.setForeground(Color.WHITE);
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnHome.setBackground(Color.RED);
		btnHome.setBounds(457, 615, 138, 38);
		contentPane.add(btnHome);
		
		lblNewLabel_1_4 = new JLabel("(yyyy/MM/dd)");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_4.setBounds(206, 167, 162, 28);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Chức vụ :");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_5.setBounds(414, 94, 153, 28);
		contentPane.add(lblNewLabel_1_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setBackground(new Color(192, 192, 192));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Quản trị", "Quản lý", "Nhân viên"}));
		comboBox.setBounds(553, 98, 162, 27);
		contentPane.add(comboBox);
		
		btnADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int maNV=Integer.parseInt(txtMaNV.getText());
				String tenNV=txtTenNV.getText();
				java.sql.Date ngaySinh=null;
				String soDT=txtSoDT.getText();
				//int tinhTrang=Integer.parseInt(txtTinhTrang.getText());
				String phepToan=(String) comboBox.getSelectedItem();
				try {
					DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date date=formatter.parse(txtNgaySinh.getText());
					long ngaysinh =date.getTime();
					ngaySinh= new java.sql.Date(ngaysinh);
				}
				catch (Exception e1) {
					// TODO: handle exception
				}
				nvDTO=new NhanVienDTO(maNV,tenNV,ngaySinh,soDT,phepToan);
				if(nvBLL.Insert(nvDTO)==true) {
					JOptionPane.showMessageDialog(btnADD, "Thêm thành công!");
					ListTable(nvBLL.ListThongTinDAL());
				}else {
					JOptionPane.showMessageDialog(btnADD, "Thêm thất bại!");
					return;
				}
			}
		});
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int maNV = Integer.parseInt(txtMaNV.getText());
				String tenNV=txtTenNV.getText();
				java.sql.Date ngaySinh=null;
				String soDT=txtSoDT.getText();
				//int tinhTrang=Integer.parseInt(txtTinhTrang.getText());
				String phepToan=(String) comboBox.getSelectedItem();
				try {
					DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date date=formatter.parse(txtNgaySinh.getText());
					long ngaysinh =date.getTime();
					ngaySinh= new java.sql.Date(ngaysinh);
				}
				catch (Exception e1) {
					// TODO: handle exception
				}
				nvDTO=new NhanVienDTO(maNV,tenNV,ngaySinh,soDT,phepToan);
				if(nvBLL.Update(nvDTO)==true) {
					JOptionPane.showMessageDialog(btnADD, "Sửa thành công!");
					ListTable(nvBLL.ListThongTinDAL());
				}else {
					JOptionPane.showMessageDialog(btnADD, "Sửa thất bại!");
					return;
				}
			}
		});
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int maNV=Integer.parseInt(txtMaNV.getText());
				if(nvBLL.Remove(maNV)==true) {
					JOptionPane.showMessageDialog(btnADD, "Xóa thành công!");
					ListTable(nvBLL.ListThongTinDAL());
				}else {
					JOptionPane.showMessageDialog(btnADD, "Xóa thất bại!");
					return;
				}
			}
		});
		
		
		ListTable(nvBLL.ListThongTinDAL());
	}
	public void ListTable(ArrayList<NhanVienDTO> kh) {
		DefaultTableModel df= (DefaultTableModel) tableListNhanVien.getModel();
		//xoa data trong table
		df.setRowCount(0);
		for (NhanVienDTO NhanVienDTO : kh) {
			Object dataRow[] =new Object[6];
			dataRow[0]=NhanVienDTO.getMaNhanVien();
			dataRow[1]=NhanVienDTO.getTenNhanVien().trim();
			dataRow[2]=NhanVienDTO.getNgaySinh();
			dataRow[3]=NhanVienDTO.getSoDienThoai().trim();
			dataRow[4]=NhanVienDTO.getChucVu().trim();
			//dataRow[5]=NhanVienDTO.getTinhTrang();
			df.addRow(dataRow);
		}
	}
	public void getEventKhoHang() {
		DefaultTableModel df= (DefaultTableModel) tableListNhanVien.getModel();
		int indexRow=tableListNhanVien.getSelectedRow();
		txtMaNV.setText(df.getValueAt(indexRow, 0).toString());
		txtTenNV.setText(df.getValueAt(indexRow, 1).toString());
		txtNgaySinh.setText(df.getValueAt(indexRow, 2).toString());
		txtSoDT.setText(df.getValueAt(indexRow, 3).toString());
		//txtTinhTrang.setText(df.getValueAt(indexRow, 5).toString());
	}
}
	
