package calculator.service;

import calculator.domain.Numbers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitService {
    public Numbers splitString(String input){
        // '//'으로 시작하는지 확인
        if(input.startsWith("//")){
            return CustomSplit(input); // 커스텀 구분자
        }
        return normalSplit(input); // ,와 : 구분자
    }

    private Numbers CustomSplit(String input) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return new Numbers(matcher.group(2).split(customDelimiter));
        }
        throw new RuntimeException("커스텀 구분자를 사용할 수 없습니다");
    }

    public Numbers normalSplit(String input){
        if(input.contains(":")||input.contains(",")){
            return new Numbers(input.split("[:,]"));
        }
        if(Integer.parseInt(input)>0){
            return new Numbers(new String[]{input});
        }
        throw new RuntimeException("구분자를 사용할 수 없습니다");
    }
}
