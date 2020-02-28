package com.macw.wwdoc;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.macw.wwdoc.entity.Category;
import com.macw.wwdoc.entity.Menu;
import com.macw.wwdoc.entity.vo.MenuVo;
import com.macw.wwdoc.mapper.MenuMapper;
import com.macw.wwdoc.service.ICategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = WwdocApplication.class)
@RunWith(SpringRunner.class)
public class WwdocApplicationTests {

    @Resource
    private MenuMapper menuMapper;

    @Resource
    private ICategoryService iCategoryService;

    @Test
    public void contextLoads() {
        List<MenuVo> menuVos = menuMapper.listMenuVo(1);
        for (MenuVo menuVo : menuVos) {
            System.out.println(menuVo);
        }
    }

    @Test
    public void test(){
        List<Integer> integers = diGui(13);
        System.out.println(integers);

    }

    List<Integer> list = new ArrayList<>();
    private List<Integer> diGui(Integer cid) {
        List<Category> categoryList = iCategoryService.list(new QueryWrapper<Category>().lambda().eq(Category::getParentId, cid));
        System.out.println("-----------"+categoryList);
        if (categoryList!=null && categoryList.size() > 0) {
            for (Category category : categoryList) {
                list.add(category.getCategoryId());
                diGui(category.getCategoryId());
            }
        }
        System.out.println("========="+list);
        return list;
    }



}
