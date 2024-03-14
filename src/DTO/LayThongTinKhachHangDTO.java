package DTO;

public class LayThongTinKhachHangDTO {

	private static int MaKhachHang;
	private static String TenKhachHang;
	
	public LayThongTinKhachHangDTO() {
		
	}
	
	public LayThongTinKhachHangDTO(int maKhachHang, String tenKhachHang) {
		super();
		MaKhachHang = maKhachHang;
		TenKhachHang = tenKhachHang;
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
	
	
	
}
