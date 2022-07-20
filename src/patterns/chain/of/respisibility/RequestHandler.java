package patterns.chain.of.respisibility;

public abstract class RequestHandler {
	private final RequestHandler next;

	public RequestHandler(RequestHandler next) {
		this.next = next;
	}

	public void handleRequest(Request req) {
		System.out.println("	-- current phase	: "+this+" is not applicable for request : "+req);
		System.out.println("	-- check next phase	: "+next);
		if (next != null) {
			next.handleRequest(req);
		}
	}

	protected void printHandling(Request req) {
		System.out.println("/--"+this+"--/	is handling request ->	"+ req);
	}

	@Override
	public abstract String toString();
}
