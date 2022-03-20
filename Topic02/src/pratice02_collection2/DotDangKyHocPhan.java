package pratice02_collection2;

import java.util.*;
import java.util.stream.Collectors;

public class DotDangKyHocPhan {
    private String ma;
    private Calendar ngayBatDau;
    private Calendar ngayKetThuc;
    private List<PhieuDangKyHocPhan> dsPhieuDangKy = new ArrayList<PhieuDangKyHocPhan>();

    public DotDangKyHocPhan(String ma, Calendar ngayBatDau, Calendar ngayKetThuc){
        this.ma = ma;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }
    
    

    //Cau 3: Lay ra danh sach sinh vien dang ky nhieu mon hoc nhat
    //Chu y : chi quan tam den nhung phieu dang ky hop le
    // Danh sach 10 sinh vien dang ky nhieu mon hoc nhat
    public List<SinhVien> getDsSinhVien(MonHoc monHoc){
       List<PhieuDangKyHocPhan> phieuHopLe = this.dsPhieuDangKy.stream()
    		   									.filter(t -> t.laHopLe())
    		   									.collect(Collectors.toList());
       return phieuHopLe.stream().sorted(Comparator.comparing(PhieuDangKyHocPhan::getSoMonDangKy)).limit(10).map(PhieuDangKyHocPhan::getSv).collect(Collectors.toList());
    }

    //Cau 4:Lay ra danh sach cac mon hoc co the mo lop. Mon do co the mo lop
    //khi so luong dang ky hoc mon hoc do lon hon hoac bang soSinhVienToiThieu
    //Chu y : chi quan tam den nhung phieu dang ky hop le
    public List<MonHoc> getDsMonHoc(int soSinhVienToiThieu){
    	List<PhieuDangKyHocPhan> phieuHopLe = this.dsPhieuDangKy.stream()
    			.filter(t -> t.laHopLe())
    			.collect(Collectors.toList());
    	
    	//tao ra Map voi key la mon hoc va value la so don dang ky voi mon hoc do
    	Map<MonHoc, Integer> map = new HashMap<>();
    	phieuHopLe.forEach(t -> t.getDsMonHoc().forEach(monHoc -> {
    												if(map.get(monHoc)==null) {
    													map.put(monHoc, 1);
    												}else{
    													map.put(monHoc, map.get(monHoc)+1);
    												}}));
    	
    	return map.entrySet().stream().filter(t -> t.getValue() >= soSinhVienToiThieu).map(t->t.getKey()).collect(Collectors.toList());
    	
    }

    public void themPhieuDangKyHocPhan(PhieuDangKyHocPhan phieuDangKyHocPhan) {
        this.dsPhieuDangKy.add(phieuDangKyHocPhan);
    }
}
