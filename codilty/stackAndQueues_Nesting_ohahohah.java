import java.util.Stack;

class Solution {

  final static int RIGHT_FORMAT = 1;
  final static int WRONG_FORMAT = 0;
  final static char OPEN_BRACKET = '(';
  final static char CLOSE_BRACKET = ')';

  public int solution(String S) {
    if (isLocal()) {
      runTestCase();
      runExceptionCase();
    } else {
      return checkBracketFormat(S);
    }
    return 0;
  }

  public int checkBracketFormat(String S) {
    char[] inputs = S.toCharArray();
    Stack<Character> stack = new Stack<>();

    for (char c : inputs) {
      if (c == OPEN_BRACKET) {
        stack.push(c);
      } else if (c == CLOSE_BRACKET) {
        if (stack.empty()) {
          return WRONG_FORMAT;
        }
        if (stack.pop() != OPEN_BRACKET) {
          return WRONG_FORMAT;
        }
      }
    }
    if (stack.isEmpty()) {
      return RIGHT_FORMAT;
    }
    return WRONG_FORMAT;
  }

  private void assertResult(String s, int expected) {
    int actual = checkBracketFormat(s);
    if (actual != expected) {
      System.out.println(
          "not equals for input " + s + ", expected=" + expected + ", actual=" + actual);
    }
  }

  private void runTestCase() {
    assertResult("()", RIGHT_FORMAT);
    assertResult("(())", RIGHT_FORMAT);
    assertResult("(()())", RIGHT_FORMAT);

    assertResult("(()(())())", RIGHT_FORMAT);

  }

  private void runExceptionCase() {
    assertResult("(", WRONG_FORMAT);
    assertResult("((", WRONG_FORMAT);
    assertResult("())", WRONG_FORMAT);
    assertResult("))", WRONG_FORMAT);
  }

  private boolean isLocal() {
    String current_path = System.getProperty("user.dir");
    String localActualPath = "/Users/syo";
    return current_path.startsWith(localActualPath);
  }
}