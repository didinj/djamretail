package com.djamware

class Payment {
    
    Sales sales
    String paytype
    String cardnumber
    Double payamount
    Double cashamount
    Double changes

    static constraints = {
        paytype blank:false,inList:["Cash","Debit","Visa","Master"]
        cardnumber nullable: true, maxLength:20
        payamount blank:false
        cashamount blank:false
        changes blank:false
    }
}
