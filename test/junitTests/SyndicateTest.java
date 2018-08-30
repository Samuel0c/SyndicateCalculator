/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junitTests;

import fi.pageshare.simplesyndicatecalculator.logic.Product;
import fi.pageshare.simplesyndicatecalculator.logic.Syndicate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class SyndicateTest {
    
    private Syndicate syndicate;
    private Product stubProduct;
    private Product anotherStubProduct;
    
//    @Before
//    public void setUp() {
//        syndicate = new Syndicate();
//        stubProduct = new Product("Photograph", 10.0);
//        anotherStubProduct = new Product("Book", 15.0);
//    }
    
    @Test
    public void addingMembersSuccessfullyToTheList() {
        syndicate.addMember(stubProduct);
        syndicate.addMember(anotherStubProduct);
        assertEquals(2, syndicate.getMembers().size());
    }
    
}
