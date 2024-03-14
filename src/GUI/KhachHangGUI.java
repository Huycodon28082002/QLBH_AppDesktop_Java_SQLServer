package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BLL.KhachHangBLL;
import DTO.KhachHangDTO;
import DTO.KhuyenMaiDTO;
import DTO.NhapHangDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

public class KhachHangGUI extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPaneKhachHang;
	private JTable tableListKhachHang;
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtNgaySinh;
	private JTextField txtSoDT;
	private JButton btnUpdate;
	private JButton btnRemove;
	private JLabel lblNewLabel_2;
	private JTextField txtTimKiem;
	private JLabel lblNewLabel_1_3;
	private JButton btnHome;
	private JLabel lblNewLabel_1_4;
	private KhachHangDTO khDTO=new KhachHangDTO();
	private KhachHangBLL khBLL=new KhachHangBLL();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KhachHangGUI frame = new KhachHangGUI();
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
	public KhachHangGUI() {
		setTitle("Quản lý khách hàng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPaneKhachHang = new JScrollPane();
		scrollPaneKhachHang.setBounds(10, 265, 1066, 340);
		contentPane.add(scrollPaneKhachHang);
		
		JLabel lblNewLabel = new JLabel("Mã khách hàng :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(137, 44, 153, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên khách hàng :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(137, 94, 153, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ngày sinh :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(137, 144, 153, 28);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Số điện thoại :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(137, 194, 153, 28);
		contentPane.add(lblNewLabel_1_2);
		
		txtMaKH = new JTextField();
		txtMaKH.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtMaKH.setBounds(300, 44, 162, 27);
		contentPane.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		txtTenKH = new JTextField();
		txtTenKH.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(300, 94, 162, 27);
		contentPane.add(txtTenKH);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(300, 144, 162, 27);
		contentPane.add(txtNgaySinh);
		
		txtSoDT = new JTextField();
		txtSoDT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtSoDT.setColumns(10);
		txtSoDT.setBounds(300, 194, 162, 27);
		contentPane.add(txtSoDT);
		
		JButton btnADD = new JButton("Add");
		btnADD.setBackground(new Color(255, 0, 0));
		
		btnADD.setForeground(new Color(255, 255, 255));
		btnADD.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnADD.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\add.png"));
		btnADD.setBounds(745, 39, 138, 38);
		contentPane.add(btnADD);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setBackground(new Color(255, 0, 0));
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\update.png"));
		
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUpdate.setBounds(745, 89, 138, 38);
		contentPane.add(btnUpdate);
		
		btnRemove = new JButton("Remove");
		
		btnRemove.setBackground(new Color(255, 0, 0));
		btnRemove.setForeground(new Color(255, 255, 255));
		btnRemove.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\delete.png"));
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRemove.setBounds(745, 139, 138, 38);
		contentPane.add(btnRemove);
		
		lblNewLabel_2 = new JLabel("Tìm kiếm :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(639, 194, 119, 28);
		contentPane.add(lblNewLabel_2);
		
		txtTimKiem = new JTextField();
		txtTimKiem.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				String tenKhachHang=txtTimKiem.getText();
				ListTable(khBLL.SearchThongTinDAL(tenKhachHang));
			}
		});
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTimKiem.setColumns(10);
		txtTimKiem.setBounds(745, 194, 156, 28);
		contentPane.add(txtTimKiem);
		
		lblNewLabel_1_3 = new JLabel("(theo tên khách hàng)");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(616, 215, 162, 28);
		contentPane.add(lblNewLabel_1_3);
		tableListKhachHang=new JTable();
		tableListKhachHang.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				getEventKhoHang();
			}
		});
		tableListKhachHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getEventKhoHang();
			}
		});
		
		
		tableListKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableListKhachHang.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Mã khách hàng","Tên khách hàng","Ngày sinh","Số điện thoại","Tổng chi tiêu"
				}
			));
		scrollPaneKhachHang.setViewportView(tableListKhachHang);
		
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
		
		lblNewLabel_1_4 = new JLabel("(yyyy-MM-dd)");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_4.setBounds(300, 167, 162, 28);
		contentPane.add(lblNewLabel_1_4);
		
		btnADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//int maKH=Integer.parseInt(txtMaKH.getText());
				String tenKH=txtTenKH.getText();
				java.sql.Date ngaySinh=null;
				String soDT=txtSoDT.getText();
				try {
					DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date date=formatter.parse(txtNgaySinh.getText());
					long ngaysinh =date.getTime();
					ngaySinh= new java.sql.Date(ngaysinh);
				}
				catch (Exception e1) {
					// TODO: handle exception
				}
				khDTO=new KhachHangDTO( tenKH, ngaySinh, soDT);
				if(khBLL.Insert(khDTO)==true) {
					JOptionPane.showMessageDialog(btnADD, "Thêm thành công!");
					ListTable(khBLL.ListThongTinDAL());
				}else {
					JOptionPane.showMessageDialog(btnADD, "Thêm thất bại!");
					return;
				}
			}
		});
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int maKH=Integer.parseInt(txtMaKH.getText());
				String tenKH=txtTenKH.getText();
				java.sql.Date ngaySinh=null;
				String soDT=txtSoDT.getText();
				try {
					DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date date=formatter.parse(txtNgaySinh.getText());
					long ngaysinh =date.getTime();
					ngaySinh= new java.sql.Date(ngaysinh);
				}
				catch (Exception e1) {
					// TODO: handle exception
				}
				khDTO=new KhachHangDTO(maKH,tenKH, ngaySinh, soDT);
				if(khBLL.Update(khDTO)==true) {
					JOptionPane.showMessageDialog(btnADD, "Sửa thành công!");
					ListTable(khBLL.ListThongTinDAL());
				}else {
					JOptionPane.showMessageDialog(btnADD, "Sửa thất bại!");
					return;
				}
			}
		});
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int maKH=Integer.parseInt(txtMaKH.getText());
				if(khBLL.Remove(maKH)==true) {
					JOptionPane.showMessageDialog(btnADD, "Xóa thành công!");
					ListTable(khBLL.ListThongTinDAL());
				}else {
					JOptionPane.showMessageDialog(btnADD, "Xóa thất bại!");
					return;
				}
			}
		});
		
		
		ListTable(khBLL.ListThongTinDAL());
	}
	public void ListTable(ArrayList<KhachHangDTO> kh) {
		DefaultTableModel df= (DefaultTableModel) tableListKhachHang.getModel();
		//xoa data trong table
		df.setRowCount(0);
		for (KhachHangDTO khachHangDTO : kh) {
			Object dataRow[] =new Object[4];
			dataRow[0]=khachHangDTO.getMaKhachHang();
			dataRow[1]=khachHangDTO.getTenKhachHang().trim();
			dataRow[2]=khachHangDTO.getNgaySinh();
			dataRow[3]=khachHangDTO.getSoDienThoai().trim();
			df.addRow(dataRow);
		}
	}
	public void getEventKhoHang() {
		DefaultTableModel df= (DefaultTableModel) tableListKhachHang.getModel();
		int indexRow=tableListKhachHang.getSelectedRow();
		txtMaKH.setText(df.getValueAt(indexRow, 0).toString());
		txtTenKH.setText(df.getValueAt(indexRow, 1).toString());
		txtNgaySinh.setText(df.getValueAt(indexRow, 2).toString());
		txtSoDT.setText(df.getValueAt(indexRow, 3).toString());
	}
}
