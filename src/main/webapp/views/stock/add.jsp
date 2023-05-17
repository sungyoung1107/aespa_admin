<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<main>
    <div class="container-fluid px-4">
        <h1 class="mt-4">Stock Add(Update)</h1>
        <ol class="breadcrumb mb-4">
            <li class="breadcrumb-item"><a href="/">Dashboard</a></li>
        </ol>
        <div class="card mb-4">
            <div class="card-body">
                재고 등록(변경)
            </div>
        </div>
        <div class="card mb-4">
            <div class="card-header">
                <i class="fas fa-table me-1"></i>
                Stock Add(Update)
            </div>
            <div class="card-body">
                <form id="stock_add" class="form-horizontal well" action="/stock/addimpl" method="get">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="product_id">제품번호 </label><br/>
                        <div class="col-sm-6"> <!--name 은 서버로 보내는 이름을 의미-->
                            <input type="number" name="product_id" class="form-control" id="product_id" placeholder="제품번호 입력(xxxx)">
                        </div>
                    </div><br/>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="product_costprice">원가 </label><br/>
                        <div class="col-sm-6">
                            <input type="number" name="product_costprice" class="form-control" id="product_costprice" placeholder="제품원가 입력">
                        </div>
                    </div><br/>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="product_amount">재고 </label><br/>
                        <div class="col-sm-6">
                            <input type="number" name="product_amount" class="form-control" id="product_amount" placeholder="재고(변경 시 변경 후 재고) 입력">
                        </div>
                    </div><br/>
                    <button type="submit" class="btn btn-primary" name="stock_add_btn"
                            id="stock_add_btn">재고 등록(변경)
                    </button>
                </form>
            </div>
        </div>
    </div>
</main>