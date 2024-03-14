package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;

import BLL.ChiTietKhuyenMaiBLL;
import BLL.KhuyenMaiBLL;
import DTO.ChiTietKhuyenMaiDTO;
import DTO.KhuyenMaiDTO;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KhuyenMaiGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaKM_KhuyenMai;
	private JTextField txtTenKM;
	private JTextField txtMaKM_ChiTietKhuyenMai;
	private JTextField txtMaSP;
	private JTextField txtGiaTriGiam;
	private JScrollPane scrollPaneKhuyenMai;
	private JTable tableListKhuyenMai;
	private JScrollPane scrollPaneCTKhuyenMai;
	private JTable tableListCTKhuyenMai;
	private KhuyenMaiDTO kmDTO=new KhuyenMaiDTO();
	private KhuyenMaiBLL kmBLL=new KhuyenMaiBLL();
	private ChiTietKhuyenMaiDTO ctkmDTO=new ChiTietKhuyenMaiDTO();
	private ChiTietKhuyenMaiBLL ctkmBLL=new ChiTietKhuyenMaiBLL();
	private JDateChooser dateChooserNgayBatDau;
	private JComboBox cbbDonViGiam;
	static int index=-1;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KhuyenMaiGUI frame = new KhuyenMaiGUI();
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
	public KhuyenMaiGUI() {
		setTitle("Quản lý khuyến mãi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelKM = new JPanel();
		panelKM.setBackground(new Color(192, 192, 192));
		panelKM.setLayout(null);
		panelKM.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin khuy\u1EBFn m\u00E3i", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelKM.setBounds(10, 10, 528, 254);
		contentPane.add(panelKM);
		
		JLabel lblNewLabel_1_6_1 = new JLabel("Mã khuyến mãi :");
		lblNewLabel_1_6_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_6_1.setBounds(59, 22, 154, 25);
		panelKM.add(lblNewLabel_1_6_1);
		
		JLabel lblNewLabel_1_6_1_1 = new JLabel("Tên khuyến mãi :");
		lblNewLabel_1_6_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_6_1_1.setBounds(59, 80, 154, 25);
		panelKM.add(lblNewLabel_1_6_1_1);
		
		JLabel lblNewLabel_1_6_1_2 = new JLabel("Ngày bắt đầu :");
		lblNewLabel_1_6_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_6_1_2.setBounds(339, 22, 136, 25);
		panelKM.add(lblNewLabel_1_6_1_2);
		
		JLabel lblNewLabel_1_6_1_2_1 = new JLabel("Ngày kết thúc :");
		lblNewLabel_1_6_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_6_1_2_1.setBounds(339, 80, 136, 25);
		panelKM.add(lblNewLabel_1_6_1_2_1);
		
		txtMaKM_KhuyenMai = new JTextField();
		txtMaKM_KhuyenMai.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtMaKM_KhuyenMai.setColumns(10);
		txtMaKM_KhuyenMai.setBounds(59, 45, 170, 25);
		panelKM.add(txtMaKM_KhuyenMai);
		
		txtTenKM = new JTextField();
		txtTenKM.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTenKM.setColumns(10);
		txtTenKM.setBounds(59, 103, 170, 25);
		panelKM.add(txtTenKM);
		
		dateChooserNgayBatDau = new JDateChooser();
		dateChooserNgayBatDau.setDateFormatString("yyyy-MM-dd");
		dateChooserNgayBatDau.setBounds(339, 45, 170, 25);
		panelKM.add(dateChooserNgayBatDau);
		
		JDateChooser dateChooserNgayKetTHuc = new JDateChooser();
		dateChooserNgayKetTHuc.setDateFormatString("yyyy-MM-dd");
		dateChooserNgayKetTHuc.setBounds(339, 103, 170, 25);
		panelKM.add(dateChooserNgayKetTHuc);
		
		JButton btnAddKM = new JButton("Add");
		btnAddKM.setForeground(new Color(255, 255, 255));
		btnAddKM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//int maKhuyenMai=Integer.parseInt(txtMaKM_KhuyenMai.getText());
				String tenKhuyenMai=txtTenKM.getText();
				SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
			    String dateNgayBatDau = dcn.format(dateChooserNgayBatDau.getDate() );
			    String dateNgayKetTHuc = dcn.format(dateChooserNgayKetTHuc.getDate() );
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				java.sql.Date ngayBatDau=null;
				java.sql.Date ngayKetThuc=null;
				try {
					java.util.Date ngayBatDau1 =  formatter.parse(dateNgayBatDau);
					long ngaysinh =ngayBatDau1.getTime();
					ngayBatDau= new java.sql.Date(ngaysinh);
					
					java.util.Date ngayKetThuc1 =  formatter.parse(dateNgayKetTHuc);
					long ngaysinh1 =ngayKetThuc1.getTime();
					ngayKetThuc= new java.sql.Date(ngaysinh1);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				kmDTO=new KhuyenMaiDTO(-1, tenKhuyenMai, ngayBatDau, ngayKetThuc, 1);
				if(kmBLL.InsertThongTinKhuyenMaiDAL(kmDTO)==true) {
					JOptionPane.showMessageDialog(btnAddKM,"Thêm thành công");
					ListTableKhuyenMai(kmBLL.ListThongTinKhuyenMaiDAL());
					return;	
				}
				else {
					JOptionPane.showMessageDialog(btnAddKM,"Thêm thất bại");
					return;	
				}
				
			}
		});
		btnAddKM.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\add.png"));
		btnAddKM.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAddKM.setBackground(Color.RED);
		btnAddKM.setBounds(59, 171, 111, 44);
		panelKM.add(btnAddKM);
		
		JButton btnUpdateKM = new JButton("Update");
		btnUpdateKM.setForeground(new Color(255, 255, 255));
		btnUpdateKM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int maKhuyenMai=Integer.parseInt(txtMaKM_KhuyenMai.getText());
				String tenKhuyenMai=txtTenKM.getText();
				SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
			    String dateNgayBatDau = dcn.format(dateChooserNgayBatDau.getDate() );
			    String dateNgayKetTHuc = dcn.format(dateChooserNgayKetTHuc.getDate() );
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				java.sql.Date ngayBatDau=null;
				java.sql.Date ngayKetThuc=null;
				try {
					java.util.Date ngayBatDau1 =  formatter.parse(dateNgayBatDau);
					long ngaysinh =ngayBatDau1.getTime();
					ngayBatDau= new java.sql.Date(ngaysinh);
					
					java.util.Date ngayKetThuc1 =  formatter.parse(dateNgayKetTHuc);
					long ngaysinh1 =ngayKetThuc1.getTime();
					ngayKetThuc= new java.sql.Date(ngaysinh1);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				kmDTO=new KhuyenMaiDTO(maKhuyenMai, tenKhuyenMai, ngayBatDau, ngayKetThuc, 1);
				if(kmBLL.UpdateThongTinKhuyenMaiDAL(kmDTO)==true) {
					JOptionPane.showMessageDialog(btnUpdateKM,"Sửa thành công");
					ListTableKhuyenMai(kmBLL.ListThongTinKhuyenMaiDAL());
					return;	
				}
				else {
					JOptionPane.showMessageDialog(btnUpdateKM,"Sửa thất bại");
					return;	
				}
				
			}
		});
		btnUpdateKM.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\update.png"));
		btnUpdateKM.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUpdateKM.setBackground(Color.RED);
		btnUpdateKM.setBounds(204, 171, 136, 44);
		panelKM.add(btnUpdateKM);
		
		JButton btnRemoveKM = new JButton("Remove");
		btnRemoveKM.setForeground(new Color(255, 255, 255));
		btnRemoveKM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int maKhuyenMai=Integer.parseInt(txtMaKM_KhuyenMai.getText());
				if(kmBLL.RemoveThongTinKhuyenMaiDAL(maKhuyenMai)==true) {
					JOptionPane.showMessageDialog(btnRemoveKM,"Xóa thành công");
					ListTableKhuyenMai(kmBLL.ListThongTinKhuyenMaiDAL());
					return;	
				}
				else {
					JOptionPane.showMessageDialog(btnRemoveKM,"Xóa thất bại");
					return;	
				}
			}
		});
		btnRemoveKM.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\delete.png"));
		btnRemoveKM.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRemoveKM.setBackground(Color.RED);
		btnRemoveKM.setBounds(373, 171, 136, 44);
		panelKM.add(btnRemoveKM);
		
		JButton btnHome = new JButton("Home");
		btnHome.setForeground(new Color(255, 255, 255));
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
		btnHome.setBounds(467, 609, 148, 44);
		contentPane.add(btnHome);
		
		JPanel paneCTKM = new JPanel();
		paneCTKM.setBackground(new Color(192, 192, 192));
		paneCTKM.setLayout(null);
		paneCTKM.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Chi ti\u1EBFt khuy\u1EBFn m\u00E3i", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		paneCTKM.setBounds(548, 10, 528, 254);
		contentPane.add(paneCTKM);
		
		JLabel lblNewLabel_1_6_1_3 = new JLabel("Mã khuyến mãi :");
		lblNewLabel_1_6_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_6_1_3.setBounds(59, 22, 154, 25);
		paneCTKM.add(lblNewLabel_1_6_1_3);
		
		JLabel lblNewLabel_1_6_1_1_1 = new JLabel("Mã sản phẩm :");
		lblNewLabel_1_6_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_6_1_1_1.setBounds(59, 80, 154, 25);
		paneCTKM.add(lblNewLabel_1_6_1_1_1);
		
		JLabel lblNewLabel_1_6_1_2_2 = new JLabel("Giá trị giảm :");
		lblNewLabel_1_6_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_6_1_2_2.setBounds(339, 22, 136, 25);
		paneCTKM.add(lblNewLabel_1_6_1_2_2);
		
		JLabel lblNewLabel_1_6_1_2_1_1 = new JLabel("Đơn vị giảm :");
		lblNewLabel_1_6_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_6_1_2_1_1.setBounds(339, 80, 136, 25);
		paneCTKM.add(lblNewLabel_1_6_1_2_1_1);
		
		txtMaKM_ChiTietKhuyenMai = new JTextField();
		txtMaKM_ChiTietKhuyenMai.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtMaKM_ChiTietKhuyenMai.setColumns(10);
		txtMaKM_ChiTietKhuyenMai.setBounds(59, 45, 170, 25);
		paneCTKM.add(txtMaKM_ChiTietKhuyenMai);
		
		txtMaSP = new JTextField();
		txtMaSP.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtMaSP.setColumns(10);
		txtMaSP.setBounds(59, 103, 170, 25);
		paneCTKM.add(txtMaSP);
		
		JButton btnAddCTKM = new JButton("Add");
		btnAddCTKM.setForeground(new Color(255, 255, 255));
		btnAddCTKM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int maPhieuNhap=Integer.parseInt(txtMaKM_ChiTietKhuyenMai.getText());
				int maSanPham=Integer.parseInt(txtMaSP.getText());
				int giaTriGiam=Integer.parseInt(txtGiaTriGiam.getText());
				String phepToan=(String) cbbDonViGiam.getSelectedItem();
				ctkmDTO=new ChiTietKhuyenMaiDTO(maPhieuNhap, maSanPham, giaTriGiam, phepToan, 1);
				if(ctkmBLL.InsertThongTinKhuyenMaiDAL(ctkmDTO)==true) {
					JOptionPane.showMessageDialog(btnAddCTKM,"Thêm thành công");
					ListTableCTKhuyenMai(ctkmBLL.ListThongTinKhuyenMaiDAL());
					return;	
				}
				else {
					JOptionPane.showMessageDialog(btnAddCTKM,"Thêm thất bại");
					return;	
				}
				
				
			}
		});
		btnAddCTKM.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\add.png"));
		btnAddCTKM.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAddCTKM.setBackground(Color.RED);
		btnAddCTKM.setBounds(59, 171, 111, 44);
		paneCTKM.add(btnAddCTKM);
		
		JButton btnUpdateCTKM = new JButton("Update");
		btnUpdateCTKM.setForeground(new Color(255, 255, 255));
		btnUpdateCTKM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int maPhieuNhap=Integer.parseInt(txtMaKM_ChiTietKhuyenMai.getText());
				int maSanPham=Integer.parseInt(txtMaSP.getText());
				int giaTriGiam=Integer.parseInt(txtGiaTriGiam.getText());
				String phepToan=(String) cbbDonViGiam.getSelectedItem();
				ctkmDTO=new ChiTietKhuyenMaiDTO(maPhieuNhap, maSanPham, giaTriGiam, phepToan, 1);
				if(ctkmBLL.UpdateThongTinKhuyenMaiDAL(ctkmDTO)==true) {
					JOptionPane.showMessageDialog(btnUpdateCTKM,"Sửa thành công");
					ListTableCTKhuyenMai(ctkmBLL.ListThongTinKhuyenMaiDAL());
					return;	
				}
				else {
					JOptionPane.showMessageDialog(btnUpdateCTKM,"Sửa thất bại");
					return;	
				}
			}
		});
		btnUpdateCTKM.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\update.png"));
		btnUpdateCTKM.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUpdateCTKM.setBackground(Color.RED);
		btnUpdateCTKM.setBounds(204, 171, 136, 44);
		paneCTKM.add(btnUpdateCTKM);
		
		JButton btnRemoveCTKM = new JButton("Remove");
		btnRemoveCTKM.setForeground(new Color(255, 255, 255));
		btnRemoveCTKM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int maPhieuNhap=Integer.parseInt(txtMaKM_ChiTietKhuyenMai.getText());
				int maSanPham=Integer.parseInt(txtMaSP.getText());
				if(ctkmBLL.RemoveThongTinKhuyenMaiDAL(maPhieuNhap, maSanPham)==true) {
					JOptionPane.showMessageDialog(btnRemoveCTKM,"Xóa thành công");
					ListTableCTKhuyenMai(ctkmBLL.ListThongTinKhuyenMaiDAL());
					return;	
				}
				else {
					JOptionPane.showMessageDialog(btnRemoveCTKM,"Xóa thất bại");
					return;	
				}
				
			}
		});
		btnRemoveCTKM.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\delete.png"));
		btnRemoveCTKM.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRemoveCTKM.setBackground(Color.RED);
		btnRemoveCTKM.setBounds(373, 171, 136, 44);
		paneCTKM.add(btnRemoveCTKM);
		
		cbbDonViGiam = new JComboBox();
		cbbDonViGiam.setBackground(new Color(192, 192, 192));
		cbbDonViGiam.setModel(new DefaultComboBoxModel(new String[] {"VND", "%"}));
		cbbDonViGiam.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbbDonViGiam.setBounds(339, 107, 170, 25);
		paneCTKM.add(cbbDonViGiam);
		
		txtGiaTriGiam = new JTextField();
		txtGiaTriGiam.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtGiaTriGiam.setColumns(10);
		txtGiaTriGiam.setBounds(339, 45, 170, 25);
		paneCTKM.add(txtGiaTriGiam);
		
		JPanel panelDSKM = new JPanel();
		panelDSKM.setBackground(new Color(192, 192, 192));
		panelDSKM.setLayout(null);
		panelDSKM.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch khuy\u1EBFn m\u00E3i", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDSKM.setBounds(10, 274, 528, 325);
		contentPane.add(panelDSKM);
		
		JPanel panelDSCTKM = new JPanel();
		panelDSCTKM.setBackground(new Color(192, 192, 192));
		panelDSCTKM.setLayout(null);
		panelDSCTKM.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch chi ti\u1EBFt khuy\u1EBFn m\u00E3i", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDSCTKM.setBounds(548, 274, 528, 325);
		contentPane.add(panelDSCTKM);
		
		scrollPaneKhuyenMai = new JScrollPane();
		scrollPaneKhuyenMai.setBounds(10, 22, 508, 293);
		panelDSKM.add(scrollPaneKhuyenMai);
		
		tableListKhuyenMai=new JTable();
		tableListKhuyenMai.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				getEventKhuyenMai();
			}
		});
		tableListKhuyenMai.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getEventKhuyenMai();
			}
		});
		
		
		tableListKhuyenMai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableListKhuyenMai.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Mã khuyến mãi","Tên khuyến mãi","Ngày bắt đầu","Ngày kết thúc"
				}
			));
		scrollPaneKhuyenMai.setViewportView(tableListKhuyenMai);
		
		scrollPaneCTKhuyenMai = new JScrollPane();
		scrollPaneCTKhuyenMai.setBounds(10, 22, 508, 293);
		panelDSCTKM.add(scrollPaneCTKhuyenMai);
		
		tableListCTKhuyenMai=new JTable();
		tableListCTKhuyenMai.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				getEventCTKhuyenMai();
			}
		});
		tableListCTKhuyenMai.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getEventCTKhuyenMai();
			}
		});
		
		
		tableListCTKhuyenMai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableListCTKhuyenMai.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Mã khuyến mãi","Mã sản phẩm","Giá trị giảm","Đơn vị giảm"
				}
			));
		scrollPaneCTKhuyenMai.setViewportView(tableListCTKhuyenMai);
		
		ListTableKhuyenMai(kmBLL.ListThongTinKhuyenMaiDAL());
		ListTableCTKhuyenMai(ctkmBLL.ListThongTinKhuyenMaiDAL());
	}
	public void ListTableKhuyenMai(ArrayList<KhuyenMaiDTO> km) {
		DefaultTableModel df= (DefaultTableModel) tableListKhuyenMai.getModel();
		//xoa data trong table
		df.setRowCount(0);
		for (KhuyenMaiDTO khuyenMaiDTO : km) {
			Object dataRow[] =new Object[4];
			dataRow[0]=khuyenMaiDTO.getMaKhuyenMai();
			dataRow[1]=khuyenMaiDTO.getTenKhuyenMai().trim();
			dataRow[2]=khuyenMaiDTO.getNgayBatDau();
			dataRow[3]=khuyenMaiDTO.getNgayKetThuc();
			df.addRow(dataRow);
		}
	}
	public void getEventKhuyenMai() {
		DefaultTableModel df= (DefaultTableModel) tableListKhuyenMai.getModel();
		int indexRow=tableListKhuyenMai.getSelectedRow();
		txtMaKM_KhuyenMai.setText(df.getValueAt(indexRow, 0).toString());
		txtTenKM.setText(df.getValueAt(indexRow, 1).toString());
	}
	public void ListTableCTKhuyenMai(ArrayList<ChiTietKhuyenMaiDTO> ctkm) {
		DefaultTableModel df= (DefaultTableModel) tableListCTKhuyenMai.getModel();
		//xoa data trong table
		df.setRowCount(0);
		for (ChiTietKhuyenMaiDTO chiTietKhuyenMaiDTO : ctkm) {
			Object dataRow[] =new Object[4];
			dataRow[0]=chiTietKhuyenMaiDTO.getMaKhuyenMai();
			dataRow[1]=chiTietKhuyenMaiDTO.getMaSanPham();
			dataRow[2]=chiTietKhuyenMaiDTO.getGiaTriGiam();
			dataRow[3]=chiTietKhuyenMaiDTO.getDonViGiam();
			df.addRow(dataRow);
		}
	}
	public void getEventCTKhuyenMai() {
		DefaultTableModel df= (DefaultTableModel) tableListCTKhuyenMai.getModel();
		int indexRow=tableListCTKhuyenMai.getSelectedRow();
		txtMaKM_ChiTietKhuyenMai.setText(df.getValueAt(indexRow, 0).toString());
		txtMaSP.setText(df.getValueAt(indexRow, 1).toString());
		txtGiaTriGiam.setText(df.getValueAt(indexRow, 2).toString());
		
		JTextField dg=new JTextField();
		dg.setText(df.getValueAt(indexRow, 3).toString()); 
//		String donViGiam=dg.getText();
//		JOptionPane.showMessageDialog(null, donViGiam);
		
		if(dg.getText().trim().equals("VND")) {
//			JOptionPane.showMessageDialog(null, "HUY");
			index=0;
		}
		if(dg.getText().trim().equals("%")) {
			index=1;
		}
		
		cbbDonViGiam.setSelectedIndex(index);
		
	}
}
