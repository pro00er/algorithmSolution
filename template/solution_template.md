## 파일 구조
- 플랫폼 폴더 구조 하위에 파일 작성 (e.g. codility/)
  - 영문명이 있을 경우 영문명으 소문자 사용
  - 영문명이 없을 경우 한글 사용

## Solution 설명 양식
- [참고파일 algorithmSolution/template/solution.md](/template/solution.md)

## Solution code 양식
- 문제를 찾을 수 있는 이름을 스네이크 표기로 명명후 코드 작성자의 이름 추가
  - e.g) codility/prefixsums_PassingCars_ksno.java

## Solution 파일 내부 구조
- 문제풀이 메인 소스코드의 메서드명은 *solution*으로 통일
- 테스트 케이스는 *testcase* 이너 클래스를 만들어 소스코드 파일에서 공유
```java
public class AlgoCodeTemplate {
	public int solution() {
		return 0;
	}
	
	class AlgoCodeTemplateTest {
		
		@Test
		public void solutionTest() {
			AlgoCodeTemplate template = new AlgoCodeTemplate();
			assertEquals(template.solution(),0);
		}
	}
}
```
