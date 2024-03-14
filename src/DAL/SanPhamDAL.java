package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;

import DTO.SanPhamDTO;

public class SanPhamDAL {

	public ArrayList<SanPhamDTO> layToanBoSanPham() {
		ArrayList<SanPhamDTO> spArray = new ArrayList<>();
		String sql = "select * from SanPham";
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SanPhamDTO spDTO = new SanPhamDTO();
				spDTO.setMaSanPham(rs.getInt("MaSanPham"));
				spDTO.setMaLoai(rs.getInt("MaLoai"));
				spDTO.setTenSanPham(rs.getString("TenSanPham"));
				spDTO.setSoLuong(rs.getInt("SoLuong"));
				spDTO.setDonGia(rs.getFloat("DonGia"));
				spDTO.setDuongDan(rs.getString("DuongDan"));
//				spDTO.setTinhTrang(rs.getInt("TinhTrang"));
				spArray.add(spDTO);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return spArray;
	}
	
	
	public boolean InsertThongTinSanPhamDAL(SanPhamDTO spDTO) {
		String sql = "insert into SanPham values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			//ps.setInt(1, spDTO.getMaSanPham());
			ps.setInt(1, spDTO.getMaLoai());
			ps.setString(2, spDTO.getTenSanPham());
			ps.setFloat(3, spDTO.getDonGia());
			ps.setInt(4, spDTO.getSoLuong());
			ps.setString(5, spDTO.getDuongDan());
			ps.setInt(6, spDTO.getTinhTrang());
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}
	
	public void ListComboboxDAL(JComboBox c) {
		String sql="select MaLoai from LoaiSanPham ";
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while( rs.next()) {
				String pat = rs.getString("MaLoai");
	            c.addItem(pat.trim());
			}
			rs.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean UpdateThongTinSanPhamDAL(SanPhamDTO spDTO) {
		String sql = "update SanPham set TenSanPham=?,DonGia=?,SoLuong=?,DuongDan=?,MaLoai=? where MaSanPham=? ";

		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ps.setInt(6, spDTO.getMaSanPham());
			ps.setInt(5, spDTO.getMaLoai());
			ps.setString(1, spDTO.getTenSanPham());
			ps.setFloat(2, spDTO.getDonGia());
			ps.setInt(3, spDTO.getSoLuong());
			ps.setString(4, spDTO.getDuongDan());
			//ps.setInt(5, spDTO.getTinhTrang());

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public boolean RemoveThongTinSanPhamDAL(int MaSanPham) {
		String sql = "delete from SanPham where MaSanPham=? ";

		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ps.setInt(1, MaSanPham);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<SanPhamDTO> timkiem(String TenSanPham ) {
		ArrayList<SanPhamDTO> spArray = new ArrayList<>();
		String sql = "select * from SanPham where TenSanPham like N'%"+TenSanPham+"%' ";
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SanPhamDTO spDTO = new SanPhamDTO();
				spDTO.setMaSanPham(rs.getInt("MaSanPham"));
				spDTO.setMaLoai(rs.getInt("MaLoai"));
				spDTO.setTenSanPham(rs.getString("TenSanPham"));
				spDTO.setSoLuong(rs.getInt("SoLuong"));
				spDTO.setDonGia(rs.getFloat("DonGia"));
				spDTO.setDuongDan(rs.getString("DuongDan"));
//				spDTO.setTinhTrang(rs.getInt("TinhTrang"));
				spArray.add(spDTO);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return spArray;
	}
	
}
