package calculator.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitService {
    public String[] splitString(String s){
        // '//'으로 시작하는지 확인
        if(s.startsWith("//")){
            return CustomSplit(s); // 커스텀 구분자
        }
        return normalSplit(s); // ,와 : 구분자
    }

    private String[] CustomSplit(String s) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(s);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        throw new RuntimeException("커스텀 구분자를 사용할 수 없습니다");
    }

    public String[] normalSplit(String s){
        if(s.contains(":")||s.contains(",")){
            return s.split("[:,]");
        }
        if(Integer.parseInt(s)>0){
            return new String[]{s};
        }
        throw new RuntimeException("구분자를 사용할 수 없습니다");
    }
}
