package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.ChiTietKhuyenMaiDTO;


public class ChiTietKhuyenMaiDAL {
	public ArrayList<ChiTietKhuyenMaiDTO> ListThongTinChiTietKhuyenMaiDAL(){
		ArrayList<ChiTietKhuyenMaiDTO> ctkmArray=new ArrayList<>();
		String sql="select * from ChiTietKhuyenMai";
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while( rs.next()) {
				ChiTietKhuyenMaiDTO ctkmDTO=new ChiTietKhuyenMaiDTO();
				ctkmDTO.setMaKhuyenMai(rs.getInt("MaKhuyenMai"));
				ctkmDTO.setMaSanPham(rs.getInt("MaSanPham"));
				ctkmDTO.setGiaTriGiam(rs.getInt("GiaTriGiam"));
				ctkmDTO.setDonViGiam(rs.getString("DonViGiam"));
				ctkmArray.add(ctkmDTO);
			}
			rs.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ctkmArray;
	}
	public boolean InsertThongTinChiTietKhuyenMaiDAL(ChiTietKhuyenMaiDTO kmDTO) {
		String sql="insert into ChiTietKhuyenMai values(?,?,?,?,?)";
		
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ps.setInt(1, kmDTO.getMaKhuyenMai());
			ps.setInt(2, kmDTO.getMaSanPham());
			ps.setInt(3, kmDTO.getGiaTriGiam());
			ps.setString(4, kmDTO.getDonViGiam());
			ps.setInt(5, kmDTO.getTinhTrang());
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean UpdateThongTinChiTietKhuyenMaiDAL(ChiTietKhuyenMaiDTO ctkmDTO) {
		String sql="update ChiTietKhuyenMai set GiaTriGiam=?,DonViGiam=? where MaKhuyenMai=? and MaSanPham=? ";
		
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ps.setInt(3, ctkmDTO.getMaKhuyenMai());
			ps.setInt(4, ctkmDTO.getMaSanPham());
			ps.setInt(1, ctkmDTO.getGiaTriGiam());
			ps.setString(2, ctkmDTO.getDonViGiam());
			
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		}

	public boolean RemoveThongTinChiTietKhuyenMaiDAL(int MaKhuyenMai,int MaSanPham) {
		String sql="delete from ChiTietKhuyenMai where MaKhuyenMai=? and MaSanPham=?";
		
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ps.setInt(1, MaKhuyenMai);
			ps.setInt(2, MaSanPham);
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
}
