package com.pay.view.model;

public class Persons {
    private String cid;//Идентиф. дела
    private String aid;//№ назначения
    private String amount;//Недополуч. сумма
    private String count_quota;//Колич. долей
    private String heir_number;//№ доли
    private String fio;//ФИО
    private String alliance;//Родственная связь
    private String lik;//Идентификационный №
    private String birth_date;//Дата рождения
    private String address;//Адрес
    private String doc_type;//Тип док.
    private String doc_number;//№ док.
    private String doc_series;//Серия
    private String doc_issue_date;//Док. выдан
    private String doc_issue_organization;//Кем выдан
    private String amount_quota;//Сумма доли
    private String calc_date;//Дата расчета
    private String delivery_org;//Поручение в организацию
    private String entry_date;//Дата выдачи поручения
    private String close_date;// Аннулировано
    private String entered_by;//Кем выдано поручение

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCount_quota() {
        return count_quota;
    }

    public void setCount_quota(String count_quota) {
        this.count_quota = count_quota;
    }

    public String getHeir_number() {
        return heir_number;
    }

    public void setHeir_number(String heir_number) {
        this.heir_number = heir_number;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getAlliance() {
        return alliance;
    }

    public void setAlliance(String alliance) {
        this.alliance = alliance;
    }

    public String getLik() {
        return lik;
    }

    public void setLik(String lik) {
        this.lik = lik;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDoc_type() {
        return doc_type;
    }

    public void setDoc_type(String doc_type) {
        this.doc_type = doc_type;
    }

    public String getDoc_number() {
        return doc_number;
    }

    public void setDoc_number(String doc_number) {
        this.doc_number = doc_number;
    }

    public String getDoc_series() {
        return doc_series;
    }

    public void setDoc_series(String doc_series) {
        this.doc_series = doc_series;
    }

    public String getDoc_issue_date() {
        return doc_issue_date;
    }

    public void setDoc_issue_date(String doc_issue_date) {
        this.doc_issue_date = doc_issue_date;
    }

    public String getAmount_quota() {
        return amount_quota;
    }

    public void setAmount_quota(String amount_quota) {
        this.amount_quota = amount_quota;
    }

    public String getCalc_date() {
        return calc_date;
    }

    public void setCalc_date(String calc_date) {
        this.calc_date = calc_date;
    }

    public String getDelivery_org() {
        return delivery_org;
    }

    public void setDelivery_org(String delivery_org) {
        this.delivery_org = delivery_org;
    }

    public String getEntry_date() {
        return entry_date;
    }

    public void setEntry_date(String entry_date) {
        this.entry_date = entry_date;
    }

    public String getEntered_by() {
        return entered_by;
    }

    public void setEntered_by(String entered_by) {
        this.entered_by = entered_by;
    }

    public String getDoc_issue_organization() {
        return doc_issue_organization;
    }

    public void setDoc_issue_organization(String doc_issue_organization) {
        this.doc_issue_organization = doc_issue_organization;
    }

    public String getClose_date() {
        return close_date;
    }

    public void setClose_date(String close_date) {
        this.close_date = close_date;
    }
}
