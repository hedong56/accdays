package com.accdays.action.hibernateFeature;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.stereotype.Controller;

import com.accdays.service.hibernateFeature.IHibernateFeatureDemoService;

/**
 * 
 * hibernate相关功能演示Action
 * 右击本类，新建Junit测试，注意选择source folder
 * 
 * @author hedong
 * @date 2013-7-21 下午2:51:38
 * @modifyNote
 * @version 1.0
 */
@Controller("hibernateFeatureAction")
public class HibernateFeatureDemoAction {

	/**
	 * @Resource 如果不用name属性则和@Autowired一样查找这个类或子类进行注入;
	 * 有name属性则按照name属性名注入
	 */
	@Resource(name="hibernateFeatureService")//注入指定name的bean，而不是默认的按java类注入
	private IHibernateFeatureDemoService hibernateFeatureService;//本行hibernateFeatureService相当于一个变量名可任意写
	
	/**
	 * hibernate同时保存多个对象
	 * @Description
	 * @author hedong
	 * @date 2013-7-21 下午3:00:25
	 * @modifyNote
	 */
	@Test
	public void saveUnitObj(){
//		Assert.assertNull(hibernateFeatureService);
		hibernateFeatureService.saveUnitObj();
	}
	
	
}
