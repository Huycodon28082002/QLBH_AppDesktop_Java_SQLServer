package DTO;


import java.sql.Date;
import java.util.Objects;

public class KhachHangDTO {
    public int MaKhachHang;
    public String TenKhachHang;
    public Date NgaySinh;
    public String SoDienThoai;
	public KhachHangDTO() {
		super();
	}
	public KhachHangDTO(int maKhachHang, String tenKhachHang, Date ngaySinh, String soDienThoai) {
		super();
		MaKhachHang = maKhachHang;
		TenKhachHang = tenKhachHang;
		NgaySinh = ngaySinh;
		SoDienThoai = soDienThoai;
	}
	
	public KhachHangDTO(String tenKhachHang, Date ngaySinh, String soDienThoai) {
		super();
		TenKhachHang = tenKhachHang;
		NgaySinh = ngaySinh;
		SoDienThoai = soDienThoai;
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
	public Date getNgaySinh() {
		return NgaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		NgaySinh = ngaySinh;
	}
	public String getSoDienThoai() {
		return SoDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		SoDienThoai = soDienThoai;
	}

	@Override
	public int hashCode() {
		return Objects.hash(MaKhachHang, NgaySinh, SoDienThoai, TenKhachHang);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHangDTO other = (KhachHangDTO) obj;
		return MaKhachHang == other.MaKhachHang && Objects.equals(NgaySinh, other.NgaySinh)
				&& Objects.equals(SoDienThoai, other.SoDienThoai) && Objects.equals(TenKhachHang, other.TenKhachHang)
				;
	}
	
    
}