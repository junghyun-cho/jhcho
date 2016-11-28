package com.example.jhcho.sample.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.jhcho.common.dao.AbstractDao;

@Repository("sampleDao")
public class SampleDao extends AbstractDao {

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> selectList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList("sample.selectList", map);
    }

}
