package com.pay.view.dao;

import com.pay.view.model.*;

import java.util.List;

public interface ResultPaymentDAO {

    public List<PayView> test(Search name);

    public List<Recipient> getInfoById(String id);

    List<String> getDate();

    List<Pay> getPay();

    List<Deduction> getInfoDeduction(String rid, String cid, String pstart, String pend);
    List<All> getInfoAll(String rid);
    List<Persons> getPersons(String pstart, String pend);
}
