package fi.pageshare.simplesyndicatecalculator.logic;

import java.util.Objects;

public class Recipient {
    
    private String name;
    private String address;

    public Recipient(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Recipient)) {
            return false;
        }
        Recipient r = (Recipient) o;
        
        return this.name.equals(r.name) && (this.address == null ? r.address == null : this.address.equals(r.address));
         
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.name);
        hash = 47 * hash + Objects.hashCode(this.address);
        return hash;
    }
    
    
    
}

