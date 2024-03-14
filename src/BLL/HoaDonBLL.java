package BLL;

import java.sql.Date;
import java.util.ArrayList;

import DAL.HoaDonDAL;
import DTO.HoaDonDTO;

public class HoaDonBLL {
	public HoaDonDAL hdDAL = new HoaDonDAL();
	
	public ArrayList<HoaDonDTO> ListThongTinHoaDonDAL() {
		return hdDAL.ListThongTinHoaDonDAL();
	}
	
	public ArrayList<HoaDonDTO> locBLL(Date NgayLapTu, Date NgayLapDen) {
		return hdDAL.loc(NgayLapTu, NgayLapDen);
	}

	public boolean UpdateThongTinHoaDonDAL(HoaDonDTO hdDTO) {
		return hdDAL.UpdateThongTinHoaDonDAL(hdDTO);
	}

	public boolean RemoveThongTinHoaDonDAL(int MaHoaDon) {
		return hdDAL.RemoveThongTinHoaDonDAL(MaHoaDon);
	}
	public boolean Insert(HoaDonDTO pnDTO) {
		return hdDAL.Insert(pnDTO);
	}
	public int getMaHoaDon() {
		return hdDAL.getMaHoaDon();
	}
}
