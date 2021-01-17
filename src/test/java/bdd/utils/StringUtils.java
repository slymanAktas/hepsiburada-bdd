package bdd.utils;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringUtils {
    public static String capitelizeOnlyFirstLetter(String text){
        return Arrays.stream(text.toLowerCase().split(" ")).map(org.apache.commons.lang3.StringUtils::capitalize).collect(Collectors.joining(" "));
    }
}
