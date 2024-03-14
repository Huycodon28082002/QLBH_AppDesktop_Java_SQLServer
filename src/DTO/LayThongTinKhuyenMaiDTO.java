package DTO;

public class LayThongTinKhuyenMaiDTO {
	private static int MaKhuyenMai;
	private static int MaSanPham;
	private static String TenKhuyenMai;
	private static String DonViGiam;
	private static int GiaTriGiam;

	public LayThongTinKhuyenMaiDTO() {
		
	}

	public static int getMaKhuyenMai() {
		return MaKhuyenMai;
	}

	public static void setMaKhuyenMai(int maKhuyenMai) {
		MaKhuyenMai = maKhuyenMai;
	}

	public LayThongTinKhuyenMaiDTO(int maSanPham, String tenKhuyenMai) {
		super();
		MaSanPham = maSanPham;
		TenKhuyenMai = tenKhuyenMai;
	}
	
	public LayThongTinKhuyenMaiDTO(String donViGiam, int giaTriGiam) {
		super();
		donViGiam = DonViGiam;
		giaTriGiam = GiaTriGiam;
	}

	public static String getDonViGiam() {
		return DonViGiam;
	}

	public static void setDonViGiam(String donViGiam) {
		DonViGiam = donViGiam;
	}

	public static int getGiaTriGiam() {
		return GiaTriGiam;
	}

	public static void setGiaTriGiam(int giaTriGiam) {
		GiaTriGiam = giaTriGiam;
	}

	public static int getMaSanPham() {
		return MaSanPham;
	}

	public static void setMaSanPham(int maSanPham) {
		MaSanPham = maSanPham;
	}

	public static String getTenKhuyenMai() {
		return TenKhuyenMai;
	}

	public static void setTenKhuyenMai(String tenKhuyenMai) {
		TenKhuyenMai = tenKhuyenMai;
	}
	
}
