package DTO;

import java.sql.Date;
import java.util.Objects;

public class ChiTietKhuyenMaiDTO {
	public int MaKhuyenMai;
	public int MaSanPham;
	public int GiaTriGiam;
	public String DonViGiam;
	public int TinhTrang;
	public ChiTietKhuyenMaiDTO(int maKhuyenMai, int maSanPham, int giaTriGiam, String donViGiam, int tinhTrang) {
		super();
		MaKhuyenMai = maKhuyenMai;
		MaSanPham = maSanPham;
		GiaTriGiam = giaTriGiam;
		DonViGiam = donViGiam;
		TinhTrang = tinhTrang;
	}
	public ChiTietKhuyenMaiDTO() {
		super();
	}
	public int getMaKhuyenMai() {
		return MaKhuyenMai;
	}
	public void setMaKhuyenMai(int maKhuyenMai) {
		MaKhuyenMai = maKhuyenMai;
	}
	public int getMaSanPham() {
		return MaSanPham;
	}
	public void setMaSanPham(int maSanPham) {
		MaSanPham = maSanPham;
	}
	public int getGiaTriGiam() {
		return GiaTriGiam;
	}
	public void setGiaTriGiam(int giaTriGiam) {
		GiaTriGiam = giaTriGiam;
	}
	public String getDonViGiam() {
		return DonViGiam;
	}
	public void setDonViGiam(String donViGiam) {
		DonViGiam = donViGiam;
	}
	public int getTinhTrang() {
		return TinhTrang;
	}
	public void setTinhTrang(int tinhTrang) {
		TinhTrang = tinhTrang;
	}
	@Override
	public int hashCode() {
		return Objects.hash(DonViGiam, GiaTriGiam, MaKhuyenMai, MaSanPham, TinhTrang);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietKhuyenMaiDTO other = (ChiTietKhuyenMaiDTO) obj;
		return Objects.equals(DonViGiam, other.DonViGiam) && GiaTriGiam == other.GiaTriGiam
				&& MaKhuyenMai == other.MaKhuyenMai && MaSanPham == other.MaSanPham && TinhTrang == other.TinhTrang;
	}
	
}
