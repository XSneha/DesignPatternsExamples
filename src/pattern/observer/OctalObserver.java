package pattern.observer;

public class OctalObserver extends Observer {

	public OctalObserver(Subject subject){
		this.subject = subject;
		//attaching AObserver in observer list of Subjects
		this.subject.attach(this);
	}	
	
	@Override
	public void update() {
		System.out.println("OctalObserver	: Subject state updated , Octal String	: " + Integer.toOctalString(subject.getState()));
	}

}
