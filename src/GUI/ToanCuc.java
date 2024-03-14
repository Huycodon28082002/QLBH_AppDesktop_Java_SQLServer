package GUI;

public class ToanCuc {
	public static String tenNhanVien="";
	public static int maNhanVien=-1;
	public ToanCuc() {
		
	}
	public static String getTenNhanVien() {
		return tenNhanVien;
	}
	public static void setTenNhanVien(String tenNhanVien) {
		ToanCuc.tenNhanVien = tenNhanVien;
	}
	public int getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(int maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	

}
