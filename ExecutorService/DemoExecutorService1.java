import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable {
    static int i=0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Thread  "+Thread.currentThread().getName()+"  counter "+ i++);
	}
	
}
public class DemoExecutorService1 {
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final ExecutorService service=Executors.newFixedThreadPool(10);
	    //thread pool usage blocking queue to make thread safe operation
		for(int i=0 ;i<20 ; i++) {
			service.execute(new Task());
		}
		System.out.println("Thread  "+Thread.currentThread().getName());
	}

}
