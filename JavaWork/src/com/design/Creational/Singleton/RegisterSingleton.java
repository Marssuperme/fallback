package com.design.Creational.Singleton;

/**
 * <b>单例模式：登记式/静态内部类</b><br>
 * 利用了 classloader 机制来保证初始化 instance 时只有一个线程
 */
public class RegisterSingleton {

	// 静态内部类， 只有调用这里是才能创建实例
	private static class SingletonOnHolder{
		
		//静态初始化器，由JVM来保证线程安全
		private static final RegisterSingleton instance = new RegisterSingleton();
	}
	
	private RegisterSingleton(){
		
	}
	
	public static final RegisterSingleton getInstance(){

		return SingletonOnHolder.instance;

	}

	public static void main(String[] args) {
		System.out.println(RegisterSingleton.getInstance());
		System.out.println(RegisterSingleton.getInstance());
		System.out.println(RegisterSingleton.getInstance());

	}


}
