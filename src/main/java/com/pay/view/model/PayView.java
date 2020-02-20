package com.pay.view.model;

import java.util.Date;

public class PayView {
    private String period; // Мес. выпл.
    private String total_payment; // № расч.
    private String payroll_no; // № вед.
    private String case_num; // № дела
    private String fio; // Получатель
    private String birth_date; // Дата рожд.
    private String lik; // Идентиф. номер.
    private String finance_source; // Ист. фин.
    private String pay_amount; // Сумма
    private String service; // За дост.
    private String aid; // № назн./уд
    private String base_aid; //№ баз. назн.
    private String base_aid_value; // Вид выпл.
    private String accounting_period;  //Выпл. за мес.
    private String non_payment_reason; //Причина невыплаты
    private String payment_form; //Способ выплаты
    private String delivary_org; //Орг. выпл.
    private String delivary_site; //Дост. уч.
    private String delivary_day; //День дост.
    private String bank_org; //Банк
    private String service_day; //День обсл. банк
    private String personal_acct; //Лиц. счет
    private String application_date; //Заявление с
    private String application_date_end; //Заявление по
    private String site; //Нас. пункт
    private String street; //Улица
    private String house; //Дом
    private String house_x; //Корпус
    private String appt; // Кв.
    private String recipient_rid; //IDrecipt
    private String rid; //RPRID
    private String cid; // CID
    private String import_data; // Из др. р-на
    private String zip_pay_back; // Отделение почт. связи
    private String region; // Код региона
    private String pay_date; //Дата факт. выпл
    private String who_recipt; // Кем получена
    private String post_or_home; // Выпл. на почту/дом
    private String post_payroll; // Номер вед. при дост. на дом

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getTotal_payment() {
        return total_payment;
    }

    public void setTotal_payment(String total_payment) {
        this.total_payment = total_payment;
    }

    public String getPayroll_no() {
        return payroll_no;
    }

    public void setPayroll_no(String payroll_no) {
        this.payroll_no = payroll_no;
    }

    public String getCase_num() {
        return case_num;
    }

    public void setCase_num(String case_num) {
        this.case_num = case_num;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getLik() {
        return lik;
    }

    public void setLik(String lik) {
        this.lik = lik;
    }

    public String getFinance_source() {
        return finance_source;
    }

    public void setFinance_source(String finance_source) {
        this.finance_source = finance_source;
    }

    public String getPay_amount() {
        return pay_amount;
    }

    public void setPay_amount(String pay_amount) {
        this.pay_amount = pay_amount;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getBase_aid() {
        return base_aid;
    }

    public void setBase_aid(String base_aid) {
        this.base_aid = base_aid;
    }

    public String getBase_aid_value() {
        return base_aid_value;
    }

    public void setBase_aid_value(String base_aid_value) {
        this.base_aid_value = base_aid_value;
    }

    public String getAccounting_period() {
        return accounting_period;
    }

    public void setAccounting_period(String accounting_period) {
        this.accounting_period = accounting_period;
    }

    public String getNon_payment_reason() {
        return non_payment_reason;
    }

    public void setNon_payment_reason(String non_payment_reason) {
        this.non_payment_reason = non_payment_reason;
    }

    public String getPayment_form() {
        return payment_form;
    }

    public void setPayment_form(String payment_form) {
        this.payment_form = payment_form;
    }

    public String getDelivary_org() {
        return delivary_org;
    }

    public void setDelivary_org(String delivary_org) {
        this.delivary_org = delivary_org;
    }

    public String getDelivary_site() {
        return delivary_site;
    }

    public void setDelivary_site(String delivary_site) {
        this.delivary_site = delivary_site;
    }

    public String getDelivary_day() {
        return delivary_day;
    }

    public void setDelivary_day(String delivary_day) {
        this.delivary_day = delivary_day;
    }

    public String getBank_org() {
        return bank_org;
    }

    public void setBank_org(String bank_org) {
        this.bank_org = bank_org;
    }

    public String getService_day() {
        return service_day;
    }

    public void setService_day(String service_day) {
        this.service_day = service_day;
    }

    public String getPersonal_acct() {
        return personal_acct;
    }

    public void setPersonal_acct(String personal_acct) {
        this.personal_acct = personal_acct;
    }

    public String getApplication_date() {
        return application_date;
    }

    public void setApplication_date(String application_date) {
        this.application_date = application_date;
    }

    public String getApplication_date_end() {
        return application_date_end;
    }

    public void setApplication_date_end(String application_date_end) {
        this.application_date_end = application_date_end;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getHouse_x() {
        return house_x;
    }

    public void setHouse_x(String house_x) {
        this.house_x = house_x;
    }

    public String getAppt() {
        return appt;
    }

    public void setAppt(String appt) {
        this.appt = appt;
    }

    public String getRecipient_rid() {
        return recipient_rid;
    }

    public void setRecipient_rid(String recipient_rid) {
        this.recipient_rid = recipient_rid;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getImport_data() {
        return import_data;
    }

    public void setImport_data(String import_data) {
        this.import_data = import_data;
    }

    public String getZip_pay_back() {
        return zip_pay_back;
    }

    public void setZip_pay_back(String zip_pay_back) {
        this.zip_pay_back = zip_pay_back;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPay_date() {
        return pay_date;
    }

    public void setPay_date(String pay_date) {
        this.pay_date = pay_date;
    }

    public String getWho_recipt() {
        return who_recipt;
    }

    public void setWho_recipt(String who_recipt) {
        this.who_recipt = who_recipt;
    }

    public String getPost_or_home() {
        return post_or_home;
    }

    public void setPost_or_home(String post_or_home) {
        this.post_or_home = post_or_home;
    }

    public String getPost_payroll() {
        return post_payroll;
    }

    public void setPost_payroll(String post_payroll) {
        this.post_payroll = post_payroll;
    }
}
