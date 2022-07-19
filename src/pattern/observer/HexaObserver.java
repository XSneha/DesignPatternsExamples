package pattern.observer;

public class HexaObserver extends Observer {

	public HexaObserver(Subject subject) {
		this.subject = subject;
		//attaching himself to the observer list of subject
		this.subject.attach(this);
	}

	@Override
	public void update() {
		//on update of subject
		System.out.println("HexaObserver	: Subject state updated , Hex String	: " + Integer.toHexString(subject.getState()));
	}

}
