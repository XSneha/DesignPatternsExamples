# DesignPattersPracticeExamples 

## Useful Links
- https://refactoring.guru/design-patterns
- https://refactoring.guru/refactoring
- https://java-design-patterns.com/
- http://cse.hcmut.edu.vn/~thai/books/Design_Patterns_Elements_of_Reusable_Object-Oriented_Software.pdf 

####  Robert C. Martin - Uncle Bob
-------------------
💎 SOLID Principles
-------------------
- Single Responsibility Principlce (SRP)
- Open/Close Principle
- Liskov's Substitution Principle
- Interface Segregation
- Dependency Inversion

💭 Let's see how we can apply above Principles.
----------
- Let's try to design a Zoo game where model are various characters
--------------------------------------------------------------------
🐶 Designing the Animal class
-------------------
```java
class Animal {
	 // attributes [properties]
	 double weight;
	 String color;
	 String species;
	 int numberOfLegs;
	 boolean hasWings;
	 boolean hasGills;
	 boolean canRun;
	 // behavior [methods]
	 void eat()
	 void fly()
	 void swim()
	 void run()
 	 void breatherUnderwater()
 	 void breatheOnLand()
}
```
🐠 Different animals have different behavior
```java
class Animal {
	 /* other stuff */
	 String species;

	void swim() {
	 	if(species.equals("Tuna") || species.equals("Shark"))
	 	print("Swim fishy swim...")
	 	else if (species.equals("Pigeon") || species.equals("Cheetah"))
         	print("I can't swim!")
 	}
}
```

What is the problems with the above code?
-If we have 100 different species then we might have to write 100 different if-else conditions!
-So what? What is bad about having a lot of if-else cases?
❓ Readable
- Yes. I can read & understand it. But actually no! If I have 100 different species, then this code will no longer be readable
❓ Testable
- Yes. We can write the tests for each species.But actually no. Because any change might have effects all over the place.
❓ Extensible
- Yes. To add a new species, I simply have to add a new if-else condition.But actually no! Because adding a new feathre changes existing code.
❓ Maintainable
- No. You have to look at a lot of code to make a simple changeAdditionally, if multiple devs are working on different species, there will be merge conflicts!


🛠 How to fix this?
Segregate the responsibilities
----------------------------------
⭐ Single Responsibility Principle
----------------------------------
- Every function/class/module (unit of code) should have a single, well-defined responsibility
- Any piece of code should have only 1 reason to change
- If some unit has multiple responsibilities, then we should split it into multiple units

```java
class Animal {
 	String species;
 	double weight;
 	String color;
 	/** other things **/
 	void eat();
 	void breed();
}
class Bird extends Animal {
 	void fly() {}
 	void run() {}
 	void breatheOnLand() {}
}
class Fish extends Animal {
 	void swim();
 	void breatherUnderwater();
}
class Mammal extends Animal {
 	int numberOfLegs;
 	void run();
 	void breatheOnLand();
}
class Insects extends Animal {
 	int numberOfLegs;
 	void jumpHigh();
 	void climbOnWall();
 	void beScreepyAndScary();
}
```
- Readable : No. Because there are a lot of classes now!But actually yes! Note: Redable doesn't mean less code
- Testable : Yes. I can test different species separately!
- Extensible : Yes.
- Maintainable : Kindof. At least the merge conflicts are reduced.

#### 📜 Understanding Rules vs Guidelines
1. Rules: Must be followed! Enforced. ex: Don't commit murder.
2. Guidelines: Good to have, but not enforced.ex: Don't run on water. Be humble.

SOLID principles are Guidelines, and not Rules.

--------------------------------------------------------------------
🐦 Designing a Bird
----------------
```java
class Bird extends Animal {
 	String species;
 	
	void fly() {
 		// .. lots of if-else cases here
 		// we used the species to find the correct behavior
 	}
}
```
🕊 Different Birds fly Differently!
```java
[library] Zoo {
   class Bird extends Animal {
 	String species;
 	void fly() {
 	if(species.equals("Sparrow"))
 		print("Fly low")
 	else if(species.equals("Eagle"))
 		println("Glide elegantly high above ground")
 	else if(species.equals("Dodo"))
 		println("Dude I'm extinct. And even if I were alive, I can't fly!")
 	// New requriement: Add Ostrich
 	else if(species.equals("Ostrich"))
 	...
 	}
   }
}
[executable] Client {
 import Zoo.Bird;
 	// I want to add a new Bird called Penguin
 	// I can't, because I don't have to code!
}
```
🐞 Problems with the above code? Yes! The same problems again!
- Readable. No.
- Testable. No.
- Extensible. No.
- Maintainable. No.
🛠 How to fix this?
New Perspective:Avoid modification of existing code, unless absolutely necessary.

-----------------------
⭐ Open/Close Principle
-----------------------
- Your code should be CLOSED for modification, yet still, OPEN for extension
❔ Why is modification bad? Bad because a lot of things need to be done.Whenever some code is written, what does the process look like?
- Developer = write & test the code on their end
- QA team - test, integration testing..
- Deployed
 + Staging servers - a lot of testing happens once again
 + Deployed to production
 * A/B testing or Beta-testing - 5% of the users
 * Finally deployed to 100% of users
