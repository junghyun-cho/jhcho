package com.example.jhcho.sample.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.jhcho.common.CommandMap;
import com.example.jhcho.sample.service.SampleService;

@Controller
public class SampleController {
    Logger log = Logger.getLogger(this.getClass());
    
    @Resource(name="sampleService")
    private SampleService sampleService;
     
    @RequestMapping(value={"/sample/list.do", "/sample/list"})
    public ModelAndView sampleList(Map<String, Object> commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("/sample/sampleList");
         
        List<Map<String,Object>> list = sampleService.selectList(commandMap);
        mv.addObject("list", list);
         
        return mv;
    }
    
    
    @RequestMapping(value="/sample/resolver")
    public ModelAndView sampleResolver(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("");

        System.out.println("----->");
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                System.out.println("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        return mv;
    }
}
