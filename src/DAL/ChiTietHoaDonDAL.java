package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.ChiTietHoaDonDTO;
import DTO.HoaDonDTO;

public class ChiTietHoaDonDAL {
	public ArrayList<ChiTietHoaDonDTO> ListThongTinChiTietHoaDonDAL() {
		ArrayList<ChiTietHoaDonDTO> cthdArray = new ArrayList<>();
		String sql = "select * from ChiTietHoaDon";
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ChiTietHoaDonDTO cthdDTO = new ChiTietHoaDonDTO();
				cthdDTO.setMaHoaDon(rs.getInt("MaHoaDon"));
				cthdDTO.setMaSanPham(rs.getInt("MaSanPham"));
				cthdDTO.setSoLuong(rs.getInt("SoLuong"));
				cthdDTO.setDonGia(rs.getInt("DonGia"));
				cthdDTO.setThanhTien(rs.getFloat("ThanhTien"));
				cthdArray.add(cthdDTO);
			}
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cthdArray;
	}

	public boolean UpdateThongTinChiTietHoaDonDAL(ChiTietHoaDonDTO cthdDTO) {
		String sql = "update ChiTietHoaDon set SoLuong=?,DonGia=?,ThanhTien=? where MaHoaDon=? and MaSanPham=? ";

		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ps.setInt(4, cthdDTO.getMaHoaDon());
			ps.setInt(5, cthdDTO.getMaSanPham());
			ps.setInt(1, cthdDTO.getSoLuong());
			ps.setFloat(2, cthdDTO.getDonGia());
			ps.setFloat(3, cthdDTO.getThanhTien());

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean RemoveThongTinChiTietHoaDonDAL(int MaHoaDon, int MaSanPham) {
		String sql = "delete from ChiTietHoaDon where MaHoaDon=? and MaSanPham=?";

		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ps.setInt(1, MaHoaDon);
			ps.setInt(2, MaSanPham);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}
	public boolean Insert(ChiTietHoaDonDTO pnDTO) {
		String sql="insert into ChiTietHoaDon values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ps.setInt(1, pnDTO.getMaHoaDon());
			ps.setInt(2, pnDTO.getMaSanPham());
			ps.setInt(3, pnDTO.getSoLuong());
			ps.setFloat(4, pnDTO.getDonGia());
			ps.setFloat(5, pnDTO.getThanhTien());
			ps.setInt(6, pnDTO.getTinhTrang());
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
}
