package com.pay.view.dao;

import com.pay.view.model.RefStage;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RefStageDAOImpl implements RefStageDAO{

    @Autowired
    private SessionFactory sessionFactory;


    public RefStage getStageByCode(short code) {


        return (RefStage)sessionFactory.getCurrentSession().createQuery("from RefStage where code = " + code).list().get(0);
    }

}
