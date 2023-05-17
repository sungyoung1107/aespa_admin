<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>

  let stockChart = {
    init : function(){
      let self = stockChart;
      self.getData();
    },
    getData : function(){
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
          categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
            'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
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
          data: [5.2, 5.7, 8.7, 13.9, 18.2, 21.4, 25.0, {
            y: 26.4,
            accessibility: {
              description: 'Sunny symbol, this is the warmest point in the chart.'
            }
          }, 22.8, 17.5, 12.1, 7.6]

        }, {
          name: '예상 재고 수량',
          data: [{
            y: 1.5,
            accessibility: {
              description: 'Snowy symbol, this is the coldest point in the chart.'
            }
          }, 1.6, 3.3, 5.9, 10.5, 13.5, 14.5, 14.4, 11.5, 8.7, 4.7, 2.6]
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