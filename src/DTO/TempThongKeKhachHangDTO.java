package DTO;

import java.util.Objects;

public class TempThongKeKhachHangDTO {
	public float TongTien;
	public String TenKhachHang;
	public TempThongKeKhachHangDTO(float tongTien, String tenKhachHang) {
		super();
		TongTien = tongTien;
		TenKhachHang = tenKhachHang;
	}
	public TempThongKeKhachHangDTO() {
		super();
	}
	public float getTongTien() {
		return TongTien;
	}
	public void setTongTien(float tongTien) {
		TongTien = tongTien;
	}
	public String getTenKhachHang() {
		return TenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		TenKhachHang = tenKhachHang;
	}
	@Override
	public int hashCode() {
		return Objects.hash(TenKhachHang, TongTien);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TempThongKeKhachHangDTO other = (TempThongKeKhachHangDTO) obj;
		return Objects.equals(TenKhachHang, other.TenKhachHang)
				&& Float.floatToIntBits(TongTien) == Float.floatToIntBits(other.TongTien);
	}
	
}
