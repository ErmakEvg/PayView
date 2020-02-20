<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Просмотр Выплаты</title>

    <link href="resources/dist/bootstrap.min.css" rel="stylesheet">
    <script src="resources/dist/jquery-1.12.4.min.js"></script>
    <script src="resources/dist/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="resources/dist/dataTables.bootstrap.min.css"/>
    <link  href="resources/dist/datepicker.css" rel="stylesheet"/>
    <script src="resources/dist/datepicker.js"></script>
    <script type="text/javascript" src="resources/dist/moment.min.js"></script>
    <script type="text/javascript" src="resources/dist/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="resources/dist/dataTables.bootstrap.min.js"></script>
    <link rel="stylesheet" href="resources/dist/buttons.bootstrap.min.css">
    <script src="resources/dist/dataTables.buttons.min.js"></script>
    <script src="resources/dist/buttons.bootstrap.min.js"></script>
    <script src="resources/dist/jszip.min.js"></script>
    <script src="resources/dist/buttons.html5.min.js"></script>


    <script src="resources/dist/buttons.colVis.min.js"></script>

    <style>

        .table-striped>tbody>tr:nth-of-type(odd)
        {
            background-color: #fdfdfd;
        }
        .table-striped>tbody>tr:nth-of-type(even)
        {
            background-color: #bfbfbf;
        }

        .table-striped>tbody>tr:nth-of-type(odd):hover
        {
            background-color: yellow;
        }

        .table-striped>tbody>tr:nth-of-type(even):hover
        {
            background-color: yellow;
        }
            /* для кнопки */
 .table>tbody>tr>td, .table>tbody>tr>th, .table>tfoot>tr>td, .table>tfoot>tr>th, .table>thead>tr>td, .table>thead>tr>th {
     padding: 5px;
 }

        .table-striped>tbody>tr.selected        {
            background-color: yellow;
        }

 .navbar
 {
     min-height: 0px;
 }

 .pagination>li>a, .pagination>li>span
 {
     float: false;
 }

 .dt-button-collection {
     height:300px;
     overflow-y:scroll;
 }
     th { white-space: nowrap; }
     td { white-space: nowrap; }

        .animate {
            -webkit-transition: all 0.3s ease-in-out;
            -moz-transition: all 0.3s ease-in-out;
            -o-transition: all 0.3s ease-in-out;
            -ms-transition: all 0.3s ease-in-out;
            transition: all 0.3s ease-in-out;
        }

        .navbar-fixed-left {
            position: fixed;
            top: 0px;
            left: 0px;
            border-radius: 0px;
        }

        .navbar-minimal {
            width: 500px;
            max-height: 100%;
            background-color: rgb(51, 51, 51);
            background-color: rgba(51, 51, 51, 0.8);
            border-width: 0px;
            z-index: 1000;
        }

        .navbar-minimal > .navbar-toggler {
            position: relative;
            min-height: 31px;
            z-index: 100;
            cursor: pointer;
        }

        .navbar-minimal.open > .navbar-toggler,
        .navbar-minimal > .navbar-toggler:hover {
            background-color: rgb(158, 202, 59);
        }

        .navbar-minimal > .navbar-toggler > span {
            position: absolute;
            top: 50%;
            right: 80%;
            margin: -8px -8px 0 0;
            width: 16px;
            height: 16px;
            background-image: url(data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0idXRmLTgiPz4KPCEtLSBHZW5lcmF0b3I6IEFkb2JlIElsbHVzdHJhdG9yIDE2LjIuMSwgU1ZHIEV4cG9ydCBQbHVnLUluIC4gU1ZHIFZlcnNpb246IDYuMDAgQnVpbGQgMCkgIC0tPgo8IURPQ1RZUEUgc3ZnIFBVQkxJQyAiLS8vVzNDLy9EVEQgU1ZHIDEuMS8vRU4iICJodHRwOi8vd3d3LnczLm9yZy9HcmFwaGljcy9TVkcvMS4xL0RURC9zdmcxMS5kdGQiPgo8c3ZnIHZlcnNpb249IjEuMSIgaWQ9IkxheWVyXzEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHg9IjBweCIgeT0iMHB4IgoJIHdpZHRoPSIxNnB4IiBoZWlnaHQ9IjMycHgiIHZpZXdCb3g9IjAgMCAxNiAzMiIgZW5hYmxlLWJhY2tncm91bmQ9Im5ldyAwIDAgMTYgMzIiIHhtbDpzcGFjZT0icHJlc2VydmUiPgo8cGF0aCBmaWxsLXJ1bGU9ImV2ZW5vZGQiIGNsaXAtcnVsZT0iZXZlbm9kZCIgZmlsbD0iI0ZGRkZGRiIgZD0iTTEsN2gxNGMwLjU1MiwwLDEsMC40NDgsMSwxcy0wLjQ0OCwxLTEsMUgxQzAuNDQ4LDksMCw4LjU1MiwwLDgKCVMwLjQ0OCw3LDEsN3oiLz4KPHBhdGggZmlsbC1ydWxlPSJldmVub2RkIiBjbGlwLXJ1bGU9ImV2ZW5vZGQiIGZpbGw9IiNGRkZGRkYiIGQ9Ik0xLDEyaDE0YzAuNTUyLDAsMSwwLjQ0OCwxLDFzLTAuNDQ4LDEtMSwxSDFjLTAuNTUyLDAtMS0wLjQ0OC0xLTEKCVMwLjQ0OCwxMiwxLDEyeiIvPgo8cGF0aCBmaWxsLXJ1bGU9ImV2ZW5vZGQiIGNsaXAtcnVsZT0iZXZlbm9kZCIgZmlsbD0iI0ZGRkZGRiIgZD0iTTEsMmgxNGMwLjU1MiwwLDEsMC40NDgsMSwxcy0wLjQ0OCwxLTEsMUgxQzAuNDQ4LDQsMCwzLjU1MiwwLDMKCVMwLjQ0OCwyLDEsMnoiLz4KPHBhdGggZmlsbC1ydWxlPSJldmVub2RkIiBjbGlwLXJ1bGU9ImV2ZW5vZGQiIGZpbGw9IiNGRkZGRkYiIGQ9Ik0xLjMzLDI4Ljk3bDExLjY0LTExLjY0YzAuNDU5LTAuNDU5LDEuMjA0LTAuNDU5LDEuNjYzLDAKCWMwLjQ1OSwwLjQ1OSwwLjQ1OSwxLjIwNCwwLDEuNjYzTDIuOTkzLDMwLjYzM2MtMC40NTksMC40NTktMS4yMDQsMC40NTktMS42NjMsMEMwLjg3MSwzMC4xNzQsMC44NzEsMjkuNDMsMS4zMywyOC45N3oiLz4KPHBhdGggZmlsbC1ydWxlPSJldmVub2RkIiBjbGlwLXJ1bGU9ImV2ZW5vZGQiIGZpbGw9IiNGRkZGRkYiIGQ9Ik0yLjk5MywxNy4zM2wxMS42NDEsMTEuNjRjMC40NTksMC40NTksMC40NTksMS4yMDQsMCwxLjY2MwoJcy0xLjIwNCwwLjQ1OS0xLjY2MywwTDEuMzMsMTguOTkzYy0wLjQ1OS0wLjQ1OS0wLjQ1OS0xLjIwNCwwLTEuNjYzQzEuNzg5LDE2Ljg3MSwyLjUzNCwxNi44NzEsMi45OTMsMTcuMzN6Ii8+Cjwvc3ZnPgo=);
            background-repeat: no-repeat;
            background-position: 0 0;
            -webkit-transition: -webkit-transform .3s ease-out 0s;
            -moz-transition: -moz-transform .3s ease-out 0s;
            -o-transition: -moz-transform .3s ease-out 0s;
            -ms-transition: -ms-transform .3s ease-out 0s;
            transition: transform .3s ease-out 0s;
            -webkit-transform: rotate(0deg);
            -moz-transform: rotate(0deg);
            -o-transform: rotate(0deg);
            -ms-transform: rotate(0deg);
            transform: rotate(0deg);
        }

        .navbar-minimal > .navbar-menu {
            position: absolute;
            top: -1000px;
            left: 0px;
            margin: 0px;
            padding: 0px;
            list-style: none;
            z-index: 50;
            background-color: rgb(51, 51, 51);
            background-color: rgb(255, 255, 255);
        }
        .navbar-minimal > .navbar-menu > li {
            margin: 0px;
            padding: 0px;
            border-width: 0px;
            height: 54px;
        }
        .navbar-minimal > .navbar-menu > li > a {
            position: relative;
            color: rgb(255, 255, 255);
            padding: 20px 23px;
            text-align: left;
            cursor: pointer;
            border-bottom: 1px solid rgb(81, 81, 81);
            width: 100%;
            text-decoration: none;
            margin: 0px;
        }

        .navbar-minimal > .navbar-menu > li > a:last-child {
            border-bottom-width: 0px;
        }
        .navbar-minimal > .navbar-menu > li > a:hover {
            background-color: rgb(158, 202, 59);
        }
        .navbar-minimal > .navbar-menu > li > a > .glyphicon {
            float: right;
        }

        .navbar-minimal.open > .navbar-toggler > span {
            background-position: 0 -16px;
            -webkit-transform: rotate(-180deg);
            -moz-transform: rotate(-180deg);
            -o-transform: rotate(-180deg);
            -ms-transform: rotate(-180deg);
            transform: rotate(-180deg);
        }

        .navbar-minimal.open > .navbar-menu {
            top: 31px;
            width: 100%;
            min-height: 100%;
        }


        @media (min-width: 768px) {
            .navbar-minimal.open {
                width: 500px;
            }
            .navbar-minimal.open > .navbar-menu {
                overflow: visible;
            }
            .navbar-minimal > .navbar-menu > li > a > .desc {
                position: absolute;
                display: inline-block;
                top: 50%;
                left: 130px;
                margin-top: -20px;
                margin-left: 20px;
                text-align: left;
                white-space: nowrap;
                padding: 10px 13px;
                border-width: 0px !important;
                background-color: rgb(51, 51, 51);
                background-color: rgba(51, 51, 51, 0.8);
                opacity: 0;
            }
            .navbar-minimal > .navbar-menu > li > a > .desc:after {
                z-index: -1;
                position: absolute;
                top: 50%;
                left: -10px;
                margin-top: -10px;
                content:'';
                width: 0;
                height: 0;
                border-top: 10px solid transparent;
                border-bottom: 10px solid transparent;
                border-right: 10px solid rgb(51, 51, 51);
                border-right-color: rgba(51, 51, 51, 0.8);
            }
            .navbar-minimal > .navbar-menu > li > a:hover > .desc {
                left: 60px;
                opacity: 1;
            }
        }
 /*End кнопки*/
        table.dataTable tbody tr:hover
        {
            background-color:#ececec;
            box-shadow:none;
            cursor: hand;
        }
        .form-control {
            width: 100%;
            background: #fff;
            box-shadow: none !important;
            border-color: #e3e3e3;
        }
        .form-control:focus {
            border-color: #70c5c0;
        }
        .form-control, .btn {
            border-radius: 2px;
            padding: 3px 5px;
        }


        .login-form form  {
            color: #191818;
            border-radius: 2px;
            font-weight: inherit;

            font-size: 13px;

            position: relative;
        }
        body {
            background: url("resources/fon.png");
        }

        .nav > li > a {
            font-weight: bold;
            padding: 5px 5px;
        }

        .options > nav > li {
            border-bottom: 1px #777;
            border-bottom-style: dotted;

        }
        .dropdown-menu > li > a {
            font-size: 12px;
            font-weight: bold;
            color:green;
            border-bottom: 1px #777 solid;
            border-bottom-style: dotted;
        }
        .dropdown-menu > li > a:hover {
            color: #FFFFFF;
            background: #337AB7;
        }

    </style>
