package DAL;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.HoaDonDTO;
import DTO.PhieuNhapDTO;

public class HoaDonDAL {
	public ArrayList<HoaDonDTO> ListThongTinHoaDonDAL() {
		ArrayList<HoaDonDTO> hdArray = new ArrayList<>();
		String sql = "select * from HoaDon";
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				HoaDonDTO hdDTO = new HoaDonDTO();
				hdDTO.setMaHoaDon(rs.getInt("MaHoaDon"));
				hdDTO.setMaNhanVien(rs.getInt("MaNhanVien"));
				hdDTO.setMaKhachHang(rs.getInt("MaKhachHang"));
				hdDTO.setNgayLap(rs.getDate("NgayLap"));
				hdDTO.setTongTien(rs.getFloat("TongTien"));
				hdArray.add(hdDTO);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hdArray;
	}
	
	public ArrayList<HoaDonDTO> loc(Date NgayLapTu, Date NgayLapDen) {
		ArrayList<HoaDonDTO> hdArray = new ArrayList<>();
		String sql = "select * from HoaDon where NgayLap >= ? AND NgayLap <= ? ";
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ps.setDate(1, NgayLapTu);
			ps.setDate(2, NgayLapDen);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				HoaDonDTO hdDTO = new HoaDonDTO();
				hdDTO.setMaHoaDon(rs.getInt("MaHoaDon"));
				hdDTO.setMaNhanVien(rs.getInt("MaNhanVien"));
				hdDTO.setMaKhachHang(rs.getInt("MaKhachHang"));
				hdDTO.setNgayLap(rs.getDate("NgayLap"));
				hdDTO.setTongTien(rs.getFloat("TongTien"));
				hdArray.add(hdDTO);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hdArray;
	}
	public boolean Insert(HoaDonDTO pnDTO) {
		String sql="insert into HoaDon values(?,?,?,?,?)";
		
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ps.setInt(1, pnDTO.getMaNhanVien());
			ps.setInt(2, pnDTO.getMaKhachHang());
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
	public boolean UpdateThongTinHoaDonDAL(HoaDonDTO hdDTO) {
		String sql = "update HoaDon set MaNhanVien=?,MaKhachHang=?,NgayLap=?,TongTien=? where MaHoaDon=?  ";

		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ps.setInt(6, hdDTO.getMaHoaDon());
			ps.setInt(1, hdDTO.getMaNhanVien());
			ps.setInt(2, hdDTO.getMaKhachHang());
			ps.setDate(3,  hdDTO.getNgayLap());
			ps.setFloat(4, hdDTO.getTongTien());
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean RemoveThongTinHoaDonDAL(int MaHoaDon) {
		String sql = "delete from HoaDon where MaHoaDon=? ";

		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ps.setInt(1, MaHoaDon);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}
	public int getMaHoaDon() {
		//top(1) MaPhieuNhap from PhieuNhap order by MaPhieuNhap DESC
		String sql="select top(1) * from HoaDon order by MaHoaDon DESC";
		int maPhieuNhap=-1;
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while( rs.next()) {
				maPhieuNhap= rs.getInt("MaHoaDon");
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
