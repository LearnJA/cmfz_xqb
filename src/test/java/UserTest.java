import com.baizhi.bean.User;
import com.baizhi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/baizhi/xml/applicationContext.xml")
public class UserTest {
    @Autowired
    private UserService userService;

    @Test
    public void findOne(){
        User user=new User();
        user.setPhone("123");
        user.setPassword("123456");
        String str=userService.findUser(user);
        System.out.println(str);
    }

    @Test
    public void updateUser(){
        userService.motifyUserStatus(1);
    }
}
