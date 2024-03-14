package DAL;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.PhieuNhapDTO;


public class PhieuNhapDAL {
	public ArrayList<PhieuNhapDTO> ListThongTinSinhVienDAL(){
		ArrayList<PhieuNhapDTO> pnArray=new ArrayList<>();
		String sql="select * from PhieuNhap ";
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while( rs.next()) {
				PhieuNhapDTO pnDTO=new PhieuNhapDTO();
				pnDTO.setMaPhieuNhap(rs.getInt("MaPhieuNhap"));
				pnDTO.setMaNhaCungCap(rs.getInt("MaNhaCungCap"));
				pnDTO.setMaNhanVien(rs.getInt("MaNhanVien"));
				pnDTO.setNgayLap(rs.getDate("NgayLap"));
				pnDTO.setTongTien(rs.getFloat("TongTien"));
				
				pnArray.add(pnDTO);
			}
			rs.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pnArray;
	}
	
	public ArrayList<PhieuNhapDTO> SearchThongTinSinhVienDAL(Date NgayLap){
		ArrayList<PhieuNhapDTO> pnArray=new ArrayList<>();
		String sql="select * from PhieuNhap where NgayLap ='"+NgayLap+"'";
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while( rs.next()) {
				PhieuNhapDTO pnDTO=new PhieuNhapDTO();
				pnDTO.setMaPhieuNhap(rs.getInt("MaPhieuNhap"));
				pnDTO.setMaNhaCungCap(rs.getInt("MaNhaCungCap"));
				pnDTO.setMaNhanVien(rs.getInt("MaNhanVien"));
				pnDTO.setNgayLap(rs.getDate("NgayLap"));
				pnDTO.setTongTien(rs.getFloat("TongTien"));
				
				pnArray.add(pnDTO);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		return pnArray;
	}
	public boolean Insert(PhieuNhapDTO pnDTO) {
		String sql="insert into PhieuNhap values(?,?,?,?,?)";
		
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ps.setInt(1, pnDTO.getMaNhaCungCap());
			ps.setInt(2, pnDTO.getMaNhanVien());
			ps.setDate(3, pnDTO.getNgayLap());
			ps.setFloat(4, pnDTO.getTongTien());
			ps.setInt(5, pnDTO.getTinhTrang());
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	public int getMaPhieuNhap() {
		//top(1) MaPhieuNhap from PhieuNhap order by MaPhieuNhap DESC
		String sql="select top(1) * from PhieuNhap order by MaPhieuNhap DESC";
		int maPhieuNhap=-1;
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while( rs.next()) {
				maPhieuNhap= rs.getInt("MaPhieuNhap");
			}
			rs.close();
			return maPhieuNhap;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maPhieuNhap;
		
	}
}
