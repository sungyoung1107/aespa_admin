<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<main>
    <div class="container-fluid px-4">
        <h1 class="mt-4">Tables</h1>
        <ol class="breadcrumb mb-4">
            <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
            <li class="breadcrumb-item active">Tables</li>
        </ol>
        <div class="card mb-4">
            <div class="card-body">
                DataTables is a third party plugin that is used to generate the demo table below. For more information about DataTables, please visit the
                <a target="_blank" href="https://datatables.net/">official DataTables documentation</a>
                .
            </div>
        </div>
        <div class="card mb-4">
            <div class="card-header">
                <i class="fas fa-table me-1"></i>
                DataTable Example
            </div>
            <div class="card-body">
                <table id="datatablesSimple">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Gender</th>
                        <th>Contact</th>
                        <th>Address</th>
                        <th>Birth Date</th>
                        <th>Admin Check</th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Gender</th>
                        <th>Contact</th>
                        <th>Address</th>
                        <th>Birth Date</th>
                        <th>Admin Check</th>
                    </tr>
                    </tfoot>
                    <tbody>
                        <c:forEach var ="obj" items="${clist}">
                            <tr>
                                <td><a href="/user/detail?id=${obj.user_id}">${obj.user_id}</a></td>
                                <td>${obj.user_name}</td>
                                <td>${obj.user_gender}</td>
                                <td>${obj.user_contact}</td>
                                <td>${obj.user_address}</td>
                                <td>${obj.user_birthday}</td>
                                <td>${obj.admin_check}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</main>