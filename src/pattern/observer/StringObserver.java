package pattern.observer;

public class StringObserver extends Observer {
	
	public StringObserver(Subject subject){
		this.subject = subject;
		//attaching BObserver in observer list of Subjects
		this.subject.attach(this);
	}	
	
	@Override
	public void update() {
		System.out.println("StringObserver 	: Subject state updated , String	: " + Integer.toString(subject.getState()));
	}
}
