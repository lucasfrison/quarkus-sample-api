package firstrest.shared.transaction;

import java.time.Instant;
import java.util.Random;

public class TransactionIdentifier {

    private final String prefix;
    private final int transactionId;
    private final Instant start;

    public TransactionIdentifier(String prefix) {
        super();
        this.prefix = prefix;
        this.transactionId = new Random().nextInt();
        this.start = Instant.now();
    }

    public String getIdentifier() {
        return prefix + transactionId + " - " + start;
    }

}
