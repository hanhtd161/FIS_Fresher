package fis.topic01.pratice01;

public class SelectionSortStrategy implements ISortStrategy {
	
	public void sort(Comparable[] data, int count) {
		for(int i = 0; i < count -1; i++) {
			int minIndex = i;
			for(int j = i+1; j < count; j++) {
				if(data[minIndex].compareTo(data[j]) > 0) {
					minIndex =j;
				}	
			}
			Comparable temp = data[i];
			data[i] = data[minIndex];
			data[minIndex] = temp;
		}
	}

}
