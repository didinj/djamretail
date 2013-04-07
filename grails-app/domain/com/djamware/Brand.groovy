package com.djamware

class Brand {
    
    def springSecurityService
    
    String brandname
    static hasMany = [products:Product]
    Date createdate
    Long createby
    Date updatedate
    Long updateby

    static constraints = {
        brandname blank:false,maxLength:255
        createdate nullable:true
        createby nullable:true
        updatedate nullable:true
        updateby nullable:true
    }
    
    String toString() {
        brandname
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
