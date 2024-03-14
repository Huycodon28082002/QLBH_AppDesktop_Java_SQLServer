package DTO;

import java.util.Objects;

public class SanPhamDTO {
	private int maSanPham;
	private int maLoai;
	private String tenSanPham;
	private float donGia;
	private int soLuong;
	private String duongDan;
	private int tinhTrang;

	public SanPhamDTO() {
	}

	public SanPhamDTO(int maSanPham, int maLoai, String tenSanPham, float donGia, int soLuong, String duongDan,
			int tinhTrang) {
		super();
		this.maSanPham = maSanPham;
		this.maLoai = maLoai;
		this.tenSanPham = tenSanPham;
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.duongDan = duongDan;
		this.tinhTrang = tinhTrang;
	}
	

	public SanPhamDTO(int maSanPham, int maLoai, String tenSanPham, float donGia, int soLuong, String duongDan) {
		super();
		this.maSanPham = maSanPham;
		this.maLoai = maLoai;
		this.tenSanPham = tenSanPham;
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.duongDan = duongDan;
	}

	public SanPhamDTO(int maLoai) {
		super();
		this.maLoai = maLoai;
	}

	public int getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(int maSanPham) {
		this.maSanPham = maSanPham;
	}

	public int getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(int maLoai) {
		this.maLoai = maLoai;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public float getDonGia() {
		return donGia;
	}

	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getDuongDan() {
		return duongDan;
	}

	public void setDuongDan(String duongDan) {
		this.duongDan = duongDan;
	}

	public int getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(donGia, maSanPham, tenSanPham);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SanPhamDTO other = (SanPhamDTO) obj;
		return Float.floatToIntBits(donGia) == Float.floatToIntBits(other.donGia)
				&& Objects.equals(maSanPham, other.maSanPham) && Objects.equals(tenSanPham, other.tenSanPham);
	}
}
