package com.pay.view.service;

import com.pay.view.dao.ResultPaymentDAO;
import com.pay.view.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class ResultPaymentServiceImpl implements ResultPaymentService {

    @Autowired
    private ResultPaymentDAO resultPaymentDAO;

    public List<PayView> test(Search name) {
        return resultPaymentDAO.test(name);
    }

    public List<Recipient> getInfoById(String id) {
        return resultPaymentDAO.getInfoById(id);
    }

    @Override
    public List<Deduction> getInfoDeduction(String rid, String cid, String pstart, String pend) {
        return resultPaymentDAO.getInfoDeduction(rid, cid, pstart, pend);
    }

    @Override
    public List<All> getInfoAll(String rid) {
        return resultPaymentDAO.getInfoAll(rid);
    }

    @Override
    public List<String> getDate() {
        return resultPaymentDAO.getDate();
    }

    @Override
    public List<Pay> getPay() {
        return resultPaymentDAO.getPay();
    }

    @Override
    public List<Persons> getPersons(String pstart, String pend) {
        return resultPaymentDAO.getPersons(pstart, pend);
    }


}
