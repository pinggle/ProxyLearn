1.说明: 
  HelloWorldTest.java 是一个测试 代理对象 使用的基础类;
  也是 main 入口函数的所在类;
  _build.sh 是编译脚本;
  _run.sh 是运行脚本;
  _clean.sh 是清理脚本;

2.重点:
/*************************************************************************************************************************************
 *  创建动态代理对象;
 * Proxy 这个类的作用就是用来动态创建一个代理对象的类,
 * 它提供了一个方法 newProxyInstance 来得到一个动态的代理对象;
 * public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h) throws IllegalArgumentException;
 * newProxyInstance 接收三个参数:
 * interfaces: 一个 Interface 对象的数组,表示的是我将要给我需要代理的对象提供一组什么接口,如果我提供了一组接口给它,那么这个代理对象就宣称
 *             实现了该接口(多态), 这样我就能调用这组接口中的方法了.
 * h: 一个 InvocationHandler 对象,表示的是当我这个动态代理对象在调用方法的时候,会关联到哪一个 InvocationHandler 对象上.
 *************************************************************************************************************************************/
HelloWorldInterface proxy = (HelloWorldInterface)Proxy.newProxyInstance(
	helloWorld.getClass().getClassLoader(),
	helloWorld.getClass().getInterfaces(),
	handler);

3.概念:
  什么是动态代理?
  动态代理可以提供对另一个对象的访问, 同时隐藏实际对象的具体事实。代理一般会实现它所表示的实际对象的接口。
  代理可以访问实际对象，但是延迟实现实际对象的部分功能,实际对象实现系统的实际功能,代理对象对客户隐藏了实际对象。
  客户不知道它是与代理打交道还是与实际对象打交道.

  为什么使用动态代理?
  因为动态代理可以对请求进行任何处理.

  哪些地方需要动态代理?
  不允许直接访问某些类, 对访问类要做特殊处理等.

4.建议:
  看 <深入理解Java虚拟机>关于ClassLoader部分 和<设计模式之蝉>关于代理模式部分章节;

5.参考:
  1.http://www.cnblogs.com/linjiqin/archive/2011/02/18/1957600.html (Java动态代理 -- 动态类Proxy的使用)

