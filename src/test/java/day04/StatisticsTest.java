package day04;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsTest {

    @Test
    void testStatistics(){
        Statistics statistics = new Statistics();
        Map<Character,Integer> result =statistics.getStatistic("BlaBlaaa");
        System.out.println(result);

        assertEquals(4,result.get('a'));
    }

}