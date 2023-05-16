package com.kbstar.mapper;

import com.kbstar.dto.Stock;
import com.kbstar.dto.User;
import com.kbstar.frame.AespaMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface StockMapper extends AespaMapper<Integer, Stock> {
    public Stock selectfinal(Integer product_id) throws Exception;
}
