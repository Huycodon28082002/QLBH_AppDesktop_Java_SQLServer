package DTO;

import java.util.Objects;

public class TempThongKeNhanVienDTO {
	public float TongTien;
	public String TenNhanVien;
	public TempThongKeNhanVienDTO(float tongTien, String tenNhanVien) {
		super();
		TongTien = tongTien;
		TenNhanVien = tenNhanVien;
	}
	public TempThongKeNhanVienDTO() {
		super();
	}
	public float getTongTien() {
		return TongTien;
	}
	public void setTongTien(float tongTien) {
		TongTien = tongTien;
	}
	public String getTenNhanVien() {
		return TenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		TenNhanVien = tenNhanVien;
	}
	@Override
	public int hashCode() {
		return Objects.hash(TenNhanVien, TongTien);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TempThongKeNhanVienDTO other = (TempThongKeNhanVienDTO) obj;
		return Objects.equals(TenNhanVien, other.TenNhanVien)
				&& Float.floatToIntBits(TongTien) == Float.floatToIntBits(other.TongTien);
	}
	
}
