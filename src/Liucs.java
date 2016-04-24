

import org.junit.Test;

public class Liucs {
	@Test
	public void test01(){
		String str = String.format("%16s", "哈哈").replace(' ', '0');
		System.out.println(str);
		str = String.format("%s", "哈哈");
	}
	@Test
	public void test02(){
		System.out.println("hello word");
	}
}
