package com.pay.view.controller;

import com.pay.view.model.Pay;
import com.pay.view.service.*;
import com.pay.view.utl.LoginUser;
import com.pay.view.utl.SessionData;
import com.pay.view.utl.SessionList;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.util.List;

@Controller
@RequestMapping(value = "inf")
@SessionAttributes("loginUserRegister")
public class InfController {

    @Autowired
    private RefStageService refStageService;

    @Autowired
    private ResultPaymentService resultPaymentService;

    @Autowired
    private SessionFactory sessionFactory;

    private String ref;
    @Autowired
    private SessionList sessionList;
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView personPage(ModelAndView model, HttpSession session) {
        List<Pay> pays = null;
   try {
       pays = resultPaymentService.getPay();
   }catch (Exception ex) {
       model.setViewName("redirect:/login");
       return model;
   }
    boolean isinf = false;
        for(SessionData s:sessionList.getA()) {
            if(s.session.equals(session.getId())){
                isinf = true;
                break;
            }
        }
        if (isinf == true) {
            model.addObject("pays", pays);
            model.setViewName("inf");

        } else {
            model.setViewName("redirect:/login");

        }
        return  model;
    }
}
