package com.pay.view.model;

public class Deduction {
    private String Finance_Source; // Ист. фин.
    private String Month_Amount; // Сумма за месяц
    private String Period_Amount; // Сумма за период
    private String Payment_Percent; // % к выпл.
    private String Period_Start; // Начало периода
    private String Period_End; // Конец периода
    private String Payment_Flag; // Не выплачивать
    private String Alloc_Code; // Вид назнач./удерж.

    public String getFinance_Source() {
        return Finance_Source;
    }

    public void setFinance_Source(String finance_Source) {
        Finance_Source = finance_Source;
    }

    public String getMonth_Amount() {
        return Month_Amount;
    }

    public void setMonth_Amount(String month_Amount) {
        Month_Amount = month_Amount;
    }

    public String getPeriod_Amount() {
        return Period_Amount;
    }

    public void setPeriod_Amount(String period_Amount) {
        Period_Amount = period_Amount;
    }

    public String getPayment_Percent() {
        return Payment_Percent;
    }

    public void setPayment_Percent(String payment_Percent) {
        Payment_Percent = payment_Percent;
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

    public String getPayment_Flag() {
        return Payment_Flag;
    }

    public void setPayment_Flag(String payment_Flag) {
        Payment_Flag = payment_Flag;
    }

    public String getAlloc_Code() {
        return Alloc_Code;
    }

    public void setAlloc_Code(String alloc_Code) {
        Alloc_Code = alloc_Code;
    }
}
