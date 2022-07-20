package patterns.chain.of.respisibility;

public class ChainOfResponsibilityExample {
	public static void main(String args[]) {
		King king = new King();
		king.makeRequest(new Request(Request.RequestType.COLLECT_TAX, "collect tax"));
		king.makeRequest(new Request(Request.RequestType.DEFEND_CASTLE, "defend castle"));
		king.makeRequest(new Request(Request.RequestType.TORTURE_PRISONER, "torture prisoner"));
		king.makeRequest(new Request(Request.RequestType.COLLECT_TAX, "collect tax"));
	}
}

/*
 * Applicability
Use Chain of Responsibility when

1.	More than one object may handle a request, and the handler isn't known a priori. The handler should be ascertained automatically.
2. 	You want to issue a request to one of several objects without specifying the receiver explicitly.
3.	The set of objects that can handle a request should be specified dynamically.
	
	Known uses
1.	java.util.logging.Logger#log()
2.	Apache Commons Chain
3.	javax.servlet.Filter#doFilter()

 * */


/*
 * output :
 * 
	-- current phase	: Comnder is not applicable for request : collect tax
	-- check next phase	: Officer
	-- current phase	: Officer is not applicable for request : collect tax
	-- check next phase	: Soldier
/--Soldier--/	is handling request ->	collect tax
/--Comnder--/	is handling request ->	defend castle
	-- current phase	: Comnder is not applicable for request : torture prisoner
	-- check next phase	: Officer
/--Officer--/	is handling request ->	torture prisoner
	-- current phase	: Comnder is not applicable for request : collect tax
	-- check next phase	: Officer
	-- current phase	: Officer is not applicable for request : collect tax
	-- check next phase	: Soldier
/--Soldier--/	is handling request ->	collect tax

 * */
 