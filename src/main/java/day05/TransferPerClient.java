package day05;

import java.util.Objects;

public class TransferPerClient {

    private String clientId;
    private int sum;
    private int numberOfTransaction;

    public TransferPerClient(String clientId, int sum, int numberOfTransaction) {
        this.clientId = clientId;
        this.sum = sum;
        this.numberOfTransaction = numberOfTransaction;
    }

    public TransferPerClient(String clientId) {
        this.clientId = clientId;
    }

    public String getClientId() {
        return clientId;
    }

    public int getSum() {
        return sum;
    }

    public void modify (int amount) {
        sum += amount;
        numberOfTransaction++;
    }

    public int getNumberOfTransaction() {
        return numberOfTransaction;
    }

    @Override
    public String toString() {
        return String.format("%s %10d %7d", clientId, sum, numberOfTransaction);
    }
}
