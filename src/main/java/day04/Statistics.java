package day04;

import java.util.Map;
import java.util.TreeMap;

public class Statistics {
     private static final String vowel ="aeiouAEIOU";

    public  Map<Character,Integer> getStatistic (String s) {
        Map<Character,Integer> statistic = new TreeMap<>();
        for (Character c: s.toCharArray()) {
            if (vowel.contains(String.valueOf(c))) {

                if (!statistic.keySet().contains(c)) {
                    statistic.put(c, 0);
                }
                statistic.put(c, statistic.get(c) + 1);
            }
        }
        return statistic;
    }
}
