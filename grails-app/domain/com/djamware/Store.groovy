package com.djamware

class Store {
    
    String storecode
    String storename
    String storeaddress
    String storecity
    String storephone
    String storeemail
    Date createdate
    Date updatedate

    static constraints = {
        storecode blank:false, maxLength:3
        storename blank:false,maxLength:50
        storeaddress blank:false, maxLength:255
        storecity blank:false, maxLength:50
        storephone blank:false, maxLength:20
        storeemail email:true
        createdate validator: {return (it > new Date())}
        updatedate blank:true,nullable:true
    }
    
    def beforeCreate() {
       createdate = new Date() 
    }
    
    def beforeUpdate() {
        updatedate = new Date() 
    }
    
}
