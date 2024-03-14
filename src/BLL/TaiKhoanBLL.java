package BLL;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import DAL.DataBaseAccess;
import DAL.TaiKhoanDAL;
import DTO.TaiKhoanDTO;

public class TaiKhoanBLL {
	public TaiKhoanDAL taiKhoanDAL=new TaiKhoanDAL();
	public TaiKhoanDTO kiemTraTaiKhoanBLL(String TenDangNhap,String MatKhau) {
		return taiKhoanDAL.kiemTraTaiKhoan(TenDangNhap,MatKhau);
	}
	public TaiKhoanDTO checkTonTaiTaiKhoanBLL(String TenDangNhap) {
		return taiKhoanDAL.checkTonTaiTaiKhoan(TenDangNhap);
	}
	public boolean themTaiKhoanBLL(TaiKhoanDTO tk){
		return taiKhoanDAL.themTaiKhoan(tk);
	}
	public int layMaNhanVienBLL(String TenDangNhap) {
		return taiKhoanDAL.layMaNhanVien(TenDangNhap);
	}
	public String layTenNhanVienBLL(int MaNhanVien) {
		return taiKhoanDAL.layTenNhanVien(MaNhanVien);
	}
	public boolean xoaTaiKhoanBLL(int MaNhanVien) {
		return taiKhoanDAL.xoaTaiKhoan(MaNhanVien);
	}

	public boolean update(int MaNhanVien,String MatKhau,String MaQuyen) {
		return taiKhoanDAL.update(MaNhanVien, MatKhau,MaQuyen);
	}
	public  boolean khoaTaiKhoan(int MaNhanVien) {
		return taiKhoanDAL.khoaTaiKhoan(MaNhanVien);
    }
    public boolean  moKhoaTaiKhoan(int MaNhanVien) {
    	return taiKhoanDAL.moKhoaTaiKhoan(MaNhanVien);
    }
    public ArrayList<TaiKhoanDTO> getAllTaiKhoan(){
    	return taiKhoanDAL.getAllTaiKhoan();
    }
    public TaiKhoanDTO checkTonTaiMaNhanVien(int MaNhanVien) {
    	return taiKhoanDAL.checkTonTaiMaNhanVien(MaNhanVien);
    }
}
