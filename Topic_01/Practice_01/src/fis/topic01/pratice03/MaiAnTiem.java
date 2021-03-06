package fis.topic01.pratice03;

import java.util.Arrays;
import java.util.List;

public class MaiAnTiem {
	private int hp;
	private int d;
	private int s;
	private String t;
	
	public MaiAnTiem() {
	}
	
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public int getS() {
		return s;
	}

	public void setS(int s) {
		this.s = s;
	}

	public String getT() {
		return t;
	}

	public void setT(String t) {
		this.t = t;
	}

	public MaiAnTiem(int hp, int d, int s, String t) {
		this.hp = hp;
		this.d = d;
		this.s = s;
		this.t = t;
	}
	public boolean validateInfo() {
		if( hp < 1 || hp > 999) {
			return false;
		}
		if( d < 1 || d > 1000) {
			return false;
		}
		if( s < 1 || s > 100) {
			return false;
		}
		String[] array =  {"Flood","Storm","Rain","Shower","Drizzle","Cloudy"};
		List<String> list = Arrays.asList(array);
		if(!list.contains(t)) {
			return false;
		}
		return true;
	}
	public double calculateGs() {
		int a = s % 6;
		double gs = 0;
		switch (a) {
		case 0: 
			gs = s/2;
			break;
		
		case 1: 
			gs = 2*s;
			break;
		
		case 2: 
			gs = - Math.pow((s%9),3)/5;
			break;
		
		case 3: 
			gs =- Math.pow((s%30),2) + 3*s;
			break;
		
		case 4: 
			gs = -s;
			break;
		
		case 5: 
			gs = - Helper.calculateTriangularNumber((s%5)+5);
			break;
		
		default: 
			gs = s/2;
			break;
		}
		return gs;
	}
	public double calculatePt(String t, int s) {
		String[] arrayStrings = {"Flood","Storm","Rain","Shower","Drizzle","Cloudy"};
		int i = 0;
		while(!arrayStrings[i].equals(t)) {
			i ++;
		}
		int[] fruitCodes = {5,4,0,1,2,3};
		int fruitCode = s%6;
		int j = 0;
		while(fruitCodes[j] != fruitCode) {
			j++;
		}
		return -5 * (j-i) / 100;
	}
	public double calculateP() {
		if(!validateInfo()) {
			return -1;
		}
		int P1,P2;
		double fdst;
		if(Helper.isPrime(hp)){
			P1 = 1000;
			P2 = (hp + s) % 1000;
		} else {
			P1 = hp;
			P2 = (hp + d) % 100;
		}
		if(d<200 && !Helper.isFibonacci(d+s)) {
			fdst = 0;
		} else if(d > 800) {
			fdst = -d * s / 1000.0;
		} else {
			if(d >= 200 && d < 300) {
				double bittenPercent = (d+P1+P2)/1000;
				if(bittenPercent > 0.8) {
					return 0;
				}
				if(bittenPercent > 0.6 && bittenPercent <= 0.8) {
					hp = hp - 50;
				}
				if(bittenPercent > 0.4 && bittenPercent <= 0.6) {
					hp = hp - 30;
				}
				if(bittenPercent > 0.2 && bittenPercent <= 0.4) {
					hp = hp - 20;
				}
				if(Helper.isPrime(hp)){
					P1 = 1000;
					P2 = (hp + s) % 1000;
				} else {
					P1 = hp;
					P2 = (hp + d) % 100;
				}
			}
			double gs = calculateGs();
			double pt = calculatePt(t,s);
			fdst = (40 - Math.abs(d - 500) / 20 + gs)*(1 + pt);
			
		}
		System.out.println(fdst);
		double P = (P1 + P2 * fdst)/ (1000 + Math.abs(P2 * fdst));
		if(P > 1) {
			return 1;
		}
		if(P < 0) {
			return 0;
		}
		return Math.round(P*1000)/1000.0;
	}
	
}
