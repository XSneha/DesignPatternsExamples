# DesignPattersPracticeExamples
Practice examples build for understanding design patterns 

## Useful Links
- https://refactoring.guru/design-patterns
- https://refactoring.guru/refactoring
- http://cse.hcmut.edu.vn/~thai/books/Design_Patterns_Elements_of_Reusable_Object-Oriented_Software.pdf 

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


