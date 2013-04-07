package com.djamware

class Product {
    
    def springSecurityService
    
    String plu
    String description
    Brand brand
    Dept dept
    Supplier supplier     
    Integer size
    String unit             // Weight, Pcs, Liter
    Double price
    Double cost
    boolean tax
    boolean consigment
    Integer margin    
    byte[] productimage
    Date createdate
    Long createby
    Date updatedate
    Long updateby

    static constraints = {
        plu blank:false,maxLength:6,unique:true
        description blank:false,maxLength:255
        brand blank:false
        dept blank:false
        supplier blank:false
        size blank:false
        unit inList:["kg","gr","ltr","pcs"]
        price blank:false
        cost blank:false
        tax blank:false
        consigment blank:false
        margin blank:false
        productimage blank:true,nullable:true,maxSize:1024*256
        createdate nullable:true
        createby nullable:true
        updatedate nullable:true
        updateby nullable:true
    }
    
    String toString() {
        plu+" "+description
    }
    
    def beforeInsert() {
        createdate = new Date()
        createby = springSecurityService.currentUser.id
    }
    
    def beforeUpdate() {
        updatedate = new Date()
        updateby = springSecurityService.currentUser.id
    }
}
