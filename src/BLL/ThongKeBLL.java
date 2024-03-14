package BLL;

import java.util.ArrayList;
import java.util.Date;

import DAL.ThongKeDAL;
import DTO.TempThongKeKhachHangDTO;
import DTO.TempThongKeNhanVienDTO;

public class ThongKeBLL {
	public ThongKeDAL tkDAL=new ThongKeDAL();
	public float thongKeDanhThuTheoNgay(Date NgayLap) {
		return tkDAL.thongKeDanhThuTheoNgay(NgayLap);
	}
	public float thongKeDanhThuTheoThang(int Month,int Year) {
		return tkDAL.thongKeDanhThuTheoThang(Month,Year);
	}
	public float thongKeDanhThuTheoNam(int Year) {
		return tkDAL.thongKeDanhThuTheoNam(Year);
	}
	public ArrayList<TempThongKeKhachHangDTO> thongKeKhachHangTheoNgay(Date NgayLap) {
		return tkDAL.thongKeKhachHangTheoNgay(NgayLap);
	}
	public ArrayList<TempThongKeKhachHangDTO> thongKeKhachHangTheoThang(int month,int year) {
		return tkDAL.thongKeKhachHangTheoThang(month, year);
	}
	public ArrayList<TempThongKeKhachHangDTO> thongKeKhachHangTheoNam(int year) {
		return tkDAL.thongKeKhachHangTheoNgayNam(year);
	}
	public ArrayList<TempThongKeNhanVienDTO> thongKeNhanVienTheoNgay(Date NgayLap) {
		return tkDAL.thongKeNhanVienTheoNgay(NgayLap);
	}
	public ArrayList<TempThongKeNhanVienDTO> thongKeNhanVienTheoThang(int month,int year) {
		return tkDAL.thongKeNhanVienTheoThang(month, year);
	}
	public ArrayList<TempThongKeNhanVienDTO> thongKeNhanVienTheoNam(int year) {
		return tkDAL.thongKeNhanVienTheoNgayNam(year);
	}

}
