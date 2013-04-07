package com.djamware

class Supplier {
    
    def springSecurityService
    
    String suppcode
    String suppname
    String suppaddress
    String suppcity
    String suppphone
    String suppemail
    String contactperson
    String accountnumber
    String bankname
    Date createdate
    Long createby
    Date updatedate
    Long updateby
    
    static hasMany = [products:Product]

    static constraints = {
        suppcode blank:false,maxLength:4
        suppname blank:false,maxLength:255
        suppaddress blank:true,nullable:true,maxLength:255
        suppcity blank:true,maxLength:50
        suppphone blank:false,maxLength:20
        suppemail email:true
        contactperson blank:true,nullable:true,maxLength:255
        accountnumber blank:false,maxLength:20
        bankname blank:false,maxLength:255
        createdate nullable:true
        createby nullable:true
        updatedate nullable:true
        updateby nullable:true
    }
    
    String toString() {
        suppname
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
