package firstrest.shared.transaction;

public class TransactionLogger {

    public static void log(TransactionIdentifier transactionIdentifier) {
        System.out.println(transactionIdentifier.getIdentifier());
    }

}
