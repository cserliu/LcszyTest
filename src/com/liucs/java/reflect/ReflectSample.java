package com.liucs.java.reflect;

import java.lang.reflect.*;
/**
 * 1、获取类的相关信息
 * 2、知道类名，实例化出对象
 * 3、动态调用实例的方法
 * 
 *
 *
 */
public class ReflectSample {
	public static void main(String[] args) throws Exception {
		newInstanceAndIncokeMethod();
	}
	/**
	 * 通过反射方式实例化并执行方法获取方法返回值。
	 * 
	 */
	private static void newInstanceAndIncokeMethod() throws SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException{
		class Point{
			int x;
			int y;
			public Point(int x, int y){
				this.x = x;
				this.y = y;
			}
			public Point(){
			}
			public int getX() {
				return x;
			}
			public void setX(int x) {
				this.x = x;
			}
			public int getY() {
				return y;
			}
			public void setY(int y) {
				this.y = y;
			}
			public double getDistant(){
				return getDistant(0,0);
			}
			public double getDistant(int x, int y){
				int x1 = this.x-x;
				int y1 = this.y - y;
				return Math.sqrt(x1*x1 + y1*y1);
			}
			public String toString(){
				return "x="+x+",y="+y;
			}
		}
		
		System.out.println("常规方式:");
		Point ox = new Point(3,4);
		System.out.println(ox);
		System.out.println("1111result="+ox.getDistant());
		System.out.println("1111result="+ox.getDistant(5,8));
		
		System.out.println("反射方式:");
		//Class clazz = Point.class;
		Class clazz = Class.forName("com.yuqiaotech.helloj2ee.java.reflect.ReflectSample$1Point");
		System.out.println("获取Point类的构造函数对象，使用该对象得到一个Point类的实例");
		//获取代表这个构造函数的对象public Point(int x, int y)
		Constructor c = clazz.getConstructor(int.class, int.class);
		Object[] args = new Object[] {3, 4};
		//Point o = new Point(3,4);
		Object o = c.newInstance(args);
		System.out.println(o);
		System.out.println("调用上述代码得到的实例的public double getDistant()方法，并执行它");
		//public double getDistant()
		Method m = clazz.getMethod("getDistant", null);
		//Double result = o.getDistant();
		Double result = (Double)m.invoke(o, null);
		System.out.println("result="+result);
		System.out.println("调用上述代码得到的实例的public double getDistant(int x, int y)方法，" +
				"并执行getDistant(5,8)");
		//public double getDistant(int x, int y)
		Method m2 = clazz.getMethod("getDistant", new Class[]{int.class,int.class});
		//Double result2 = o.getDistant(5,8);
		Double result2 = (Double)m2.invoke(o, new int[]{5,8});
		System.out.println("result2="+result2);
	}
}