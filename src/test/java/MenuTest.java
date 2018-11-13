import com.baizhi.bean.Menu;
import com.baizhi.service.MenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/baizhi/xml/applicationContext.xml")
public class MenuTest {

    @Autowired
    private MenuService menuService;

    @Test
    public void testFindAllMenu(){
        List<Menu> menus=menuService.findAllMenu();
        for(Menu m:menus){
            System.out.println(m);
        }
    }
}
