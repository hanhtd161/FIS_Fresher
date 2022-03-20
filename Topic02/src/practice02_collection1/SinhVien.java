package practice02_collection1;

import java.util.*;

public class SinhVien {
  private String mssv;
  private String ten;

  private Set<Diem> monDaHoc = new HashSet<Diem>();

  public SinhVien(String mssv, String ten){
    this.mssv = mssv;
    this.ten = ten;
  }

  public String getMssv() {
	return mssv;
  }

  public void setMssv(String mssv) {
	this.mssv = mssv;
  }

  public String getTen() {
	return ten;
  }

  public void setTen(String ten) {
	this.ten = ten;
  }

  public boolean themDiem(Diem diemMoi){
    return this.monDaHoc.add(diemMoi);
  }

  //Cau 1
  public double tinhDiemTrungBinh(){
    //Giong nhu cach tinh hien tai cua truong
	int tongDiemHeSo = this.monDaHoc.stream()
		.map( x -> x.getMon().getTongTc() * x.getDiem())
		.mapToInt(Integer::valueOf)
		.sum();
	int tongTinChi = this.monDaHoc.stream()
			 .map( x -> x.getMon().getTongTc())
			 .mapToInt(Integer::valueOf)
			 .sum();		
    //...
    return (double) tongDiemHeSo / tongTinChi ;
  }


  //Cau 2
  /*
  MSSV : 0203044
  Ten  : Nguyen Van A
  Danh Sach Diem
  STT  Ten Mon             Diem       So Tin Chi
  1    Cau Truc Du Lieu 1  8          3
  2    Cau Truc Du Lieu 2  8          3
  Diem Trung Binh   8.0
 */
 //...
  public String taoBangDiem(){
	StringBuilder bangDiem = new StringBuilder("MSSV : " + this.mssv + "\nTen : "
			+ this.ten + "\nDanh Sach Diem\nSTT\tTen Mon\tDiem\tSo Tin Chi\n");
	int i =1;
	for(Diem x : this.monDaHoc) {
		bangDiem.append(i + "\t" + x.getMon().getTen() +
				"\t" + x.getDiem() + "\t" + x.getMon().getTongTc() + "\n");
		i++;
	}
	bangDiem.append("Diem Trung Binh\t" + this.tinhDiemTrungBinh());
    return bangDiem.toString();
  }


  //Cau 3
  public String xepLoai(){
    /*
    Quy tac xep loai nhu sau
        DiemTB < 5 -> YEU
        DiemTB >= 5 va DiemTB < 6 -> TB
        DiemTB >= 6 va DiemTB < 7 -> TB-KHA
        DiemTB >= 7 va DiemTB < 8 -> KHA
        DiemTB >= 8 -> GIOI
    */
	 double diemTB = tinhDiemTrungBinh();
	 if(diemTB < 5) {
		 return "YEU";
	 }
	 if(diemTB < 6) {
		 return "TB";
	 }
	 if(diemTB < 7) {
		 return "TB-KHA";
	 }
	 if(diemTB < 8) {
		 return "KHA";
	 }
    //...
    return "GIOI";
  }

  	public Set<Diem> getMonDaHoc() {
	return this.monDaHoc;
	}

}

