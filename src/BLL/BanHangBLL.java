package BLL;

import java.util.ArrayList;

import DAL.BanHangDAL;
import DTO.BanHangDTO;

public class BanHangBLL {
	public BanHangDAL bh = new BanHangDAL();

	public ArrayList<BanHangDTO> layToanBoSanPhamBLL() {
		return bh.layToanBoSanPham();
	}

	public ArrayList<BanHangDTO> locBLL(Float DonGiaTu, Float DonGiaDen) {
		return bh.loc(DonGiaTu, DonGiaDen);
	}
	public ArrayList<BanHangDTO> update(int SLnew, int maSanPham) {
		return bh.update(SLnew, maSanPham);
	}

	public ArrayList<BanHangDTO> layToanBoKhachHang() {
		return bh.layToanBoKhachHang();
	}

	public ArrayList<BanHangDTO> timkiemKH(String TenKhachHang) {
		return bh.timkiemKH(TenKhachHang);
	}

	public ArrayList<BanHangDTO> layToanBoKhuyenMai() {
		return bh.layToanBoKhuyenMai();
	}

//	public ArrayList<BanHangDTO> timkiemKM(int MaSanPham) {
//		return bh.timkiemKM(MaSanPham);
//	}
	
	public ArrayList<BanHangDTO> layToanBoCTKhuyenMai() {
		return bh.layToanBoCTKhuyenMai();
	}

	public ArrayList<BanHangDTO> timkiemCTKM(String MaKhuyenMai) {
		return bh.timkiemCTKM(MaKhuyenMai);
	}
	public int getSoLuong(int MaSanPham) {
		return bh.getSoLuong(MaSanPham);
	}
}
