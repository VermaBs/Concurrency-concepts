import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample2 {

	static class CpuIntensiveTask implements Runnable {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			//some cpu intensive operation
			System.out.println("Thread  "+Thread.currentThread().getName());
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int coreCount=Runtime.getRuntime().availableProcessors();
       System.out.println(coreCount+"  core machine");
       final ExecutorService service=Executors.newFixedThreadPool(coreCount);
       
       //thread pool usage blocking queue to make thread safe operation
		for(int i=0 ;i<20 ; i++) {
			service.execute(new CpuIntensiveTask());
		}
		System.out.println("Thread  "+Thread.currentThread().getName());
	}

}
