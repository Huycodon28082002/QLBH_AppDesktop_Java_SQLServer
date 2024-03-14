package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import DTO.PhanQuyenDTO;

public class PhanQuyenDAL {
	public PhanQuyenDTO pq=new PhanQuyenDTO();
	
	public void ListComboboxDAL(JComboBox c) {
		String sql="select MaQuyen from PhanQuyen ";
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while( rs.next()) {
				String pat = rs.getString("MaQuyen");
	            c.addItem(pat.trim());
			}
			rs.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<PhanQuyenDTO> layToanBoQuyenTheoMaQuyen(String maQuyen){
		ArrayList<PhanQuyenDTO> pqDTO=new ArrayList<>();
		String sql="select * from PhanQuyen where MaQuyen like N'%"+maQuyen+"%'";
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while( rs.next()) {
				PhanQuyenDTO pq=new PhanQuyenDTO();
				pq.setQuanLyBanHang(rs.getInt("QuanLyBanHang"));
				pq.setQuanLyNhapHang(rs.getInt("QuanLyNhapHang"));
				pq.setQuanLyKhachHang(rs.getInt("QuanLyKhachHang"));
				pq.setQuanLyNhanVien(rs.getInt("QuanLyNhanVien"));
				pq.setQuanLySanPham(rs.getInt("QuanLySanPham"));
				pq.setQuanLyXemThongKe(rs.getInt("QuanLyXemThongKe"));
				pq.setQuanLyPhanQuyen(rs.getInt("QuanLyPhanQuyen"));
				pq.setQuanLyKhuyenMai(rs.getInt("QuanLyKhuyenMai"));
				pqDTO.add(pq);
			}
			rs.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pqDTO;
	}
	public ArrayList<PhanQuyenDTO> layQuyen(int maNhanVien){
		ArrayList<PhanQuyenDTO> pqDTO=new ArrayList<>();
		String sql="select * from PhanQuyen,TaiKhoan where PhanQuyen.MaQuyen=TaiKhoan.MaQuyen and MaNhanVien ='"+maNhanVien+"'";
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while( rs.next()) {
				PhanQuyenDTO pq=new PhanQuyenDTO();
				pq.setQuanLyBanHang(rs.getInt("QuanLyBanHang"));
				pq.setQuanLyNhapHang(rs.getInt("QuanLyNhapHang"));
				pq.setQuanLyKhachHang(rs.getInt("QuanLyKhachHang"));
				pq.setQuanLyNhanVien(rs.getInt("QuanLyNhanVien"));
				pq.setQuanLySanPham(rs.getInt("QuanLySanPham"));
				pq.setQuanLyXemThongKe(rs.getInt("QuanLyXemThongKe"));
				pq.setQuanLyPhanQuyen(rs.getInt("QuanLyPhanQuyen"));
				pq.setQuanLyKhuyenMai(rs.getInt("QuanLyKhuyenMai"));
				pqDTO.add(pq);
			}
			rs.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pqDTO;
	}
	public boolean thucThiPhanQuyen(PhanQuyenDTO pq) {
		String sql="update PhanQuyen set QuanLyBanHang=?,QuanLyNhapHang=?,QuanLyKhachHang=?,QuanLyNhanVien=?,QuanLySanPham=?,QuanLyXemThongKe=?,QuanLyPhanQuyen=?,QuanLyKhuyenMai=? where MaQuyen=?";
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ps.setInt(1, pq.getQuanLyBanHang());
			ps.setInt(2, pq.getQuanLyNhapHang());
			ps.setInt(3, pq.getQuanLyKhachHang());
			ps.setInt(4, pq.getQuanLyNhanVien());
			ps.setInt(5, pq.getQuanLySanPham());
			ps.setInt(6, pq.getQuanLyXemThongKe());
			ps.setInt(7, pq.getQuanLyPhanQuyen());
			ps.setInt(8, pq.getQuanLyKhuyenMai());
			ps.setString(9, pq.getMaQuyen());
			return ps.executeUpdate()>0;
		}
		catch (Exception e) {
			
			// TODO: handle exception
		}
		return false;
	}
}
