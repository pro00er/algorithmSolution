# Problem Link
- [link](http://tech.kakao.com/2017/09/27/kakao-blind-recruitment-round-1/)

## 접근 방법
1. LRUcache 생성
2. input을 탐색하며, hit, missing 구분
 - hit : LRUcache에 있을 경우
     - 현재값 제거
     - +1
 - missing : LRUcache에 없을 경우
     - 탐색한지 제일 오래된 cities 제거 후
     - +5
3. LRUcache에 지금 input값 insert
4. 2,3 반복
