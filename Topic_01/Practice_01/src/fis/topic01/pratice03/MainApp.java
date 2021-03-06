package fis.topic01.pratice03;

import java.io.FileInputStream;
import java.util.Scanner;

public class MainApp {
	public static void main(String[] args) {
		String url = "E:\\FIS_Fresher\\Topic_01\\Practice_01\\src\\fis\\topic01\\pratice03\\Input.inp";
		try {
			FileInputStream fileInputStream = new FileInputStream(url);
			Scanner scanner = new Scanner(fileInputStream);
			if(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] info = line.split(" ");
				MaiAnTiem maiAnTiem = new MaiAnTiem();
				maiAnTiem.setHp(Integer.valueOf(info[0]));
				maiAnTiem.setD(Integer.valueOf(info[1]));
				maiAnTiem.setS(Integer.valueOf(info[2]));
				maiAnTiem.setT(info[3]);
				System.out.println(maiAnTiem.calculateP());
			}
			scanner.close();
		} catch (Exception e) {
			System.out.println(-1);
		}
	}
}
