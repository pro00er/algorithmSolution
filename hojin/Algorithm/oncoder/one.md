- [NUll](www.google.com)

## 접근 방법


# 첫번 째 방법
    1. 아스키코드값을 이용하여 대소문자 구분
    

## 소스코드

# 내 풀이
~~~java
public String decryptSpell(String str){
		if(str.length()<1 || str.length()>100){
			return "";
		}
		if(str.length()==2){
			return str;
		}
		
		char[] charArray = str.toCharArray();
		char[] resultChar = str.toCharArray();
		for(int i=2; i<charArray.length;i+=3){
			if((int)charArray[i] >= 97 &&
					(int)charArray[i] <=122){
				//소문자다 
				//대문자로 변경
				resultChar[i] = (char) ((char)((int)charArray[i])-(32));
			}else{
				//느낌표로 변경
				resultChar[i] = '!';
			}
		}
        return String.valueOf(resultChar);
    }
~~~

# 공유 할 풀이

~~~c
#include <string>
#include <bits/stdc++.h>
 
using namespace std;
 
//핵심 소스코드의 설명을 주석으로 작성하면 평가에 큰 도움이 됩니다.
class Solution{
public:
    string decryptSpell(string str){
        for(int i=0;str[i];i++){
            if(i%3 != 2) continue;
            printf("%c %d\n",str[i], str[i]);
            if('a' <= str[i] && str[i] <= 'z') str[i] ^= 0x20;
            else str[i] = '!';
        }
        return str;
    }
};
~~~
## 개선필요한 사항
    1. 코드를 더 스마트 하게 하고 싶다.
 

## 시간복잡도를 주링기 위해 생각한 점, 반영한 점
 
 
## 채점 결과
| Task Score | Correctness | Performance | 
| ------------ | ------------- | ------------- |
| 100% | 100% | 100% |
