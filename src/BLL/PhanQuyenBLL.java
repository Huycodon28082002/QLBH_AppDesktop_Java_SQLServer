package BLL;

import java.util.ArrayList;

import javax.swing.JComboBox;

import DAL.PhanQuyenDAL;
import DTO.PhanQuyenDTO;

public class PhanQuyenBLL {
//	public PhanQuyenDTO pq=new PhanQuyenDTO();
	public PhanQuyenDAL pqDAL=new PhanQuyenDAL();
	
	public void ListComboboxDAL(JComboBox c) {
		pqDAL.ListComboboxDAL(c);
	}
	public ArrayList<PhanQuyenDTO> layToanBoQuyenTheoMaQuyenBLL(String maQuyen){
		return pqDAL.layToanBoQuyenTheoMaQuyen(maQuyen);
	}
	public ArrayList<PhanQuyenDTO> layQuyenBLL(int maNhanVien){
		return pqDAL.layQuyen(maNhanVien);
	}
	public boolean thucThiPhanQuyenBLL(PhanQuyenDTO pq) {
		return pqDAL.thucThiPhanQuyen(pq);
	}
}
