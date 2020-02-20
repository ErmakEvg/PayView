package com.pay.view.controller;

import java.io.IOException;

import com.pay.view.configs.MyRoutingDataSource;
import com.pay.view.utl.SessionList;
import com.pay.view.utl.SessionData;
import com.pay.view.utl.TnsBuilding;
import com.pay.view.model.LoginInfo;
import com.pay.view.model.User;
import com.pay.view.service.UserService;
import oracle.net.jdbc.nl.NLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
@EnableScheduling
@Controller
@RequestMapping(value = "/")
@SessionAttributes("user")
public class LoginController {

    @Autowired
    private MyRoutingDataSource dataSource;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(ModelAndView model, HttpSession session) {

        String[] tnsNames = null;
        try {
            tnsNames = TnsBuilding.getTnsNames();

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(SessionData s:sessionsList.getA()) {
            if(s.session.equals(session.getId())){
                sessionsList.getA().remove(s);
                dataSource.deleteDateSource(session.getId());
                break;
            }
        }

        model.addObject("loginInfo", new LoginInfo());
        model.addObject("tnsNamesList", tnsNames);
        model.setViewName("login");

        return model;
    }

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView loginForm(ModelAndView model) {

        String[] tnsNames = null;
            try {
                tnsNames = TnsBuilding.getTnsNames();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NLException e) {
                e.printStackTrace();
            }

        model.addObject("loginInfo", new LoginInfo());
        model.addObject("tnsNamesList", tnsNames);
        model.setViewName("login");
        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("loginInfo") LoginInfo loginInfo, ModelAndView model, final HttpSession session) {
        String ip = "";
        String serviceName = "";
        String[] tnsNames = null;
        try {
            tnsNames = TnsBuilding.getTnsNames();
            ip = TnsBuilding.getInfoByTns(loginInfo.getServer());
            serviceName = TnsBuilding.getInfoBySid(loginInfo.getServer());
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

        String username = loginInfo.getUsername();
        String password = loginInfo.getPassword();

        SessionData sd = null;

        DriverManagerDataSource tds = new DriverManagerDataSource();
        tds.setDriverClassName("oracle.jdbc.OracleDriver");

        tds.setUrl("jdbc:oracle:thin:@//" + ip + ":1521" + "/" + serviceName);
        tds.setUsername(username);
        tds.setPassword(password);

        User user;
        try {
            tds.getConnection();


        for (SessionData each : sessionsList.getA()){
                    if (each.session.equals(session.getId())){
                        sd = each;
                        break;
                    }
                }
                if (sd == null){
                    sd = new SessionData();
                    sd.session = session.getId();
                    sd.dateCreateSession = new Date();
                    sd.tnsName = loginInfo.getServer();
                    sessionsList.getA().add(sd);
                    dataSource.addDateSource(sd.session, tds);
                } else{
                    sd = null;
                    model.addObject("tnsNamesList", tnsNames);
                    model.addObject("error", "Пользователь в системе");
                    model.setViewName("/login");
                    return model;
                }




            user = userService.getUserByUserName(username);
            boolean isUser = false;
            sd.username = user.getUsername();
            sd.fio = user.getName() + " " + user.getSurname();

        } catch (Exception ex) {
            sd = null;
            for (SessionData each : sessionsList.getA()){
                if (each.session.equals(session.getId())){
                    sessionsList.getA().remove(each);
                    dataSource.deleteDateSource(session.getId());
                    break;
                }
            }
            model.addObject("tnsNamesList", tnsNames);
            model.addObject("error", "Неправильный логин или пароль !");
            model.setViewName("/login");
            return model;
        }

        model.setViewName("redirect:/inf");

        model.addObject("user", user);
        return model;
    }

    @Autowired
    private SessionList sessionsList;


}