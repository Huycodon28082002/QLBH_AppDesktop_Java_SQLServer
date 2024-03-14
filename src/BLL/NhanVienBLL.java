package BLL;

import java.util.ArrayList;


import DTO.NhanVienDTO;
import DAL.NhanVienDAL;

public class NhanVienBLL {
	private NhanVienDAL nv=new NhanVienDAL();
	public ArrayList<NhanVienDTO> ListThongTinDAL(){
		return nv.ListThongTinDAL();
	}
	
	public ArrayList<NhanVienDTO> SearchThongTinDAL(String TenNhanVien){
		
		return nv.SearchThongTinDAL(TenNhanVien);
	}
	public boolean Insert(NhanVienDTO khDTO) {
		
		return nv.Insert(khDTO);
		
	}
	public boolean Update(NhanVienDTO khDTO) {
		
		return nv.Update(khDTO);
	}

	public boolean Remove(int MaNhanVien) {
		
		return nv.Remove(MaNhanVien);
		
	}
}
