/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pay.view.configs;

import com.pay.view.utl.TnsBuilding;
import com.pay.view.utl.TnsNameFullConnectJDBC;
import oracle.net.jdbc.nl.NLException;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


import javax.sql.DataSource;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class SpringBootRoutingDsApplication {

     private static final String DRIVER_CLASS_NAME = "oracle.jdbc.OracleDriver";

     @Primary
     @Bean(name = "dataSource")
     public MyRoutingDataSource getDataSource() {
          MyRoutingDataSource dataSource = new MyRoutingDataSource();

          List<TnsNameFullConnectJDBC> list = null;
          try {
               list =  TnsBuilding.getListConnect();
          } catch (IOException e) {
               e.printStackTrace();
          } catch (NLException e) {
               e.printStackTrace();
          }
          Map<String, DataSource> dataSourceMap = new HashMap<String, DataSource>();
          list.forEach(tnsNameFullConnectJDBC -> {
               DriverManagerDataSource tds = new DriverManagerDataSource();
               tds.setDriverClassName(DRIVER_CLASS_NAME);
               tds.setUrl("jdbc:oracle:thin:@//" + tnsNameFullConnectJDBC.getIp() + ":" + tnsNameFullConnectJDBC.getPort()  + "//" + tnsNameFullConnectJDBC.getSid());
               tds.setUsername("SISSP");
               tds.setPassword("QWAZAR");
               dataSourceMap.put(tnsNameFullConnectJDBC.getTnsname(), tds);
          });
          dataSource.initDataSources(dataSourceMap);

          return dataSource;
     }

}