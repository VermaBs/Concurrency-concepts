import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyCallable implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(3000);
		return 3;
	}
	
}
public class Callable_test1 {
	

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		int threads=1;
		ExecutorService pool=Executors.newFixedThreadPool(threads);
		Future<Integer> future=pool.submit(new MyCallable()); //Future is a placeholder  for returned value
		
		int i=future.get();//its an blocking method , it will block the main thread excetution till Future get the value 
		//i put sleep for 3 sec means it will not proceed further from line 26 for 3 sec
		System.out.println(i);
		pool.shutdown();
	}

}
