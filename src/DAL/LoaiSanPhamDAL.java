package DAL;

import DTO.LoaiSanPhamDTO;
import DTO.SanPhamDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoaiSanPhamDAL {

	public ArrayList<LoaiSanPhamDTO> layToanBoLoaiSanPham() {
		ArrayList<LoaiSanPhamDTO> lspArray = new ArrayList<>();
		String sql = "select * from LoaiSanPham";
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				LoaiSanPhamDTO lspDTO = new LoaiSanPhamDTO();
				lspDTO.setMaLoai(rs.getInt("MaLoai"));
				lspDTO.setTenLoai(rs.getString("Tenloai"));
				//lspDTO.setTinhTrang(rs.getInt("TinhTrang"));
				lspArray.add(lspDTO);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lspArray;
	}

	public boolean InsertThongTinLoaiSanPhamDAL(LoaiSanPhamDTO lspDTO) {
		String sql = "insert into LoaiSanPham values(?,?)";
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
//			ps.setInt(1, lspDTO.getMaLoai());
			ps.setString(1, lspDTO.getTenLoai());
			ps.setInt(2, lspDTO.getTinhTrang());
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public boolean UpdateThongTinLoaiSanPhamDAL(LoaiSanPhamDTO lspDTO) {
		String sql = "update LoaiSanPham set TenLoai=? where MaLoai=? ";

		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ps.setInt(2, lspDTO.getMaLoai());
			ps.setString(1, lspDTO.getTenLoai());
			//ps.setInt(2, lspDTO.getTinhTrang());

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public boolean RemoveThongTinLoaiSanPhamDAL(int MaLoai) {
		String sql = "delete from LoaiSanPham where MaLoai=? ";

		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ps.setInt(1, MaLoai);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
	public ArrayList<LoaiSanPhamDTO> timkiem(String TenLoaiSP ) {
		ArrayList<LoaiSanPhamDTO> lspArray = new ArrayList<>();
		String sql = "select * from LoaiSanPham where TenLoai like N'%"+TenLoaiSP+"%' ";
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				LoaiSanPhamDTO lspDTO = new LoaiSanPhamDTO();
				lspDTO.setMaLoai(rs.getInt("MaLoai"));
				lspDTO.setTenLoai(rs.getString("Tenloai"));
			//	lspDTO.setTinhTrang(rs.getInt("TinhTrang"));
				lspArray.add(lspDTO);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lspArray;
	}
}
