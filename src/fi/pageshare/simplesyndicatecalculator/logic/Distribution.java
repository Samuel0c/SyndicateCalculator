package fi.pageshare.simplesyndicatecalculator.logic;

import java.util.HashMap;
import java.util.ArrayList;

public class Distribution {
    
    private HashMap<Product, Double> revenueFromProducts;
    private Syndicate syndicate;
    private ArrayList<Recipient> recipients;
    private Double developmentFundShare;

    public Distribution(Syndicate s) {
        this.revenueFromProducts = new HashMap<>();
        this.syndicate = s;
        this.recipients = new ArrayList<>();
        this.developmentFundShare = 0.0;
    }

    public Double getDevelopmentFundShare() {
        return developmentFundShare;
    }
    
    
    
    public void addProduct(Product p, Double revenue, int howManySold) {
        double toDevelopmentFund = 0.1 * revenue;
        this.developmentFundShare += toDevelopmentFund;
        this.revenueFromProducts.put(p, revenue - toDevelopmentFund - howManySold * p.getProductionPrice());
    }
    
//    public double developmentFundShare() {
//        double share = 0;
//        for (Product current : this.revenueFromProducts.keySet()) {
//            share += 0.1 * this.revenueFromProducts.get(current);
//        }
//        return share;
//    }

    
    public double syndicateShare() {
        double total = 0;
        for (double current : this.revenueFromProducts.values()) {
            total += current;
        }
        return 0.2 * total;
    }
    
    private double totalAfterReductions (Product p) {
        return (0.9 * this.revenueFromProducts.get(p)) * 0.8;
    }
    
    private double payExcludingSyndicate(Recipient r) {
        double pay = 0;
        for (Product p : this.revenueFromProducts.keySet()) {
            if (p.setOfRecipients().contains(r)) {
                pay += p.getRecipients().get(r) * this.totalAfterReductions(p) / 100;
            }
        }
        return pay;
    }
    
    private double payFromSyndicate(Recipient r) {
        double pay = 0;
        double payPerMember = this.syndicateShare() / this.syndicate.getMembers().size();
        for (Product member : this.syndicate.getMembers()) {
            if (member.setOfRecipients().contains(r)) {
                pay += member.getRecipients().get(r) * payPerMember / 100;
            }
        }
        return pay;
    }
    
    public double pay(Recipient r) {
        return this.payExcludingSyndicate(r) + this.payFromSyndicate(r);
    }

    public ArrayList<Recipient> getRecipients() {
        for (Product p : this.syndicate.getMembers()) {
            for (Recipient current : p.setOfRecipients()) {
                if (!this.recipients.contains(current)) {
                    this.recipients.add(current);
                }
            }
        }
        return recipients;
    }
    
    

    
}

