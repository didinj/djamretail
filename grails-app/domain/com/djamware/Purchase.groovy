package com.djamware

class Purchase {
    
    def springSecurityService
    
    Store store
    Supplier supplier
    Double cost
    Double discount
    Double totalcost
    boolean tax
    Double tcostwithtax
    String notes
    String status
    Date createdate
    Long createby
    Date confirmdate
    Long confirmby
    Date updatedate
    Long updateby
    
    static hasMany = [details:PurchaseDetail]

    static constraints = {
        store blank:false
        supplier blank:false
        cost blank:false
        discount blank:false
        totalcost blank:false
        tax blank:false
        tcostwithtax blank:false
        notes nullable:true,maxLength:255
        status blank:false,inList:["created","confirm","updated"]
        createdate nullable:true
        createby nullable:true
        confirmdate nullable:true
        confirmby nullable:true
        updatedate nullable:true
        updateby nullable:true
        details nullable:true
    }
    
    def beforeInsert() {
        createdate = new Date()
        createby = springSecurityService.currentUser.id
        totalcost = cost+discount
        if(tax==true) {
            tcostwithtax = ((totalcost*10)/100)+totalcost  
        } else {
            tcostwithtax = totalcost
        }
        status = "created"
    }
    
    def beforeUpdate() {
        updatedate = new Date()
        updateby = springSecurityService.currentUser.id
        confirmdate = new Date()
        confirmby = springSecurityService.currentUser.id
    }
}
