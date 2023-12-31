package firstrest.shared.transaction;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;

import io.quarkus.arc.DefaultBean;
import io.quarkus.arc.profile.IfBuildProfile;

public class TransactionIdentifierProducer {

    @Produces
    @DefaultBean
    @RequestScoped
    public TransactionIdentifier produceTest() {
        return new TransactionIdentifier("Test-");
    }

    @Produces
    @IfBuildProfile("prod")
    @RequestScoped
    public TransactionIdentifier produceProd() {
        return new TransactionIdentifier("Prod-");
    }

}
