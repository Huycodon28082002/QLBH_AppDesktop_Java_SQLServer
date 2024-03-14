package DAL;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.NhanVienDTO;



public class NhanVienDAL {
 
    public ArrayList<NhanVienDTO> ListThongTinDAL(){
		ArrayList<NhanVienDTO> khArray=new ArrayList<>();
		String sql="select * from NhanVien ";
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while( rs.next()) {
				NhanVienDTO nvDTO=new NhanVienDTO();		
				nvDTO.setMaNhanVien(rs.getInt("MaNhanVien"));
				nvDTO.setTenNhanVien(rs.getString("TenNhanVien"));
				nvDTO.setNgaySinh(rs.getDate("NgaySinh"));
				nvDTO.setSoDienThoai(rs.getString("SoDienThoai"));
				nvDTO.setChucVu(rs.getString("ChucVu"));
				
				khArray.add(nvDTO);
			}
			rs.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return khArray;
	}
	
	public ArrayList<NhanVienDTO> SearchThongTinDAL(String TenNhanVien){
		ArrayList<NhanVienDTO> khArray=new ArrayList<>();
		String sql="select * from NhanVien where TenNhanVien like N'%"+TenNhanVien+"%'";
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while( rs.next()) {
				NhanVienDTO nvDTO=new NhanVienDTO();
				
				nvDTO.setMaNhanVien(rs.getInt("MaNhanVien"));
				nvDTO.setTenNhanVien(rs.getString("TenNhanVien"));
				nvDTO.setNgaySinh(rs.getDate("NgaySinh"));
				nvDTO.setSoDienThoai(rs.getString("SoDienThoai"));
				nvDTO.setChucVu(rs.getString("ChucVu"));
				
				khArray.add(nvDTO);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		return khArray;
	}
	public boolean Insert(NhanVienDTO nvDTO) {
		String sql= "SET IDENTITY_INSERT NhanVien ON"
				 +" insert into NhanVien(MaNhanVien,TenNhanVien,NgaySinh,SoDienThoai,ChucVu) values (?, ?, ?, ?, ?)"
				 +" SET IDENTITY_INSERT NhanVien OFF";
		
		
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ps.setInt(1, nvDTO.getMaNhanVien());
			ps.setString(2, nvDTO.getTenNhanVien());
			ps.setDate(3, nvDTO.getNgaySinh());
			ps.setString(4, nvDTO.getSoDienThoai());
			ps.setString(5, nvDTO.getChucVu());
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	public boolean Update(NhanVienDTO nvDTO) {
		String sql="update NhanVien set TenNhanVien = ?, NgaySinh = ? , SoDienThoai = ?, ChucVu = ? WHERE MaNhanVien = ? ";
		
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			
			ps.setString(1, nvDTO.getTenNhanVien());
			ps.setDate(2, nvDTO.getNgaySinh());
			ps.setString(3, nvDTO.getSoDienThoai());
			ps.setString(4, nvDTO.getChucVu());
			ps.setInt(5, nvDTO.getMaNhanVien());
			
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		}

	public boolean Remove(int MaNhanVien) {
		String sql="delete from NhanVien where MaNhanVien=? ";
		
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ps.setInt(1, MaNhanVien);
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
}
