import java.util.Arrays;

public class SecretMap {
    public static void main(String[] args) {
        String[] results = solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28});
        System.out.println(Arrays.equals(results, new String[]{"#####","# # #", "### #", "# ##", "#####"}));

        results = solution(6, new int[]{46, 33, 33 ,22, 31, 50}, new int[]{27 ,56, 19, 14, 14, 10});
        System.out.println(Arrays.equals(results, new String[]{"######", "### #", "## ##", " #### ", " #####", "### # "}));
    }

    /**
     * 1. 배열의 같은 idx의 수를 OR 연산을 수행.
     * 2. 연산한 수를 binaryString으로 변환
     *  - String으로 변환한 후 길이를 확인 한 후 길이가 맞지 않을 경우 앞에 0을 추가
     * 3. 공백은 ' '으로, 1은 '#'으로 치환
     *  - 공백 : 0이 여러개 붙어있어도 그것은 지도에선 하나의 공백이다.
     * @param length
     * @param intArr1
     * @param intArr2
     * @return
     */
    private static String[] solution(int length, int[] intArr1, int[] intArr2) {
        String[] resultMap = new String[length];

        for (int idx = 0; idx < length; idx++) {
            String orResult = orResultString(intArr1[idx], intArr2[idx], length);
            orResult = convertBinaryStringToMap(orResult);
            resultMap[idx] = orResult;
        }

        return resultMap;
    }

    public static String orResultString(int num1, int num2, int length) {
        String binaryString = Integer.toBinaryString(num1 | num2);
        return zeroString(length - binaryString.length()) + binaryString;
    }

    private static String zeroString(int length) {
        if(length == 0)
            return "";

        StringBuffer zeroString = new StringBuffer();
        for (int i = 0; i < length; i++) {
            zeroString.append("0");
        }

        return zeroString.toString();
    }

    public static String convertBinaryStringToMap(String orResult) {
        orResult = orResult.replaceAll("(0+)", "0");
        return orResult.replace("1", "#").replace("0", " ");
    }
}

