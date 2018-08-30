package fi.pageshare.simplesyndicatecalculator.logic;

import java.util.ArrayList;

public class Syndicate {
    
    private ArrayList<Product> members;

    public Syndicate() {
        this.members = new ArrayList<>();
    }

    public ArrayList<Product> getMembers() {
        return members;
    }
    
    public void addMember(Product member) {
        this.members.add(member);
    }
    
}

