package pattern.observer;

public abstract class Observer {
	Subject subject;
	abstract public void update();
}
