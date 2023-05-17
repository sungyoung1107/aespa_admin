package com.kbstar.controller;

import com.kbstar.dto.Stock;
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

    String dir = "chart/";

    @Value("${uploadimgdir}")  // application properties 안에서 설정해준 imgdir 경로를 가져옴
    String imgdir;

    @RequestMapping("/stock")
    public String stock(Model model){
        model.addAttribute("center", dir+"stock");
        return "index";
    }

    @RequestMapping("/stockimpl")
    @ResponseBody // json 반환
    public Object stockimpl(Model model){

//        List<Sales> list = null;
//        list = salesService.groupsales();
//
//        // data : { labels:[], datasets[{data: []}]}
//        JSONObject joData = new JSONObject();
//
//        // 월 매출액
//        JSONArray jaLabel = new JSONArray();
//        for(int i =1 ; i <13 ; i++) {
//            jaLabel.add(i);
//        }
//        JSONObject joInnerData = new JSONObject();
//        // innerdata
//        JSONArray jaInnerData = new JSONArray();
//        for (Sales sales : list){
//            // 매출액이 없는 경우 0으로 세팅
//            if(sales.getPrice() == null || sales.getPrice() == 0){
//                jaInnerData.add(0);
//                continue; // 아래구문 패스
//            }
//            jaInnerData.add(sales.getPrice()); // 매출액이 있는 경우 매출액 set
//        } // [XXX, XXX, XXX, ....]
//        joInnerData.put("data", joInnerData); // {data: []}
//
//        // datasets
//        JSONArray jaDatasets = new JSONArray();
//        jaDatasets.add(joInnerData); // [{data: []}]
//
//        joData.put("labels", jaLabel); // labels : [1,2,3,4,5,6,7,8,9,10,11,12]
//        joData.put("datasets", jaDatasets); // datasets: [{data: []}]
//
//        return joData;
        return null;
    }

}
