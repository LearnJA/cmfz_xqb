package com.baizhi.service;

import com.baizhi.bean.Guru;
import com.baizhi.dao.GuruDAO;
import com.baizhi.util.FindList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class GuruServiceImpl implements GuruService {

    @Autowired
    private GuruDAO guruDAO;

    @Override
    public void addGuru(Guru guru) {
        guruDAO.insert(guru);
    }

    @Override
    public void motifyGuru(Guru guru) {
        guruDAO.update(guru);
    }

    @Override
    public void deleteGuru(Guru guru) {
        guruDAO.delete(guru);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Guru> findAllGuru() {
        return guruDAO.queryAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Map<String, Object> findOneGrur(Integer status,Integer page,Integer rows) {
        int start=(page-1)*rows;
        List<Guru> gurus=guruDAO.queryAllPage(status,start,rows);
        Long total=guruDAO.queryAllCount(status);
        return FindList.findList(total,gurus);
    }
}
