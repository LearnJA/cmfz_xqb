package com.baizhi.controller;

import com.baizhi.bean.Menu;
import com.baizhi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@Scope("prototype")
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/findMenus",method = RequestMethod.POST)
    public @ResponseBody List<Menu> findMenus(Menu menu){
        List<Menu> menus=menuService.findAllMenu();
        System.out.println(menus);
        return menus;
    }
}
