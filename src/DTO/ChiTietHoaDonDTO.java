package DTO;

import java.util.Objects;

public class ChiTietHoaDonDTO {
	public int maHoaDon;
	public int maSanPham;
	public int soLuong;
	public float donGia;
	public float thanhTien;
	public int tinhTrang;

	public ChiTietHoaDonDTO() {
		super();
	}

	public ChiTietHoaDonDTO(int maHoaDon, int maSanPham, int soLuong, float donGia, float thanhTien, int tinhTrang) {
		super();
		this.maHoaDon = maHoaDon;
		this.maSanPham = maSanPham;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.thanhTien = thanhTien;
		this.tinhTrang = tinhTrang;
	}
	
	

	public ChiTietHoaDonDTO(int maHoaDon, int maSanPham, int soLuong, float donGia, float thanhTien) {
		super();
		this.maHoaDon = maHoaDon;
		this.maSanPham = maSanPham;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.thanhTien = thanhTien;
	}
	
	public ChiTietHoaDonDTO(int maSanPham, int soLuong, float donGia, float thanhTien, int tinhTrang) {
		super();
		this.maSanPham = maSanPham;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.thanhTien = thanhTien;
		this.tinhTrang = tinhTrang;
	}

	public int getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(int maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public int getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(int maSanPham) {
		this.maSanPham = maSanPham;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public float getDonGia() {
		return donGia;
	}

	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}

	public float getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(float thanhTien) {
		this.thanhTien = thanhTien;
	}

	public int getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	@Override
	public int hashCode() {
		return Objects.hash(donGia, maHoaDon, maSanPham, soLuong, thanhTien, tinhTrang);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietHoaDonDTO other = (ChiTietHoaDonDTO) obj;
		return donGia == other.donGia && maHoaDon == other.maHoaDon && maSanPham == other.maSanPham
				&& soLuong == other.soLuong && thanhTien == other.thanhTien && tinhTrang == other.tinhTrang;
	}

}
