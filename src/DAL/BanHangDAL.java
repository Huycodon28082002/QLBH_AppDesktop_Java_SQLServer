package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.BanHangDTO;

public class BanHangDAL {

	public ArrayList<BanHangDTO> layToanBoSanPham() {
		ArrayList<BanHangDTO> bhArray = new ArrayList<>();
		String sql = "select * from SanPham";
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BanHangDTO bhDTO = new BanHangDTO();
				bhDTO.setMaSanPham(rs.getInt("MaSanPham"));
				bhDTO.setTenSanPham(rs.getString("TenSanPham"));
				bhDTO.setSoLuong(rs.getInt("SoLuong"));
				bhDTO.setDonGia(rs.getFloat("DonGia"));
				bhDTO.setLoai(rs.getInt("MaLoai"));
				bhDTO.setHinhAnh(rs.getString("DuongDan"));
				bhArray.add(bhDTO);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bhArray;
	}
	
	public ArrayList<BanHangDTO> loc(Float DonGiaTu, Float DonGiaDen) {
		ArrayList<BanHangDTO> bhArray = new ArrayList<>();
		String sql = "select * from SanPham where DonGia >= ? AND DonGia <= ? ";
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ps.setFloat(1, DonGiaTu);
			ps.setFloat(2, DonGiaDen);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BanHangDTO bhDTO = new BanHangDTO();
				bhDTO.setMaSanPham(rs.getInt("MaSanPham"));
				bhDTO.setTenSanPham(rs.getString("TenSanPham"));
				bhDTO.setSoLuong(rs.getInt("SoLuong"));
				bhDTO.setDonGia(rs.getFloat("DonGia"));
				bhDTO.setLoai(rs.getInt("MaLoai"));
				bhDTO.setHinhAnh(rs.getString("DuongDan"));
				bhArray.add(bhDTO);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bhArray;
	}

	public ArrayList<BanHangDTO> layToanBoKhachHang() {
		ArrayList<BanHangDTO> bhArray = new ArrayList<>();
		String sql = "select * from KhachHang";
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BanHangDTO bhDTO = new BanHangDTO();
				bhDTO.setMaKhachHang(rs.getInt("MaKhachHang"));
				bhDTO.setTenKhachHang(rs.getString("TenKhachHang"));
				bhArray.add(bhDTO);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bhArray;
	}

	public ArrayList<BanHangDTO> timkiemKH(String TenKhachHang) {
		ArrayList<BanHangDTO> bhArray = new ArrayList<>();
		String sql = "SELECT * FROM KhachHang WHERE TenKhachHang LIKE N'%" + TenKhachHang
				+ "%'";
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BanHangDTO bhDTO = new BanHangDTO();
				bhDTO.setMaKhachHang(rs.getInt("MaKhachHang"));
				bhDTO.setTenKhachHang(rs.getString("TenKhachHang"));
				bhArray.add(bhDTO);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bhArray;
	}

	public ArrayList<BanHangDTO> layToanBoKhuyenMai() {
		ArrayList<BanHangDTO> bhArray = new ArrayList<>();
		String sql = "select * from KhuyenMai";
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BanHangDTO bhDTO = new BanHangDTO();
				bhDTO.setMaKhuyenMai(rs.getInt("MaKhuyenMai"));
				bhDTO.setTenKhuyenMai(rs.getString("TenKhuyenMai"));
				bhDTO.setNgayBatDau(rs.getDate("NgayBatDau"));
				bhDTO.setNgayKetThuc(rs.getDate("NgayKetThuc"));
				bhArray.add(bhDTO);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bhArray;
	}

	public ArrayList<BanHangDTO> timkiemKM(String MaSanPham) {
		ArrayList<BanHangDTO> bhArray = new ArrayList<>();
		String sql = "SELECT * FROM KhuyenMai WHERE between NgayBatDau=? and NgayKetThuc=?";
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BanHangDTO bhDTO = new BanHangDTO();
				bhDTO.setMaKhuyenMai(rs.getInt("MaKhuyenMai"));
				bhDTO.setMaSanPham(rs.getInt("MaSanPham"));
				bhDTO.setNgayBatDau(rs.getDate("NgayBatDau"));
				bhDTO.setNgayKetThuc(rs.getDate("NgayKetThuc"));
				bhArray.add(bhDTO);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bhArray;
	}
	public ArrayList<BanHangDTO> layToanBoCTKhuyenMai() {
		ArrayList<BanHangDTO> bhArray = new ArrayList<>();
		String sql = "select * from ChiTietKhuyenMai";
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BanHangDTO bhDTO = new BanHangDTO();
				bhDTO.setMaKhuyenMai(rs.getInt("MaKhuyenMai"));
				bhDTO.setMaSanPham(rs.getInt("MaSanPham"));
				bhDTO.setGiaTriGiam(rs.getInt("GiaTriGiam"));
				bhDTO.setDonViGiam(rs.getString("DonViGiam"));
				bhArray.add(bhDTO);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bhArray;
	}

	public ArrayList<BanHangDTO> timkiemCTKM(String MaKhuyenMai) {
		ArrayList<BanHangDTO> bhArray = new ArrayList<>();
		String sql = "SELECT * FROM ChiTietKhuyenMai WHERE MaKhuyenMai = ?";
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ps.setString(1, MaKhuyenMai);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BanHangDTO bhDTO = new BanHangDTO();
				bhDTO.setMaKhuyenMai(rs.getInt("MaKhuyenMai"));
				bhDTO.setMaSanPham(rs.getInt("MaSanPham"));
				bhDTO.setGiaTriGiam(rs.getInt("GiaTriGiam"));
				bhDTO.setDonViGiam(rs.getString("DonViGiam"));
				bhArray.add(bhDTO);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bhArray;
	}
	public ArrayList<BanHangDTO> update(int SLnew, int MaSP) {
		ArrayList<BanHangDTO> bhArray = new ArrayList<>();
		String sql = "Update SanPham set SoLuong = ? where MaSanPham = ?";
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ps.setInt(1, SLnew);
			ps.setInt(2, MaSP);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BanHangDTO bhDTO = new BanHangDTO();
				bhDTO.setMaSanPham(rs.getInt("MaSanPham"));
				bhDTO.setTenSanPham(rs.getString("TenSanPham"));
				bhDTO.setSoLuong(rs.getInt("SoLuong"));
				bhDTO.setDonGia(rs.getFloat("DonGia"));
				bhDTO.setLoai(rs.getInt("MaLoai"));
				bhDTO.setHinhAnh(rs.getString("DuongDan"));
				bhArray.add(bhDTO);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bhArray;
	}
	public int getSoLuong(int MaSanPham) {
		String sql = "select SoLuong from SanPham where MaSanPham = ?";
		int soluong=-1;
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ps.setInt(1, MaSanPham);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				 soluong=rs.getInt("SoLuong");
			}
			rs.close();
			return soluong;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return soluong;
	}
}
