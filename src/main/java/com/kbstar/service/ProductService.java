package com.kbstar.service;

import com.kbstar.dto.Product;
import com.kbstar.frame.AespaService;
import com.kbstar.mapper.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j  //log
@Service
public class ProductService implements AespaService<Integer, Product> {
    /**
     * 등록 & 가입 진행
     * argument : object
     * return : null
     *
     * @param product
     **/
    @Override
    public void register(Product product) throws Exception {

    }

    @Override
    public void remove(Integer integer) throws Exception {

    }

    @Override
    public void modify(Product product) throws Exception {

    }

    @Override
    public Product get(Integer integer) throws Exception {
        return null;
    }

    @Override
    public List<Product> get() throws Exception {
        return null;
    }

}