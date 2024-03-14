package BLL;

import java.util.ArrayList;

import DAL.ChiTietKhuyenMaiDAL;
import DTO.ChiTietKhuyenMaiDTO;


public class ChiTietKhuyenMaiBLL {
	public ChiTietKhuyenMaiDAL ctkmDAL=new ChiTietKhuyenMaiDAL();
	public ArrayList<ChiTietKhuyenMaiDTO> ListThongTinKhuyenMaiDAL(){
		return ctkmDAL.ListThongTinChiTietKhuyenMaiDAL();
	}
	public boolean InsertThongTinKhuyenMaiDAL(ChiTietKhuyenMaiDTO ctkmDTO) {
		return ctkmDAL.InsertThongTinChiTietKhuyenMaiDAL(ctkmDTO);
	}
	public boolean UpdateThongTinKhuyenMaiDAL(ChiTietKhuyenMaiDTO ctkmDTO) {
		return ctkmDAL.UpdateThongTinChiTietKhuyenMaiDAL(ctkmDTO);
	}
	public boolean RemoveThongTinKhuyenMaiDAL(int MaKhuyenMai,int MaSanPham) {
		return ctkmDAL.RemoveThongTinChiTietKhuyenMaiDAL(MaKhuyenMai,MaSanPham);
	}
}
