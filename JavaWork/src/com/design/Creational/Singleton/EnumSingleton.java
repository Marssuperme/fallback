package com.design.Creational.Singleton;

/**
 * <b>单例模式： 枚举类型</b><br>
 * 单元素的枚举类型已经成为实现Singleton的最佳方法。用枚举来实现单例非常简单，只需要编写一个包含单个元素的枚举类型即可。
 */
public enum EnumSingleton {

	INSTANCE;	// 定义一个枚举的元素，它就代表了Singleton的一个实例。

	// 单例可以有自己的操作
	public void whateverMethod(){
		
		//功能处理
		
	}



}
