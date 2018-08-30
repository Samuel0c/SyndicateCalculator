/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junitTests;

import fi.pageshare.simplesyndicatecalculator.logic.Product;
import fi.pageshare.simplesyndicatecalculator.logic.Recipient;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTest {
    
    private Product product;
    private Recipient stubTestiHenkilo;
    private Recipient stubToinenHenkilo;

    
//    @Before
//    public void setUp() {
//        product = new Product("testiTuote", 10.0);
//        stubTestiHenkilo = new Recipient("Testi Henkilö", "puuttuu");
//        stubToinenHenkilo = new Recipient("Toinen Henkilö", "puuttuu");
//    }

    @Test
    public void addingRecipientsSuccessfullyToTheMapOfRecipients() {
        product.addRecipient(stubTestiHenkilo, 60);
        product.addRecipient(stubToinenHenkilo, 40);
        assertEquals(2, product.setOfRecipients().size());
    }
    
    
    
}
