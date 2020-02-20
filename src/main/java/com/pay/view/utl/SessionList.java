package com.pay.view.utl;
import java.util.List;
import java.util.ArrayList;


import org.springframework.stereotype.Component;

@Component
public class SessionList {

    private List<SessionData> a;

    public SessionList() {
        this.a= new ArrayList<SessionData>();
    }

    public List<SessionData> getA() {
        return a;
    }

    public void setA(List<SessionData> a) {
        this.a = a;
    }
}
