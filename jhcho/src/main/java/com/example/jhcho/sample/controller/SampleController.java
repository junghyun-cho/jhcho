package com.example.jhcho.sample.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
    
    
    @RequestMapping("/sample/example")
    public ModelAndView exampleList() throws Exception {
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName("/sample/sampleList");
    	
    	return mv;
    }
}
