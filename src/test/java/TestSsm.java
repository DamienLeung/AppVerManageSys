import com.dfbz.config.SpringMybatis;
import com.dfbz.dao.AppVersionMapper;
import com.dfbz.entity.AppVersion;
import com.dfbz.service.AppVersionService;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringMybatis.class)
public class TestSsm {

    @Autowired
    DataSource dataSource;  //向上造型

    @Autowired
    SqlSessionFactoryBean sqlSessionFactoryBean;


    @Autowired
    AppVersionService service;

    @Test
    public void testSelectAll(){
        List<AppVersion> appVersions = service.selectAll();
        for (AppVersion version :
                appVersions) {
            System.out.println(version);
        }
    }

    @Test
    public void testPageInfo() {
        AppVersion version = new AppVersion();
        PageInfo<AppVersion> appVersionPageInfo = service.selectPage(version, 1, 5);
        List<AppVersion> list = appVersionPageInfo.getList();
        for (AppVersion ver :
                list) {
            System.out.println(ver);
        }
    }


}
