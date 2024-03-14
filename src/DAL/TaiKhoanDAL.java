package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import DTO.TaiKhoanDTO;



public class TaiKhoanDAL {
	public TaiKhoanDTO kiemTraTaiKhoan(String TenDangNhap,String MatKhau) {
		String sql="select * from TaiKhoan where TenDangNhap=? and MatKhau=? and TinhTrang=1";
		PreparedStatement ps;
		ArrayList<TaiKhoanDTO> dstk=new ArrayList<>();
		try {
			ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ps.setString(1, TenDangNhap);
            ps.setString(2, MatKhau);
			ResultSet rs=ps.executeQuery();
			
			while( rs.next()) {
				TaiKhoanDTO tk=new TaiKhoanDTO();
				tk.setMaNhanVien(rs.getInt("MaNhanVien"));
				tk.setMaQuyen(rs.getString("MaQuyen"));
				tk.setTenDangNhap(rs.getString("TenDangNhap"));
				tk.setMatKhau(rs.getString("MatKhau"));
				tk.setTinhTrang(rs.getInt("TinhTrang"));
				dstk.add(tk);
				return dstk.get(0);
			}
			rs.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
		return null;
	}
	public TaiKhoanDTO checkTonTaiTaiKhoan(String TenDangNhap) {
		String sql="select * from TaiKhoan where  TenDangNhap= ? ";
		PreparedStatement ps;
		ArrayList<TaiKhoanDTO> dstk=new ArrayList<>();
		try {
			ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ps.setString(1, TenDangNhap);
			ResultSet rs=ps.executeQuery();
			
			while( rs.next()) {
				TaiKhoanDTO tk=new TaiKhoanDTO();
				tk.setTenDangNhap(rs.getString("TenDangNhap"));
				dstk.add(tk);
				return dstk.get(0);
			}
			rs.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
		return null;
	}
	public TaiKhoanDTO checkTonTaiMaNhanVien(int MaNhanVien) {
		String sql="select * from TaiKhoan where  MaNhanVien= ? ";
		PreparedStatement ps;
		ArrayList<TaiKhoanDTO> dstk=new ArrayList<>();
		try {
			ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ps.setInt(1, MaNhanVien);
			ResultSet rs=ps.executeQuery();
			
			while( rs.next()) {
				TaiKhoanDTO tk=new TaiKhoanDTO();
				tk.setMaNhanVien(MaNhanVien);
				dstk.add(tk);
				return dstk.get(0);
			}
			rs.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
		return null;
	}
	public boolean themTaiKhoan(TaiKhoanDTO tk) {
		String sql="insert into TaiKhoan values(?,?,?,?,?)";
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			
			ps.setString(1, tk.getMaQuyen());
			ps.setInt(2, tk.getMaNhanVien());
			ps.setString(3, tk.getTenDangNhap());
			ps.setString(4, tk.getMatKhau());
			ps.setInt(5, tk.getTinhTrang());
			return ps.executeUpdate()>0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public int layMaNhanVien(String TenDangNhap) {
		String sql="select MaNhanVien from TaiKhoan where TenDangNhap=?";
		int maNhanVien=-1;
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ps.setString(1, TenDangNhap);
			ResultSet rs=ps.executeQuery();
			
			while( rs.next()) {
				
				maNhanVien=rs.getInt("MaNhanVien");
			}
			rs.close();
			return maNhanVien;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maNhanVien;
	}
	public String layTenNhanVien(int MaNhanVien) {
		String sql="select TenNhanVien from NhanVien where MaNhanVien=?";
		String TenNhanVien="";
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ps.setInt(1, MaNhanVien);
			ResultSet rs=ps.executeQuery();
			
			while( rs.next()) {
				TenNhanVien=rs.getString("TenNhanVien");
			}
			rs.close();
			return TenNhanVien;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return TenNhanVien;
	}
	
	public boolean xoaTaiKhoan(int MaNhanVien) {
		String sql="delete from TaiKhoan where MaNhanVien=?";
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ps.setInt(1, MaNhanVien);
			
			return ps.executeUpdate()>0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean khoaTaiKhoan(int MaNhanVien) {
        String sql="update TaiKhoan set TinhTrang=0 where MaNhanVien=?";
        try {
            PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
            ps.setInt(1, MaNhanVien);

            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public static boolean moKhoaTaiKhoan(int MaNhanVien) {
        String sql="update TaiKhoan set TinhTrang=1 where MaNhanVien=?";
        try {
            PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
            ps.setInt(1, MaNhanVien);

            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
	public boolean update(int MaNhanVien,String MatKhau,String MaQuyen) {
		String sql="update TaiKhoan set MatKhau=?,MaQuyen=? where MaNhanVien=?";
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ps.setString(1, MatKhau);
			ps.setString(2, MaQuyen);
			ps.setInt(3, MaNhanVien);
			return ps.executeUpdate()>0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	 public ArrayList<TaiKhoanDTO> getAllTaiKhoan(){
	    	String query = "SELECT * FROM TaiKhoan";
	    	try {
	            PreparedStatement statement = DataBaseAccess.getcoon().prepareStatement(query);
	            ResultSet resultSet = statement.executeQuery();
	            ArrayList<TaiKhoanDTO> DsTK = new ArrayList<>();
	            while (resultSet.next()) {
	            	TaiKhoanDTO tk = new TaiKhoanDTO();
	            	tk.setMaQuyen(resultSet.getString("MaQuyen").trim());
	            	tk.setMaNhanVien(resultSet.getInt("MaNhanVien"));
	            	tk.setTenDangNhap(resultSet.getString("TenDangNhap").trim());
	            	tk.setMatKhau(resultSet.getString("MatKhau").trim());
	            	tk.setTinhTrang(resultSet.getInt("TinhTrang"));
	                DsTK.add(tk);
	            }
	            return DsTK;
	    	} catch(SQLException e) {
	    		e.printStackTrace();
	    		
	    	}
	        return null;
	    }
	

}
