<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Контроль выплаты</title>
    <link href="resources/dist/bootstrap.min.css" rel="stylesheet">
    <script src="resources/dist/jquery-1.12.4.min.js"></script>
    <script src="resources/dist/bootstrap.min.js"></script>
    <style>

        body {
            background: #fff url(resources/fon.png);
        }
        .form-control {
            min-height: 41px;
            background: #fff;
            box-shadow: none !important;
            border-color: #e3e3e3;
            border: none;
            border-bottom: 2px #456 solid;
            border-radius: 2px;
            border-radius: 0px;
            background: #FDFBFB;
        }
        .form-control:focus {
            border-color: #70c5c0;
        }
        .form-control, .btn {
            border-radius: 2px;
        }
        .login-form {



            margin:140px auto;
        }
        .login-form form {
            color: #191818;
            border-radius: 2px;
            font-weight: inherit;
            margin-bottom: 15px;
            font-size: 13px;
            background: #FDFBFB;
            box-shadow: 0px 3px 6px rgba(0, 0, 0, 0.3);
            padding: 30px;
            position: relative;
        }
        .login-form h2 {
            font-size: 22px;
            margin: 35px 0 25px;
        }
        .login-form .avatar {
            position: absolute;
            margin: 0 auto;
            left: 0;
            right: 0;
            top: -50px;
            width: 95px;
            height: 95px;
            border-radius: 50%;
            z-index: 9;
            background: #337AB7;
            padding: 15px;
            box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.1);
        }
        .login-form .avatar img {
            width: 100%;
        }
        .login-form input[type="checkbox"] {
            margin-top: 2px;
        }
        .login-form .btn {
            font-size: 16px;
            font-weight: bold;
            background: #337ab7;
            border: none;

        }
        .login-form .btn:hover, .login-form .btn:focus {
            background: #50b8b3;
            outline: none !important;
        }
        .login-form a {
            color: #fff;
            text-decoration: underline;
        }
        .login-form a:hover {
            text-decoration: none;
        }
        .login-form form a {
            color: #7a7a7a;
            text-decoration: none;
        }
        .login-form form a:hover {
            text-decoration: underline;
        }
        .error {
            margin: 0 auto;
            font-size: 14px;
            color: red;
            display: table;
        }

        .effect6
        {
            position:relative;
            -webkit-box-shadow:0 1px 4px rgba(0, 0, 0, 0.3), 0 0 40px rgba(0, 0, 0, 0.1) inset;
            -moz-box-shadow:0 1px 4px rgba(0, 0, 0, 0.3), 0 0 40px rgba(0, 0, 0, 0.1) inset;
            box-shadow:0 1px 4px rgba(0, 0, 0, 0.3), 0 0 40px rgba(0, 0, 0, 0.1) inset;
        }
        .effect6:before, .effect6:after
        {
            content:"";
            position:absolute;
            z-index:-1;
            -webkit-box-shadow:0 0 20px rgba(0,0,0,0.8);
            -moz-box-shadow:0 0 20px rgba(0,0,0,0.8);
            box-shadow:0 0 20px rgba(0,0,0,0.8);
            top:50%;
            bottom:0;
            left:10px;
            right:10px;
            -moz-border-radius:100px / 10px;
            border-radius:100px / 10px;
        }
        .effect6:after
        {
            right:10px;
            left:auto;
            -webkit-transform:skew(8deg) rotate(3deg);
            -moz-transform:skew(8deg) rotate(3deg);
            -ms-transform:skew(8deg) rotate(3deg);
            -o-transform:skew(8deg) rotate(3deg);
            transform:skew(8deg) rotate(3deg);
        }
        .shadow{
            box-shadow: 0 4px 8px rgba(0,0,0,0.25), 0 1px 1px rgba(0,0,0,0.22);
        }



    </style>

</head>
<body background="${pageContext.request.contextPath}resources/1334.png">
<div class="container">
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <div class="effect6 login-form">
                <form:form action="login" method="POST" commandName="loginInfo" >
                    <div class="avatar">
                        <img src="resources/avatar.png" alt="Avatar">
                    </div>
                    <h2 class="text-center">ВХОД В СИСТЕМУ</h2>
                    <div class="effect4 form-group">
                        <form:select  cssClass="form-control" path="server" size="1">
                            <form:options  items="${tnsNamesList}" />
                        </form:select>
                    </div>
                    <div class="effect4 form-group">
                        <input  type="text" class="form-control shadow" name="username" placeholder="Имя" required="required">
                    </div>
                    <div class="effect4 form-group">
                        <input type="password" class="form-control shadow" name="password" placeholder="Пароль" required="required">
                    </div>
                    <div class="effect4 form-group">
                        <button style="margin-bottom: 0px" type="submit" class="btn btn-primary btn-lg btn-block shadow">ВОЙТИ</button>
                    </div>
                    <span class="error">${error}</span>
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
