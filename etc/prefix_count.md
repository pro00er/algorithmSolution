## 문제

문자열 배열(string array)이 주어지면, 제일 긴 공통 접두사(prefix)의 길이를 반환해라.
예제)
Input: [“apple”, “apps”, “app”]
Output: 3 // “app”

Input: [“hot”, “happy”]

Output: 1 // “h”

Input: [“hey”, “here”, “heys”]

Output: 2 // “he”

## 풀이 
- 손코딩이라 API 사용이 틀릴 수 있어요
```java
String[] inputs = new String[]{“apple”, “apps”, “ape”};


public countPrefix(String[] inputs){
	int[] asciisum = sumInputsAscii(inputs,getMaxWordLength(inputs));

	String minLengthStr = getMinChar(inputs);

	int prefixCount = 0;
	int sizeInputs = inputs.size()

	for(int i = 0; i < minLengthStr.length(); i++){
	  if (minLength[i] == asciisum[i]/sizeInputs){
	    prefixCount++;
	  }else {
	    return prefixCount;
	  }
	}
	return prefixCount;
}

private int[] sumInputAscii(String[] input, int length){
	int[] sumAscii = new int[](length);
	for(String s : input){
	  for(Char c : s.toChar()){
	    sumAscii[i] = sumAscii[i] + charToAcii(c);
	  }
	}
	return sumAscii;
}

private int getMinchar(String[] input){
	String[] arr = Arrays.stream(input).toArray(String[]::new);
	Arrays.sort(arr, (a, b)->Integer.compare(a.length(), b.length()));
	return arr[0].length();
}

private int charToAcii(char c){
  return (int) c;
}
```

## 결과 
- O(n^2)
- 문자열 크기가 클때 acsciiSum가 int의 범위를 벗어날 수 있음
