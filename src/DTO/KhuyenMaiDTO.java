package DTO;

import java.sql.Date;
import java.util.Objects;

public class KhuyenMaiDTO {
	public int MaKhuyenMai;
	public String TenKhuyenMai;
	public Date NgayBatDau;
	public Date NgayKetThuc;
	public int TinhTrang;
	public KhuyenMaiDTO(int maKhuyenMai, String tenKhuyenMai, Date ngayBatDau, Date ngayKetThuc, int tinhTrang) {
		super();
		MaKhuyenMai = maKhuyenMai;
		TenKhuyenMai = tenKhuyenMai;
		NgayBatDau = ngayBatDau;
		NgayKetThuc = ngayKetThuc;
		TinhTrang = tinhTrang;
	}
	public KhuyenMaiDTO() {
		super();
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
	public int getTinhTrang() {
		return TinhTrang;
	}
	public void setTinhTrang(int tinhTrang) {
		TinhTrang = tinhTrang;
	}
	@Override
	public int hashCode() {
		return Objects.hash(MaKhuyenMai, NgayBatDau, NgayKetThuc, TenKhuyenMai, TinhTrang);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhuyenMaiDTO other = (KhuyenMaiDTO) obj;
		return MaKhuyenMai == other.MaKhuyenMai && Objects.equals(NgayBatDau, other.NgayBatDau)
				&& Objects.equals(NgayKetThuc, other.NgayKetThuc) && Objects.equals(TenKhuyenMai, other.TenKhuyenMai)
				&& TinhTrang == other.TinhTrang;
	}
	
	
}
