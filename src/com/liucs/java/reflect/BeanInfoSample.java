package com.liucs.java.reflect;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
/**
 * 使用BeanInfo来设置和读取对象的属性。
 * 自省。
 */
public class BeanInfoSample {
	static class User{
		private String username;
		private String password;
		private String gender;
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
	}
	/**
	 * JavaBean中通过getName/setName 来访问name属性，方法中第一个单词字母小写，第二个单词首字母大写，这就是默认的规则。
	 * Java中提供了一套API 用来访问某个属性的getter/setter方法，通过这些API 可以使你不需要了解这个规则，
	 * 
	 * Introspector类提供了一个标准的方法，通过getBeanInfo方法获取某个对象的BeanInfo 信息,使得工具可以获取JavaBean中属性、方法、事件。
	 * BeanInfo接口定义了获取JavaBean属性、方法、事件的详细描述信息的方法，如getPropertyDescriptors、getMethodDescriptors、getEventSetDescriptors等
	 * PropertyDescriptor类可以通过 getReadMethod()，getWriteMethod()来获取JavaBean中属性对应的getter/setter方法，方便后续反射调用
	 */
	public static void main(String[] args) throws Exception {
		User u = new User();
		u.setUsername("Tom");
		u.setPassword("123");
		u.setGender("male");
		BeanInfo beanInfo = Introspector.getBeanInfo(User.class);
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor pd : propertyDescriptors) {
			String proName = pd.getName();
			Object v = pd.getReadMethod().invoke(u, null);
			System.out.println(proName+"="+v);
		}
	}
}