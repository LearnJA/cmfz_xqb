import com.baizhi.bean.Admain;
import com.baizhi.service.AdmainService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/baizhi/xml/applicationContext.xml")
public class AdmainTest {

    @Resource
    private AdmainService admainService;
    //测试注册
    @Test
    public void testRegist(){
        Admain m=new Admain();
        m.setName("123");
        m.setPassword("123456");
        m.setStatus(1);
        admainService.addAdmain(m);
    }

    @Test
    public void findOne(){
        Admain manager=new Admain();
        manager.setName("123");
        manager.setPassword("123456");
        Admain m=admainService.findOneAdmain(manager);
        System.out.println(m);
    }
}
