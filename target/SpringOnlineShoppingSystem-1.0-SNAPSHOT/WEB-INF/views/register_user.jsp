<%-- 
    Document   : regiser_user
    Created on : Feb 13, 2019, 2:30:56 PM
    Author     : test
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
 
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Register User</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/vendor/bootstrap/css/bootstrap.min.css">
    <link href="${pageContext.request.contextPath}/resources/assets/vendor/fonts/circular-std/style.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/libs/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/vendor/fonts/fontawesome/css/fontawesome-all.css">
    <style>
    html,
    body {
        height: 100%;
    }

    body {
        display: -ms-flexbox;
        display: flex;
        -ms-flex-align: center;
        align-items: center;
        padding-top: 40px;
        padding-bottom: 40px;
    }
    </style>
</head>
<!-- ============================================================== -->
<!-- signup form  -->
<!-- ============================================================== -->

<body>
    <!-- ============================================================== -->
    <!-- signup form  -->
    <!-- ============================================================== -->
    <form class="splash-container" action="<c:url value="/register"/>" method="post" enctype="multipart/form-data">
        <div class="card">
            <div class="card-header">
                <h2 class="text-danger">${registerError}</h2>
                <h3 class="mb-1">Sign up for membership</h3>
                <p>Please enter your user information.</p>
            </div>
            <div class="card-body">
                <div class="form-group">
                    <input class="form-control form-control-lg" type="text" name="firstname" required="" placeholder="First Name" autocomplete="off">
                </div>
                <div class="form-group">
                    <input class="form-control form-control-lg" type="text" name="lastname" required="" placeholder="Last Name" autocomplete="off">
                </div>
                <div class="form-group">
                    <input class="form-control form-control-lg" type="email" name="email" required="" placeholder="E-Mail" autocomplete="off">
                </div>
                <div class="form-group">
                    <div class="form-control form-control-lg">
                        <input class="form-control" type="date" name="dob" required="" placeholder="Date-of-Birth" autocomplete="off">
                        <p  class="help-block">Date of Birth</p>
                    </div>
                </div>               
                <div class="form-group">
                    <div class="form-control form-control-lg">
                        <input class="form-control" type="file" name="image" required="" placeholder="Image" autocomplete="off">
                        <p  class="help-block">User Image</p>
                        <p class="text-danger">${uploadError}</p>
                    </div>
                </div>
                <div class="form-group">
                    <input class="form-control form-control-lg" type="text" name="username" required="" placeholder="Username" autocomplete="off">
                </div>                
                <div class="form-group">
                    <input class="form-control form-control-lg" name="password" type="password" required="" placeholder="Password">
                </div>
                <div class="form-group">
                    <input class="form-control form-control-lg" name="cpassword" required="" placeholder="Confirm Password">
                    <p class="text-danger">${passwordError}</p> 
                </div>
                <div class="form-group">
                    <select class="form-control form-control-lg" name="authority">
                        <option>Select Authority <i class="fas fa-caret-down"></i></option>
                        <option value="ROLE_ADMIN">Admin</option>
                        <option value="ROLE_USER">User</option>
                    </select>
                </div>
                <div class="form-group pt-2">
                    <button class="btn btn-block btn-primary" type="submit">Register My Account</button>
                </div>
                <div class="form-group">
                    <label class="custom-control custom-checkbox">
                        <input class="custom-control-input" type="checkbox"><span class="custom-control-label">By creating an account, you agree the <a href="">terms and conditions</a></span>
                    </label>
                </div>
                
            </div>
            <div class="card-footer bg-white">
                <p>Already member? <a href="<c:url value="/login"></c:url>" class="text-secondary">Login Here.</a></p>
            </div>
        </div>
    </form>
</body>

 
</html>
