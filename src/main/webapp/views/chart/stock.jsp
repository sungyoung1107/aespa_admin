<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>

  let stockChart = {
    init : function(){
      const self=  this;
      self.getData(self);
    },
    getData : function(self){
      $.ajax({
        url: '/charts/stockimpl',
        success: function(result){
          console.log(result);
          self.display(result);
        }
      });
    },
    display : function(result){
      Highcharts.chart('container', {
        chart: {
          type: 'spline'
        },
        title: {
          text: '재고 부족 상품 리스트'
        },
        subtitle: {
          text: 'Source: ' +
                  '<a href="/stock/all" ' +
                  'target="_blank">Stock Management</a>'
        },
        xAxis: {
          categories: result["categories"],
          accessibility: {
            description: 'Months of the year'
          }
        },
        yAxis: {
          title: {
            text: 'Stock'
          },
          labels: {
            formatter: function () {
              return this.value + '개';
            }
          }
        },
        tooltip: {
          crosshairs: true,
          shared: true
        },
        plotOptions: {
          spline: {
            marker: {
              radius: 4,
              lineColor: '#666666',
              lineWidth: 1
            }
          }
        },
        series: [{
          name: '실 재고 수량',
          data: result["amount"]
        }, {
          name: '예상 재고 수량',
          data:result["expectedamount"]
        }]
      });
    }
  }
  $(document).ready(function () {
    stockChart.init();
  });

</script>

<style>
  #container {
    width: 80%;
    height: 50%;
  }
</style>

<main>
  <div class="container-fluid px-4">
    <h1 class="mt-4">재고 관리 차트</h1>
    <br>
    <div class="card mb-4">
      <div class="card-header">
        <i class="fas fa-table me-1"></i>
        재고 관리 차트
      </div>
      <div class="card-body">
        <div id="container"></div>
      </div>
    </div>
  </div>
</main>