package com.macw.wwdoc;

import com.macw.wwdoc.entity.Menu;
import com.macw.wwdoc.entity.vo.MenuVo;
import com.macw.wwdoc.mapper.MenuMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest(classes = WwdocApplication.class)
@RunWith(SpringRunner.class)
public class WwdocApplicationTests {

    @Resource
    private MenuMapper menuMapper;


    @Test
    public void contextLoads() {
        List<MenuVo> menuVos = menuMapper.listMenuVo(1);
        for (MenuVo menuVo : menuVos) {
            System.out.println(menuVo);
        }
    }



}
