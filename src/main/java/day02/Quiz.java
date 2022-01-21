package day02;

import java.io.IOException;
import java.lang.reflect.AnnotatedArrayType;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.util.*;

public class Quiz {

    private static final String SEPARATOR = " ";

    private Map<String, List<Character>> playersAndAnswers = new HashMap<>();

    private List<Character> solutions;

    public void readFile(Path path) {
        try (Scanner scanner = new Scanner(path)) {
            solutions = getSolutionListFromString(scanner.nextLine());

            while (scanner.hasNextLine()) {
                String[] fields = scanner.nextLine().split(SEPARATOR);
                if (!playersAndAnswers.containsKey(fields[0])) {
                    playersAndAnswers.put(fields[0], new ArrayList<>());
                }
                playersAndAnswers.get(fields[0]).add(fields[1].charAt(0));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Error while working");
        }
    }

    public boolean checkAnswers(String code, int index) {
        return playersAndAnswers.get(code).get(index - 1) == solutions.get(index - 1);
    }

    public String getBestPlayer() {
        Map<String, Integer> playerAndPoint = new HashMap<>();

        for (Map.Entry<String, List<Character>> entry : playersAndAnswers.entrySet()) {
            if (!playerAndPoint.containsKey(entry.getKey())) {
                playerAndPoint.put(entry.getKey(), 0);
            }
            for (int i = 0; i < solutions.size(); i++) {
                if (checkAnswers(entry.getKey(), i + 1)) {
                    playerAndPoint.put(entry.getKey(), playerAndPoint.get(entry.getKey()) + i + 1);
                }

            }
        }
        String bestPlayer = "";
        int bestResult = 0;
        for (Map.Entry<String, Integer> entry : playerAndPoint.entrySet()) {
            if (bestResult < entry.getValue()) {
                bestResult = entry.getValue();
                bestPlayer = entry.getKey();
            }
        }
        return bestPlayer;
    }

    private List<Character> getSolutionListFromString(String solutionLine) {
        List<Character> result = new ArrayList<>();
        for (Character c : solutionLine.toCharArray()) {
            result.add(c);
        }
        return result;
    }

    public static void main(String[] args) {
        Path path = Path.of("src/main/resources/result.txt");
        Quiz quiz = new Quiz();
        quiz.readFile(path);
        System.out.println(quiz.playersAndAnswers);
        System.out.println(quiz.solutions);
        System.out.println(quiz.checkAnswers("AB123", 1));
        System.out.println(quiz.checkAnswers("AB123", 5));
        System.out.println(quiz.getBestPlayer());
    }
}
