/**
 * 
 */
package com.interpark.sts.polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author 최지혜
 */
public class TVUser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		SamsungTV tv = new SamsungTV();
//		LgTV tv = new LgTV();
		/*
		TV tv = new SamsungTVImpl();
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		*/
		
		// 1. Spring container를 구동
		AbstractApplicationContext factory = new GenericXmlApplicationContext("application-context.xml");
//		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");

		// 2. Spring 컨테이너로부터 필요한 객체를 요청(Lookup) 한다.

//		TV tv = (TV) factory.getBean("lgtv");
		com.interpark.sts.polymorphism.ifs.TV tv = (com.interpark.sts.polymorphism.ifs.TV) factory.getBean("samsungTv");
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		
		// 2.1 Singleton test
		/*
		TV tv1 = (TV) factory.getBean("tv");
		TV tv2 = (TV) factory.getBean("tv");
		TV tv3 = (TV) factory.getBean("tv");
		*/
		// 3. Spring container 를 종료
		factory.close();
	}

}
