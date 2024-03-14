package GUI;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.PhanQuyenBLL;
import DTO.PhanQuyenDTO;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TrangChuGUI extends JFrame {

	private JPanel contentPane;
	private PhanQuyenBLL pqBLL=new PhanQuyenBLL();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangChuGUI frame = new TrangChuGUI();
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
	public TrangChuGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 675);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Quản lý shop bán đồng hồ");
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER,7,7));
		panel.setBounds(20, 456, 966, 175);
		
		contentPane.add(panel);
		
		JButton btnThoat = new JButton("");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				DangNhapGUI dn =new DangNhapGUI();
				dn.setVisible(true);
			}
		});
		btnThoat.setBackground(new Color(255, 0, 0));
		btnThoat.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\exit.png"));
		btnThoat.setBounds(0, 0, 39, 44);
		contentPane.add(btnThoat);
		
		JLabel lblNewLabel = new JLabel("Xin Chào :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(617, 10, 100, 34);
		contentPane.add(lblNewLabel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnSanPham = new JButton("Sản phẩm");
		btnSanPham.setForeground(new Color(255, 255, 255));
		btnSanPham.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SanPhamGUI sp=new SanPhamGUI();
				dispose();
				sp.setVisible(true);
			}
		});
		btnSanPham.setBackground(new Color(255, 0, 0));
		btnSanPham.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\SanPham3.png"));
		btnSanPham.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(btnSanPham);
		
		JButton btnNhanVien = new JButton("Nhân viên");
		btnNhanVien.setForeground(new Color(255, 255, 255));
		btnNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhanVienGUI n=new NhanVienGUI();
				dispose();
				n.setVisible(true);
			}
		});
		btnNhanVien.setBackground(new Color(255, 0, 0));
		btnNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		btnNhanVien.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\NhanVien2.png"));
		btnNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(btnNhanVien);
		
		JButton btnBanHang = new JButton("Bán hàng");
		btnBanHang.setForeground(new Color(255, 255, 255));
		btnBanHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BanHangVaHoaDonGUI b=new BanHangVaHoaDonGUI();
				dispose();
				b.setVisible(true);
			}
		});
		btnBanHang.setBackground(new Color(255, 0, 0));
		btnBanHang.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\BanHang1.png"));
		btnBanHang.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(btnBanHang);
		
		JButton btnGiamGia = new JButton("Giảm giá");
		btnGiamGia.setForeground(new Color(255, 255, 255));
		btnGiamGia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KhuyenMaiGUI t=new KhuyenMaiGUI();
				dispose();
				t.setVisible(true);
			}
		});
		btnGiamGia.setBackground(new Color(255, 0, 0));
		btnGiamGia.setHorizontalAlignment(SwingConstants.LEFT);
		btnGiamGia.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\KhuyenMai2.png"));
		btnGiamGia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(btnGiamGia);
		
		JButton btnKhachHang = new JButton("Khách hàng");
		btnKhachHang.setForeground(new Color(255, 255, 255));
		btnKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KhachHangGUI k=new KhachHangGUI();
				dispose();
				k.setVisible(true);
			}
		});
		btnKhachHang.setBackground(new Color(255, 0, 0));
		btnKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		btnKhachHang.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\KhachHang1.png"));
		btnKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(btnKhachHang);
		
		JButton btnNhapHang = new JButton("Nhập hàng");
		btnNhapHang.setForeground(new Color(255, 255, 255));
		btnNhapHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhapHangVaPhieuNhapGUI t=new NhapHangVaPhieuNhapGUI();
				dispose();
				t.setVisible(true);
			}
		});
		btnNhapHang.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\KhoHang.png"));
		btnNhapHang.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNhapHang.setBackground(Color.RED);
		panel.add(btnNhapHang);
		
		JButton btnThongKe = new JButton("Thống kê");
		btnThongKe.setForeground(new Color(255, 255, 255));
		btnThongKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThongKeGUI tk =new ThongKeGUI();
				dispose();
				tk.setVisible(true);
			}
		});
		btnThongKe.setBackground(new Color(255, 0, 0));
		btnThongKe.setHorizontalAlignment(SwingConstants.LEADING);
		btnThongKe.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\ThongKe2.png"));
		btnThongKe.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(btnThongKe);
		
		JButton btnPhanQuyen = new JButton("Phân quyền");
		btnPhanQuyen.setForeground(new Color(255, 255, 255));
		btnPhanQuyen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PhanQuyenGUI pq=new PhanQuyenGUI();
				pq.setVisible(true);
			}
		});
		btnPhanQuyen.setBackground(new Color(255, 0, 0));
		btnPhanQuyen.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\phân quyền1.png"));
		btnPhanQuyen.setHorizontalAlignment(SwingConstants.LEADING);
		btnPhanQuyen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(btnPhanQuyen);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\AFiS.gif"));
		lblNewLabel_1.setBounds(10, 54, 966, 392);
		contentPane.add(lblNewLabel_1);
		
		
		JLabel lbTenNhanVien = new JLabel("");
		lbTenNhanVien.setBounds(701, 16, 275, 22);
		contentPane.add(lbTenNhanVien);
		lbTenNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		ToanCuc tc=new ToanCuc();
		lbTenNhanVien.setText(tc.tenNhanVien.trim());
		for (PhanQuyenDTO pqDTO : pqBLL.layQuyenBLL(tc.maNhanVien)) {
			if(pqDTO.getQuanLyBanHang()==0) {
				panel.remove(btnBanHang);
			}
			if(pqDTO.getQuanLyNhapHang()==0) {
				panel.remove(btnNhapHang);
			}
			if(pqDTO.getQuanLyKhachHang()==0) {
				panel.remove(btnKhachHang);
			}
			if(pqDTO.getQuanLyNhanVien()==0) {
				panel.remove(btnNhanVien);
			}
			if(pqDTO.getQuanLySanPham()==0) {
				panel.remove(btnSanPham);
			}
			if(pqDTO.getQuanLyXemThongKe()==0) {
				panel.remove(btnThongKe);
			}
			if(pqDTO.getQuanLyPhanQuyen()==0) {
				panel.remove(btnPhanQuyen);
			}
			if(pqDTO.getQuanLyKhuyenMai()==0) {
				panel.remove(btnGiamGia);
			}
		}
		
		
	}
}
