package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.KhuyenMaiDTO;


public class KhuyenMaiDAL {
	public ArrayList<KhuyenMaiDTO> ListThongTinKhuyenMaiDAL(){
		ArrayList<KhuyenMaiDTO> kmArray=new ArrayList<>();
		String sql="select * from KhuyenMai";
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while( rs.next()) {
				KhuyenMaiDTO kmDTO=new KhuyenMaiDTO();
				kmDTO.setMaKhuyenMai(rs.getInt("MaKhuyenMai"));
				kmDTO.setTenKhuyenMai(rs.getString("TenKhuyenMai"));
				kmDTO.setNgayBatDau(rs.getDate("NgayBatDau"));
				kmDTO.setNgayKetThuc(rs.getDate("NgayKetThuc"));
				kmArray.add(kmDTO);
			}
			rs.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kmArray;
	}
	public boolean InsertThongTinKhuyenMaiDAL(KhuyenMaiDTO kmDTO) {
		String sql="insert into KhuyenMai values(?,?,?,?)";
		
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			//ps.setInt(1, kmDTO.getMaKhuyenMai());
			ps.setString(1, kmDTO.getTenKhuyenMai());
			ps.setDate(2, kmDTO.getNgayBatDau());
			ps.setDate(3, kmDTO.getNgayKetThuc());
			ps.setInt(4, kmDTO.getTinhTrang());
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean UpdateThongTinKhuyenMaiDAL(KhuyenMaiDTO kmDTO) {
		String sql="update KhuyenMai set TenKhuyenMai=?,NgayBatDau=?,NgayKetThuc=? where MaKhuyenMai=?  ";
		
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ps.setInt(4, kmDTO.getMaKhuyenMai());
			ps.setString(1, kmDTO.getTenKhuyenMai());
			ps.setDate(2, kmDTO.getNgayBatDau());
			ps.setDate(3, kmDTO.getNgayKetThuc());
			
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		}

	public boolean RemoveThongTinKhuyenMaiDAL(int MaKhuyenMai) {
		String sql="delete from KhuyenMai where MaKhuyenMai=? ";
		
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ps.setInt(1, MaKhuyenMai);
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
}
