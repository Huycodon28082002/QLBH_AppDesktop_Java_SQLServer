package DTO;

import java.util.Objects;

public class ChiTietPhieuNhapDTO {
	public int MaPhieuNhap;
	public int MaSanPham;
	public int SoLuong;
	public float DonGia;
	public float ThanhTien;
	public ChiTietPhieuNhapDTO(int maPhieuNhap, int maSanPham, int soLuong, float donGia, float thanhTien) {
		super();
		MaPhieuNhap = maPhieuNhap;
		MaSanPham = maSanPham;
		SoLuong = soLuong;
		DonGia = donGia;
		ThanhTien = thanhTien;
	}
	public ChiTietPhieuNhapDTO() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(DonGia, MaPhieuNhap, MaSanPham, SoLuong, ThanhTien);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietPhieuNhapDTO other = (ChiTietPhieuNhapDTO) obj;
		return Float.floatToIntBits(DonGia) == Float.floatToIntBits(other.DonGia) && MaPhieuNhap == other.MaPhieuNhap
				&& MaSanPham == other.MaSanPham && SoLuong == other.SoLuong
				&& Float.floatToIntBits(ThanhTien) == Float.floatToIntBits(other.ThanhTien);
	}
	public int getMaPhieuNhap() {
		return MaPhieuNhap;
	}
	public void setMaPhieuNhap(int maPhieuNhap) {
		MaPhieuNhap = maPhieuNhap;
	}
	public int getMaSanPham() {
		return MaSanPham;
	}
	public void setMaSanPham(int maSanPham) {
		MaSanPham = maSanPham;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	public float getDonGia() {
		return DonGia;
	}
	public void setDonGia(float donGia) {
		DonGia = donGia;
	}
	public float getThanhTien() {
		return ThanhTien;
	}
	public void setThanhTien(float thanhTien) {
		ThanhTien = thanhTien;
	}
	
}
