package day05;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class transferAggregator {

    private static final String SEPARATOR = ",";
    List<TransferPerClient> transfersList = new ArrayList<>();
    Map<String, TransferPerClient> transfersMap = new TreeMap<>();

    private void readFileAndSummarize(Path path) {
        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNextLine()) {
                String[] fields = scanner.nextLine().split(SEPARATOR);
                String source = fields[0];
                String target = fields[1];
                int amount = Integer.parseInt(fields[2]);

                putToMap(source, amount * -1);
                putToMap(target, amount);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Error while reading file!");
        }
    }

    private void putToMap(String id, int amount) {
        TransferPerClient actual = transfersMap.get(id);
        if (actual == null) {
            actual = new TransferPerClient(id);
            transfersMap.put(id, actual);
        }
        actual.modify(amount);
    }

    private void transferListBuilder() {
        for (TransferPerClient actual : transfersMap.values()) {
            transfersList.add(actual);
        }
    }

    public static void main(String[] args) {
        transferAggregator transactions = new transferAggregator();
        Path path = Path.of("src/main/resources/transfers.csv");

        transactions.readFileAndSummarize(path);
        transactions.transferListBuilder();

        transactions.transfersList.forEach(transfers -> System.out.println(transfers)); // akkor már lambdás kiírás
    }
}
