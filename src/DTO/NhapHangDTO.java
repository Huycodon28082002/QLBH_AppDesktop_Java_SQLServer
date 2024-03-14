package DTO;

import java.util.Objects;

public class NhapHangDTO {
	public int MaSanPham;
	public String TenSanPham;
	public int SoLuong;
	public float DonGia;
	public NhapHangDTO(int maSanPham, String tenSanPham, int soLuong, float donGia) {
		super();
		MaSanPham = maSanPham;
		TenSanPham = tenSanPham;
		SoLuong = soLuong;
		DonGia = donGia;
	}
	public NhapHangDTO() {
		super();
	}
	public int getMaSanPham() {
		return MaSanPham;
	}
	public void setMaSanPham(int maSanPham) {
		MaSanPham = maSanPham;
	}
	public String getTenSanPham() {
		return TenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		TenSanPham = tenSanPham;
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
	@Override
	public int hashCode() {
		return Objects.hash(DonGia, MaSanPham, SoLuong, TenSanPham);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhapHangDTO other = (NhapHangDTO) obj;
		return Float.floatToIntBits(DonGia) == Float.floatToIntBits(other.DonGia) && MaSanPham == other.MaSanPham
				&& SoLuong == other.SoLuong && Objects.equals(TenSanPham, other.TenSanPham);
	}
	
}
