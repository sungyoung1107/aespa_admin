package com.kbstar.controller;

import com.kbstar.dto.Product;
import com.kbstar.dto.Stock;
import com.kbstar.service.ProductService;
import com.kbstar.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/charts")
public class ChartController {

    @Autowired
    StockService stockService;

    @Autowired
    ProductService productService;

    String dir = "chart/";

    @Value("${uploadimgdir}")  // application properties 안에서 설정해준 imgdir 경로를 가져옴
    String imgdir;

    @RequestMapping("/stock")
    public String stock(Model model) {
        model.addAttribute("center", dir + "stock");
        return "index";
    }

    @RequestMapping("/stockimpl")
    @ResponseBody // json 반환
    public Object stockimpl(Model model) throws Exception {

        try {
            stockService.modifyExpectedamount();
        } catch (Exception e) {
            // 예외 무시 - 상품과 재고간 비즈니스 로직 명확히 해야 함
        }

        List<Stock> list = null;
        list = stockService.getLowstock();

        /*
        let jo = {
                categories:[],
                data1:[]
                data2:[]
         }
         */
        JSONObject jo = new JSONObject();

        // 카테고리 데이터
        // categories = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
        // data1: [5.2, 5.7, 8.7, 13.9, 18.2, 21.4, 25.0, 22.8, 17.5, 12.1, 7.6];
        // data2: [5.2, 5.7, 8.7, 13.9, 18.2, 21.4, 25.0, 22.8, 17.5, 12.1, 7.6];
        JSONArray categories = new JSONArray();
        JSONArray amount = new JSONArray();
        JSONArray expectedAmount = new JSONArray();
        for (Stock item : list) {
            categories.add(item.getProduct_name());
            amount.add(item.getProduct_amount());
            expectedAmount.add(item.getProduct_expectedamount());
        }
        jo.put("categories", categories);
        jo.put("amount", amount);
        jo.put("expectedamount", expectedAmount);

        return jo;
    }
    @RequestMapping("/popular")
    @ResponseBody // json 반환
    public Object popular(Model model) throws Exception {

        List<Product> list = null;
        try {
            list = productService.selectPopularitem();
        } catch (Exception e) {
            // 예외 무시 - 상품과 재고간 비즈니스 로직 명확히 해야 함
        }
        /*
        let jo = {
                1 : "ㅇㅇㅇㅇ",
                2 : "ㅇㅇㅇㅇ"
         }
         */
        JSONObject jo = new JSONObject();
        // 1위~4위 상품 넣기
        for (Product item : list){
            if(item.getRank()==1){
                jo.put("1위", item.getProduct_name());
                jo.put("1위수량", item.getCart_quantity());
            }
            if(item.getRank()==2){
                jo.put("2위", item.getProduct_name());
                jo.put("2위수량", item.getCart_quantity());
            }
            if(item.getRank()==3){
                jo.put("3위", item.getProduct_name());
                jo.put("3위수량", item.getCart_quantity());
            }
            if(item.getRank()==4){
                jo.put("4위", item.getProduct_name());
                jo.put("4위수량", item.getCart_quantity());
            }
        }

        return jo;
    }

    // 어제 날짜 인기 상품 (카트 기준)
    @RequestMapping("/popular_y")
    @ResponseBody // json 반환
    public Object popular_y(Model model) throws Exception {

        List<Product> list = null;
        try {
            list = productService.selectPopularitem_y();
        } catch (Exception e) {
            // 예외 무시 - 상품과 재고간 비즈니스 로직 명확히 해야 함
        }
        /*
        let jo = {
                1 : "ㅇㅇㅇㅇ",
                2 : "ㅇㅇㅇㅇ"
         }
         */
        JSONObject jo = new JSONObject();
        // 1위~4위 상품 넣기
        for (Product item : list){
            if(item.getRank()==1){
                jo.put("1위", item.getProduct_name());
                jo.put("1위수량", item.getCart_quantity());
            }
            if(item.getRank()==2){
                jo.put("2위", item.getProduct_name());
                jo.put("2위수량", item.getCart_quantity());
            }
            if(item.getRank()==3){
                jo.put("3위", item.getProduct_name());
                jo.put("3위수량", item.getCart_quantity());
            }
            if(item.getRank()==4){
                jo.put("4위", item.getProduct_name());
                jo.put("4위수량", item.getCart_quantity());
            }
        }

        return jo;
    }
}
