package com.djamware

class PurchaseDetail {
    
    Purchase purchase
    Product product
    Integer qty
    Integer discpercent
    Double discamount
    Double totalcost
    boolean tax
    Double totalwithtax

    static constraints = {
        qty blank:false
        discpercent blank:false
        discamount nullable:true
        totalcost nullable:true
        tax blank:false
        totalwithtax nullable:true
    }
    
    def beforeInsert() {
        discamount = (product.cost*discpercent)/100
        totalcost = (product.cost-discamount)*qty
        if(tax==true) {
            totalwithtax = ((totalcost*10)/100)+totalcost
        } else {
            totalwithtax = totalcost
        }
    }
}
