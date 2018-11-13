package com.baizhi.service;

import com.baizhi.bean.Banner;
import com.baizhi.dao.BannerDAO;
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
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerDAO bannerDAO;

    @Override
    public void addBanner(Banner banner) {
        bannerDAO.insert(banner);
    }

    @Override
    public void motifyBanner(Banner banner) {
        bannerDAO.update(banner);
    }

    @Override
    public void removeBanner(Banner banner) {
        bannerDAO.delete(banner);
    }

    @Override
    public void removeAnyBanner(int[] ids) {
        bannerDAO.deleteAny(ids);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Banner findOneBanner(Banner banner) {
        return bannerDAO.queryOne(banner);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Map<String, Object> findAllBanner(Integer status, Integer page, Integer rows) {
            int start=(page-1)*rows;
            List<Banner> banners=bannerDAO.queryAllPage(status,start,rows);
            Long total=bannerDAO.queryAllCount(status);
        return FindList.findList(total,banners);
    }
}
