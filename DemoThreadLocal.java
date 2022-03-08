import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ThreadSafeFormatter{
	   private static ExecutorService threadpool=Executors.newFixedThreadPool(10);
	   
	   /*
	    * before java 8
	    * 
	    public static ThreadLocal<SimpleDateFormat> dateFormatter=new ThreadLocal<SimpleDateFormat>() {
	    	
	    	@Override
	    	protected SimpleDateFormat intialValue() {
				return new SimpleDateFormat("yyyy-MM-dd");
			}
	    	
	        @Override
	    	public SimpleDateFormat get() {
	    		return super.get();
	    	}
	    };
	    
	    */
	   
	   //After java 8
	   
	   public static ThreadLocal<SimpleDateFormat> dateFormatter=ThreadLocal.withInitial(()-> new SimpleDateFormat("yyyy-mm-dd") );
	   //with initial is a factory method that will return object of formatter
}

public class DemoThreadLocal {
 
    		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      System.out.println( new DemoThreadLocal().userDOB(1));
	}
	
	public String userDOB(int userId) {
		Date date=new Date() ;//getDOBFromDB(userId);
		final SimpleDateFormat df=ThreadSafeFormatter.dateFormatter.get();
		return df.format(date);
	}

}
