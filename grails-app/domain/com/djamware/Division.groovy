package com.djamware

class Division {
    
    def springSecurityService
    
    String divname
    static hasMany = [depts:Dept]
    Date createdate
    Long createby
    Date updatedate
    Long updateby

    static constraints = {
        divname blank:false,maxLength:255
        createdate nullable:true
        createby nullable:true
        updatedate nullable:true
        updateby nullable:true
    }
    
    String toString() {
        divcode+" - "+divname
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
