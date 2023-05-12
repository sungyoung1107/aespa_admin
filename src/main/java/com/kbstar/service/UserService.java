package com.kbstar.service;


import com.kbstar.dto.User;
import com.kbstar.frame.AespaService;
import com.kbstar.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Slf4j
//@Service
//public class UserService implements AespaService<String, User> {
//
//    @Autowired
//    UserMapper mapper;
//
//    @Override
//    public void register(Cust cust) throws Exception {
//        mapper.insert(cust);
//        //mapper.insert(cust);
//        log.info("Send Mail ..." + cust.getId());
//    }
//
//    @Override
//    public void remove(String s) throws Exception {
//        mapper.delete(s);
//
//    }
//
//    @Override
//    public void modify(Cust cust) throws Exception {
//        mapper.update(cust);
//    }
//
//    @Override
//    public Cust get(String s) throws Exception {
//        return mapper.select(s);
//    }
//
//    @Override
//    public List<Cust> get() throws Exception {
//        return mapper.selectall();
//    }
//}
