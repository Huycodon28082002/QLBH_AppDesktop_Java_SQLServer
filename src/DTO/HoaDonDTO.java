package DTO;

import java.sql.Date;
import java.util.Objects;

public class HoaDonDTO {
	public int MaHoaDon;
	public int MaNhanVien;
	public int MaKhachHang;
	public Date NgayLap;
	public float TongTien;
	public int TinhTrang;
	public HoaDonDTO() {
		super();
	}
	public int getMaHoaDon() {
		return MaHoaDon;
	}
	public HoaDonDTO(int maNhanVien, int maKhachHang, Date ngayLap, float tongTien, int tinhTrang) {
		super();
		MaNhanVien = maNhanVien;
		MaKhachHang = maKhachHang;
		NgayLap = ngayLap;
		TongTien = tongTien;
		TinhTrang = tinhTrang;
	}
	public int getMaNhanVien() {
		return MaNhanVien;
	}
	public void setMaNhanVien(int maNhanVien) {
		MaNhanVien = maNhanVien;
	}
	public int getMaKhachHang() {
		return MaKhachHang;
	}
	public void setMaKhachHang(int maKhachHang) {
		MaKhachHang = maKhachHang;
	}
	public Date getNgayLap() {
		return NgayLap;
	}
	public void setNgayLap(Date ngayLap) {
		NgayLap = ngayLap;
	}
	public float getTongTien() {
		return TongTien;
	}
	public void setTongTien(float tongTien) {
		TongTien = tongTien;
	}
	public int getTinhTrang() {
		return TinhTrang;
	}
	public void setTinhTrang(int tinhTrang) {
		TinhTrang = tinhTrang;
	}
	public void setMaHoaDon(int maHoaDon) {
		MaHoaDon = maHoaDon;
	}
	@Override
	public int hashCode() {
		return Objects.hash(MaHoaDon, MaKhachHang, MaNhanVien, NgayLap, TinhTrang, TongTien);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDonDTO other = (HoaDonDTO) obj;
		return MaHoaDon == other.MaHoaDon && MaKhachHang == other.MaKhachHang && MaNhanVien == other.MaNhanVien
				&& Objects.equals(NgayLap, other.NgayLap) && TinhTrang == other.TinhTrang
				&& Float.floatToIntBits(TongTien) == Float.floatToIntBits(other.TongTien);
	}
	public HoaDonDTO(int maHoaDon, int maNhanVien, int maKhachHang, Date ngayLap, float tongTien) {
		super();
		MaHoaDon = maHoaDon;
		MaNhanVien = maNhanVien;
		MaKhachHang = maKhachHang;
		NgayLap = ngayLap;
		TongTien = tongTien;
	}
	
	
	
}
