package com.baizhi.service;

import com.baizhi.bean.Menu;
import com.baizhi.dao.MenuDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDAO menuDAO;

    @Override
    public List<Menu> findAllMenu() {
        return menuDAO.queryAll();
    }
}
