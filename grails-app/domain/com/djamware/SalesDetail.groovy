package com.djamware

class SalesDetail {
    
    static belongsTo = [sales:Sales]
    String plu
    Integer qty
    Double price
    Double tprice
    Double discount
    Double grossale
    Double tax
    Double netsale

    static constraints = {
        plu blank:false
        qty blank:false
        price blank:false
        tprice blank:false
        discount blank:false
        grossale blank:false
        tax blank:false
        netsale blank:false
    }
}
