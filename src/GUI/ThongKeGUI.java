package GUI;

import java.awt.EventQueue;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import BLL.ThongKeBLL;
import DTO.TempThongKeKhachHangDTO;
import DTO.TempThongKeNhanVienDTO;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;


public class ThongKeGUI extends JFrame {

	private JPanel contentPane;
	private DefaultCategoryDataset defaultCategoryDataset;
	private JFreeChart jFreeChart;
	private ChartPanel chartPanel;
	private ThongKeBLL tkBLL=new ThongKeBLL();
	private JDateChooser dateChooserNgayBatDau;
	private String tenTK="Thống kê danh thu";
	private String ngang= "Thời gian";
	private String dung="Danh thu";
	private JComboBox cbbBangTK;
	private JComboBox cbbThongKeTheo;
	private ChartPanel chartPanelKhachHang;
	private DefaultCategoryDataset defaultPieDatasetKhachHang;
	private ChartPanel chartPanelNhanVien;
	private DefaultCategoryDataset defaultPieDatasetNhanVien;
	private JPanel panel_1;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongKeGUI frame = new ThongKeGUI();
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
	public ThongKeGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);
		
		

		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 269, 643);
		contentPane.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(289, 10, 787, 643);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		dateChooserNgayBatDau = new JDateChooser();
		dateChooserNgayBatDau.setBounds(47, 299, 170, 25);
		panel.add(dateChooserNgayBatDau);
		dateChooserNgayBatDau.setDateFormatString("yyyy-MM-dd");
		
		JButton btnThongKe = new JButton("Thống kê");
		btnThongKe.setBackground(new Color(255, 0, 0));
		btnThongKe.setBounds(38, 407, 183, 59);
		panel.add(btnThongKe);
		btnThongKe.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\ThongKe2.png"));
	
		btnThongKe.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblNewLabel = new JLabel("Bảng thống kê :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(47, 124, 170, 25);
		panel.add(lblNewLabel);
		
		JLabel lblThngKTheo = new JLabel("Thống kê theo :");
		lblThngKTheo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblThngKTheo.setBounds(47, 194, 170, 25);
		panel.add(lblThngKTheo);
		
		JLabel lblThiGianThng = new JLabel("Thời gian thống kê :");
		lblThiGianThng.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblThiGianThng.setBounds(47, 264, 170, 25);
		panel.add(lblThiGianThng);

		defaultCategoryDataset= new DefaultCategoryDataset();
		jFreeChart=ChartFactory.createBarChart(tenTK, ngang, dung, defaultCategoryDataset);
		chartPanel=new ChartPanel(jFreeChart);
		chartPanel.setBackground(new Color(192, 192, 192));
		chartPanel.setBounds(10, 10, 767, 623);
		
		panel_1.add(chartPanel);
		
		cbbBangTK = new JComboBox();
		cbbBangTK.setBackground(new Color(192, 192, 192));
		cbbBangTK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String phepToan=(String) cbbBangTK.getSelectedItem();
				if(phepToan.equals("Khách hàng")) {
					tenTK="Thống kê khách hàng";
					ngang="Tên khách hàng";
					dung="Tổng chi tiêu";


					defaultPieDatasetKhachHang= new DefaultCategoryDataset();
					jFreeChart=ChartFactory.createBarChart(tenTK, ngang, dung, defaultPieDatasetKhachHang);
					
					chartPanelKhachHang=new ChartPanel(jFreeChart);
					chartPanelKhachHang.setBounds(10, 10, 767, 623);
					
					panel_1.removeAll();
	
					panel_1.add(chartPanelKhachHang);
					panel_1.repaint();
					
					
					
				}else if(phepToan.equals("Danh thu")) {
					
					panel_1.removeAll();
					
					panel_1.add(chartPanel);
					panel_1.repaint();
					
					
				}else if(phepToan.equals("Nhân viên")) {


					tenTK="Thống kê danh số bán hàng";
					ngang="Tên nhân viên";
					dung="Danh số";
					defaultPieDatasetNhanVien= new DefaultCategoryDataset();
					jFreeChart=ChartFactory.createBarChart(tenTK, ngang, dung, defaultPieDatasetNhanVien);
					chartPanelNhanVien=new ChartPanel(jFreeChart);
					chartPanelNhanVien.setBounds(10, 10, 767, 623);
					panel_1.removeAll();
					
					panel_1.add(chartPanelNhanVien);
					panel_1.repaint();
					
					
				}
			}
		});
		
		cbbBangTK.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbbBangTK.setModel(new DefaultComboBoxModel(new String[] {"Danh thu", "Khách hàng", "Nhân viên"}));
		cbbBangTK.setBounds(47, 159, 170, 25);
		panel.add(cbbBangTK);
		
		cbbThongKeTheo = new JComboBox();
		cbbThongKeTheo.setBackground(new Color(192, 192, 192));
		cbbThongKeTheo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbbThongKeTheo.setModel(new DefaultComboBoxModel(new String[] {"Ngày", "Tháng", "Năm"}));
		cbbThongKeTheo.setBounds(47, 229, 170, 25);
		panel.add(cbbThongKeTheo);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrangChuGUI t=new TrangChuGUI();
				dispose();
				t.setVisible(true);
			}
		});
		btnHome.setIcon(new ImageIcon("E:\\java\\Workspace\\QuanLyBanDongHo\\Icon\\home.png"));
		btnHome.setBounds(57, 501, 148, 44);
		panel.add(btnHome);
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnHome.setBackground(Color.RED);
		
		

		
		
		btnThongKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String phepToan=(String) cbbBangTK.getSelectedItem();
				String ThongKeTheo=(String) cbbThongKeTheo.getSelectedItem();
				java.sql.Date ngayBatDau=null;
				SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
				String dateNgayBatDau = dcn.format(dateChooserNgayBatDau.getDate());
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Calendar cal = Calendar.getInstance();
				try {
					java.util.Date ngayBatDau1 =  formatter.parse(dateNgayBatDau);
					long ngaysinh =ngayBatDau1.getTime();
					ngayBatDau= new java.sql.Date(ngaysinh);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				cal.setTime(ngayBatDau);
				int month = cal.get(Calendar.MONTH);
				int year = cal.get(Calendar.YEAR);
				if(phepToan.equals("Danh thu")) {
					
					if(ThongKeTheo.equals("Ngày")) {
						defaultCategoryDataset.addValue(tkBLL.thongKeDanhThuTheoNgay(ngayBatDau),"Thống kê theo ngày", ngayBatDau);		
						
					}
					else if(ThongKeTheo.equals("Tháng")) {
						
						
						defaultCategoryDataset.addValue(tkBLL.thongKeDanhThuTheoThang(month+1,year),"Thống kê theo tháng", month+1+"."+ year);	
						
					}
					else if(ThongKeTheo.equals("Năm")) {
						defaultCategoryDataset.addValue(tkBLL.thongKeDanhThuTheoNam(year),"Thống kê theo năm", String.valueOf(year));	
					}
				}
				else if(phepToan.equals("Khách hàng")) {
					
					if(ThongKeTheo.equals("Ngày")) {
						for (TempThongKeKhachHangDTO t : tkBLL.thongKeKhachHangTheoNgay(ngayBatDau)) {
							defaultPieDatasetKhachHang.addValue(t.getTongTien(),"Thống kê theo ngày",t.getTenKhachHang().trim()+" "+ngayBatDau);
						}
					}
					else if(ThongKeTheo.equals("Tháng")) {
						for (TempThongKeKhachHangDTO t : tkBLL.thongKeKhachHangTheoThang(month+1,year)) {
							defaultPieDatasetKhachHang.addValue(t.getTongTien(),"Thống kê theo tháng",t.getTenKhachHang().trim()+" "+ month+"-"+year);
						}
					}
					else if(ThongKeTheo.equals("Năm")) {
						for (TempThongKeKhachHangDTO t : tkBLL.thongKeKhachHangTheoNam(year)) {
							defaultPieDatasetKhachHang.addValue(t.getTongTien(),"Thống kê theo năm",t.getTenKhachHang().trim()+" "+year);
						}	
					}
					
				}
				else if(phepToan.equals("Nhân viên")) {

					if(ThongKeTheo.equals("Ngày")) {
						for (TempThongKeNhanVienDTO t : tkBLL.thongKeNhanVienTheoNgay(ngayBatDau)) {
							defaultPieDatasetNhanVien.addValue(t.getTongTien(),"Thống kê theo ngày",t.getTenNhanVien().trim() +" "+ngayBatDau);
						}
					}
					else if(ThongKeTheo.equals("Tháng")) {
						for (TempThongKeNhanVienDTO t : tkBLL.thongKeNhanVienTheoThang(month+1,year)) {
							defaultPieDatasetNhanVien.addValue(t.getTongTien(),"Thống kê theo tháng",t.getTenNhanVien().trim() +" "+month+"-"+year);
						}
					}
					else if(ThongKeTheo.equals("Năm")) {
						for (TempThongKeNhanVienDTO t : tkBLL.thongKeNhanVienTheoNam(year)) {
							defaultPieDatasetNhanVien.addValue(t.getTongTien(),"Thống kê theo năm",t.getTenNhanVien().trim() +" "+year);
						}	
					}
					
				}
			}
		});
		
		
		
	}
}
