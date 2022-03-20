package fis.topic01.pratice01;

public class BubbleSortStrategy implements ISortStrategy {

	@Override
	public void sort(Comparable[] data, int count) {
		for(int i = 0; i < count; i++) {
			for(int j = 0; j < count-i-1; j++) {
				if(data[j].compareTo(data[j+1]) > 0) {
					Comparable temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp;
				}	
			}
		}

	}

}
