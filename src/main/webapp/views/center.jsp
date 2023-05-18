<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>

    let stockChart = {
        init : function(){
            stockChart.getData();
        },
        getData : function(){
            $.ajax({
                url: '/charts/stockimpl',
                success: function(result){
                    console.log(result);
                    stockChart.display(result);
                }
            });
        },
        display : function(result){
            Highcharts.chart('container1', {
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

    let categoryChart = {
        init:function(){
            $.ajax({
                url:'/chart1',
                success:function(data){
                    categoryChart.display(data)
                }
            });
        },
        display:function(data){
            Highcharts.chart('container2', {
                chart: {
                    type: 'column'
                },
                title: {
                    text: '카테고리별 남녀 주문량'
                },
                subtitle: {
                    text: 'Source: cart'
                },
                xAxis: {
                    categories: [
                        '101',
                        '102',
                        '103',
                        '104',
                        '105',
                        '200'
                    ],
                    crosshair: true
                },
                yAxis: {
                    min: 0,
                    title: {
                        text: '수량(개)'
                    }
                },
                tooltip: {
                    headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                    pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                        '<td style="padding:0"><b>{point.y:.1f} 개</b></td></tr>',
                    footerFormat: '</table>',
                    shared: true,
                    useHTML: true
                },
                plotOptions: {
                    column: {
                        pointPadding: 0.2,
                        borderWidth: 0
                    }
                },
                series: data
            });

        }
    }


    $(document).ready(function () {
        stockChart.init();
        categoryChart.init();

        setInterval(stockChart.init, 5000);
        setInterval(categoryChart.init, 5000);
    });

</script>

<main>
    <div class="container-fluid px-4">
        <h1 class="mt-4">Dashboard</h1>
        <ol class="breadcrumb mb-4">
            <li class="breadcrumb-item active">Dashboard</li>
        </ol>
        <div class="container-fluid px-4">
            <div class="card mb-4">
                <div class="card-body">
                    <div class="row">
                        <div class="col-sm">
                            <div id="container1"></div>
                        </div>
                        <div class="col-sm">
                            <div id="container2"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</main>
