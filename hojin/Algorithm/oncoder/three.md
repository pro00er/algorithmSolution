- [NUll](www.google.com)

## 접근 방법


# 첫번 째 방법
    1. parserCharToInt() : 인코딩 작업 (문제에서 제시 한)
    2. toBinaryString : 2진수 변환
    3. parserBinaryTo6bit : 6비트씩 묶기
    4.lastAddZero : 8개씩 묶어서 해석할 수 있도록, 마지막에 "0"을 추가하여 8의 배수로 변경
## 소스코드

# 내 풀이
~~~java
public String encoder(String message){
		char[] messageChar = message.toCharArray();
		int[] encoder = new int[message.length()];
		String binaryStr = "";
		String total = "";
		for(int i=0; i<message.length();i++){
			encoder[i] = this.parserCharToInt(messageChar[i]);
			binaryStr = Integer.toBinaryString(encoder[i]);
			total += this.parserBinaryTo6bit(binaryStr);
		}
		total = this.lastAddZero(total);
		String[] hex = new String[total.length()/8];
		int start=0;
		String result="";
		int temp10=0;
		String hexStr="";
		
		for(int i=0;i<hex.length;i++){
			hex[i] = total.substring(start,start+8);
			start += 8;
			temp10 = Integer.parseInt(hex[i],2);
			hexStr = Integer.toHexString(temp10);
			if(temp10<16){
				result += "0"+hexStr;
			}else{
				result +=hexStr;
			}
		}
        return result.toUpperCase();
    }
	public String lastAddZero(String str){
		int zeroCnt = 8 - (str.length()%8);
		if(zeroCnt == 8){
			return str;
		}
		String retrunStr = "";
		while(zeroCnt > 0){
			retrunStr += "0";
			zeroCnt--;
		}
		return str+retrunStr;
	}
	public String parserBinaryTo6bit(String binaryStr){
		if(binaryStr.length()>1){
			if(binaryStr.indexOf("0")==0){
				binaryStr = binaryStr.substring(1,binaryStr.length());
			}
		}
		int zeroCnt = 6-binaryStr.length();
		String retrunStr = "";
		while(zeroCnt > 0){
			retrunStr += "0";
			zeroCnt--;
		}
		return retrunStr+binaryStr;
	}
	
	public int parserCharToInt(char val){
		int checkVal = val;
		if(checkVal >= 97 && checkVal <=122){
			return checkVal-97;
		}else if(checkVal >= 65 && checkVal <=90){
			return checkVal-39;
		}else if(checkVal >= 48 && checkVal <=57){
			return checkVal+4;
		}else{
			return 62;
		}
	}
~~~

# 공유할 풀이
~~~c
4번
#include <string>
#include <bits/stdc++.h>
 
using namespace std;
 
//핵심 소스코드의 설명을 주석으로 작성하면 평가에 큰 도움이 됩니다.
class Solution{
public:
    string encoder(string message){
        vector<int> num(255);
        for(int i='a';i<='z';i++) num[i] = i - 'a' + 0;
        for(int i='A';i<='Z';i++) num[i] = i - 'A' + 26;
        for(int i='0';i<='9';i++) num[i] = i - '0' + 52;
        char TTT[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        vector<char> hex(TTT, TTT + 16);
        num[' '] = 62;
        int current = 0, cnt = 0, cntt = 0;
        string ans;
        for(int i=0;message[i];i++){
            int k = num[message[i]];
            //printf("%d\n",k);
            for(int j=5;j>=0;j--){
                current = (current << 1) | (((k&(1<<j))>>j)&1);
                cnt++;
                cntt++;
                //printf("%d %x %d\n",j, current, (((k&(1<<j))>>j)&1));
                if(cnt == 4){
                    ans += hex[current];
                    cnt = current = 0;
                }
                if(cntt == 8) cntt = 0;
            }
        }
        if(cnt){
            current <<= 4 - cnt;
            ans += hex[current];
        }
        if(cntt && cntt<=4) ans += '0';
        
        return ans;
    }
};

~~~
## 개선필요한 사항
    1. 코드를 더 스마트 하게 하고 싶다.
    2. 2진수 10진수 16진수 변경을 조금 더 스마트 하게 하고 싶다.

## 시간복잡도를 주링기 위해 생각한 점, 반영한 점
 
 
## 채점 결과
| Task Score | Correctness | Performance | 
| ------------ | ------------- | ------------- |
| 100% | 100% | 100% |
