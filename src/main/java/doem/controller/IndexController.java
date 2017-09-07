package doem.controller;

import doem.config.aop.Monitor;
import doem.config.redis.IRedisService;
import doem.dao.UserMapper;
import doem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JJJ on 2017/9/7.
 */
@RestController
public class IndexController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private IRedisService iRedisService;


    @RequestMapping(value = "/index/{id}")
    @CrossOrigin //跨域返回json注解
    public Map<String,Object> view(@PathVariable Integer id) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("id",id);
        return map;
    }
    @RequestMapping(value = "/index",method = RequestMethod.POST)
    @ResponseBody //返回json注解
    public Map<String,Object> index(Integer id) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("id",id);
        return map;
    }
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public ModelAndView getindex(Integer id, ModelMap modelMap) {
        User user = userMapper.selectByPrimaryKey(new Long("1"));
        modelMap.put("name","liuzhiqiang");
        modelMap.put("user",user);
        return new ModelAndView("index",modelMap);
    }
    @Monitor(logTitle = "aop测试", logType = "aop",text = "12345678")//自定义注解
    @RequestMapping(value = "/redis",method = RequestMethod.GET)
    public ModelAndView redis(Integer id, ModelMap modelMap) {
        iRedisService.set("name",id.toString());
        modelMap.put("redis",iRedisService.get("name"));
        return new ModelAndView("index",modelMap);
    }
}
