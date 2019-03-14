package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static Configuration configuration;
	private static SessionFactory sessionFactory;
	/*
	 * 静态语句块中的内容只是在类加载的时候只创建一次，因此这里的大大减少了资源的消耗
	 */
	static {
		// 加载核心配置文件hibernate.cfg.xml
		configuration = new Configuration();
		configuration.configure();
		// 创建SessionFactotry对象
		sessionFactory = configuration.buildSessionFactory();
	}

	//创建session对象，在测试类中可以使用这个静态方法获取session
	public static Session getSession(){
		return sessionFactory.openSession();
	}
	


	}
