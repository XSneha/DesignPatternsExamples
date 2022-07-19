package pattern.observer;

public class ObserverPatternExample {
	public static void main(String args[]) {
		Subject subject = new Subject();

		//setting 2 observers to observer and notify on update in subject object
		new StringObserver(subject);
		new BinaryObserver(subject);
		new OctalObserver(subject);
		new HexaObserver(subject);

		System.out.println("\nSubject State change	: 45");
		subject.setState(45);
		System.out.println("\n\nSubject State change	: 150");
		subject.setState(150);
	}
}


/*
 * output :
 * 
Subject State change	: 45
StringObserver 	: Subject state updated , String	: 45
BinaryObserver 	: Subject state updated , Binary String	: 101101
OctalObserver	: Subject state updated , Octal String	: 55
HexaObserver	: Subject state updated , Hex String	: 2d


Subject State change	: 150
StringObserver 	: Subject state updated , String	: 150
BinaryObserver 	: Subject state updated , Binary String	: 10010110
OctalObserver	: Subject state updated , Octal String	: 226
HexaObserver	: Subject state updated , Hex String	: 96
 * */
 