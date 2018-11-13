import com.baizhi.bean.Album;
import com.baizhi.service.AlbumService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/baizhi/xml/applicationContext.xml")
public class AlbumTest {

    @Autowired
    private AlbumService albumService;
    private Map<String,Object> result=new HashMap<String,Object>();
    private Album album=new Album();

    @Test
    public void findAllTest(){
        result=albumService.findAllAlbum();
        Set<String> set=result.keySet();
        for(String s:set){
            System.out.println(result.get(s));
        }
    }

    /*测试修改*/
    @Test
    public void update(){
        album.setId(2);
        album.setCount(4);
        albumService.motifyAlbum(album);
    }
    /*删除测试*/
    @Test
    public void delete(){
        album.setId(11);
        albumService.delAlbum(album);
    }
}
