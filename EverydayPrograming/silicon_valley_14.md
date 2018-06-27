## 문제
매일프로그래밍 - 실리콘밸리 패키지 문제 14

## 풀이 
- 가장 짧은 문자길이로 모든 문자들을 자르고
- 문자들을 char 배열로 변경
- 문자위치를 기준으로 훑어가면서 일치하지 않는 위치의 idx의 전 idx를 반환
```sudo

for word in words:
	cutWords = word[:minlength]

minword = cutWords[0]
for idx in range(1,minlength):
	for word in cutWords:
		if word[idx] != minword:
			return idx -1
```

## 결과 
- O(n^2)
	- 문자의 개수 n, min문자의 길이가 가변일 경우
