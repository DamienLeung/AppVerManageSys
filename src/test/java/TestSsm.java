import com.dfbz.config.SpringMybatis;
import com.dfbz.dao.AppVersionMapper;
import com.dfbz.entity.*;
import com.dfbz.service.*;
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
import java.util.Map;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringMybatis.class)
public class TestSsm {

    @Autowired
    DataSource dataSource;  //向上造型

    @Autowired
    SqlSessionFactoryBean sqlSessionFactoryBean;


    @Autowired
    WorkOrderService service;

//    @Test
//    public void testSelectAll(){
//
//        HashMap<String, Object> map = new HashMap<>();
//
//        PageInfo<Qualification> pageInfo = service.selectAllByCondition(map, 1, 5);
//        for (Qualification version :
//                pageInfo.getList()) {
//            System.out.println(version);
//        }
//    }
//
//    @Test
//    public void testPageInfo() {
//        List<Qualification> qualifications = service.selectAll();
//        for (Qualification ver :
//                qualifications) {
//            System.out.println(ver);
//        }
//    }

//    @Test
//    public void testPageInfo2() {
//        HashMap<String, Object> map = new HashMap<>();
//        PageInfo<Examine> examinePageInfo = service.selectByConditions(map, 1, 5);
//        for (Examine ex :
//                examinePageInfo.getList()) {
//            System.out.println(ex);
//        }
//    }

//    @Test
//    public void testPageInfo3() {
//        HashMap<String, Object> map = new HashMap<>();
//        List<SysOffice> offices = service.selectAll();
//        for (SysOffice sys :
//                offices) {
//            System.out.println(sys);
//        }
//    }

    @Test
    public void testWorkOrderService() {
        WorkOrder workOrder = service.selectByCode("2016082000001");
        System.out.println(workOrder);
    }

    @Test
    public void testWorkOrderService2() {
        HashMap<String, Object> map = new HashMap<>();
        PageInfo<WorkOrder> workOrderPageInfo = service.selectByConditions(map, 1, 5);
        for (WorkOrder work :
                workOrderPageInfo.getList()) {
            System.out.println(work);
        }
    }

}
