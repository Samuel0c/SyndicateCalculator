package fi.pageshare.simplesyndicatecalculator.logic;

import java.util.HashMap;
import java.util.Set;

public class Product {
    
    private final String name;
    private Double productionPrice;
    private HashMap<Recipient, Integer> recipients;

    public Product(String name, Double productionPrice) {
        this.name = name;
        this.productionPrice = productionPrice;
        this.recipients = new HashMap<>();
    }
    
    public void addRecipient(Recipient r, Integer percentage) {
        this.recipients.put(r, percentage);
    }
    
    public Set<Recipient> setOfRecipients() {
        return this.recipients.keySet();
    }

    public HashMap<Recipient, Integer> getRecipients() {
        return recipients;
    }

    public Double getProductionPrice() {
        return productionPrice;
    }

    public String getName() {
        return name;
    }
    
    
    
    
    
}
