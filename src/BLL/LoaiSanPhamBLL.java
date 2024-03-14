package BLL;

import DAL.LoaiSanPhamDAL;
import DTO.LoaiSanPhamDTO;

import java.util.ArrayList;

public class LoaiSanPhamBLL {
	public LoaiSanPhamDAL lsp = new LoaiSanPhamDAL();

	public ArrayList<LoaiSanPhamDTO> layToanBoLoaiSanPham() {
		return lsp.layToanBoLoaiSanPham();
	}

	public boolean InsertThongTinLoaiSanPhamDAL(LoaiSanPhamDTO lspDTO) {
		return lsp.InsertThongTinLoaiSanPhamDAL(lspDTO);
	}

	public boolean UpdateThongTinLoaiSanPhamDAL(LoaiSanPhamDTO lspDTO) {
		return lsp.UpdateThongTinLoaiSanPhamDAL(lspDTO);
	}

	public boolean RemoveThongTinLoaiSanPhamDAL(int MaLoai) {
		return lsp.RemoveThongTinLoaiSanPhamDAL(MaLoai);
	}
	
	public ArrayList<LoaiSanPhamDTO> timkiem(String MaLoai ) {
		return lsp.timkiem(MaLoai);
	}
}
