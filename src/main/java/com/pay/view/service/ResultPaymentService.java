package com.pay.view.service;

import com.pay.view.model.*;

import java.util.List;

public interface ResultPaymentService {
    List<PayView> test(Search name);
    List<Recipient> getInfoById(String id);
    List<Deduction> getInfoDeduction(String rid, String cid, String pstart, String pend);
    List<All> getInfoAll(String rid);
    List<String> getDate();
    List<Pay> getPay();
    List<Persons> getPersons(String pstart, String pend);
}
