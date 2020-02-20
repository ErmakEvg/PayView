package com.pay.view.service;

import com.pay.view.dao.RefStageDAO;
import com.pay.view.model.RefStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RefStageServiceImpl implements RefStageService{

    @Autowired
    private RefStageDAO refStageDAO;


    public RefStage getStageByCode(short code) {
        return refStageDAO.getStageByCode(code);
    }

}