Modifying code is expensive, because of all the above steps.

```java
  [library] Zoo {
 	// shipped as compiled code
 	// .dll files, .so files, .jar files
 	abstract class Bird extends Animal {
 	// abstract: incomplete - not rooted in reality
 	// OOP - abstract classes are blueprints/templates for other concrete
	classes
 	String species;
 	abstract void fly()
  }
  class Sparrow extends Bird {
 	@Override
 	void fly() {
 	print("Fly low")
  }
 }
 class Eagle extends Bird {
 	@Override
 	void fly() {
 		print("Glide elegantly")
 	}
   }
}
[executable] Client {
    // your code
    import Zoo.Bird;
    // add new Bird - Penguin
    class Penguin extends Bird {
 	@Override
 	void fly() {
 		print("Cant Fly!")
 	}
    }
}
```
- Modification.To add a new feature `Ostricth` do I have to? No need for modiciation
- Extension Can totally add new species of Birds without modifing existing code
- Readable. Better
- Testable. Better
- Extensible. Better
- Maintainable. Better
❔ Didn't we do the exact same thing for the Single Responsibility Principle as well? Yes!
❔ SRP = Open/Close? No.

🔗 All the SOLID principles are linked together.
analogy: If you speak the truth, then you're being honest. If you're being
honest, then you will defintely speak the truth!

--------------------------------------------------------------------
🐓 Can all Birds fly?
---------------------
```java
 	abstract class Bird extends Animal {
 		abstract void fly() {}
 	}
 	class Sparrow extends Bird {
 		@Override
 		void fly() {
 			// ...
 		}
 	}
	class Kiwi extends Bird {
 		@Override
 		void fly() {
 			!??
 		}
 	}
```
Penguin, Ostrich, Kiwi, Dodo, Emu .. are birds which cannot fly!
 ❓ How do we solve this?
 • Throw exception with a proper message
 • Don't implement the `fly()` method
 • Return `null`
 • Redesign the system

 Don't implement

```java
 abstract class Bird extends Animal {
 	abstract void fly() {}
 }
 class Kiwi extends Bird {
 	// don't implement void fly()
 }
```

🐞 Compile time Error! Because the fly is an abstract method, it either must be implemented, or the Kiwi class must be marked as abstract as well.
⚠️ Throw an exception
```java
 	abstract class Bird extends Animal {
 		abstract void fly() {}
 	}
 	class Kiwi extends Bird {
 		@Override
 		void fly() {
 			throw new CantFlyException("I can't fly!")
 		}	
 	}
```
🐞 This violates expectations!
```java
[executable] Client {
 	class Main {
 		void main() {
 		Bird b;
 		b = getBirdFromUserInput(); // might return any sort of Bird.
		Sparrow / Eagle / Kiwi
 		b.fly();
 		}
 	}
}
```

✅ Before extension
Code was working fine!
❌ After extension 
We extended `Bird` by creating a new `Kiwi` class.
Code is no longer working! Even though we did not touch the old code!? If we extend working code, the old code should still perform without breaking!

--------------------------------
⭐ Liskov Substitution Principle
--------------------------------
- Any functionality in the parent class must also work for child classes
- If some piece of code works in a parent `class P` then it should still work, without modification, with all child `class C extends P`
- Derived: Any extension to existnt code should not break existing features
🎨 How to re-design it?
```java
abstract class Bird extends Animal {
 	String numberOfWings;
 	bool hasBeak;
 	void speak();
 	// void fly() is not here, because not all birds can fly!
}
interface ICanFly {
 	void fly();
}
class Eagle extends Bird implements ICanFly {
 	@Override
 	void fly() { ... }
}
class Kiwi extends Bird {
 	// do Kiwi stuff
 	// but we don't need to implement void fly() because Kiwi does not implement the ICanFly interface!
}
```
--------------------------------------------------------------------
Can it fly?
-----------
- Flap wings
- Kick off the ground to take off

```java
interface ICanFly {
	 void fly();
	 void flapWings();
	 voif kickToTakeOff();
}
class Eagle extends Bird implements ICanFly {
 	@Override
 	void fly() { ... }
 	@Override
 	void flapWings() { ... }

 	@Override
 	void kickToTakeOff() { ... }
}
```
 ❓ Should these additional methods be part of the ICanFly interface?
 • Yes, obviously. All things methods are related to flying
 • Nope. [send your reason in the chat]

```java
interface ICanFly {
 	void fly();
 	void flapWings();
 	voif kickToTakeOff();
}
// what other things aprt from Bird can fly?
class PapaKiPari implements ICanFly {}
class AeroPlane implements ICanFly {}
class IronMan implements ICanFly {}
class MomsChappal implements ICanFly {}

class Shaktiman implements ICanFly {
 	@Override
 	void flapWings() {
 		print("Sorry Shaktiman!")
 	}
}
```

