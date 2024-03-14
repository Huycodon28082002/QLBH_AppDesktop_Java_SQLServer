package BLL;

import java.sql.Date;
import java.util.ArrayList;

import DAL.PhieuNhapDAL;
import DTO.PhieuNhapDTO;

public class PhieuNhapBLL {
	PhieuNhapDAL pn=new PhieuNhapDAL();
	public ArrayList<PhieuNhapDTO> ListThongTinSinhVienBLL(){
		return pn.ListThongTinSinhVienDAL();
	}
	public ArrayList<PhieuNhapDTO> SearchThongTinSinhVienBLL(Date NgayLap){
		return pn.SearchThongTinSinhVienDAL(NgayLap);
	}
	public boolean InsertBLL(PhieuNhapDTO pnDTO) {
		return pn.Insert(pnDTO);
	}
	public int getMaPhieuNhapBLL() {
		return pn.getMaPhieuNhap();
	}
}