</head>
<body>
<div class="container-fluid">
    <nav style="box-shadow: 0px 3px 6px rgba(0, 0, 0, 0.3);" class="navbar navbar-default navbar-fixed-top">


        <nav id="menu" class="navbar navbar-fixed-left navbar-minimal animate" role="navigation" style="min-width: 158px">

            <div class="navbar-toggler animate">
                <span class="menu-icon">
                </span>
            </div>
            <ul class="navbar-menu animate">


                    <div class="col-md-6 col-sm-6 col-xs-6" style="padding-top: 10px ">
                        <input id="firstdate" type="text" placeholder="Дата выплаты..." readonly="true" class="form-control" style="background-color:#eee; text-transform: uppercase">
                        <label style="display: none; color: #c33d3d;" id="datebag" >Не введена дата выплаты!</label>
                        <label style="display: none; color: #c33d3d;" id="datefix" >Проверьте диапазон!</label>
                    </div>

                    <div class="col-md-6 col-sm-6 col-xs-6" style="padding-top: 10px">
                        <input id="lastdate" type="text" placeholder="" readonly="true" class="form-control" style="background-color:#eee; text-transform: uppercase">
                    </div>
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <input type="checkbox"id="dis" style="float: left;">
                    <label for="dis" style="color: black;float: left;">Диапазон.</label>
                    <label for="Payment" style="color: black; float: right">Выплата недополученных сумм.</label>
                    <input type="checkbox"id="Payment" style="float: right">
                </div>

                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <%--<label style="color: white">Способ выплаты:</label>--%>
                       <select id="listpay" class="form-control"/>
                        <option value="0" label="Любой способ выплаты"/>
                        <c:forEach var="pay" items="${pays}">
                            <option value="${pay.id}" label="${pay.value}"/>
                        </c:forEach>
                        </select>
                    </div>

                    <div class="col-md-4 col-sm-4 col-xs-4" style="padding-top: 10px">
                    <input id="totalpayment" type="text" placeholder="№ расчёта" class="form-control" style="text-transform: uppercase"/>
                    </div>

                    <div class="col-md-4 col-sm-4 col-xs-4" style="padding-top: 10px">
                    <input id="payrollnumber" type="text" placeholder="№ ведомости" class="form-control" style="text-transform: uppercase"/>
                    </div>

                    <div class="col-md-4 col-sm-4 col-xs-4" style="padding-top: 10px">
                    <input id="casenum" type="text" placeholder="№ дела" class="form-control" style="text-transform: uppercase"/>
                    </div>

                    <div class="col-md-4 col-sm-4 col-xs-4" style="padding-top: 10px">
                        <input id="surname" type="text" placeholder="Фамилия" class="form-control" style="text-transform: uppercase"/>
                    </div>

                    <div class="col-md-4 col-sm-4 col-xs-4" style="padding-top: 10px">
                        <input id="name" type="text" placeholder="Имя" class="form-control" style="text-transform: uppercase"/>
                    </div>

                    <div class="col-md-4 col-sm-4 col-xs-4" style="padding-top: 10px">
                        <input id="patname" type="text" placeholder="Отчество" class="form-control" style="text-transform: uppercase"/>
                    </div>

                <div class="col-md-12 col-sm-12 colo-xs-12" style="padding-top: 5px">
                    <label style="display: none; color: #c33d3d;" id="box" >Недостаточно данных для поиска. Заполните одно из полей (Способ выплаты, № дела или Фамилию)</label>
                </div>
                <div class="col-md-12 col-sm-12 col-xs-12" style="padding: 0px">
                    <div class="input-group" style="padding-bottom: 10px;">
                        <div class="input-group-btn">
                            <div style="
                                                       padding-left: 0px;
                                                       ght: 0px;
                                                       border-bottom-right-radius: 0px;">
                                <div  class="col-md-4 col-sm-4 col-xs-4" style="padding-top: 10px;">
                                    <div class="progress-bar progress-bar-striped active" id="load" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="display:none; font-weight: bold; width: 100%; line-height: 200%; font-size: 14px;">
                                        <span class="glyphicon glyphicon-refresh"></span> ЗАГРУЗКА
                                    </div>
                                <button id="search-btn" style="font-weight: bold;
                                                               border-bottom-right-radius: 0px;
                                                               border-top-right-radius: 0px;
                                                               " type="button" class="btn btn-info btn-block">
                                    <span class="glyphicon glyphicon-search"></span>   ПОИСК
                                </button>
                                </div>
                                    <div  class="col-md-4 col-sm-4 col-xs-4" style="padding-top: 10px; float: right;">
                                <button id="search-clear-btn" style="float:right;font-weight:bold; " type="button" class="btn btn-default btn-block">
                                    <span class="glyphicon glyphicon-trash"></span>  ОЧИСТИТЬ
                                </button>
                                </div>

                            </div>
                        </div>
                    </div>
            </div>
                <div id="divcheck">
                <input type="checkbox"id="Check">
                <label for="Check" style="color: black;">Показывать краткую и дополнительную информацию по делу.</label>
                </div>
            </ul>
        </nav>

        <div class="container"   style="margin-right: 0px;">
            <ul class="nav navbar-nav navbar-right" >
                <li><a><span class="glyphicon glyphicon-user"></span> ${user.getName()} ${user.getSurname()} </a></li>
                <li><a href="logout" id="End"><span id="End1" class="glyphicon glyphicon-log-in"></span>   Выйти</a></li>
            </ul>
        </div>
    </nav>

    <div style="margin-top: 35px;" class="row">
        </div>
        <div style="display:none; background: #fff;
                         padding: 5px;
                         box-shadow: 0px 3px 6px rgba(0, 0, 0, 0.3);
                         margin-bottom: 2px;" class="col-md-12" id="infoTable">
            <table id="tbl-persons" class="table table-sm table-striped table-hover table-bordered" style=" content: none; width:100%;font-size: 12px;">
                <thead>
                <th>Мес. выпл.</th>
                <th>№ расч.</th>
                <th>№ вед.</th>
                <th>№ дела</th>
                <th>Получатель</th>
                <th>Дата рожд.</th>
                <th>Идентиф. номер.</th>
                <th>Ист. фин.</th>
                <th>Сумма</th>
                <th>За дост.</th>
                <th>№ назн./уд.</th>
                <th>№ баз. назн.</th>
                <th>Вид выпл.</th>
                <th>Выпл. за мес.</th>
                <th>Причина невыплаты</th>
                <th>Спос. выпл.</th>
                <th>Орг. выпл.</th>
                <th>Дост. уч.</th>
                <th>День дост.</th>
                <th>Банк</th>
                <th>День обсл. банка</th>
                <th>Лиц. счёт</th>
                <th>Заявл. с</th>
                <th>Заявл. по</th>
                <th>Нас. пункт</th>
                <th>Улица</th>
                <th>Дом</th>
                <th>Корпус</th>
                <th>Кв.</th>
                <th>IDrecipt</th>
                <th>RPRid</th>
                <th>CID</th>
                <th>Из др. р-на</th>
                <th>Отделение почт. связи</th>
                <th>Код региона</th>
                <th>Дата факт. выпл</th>
                <th>Кем получена</th>
                <th>Выпл. на почту/дом</th>
                <th>Номер вед. при дост. на дом</th>
                </thead>
                <tfoot>
                <tr>
                    <th colspan="8" style="text-align:left"></th>
                    <th></th>
                    <th></th>
                    <th colspan="29" style="text-align:right"></th>
                </tr>
                </tfoot>
                 </table>
        </div>

    <div style=" display:none; background: #fff;
                         padding: 5px;
                         box-shadow: 0px 3px 6px rgba(0, 0, 0, 0.3);
                         margin-bottom: 2px;" class="col-md-12" id="personsTable">
        <table id="tbl-persons-4" class="table table-sm table-striped table-hover table-bordered" style=" content: none; width:100%;font-size: 12px;">
            <thead>
            <th>Идентиф. дела</th>
            <th>Аннулировано</th>
            <th>№ назначения</th>
            <th>Недополуч. сумма</th>
            <th>Колич. долей</th>
            <th>№ доли</th>
            <th>Получатель</th>
            <th>Родственная связь</th>
            <th>Идентификационный №</th>
            <th>Дата рождения</th>
            <th>Адрес</th>
            <th>Тип док.</th>
            <th>№ док.</th>
            <th>Серия</th>
            <th>Док. выдан</th>
            <th>Кем выдан</th>
            <th>Сумма доли</th>
            <th>Дата расчета</th>
            <th>Поручение в организацию</th>
            <th>Дата выдачи поручения</th>
            <th>Кем выдано поручение</th>
            </thead>
        </table>
    </div>

    <div id="dop_inf" style="display:none;">
    <ul class="nav nav-tabs" id="inf_button">
        <li id="first_tab" class="active"><a data-toggle="tab" href="#tbl-info-1">Краткая информация</a></li>
        <li  id="second_tab"> <a data-toggle="tab" href="#tbl-info-2">Дополнительная информация</a></li>
    </ul>

    <div class="tab-content">
        <div id="tbl-info-1" class="tab-pane fade in active"  style="
        background: #fff;
                         padding: 5px;
                         box-shadow: 0px 3px 6px rgba(0, 0, 0, 0.3);">
            <table class="table table-sm table-striped table-hover table-bordered" style="width:100%;font-size: 12px;" id="qtbl-info-1">
                <thead style="width: 100%" id="qtbl-info-1-1">
                <th>Способ выпл.</th>
                <th>Банк</th>
                <th>№ лиц. счёта</th>
                <th>Заявление с</th>
                <th>Заявление по</th>
                <th>Дата обслуживания</th>
                <th>Почта</th>
                <th>Доставочный</th>
                <th>День доставки</th>
                </thead>
            </table>
        </div>
        <div id="tbl-info-2" class="tab-pane fade" style=" background: #fff;
                         padding: 5px;
                         box-shadow: 0px 3px 6px rgba(0, 0, 0, 0.3);">
            <table class="table table-sm table-striped table-hover table-bordered" style="width:100%;font-size: 12px;" id="qtbl-info-2">
                <thead style="width: 100%" id="qtbl-info-2-1">
                <th>Ист. фин.</th>
                <th>Сумма за месяц</th>
                <th>Сумма за период</th>
                <th>% к выпл.</th>
                <th>Начало периода</th>
                <th>Конец периода</th>
                <th>Не выплачивать</th>
                <th>Вид назн./уд</th>
                </thead>
            </table>
            <table class="table table-sm table-striped table-hover table-bordered" style="width:100%;font-size: 12px;" id="qtbl-info-3">
                <thead style="width: 100%" id="qtbl-info-3-1">
                <th>Вид удерж./назнач.</th>
                <th>Источник Финансирования</th>
                <th>Сумма удержания</th>
                <th>Сумма получателю</th>
                <th>Сумма к выпл.</th>
                <th>Задолж. по удерж.</th>
                <th>Переплата</th>
                <th>Сумма за почт. усл.</th>
                <th>Начало периода</th>
                <th>Конец периода</th>
                <th>Задолж. за почт. усл.</th>
                <th>Вид назначения</th>
                </thead>
            </table>
        </div>
    </div>
    </div>


