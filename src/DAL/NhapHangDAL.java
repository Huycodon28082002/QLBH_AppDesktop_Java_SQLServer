package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;

import DTO.NhapHangDTO;


public class NhapHangDAL {
	public ArrayList<NhapHangDTO> layToanBoKhoHang(){
		ArrayList<NhapHangDTO> nhArray=new ArrayList<>();
		String sql="select * from SanPham";
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while( rs.next()) {
				NhapHangDTO nhDTO=new NhapHangDTO();
				nhDTO.setMaSanPham(rs.getInt("MaSanPham"));
				nhDTO.setTenSanPham(rs.getString("TenSanPham"));
				nhDTO.setSoLuong(rs.getInt("SoLuong"));
				nhDTO.setDonGia(rs.getFloat("DonGia"));
				nhArray.add(nhDTO);
			}
			rs.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nhArray;
	}
	public ArrayList<NhapHangDTO> timKiem(String TenSanPham){
		ArrayList<NhapHangDTO> nhArray=new ArrayList<>();
		String sql="select * from SanPham where TenSanPham like N'%"+TenSanPham+"%'";
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while( rs.next()) {
				NhapHangDTO nhDTO=new NhapHangDTO();
				nhDTO.setMaSanPham(rs.getInt("MaSanPham"));
				nhDTO.setTenSanPham(rs.getString("TenSanPham"));
				nhDTO.setSoLuong(rs.getInt("SoLuong"));
				nhDTO.setDonGia(rs.getFloat("DonGia"));
				nhArray.add(nhDTO);
			}
			rs.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nhArray;
	}
	public void ListComboboxNhapHangDAL(JComboBox c) {
		String sql="select TenNhaCungCap from NhaCungCap ";
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while( rs.next()) {
				String pat = rs.getString("TenNhaCungCap");
	            c.addItem(pat.trim());
			}
			rs.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int layMaNhaCC(String tenNhaCC) {
		int maNCC=-1;
		String sql="select MaNhaCungCap from NhaCungCap where TenNhaCungCap='"+tenNhaCC+"'";
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while( rs.next()) {
				maNCC=rs.getInt("MaNhaCungCap");
			}
			rs.close();
			
			return maNCC;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maNCC;
	}
	public boolean UpdateSanPhamDAL(int MaSanPham,int SoLuong) {
		String sql="update SanPham set SoLuong=SoLuong + ? where MaSanPham=?  ";
		
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ps.setInt(1, SoLuong);
			ps.setInt(2,MaSanPham);

			
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		}
}
