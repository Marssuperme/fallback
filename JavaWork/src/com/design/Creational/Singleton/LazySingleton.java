package com.design.Creational.Singleton;

/**
 * <b>单例模式：懒汉式</b><br>
 * 以时间换空间，节约内存空间<br>
 * <b>缺点：静态工厂方法必须加锁 synchronized 才能保证单例</b>
 */
public class LazySingleton {

	private static LazySingleton instance = null;
	
	private LazySingleton(){
		
	}
	
	// 静态工厂方法使用了同步化，以处理多线程环境。(synchronized : 线程安全)
	public static synchronized LazySingleton getInstance(){
		
		if(instance == null){
			instance = new LazySingleton();
		}
		return instance;
	}

	public static void main(String[] args) {
		System.out.println(LazySingleton.getInstance());
		System.out.println(LazySingleton.getInstance());
		System.out.println(LazySingleton.getInstance());

	}

	
}
