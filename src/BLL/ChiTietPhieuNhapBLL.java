package BLL;

import java.util.ArrayList;

import DAL.ChiTietPhieuNhapDAL;
import DTO.ChiTietPhieuNhapDTO;


public class ChiTietPhieuNhapBLL {
	ChiTietPhieuNhapDAL pn=new ChiTietPhieuNhapDAL();
	public ArrayList<ChiTietPhieuNhapDTO> ListThongTinSinhVienBLL(){
		return pn.ListThongTinSinhVienDAL();
	}
	public boolean addBLL(ChiTietPhieuNhapDTO ctpn) {
		return pn.add(ctpn);
	}
}
