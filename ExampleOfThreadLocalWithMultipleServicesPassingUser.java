
class User{

	public static User getUser() {
		// TODO Auto-generated method stub
		return new User();
	}
	
}


class UserContextHolder{
	
	public static ThreadLocal<User> holder=new  ThreadLocal<>();
}

class Service1{
	public void process() {
		User user=User.getUser();
		UserContextHolder.holder.set(user);//set it for thread
		System.out.println(user);
	}
}

class Service2{
	public void process() {
		User user=UserContextHolder.holder.get();//get it for thread
		System.out.println(user);
	}
}


class ServiceLast{
	public void process() {
		System.out.println(UserContextHolder.holder.get());
		UserContextHolder.holder.remove();//remove the user when last thread is executed
		System.out.println(UserContextHolder.holder.get()+ "  after clean up");
	}
}

public class ExampleOfThreadLocalWithMultipleServicesPassingUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		new Service1().process();
		new Service2().process();
		new ServiceLast().process();
	}

}
