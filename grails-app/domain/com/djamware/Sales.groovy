package com.djamware

class Sales {
    
    Store store
    Integer shift
    Integer posnbr
    Long salesby
    Date trndate
    Date trntime
    String trntype
    Integer saleqty
    Double price
    Double discamount
    Double grossale
    Double tax
    Double netsale
    
    static hasMany = [salesdetails:SalesDetail]
    static hasOne = [payment:Payment]

    static constraints = {
        store blank:false
        shift blank:false
        posnbr blank:false
        trndate blank:false
        trntime blank:false
        trntype blank:false
        saleqty blank:false
        price blank:false
        discamount blank:false
        grossale blank:false
        tax blank:false
        netsale blank:false
    }
}
