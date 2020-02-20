package com.pay.view.dao;

import com.pay.view.model.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class ResultPaymentDAOImpl implements ResultPaymentDAO {
    @Autowired
    private SessionFactory sessionFactory;


    public List<PayView> test(Search search) {

        List<PayView> payViews = new ArrayList<PayView>();
        List<Object[]> pays = sessionFactory.getCurrentSession().createSQLQuery("SELECT AP.PERIOD as \"Мес. выпл.\",\n" +
                "       p.TOTAL_PAYMENT_NO as \"№ расч.\",\n" +
                "       p.PAYROLL_NO as \"№ вед.\",\n" +
                "       C.CASE_NUM as \"№ дела\",\n" +
                "       p1.SURNAME || ' ' || p1.NAME || ' ' || p1.PATNAME AS \"Получатель\",\n" +
                "       p1.BIRTH_DATE as \"Дата рожд.\",\n" +
                "       p1.LIK as \"Идентиф. номер.\",\n" +
                "       RP.FINANCE_SOURCE as \"Ист. фин.\",\n" +
                "       RP.PAY_AMOUNT \"Сумма\",\n" +
                "       RP.Service as \"За дост.\",\n" +
                "       RP.AID as \"№ назн./уд.\",\n" +
                "       RP.BASE_AID as \"№ баз.назн.\",\n" +
                "       decode(RP.BASE_AID, null, ' назн.', ' удерж.') as \"Вид выпл.\",\n" +
                "(select period from accounting_period where rid = RP.PREV_PERIOD_RID) as \"Выпл. за мес.\",\n" +
                "        RP.NON_PAYMENT_REASON as \"Причина невыплаты\",\n" +
                "  (select value from ref_payment_method where code = p.PAYMENT_FORM) as \"Способ выплаты\",\n" +
                "(select value from organizations where code = R.DELIVERY_ORG) as \"Орг. выпл.\",\n" +
                "  R.DELIVERY_SITE as \"Дост. уч.\",\n" +
                "  R.DELIVERY_DAY as \"День дост.\",\n" +
                "(select value from organizations where code = R.BANK_ORG) as \"Банк\",\n" +
                "  R.SERVICE_DAY as \"День обсл. банк\",\n" +
                "  R.PERSONAL_ACCT as \"Лиц. счет\",\n" +
                "  R.APPLICATION_DATE as \"Заявление с\",\n" +
                "  R.APPLICATION_DATE_END as \"Заявление по\",\n" +
                "(select value from state_division where code = a.SITE) \"Нас. пункт\" ,\n" +
                "(select value from state_division where code = a.STREET) \"Улица\", \n" +
                "  a.HOUSE \"Дом\", \n" +
                "  a.HOUSE_X \"Корпус\", \n" +
                "  a.APPT \"Кв.\",\n" +
                "  RP.RECIPIENT_RID as \"IDrecipt\",\n" +
                "  RP.RID as \"RPRID\",\n" +
                "  R.CID,\n" +
                "  RP.IMPORT_DATA as \"Из др. р-на\" ,\n" +
                "  RP.ZIP_PAY_BACK as \"Отделение почт. связи\", \n" +
                "  RP.REGION as \"Код региона\",\n" +
                "  RP.PAY_DATE as \"Дата факт. выпл.\",\n" +
                "  RP.WHO_RECIPT as \"Кем получена\",\n" +
                "  RP.POST_OR_HOME as \"Выпл. на почту/дом\",\n" +
                "  RP.POST_PAYROLL as \"Номер вед. при дост. на дом\"\n" +
                "  FROM Payroll p\n" +
                "    INNER JOIN ACCOUNTING_PERIOD AP\n" +
                "      ON p.PERIOD_RID = AP.RID\n" +
                "      INNER JOIN RESULT_PAYMENT RP\n" +
                "        ON RP.PERIOD_RID = p.PERIOD_RID\n" +
                "        AND RP.PAYROLL_NO = p.PAYROLL_NO\n" +
                "        INNER JOIN RECIPIENT R\n" +
                "          ON R.RID = RP.RECIPIENT_RID\n" +
                "          INNER JOIN CASE C\n" +
                "            ON C.CID = R.CID\n" +
                "            AND C.STAGE IS NULL\n" +
                "            LEFT JOIN PERSON p1\n" +
                "              ON R.PERSON_RID = p1.RID\n" +
                "              LEFT JOIN ADDRESS a\n" +
                "                ON a.RID = R.ADDRES_RID\n" +
                "   WHERE (( AP.PERIOD BETWEEN to_date('"+search.getFirstDate()+"','dd.mm.yyyy') AND to_date('"+search.getLastDate()+"','dd.mm.yyyy') AND to_date('"+search.getLastDate()+"','dd.mm.yyyy') IS NOT NULL) \n" +
                        "    OR (AP.PERIOD = to_date('"+search.getFirstDate()+"','dd.mm.yyyy') AND to_date('"+search.getLastDate()+"','dd.mm.yyyy') IS NULL))\n" +
                "   AND (p.PAYROLL_NO =" + search.getPayrollNumber()+ "\n" +
                "    OR "+ search.getPayrollNumber()+" = 0)\n" +
                "   AND (p.PAYMENT_FORM = "+search.getPay()+" \n" +
                "    OR "+search.getPay()+" = 0)\n" +
                "    AND (p.TOTAL_PAYMENT_NO = "+search.getTotalPayment()+"\n" +
                "    OR "+search.getTotalPayment()+" = 0)\n" +
                "    AND (C.CASE_NUM like '"+search.getCaseNum()+"'\n" +
                "    OR '"+search.getCaseNum()+"' IS NULL)\n" +
                "    AND (p1.SURNAME like '"+search.getSurname()+'%'+"'\n" +
                "    OR '"+search.getSurname()+"' IS NULL)\n" +
                "    AND (p1.PATNAME like '"+search.getPatname()+'%'+"'\n" +
                "    OR '"+search.getPatname()+"' IS NULL)\n" +
                "    AND (p1.NAME like '"+search.getName()+'%'+"'\n" +
                "    OR '"+search.getName()+"' IS NULL)").list();
        SimpleDateFormat parseDate = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat qwr = new SimpleDateFormat("yyyy-MM-dd");
        for(Object[] pay : pays){
            PayView element = new PayView();
            if(pay[0] != null)
            {
                String per = pay[0].toString().substring(0, 10);
                Date date = null;
                try {
                    date = qwr.parse(per);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                element.setPeriod(parseDate.format(date));
            }
            if(pay[1] != null)
                element.setTotal_payment(pay[1].toString());
            if(pay[2] != null)
                element.setPayroll_no(pay[2].toString());
            if(pay[3] != null)
                element.setCase_num(pay[3].toString());
            if(pay[4] != null)
                element.setFio(pay[4].toString());
            if(pay[5] != null)
                 {
                    String bir = pay[5].toString().substring(0, 10);
                    Date date = null;
                    try {
                        date = qwr.parse(bir);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    element.setBirth_date(parseDate.format(date));
                }
            if(pay[6] != null)
                element.setLik(pay[6].toString());
            if(pay[7] != null)
                element.setFinance_source(pay[7].toString());
            if(pay[8] != null)
                element.setPay_amount(pay[8].toString());
            if(pay[9] != null)
                element.setService(pay[9].toString());
            if(pay[10] != null)
                element.setAid(pay[10].toString());
            if(pay[11] != null)
                element.setBase_aid(pay[11].toString());
            if(pay[12] != null)
                element.setBase_aid_value(pay[12].toString());
            if(pay[13] != null)
            {
                String acc = pay[13].toString().substring(0, 10);
                Date date = null;
                try {
                    date = qwr.parse(acc);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                element.setAccounting_period(parseDate.format(date));
            }
            if(pay[14] != null)
                element.setNon_payment_reason(pay[14].toString());
            if(pay[15] != null)
                element.setPayment_form(pay[15].toString());
            if(pay[16] != null)
                element.setDelivary_org(pay[16].toString());
            if(pay[17] != null)
                element.setDelivary_site(pay[17].toString());
            if(pay[18] != null)
                element.setDelivary_day(pay[18].toString());
            if(pay[19] != null)
                element.setBank_org(pay[19].toString());
            if(pay[20] != null)
                element.setService_day(pay[20].toString());
            if(pay[21] != null)
                element.setPersonal_acct(pay[21].toString());
            if(pay[22] != null)
            {
                String appt = pay[22].toString().substring(0, 10);
                Date date = null;
                try {
                    date = qwr.parse(appt);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                element.setApplication_date(parseDate.format(date));
            }
            if(pay[23] != null)
            {
                String app = pay[23].toString().substring(0, 10);
                Date date = null;
                try {
                    date = qwr.parse(app);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                element.setApplication_date_end(parseDate.format(date));
            }
            if(pay[24] != null)
                element.setSite(pay[24].toString());
            if(pay[25] != null)
                element.setStreet(pay[25].toString());
            if(pay[26] != null)
                element.setHouse(pay[26].toString());
            if(pay[27] != null)
                element.setHouse_x(pay[27].toString());
            if(pay[28] != null)
                element.setAppt(pay[28].toString());
            if(pay[29] != null)
                element.setRecipient_rid(pay[29].toString());
            if(pay[30] != null)
                element.setRid(pay[30].toString());
            if(pay[31] != null)
                element.setCid(pay[31].toString());
            if(pay[32] != null)
                element.setImport_data(pay[32].toString());
            if(pay[33] != null)
                element.setZip_pay_back(pay[33].toString());
            if(pay[34] != null)
                element.setRegion(pay[34].toString());
            if(pay[35] != null)
                element.setPay_date(pay[35].toString());
            if(pay[36] != null)
                element.setWho_recipt(pay[36].toString());
            if(pay[37] != null)
                element.setPost_or_home(pay[37].toString());
            if(pay[38] != null)
                element.setPost_payroll(pay[38].toString());

                payViews.add(element);
        }
        return payViews;

    }

    @Override
    public List<Recipient> getInfoById(String id) {
        List<Recipient> result = new ArrayList<Recipient>();
        List<Object[]> rows = sessionFactory.getCurrentSession().createSQLQuery("SELECT    rpm.VALUE as \"Способ выпл.\",\n" +
                "       o.VALUE AS \"Банк\",\n" +
                "       r.PERSONAL_ACCT as \"№ лиц. счета\",\n" +
                "       r.APPLICATION_DATE as \"Заявление с\",\n" +
                "       r.APPLICATION_DATE_END as \"Заявление по\", \n" +
                "       r.SERVICE_DAY as \"Дата обслуживания\",\n" +
                "       o1.VALUE AS \"Почта\",\n" +
                "       r.DELIVERY_DAY as \"День доставки\",\n" +
                "       r.DELIVERY_SITE as \"Доставочный участок\"       \n" +
                "FROM RECIPIENT r\n" +
                "FULL OUTER JOIN ORGANIZATIONS o ON (o.CODE = r.BANK_ORG)\n" +
                "INNER JOIN REF_PAYMENT_METHOD rpm ON r.PAYMENT_FORM = rpm.CODE\n" +
                "FULL OUTER JOIN ORGANIZATIONS o1 ON o1.CODE = r.DELIVERY_ORG\n" +
                "WHERE r.RID =" +id).list();
        SimpleDateFormat sd = new SimpleDateFormat("dd.MM.yyyy");
     SimpleDateFormat sder = new SimpleDateFormat("yyyy-MM-dd");
        for(Object[] row : rows){
            Recipient emp = new Recipient();
            if(row[0] != null)
            emp.setVspl(row[0].toString());
            if(row[1] != null)
            emp.setBank(row[1].toString());
            if(row[2] != null)
            emp.setPersonal_Acct(row[2].toString());
            if(row[3] != null) {

                String dateCurr =  row[3].toString().substring(0, 10);
                Date date = null;
                try {
                    date = sder.parse(dateCurr);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                emp.setApplication_Date(sd.format(date));
            }
            if(row[4] != null) {

                String strD = row[4].toString().substring(0, 10);
              Date date = null;
                try {
                    date = sder.parse(strD);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                emp.setApplication_Date_End(sd.format(date));
            }
            if(row[5] != null)
            emp.setService_Day(row[5].toString());
            if(row[6] != null)
            emp.setCoffice(row[6].toString());
            if(row[7] != null)
            emp.setDelivery_Day(row[7].toString());
            if(row[8] != null)
            emp.setDelivery_Site(row[8].toString());
            result.add(emp);
        }

        return result;
    }

    @Override
    public List<String> getDate() {
        List<Date> result = null;
        result = sessionFactory.getCurrentSession().createSQLQuery("select * from(select trunc(period) as period\n" +
                        "from accounting_period\n" +
                        "order by period desc) where rownum <=24").list();
        SimpleDateFormat sd = new SimpleDateFormat("dd.MM.yyyy");
        List<String> convertResult = new ArrayList<String>();
        for (Date date : result) {

            convertResult.add(sd.format(date));
        }
        return convertResult;
    }

    @Override
    public List<Pay> getPay() {
        List<Pay> result = new ArrayList<Pay>();
        List<Object[]> paws = sessionFactory.getCurrentSession().createSQLQuery("select code, value from ref_payment_method order by code").list();
        for(Object[] paw : paws) {
            Pay pa = new Pay();
            if (paw[0] != null)
                pa.setId(paw[0].toString());
            if (paw[1] != null)
                pa.setValue(paw[1].toString());
            result.add(pa);
        }
        return result;
    }

    @Override
    public List<Deduction> getInfoDeduction(String rid, String cid, String pstart, String pend) {
        List<Deduction> result = new ArrayList<Deduction>();
        List<Object[]> ds = sessionFactory.getCurrentSession().createSQLQuery("select (SELECT VALUE FROM ref_finance_source WHERE CODE = FINANCE_SOURCE) as \"Ист. фин.\",\n" +
                "                             month_amount AS \"Сумма за месяц\", \n" +
                "                             Period_amount AS \"Сумма за период\",\n" +
                "                             payment_percent AS \"% к выпл.\", \n" +
                "                             PERIOD_START AS \"Начало периода\", \n" +
                "                             PERIOD_END as \"Конец периода\", \n" +
                "                             PAYMENT_FLAG AS \"Не выплачивать\", \n" +
                "                             (SELECT VALUE FROM allocations WHERE CODE = ALLOC_CODE) as \"Вид назнач./удерж.\"\n" +
                "                             from calc_amount where result_payment_rid = "+ rid +" and stage is null \n" +
                "                             union all \n" +
                "                             SELECT (SELECT VALUE FROM ref_finance_source WHERE CODE = dca.FINANCE_SOURCE) AS \"Ист. фин.\",\n" +
                "                             dca.AMOUNT_DEDUCTION as \"Сумма за месяц\", \n" +
                "                             dca.AMOUNT_PAYMENT as \"Сумма за период\", \n" +
                "                             dca.AMOUNT_PAYMENT AS \"% к выпл.\", \n" +
                "                             dca.PERIOD_START AS \"Начало периода\", \n" +
                "                             dca.PERIOD_END as \"Конец периода\", \n" +
                "                             null \"Не выплачивать\",\n" +
                "                             (SELECT VALUE FROM allocations WHERE CODE = dca.ALLOC_CODE) AS \"Вид назнач./удерж.\" \n" +
                "                             FROM DEDUCTION_CALC_AMOUNT dca \n" +
                "                             WHERE dca.CID = "+ cid +" \n" +
                "                             AND NVL(dca.AMOUNT_RECIPIENT, 0) <> 0\n" +
                "                             AND dca.PERIOD_START >= to_date('"+ pstart +"','dd.mm.yyyy') \n" +
                "                             AND dca.PERIOD_END <= to_date('" + pend +"','dd.mm.yyyy')").list();
        SimpleDateFormat sd = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat sder = new SimpleDateFormat("yyyy-MM-dd");
        for(Object[] d : ds){
            Deduction ded = new Deduction();
            if(d[0] != null)
                ded.setFinance_Source(d[0].toString());
            if(d[1] != null)
                ded.setMonth_Amount(d[1].toString());
            if(d[2] != null)
                ded.setPeriod_Amount(d[2].toString());
            if(d[3] != null)
                ded.setPayment_Percent(d[3].toString());
            if(d[4] != null) {

                String strS = d[4].toString().substring(0, 10);
                Date date = null;
                try {
                    date = sder.parse(strS);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                ded.setPeriod_Start(sd.format(date));
            }
            if(d[5] != null){
                String sty =  d[5].toString().substring(0, 10);
                Date date = null;
                try {
                    date = sder.parse(sty);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                ded.setPeriod_End(sd.format(date));
            }
                if(d[6] != null)
                    ded.setPayment_Flag(d[6].toString());
                if(d[7] != null)
                    ded.setAlloc_Code(d[7].toString());
                result.add(ded);
            }
            return result;
        }

    @Override
    public List<All> getInfoAll(String rid) {
        List<All> result = new ArrayList<All>();
        List<Object[]> alls = sessionFactory.getCurrentSession().createSQLQuery("select (SELECT VALUE FROM allocations WHERE CODE = ALLOC_CODE) as \"Вид удерж./назнач.\", \n" +
                "                           (SELECT VALUE FROM ref_finance_source WHERE CODE = FINANCE_SOURCE) as \"Источник Финансирования\", \n" +
                "                           AMOUNT_DEDUCTION as \"Сумма удержания\", \n" +
                "                           AMOUNT_RECIPIENT as \"Сумма получателю\", \n" +
                "                           AMOUNT_PAYMENT AS \"Сумма к выпл.\", \n" +
                "                           LIABILITIES AS \"Задолж. по удерж.\", \n" +
                "                           OVERPAYMENT AS \"Переплата\", \n" +
                "                           POST_AMOUNT as \"Сумма за почт. усл.\", \n" +
                "                           PERIOD_START AS \"Начало периода\", \n" +
                "                           PERIOD_END as \"Конец периода\", \n" +
                "                           POST_LIAB AS \"Задолж. за почт. усл.\", \n" +
                "                           (SELECT VALUE FROM allocations WHERE CODE = ALLOC_CODE_ALLOC) AS \"Вид назначения\" \n" +
                "                           from deduction_calc_amount \n" +
                "                           where "+rid+" = result_payment_rid and stage is null").list();
        SimpleDateFormat sd = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat sder = new SimpleDateFormat("yyyy-MM-dd");
        for(Object[] all : alls){
            All al = new All();
            if(all[0] != null)
                al.setAlloc_Code(all[0].toString());
            if(all[1] != null)
                al.setFinance_Source(all[1].toString());
            if(all[2] != null)
                al.setAmount_Deduction(all[2].toString());
            if(all[3] != null)
                al.setAmount_Recipient(all[3].toString());
            if(all[4] != null)
                al.setAmount_Payment(all[4].toString());
            if(all[5] != null)
                al.setLibilities(all[5].toString());
            if(all[6] != null)
                al.setOverpayment(all[6].toString());
            if(all[7] != null)
                al.setPost_Amount(all[7].toString());
            if(all[8] != null){
                String strS = all[8].toString().substring(0, 10);
            Date date = null;
            try {
                date = sder.parse(strS);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            al.setPeriod_Start(sd.format(date));
            }
            if(all[9] != null)
            {
                String sty =  all[9].toString().substring(0, 10);
                Date date = null;
                try {
                    date = sder.parse(sty);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                al.setPeriod_End(sd.format(date));
            }
            if(all[10] != null)
                al.setPost_Liab(all[10].toString());
            if(all[11] != null)
                al.setAlloc_Code_Alloc(all[11].toString());
            result.add(al);
        }
        return result;
    }

    @Override
    public List<Persons> getPersons(String pstart, String pend) {
        List<Persons> result = new ArrayList<Persons>();
        List<Object[]> pers = sessionFactory.getCurrentSession().createSQLQuery("select \n" +
                "  CID \"Идентиф. дела\",\n" +
                "  AID \"№ назначения\",\n" +
                "  AMOUNT \" Недополуч. сумма\",\n" +
                "  COUNT_QUOTA \"Колич. долей\",\n" +
                "  HEIR_NUMBER \"№ доли\",\n" +
                "  initcap(SURNAME) || ' ' || \n" +
                "  initcap(NAME) || ' ' || initcap(PATNAME) \"Получатель\", \n" +
                "  ALLIANCE \"Родственная связь\",\n" +
                "  LIK \"Идентификационный №\",\n" +
                "  trunc(BIRTH_DATE) \"Дата рождения\",\n" +
                "  ADDRESS \"Адрес\",\n" +
                "  DOC_TYPE \"Тип док.\",\n" +
                "  DOC_NUMBER \" № док.\",\n" +
                "  DOC_SERIES \"Серия\",\n" +
                "  DOC_ISSUE_DATE \"Док. выдан\",\n" +
                "  DOC_ISSUE_ORGANIZATION \"Кем выдан\",\n" +
                "  AMOUNT_QUOTA \"Сумма доли\",\n" +
                "  trunc(CALC_DATE) \"Дата расчета\",\n" +
                "  DECODE_ORGANIZATIONS(DELIVERY_ORG) \"Поручение в организацию\",\n" +
                "  trunc(ENTRY_DATE) \"Дата выдачи поручения\",\n" +
                "  CLOSE_DATE \"Аннулировано\",\n" +
                "  (select initcap(OSP.SURNAME) || ' ' || \n" +
                "          initcap(OSP.NAME) || ' ' || initcap(OSP.PATNAME)\n" +
                "  from ORG_SOCIAL_PERSONS OSP\n" +
                "  where OSP.USER_ID = PAYMENT_HEIR.ENTERED_BY) \"Кем выдано поручение\"\n" +
                "from PAYMENT_HEIR\n" +
                "where trunc(CALC_DATE) between to_date('"+ pstart +"','dd.mm.yyyy') and to_date('"+ pend +"','dd.mm.yyyy')\n" +
                "order by CID, HEIR_NUMBER").list();
        SimpleDateFormat sd = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat sder = new SimpleDateFormat("yyyy-MM-dd");
        for(Object[] per : pers){
            Persons pe = new Persons();
            if(per[0] != null)
                pe.setCid(per[0].toString());
            if(per[1] != null)
                pe.setAid(per[1].toString());
            if(per[2] != null)
                pe.setAmount(per[2].toString());
            if(per[3] != null)
                pe.setCount_quota(per[3].toString());
            if(per[4] != null)
                pe.setHeir_number(per[4].toString());
            if(per[5] != null)
                pe.setFio(per[5].toString());
            if(per[6] != null)
                pe.setAlliance(per[6].toString());
            if(per[7] != null)
                pe.setLik(per[7].toString());
            if(per[8] != null)
            {
            String stb = per[8].toString().substring(0, 10);
            Date date = null;
            try {
                date = sder.parse(stb);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            pe.setBirth_date(sd.format(date));
            }

            if(per[9] != null)
                pe.setAddress(per[9].toString());
            if(per[10] != null)
                pe.setDoc_type(per[10].toString());
            if(per[11] != null)
                pe.setDoc_number(per[11].toString());
            if(per[12] != null)
                pe.setDoc_series(per[12].toString());
            if(per[13] != null)
            {
                String std = per[13].toString().substring(0, 10);
                Date date = null;
                try {
                    date = sder.parse(std);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                pe.setDoc_issue_date(sd.format(date));
            }
            if(per[14] != null)
                pe.setDoc_issue_organization(per[14].toString());
            if(per[15] != null)
                pe.setAmount_quota(per[15].toString());
            if(per[16] != null)
            {
                String stc = per[16].toString().substring(0, 10);
                Date date = null;
                try {
                    date = sder.parse(stc);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                pe.setCalc_date(sd.format(date));
            }
            if(per[17] != null)
                pe.setDelivery_org(per[17].toString());
            if(per[18] != null)
            {
                String ste = per[18].toString().substring(0, 10);
                Date date = null;
                try {
                    date = sder.parse(ste);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                pe.setEntry_date(sd.format(date));
            }
            if(per[19] != null){
                String ste = per[19].toString().substring(0, 10);
            Date date = null;
            try {
                date = sder.parse(ste);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            pe.setClose_date(sd.format(date));
            }
            if(per[20] != null)
                pe.setEntered_by(per[20].toString());
            result.add(pe);
        }
        return result;
    }

}
