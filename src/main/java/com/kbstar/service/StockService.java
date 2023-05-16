package com.kbstar.service;


import com.kbstar.dto.Stock;
import com.kbstar.dto.User;
import com.kbstar.frame.AespaService;
import com.kbstar.mapper.StockMapper;
import com.kbstar.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StockService implements AespaService<Integer, Stock> {

    @Autowired
    StockMapper mapper;

    @Override
    public void register(Stock stock) throws Exception {
        mapper.insert(stock);
    }

    @Override
    public void remove(Integer s) throws Exception {
        mapper.delete(s);
    }

    @Override
    public void modify(Stock stock) throws Exception {
        mapper.update(stock);
    }

    @Override
    public Stock get(Integer s) throws Exception {
        return mapper.select(s);
    }

    @Override
    public List<Stock> get() throws Exception {
        return mapper.selectall();
    }

    public Stock selectfinal(Integer product_id) throws Exception {
        return mapper.selectfinal(product_id);
    }
}
