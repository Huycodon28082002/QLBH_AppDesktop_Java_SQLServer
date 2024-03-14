package DTO;

import java.util.Objects;

public class LoaiSanPhamDTO {
	private int maLoai;
	private String tenLoai;
	private int tinhTrang;

	public LoaiSanPhamDTO() {
	}

	public LoaiSanPhamDTO(int maLoai, String tenLoai, int tinhTrang) {
		super();
		this.maLoai = maLoai;
		this.tenLoai = tenLoai;
		this.tinhTrang = tinhTrang;
	}
	
	
	

	public LoaiSanPhamDTO(String tenLoai, int tinhTrang) {
		super();
		this.tenLoai = tenLoai;
		this.tinhTrang = tinhTrang;
	}

	public LoaiSanPhamDTO(int maLoai, String maLoaiDTO) {
		super();
		this.maLoai = maLoai;
		this.tenLoai = maLoaiDTO;
	}

	public int getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(int maLoai) {
		this.maLoai = maLoai;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public int getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maLoai, tenLoai, tinhTrang);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoaiSanPhamDTO other = (LoaiSanPhamDTO) obj;
		return maLoai == other.maLoai && Objects.equals(tenLoai, other.tenLoai) && tinhTrang == other.tinhTrang;
	}

}
