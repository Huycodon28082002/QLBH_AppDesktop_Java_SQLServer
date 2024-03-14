package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import BLL.BanHangBLL;
import DTO.BanHangDTO;
import DTO.LayThongTinKhachHangDTO;
import java.awt.Color;

public class TimKiemKH extends JFrame {
	private JTextField txtMaKH_TKKH;
	private JTextField txtTenKH_TKKH;
	private JTextField txtTenKHTim_TKKH;
	private JTable tableListKhachHang;
	private BanHangDTO bhDTO = new BanHangDTO();
	private BanHangBLL bhBLL = new BanHangBLL();
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimKiemKH frame = new TimKiemKH();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TimKiemKH() {
		getContentPane().setBackground(new Color(192, 192, 192));

		getContentPane().setLayout(null);

		JLabel lblMaKH_TKKH = new JLabel("Mã KH:");
		lblMaKH_TKKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMaKH_TKKH.setBounds(20, 65, 70, 25);
		getContentPane().add(lblMaKH_TKKH);

		JLabel lblTenKH_TKKH = new JLabel("Tên:");
		lblTenKH_TKKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTenKH_TKKH.setBounds(270, 65, 38, 25);
		getContentPane().add(lblTenKH_TKKH);

		JLabel lbl = new JLabel("Tìm Kiếm Khách Hàng");
		lbl.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl.setBounds(150, 15, 222, 40);
		getContentPane().add(lbl);

		txtMaKH_TKKH = new JTextField();
		txtMaKH_TKKH.setColumns(10);
		txtMaKH_TKKH.setBounds(100, 67, 140, 25);
		getContentPane().add(txtMaKH_TKKH);

		txtTenKH_TKKH = new JTextField();
		txtTenKH_TKKH.setColumns(10);
		txtTenKH_TKKH.setBounds(310, 65, 150, 25);
		getContentPane().add(txtTenKH_TKKH);

		JLabel lblMaKHTim_TKKH = new JLabel("Tên KH:");
		lblMaKHTim_TKKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMaKHTim_TKKH.setBounds(80, 115, 60, 25);
		getContentPane().add(lblMaKHTim_TKKH);

		txtTenKHTim_TKKH = new JTextField();
		txtTenKHTim_TKKH.setColumns(10);
		txtTenKHTim_TKKH.setBounds(150, 115, 150, 25);
		getContentPane().add(txtTenKHTim_TKKH);

		JButton btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setBackground(new Color(255, 0, 0));
		btnTimKiem.setForeground(new Color(255, 255, 255));
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String tenKhachHang = txtTenKHTim_TKKH.getText();
				
					ArrayList<BanHangDTO> listKH = new BanHangBLL().timkiemKH(tenKhachHang);
					ListTableKhachHang(listKH);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(btnTimKiem, "Tìm kiếm thất bại");
				}
			}
		});
		btnTimKiem.setBounds(330, 110, 108, 35);
		getContentPane().add(btnTimKiem);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 160, 465, 160);
		getContentPane().add(scrollPane);

		tableListKhachHang = new JTable();
		tableListKhachHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getEventKhachHang();
			}
		});
		tableListKhachHang.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				getEventKhachHang();
			}
		});
		tableListKhachHang.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 Kh\u00E1ch H\u00E0ng", "T\u00EAn Kh\u00E1ch H\u00E0ng" }));
		scrollPane.setViewportView(tableListKhachHang);

		JButton btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.setForeground(new Color(255, 255, 255));
		btnXacNhan.setBackground(new Color(255, 0, 0));
		btnXacNhan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnXacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LayThongTinKhachHangDTO l=new LayThongTinKhachHangDTO();
				DefaultTableModel df = (DefaultTableModel) tableListKhachHang.getModel();
				int indexRow = tableListKhachHang.getSelectedRow();
				JTextField mkh=new JTextField();
				JTextField tkh=new JTextField();
				
				mkh.setText(df.getValueAt(indexRow, 0).toString());
				tkh.setText(df.getValueAt(indexRow, 1).toString());
				
				int maKH =Integer.parseInt( mkh.getText());
				String tenKH = tkh.getText();
				
				l.setMaKhachHang(maKH);
				l.setTenKhachHang(tenKH);

				dispose();
			}
		});
		btnXacNhan.setBounds(200, 330, 108, 35);
		getContentPane().add(btnXacNhan);

		ListTableKhachHang(bhBLL.layToanBoKhachHang());

		setTitle("My Form");
		setSize(500, 415);
		setLocationRelativeTo(null);

	}

	public void ListTableKhachHang(ArrayList<BanHangDTO> bh) {
		DefaultTableModel df = (DefaultTableModel) tableListKhachHang.getModel();
		df.setRowCount(0);
		for (BanHangDTO banHangDTO : bh) {
			Object dataRow[] = new Object[5];
			dataRow[0] = banHangDTO.getMaKhachHang();
			dataRow[1] = banHangDTO.getTenKhachHang().trim();
			df.addRow(dataRow);
		}
	}

	public void getEventKhachHang() {
		DefaultTableModel df = (DefaultTableModel) tableListKhachHang.getModel();
		int indexRow = tableListKhachHang.getSelectedRow();
		
		txtMaKH_TKKH.setText(df.getValueAt(indexRow, 0).toString());
		txtTenKH_TKKH.setText(df.getValueAt(indexRow, 1).toString());
	}
	
}
