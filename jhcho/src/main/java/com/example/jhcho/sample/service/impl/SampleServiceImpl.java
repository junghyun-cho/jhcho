package com.example.jhcho.sample.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.example.jhcho.sample.dao.SampleDao;
import com.example.jhcho.sample.service.SampleService;

@Service("sampleService")
public class SampleServiceImpl implements SampleService {

    Logger log = Logger.getLogger(this.getClass());
    
    @Resource(name="sampleDao")
    private SampleDao sampleDao;
     
    @Override
    public List<Map<String, Object>> selectList(Map<String, Object> map) throws Exception {
        return sampleDao.selectList(map);
    }

}
