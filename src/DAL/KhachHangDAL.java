package DAL;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import DTO.KhachHangDTO;




public class KhachHangDAL {
	public ArrayList<KhachHangDTO> ListThongTinDAL(){
		ArrayList<KhachHangDTO> khArray=new ArrayList<>();
		String sql="select * from KhachHang ";
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while( rs.next()) {
				KhachHangDTO knDTO=new KhachHangDTO();
				knDTO.setMaKhachHang(rs.getInt("MaKhachHang"));
				knDTO.setTenKhachHang(rs.getString("TenKhachHang"));
				knDTO.setNgaySinh(rs.getDate("NgaySinh"));
				knDTO.setSoDienThoai(rs.getString("SoDienThoai"));
				
				khArray.add(knDTO);
			}
			rs.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return khArray;
	}
	
	public ArrayList<KhachHangDTO> SearchThongTinDAL(String TenKhachHang){
		ArrayList<KhachHangDTO> khArray=new ArrayList<>();
		String sql="select * from KhachHang where TenKhachHang like N'%"+TenKhachHang+"%'";
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while( rs.next()) {
				KhachHangDTO knDTO=new KhachHangDTO();
				knDTO.setMaKhachHang(rs.getInt("MaKhachHang"));
				knDTO.setTenKhachHang(rs.getString("TenKhachHang"));
				knDTO.setNgaySinh(rs.getDate("NgaySinh"));
				knDTO.setSoDienThoai(rs.getString("SoDienThoai"));
				
				khArray.add(knDTO);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		return khArray;
	}
	public boolean Insert(KhachHangDTO khDTO) {
		String sql="insert into KhachHang values(?,?,?)";
		
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			//ps.setInt(1, khDTO.getMaKhachHang());
			ps.setString(1, khDTO.getTenKhachHang());
			ps.setDate(2, khDTO.getNgaySinh());
			ps.setString(3, khDTO.getSoDienThoai());
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	public boolean Update(KhachHangDTO khDTO) {
		String sql="update KhachHang set TenKhachHang=?,NgaySinh=?,SoDienThoai=? where MaKhachHang=?  ";
		
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ps.setString(1, khDTO.getTenKhachHang());
			ps.setDate(2, khDTO.getNgaySinh());
			ps.setString(3, khDTO.getSoDienThoai());
			ps.setInt(4, khDTO.getMaKhachHang());

			
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		}

	public boolean Remove(int MaKhachHang) {
		String sql="delete from KhachHang where MaKhachHang=? ";
		
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ps.setInt(1, MaKhachHang);
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
}

