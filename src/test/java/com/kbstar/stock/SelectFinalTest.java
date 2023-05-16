package com.kbstar.stock;

import com.kbstar.dto.Stock;
import com.kbstar.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class SelectFinalTest {

    @Autowired
    StockService service;

    @Test
    void contextLoads(){
        int id = 1000;
        Stock stock = null;
        try {
            stock = service.selectfinal(id);
            log.info("------------------------");
            log.info(stock.toString());
            log.info("------------------------");
        } catch (Exception e) {
            log.info("에러 ..... ");
           e.printStackTrace();
        }
    }
}
