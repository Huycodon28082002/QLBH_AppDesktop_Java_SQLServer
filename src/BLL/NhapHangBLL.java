package BLL;

import java.util.ArrayList;

import javax.swing.JComboBox;

import DAL.NhapHangDAL;
import DTO.NhapHangDTO;

public class NhapHangBLL {
	public NhapHangDAL nh=new NhapHangDAL();
	public ArrayList<NhapHangDTO> layToanBoKhoHangBLL(){
		return nh.layToanBoKhoHang();
	}
	public ArrayList<NhapHangDTO> timKiemBLL(String TenSanPham){
		return nh.timKiem(TenSanPham);
	}
	public void ListComboboxNhapHangBLL(JComboBox c) {
		nh.ListComboboxNhapHangDAL(c);
	}
	public int layMaNhaCCBLL(String tenNhaCC) {
		return nh.layMaNhaCC(tenNhaCC);
	}
	public boolean UpdateSanPhamBLL(int MaSanPham,int SoLuong) {
		return nh.UpdateSanPhamDAL(MaSanPham, SoLuong);
	}
}
