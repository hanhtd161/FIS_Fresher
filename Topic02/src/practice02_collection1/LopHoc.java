package practice02_collection1;

import java.util.*;
import java.util.stream.Collectors;

public class LopHoc {
  private String ten;
  private String giaoVien;
  private List<SinhVien> dsLop = new ArrayList<SinhVien>();

  public LopHoc(String ten, String giaoVien){
    this.ten = ten;
    this.giaoVien = giaoVien;
  }

  public boolean them(SinhVien svMoi){
    return dsLop.add(svMoi);
  }

  //Cau 4
  /*
  Danh Sach Diem Lop : ten
  Giao Vien Chu Nhiem : giaoVien
  STT      MSSV        Ten              Diem TB   XepLoai
  1        123456      Nguyen Van A     8.4       GIOI
  2        678919      Nguyen Van B     6         TB-KHA
  3        112456      Nguyen Van C     7         KHA
  */
  //...
  public String inDiem(){
	StringBuilder str = new StringBuilder("Danh Sach Diem Lop : " + this.ten);
	str.append("\nGiao Vien Chu Nhiem : " + this.giaoVien);
	str.append("\nSTT" + "\tMSSV" + "\tTen" + "\tDiem TB" + "\tXeploai\n");
	int i =1;
	for(SinhVien sV : this.dsLop) {
		str.append(i + "\t" + sV.getMssv() +"\t" + sV.getTen() +"\t" 
				+ sV.tinhDiemTrungBinh() + "\t" + sV.xepLoai() +"\n");
		i++;
	}
    return str.toString();
  }

  //Cau 5
  public List<SinhVien> top10(){
	List<SinhVien> top10List = this.dsLop.stream()
			.sorted(Comparator.comparingDouble(SinhVien::tinhDiemTrungBinh))
			.limit(10)
			.collect(Collectors.toList());
    return top10List;
  }

  //Cau 6
  public List<SinhVien> sinhVienYeu(){
    //Tra ve danh sach vien vien xep loai YEU
    //...
	  List<SinhVien> sinhVienYeu = this.dsLop.stream()
			  .filter(x -> x.xepLoai().equals("YEU"))
			  .collect(Collectors.toList());
    return sinhVienYeu;
  }
}