----------------------------------
⭐ Interface Segregation Principle
----------------------------------
- Keep your interfaces minimal
- No code should be forced to implement a method that it doesn't need To fix previous code, split the `ICanFly` interface into multiple interfaces
- Isn't this simply teh Single Responsibility Principle applied to the `ICanFly` interface? Yes!

🔗 All the SOLID principles are linked
--------------------------------------------------------------------
Now that we've the necessary characters, let's design the structures.
🗑 Design a Bird Cage
---------------------
```java
interface IFeedingBowl {}
class MeatBowl implements IFeedingBowl{}
class FruitBowl implements IFeedingBowl{}
interface Door{}
class IronDoor implements Door{}
class WoodenDoor implements Door{}
class Cage1 {
 	MeatBowl feedingBowl;
 	IronDoor door;
 	List<Tiger> tigers;
 	public Cage() {
 		// add 5 tigers
 		for(int i = 0; i < 5; i++)
 			tigers.add(new Tiger(...));
 	}
}
class Cage2 {
 	FruitBowl feedingBowl;
 	WoodenDoor door;
 	List<Bird> peacocksAndHen;
 	public Cage2() {
 	// add 3 peacocks
 	for(int i = 0; i < 3; i++)
 		peacocksAndHen.add(new Peacock(...));
 	// add 5 hen
 	for(int i = 0; i < 5; i++)
 		peacocksAndHen.add(new Hen(...));
 	}
}
```
🐞 What is wrong with this code?
We have to create many different types of Cage classes.
No reuse of the cage class functionality.
```
 --------------         ---------	 -------
 IFeedingBowl 		 IAnimal 	  IDoor
 -------------- 	--------- 	 -------
 	║ 		   ║ 		   ║	
 	║ 		   ║ 		   ║
┏━━━━━━━━━━━━━━━━━┓ 	┏━━━━━━━┓ 	┏━━━━━━━━━━┓
┃ MeatFeedingBowl ┃ 	┃ Tiger ┃ 	┃ IronDoor ┃
┗━━━━━━━━━━━━━━━━━┛ 	┗━━━━━━━┛ 	┗━━━━━━━━━━┛
        │                  │ 		   │
        ╰──────────────────╁───────────────╯
                           ┃
 			┏━━━━━━━┓
			┃ Cage1 ┃
			┗━━━━━━━┛
```
High-level class `Cage1` depends on the concrete types `MeatBowl`, `Tiger`,
`IronDoor`
---------------------------------
⭐ Dependency Inversion Principle
---------------------------------
- High-level modules should NOT depend on low-level modules.
- Instead, they should depend on Abstactions (interfaces)

```
 --------------        --------- 	-------
 IFeedingBowl           IAnimal 	 IBars
 --------------        --------- 	-------
	 │ 		    │ 		    │
	 ╰──────────────────╁───────────────╯
			    ┃
 			┏━━━━━━┓
			┃ Cage ┃
			┗━━━━━━┛
```
But how?
----------------------
💉 Dependecy Injection
----------------------
- Inestead of creating the dependencies ourselves, we should inject them
```java
	interface IFeedingBowl {}
	class MeatBowl implements IFeedingBowl{}
	class FruitBowl implements IFeedingBowl{}
	interface Door{}
	class IronDoor implements Door{}
	class WoodenDoor implements Door{}
	class Cage {
	 	IFeedingBowl bowl;
		Door door;
 		List<Animal> animals;
 		/* injecting the dependencies from the Client */
 		public Cage(IFeedingBowl bowl, Door door, List<Animal> animals) {
 		this.bowl = bowl;
 		this.door = door;
 		this.animals.addAll(animals);
 	}
}
class Main {
 	void main() {
 		// client
 		Cage cage1 = new Cage(new MeatBowl(),
 		new IronDoor(),
 		Arrays.toList(new Tiger(), ...));
 		Cage cage2 = new Cage(new FruitBowl(),
 		new WoodenDoor(),
 		Arrays.toList(new Peacock(), ...));
 	}
}

```
High-level module `Cage` depends only on the abstactions `FeedingBowl` & `Door`.
• Single Responsbility
• Open/Close
• Liskov Substituion
• Interface Segregation
• Dependency Inversion + Depedency Injection


Find Practice examples above built for understanding design patterns

### Factory Pattern
- Creational pattern.
- object is created without exposing the creation logic to the client and objected created can be referred using a common interface.

### Observer Pattern
- Behavioural pattern.
- One-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.

### Chain of responsibility
- Behavioural pattern.
- Avoid coupling the sender of a request to its receiver by giving more than one object a chance to handle the request. Chain the receiving objects and pass the request along the chain until an object handles it.
(example : The Orc King gives loud orders to his army. The closest one to react is the commander, then an officer, and then a soldier. The commander, officer, and soldier form a chain of responsibility.)
- It helps to build a chain of objects. A request enters from one end and keeps going from an object to another until it finds a suitable handler.
- Applicability : Use Chain of Responsibility when
1.	More than one object may handle a request, and the handler isn't known a priori. The handler should be ascertained automatically.
2. 	You want to issue a request to one of several objects without specifying the receiver explicitly.
3.	The set of objects that can handle a request should be specified dynamically.


