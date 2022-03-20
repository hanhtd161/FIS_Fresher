package pratice02_collection2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BangDiem {
    private List<Diem> dsDiem = new ArrayList<Diem>();

    public List<Diem> getDsDiem() {
		return dsDiem;
	}

	public void setDsDiem(List<Diem> dsDiem) {
		this.dsDiem = dsDiem;
	}

	public void themDiem(Diem diem){
        this.dsDiem.add(diem);
    }
	
	public boolean kiemTraQuaMon(MonHoc monHoc){
		Optional<Diem> diem = this.dsDiem.stream().filter(t -> t.getMonHoc().equals(monHoc)).findAny();
        if(diem.isPresent() && diem.get().isPassed()) {
        	return true;
        }
        return false;
	}
}
