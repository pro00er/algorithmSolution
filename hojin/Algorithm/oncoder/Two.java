package oncoder;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.ValidationEvent;

public class Two {

	static public void main(String[] args) {
//		new Two().getHashM(1007,3);
		System.out.println(new Two().getHashM(88445,10));
	}

	public int getHashM(int maxK, int collision) {
		int l  = maxK / collision;
		if(l<2){
			return 2;
		}
		int n = 0;
		int xn = 0;
		boolean flag = false;
		while(true){
			if(this.getN(l, Math.pow(2, n),Math.pow(2, n+1))){
				flag = true;
			}
			if(flag){
				if(this.getN(l, Math.pow(2, n+1),Math.pow(2, n+2))){
					flag = false;
				}else{
					xn = n;
					break;
				}
			}
			n++;
		}
		//소수 찾기
		int middel = (int)((Math.pow(2, n) + Math.pow(2, n+1))/2);
		int cnt=0;
		int min = 10000;
		int val = 0;
		List<Integer> valList = new ArrayList<Integer>();
		valList.add(2);
		for(int i=(int)Math.pow(2, n); i<(int)Math.pow(2, n+1) ; i++){
			for(int j=0;j<valList.size();j++){
				if(i%(valList.get(j)) ==0){
					break;
				}
				if(j+1 == valList.size()){
					valList.add(i);
				}
			}
			if(cnt==0){
				if(min >  Math.abs( middel-i)){
					min = Math.abs( middel-i);
					val = i;
				}
			}
			cnt=0;
		}
		for(int temp:valList){
			if(min >  Math.abs( middel-temp)){
				min = Math.abs( middel-temp);
				val = temp;
			}
		}
		return val;
	}
	
	public boolean getN(int key, double d, double e){
		if(d <= key && key <= e){
			return true;
		}
		return false;
	}
//	public int getHashM(int maxK, int collision) {
//		int l  = maxK / collision;
//		if(l<2){
//			return 2;
//		}
//		int n = 0;
//		int xn = 0;
//		boolean flag = false;
//		while(true){
//			if(this.getN(l, Math.pow(2, n),Math.pow(2, n+1))){
//				flag = true;
//			}
//			if(flag){
//				if(this.getN(l, Math.pow(2, n+1),Math.pow(2, n+2))){
//					flag = false;
//				}else{
//					xn = n;
//					break;
//				}
//			}
//			n++;
//		}
//		//소인수 찾기
//		int middel = (int)((Math.pow(2, n) + Math.pow(2, n+1))/2);
//		int cnt=0;
//		int min = 10000;
//		int val = 0;
//		for(int i=(int)Math.pow(2, n); i<(int)Math.pow(2, n+1) ; i++){
//			for(int j=2;j<i;j++){
//				if(i%j==0){
//					cnt++;
//					continue;
//				}
//			}
//			if(cnt==0){
//				if(min >  Math.abs( middel-i)){
//					min = Math.abs( middel-i);
//					val = i;
//				}
//			}
//			cnt=0;
//		}
//		return val;
//	}
//	
//	public boolean getN(int key, double d, double e){
//		if(d <= key && key <= e){
//			return true;
//		}
//		return false;
//	}

}
