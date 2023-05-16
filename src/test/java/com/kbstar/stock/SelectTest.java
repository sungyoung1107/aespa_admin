package com.kbstar.stock;

import com.kbstar.dto.Stock;
import com.kbstar.dto.User;
import com.kbstar.service.StockService;
import com.kbstar.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class SelectTest {

    @Autowired
    StockService service;

    @Test
    void contextLoads(){
        int id = 1000;
        Stock stock = null;
        try {
            stock = service.get(id);
            log.info("------------------------");
            log.info(stock.toString());
            log.info("------------------------");
        } catch (Exception e) {
            log.info("에러 ..... ");
           e.printStackTrace();
        }
    }
}
