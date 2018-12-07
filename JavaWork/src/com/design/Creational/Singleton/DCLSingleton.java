package com.design.Creational.Singleton;

/**
 * <b>单例模式： 双重检验锁DCL ： double-checked locking</b><br>
 * 采用双锁机制，安全且在多线程情况下能保持高性能。
 */
public class DCLSingleton {

	private volatile static DCLSingleton instance = null;

	private DCLSingleton() {

	}

	public static DCLSingleton getInstacne() {

		// 先检查实例是否存在，如果不存在才进入下面的同步块
		if (instance == null) {

			// 同步块，线程安全的创建实例
			synchronized (DCLSingleton.class) {

				// 再次检查实例是否存在，如果不存在才真正的创建实例
				if (instance == null) {

					instance = new DCLSingleton();
				}
			}
		}

		return instance;
	}

	public static void main(String[] args) {
		System.out.println(DCLSingleton.getInstacne());
		System.out.println(DCLSingleton.getInstacne());
		System.out.println(DCLSingleton.getInstacne());
	}


}
