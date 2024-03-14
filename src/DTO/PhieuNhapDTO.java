package DTO;

import java.sql.Date;
import java.util.Objects;

public class PhieuNhapDTO {
	public int MaPhieuNhap;
	public int MaNhaCungCap;
	public int MaNhanVien;
	public Date NgayLap;
	public Float TongTien;
	public int TinhTrang;
	public PhieuNhapDTO(int maPhieuNhap, int maNhaCungCap, int maNhanVien, Date ngayLap, Float tongTien) {
		super();
		MaPhieuNhap = maPhieuNhap;
		MaNhaCungCap = maNhaCungCap;
		MaNhanVien = maNhanVien;
		NgayLap = ngayLap;
		TongTien = tongTien;
	}
	
	public PhieuNhapDTO(int maNhaCungCap, int maNhanVien, Date ngayLap, Float tongTien, int tinhTrang) {
		super();
		MaNhaCungCap = maNhaCungCap;
		MaNhanVien = maNhanVien;
		NgayLap = ngayLap;
		TongTien = tongTien;
		TinhTrang = tinhTrang;
	}

	public int getTinhTrang() {
		return TinhTrang;
	}

	public void setTinhTrang(int tinhTrang) {
		TinhTrang = tinhTrang;
	}

	public PhieuNhapDTO() {
		super();
	}
	public int getMaPhieuNhap() {
		return MaPhieuNhap;
	}
	public void setMaPhieuNhap(int maPhieuNhap) {
		MaPhieuNhap = maPhieuNhap;
	}
	public int getMaNhaCungCap() {
		return MaNhaCungCap;
	}
	public void setMaNhaCungCap(int maNhaCungCap) {
		MaNhaCungCap = maNhaCungCap;
	}
	public int getMaNhanVien() {
		return MaNhanVien;
	}
	public void setMaNhanVien(int maNhanVien) {
		MaNhanVien = maNhanVien;
	}
	public Date getNgayLap() {
		return NgayLap;
	}
	public void setNgayLap(Date ngayLap) {
		NgayLap = ngayLap;
	}
	public Float getTongTien() {
		return TongTien;
	}
	public void setTongTien(Float tongTien) {
		TongTien = tongTien;
	}
	@Override
	public int hashCode() {
		return Objects.hash(MaNhaCungCap, MaNhanVien, MaPhieuNhap, NgayLap, TongTien);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhieuNhapDTO other = (PhieuNhapDTO) obj;
		return MaNhaCungCap == other.MaNhaCungCap && MaNhanVien == other.MaNhanVien && MaPhieuNhap == other.MaPhieuNhap
				&& Objects.equals(NgayLap, other.NgayLap) && TongTien == other.TongTien;
	}
	
}
