package codility;

class Solution {

  public int solution(int A) {
    if (isLocal()) {
      runTestCase();
      runExceptionCase();
      runMaxCase();
      runMinCase();
    } else {
//      TODO refactoring function name
      something(A);
    }
    return 0;
  }

  public int something(int s) {
    //stub
    return -1;
  }

  private void assertResult(int input, int expected) {
    int actual = something(input);
    if (actual != expected) {
      System.out.println(
          "not equals for input " + input + ", expected=" + expected + ", actual=" + actual);
    }
  }

  private void runTestCase() {
    assertResult(1, 0);
    assertResult(2, 1);
    assertResult(3, 3);
    assertResult(4, 6);
    assertResult(5, 10);
    assertResult(6, 15);
    assertResult(7, 21);
  }

  private void runExceptionCase() {
    assertResult(0, -1);
  }

  private void runMaxCase() {
    assertResult(4999, 0);
  }

  private void runMinCase() {
    assertResult(-4999, 0);
  }

  private boolean isLocal() {
    String current_path = System.getProperty("user.dir");
    //TODO change localActualPath
    String localActualPath = "/Users/mac";
    return current_path.startsWith(localActualPath);
  }
}