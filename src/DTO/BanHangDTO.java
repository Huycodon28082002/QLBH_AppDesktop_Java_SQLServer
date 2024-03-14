package DTO;

import java.util.Date;
import java.util.Objects;

public class BanHangDTO {
	public int MaSanPham;
	public String TenSanPham;
	public int SoLuong;
	public Float DonGia;
	public int Loai;
	public String HinhAnh;

	public int MaKhachHang;
	public String TenKhachHang;

	public int MaKhuyenMai;
	public String TenKhuyenMai;
	public Date NgayBatDau;
	public Date NgayKetThuc;
	
	private String DonViGiam;
	private int GiaTriGiam;


	public BanHangDTO() {
		super();
	}

	public BanHangDTO(int maSanPham, String tenSanPham, int soLuong, Float donGia, int loai, String hinhAnh, int moTa) {
		super();
		MaSanPham = maSanPham;
		TenSanPham = tenSanPham;
		SoLuong = soLuong;
		DonGia = donGia;
		Loai = loai;
	}

	public BanHangDTO(int maKhachHang, String tenKhachHang) {
		super();
		MaKhachHang = maKhachHang;
		TenKhachHang = tenKhachHang;
	}
	
	public BanHangDTO(String tenKhuyenMai, int maKhuyenMai, Date ngayBatDau, Date ngayKetThuc) {
		super();
		TenKhuyenMai = tenKhuyenMai;
		MaKhuyenMai = maKhuyenMai;
		NgayBatDau = ngayBatDau;
		NgayKetThuc = ngayKetThuc;
	}
	
	public BanHangDTO(int maSanPham, int maKhuyenMai, String donViGiam, int giaTriGiam) {
		super();
		MaSanPham = maSanPham;
		MaKhuyenMai = maKhuyenMai;
		DonViGiam = donViGiam;
		GiaTriGiam = giaTriGiam;
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

	public Float getDonGia() {
		return DonGia;
	}

	public void setDonGia(Float donGia) {
		DonGia = donGia;
	}

	public int getLoai() {
		return Loai;
	}

	public void setLoai(int loai) {
		Loai = loai;
	}

	public int getMaKhachHang() {
		return MaKhachHang;
	}

	public void setMaKhachHang(int maKhachHang) {
		MaKhachHang = maKhachHang;
	}

	public String getTenKhachHang() {
		return TenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		TenKhachHang = tenKhachHang;
	}

	public int getMaKhuyenMai() {
		return MaKhuyenMai;
	}

	public void setMaKhuyenMai(int maKhuyenMai) {
		MaKhuyenMai = maKhuyenMai;
	}
	
	public String getTenKhuyenMai() {
		return TenKhuyenMai;
	}

	public void setTenKhuyenMai(String tenKhuyenMai) {
		TenKhuyenMai = tenKhuyenMai;
	}

	public Date getNgayBatDau() {
		return NgayBatDau;
	}

	public void setNgayBatDau(Date ngayBatDau) {
		NgayBatDau = ngayBatDau;
	}

	public Date getNgayKetThuc() {
		return NgayKetThuc;
	}

	public void setNgayKetThuc(Date ngayKetThuc) {
		NgayKetThuc = ngayKetThuc;
	}

	public String getDonViGiam() {
		return DonViGiam;
	}

	public void setDonViGiam(String donViGiam) {
		DonViGiam = donViGiam;
	}

	public int getGiaTriGiam() {
		return GiaTriGiam;
	}

	public String getHinhAnh() {
		return HinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		HinhAnh = hinhAnh;
	}

	public void setGiaTriGiam(int giaTriGiam) {
		GiaTriGiam = giaTriGiam;
	}

	@Override
	public int hashCode() {
		return Objects.hash(DonGia, Loai, MaSanPham, SoLuong, TenSanPham);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BanHangDTO other = (BanHangDTO) obj;
		return Double.doubleToLongBits(DonGia) == Double.doubleToLongBits(other.DonGia) && Loai == other.Loai
				&& MaSanPham == other.MaSanPham && SoLuong == other.SoLuong
				&& Objects.equals(TenSanPham, other.TenSanPham);
	}


}
