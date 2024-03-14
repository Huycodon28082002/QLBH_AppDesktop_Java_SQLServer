package BLL;

import java.util.ArrayList;

import DAL.KhuyenMaiDAL;
import DTO.KhuyenMaiDTO;

public class KhuyenMaiBLL {
	public KhuyenMaiDAL kmDAL=new KhuyenMaiDAL();
	public ArrayList<KhuyenMaiDTO> ListThongTinKhuyenMaiDAL(){
		return kmDAL.ListThongTinKhuyenMaiDAL();
	}
	public boolean InsertThongTinKhuyenMaiDAL(KhuyenMaiDTO kmDTO) {
		return kmDAL.InsertThongTinKhuyenMaiDAL(kmDTO);
	}
	public boolean UpdateThongTinKhuyenMaiDAL(KhuyenMaiDTO kmDTO) {
		return kmDAL.UpdateThongTinKhuyenMaiDAL(kmDTO);
	}
	public boolean RemoveThongTinKhuyenMaiDAL(int MaKhuyenMai) {
		return kmDAL.RemoveThongTinKhuyenMaiDAL(MaKhuyenMai);
	}
}
