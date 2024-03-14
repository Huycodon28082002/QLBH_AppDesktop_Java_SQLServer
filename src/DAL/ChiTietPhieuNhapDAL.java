package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.ChiTietPhieuNhapDTO;




public class ChiTietPhieuNhapDAL {
	public ArrayList<ChiTietPhieuNhapDTO> ListThongTinSinhVienDAL(){
		ArrayList<ChiTietPhieuNhapDTO> pnArray=new ArrayList<>();
		String sql="select * from ChiTietPhieuNhap ";
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while( rs.next()) {
				ChiTietPhieuNhapDTO pnDTO=new ChiTietPhieuNhapDTO();
				pnDTO.setMaPhieuNhap(rs.getInt("MaPhieuNhap"));
				pnDTO.setMaSanPham(rs.getInt("MaSanPham"));
				pnDTO.setSoLuong(rs.getInt("SoLuong"));
				pnDTO.setDonGia(rs.getFloat("DonGia"));
				pnDTO.setThanhTien(rs.getFloat("ThanhTien"));
				
				pnArray.add(pnDTO);
			}
			rs.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pnArray;
	}
	public boolean add(ChiTietPhieuNhapDTO ctpn) {
		String sql="insert into ChiTietPhieuNhap values(?,?,?,?,?)";
		
		try {
			PreparedStatement ps = DataBaseAccess.getcoon().prepareStatement(sql);
			ps.setInt(1, ctpn.getMaPhieuNhap());
			ps.setInt(2, ctpn.getMaSanPham());
			ps.setInt(3, ctpn.getSoLuong());
			ps.setFloat(4, ctpn.getDonGia());
			ps.setFloat(5, ctpn.getThanhTien());
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}
