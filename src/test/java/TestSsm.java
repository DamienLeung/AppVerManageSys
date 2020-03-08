import com.dfbz.config.SpringMybatis;
import com.dfbz.dao.AppVersionMapper;
import com.dfbz.entity.AppVersion;
import com.dfbz.entity.Qualification;
import com.dfbz.service.AppVersionService;
import com.dfbz.service.QualificationService;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringMybatis.class)
public class TestSsm {

    @Autowired
    DataSource dataSource;  //向上造型

    @Autowired
    SqlSessionFactoryBean sqlSessionFactoryBean;


    @Autowired
    QualificationService service;

    @Test
    public void testSelectAll(){

        HashMap<String, Object> map = new HashMap<>();

        PageInfo<Qualification> pageInfo = service.selectAllByCondition(map, 1, 5);
        for (Qualification version :
                pageInfo.getList()) {
            System.out.println(version);
        }
    }

    @Test
    public void testPageInfo() {
        List<Qualification> qualifications = service.selectAll();
        for (Qualification ver :
                qualifications) {
            System.out.println(ver);
        }
    }


}
