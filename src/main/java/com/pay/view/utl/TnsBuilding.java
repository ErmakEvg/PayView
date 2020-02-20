package com.pay.view.utl;
// Нужен для получения списка баз данных из файла tnsnames.ora на компьютере
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import oracle.net.jdbc.nl.NLException;
import oracle.net.jdbc.nl.NLParamParser;
import oracle.net.jdbc.nl.NVPair;


public class TnsBuilding {

    private final static String pathToOracle = System.getenv("ORACLE_HOME"); // нужен для постоянности использования программы(чтобы всегда было "ORACLE_HOME" и ничего более)

    public static String[] getTnsNames() throws IOException, NLException {

        NLParamParser parser = new NLParamParser(
                new BufferedReader(new FileReader(new File(pathToOracle + "/network/admin", "tnsnames.ora"))),
                (byte) 1);
        String[] elements = parser.getNLPAllNames();
        Arrays.sort(elements);
        return elements;

    }

    public static String getInfoByTns(String tns) throws IOException, NLException {
        String ip = "";
        NLParamParser parser = new NLParamParser(
                new BufferedReader(new FileReader(new File(pathToOracle + "/network/admin", "tnsnames.ora"))),
                (byte) 1);
        NVPair element = parser.getNLPListElement(tns);

        for (int i = 0; i < element.getListSize(); i++) {
            if (element.getListElement(i).getName().compareTo("DESCRIPTION") == 0) {
                NVPair description = element.getListElement(i);
                for (int j = 0; j < description.getListSize(); j++) {
                    if (description.getListElement(j).getName().compareTo("ADDRESS") == 0) {
                        NVPair address = description.getListElement(j);
                        for (int i2 = 0; i2 < address.getListSize(); i2++) {
                            if (address.getListElement(i2).getName().compareTo("HOST") == 0) {
                                ip = address.getListElement(i2).getAtom();
                            }
                        }
                    } else if (description.getListElement(j).getName().compareTo("ADDRESS_LIST") == 0) {
                        NVPair addressList = description.getListElement(j);
                        for (int i2 = 0; i2 < addressList.getListSize(); i2++) {
                            if (addressList.getListElement(i2).getName().compareTo("ADDRESS") == 0) {
                                NVPair address = addressList.getListElement(i2);
                                for (int i3 = 0; i3 < address.getListSize(); i3++) {
                                    if (address.getListElement(i3).getName().compareTo("HOST") == 0) {
                                        ip = address.getListElement(i3).getAtom();

                                    }
                                }
                                if(ip.length() > 0) {
                                    break;
                                }
                            }
                        }
                    }
                }

            }
        }
        return ip;

    }

    public static String getInfoBySid(String tns) throws IOException, NLException {

        String sid = "";
        NLParamParser parser = new NLParamParser(
                new BufferedReader(new FileReader(new File(pathToOracle + "/network/admin", "tnsnames.ora"))),
                (byte) 1);
        NVPair element = parser.getNLPListElement(tns);
        //.getListElement(0).getListElement(0).getListElement(1);

        for (int i = 0; i < element.getListSize(); i++) {
            if (element.getListElement(i).getName().compareTo("DESCRIPTION") == 0) {
                NVPair description = element.getListElement(i);
                for (int j = 0; j < description.getListSize(); j++) {
                    if (description.getListElement(j).getName().compareTo("CONNECT_DATA") == 0) {
                        NVPair connectData = description.getListElement(j);
                        for (int i2 = 0; i2 < connectData.getListSize(); i2++) {
                            if (connectData.getListElement(i2).getName().compareTo("SERVICE_NAME") == 0) {
                                sid = connectData.getListElement(i2).getAtom();
                            }
                        }
                    }
                }

            }
        }
        return sid;

    }

    public static List<TnsNameFullConnectJDBC> getListConnect () throws IOException, NLException {
        List<TnsNameFullConnectJDBC> list = new ArrayList<>();
        String [] tnsString = getTnsNames();
        for(String s : tnsString) {
            TnsNameFullConnectJDBC connStr = new TnsNameFullConnectJDBC();
            connStr.setTnsname(s);
            connStr.setIp(getInfoByTns(s));
            connStr.setSid(getInfoBySid(s));
            list.add(connStr);
        }

        return  list;
    }
}
