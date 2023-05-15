<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
    #product_img{
        width:80px;
    }
</style>

<script>

</script>
<main>
    <div class="container-fluid px-4">
        <h1 class="mt-4">Product Table</h1>
        <div class="card mb-4">
            <div class="card-header">
                <i class="fas fa-table me-1"></i>
                Product Table
            </div>
            <div class="card-body">
                <table class="table table-bordered" id="datatablesSimple" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>Image</th>
                        <th>Product ID</th>
                        <th>Product Name</th>
                        <th>Price</th>
                        <th>Regdate</th>
                        <th>Category ID</th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>Image</th>
                        <th>Product ID</th>
                        <th>Product Name</th>
                        <th>Price</th>
                        <th>Regdate</th>
                        <th>Category ID</th>
                    </tr>
                    </tfoot>
                    <tbody>
                        <c:forEach var ="obj" items="${clist}">
                            <tr>
                                <td>
                                    <a href="#" data-toggle="modal" data-target="#target${obj.product_id}">
                                        <img id="product_img" src="/uimg/${obj.product_imgname}">
                                    </a>
                                </td>
                                <td><a href="/product/detail?id=${obj.product_id}">${obj.product_id}</a></td>
                                <td>${obj.product_name}</td>
                                <td><fmt:formatNumber value="${obj.product_price}" type="number" pattern="###,###원"/></td>
                                <td><fmt:formatDate value="${obj.product_regdate}" pattern="yyyy-MM-dd:hh-mm-ss" /></td>
                                <td>${obj.category_id}</td>
                            </tr>
                            <!-- Modal -->
                            <div class="modal fade" id="target${obj.product_id}" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h4 class="modal-title">Detail Image</h4>
                                        </div>
                                        <div class="modal-body">
                                            <p>${obj.product_name}</p>
                                            <img src ="/uimg/${obj.product_imgname}"><br/>
                                        </div>
                                        <div class="modal-footer">
                                            <a href="/product/detail?id=${obj.product_id}" class="btn btn-info" role="button">Detail</a>
                                            <a href="#" class="btn btn-info" data-dismiss="modal" role="button">Close</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Modal End -->
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</main>