</div>
<script>
    $(document).ready(function () {
        document.getElementById("menu").className +=' open';
        jQuery.extend(jQuery.fn.dataTableExt.oSort, {
            "extract-date-pre": function (value) {
                var date = value;
                if(date != null) {
                    date = date.split('.');
                    return Date.parse(date[1] + '.' + date[0] + '.' + date[2])
                } else {
                    return Infinity;
                }
            },
            "extract-date-asc": function (a, b) {
                return ((a < b) ? -1 : ((a > b) ? 1 : 0));
            },
            "extract-date-desc": function (a, b) {
                return ((a < b) ? 1 : ((a > b) ? -1 : 0));
            }
        });


        dTable.buttons().container().appendTo( '#tbl-persons_wrapper .col-sm-6:eq(0)' );
        $('#divcheck').detach().appendTo('#tbl-persons_wrapper .col-sm-6:eq(1)');

        rTable.buttons().container()
            .appendTo( '#tbl-persons-4_wrapper .col-sm-6:eq(0)' );

        var qTable = $('#qtbl-info-1').DataTable({
            "scrollCollapse": true,
            "paging" : false,
            "scrollX": true,
            "searching" : false,
            "processing":true,
            "info": false,
            "ordering": false,
            columns: [
                { data: 'vspl' },
                { data: 'bank' },
                { data: 'personal_Acct' },
                { data: 'application_Date' },
                { data: 'application_Date_End' },
                { data: 'service_Day' },
                { data: 'coffice' },
                { data: 'delivery_Site' },
                { data: 'delivery_Day' },
             ],

            "language": {
                "processing": "Подождите...",
                "search": "Поиск:",
                "lengthMenu": "Показать _MENU_ записей",
                "info": "Количество найденых записей _TOTAL_",
                "infoEmpty": "Количество найденых записей _TOTAL_",
                "infoFiltered": "(отфильтровано из _MAX_ записей)",
                "infoPostFix": "",
                "loadingRecords": "Загрузка записей...",
                "zeroRecords": "Записи отсутствуют.",
                "emptyTable": "Поиск не дал результатов.",
                "paginate": {
                    "first": "Первая",
                    "previous": "Предыдущая",
                    "next": "Следующая",
                    "last": "Последняя"
                },
                "aria": {
                    "sortAscending": ": активировать для сортировки столбца по возрастанию",
                    "sortDescending": ": активировать для сортировки столбца по убыванию"
                }
            }

        });

        var wTable = $('#qtbl-info-2').DataTable({
            "scrollCollapse": true,
            "paging" : false,
            "scrollX": true,
            "searching" : false,
            "processing":true,
            "info":false,
            "ordering": false,
            columns: [
                { data: 'finance_Source' },
                { data: 'month_Amount' },
                { data: 'period_Amount' },
                { data: 'payment_Percent' },
                { data: 'period_Start' },
                { data: 'period_End' },
                { data: 'payment_Flag' },
                { data: 'alloc_Code' },
            ],
            "language": {
                "processing": "Подождите...",
                "search": "Поиск:",
                "lengthMenu": "Показать _MENU_ записей",
                "info": "Количество найденых записей _TOTAL_",
                "infoEmpty": "Количество найденых записей _TOTAL_",
                "infoFiltered": "(отфильтровано из _MAX_ записей)",
                "infoPostFix": "",
                "loadingRecords": "Загрузка записей...",
                "zeroRecords": "Записи отсутствуют.",
                "emptyTable": "Поиск не дал результатов.",
                "paginate": {
                    "first": "Первая",
                    "previous": "Предыдущая",
                    "next": "Следующая",
                    "last": "Последняя"
                },
                "aria": {
                    "sortAscending": ": активировать для сортировки столбца по возрастанию",
                    "sortDescending": ": активировать для сортировки столбца по убыванию"
                }
            }

        });

        var eTable = $('#qtbl-info-3').DataTable({
            "scrollCollapse": true,
            "paging" : false,
            "scrollX": true,
            "searching" : false,
            "processing":true,
            "info":false,
            "ordering": false,
            columns: [
                { data: 'alloc_Code' },
                { data: 'finance_Source' },
                { data: 'amount_Deduction' },
                { data: 'amount_Recipient' },
                { data: 'amount_Payment' },
                { data: 'libilities' },
                { data: 'overpayment' },
                { data: 'post_Amount' },
                { data: 'period_Start' },
                { data: 'period_End' },
                { data: 'post_Liab' },
                { data: 'alloc_Code_Alloc' },
            ],
            "language": {
                "processing": "Подождите...",
                "search": "Поиск:",
                "lengthMenu": "Показать _MENU_ записей",
                "info": "Количество найденых записей _TOTAL_",
                "infoEmpty": "Количество найденых записей _TOTAL_",
                "infoFiltered": "(отфильтровано из _MAX_ записей)",
                "infoPostFix": "",
                "loadingRecords": "Загрузка записей...",
                "zeroRecords": "Записи отсутствуют.",
                "emptyTable": "Поиск не дал результатов.",
                "paginate": {
                    "first": "Первая",
                    "previous": "Предыдущая",
                    "next": "Следующая",
                    "last": "Последняя"
                },
                "aria": {
                    "sortAscending": ": активировать для сортировки столбца по возрастанию",
                    "sortDescending": ": активировать для сортировки столбца по убыванию"
                }
            }

        });

        $('#search-btn').click(function () {


            if (document.getElementById('dis').checked || $.trim($("#firstdate").val()).length > 0) {
                $("#datebag").hide();

               if (document.getElementById('dis').checked && $.trim($("#lastdate").val()).length > 0) {
                var period1 = $("#firstdate").val();

                var month1 = Number(period1.substring(0, 2));
                var year1 = Number(period1.substring(3, 8));
                var date1 = new Date(year1, month1, 1);

                var period2 = $("#lastdate").val();

                var month2 = Number(period2.substring(0, 2));
                var year2 = Number(period2.substring(3, 8));
                var date2 = new Date(year2, month2, 1);

                var listpay = Number($("#listpay").val());

                if (document.getElementById('Payment').checked == false && document.getElementById('dis').checked && $.trim($("#lastdate").val()).length > 0 && $.trim($("#firstdate").val()).length > 0 && date1 >= date2 ) {
                    $("#box").hide();
                    $("#datefix").show();
                }

                else {
                    $("#datefix").hide();
                    if (document.getElementById('Payment').checked == false && $("#casenum").val() == '' && $("#surname").val() == '' && listpay == 0) {
                        $("#box").show();
                    }

                    else {
                        dTable.clear();
                        qTable.clear();
                        wTable.clear();
                        eTable.clear();
                        rTable.clear();
                        $("#box").hide();
                        $("#search-btn").hide();
                        $("#infoTable").hide();
                        $("#dop_inf").hide();

                        $("#load").show();
                        seacrhByParameter();
                    }
                }
            }

            else{
                   if(document.getElementById('dis').checked)
                   {
                       $("#datefix").show();
                       $("#box").hide();
                   }
                   else{
                       dTable.clear();
                       qTable.clear();
                       wTable.clear();
                       eTable.clear();
                       rTable.clear();
                       $("#datefix").hide();
                       $("#search-btn").hide();
                       $("#box").hide();
                       $("#infoTable").hide();
                       $("#dop_inf").hide();
                       $("#load").show();
                       seacrhByParameter();
                   }
                }
            }
            else {
                $("#datebag").show();
            }
        });

        var seacrhByParameter = function () {
            var ff = $("#firstdate").val();
            if(ff.length > 0) {
                ff = '01.' + ff;
            }
            var fl = $("#lastdate").val();
            if(fl.length > 0) {
                fl = '01.' + fl;
            }

            var model = {
                firstDate :  ff,
                lastDate :  fl,
                pay: $("#listpay").val(),
                caseNum : $("#casenum").val(),
                totalPayment : $("#totalpayment").val(),
                payrollNumber : $("#payrollnumber").val(),
                surname :  $("#surname").val().toUpperCase(),
                name :  $("#name").val().toUpperCase(),
                patname :  $("#patname").val().toUpperCase(),
            };
            if (document.getElementById('Payment').checked) {
                var q = window.innerHeight - 230;
                $( "#personsTable" ).parent().css( "max-height", q );
                $("#infoTable").hide();
                var period = $("#firstdate").val();
                var month = Number(period.substring(0, 2));
                var year = Number(period.substring(3, 8));
                var date = new Date(year, month, 0);
                var end = date.getDate() + "." + period.substring(0, 2) + "." + period.substring(3, 8);
                $.ajax({
                    type: 'POST',
                    contentType : "application/json",
                    data : JSON.stringify(model),
                    dataType : 'json',
                    async: true,
                    url: '/service/persons?pstart=' + ff + '&pend=' + end,
                    success: function (data, textstatus) {

                        if (data.length > 0) {
                            rTable.rows.add(data);
                        }
                        $("#load").hide();
                        $("#personsTable").show();
                        $("#tbl-persons-4").show();
                        rTable.draw();
                        $("#search-btn").show();
                        document.getElementById("menu").className =
                            document.getElementById("menu").className.replace
                            ( /(?:^|\s)open(?!\S)/g , '' );
                    },
                    error:function(jqXHR, textStatus, errorThrown) {
                        var loc = window.location.origin;
                        window.location.replace(loc+"/logout");
                    }
                });
               }

            else{

                var q = window.innerHeight - 230;
                $( "#tbl-persons" ).parent().css( "max-height", q );
                $('#tbl-persons_filter').hide();

                $("#personsTable").hide();
                $.ajax({
                    type: 'POST',
                    contentType : "application/json",
                    data : JSON.stringify(model),
                    dataType : 'json',
                    async: true,
                    url: '/service/search',
                    success: function (data, textstatus) {


                        if (data.length > 0) {
                            dTable.rows.add(data);
                        }
                        $("#load").hide();
                        $("#infoTable").show();
                        dTable.draw();
                        $("#search-btn").show();
                        document.getElementById("menu").className =
                            document.getElementById("menu").className.replace
                            ( /(?:^|\s)open(?!\S)/g , '' );

                    },
                   error:function(jqXHR, textStatus, errorThrown) {
                       var loc = window.location.origin;
                        window.location.replace(loc+"/logout");
                    }
                });
            }
        }


        $("#second_tab").on('shown.bs.tab', function () {

            wTable.draw(true);
            eTable.draw(true);
        });

        $("#first_tab").on('shown.bs.tab', function () {

            qTable.draw(true);
        });



         $("#search-clear-btn").click(function() {
            $("#firstdate").val('');
            $("#lastdate").val('');
            $("#listpay").val(0);
            $("#casenum").val('');
            $("#payrollnumber").val('');
            $("#totalpayment").val('');
            $("#surname").val('');
            $("#name").val('');
            $("#patname").val('');
            $("#datebag").hide();
            $("#datefix").hide();
            $("#datefix").hide();
            $("#box").hide();
            $("#datebag2").hide();

        });

        $('.navbar-toggler').on('click', function(event) {
            event.preventDefault();
            $(this).closest('.navbar-minimal').toggleClass('open');
        });

        $('#tbl-persons-4').on('click', 'tr', function () {

            if ( $(this).hasClass('selected') ) {
                $(this).removeClass('selected');

            }
            else {
                $('#tbl-persons-4').DataTable().$('tr.selected').removeClass('selected');
                $(this).addClass('selected');

            }});

        $('#tbl-persons').on('click', 'tr', function () {

            if ( $(this).hasClass('selected') ) {
                $(this).removeClass('selected');

            }
            else {
                $('#tbl-persons').DataTable().$('tr.selected').removeClass('selected');
                $(this).addClass('selected');

            }
            // $(this).css('background-color','yellow');
            if (document.getElementById('Check').checked) {
                var d = window.innerHeight*0.15;
                $( "#qtbl-info-1" ).parent().css( "max-height", d );
                $( "#qtbl-info-2" ).parent().css( "max-height", d );
                var q = window.innerHeight - 230 - window.innerHeight*0.21;
                    $( "#tbl-persons" ).parent().css( "max-height", q );
                $("#dop_inf").show();
                qTable.clear();
                qTable.draw();
                var rowData = dTable.row(this).data();
                var recipient_rid = rowData.recipient_rid;
                var rid = rowData.rid;
                var cid = rowData.cid;
                var period = rowData.period;

                var month = Number(period.substring(3, 5));
                var year = Number(period.substring(6, 10));
                var date = new Date(year, month, 0);
                var end = date.getDate() + "." + period.substring(3, 5) + "." + period.substring(6, 10);
                var base_aid = Number(rowData.base_aid);

                $.ajax({
                    type: 'GET',
                    contentType: "application/json",
                    dataType: 'json',
                    async: true,
                    url: '/service/search?id=' + recipient_rid,
                    success: function (data, textstatus) {
                        qTable.clear();
                        qTable.draw();
                        if (data.length > 0) {
                            qTable.rows.add(data);
                        }
                        qTable.draw(true);


                    }

                });

                if (base_aid == 0) {
                    var d = window.innerHeight*0.15;
                    $( "#qtbl-info-3" ).parent().css( "max-height", d );
                    $("#qtbl-info-3").hide();
                    $("#qtbl-info-3_wrapper").hide();
                    $("#qtbl-info-3-1").hide();
                    $.ajax({
                        type: 'GET',
                        contentType: "application/json",
                        dataType: 'json',
                        async: true,
                        url: '/service/deduction?rid=' + rid + '&cid=' + cid + '&pstart=' + period + '&pend=' + end,
                        success: function (data, textstatus) {
                            wTable.clear();
                            if (data.length > 0) {
                                wTable.rows.add(data);

                            }
                            wTable.draw(true);
                        }
                    });
                    $("#qtbl-info-2").show();
                    $("#qtbl-info-2_wrapper").show();
                    $("#qtbl-info-2-1").show();
                }
                else {
                    $("#qtbl-info-2").hide();
                    $("#qtbl-info-2_wrapper").hide();
                    $("#qtbl-info-2-1").hide();

                    $.ajax({
                        type: 'GET',
                        contentType: "application/json",
                        dataType: 'json',
                        async: true,
                        url: '/service/all?rid=' + rid,
                        success: function (data, textstatus) {
                            eTable.clear();
                            if (data.length > 0) {
                                eTable.rows.add(data);
                            }
                            eTable.draw(true);

                        }
                    });
                    $("#qtbl-info-3").show();
                    $("#qtbl-info-3_wrapper").show();
                    $("#qtbl-info-3-1").show();
                }
            }
            else
            {
                $("#dop_inf").hide();
            }
        });


    });


    // Фильтры для таблицы
        $('#tbl-persons thead tr').clone(true).appendTo('#tbl-persons thead');
        $('#tbl-persons thead tr:eq(1) th').each(function (i) {
            var title = $(this).text();
            $(this).html('<input class="form-control input-sm" type="text" style="width: 100%;" placeholder="' + title + '" />');

            $('input', this).on('keypress',function(e) {
                if(e.which == 13) {
                    if (dTable.column(i).search() !== this.value) {
                        dTable
                            .column(i)
                            .search(this.value)
                            .draw(true);
                    }
                }
            });

//            $('input', this).on('change', function () {
//                if (dTable.column(i).search() !== this.value) {
//                    dTable
//                        .column(i)
//                        .search(this.value)
//                        .draw(true);
//                }
//            });
        });


    var dTable = $('#tbl-persons').DataTable({
        sAutoWidth: false,
        lengthChange: false,
        orderCellsTop: true,
        fixedHeader: true,
        buttons: [{
            extend: 'excelHtml5',
            text: 'Экспортировать в Excel',
            exportOptions: {
                columns: ':visible',
            },
//            footer: true,
            sheetName: 'Лист 1',
        }, {
            extend: 'colvis',
            text: 'Выбор колонок для отображения',
            exportOptions: {}
        }],

        "deferRender": true,
        "scrollCollapse": true,
        "scroller": true,
        "info": false,
        "pageLength": 500,
        "searching": true,
        "scrollX": true,
        "processing": true,
        'columnDefs': [{
            type: 'extract-date',
            targets: [0, 5, 13, 22, 23]
        }, { targets: 29, visible: false }, { targets: 30, visible: false }, { targets: 31, visible: false }],

        columns: [{ data: 'period' }, { data: 'total_payment' }, { data: 'payroll_no' }, { data: 'case_num' }, { data: 'fio' }, { data: 'birth_date' }, { data: 'lik' }, { data: 'finance_source' }, { data: 'pay_amount' }, { data: 'service' }, { data: 'aid' }, { data: 'base_aid' }, { data: 'base_aid_value' }, { data: 'accounting_period' }, { data: 'non_payment_reason' }, { data: 'payment_form' }, { data: 'delivary_org' }, { data: 'delivary_site' }, { data: 'delivary_day' }, { data: 'bank_org' }, { data: 'service_day' }, { data: 'personal_acct' }, { data: 'application_date' }, { data: 'application_date_end' }, { data: 'site' }, { data: 'street' }, { data: 'house' }, { data: 'house_x' }, { data: 'appt' }, { data: 'recipient_rid' }, { data: 'rid' }, { data: 'cid' }, { data: 'import_data' }, { data: 'zip_pay_back' }, { data: 'region' }, { data: 'pay_date' }, { data: 'who_recipt' }, { data: 'post_or_home' }, { data: 'post_payroll' }],

        "language": {
            "processing": "Подождите...",
            "search": "Фильтр по таблице",
            "lengthMenu": "Показать _MENU_ записей",
            "info": "Количество найденых записей _TOTAL_",
            "infoEmpty": "Количество найденых записей _TOTAL_",
            "infoFiltered": "(отфильтровано из _MAX_ записей)",
            "infoPostFix": "",
            "loadingRecords": "Загрузка записей...",
            "zeroRecords": "Записи отсутствуют.",
            "emptyTable": "Поиск не дал результатов.",
            "paginate": {
                "first": "Первая",
                "previous": "Предыдущая",
                "next": "Следующая",
                "last": "Последняя"
            },
            "aria": {
                "sortAscending": ": Активировать для сортировки столбца по возрастанию",
                "sortDescending": ": Активировать для сортировки столбца по убыванию"
            }
        },
        'rowCallback': function rowCallback(row, data, index) {
                if(data['import_data']== 1){
                    // $(row).find('td:eq(1)').css('background', '#ff7878');
                    $(row).css('background', '#ff7878');
                }

            $(row).find('td:eq(2)').css('background', 'rgba(0, 137, 255, 0.44)');
            $(row).find('td:eq(3)').css('background', 'rgba(0, 137, 255, 0.44)');
            $(row).find('td:eq(8)').css('background', 'rgba(0, 255, 149, 0.22)');
        },
        "footerCallback": function footerCallback(row, data, start, end, display) {
            var api = this.api();

            // Remove the formatting to get integer data for summation
            var intVal = function intVal(i) {
                return typeof i === 'string' ? i.replace(/[\$,]/g, '') * 1 : typeof i === 'number' ? i : 0;
            };
            count = display.length;
            // Total over all pages
            totalq = display.map(function (el) {
                return data[el]['service'];
            }).reduce(function (a, b) {
                return parseFloat((intVal(a) + intVal(b)).toFixed(3));
            }, 0);

            sum = display.map(function (el) {
                return data[el]['pay_amount'];
            }).reduce(function (a, b) {
                return parseFloat((intVal(a) + intVal(b)).toFixed(3));
            }, 0);

            $(api.column(0).footer()).html("Количество найденных записей: " + count);
            // Update footer
            $(api.column(8).footer()).css('background', 'rgb(149, 205, 182)');
            $(api.column(8).footer()).html(sum);
            $(api.column(9).footer()).html(totalq);

            $('#lastdate').datepicker({
                format: 'mm.YYYY',
                months: ['Январь', 'Февраль', 'Март', 'Апрель', 'Май', 'Июнь', 'Июль', 'Август', 'Сентябрь', 'Октябрь', 'Ноябрь', 'Декабрь'],
                monthsShort: ['Янв', 'Фев', 'Март', 'Апр', 'Май', 'Июнь', 'Июль', 'Авг', 'Сен', 'Окт', 'Ноя', 'Дек'],
                zIndex: 2000,
                startView: 1,
                autoHide: true
            });

            $('#firstdate').datepicker({
                format: 'mm.YYYY',
                months: ['Январь', 'Февраль', 'Март', 'Апрель', 'Май', 'Июнь', 'Июль', 'Август', 'Сентябрь', 'Октябрь', 'Ноябрь', 'Декабрь'],
                monthsShort: ['Янв', 'Фев', 'Март', 'Апр', 'Май', 'Июнь', 'Июль', 'Авг', 'Сен', 'Окт', 'Ноя', 'Дек'],
                zIndex: 2000,
                startView: 1,
                autoHide: true
            });

            var loadDate = function loadDate() {
                var enddata = data[0];
                $.ajax({
                    type: 'GET',
                    contentType: "application/json",
                    dataType: 'json',
                    async: true,
                    url: '/service/date',
                    success: function success(data, textstatus) {
                        var datepicker = $('#lastdate');

                        var st1 = data[data.length - 1];
                        var pattern1 = /(\d{2})\.(\d{2})\.(\d{4})/;
                        var dt1 = new Date(st1.replace(pattern1,'$3-$2-$1'));

                        datepicker.datepicker('setStartDate', dt1);

                        var st2 = data[0];
                        var pattern2 = /(\d{2})\.(\d{2})\.(\d{4})/;
                        var dt2 = new Date(st2.replace(pattern2,'$3-$2-$1'));

                        datepicker.datepicker('setEndDate', dt2);
                        datepicker.datepicker('Date', null);

                        var datepicker = $('#firstdate');
                        datepicker.datepicker('setStartDate', dt1);

                        datepicker.datepicker('setEndDate', dt2);
                    }
                });
            };

            loadDate();
        }
    });

    var rTable = $('#tbl-persons-4').DataTable({
        lengthChange: false,

        buttons: [ {
            extend: 'excelHtml5',
            text: 'Экспортировать в Excel',
            exportOptions: {
                columns: ':visible',
            }

        }],

        "deferRender" : true,
        "scrollCollapse": true,
        "scroller": true,
        "info": false,
        "paging" : false,
        "searching" : false,
        "scrollX": true,
        "processing":true,
        columns: [
            { data: 'cid'},
            { data: 'close_date' },
            { data: 'aid' },
            { data: 'amount' },
            { data: 'count_quota' },
            { data: 'heir_number' },
            { data: 'fio' },
            { data: 'alliance' },
            { data: 'lik' },
            { data: 'birth_date' },
            { data: 'address' },
            { data: 'doc_type' },
            { data: 'doc_number' },
            { data: 'doc_series' },
            { data: 'doc_issue_date' },
            { data: 'doc_issue_organization' },
            { data: 'amount_quota' },
            { data: 'calc_date' },
            { data: 'delivery_org' },
            { data: 'entry_date' },
            { data: 'entered_by' },
        ],
        'rowCallback': function(row, data, index){
            var tryt=data['close_date'];
            if(data['close_date']!= null){
               // $(row).find('td:eq(1)').css('background', '#ff7878');
                $(row).css('background', '#ff7878');
                }
        },
        "language": {
            "processing": "Подождите...",
            "search": "Фильтр по таблице",
            "lengthMenu": "Показать _MENU_ записей",
            "info": "Количество найденых записей _TOTAL_",
            "infoEmpty": "Количество найденых записей _TOTAL_",
            "infoFiltered": "(отфильтровано из _MAX_ записей)",
            "infoPostFix": "",
            "loadingRecords": "Загрузка записей...",
            "zeroRecords": "Записи отсутствуют.",
            "emptyTable": "Поиск не дал результатов.",
            "paginate": {
                "first": "Первая",
                "previous": "Предыдущая",
                "next": "Следующая",
                "last": "Последняя"
            },
            "aria": {
                "sortAscending": ": активировать для сортировки столбца по возрастанию",
                "sortDescending": ": активировать для сортировки столбца по убыванию"
            }
        }
    });

    $(document).ready(function(){
        $('#dis').prop('disabled', false);
        $('#casenum').prop('disabled', false);
        $('#payrollnumber').prop('disabled', false);
        $('#totalpayment').prop('disabled', false);
        $('#listpay').prop('disabled', false);
        $('#lastdate').prop('disabled', false);
        $('#surname').prop('disabled', false);
        $('#name').prop('disabled', false);
        $('#patname').prop('disabled', false);
        $('#search-clear-btn').prop('disabled', false);


        $('#Payment').change(function() {


            $('#lastdate').prop('disabled', function(i, val) {
                if (document.getElementById("dis").checked) {
                if(document.getElementById("Payment").checked){
                    document.getElementById("lastdate").style = 'background-color:#c3c3c3; text-transform: uppercase';}
                else{
                    document.getElementById("lastdate").style = 'background-color:#fff; text-transform: uppercase';
                }}
                return !val;
            })
            $('#casenum').prop('disabled', function(i, val) {
                return !val;
            })
            $('#payrollnumber').prop('disabled', function(i, val) {
                return !val;
            })
            $('#totalpayment').prop('disabled', function(i, val) {
                return !val;
            })
            $('#surname').prop('disabled', function(i, val) {
                return !val;
            })
            $('#name').prop('disabled', function(i, val) {
                return !val;
            })
            $('#patname').prop('disabled', function(i, val) {
                return !val;
            })
            $('#listpay').prop('disabled', function(i, val) {
                return !val;
            })
            $('#search-clear-btn').prop('disabled', function(i, val) {
                return !val;
            })
            $('#dis').prop('disabled', function(i, val) {
                return !val;
            })
        });

        document.getElementById("lastdate").style.display ='none';

            $('#dis').change(function() {
                if (document.getElementById("dis").checked) {
                    document.getElementById("lastdate").style.display = '';
                    document.getElementById('firstdate').placeholder = 'Дата выплаты с...';
                    document.getElementById('lastdate').placeholder = 'Дата выплаты по...';

                }

                else
                {
                    document.getElementById('firstdate').placeholder = 'Дата выплаты...';
                    document.getElementById("lastdate").style.display ='none';
                }
            });

            $('#Check').change(function () {
                if ((document.getElementById("Check").checked)){
                }
                else{
                    var q = window.innerHeight - 230;
                    $( "#tbl-persons" ).parent().css( "max-height", q );
                    $("#dop_inf").hide();
                    qTable.clear();
                    wTable.clear();
                    eTable.clear();

                }
            })

        // Start проверки для 3 числовых полей//
        document.getElementsByTagName('input')[4].onkeypress = function(e) {

            e = e || event;

            if (e.ctrlKey || e.altKey || e.metaKey) return;

            var chr = getChar(e);

            if (chr == null) return;

            if (chr < '0' || chr > '9') {
                return false;
            }

        }

        document.getElementsByTagName('input')[5].onkeypress = function(e) {

            e = e || event;

            if (e.ctrlKey || e.altKey || e.metaKey) return;

            var chr = getChar(e);

            if (chr == null) return;

            if (chr < '0' || chr > '9') {
                return false;
            }

        }

        document.getElementsByTagName('input')[6].onkeypress = function(e) {

            e = e || event;

            if (e.ctrlKey || e.altKey || e.metaKey) return;

            var chr = getChar(e);

            if (chr == null) return;

            if (chr < '0' || chr > '9') {
                return false;
            }

        }

        function getChar(event) {
            if (event.which == null) {
                if (event.keyCode < 32) return null;
                return String.fromCharCode(event.keyCode)
            }

            if (event.which != 0 && event.charCode != 0) {
                if (event.which < 32) return null;
                return String.fromCharCode(event.which)
            }

            return null;
        }
        //End проверки для 3 числовых полей//

        // Проверка для символьных полей
        var map = {
            'q' : 'й', 'w' : 'ц', 'e' : 'у', 'r' : 'к', 't' : 'е', 'y' : 'н', 'u' : 'г', 'i' : 'ш', 'o' : 'щ', 'p' : 'з', '[' : 'х', ']' : 'ъ', 'a' : 'ф', 's' : 'ы', 'd' : 'в', 'f' : 'а', 'g' : 'п', 'h' : 'р', 'j' : 'о', 'k' : 'л', 'l' : 'д', ';' : 'ж', '\'' : 'э', 'z' : 'я', 'x' : 'ч', 'c' : 'с', 'v' : 'м', 'b' : 'и', 'n' : 'т', 'm' : 'ь', ',' : 'б', '.' : 'ю','Q' : 'Й', 'W' : 'Ц', 'E' : 'У', 'R' : 'К', 'T' : 'Е', 'Y' : 'Н', 'U' : 'Г', 'I' : 'Ш', 'O' : 'Щ', 'P' : 'З', '[' : 'Х', ']' : 'Ъ', 'A' : 'Ф', 'S' : 'Ы', 'D' : 'В', 'F' : 'А', 'G' : 'П', 'H' : 'Р', 'J' : 'О', 'K' : 'Л', 'L' : 'Д', ';' : 'Ж', '\'' : 'Э', 'Z' : 'Я', 'X' : 'Ч', 'C' : 'С', 'V' : 'М', 'B' : 'И', 'N' : 'Т', 'M' : 'Ь', ',' : 'Б', '.' : 'Ю',
            '`' : 'ё', '~' : 'Ё'
        };

        var localization = function(element) {
            var that = element;
            setTimeout(function() {
                var str = element.val();
                var r = '';
                for (var i = 0; i < str.length; i++) {
                    r += map[str.charAt(i)] || str.charAt(i);
                }
                element.val(r);
            }, 0);
        };

        $('#name').on('keypress', function(key) {
            localization($(this));
           console.log(key.charCode);
            if(key.charCode!=91 && key.charCode!=93 && key.charCode!=59 && key.charCode!=39 && key.charCode!=46 && key.charCode!=44 && key.charCode!=123 && key.charCode!=125 && key.charCode!=58 && key.charCode!=34 && key.charCode!=62 && key.charCode!=63 && key.charCode!=1105 && key.charCode!=1025 && key.charCode!=96 && key.charCode!=126 && (key.charCode < 1072 || key.charCode > 1103) && (key.charCode < 1040 || key.charCode > 1071) && (key.charCode < 97 || key.charCode > 122) && (key.charCode < 65 || key.charCode > 90) && key.charCode!=45)
            {
                return false;
            }
        });

        $('#surname').on('keypress', function(key) {
            localization($(this));
            if(key.charCode!=91 && key.charCode!=93 && key.charCode!=59 && key.charCode!=39 && key.charCode!=46 && key.charCode!=44 && key.charCode!=123 && key.charCode!=125 && key.charCode!=58 && key.charCode!=34 && key.charCode!=62 && key.charCode!=63 && key.charCode!=1105 && key.charCode!=1025 && key.charCode!=96 && key.charCode!=126 && (key.charCode < 1072 || key.charCode > 1103) && (key.charCode < 1040 || key.charCode > 1071) && (key.charCode < 97 || key.charCode > 122) && (key.charCode < 65 || key.charCode > 90)&& key.charCode!=45)
            {
                return false;
            }
        });

        $('#patname').on('keypress', function(key) {
            localization($(this));
            if(key.charCode!=91 && key.charCode!=93 && key.charCode!=59 && key.charCode!=39 && key.charCode!=46 && key.charCode!=44 && key.charCode!=123 && key.charCode!=125 && key.charCode!=58 && key.charCode!=34 && key.charCode!=62 && key.charCode!=63 && key.charCode!=1105 && key.charCode!=1025 && key.charCode!=96 && key.charCode!=126 && (key.charCode < 1072 || key.charCode > 1103) && (key.charCode < 1040 || key.charCode > 1071) && (key.charCode < 97 || key.charCode > 122) && (key.charCode < 65 || key.charCode > 90)&& key.charCode!=45)
            {
                return false;
            }
        });
//       window.onbeforeunload = function() {
//            $.ajax({
//             type: 'GET',
//             url: "/logout",
//             async: false,
//             success: function (data) {
//             },
//             error: function (jqXHR, textStatus, errorThrown) {
//                 var loc = window.location.origin;
//                 window.location.replace(loc+"/logout");
//             }
//         });
//        };
});

</script>
</body>
</html>