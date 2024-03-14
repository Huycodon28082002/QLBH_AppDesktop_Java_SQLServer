package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import BLL.TaiKhoanBLL;
import DTO.TaiKhoanDTO;

public class DangNhapGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtTaiKhoan;
	private JPasswordField pwMatKhau;
	private TaiKhoanBLL tkBLL=new TaiKhoanBLL();
	private TaiKhoanDTO tkDTO=new TaiKhoanDTO();
	private static String taiKhoan;
	private static String matKhau;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhapGUI frame = new DangNhapGUI();
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
	public DangNhapGUI() {
		setTitle("Đăng nhập");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 475);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tài Khoản\r\n :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(35, 226, 98, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblMtKhu = new JLabel("Mật Khẩu :");
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMtKhu.setBounds(35, 270, 98, 33);
		contentPane.add(lblMtKhu);
		
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTaiKhoan.setColumns(10);
		txtTaiKhoan.setBounds(143, 226, 198, 33);
		contentPane.add(txtTaiKhoan);
		
		pwMatKhau = new JPasswordField();
		pwMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pwMatKhau.setBounds(143, 270, 198, 33);
		contentPane.add(pwMatKhau);
		
		JCheckBox ckbGhiNhoMatKhau = new JCheckBox("Ghi nhớ mật khẩu");
		ckbGhiNhoMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ckbGhiNhoMatKhau.setBounds(35, 321, 149, 23);
		contentPane.add(ckbGhiNhoMatKhau);
		
		JButton btnDangNhap = new JButton("Đăng Nhập");
		btnDangNhap.setForeground(new Color(255, 255, 255));
		btnDangNhap.setBackground(new Color(255, 0, 0));
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String TaiKhoan=txtTaiKhoan.getText();
				String MatKhau=String.valueOf(pwMatKhau.getPassword());
				if(TaiKhoan.equals("")||MatKhau.equals("")) {
					JOptionPane.showMessageDialog(btnDangNhap,"Tài khoản hoặc mật khẩu không được để trống!");
					return;
				}
					
				tkDTO=tkBLL.kiemTraTaiKhoanBLL(TaiKhoan, MatKhau);
				if(tkDTO==null) {
					JOptionPane.showMessageDialog(btnDangNhap,"Sai tài khoản hoặc mật khẩu. Xin hãy thử lại!");
				
				}
				else {
					JOptionPane.showMessageDialog(btnDangNhap,"Đăng nhập thành công");
					int maNhanVien=tkBLL.layMaNhanVienBLL(TaiKhoan);
					String tenNhanVien=tkBLL.layTenNhanVienBLL(maNhanVien);
					
					taiKhoan=TaiKhoan;
					matKhau=MatKhau;
					if(ckbGhiNhoMatKhau.isSelected()==true) {
						txtTaiKhoan.setText(taiKhoan);
						pwMatKhau.setText(matKhau);
					}
					else {
						taiKhoan="";
						matKhau="";
					}
					ToanCuc tc=new ToanCuc();
					tc.tenNhanVien= tenNhanVien;
					tc.maNhanVien=maNhanVien;
					dispose();
					TrangChuGUI t=new TrangChuGUI();
					t.setVisible(true);
					


				}
			}
		});
		btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDangNhap.setBounds(154, 354, 136, 40);
		contentPane.add(btnDangNhap);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBackground(new Color(0, 128, 255));
		lblNewLabel_2.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\2.png"));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 11, 431, 205);
		contentPane.add(lblNewLabel_2);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Quên mật khẩu?");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				JOptionPane.showMessageDialog(lblNewLabel_1,"Liên hệ Admin để được giả quyết!");
			}
		});
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(154, 404, 137, 24);
		contentPane.add(lblNewLabel_1);
		
		JCheckBox ckbxMatKhau = new JCheckBox("Show");
		ckbxMatKhau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ckbxMatKhau.isSelected()==true) {
					pwMatKhau.setEchoChar((char)0);
				}else {
					pwMatKhau.setEchoChar('●');
				}
			}
		});
		ckbxMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ckbxMatKhau.setBounds(347, 279, 59, 23);
		contentPane.add(ckbxMatKhau);

		ckbGhiNhoMatKhau.setSelected(true);
		txtTaiKhoan.setText(taiKhoan);
		pwMatKhau.setText(matKhau);
	}
}
