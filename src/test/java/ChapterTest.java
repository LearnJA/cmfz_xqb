import com.baizhi.bean.Album;
import com.baizhi.bean.Chapter;
import com.baizhi.service.ChapterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.Map;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/baizhi/xml/applicationContext.xml")
public class ChapterTest {

    @Autowired
    private ChapterService chapterService;
    /*测试修改*/
    @Test
    public void update(){
        Chapter chapter=new Chapter();
        chapter.setId("1dfcebcd-4a65-4f2d-b8bd-6abc0e45c69a");
        chapter.setUploadDate(new Date());
        chapter.setTitle("是的冯绍峰");
        chapter.setDownPath("sdfs");
        chapter.setAlbum_id(2);
        chapter.setSize("10M");
        chapterService.addChapter(chapter);
    }
    @Test
    public void findOne(){
        Chapter chapter=new Chapter();
        chapter.setId("636e948e-f193-47eb-9928-229c7b7f016a");
        chapter=chapterService.findOne(chapter);
        System.out.println(chapter);
    }
    @Test
    public void findAll(){
        Map<String,Object> map=chapterService.findAll(1,5);
        Set<String> s=map.keySet();
        for(String p:s){
            System.out.println(map.get(p));
        }
    }
}
