package BLL;

import java.util.ArrayList;

import DAL.ChiTietHoaDonDAL;
import DTO.ChiTietHoaDonDTO;

public class ChiTietHoaDonBLL {
	public ChiTietHoaDonDAL cthdDAL = new ChiTietHoaDonDAL();

	public ArrayList<ChiTietHoaDonDTO> ListThongTinChiTietHoaDonDAL() {
		return cthdDAL.ListThongTinChiTietHoaDonDAL();
	}

	public boolean UpdateThongTinChiTietHoaDonDAL(ChiTietHoaDonDTO cthdDTO) {
		return cthdDAL.UpdateThongTinChiTietHoaDonDAL(cthdDTO);
	}

	public boolean RemoveThongTinChiTietHoaDonDAL(int MaHoaDon, int MaSanPham) {
		return cthdDAL.RemoveThongTinChiTietHoaDonDAL(MaHoaDon, MaSanPham);
	}
	public boolean Insert(ChiTietHoaDonDTO pnDTO) {
		return cthdDAL.Insert(pnDTO);
	}
}
