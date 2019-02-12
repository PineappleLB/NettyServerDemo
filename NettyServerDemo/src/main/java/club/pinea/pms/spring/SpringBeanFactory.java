package club.pinea.pms.spring;


import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


import io.netty.util.Constant;

/**
 * @author 作者 pineapple 
 * @E-mail: 2443755705@qq.com
 * @version 创建时间：2019年2月3日 上午11:53:57
 * @description 类说明
 */
public class SpringBeanFactory {

	private  ApplicationContext context = null;
	private static SpringBeanFactory factory = null;
	Logger log = LogManager.getLogger(SpringBeanFactory.class);
	public static SpringBeanFactory getInstance(){
		if(factory == null){
			synchronized (SpringBeanFactory.class) {
				if(factory == null){
					factory = new SpringBeanFactory();
				}
			}
		}
		return factory;
	}
	
	private SpringBeanFactory(){
		this.springStart();
	}
	
	public  void springStart() {
//		String filePaht = "/"+System.getProperty("user.dir") + File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"applicationContext.xml";
//		System.out.println(filePaht);
		context= new FileSystemXmlApplicationContext("file:" + File.separator + "applicationContext.xml");
		//this.context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
	}
	/**
	 * 获得SpingBean
	 * 
	 * @createDate 2008-9-27 04:36:46
	 * @param beanName
	 * @return
	 */
	public Object getSpringBean(String beanName) {
		if(context.containsBean(beanName)){
			return context.getBean(beanName);
		}
		log.info("实例："+beanName+"不存在");
		return null;
	}
	
	public <T> T getSpringBean(Class<T> _class){
		return (T) context.getBean(_class);
	}
	
}
