package countingElement.ForgRiverOne;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {

  public int solution(int[] A) {
    if (isLocal()) {
      runTestCase();
      runExceptionCase();
      runMaxCase();
      runMinCase();
    } else {
//      TODO refactoring function name
      findMissingInt(A);
    }
    return 0;
  }

  public int findMissingInt(int[] s) {

    Set<Integer> notDuplicateInput = new HashSet<Integer>(Arrays.stream(s).boxed().collect( Collectors.toList() ));
    if(Collections.min(notDuplicateInput) < 0){
      return 1;
    }

    int max = Collections.max(notDuplicateInput);

    int actualSum = (max + 1) / (max/2);
    int sum = notDuplicateInput.stream().mapToInt(Integer::intValue).sum();

    return actualSum - sum;
  }

  private void assertResult(int[] input, int expected) {
    int actual = findMissingInt(input);
    if (actual != expected) {
      System.out.println(
          "not equals for input " + input + ", expected=" + expected + ", actual=" + actual);
    }
  }

  private void runTestCase() {
    assertResult(null, 0);
  }

  private void runExceptionCase() {
    assertResult(null, 0);
  }

  private void runMaxCase() {
    assertResult(null, 0);
  }

  private void runMinCase() {
    assertResult(null, 0);
  }

  private boolean isLocal() {
    String current_path = System.getProperty("user.dir");
    //TODO change localActualPath
    String localActualPath = "/Users/syo";
    return current_path.startsWith(localActualPath);
  }
}