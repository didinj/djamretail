package com.djamware

class Dept {
    
    def springSecurityService
    
    Division division
    String deptname
    static hasMany = [products:Product]
    Date createdate
    Long createby
    Date updatedate
    Long updateby

    static constraints = {
        division blank:false
        deptname blank:false,maxLength:255
        createdate nullable:true
        createby nullable:true
        updatedate nullable:true
        updateby nullable:true
    }
    
    String toString() {
        deptname
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
