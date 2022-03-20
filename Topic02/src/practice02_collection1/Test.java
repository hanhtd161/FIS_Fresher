package practice02_collection1;

public class Test {
	public static void main(String[] args) {
		MonHoc toanHoc = new MonHoc("toan", 1, 2);
		MonHoc toanHoc2 = new MonHoc("toan", 1, 2);
		Diem diem1 = new Diem(toanHoc, 4);
		Diem diem3 = new Diem(toanHoc2, 3);
		SinhVien sVien = new SinhVien("123", "A");
		System.out.println(sVien.themDiem(diem1));
		System.out.println(sVien.getMonDaHoc().contains(diem3));
	}
}
