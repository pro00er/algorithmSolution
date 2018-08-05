- [NUll](www.google.com)

## 접근 방법


# 첫번 째 방법
    1. while문으로 조건에 만족하는 n,xn값  찾기 ( 2^n < x < 2^n+1)
    2. 찾은 n을 이용하여 for의 조건식을 채운 후 소수 찾기
    3. 소수중에서 middle(중간값)과 가장 가까운 값 찾기
    
## 소스코드

# 내 풀이
~~~java
public int getHashM(int maxK, int collision) {
		int l  = maxK / collision;
		if(l<2){
			return 2;
		}
		int n = 0;
		int xn = 0;
		boolean flag = false;
		//2의 배수에 만족하는 값 찾는 반복문
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
		//소인수 찾기
		int middel = (int)((Math.pow(2, n) + Math.pow(2, n+1))/2);
		int cnt=0;
		int min = 10000;
		int val = 0;
		for(int i=(int)Math.pow(2, n); i<(int)Math.pow(2, n+1) ; i++){
			for(int j=2;j<i;j++){
				if(i%j==0){
					cnt++;
					continue;
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
		return val;
	}
	
	public boolean getN(int key, double d, double e){
		if(d <= key && key <= e){
			return true;
		}
		return false;
	}
~~~

# 공유할 풀이

~~~c
2번
#include <bits/stdc++.h>
 
using namespace std;
 
class Solution{
public:
    int getHashM(int maxK, int collision){
        int N = maxK / collision;
        if(N <= 2) return 2;
        int M;
        for(M = 1; M * 2 <= N; M <<= 1);
        vector<int> P(M*2);
        
        for(int i=2;i*i<M*2;i++){
            for(int j=i+i;j<M*2;j+=i) P[j] = 1;
        }
        int ans = -1, len = 0;
        for(int i=M;i<M*2;i++) if(!P[i]){
            if(min(i-M, M*2-i) > len){
                len = min(i-M, M*2-i);
                ans = i;
            }
        }
        return ans;
    }
};
~~~
## 개선필요한 사항
    1. 코드를 더 스마트 하게 하고 싶다.
    2. 소인수 찾는 부분에서 시간복잡도가 높다.
    3. 2의 배수 값을 찾는 부분을 재귀로 바꾸면 좋을 듯 하다.

## 시간복잡도를 주링기 위해 생각한 점, 반영한 점
    1. 소수 검사를 위하여, 모든 정수와 약수가 되는지 찾지말고 for문에서 찾은 소수로만 약수가 되는지 비교하면 속도가 향상 될 듯 하다.
 
 
## 채점 결과
| Task Score | Correctness | Performance | 
| ------------ | ------------- | ------------- |
| 100% | 100% | 100% |
