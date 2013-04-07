package com.djamware



import grails.test.mixin.*
import org.junit.*


@TestFor(Product)
class ProductTests {
    void testMinPluChar() {
        
        mockDomain(Product)
        
        def product = new Product(plu:"12345678")
        
        assertFalse 'validation should have failed', product.validate()
        
        assertEquals "min", product.errors.plu
    }
}