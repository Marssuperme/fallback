package com.design.Creational.Singleton;

/**
 * <b>单例模式： 饿汉式</b><br>
 * 以空间换时间，节约运行时间
 */
public class EagerSingleton {

	// 当这个类被加载时，静态变量instance会被初始化，此时类的私有构造子方法会被调用
	private static EagerSingleton instance = new EagerSingleton();

	// 私有构造子方法
	private EagerSingleton() {

	}

	// 静态工厂方法
	public static EagerSingleton getInstance() {

		return instance;

	}

	public static void main(String[] args) {
		System.out.println(EagerSingleton.getInstance());
		System.out.println(EagerSingleton.getInstance());
		System.out.println(EagerSingleton.getInstance());


	}

}
