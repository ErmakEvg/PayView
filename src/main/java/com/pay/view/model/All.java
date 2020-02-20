package com.pay.view.model;

public class All {
    private String Alloc_Code; //Вид удерж./назнач.
    private String Finance_Source; //Источник Финансирования
    private String Amount_Deduction;//Сумма удержания
    private String Amount_Recipient;//Сумма получателю
    private String Amount_Payment;//Сумма к выпл.
    private String Libilities;//Задолж. по удерж.
    private String Overpayment;//Переплата
    private String Post_Amount;//Сумма за почт. усл.
    private String Period_Start;//Начало периода
    private String Period_End;//Конец периода
    private String Post_Liab;//Задолж. за почт. усл.
    private String Alloc_Code_Alloc;//Вид назначения

    public String getAlloc_Code() {
        return Alloc_Code;
    }

    public void setAlloc_Code(String alloc_Code) {
        Alloc_Code = alloc_Code;
    }

    public String getFinance_Source() {
        return Finance_Source;
    }

    public void setFinance_Source(String finance_Source) {
        Finance_Source = finance_Source;
    }

    public String getAmount_Deduction() {
        return Amount_Deduction;
    }

    public void setAmount_Deduction(String amount_Deduction) {
        Amount_Deduction = amount_Deduction;
    }

    public String getAmount_Recipient() {
        return Amount_Recipient;
    }

    public void setAmount_Recipient(String amount_Recipient) {
        Amount_Recipient = amount_Recipient;
    }

    public String getAmount_Payment() {
        return Amount_Payment;
    }

    public void setAmount_Payment(String amount_Payment) {
        Amount_Payment = amount_Payment;
    }

    public String getLibilities() {
        return Libilities;
    }

    public void setLibilities(String libilities) {
        Libilities = libilities;
    }

    public String getOverpayment() {
        return Overpayment;
    }

    public void setOverpayment(String overpayment) {
        Overpayment = overpayment;
    }

    public String getPost_Amount() {
        return Post_Amount;
    }

    public void setPost_Amount(String post_Amount) {
        Post_Amount = post_Amount;
    }

    public String getPeriod_Start() {
        return Period_Start;
    }

    public void setPeriod_Start(String period_Start) {
        Period_Start = period_Start;
    }

    public String getPeriod_End() {
        return Period_End;
    }

    public void setPeriod_End(String period_End) {
        Period_End = period_End;
    }

    public String getPost_Liab() {
        return Post_Liab;
    }

    public void setPost_Liab(String post_Liab) {
        Post_Liab = post_Liab;
    }

    public String getAlloc_Code_Alloc() {
        return Alloc_Code_Alloc;
    }

    public void setAlloc_Code_Alloc(String alloc_Code_Alloc) {
        Alloc_Code_Alloc = alloc_Code_Alloc;
    }
}
