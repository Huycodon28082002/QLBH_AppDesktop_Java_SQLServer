package DTO;

import java.util.Objects;

public class PhanQuyenDTO {
	public String MaQuyen;
	public int QuanLyBanHang;
	public int QuanLyNhapHang;
	public int QuanLyKhachHang;
	public int QuanLyNhanVien;
	public int QuanLySanPham;
	public int QuanLyXemThongKe;
	public int QuanLyPhanQuyen;
	public int QuanLyKhuyenMai;
	public PhanQuyenDTO(String maQuyen, int quanLyBanHang, int quanLyNhapHang, int quanLyKhachHang, int quanLyNhanVien,
			int quanLySanPham, int quanLyXemThongKe, int quanLyPhanQuyen, int quanLyKhuyenMai) {
		super();
		MaQuyen = maQuyen;
		QuanLyBanHang = quanLyBanHang;
		QuanLyNhapHang = quanLyNhapHang;
		QuanLyKhachHang = quanLyKhachHang;
		QuanLyNhanVien = quanLyNhanVien;
		QuanLySanPham = quanLySanPham;
		QuanLyXemThongKe = quanLyXemThongKe;
		QuanLyPhanQuyen = quanLyPhanQuyen;
		QuanLyKhuyenMai = quanLyKhuyenMai;
	}
	public PhanQuyenDTO(int quanLyBanHang, int quanLyNhapHang, int quanLyKhachHang, int quanLyNhanVien,
			int quanLySanPham, int quanLyXemThongKe, int quanLyPhanQuyen, int quanLyKhuyenMai) {
		super();
		QuanLyBanHang = quanLyBanHang;
		QuanLyNhapHang = quanLyNhapHang;
		QuanLyKhachHang = quanLyKhachHang;
		QuanLyNhanVien = quanLyNhanVien;
		QuanLySanPham = quanLySanPham;
		QuanLyXemThongKe = quanLyXemThongKe;
		QuanLyPhanQuyen = quanLyPhanQuyen;
		QuanLyKhuyenMai = quanLyKhuyenMai;
	}
	public PhanQuyenDTO() {
		super();
	}
	public String getMaQuyen() {
		return MaQuyen;
	}
	public void setMaQuyen(String maQuyen) {
		MaQuyen = maQuyen;
	}
	public int getQuanLyBanHang() {
		return QuanLyBanHang;
	}
	public void setQuanLyBanHang(int quanLyBanHang) {
		QuanLyBanHang = quanLyBanHang;
	}
	public int getQuanLyNhapHang() {
		return QuanLyNhapHang;
	}
	public void setQuanLyNhapHang(int quanLyNhapHang) {
		QuanLyNhapHang = quanLyNhapHang;
	}
	public int getQuanLyKhachHang() {
		return QuanLyKhachHang;
	}
	public void setQuanLyKhachHang(int quanLyKhachHang) {
		QuanLyKhachHang = quanLyKhachHang;
	}
	public int getQuanLyNhanVien() {
		return QuanLyNhanVien;
	}
	public void setQuanLyNhanVien(int quanLyNhanVien) {
		QuanLyNhanVien = quanLyNhanVien;
	}
	public int getQuanLySanPham() {
		return QuanLySanPham;
	}
	public void setQuanLySanPham(int quanLySanPham) {
		QuanLySanPham = quanLySanPham;
	}
	public int getQuanLyXemThongKe() {
		return QuanLyXemThongKe;
	}
	public void setQuanLyXemThongKe(int quanLyXemThongKe) {
		QuanLyXemThongKe = quanLyXemThongKe;
	}
	public int getQuanLyPhanQuyen() {
		return QuanLyPhanQuyen;
	}
	public void setQuanLyPhanQuyen(int quanLyPhanQuyen) {
		QuanLyPhanQuyen = quanLyPhanQuyen;
	}
	public int getQuanLyKhuyenMai() {
		return QuanLyKhuyenMai;
	}
	public void setQuanLyKhuyenMai(int quanLyKhuyenMai) {
		QuanLyKhuyenMai = quanLyKhuyenMai;
	}
	@Override
	public int hashCode() {
		return Objects.hash(MaQuyen, QuanLyBanHang, QuanLyKhachHang, QuanLyKhuyenMai, QuanLyNhanVien, QuanLyNhapHang,
				QuanLyPhanQuyen, QuanLySanPham, QuanLyXemThongKe);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhanQuyenDTO other = (PhanQuyenDTO) obj;
		return Objects.equals(MaQuyen, other.MaQuyen) && QuanLyBanHang == other.QuanLyBanHang
				&& QuanLyKhachHang == other.QuanLyKhachHang && QuanLyKhuyenMai == other.QuanLyKhuyenMai
				&& QuanLyNhanVien == other.QuanLyNhanVien && QuanLyNhapHang == other.QuanLyNhapHang
				&& QuanLyPhanQuyen == other.QuanLyPhanQuyen && QuanLySanPham == other.QuanLySanPham
				&& QuanLyXemThongKe == other.QuanLyXemThongKe;
	}
	
}
