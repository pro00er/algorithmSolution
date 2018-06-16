package prefixsums.countdiv;

import java.util.List;

class Solution {

  public int solution(int A, int B, int K) {
    if (isLocal()) {
      runTestCase();
      runExceptionCase();
      runMaxCase();
      runMinCase();
    } else {
//      TODO refactoring function name
      return countRangeMultiple(A,B,K);
    }
    return 0;
  }

  public int countRangeMultiple(int a, int b, int k) {
    return countMultiple(b,k) - countMultiple(a-1,k);
  }

  private int countMultiple(int input,int dividend) {
    return input / dividend;
  }

  private void assertResult(int a, int b, int k, int expected) {
    int actual = countRangeMultiple(a,b,k);
    if (actual != expected) {
      System.out.println(
          "not equals for input " + a + b + k +  ", expected=" + expected + ", actual=" + actual);
    }
  }

  private void runTestCase() {
    assertResult(6, 11,2,3);
  }

  private void runExceptionCase() {
//    assertResult(0, -1);
  }

  private void runMaxCase() {
//    assertResult(4999, 0);
  }

  private void runMinCase() {
//    assertResult(-4999, 0);
  }

  private boolean isLocal() {
    String current_path = System.getProperty("user.dir");
    String localActualPath = "/Users/syo";
    return current_path.startsWith(localActualPath);
  }
}