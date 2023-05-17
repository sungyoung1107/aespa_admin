package com.kbstar.stock;

import com.kbstar.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class SelectProductIdTest {

    @Autowired
    StockService service;

    @Test
    void contextLoads(){
        List<Integer> list = null;
        try {
            list = service.selectProductid();
            log.info(list.toString());
        } catch (Exception e) {
            log.info("에러 ..... ");
           e.printStackTrace();
        }
    }
}
