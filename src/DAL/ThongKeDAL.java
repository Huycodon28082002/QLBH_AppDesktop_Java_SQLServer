package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import DTO.TempThongKeKhachHangDTO;
import DTO.TempThongKeNhanVienDTO;

public class ThongKeDAL {
	public float thongKeDanhThuTheoNgay(Date NgayLap) {
		String sql="select SUM(TongTien) as TongTien from HoaDon where NgayLap='"+NgayLap+"'";
		float value=0;
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while( rs.next()) {
				value = rs.getFloat("TongTien");
			}
			rs.close();
			return value;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	public float thongKeDanhThuTheoThang(int Month,int Year) {
		String sql="select SUM(TongTien) as TongTien from HoaDon where MONTH(NgayLap)='"+Month+"' and YEAR(NgayLap)='"+Year+"'";
		float value=0;
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while( rs.next()) {
				value = rs.getFloat("TongTien");
			}
			rs.close();
			return value;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	public float thongKeDanhThuTheoNam(int Year) {
		String sql="select SUM(TongTien) as TongTien from HoaDon where YEAR(NgayLap)='"+Year+"'";
		float value=0;
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while( rs.next()) {
				value = rs.getFloat("TongTien");
			}
			rs.close();
			return value;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	public ArrayList<TempThongKeKhachHangDTO> thongKeKhachHangTheoNgay(Date NgayLap) {
		String sql="select SUM(TongTien) as TongTien,TenKhachHang from HoaDon,KhachHang where NgayLap='"+NgayLap+"' and HoaDon.MaKhachHang=KhachHang.MaKhachHang group by TenKhachHang ";
		ArrayList<TempThongKeKhachHangDTO> temp=new ArrayList<>();
		
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while( rs.next()) {
				TempThongKeKhachHangDTO t=new TempThongKeKhachHangDTO();
				t.setTongTien(rs.getFloat("TongTien"));
				
				t.setTenKhachHang(rs.getString("TenKhachHang"));
				temp.add(t);
			}
			rs.close();
			
			return temp;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}
	public ArrayList<TempThongKeKhachHangDTO> thongKeKhachHangTheoThang(int Month, int Year) {
		String sql="select SUM(TongTien) as TongTien,TenKhachHang from HoaDon,KhachHang where MONTH(NgayLap)='"+Month+"' and YEAR(NgayLap)='"+Year+"' and HoaDon.MaKhachHang=KhachHang.MaKhachHang group by TenKhachHang ";
		ArrayList<TempThongKeKhachHangDTO> temp=new ArrayList<>();
		
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while( rs.next()) {
				TempThongKeKhachHangDTO t=new TempThongKeKhachHangDTO();
				t.setTongTien(rs.getFloat("TongTien"));
				
				t.setTenKhachHang(rs.getString("TenKhachHang"));
				temp.add(t);
			}
			rs.close();
			
			return temp;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}
	public ArrayList<TempThongKeKhachHangDTO> thongKeKhachHangTheoNgayNam(int year) {
		String sql="select SUM(TongTien) as TongTien,TenKhachHang from HoaDon,KhachHang where YEAR(NgayLap)='"+year+"' and HoaDon.MaKhachHang=KhachHang.MaKhachHang group by TenKhachHang ";
		ArrayList<TempThongKeKhachHangDTO> temp=new ArrayList<>();
		
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while( rs.next()) {
				TempThongKeKhachHangDTO t=new TempThongKeKhachHangDTO();
				t.setTongTien(rs.getFloat("TongTien"));
				
				t.setTenKhachHang(rs.getString("TenKhachHang"));
				temp.add(t);
			}
			rs.close();
			
			return temp;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}
	public ArrayList<TempThongKeNhanVienDTO> thongKeNhanVienTheoNgay(Date NgayLap) {
		String sql="select SUM(TongTien) as TongTien,TenNhanVien from HoaDon,NhanVien where NgayLap='"+NgayLap+"' and HoaDon.MaNhanVien=NhanVien.MaNhanVien group by TenNhanVien ";
		ArrayList<TempThongKeNhanVienDTO> temp=new ArrayList<>();
		
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while( rs.next()) {
				TempThongKeNhanVienDTO t=new TempThongKeNhanVienDTO();
				t.setTongTien(rs.getFloat("TongTien"));
				
				t.setTenNhanVien(rs.getString("TenNhanVien"));
				temp.add(t);
			}
			rs.close();
			
			return temp;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}
	public ArrayList<TempThongKeNhanVienDTO> thongKeNhanVienTheoThang(int Month, int Year) {
		String sql="select SUM(TongTien) as TongTien,TenNhanVien from HoaDon,NhanVien where MONTH(NgayLap)='"+Month+"' and YEAR(NgayLap)='"+Year+"' and HoaDon.MaNhanVien=NhanVien.MaNhanVien group by TenNhanVien ";
		ArrayList<TempThongKeNhanVienDTO> temp=new ArrayList<>();
		
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while( rs.next()) {
				TempThongKeNhanVienDTO t=new TempThongKeNhanVienDTO();
				t.setTongTien(rs.getFloat("TongTien"));
				
				t.setTenNhanVien(rs.getString("TenNhanVien"));
				temp.add(t);
			}
			rs.close();
			
			return temp;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}
	public ArrayList<TempThongKeNhanVienDTO> thongKeNhanVienTheoNgayNam(int year) {
		String sql="select SUM(TongTien) as TongTien,TenNhanVien from HoaDon,NhanVien where YEAR(NgayLap)='"+year+"' and HoaDon.MaNhanVien=NhanVien.MaNhanVien group by TenNhanVien ";
		ArrayList<TempThongKeNhanVienDTO> temp=new ArrayList<>();
		
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while( rs.next()) {
				TempThongKeNhanVienDTO t=new TempThongKeNhanVienDTO();
				t.setTongTien(rs.getFloat("TongTien"));
				
				t.setTenNhanVien(rs.getString("TenNhanVien"));
				temp.add(t);
			}
			rs.close();
			
			return temp;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}
	
}
