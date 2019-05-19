<%-- 
    Document   : sidebar
    Created on : Jan 24, 2019, 1:06:38 PM
    Author     : test
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%--Side Navbar or Sidebar --%>
<div class="nav-left-sidebar sidebar-dark">
            <div class="menu-list">
                <nav class="navbar navbar-expand-lg navbar-light">
                    <a class="d-xl-none d-lg-none" href="${pageContext.request.contextPath}/admin/dashboard">Dashboard</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav flex-column">
                            <li class="nav-divider">
                                Menu
                            </li>
                            <li class="nav-item ">
                                <a class="nav-link active" href="${pageContext.request.contextPath}/admin/dashboard" data-toggle="collapse" aria-expanded="false" data-target="#submenu-1" aria-controls="submenu-1"><i class="fa fa-fw fa-user-circle"></i>Dashboard <span class="badge badge-success">6</span></a>
                                <div id="submenu-1" class="collapse submenu" style="">
                                    <ul class="nav flex-column">
                                        <li class="nav-item">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/admin/dashboard" data-toggle="collapse" aria-expanded="false" data-target="#submenu-1-2" aria-controls="submenu-1-2">E-Commerce</a>
                                            <div id="submenu-1-2" class="collapse submenu" style="">
                                                <ul class="nav flex-column">
                                                    <li class="nav-item">
                                                        <a class="nav-link" href="${pageContext.request.contextPath}/admin/dashboard">Online-Bazar Dashboard</a>
                                                    </li>
                                                    
                                                </ul>
                                            </div>
                                        </li>
                                        
                                    </ul>
                                </div>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#" data-toggle="collapse" aria-expanded="false" data-target="#submenu-2" aria-controls="submenu-2"><i class="fas fa-th"></i>Category Management</a>
                                <div id="submenu-2" class="collapse submenu" style="">
                                    <ul class="nav flex-column">
                                        <li class="nav-item">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/admin/category/add"><i class="fas fa-plus-square"></i> Add Category</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/admin/category/display"><i class="fas fa-desktop"></i>Display Category</a>
                                        </li>
                                    </ul>
                                </div>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#" data-toggle="collapse" aria-expanded="false" data-target="#submenu-3" aria-controls="submenu-3"><i class="fas fa-boxes"></i>Product Management</a>
                                <div id="submenu-3" class="collapse submenu" style="">
                                    <ul class="nav flex-column">
                                        <li class="nav-item">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/admin/product/add"><i class="fas fa-plus-square"></i>Add Product</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/admin/product/display"><i class="fas fa-desktop"></i>Display Product</a>
                                        </li>
                                    </ul>
                                </div>
                            </li>
                            <li class="nav-divider">
                                View
                            </li>
                            
                            <li class="nav-item">
                                <a class="nav-link" href="<c:url value="/admin/cart/view"></c:url>"><i class="fas fa-shopping-cart"></i> Shopping Cart</a>
                            </li>
                            
                            <li class="nav-item">
                                <a class="nav-link" href="<c:url value="/admin/order/view"></c:url>"><i class="fas fa-shipping-fast"></i> Orders</a>
                            </li> 
                            
                            <li class="nav-item">
                                <a class="nav-link" href="<c:url value="/admin/payment/view"></c:url>"><i class="fas fa-dollar-sign"></i> Payment</a>
                            </li>
                            
                            <li class="nav-item">
                                <a class="nav-link" href="<c:url value="/admin/user/view"></c:url>"><i class="fas fa-users"></i> User Management</a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
