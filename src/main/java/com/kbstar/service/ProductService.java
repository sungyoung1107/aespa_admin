package com.kbstar.service;



import com.kbstar.mapper.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Slf4j  //log
//@Service
//public class ProductService implements KBService<Integer, Product> {

//    @Autowired
//    ProductMapper mapper;
//
//    @Override
//    public void register(Item item) throws Exception {
//        mapper.insert(item);
//        log.info("Send Mail..."+item.getId());
//    }

//    @Override
//    public void remove(Integer i) throws Exception {
//        mapper.delete(i);
//    }
//
//    @Override
//    public void modify(Item item) throws Exception {
//        mapper.update(item);
//    }
//
//    @Override
//    public Item get(Integer i) throws Exception {
//        return mapper.select(i);
//    }
//
//    @Override
//    public List<Item> get() throws Exception {
//        return mapper.selectall();
//    }
//
//    public List<Item> search(ItemSearch ms) throws Exception{
//        return mapper.search(ms);
//    }
//}