package pattern.observer;

public class BinaryObserver extends Observer {

	public BinaryObserver(Subject subject) {
		this.subject = subject;
		//attaching himself to the observer list of subject
		this.subject.attach(this);
	}

	@Override
	public void update() {
		//on update of subject
		System.out.println("BinaryObserver 	: Subject state updated , Binary String	: " + Integer.toBinaryString(subject.getState()));
	}

}
