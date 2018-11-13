package com.baizhi.service;

import com.baizhi.bean.Menu;

import java.util.List;

public interface MenuService {
    /*查询所有菜单项*/
    List<Menu> findAllMenu();
}
