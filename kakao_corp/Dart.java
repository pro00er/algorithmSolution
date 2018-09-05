import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dart {
    public static void main(String[] args) {
        System.out.println(solution("1S2D*3T") == 37);
        System.out.println(solution("1D2S0T") == 3);
        System.out.println(solution("1S*2T*3S") == 23);
        System.out.println(solution("1D#2S*3S") == 5);
        System.out.println(solution("1D2S3T*") == 59);
        System.out.println(solution("1D2S#10S") == 9);
        System.out.println(solution("1T2D3D#") == -4);
    }

    private static int solution(String dartLog) {
        Matcher matcher = Pattern.compile("([1]{0,1}[0-9])([STD])([\\#\\*]{0,1})").matcher(dartLog);
        int totalScore = 0;

        int afterScore = 0;
        while (matcher.find()) {
            int nowScore = Integer.parseInt(matcher.group(1));
            nowScore = squre(nowScore, matcher.group(2));

            int optionNumber = convertOptionNumber(matcher.group(3));
            if(optionNumber == 2)
                afterScore *= optionNumber;

            totalScore += afterScore;
            afterScore = nowScore * optionNumber;
        }

        totalScore += afterScore;
        return totalScore;
    }

    private static int convertOptionNumber(String optionType) {
        if ("*".equals(optionType))
            return 2;
        if ("#".equals(optionType))
            return -1;
        return 1;
    }

    private static int squre(int nowScore, String areaType) {
        switch (areaType) {
            case "S" : return nowScore;
            case "D" : return nowScore * nowScore;
            case "T" : return nowScore * nowScore * nowScore;
            default: return nowScore;
        }
    }


}
