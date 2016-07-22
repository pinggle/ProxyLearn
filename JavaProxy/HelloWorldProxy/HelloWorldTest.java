
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class HelloWorldTest {
	
	public static void main(String [] args) {
		HelloWorldInterface helloWorld = new HelloWorldImpl();
		InvocationHandler handler = new HelloWorldHandler(helloWorld);

		/****************************************************************************************************************************************
		 *  创建动态代理对象;
		 * Proxy 这个类的作用就是用来动态创建一个代理对象的类,
		 * 它提供了一个方法 newProxyInstance 来得到一个动态的代理对象;
		 * public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h) throws IllegalArgumentException;
		 * newProxyInstance 接收三个参数:
		 * loader: 一个 ClassLoader 对象,定义了由哪个 ClassLoader 对象来对生成的代理对象进行加载;
		 * interfaces: 一个 Interface 对象的数组,表示的是我将要给我需要代理的对象提供一组什么接口,如果我提供了一组接口给它,那么这个代理对象就宣称
		 * 	       实现了该接口(多态), 这样我就能调用这组接口中的方法了.
		 * h: 一个 InvocationHandler 对象,表示的是当我这个动态代理对象在调用方法的时候,会关联到哪一个 InvocationHandler 对象上.
		*****************************************************************************************************************************************/
		HelloWorldInterface proxy = (HelloWorldInterface)Proxy.newProxyInstance(
				helloWorld.getClass().getClassLoader(),
				helloWorld.getClass().getInterfaces(),
				handler);
		proxy.sayHelloWorld();
		System.out.println("DTPrint HelloWorldTest Print ... ");
	}
}
