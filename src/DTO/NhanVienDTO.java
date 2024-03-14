package DTO;

import java.sql.Date;
import java.util.Objects;

public class NhanVienDTO {
	private int MaNhanVien;
    private String TenNhanVien;
    private Date NgaySinh;
    private String SoDienThoai;
    private String ChucVu;

    public NhanVienDTO() {
    	super();
    }

    public NhanVienDTO(int maNhanVien, String tenNhanVien, Date ngaySinh, String soDienThoai, String chucVu) {
    	super();
    	MaNhanVien = maNhanVien;
        TenNhanVien = tenNhanVien;
        NgaySinh = ngaySinh;
        SoDienThoai = soDienThoai;
        ChucVu = chucVu;
        
    }
    
    public NhanVienDTO(String tenNhanVien, Date ngaySinh, String soDienThoai, String chucVu) {
    	super();
        TenNhanVien = tenNhanVien;
        NgaySinh = ngaySinh;
        SoDienThoai = soDienThoai;
        ChucVu = chucVu;
        
    }

    public int getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        MaNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return TenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        TenNhanVien = tenNhanVien;
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

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String chucVu) {
        ChucVu = chucVu;
    }


	@Override
	public int hashCode() {
		return Objects.hash(MaNhanVien, TenNhanVien,  NgaySinh,  SoDienThoai, ChucVu);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVienDTO other = (NhanVienDTO) obj;
		return MaNhanVien == other.MaNhanVien && Objects.equals(TenNhanVien, other.TenNhanVien)
				&& Objects.equals(NgaySinh, other.NgaySinh) && Objects.equals(SoDienThoai, other.SoDienThoai)
				&& Objects.equals(ChucVu, other.ChucVu) 
				;
	}

}
