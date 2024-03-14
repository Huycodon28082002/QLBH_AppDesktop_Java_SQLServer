package BLL;


import java.util.ArrayList;
import DAL.KhachHangDAL;
import DTO.KhachHangDTO;

public class KhachHangBLL {
	private KhachHangDAL kn=new KhachHangDAL();
	public ArrayList<KhachHangDTO> ListThongTinDAL(){
		
		return kn.ListThongTinDAL();
	}
	
	public ArrayList<KhachHangDTO> SearchThongTinDAL(String TenKhachHang){
		
		return kn.SearchThongTinDAL(TenKhachHang);
	}
	public boolean Insert(KhachHangDTO khDTO) {
		
		return kn.Insert(khDTO);
		
	}
	public boolean Update(KhachHangDTO khDTO) {
		
		return kn.Update(khDTO);
	}

	public boolean Remove(int MaKhachHang) {
		
		return kn.Remove(MaKhachHang);
		
	}
}
