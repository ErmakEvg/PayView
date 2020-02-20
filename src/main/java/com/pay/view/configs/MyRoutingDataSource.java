package com.pay.view.configs;

import com.pay.view.utl.SessionData;
import com.pay.view.utl.SessionList;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.Cookie;
import org.springframework.beans.factory.annotation.Autowired;

public class MyRoutingDataSource extends AbstractRoutingDataSource {

     private Map<Object, Object> targetDataSources;
     @Autowired
     private SessionList sessionList;

     @Override
     protected Object determineCurrentLookupKey() {
          try {
               HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

               String id = "";
               for (Cookie each : request.getCookies()) {
                    if (each.getName().equals("JSESSIONID")) {
                         id = each.getValue();
                    }
               }
               for (SessionData each : sessionList.getA()) {
                    if (each.session.equals(id)) {
                         return each.session;
                    }
               }
               return "test";
          } catch (Exception ex) {
               return "test";
          }

     }

     public void deleteDateSource(String keyDS) {
          targetDataSources.remove(keyDS);
          this.setTargetDataSources(targetDataSources);
          this.afterPropertiesSet();
     }

     public void addDateSource(String keyDS, DataSource dataSource) {
          targetDataSources.put(keyDS, dataSource);
          this.setTargetDataSources(targetDataSources);
          this.afterPropertiesSet();
     }


     public void initDataSources(Map<String, DataSource> dataSourceMap) {
          targetDataSources = new HashMap<Object, Object>();
          targetDataSources.putAll(dataSourceMap);
          this.setTargetDataSources(targetDataSources);
     }
}