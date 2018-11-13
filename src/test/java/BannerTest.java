import com.baizhi.bean.Banner;
import com.baizhi.service.BannerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/baizhi/xml/applicationContext.xml")
public class BannerTest {
    @Autowired
    private BannerService bannerService;

    @Test
    public void testAllBanner(){
        Map<String,Object> map=bannerService.findAllBanner(1,1,2);
        Set<String> s=map.keySet();
        for(String p:s){
            System.out.println(map.get(p));
        }
    }

    /*查一个*/
    @Test
    public void finOne(){
        Banner banner=new Banner();
        banner.setId(1);
        banner=bannerService.findOneBanner(banner);
        System.out.println(banner);
    }
}
