package DTO;

import java.util.Objects;

public class TaiKhoanDTO {
	private String MaQuyen;
	private int MaNhanVien;
	private String TenDangNhap;
	private String MatKhau;
	private int TinhTrang;
	public TaiKhoanDTO(String maQuyen, int maNhanVien, String tenDangNhap, String matKhau, int tinhTrang) {
		super();
		MaQuyen = maQuyen;
		MaNhanVien = maNhanVien;
		TenDangNhap = tenDangNhap;
		MatKhau = matKhau;
		TinhTrang = tinhTrang;
	}
	public TaiKhoanDTO() {
		super();
	}
	public String getMaQuyen() {
		return MaQuyen;
	}
	public void setMaQuyen(String maQuyen) {
		MaQuyen = maQuyen;
	}
	public int getMaNhanVien() {
		return MaNhanVien;
	}
	public void setMaNhanVien(int maNhanVien) {
		MaNhanVien = maNhanVien;
	}
	public String getTenDangNhap() {
		return TenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		TenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return MatKhau;
	}
	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}
	public int getTinhTrang() {
		return TinhTrang;
	}
	public void setTinhTrang(int tinhTrang) {
		TinhTrang = tinhTrang;
	}
	@Override
	public int hashCode() {
		return Objects.hash(MaNhanVien, MaQuyen, MatKhau, TenDangNhap, TinhTrang);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaiKhoanDTO other = (TaiKhoanDTO) obj;
		return MaNhanVien == other.MaNhanVien && Objects.equals(MaQuyen, other.MaQuyen)
				&& Objects.equals(MatKhau, other.MatKhau) && Objects.equals(TenDangNhap, other.TenDangNhap)
				&& TinhTrang == other.TinhTrang;
	}
	
}
