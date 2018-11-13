import com.baizhi.bean.Course;
import com.baizhi.service.ChapterService;
import com.baizhi.service.CourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/baizhi/xml/applicationContext.xml")
public class CounseTest {
    @Autowired
    private CourseService courseService;

    /*测试用户查所有*/
    @Test
    public void findUserAll(){
        Course course=new Course();
        course.setUser_id(1);
        List<Course> cs=courseService.findUserCourse(course);
        for(Course s:cs){
            System.out.println(s);
        }
    }
}