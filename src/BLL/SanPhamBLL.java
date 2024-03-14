package BLL;

import java.util.ArrayList;

import javax.swing.JComboBox;

import DAL.SanPhamDAL;

import DTO.SanPhamDTO;

public class SanPhamBLL {

	public SanPhamDAL sp = new SanPhamDAL();
	
	public ArrayList<SanPhamDTO> layToanBoSanPham() {
		return sp.layToanBoSanPham();
	}
	
//	public ArrayList<LoaiSanPhamDTO> layLoaiSanPham() {
//		return sp.layLoaiSanPham();
//	}
	
	public boolean InsertThongTinSanPhamDAL(SanPhamDTO spDTO) {
		return sp.InsertThongTinSanPhamDAL(spDTO);

	}

	public boolean UpdateThongTinSanPhamDAL(SanPhamDTO spDTO) {
		return sp.UpdateThongTinSanPhamDAL(spDTO);
	}

	public boolean RemoveThongTinSanPhamDAL(int MaSanPham) {
		return sp.RemoveThongTinSanPhamDAL(MaSanPham);
	}
	
	public ArrayList<SanPhamDTO> timkiem(String TenSanPham ) {
		return sp.timkiem(TenSanPham);
	}
	public void ListComboboxDAL(JComboBox c) {
		sp.ListComboboxDAL(c);
	}
}
