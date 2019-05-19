<%-- 
    Document   : blank
    Created on : Jan 24, 2019, 2:24:08 PM
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
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/vendor/bootstrap/css/bootstrap.min.css">
    <link href="${pageContext.request.contextPath}/resources/assets/vendor/fonts/circular-std/style.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/libs/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/vendor/fonts/fontawesome/css/fontawesome-all.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/vendor/charts/chartist-bundle/chartist.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/vendor/charts/morris-bundle/morris.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/vendor/fonts/material-design-iconic-font/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/vendor/charts/c3charts/c3.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/vendor/fonts/flag-icon-css/flag-icon.min.css">
    <title>OSS - 2.0 Admin Dashboard</title>
</head>

<body>
    <!-- ============================================================== -->
    <!-- main wrapper -->
    <!-- ============================================================== -->
    <div class="dashboard-main-wrapper">
        <!-- ============================================================== -->
        <!-- navbar -->
        <!-- ============================================================== -->
        <%@include file="navbar.jsp" %>
        <!-- ============================================================== -->
        <!-- end navbar -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- left sidebar -->
        <!-- ============================================================== -->
        <%@include file="sidebar.jsp" %>
        <!-- ============================================================== -->
        <!-- end left sidebar -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- wrapper  -->
        <!-- ============================================================== -->
        <div class="dashboard-wrapper">
            <div class="dashboard-ecommerce">
                <div class="container-fluid dashboard-content ">
                    <!-- ============================================================== -->
                    <!-- pageheader  -->
                    <!-- ============================================================== -->
                    <div class="row">
                        <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                            <div class="page-header">
                                <h2 class="pageheader-title">Product Management </h2>
                                <p class="pageheader-text">Nulla euismod urna eros, sit amet scelerisque torton lectus vel mauris facilisis faucibus at enim quis massa lobortis rutrum.</p>
                                <div class="page-breadcrumb">
                                    <nav aria-label="breadcrumb">
                                        <ol class="breadcrumb">
                                            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/admin/dashboard" class="breadcrumb-link">Dashboard</a></li>
                                            <li class="breadcrumb-item active" aria-current="page">Product Management</li>
                                        </ol>
                                    </nav>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- ============================================================== -->
                    <!-- end pageheader  -->
                    <!-- ============================================================== -->
                    
                    <!-- body -->
                    <div class="row">
                        <div class="col-lg-12 col-md-12 col-lg-12 col-lg-12 col-12">
                            <div class="card">
                                <h5 class="card-header">
                                    <c:choose>
                                        <c:when test="${edit.equals('true')}">Update</c:when>
                                        <c:otherwise>Add new</c:otherwise>
                                    </c:choose>
                                    Product
                                </h5>
                                <div class="card-body">
                                    <c:choose>
                                        <c:when test="${edit.equals('true')}">

                                            <form id="form" data-parsley-validate="" novalidate="" 
                                                  action="${pageContext.request.contextPath}/admin/product/update" method="post" enctype="multipart/form-data">

                                                <div class="form-group row">
                                                    <label class="col-3 col-lg-2 col-form-label text-right">ID</label>
                                                    <div class="col-9 col-lg-10">
                                                        <input id="" type="text" name="pid" data-parsley-type="" readonly class="form-control" value="${product.id}">
                                                    </div>
                                                </div>
                                            </c:when>

                                            <c:otherwise>
                                                <form id="form" data-parsley-validate="" novalidate="" 
                                                      action="${pageContext.request.contextPath}/admin/product/add" method="post" enctype="multipart/form-data">
                                                </c:otherwise>
                                            </c:choose>

                                            <div class="form-group row">
                                                <label class="col-3 col-lg-2 col-form-label text-right">Name</label>
                                                <div class="col-9 col-lg-10">
                                                    <input id="" type="text" name="pname" required placeholder="Enter Product Name" class="form-control" value="${product.name}">
                                                </div>
                                            </div>

                                            <div class="form-group row">
                                                <label  class="col-3 col-lg-2 col-form-label text-right">Description</label>
                                                <div class="col-9 col-lg-10">
                                                    <textarea class="form-control" id="" rows="3" name="pdescription" required placeholder="Write the description of Product">${product.description}</textarea>
                                                </div>
                                            </div>
                                                
                                            <div class="form-group row">
                                                <label class="col-3 col-lg-2 col-form-label text-right">Category</label>
                                                <div class="col-9 col-lg-10" class="form-control">
                                                    <select class="form-control" name="pcategory">
                                                        <c:forEach items="${categories}" var="cat">
                                                            <option value="${cat.id}" <c:if test="${product.category.id.equals(cat.id)}">selected</c:if> >${cat.name}</option>
                                                        </c:forEach>
                                                    </select>
                                                    <p class="col-9 col-lg-10" class="help-block">
                                                        <c:choose>
                                                            <c:when test="${edit.equals('true')}">Selected </c:when>
                                                            <c:otherwise>Select one of the </c:otherwise>
                                                        </c:choose>Category
                                                    </p>
                                                </div>
                                                
                                            </div>    

                                            <div class="form-group row">
                                                <label class="col-3 col-lg-2 col-form-label text-right">Image</label>
                                                <div class="col-9 col-lg-10" class="form-control">
                                                    <input id="" type="file" name="pimage" required="" data-parsley-type="" class="form-control">
                                                    <p class="col-9 col-lg-10" class="help-block" ><c:if test="${edit.equals('true')}">The original image was: ${product.image}. Select new Image or same</c:if></p>
                                                    <p class="col-9 col-lg-10" class="text-danger">${uploaderror}</p>
                                                </div>
                                                
                                            </div>

                                            
                                            <div class="form-group row">
                                                <label class="col-3 col-lg-2 col-form-label text-right">Brand</label>
                                                <div class="col-9 col-lg-10">
                                                    <input id="" type="text" name="pbrand" required placeholder="Enter Brand Name" class="form-control" value="${product.brand}">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-3 col-lg-2 col-form-label text-right">Color</label>
                                                <div class="col-9 col-lg-10">
                                                    <input id="" type="text" name="pcolor" required placeholder="Enter Color of Product" class="form-control" value="${product.color}">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-3 col-lg-2 col-form-label text-right">Price</label>
                                                <div class="col-9 col-lg-10">
                                                    <input id="" type="text" name="pprice" required  placeholder="Enter Price of Product" class="form-control" value="${product.price}">
                                                </div>
                                            </div>
                                        <div class="row pt-2 pt-sm-5 mt-1">
                                            <div class="col-sm-6 pl-0">
                                                <p class="text-center">
                                                    <button type="submit" class="btn btn-space btn-primary">Submit</button>
                                                    <button type="reset" class="btn btn-space btn-secondary">Reset</button>
                                                </p>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <div class="row">
                        <div class="col-xl-12 col-lg-12 col-lg-12 col-lg-12 col-12" id="showProduct">
                            <div class="card">
                                <h5 class="card-header">Displaying All Products</h5>
                                <div class="card-body">
                                    <div class="table-responsive ">
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th scope="col">ID</th>
                                                    <th scope="col">Name</th>
                                                    <th scope="col">Description</th>
                                                    <th scope="col">Category</th>
                                                    <th scope="col">Image Name</th>
                                                    <th scope="col">Brand</th>
                                                    <th scope="col">Color</th>
                                                    <th scope="col">Price</th>
                                                    <th scope="col">Edit</th>
                                                    <th scope="col">Delete</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${products}" var="p">
                                                    <tr>
                                                        <td>${p.id}</td>
                                                        <td>${p.name}</td>
                                                        <td>${p.description}</td>
                                                        <td>${p.category.name}</td>
                                                        <td>${p.image}</td>
                                                        <td>${p.brand}</td>
                                                        <td>${p.color}</td>
                                                        <td>${p.price}</td>
                                                        <td><a href="<c:url value="/admin/product/edit/${p.id}"></c:url>">Edit</a></td>
                                                        <td><a href="<c:url value="/admin/product/delete/${p.id}"></c:url>">Delete</a></td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>                            
                </div>
            </div>
            <!-- ============================================================== -->
            <!-- footer -->
            <!-- ============================================================== -->
            <%@include file="footer.jsp" %>
            <!-- ============================================================== -->
            <!-- end footer -->
            <!-- ============================================================== -->
        </div>
        <!-- ============================================================== -->
        <!-- end wrapper  -->
        <!-- ============================================================== -->
    </div>
    <!-- ============================================================== -->
    <!-- end main wrapper  -->
    <!-- ============================================================== -->
    <!-- Optional JavaScript -->
    <!-- jquery 3.3.1 -->
    <script src="${pageContext.request.contextPath}/resources/assets/vendor/jquery/jquery-3.3.1.min.js"></script>
    <!-- bootstap bundle js -->
    <script src="${pageContext.request.contextPath}/resources/assets/vendor/bootstrap/js/bootstrap.bundle.js"></script>
    <!-- slimscroll js -->
    <script src="${pageContext.request.contextPath}/resources/assets/vendor/slimscroll/jquery.slimscroll.js"></script>
    <!-- main js -->
    <script src="${pageContext.request.contextPath}/resources/assets/libs/js/main-js.js"></script>
    <!-- chart chartist js -->
    <script src="${pageContext.request.contextPath}/resources/assets/vendor/charts/chartist-bundle/chartist.min.js"></script>
    <!-- sparkline js -->
    <script src="${pageContext.request.contextPath}/resources/assets/vendor/charts/sparkline/jquery.sparkline.js"></script>
    <!-- morris js -->
    <script src="${pageContext.request.contextPath}/resources/assets/vendor/charts/morris-bundle/raphael.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/vendor/charts/morris-bundle/morris.js"></script>
    <!-- chart c3 js -->
    <script src="${pageContext.request.contextPath}/resources/assets/vendor/charts/c3charts/c3.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/vendor/charts/c3charts/d3-5.4.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/vendor/charts/c3charts/C3chartjs.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/libs/js/dashboard-ecommerce.js"></script>
</body>
 
</html>

