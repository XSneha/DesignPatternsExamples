package patterns.chain.of.respisibility;

public class OrcCommander extends RequestHandler {

	public OrcCommander(RequestHandler handler) {
		super(handler);
	}

	@Override
	public void handleRequest(Request req) {
		if (req.getRequestType().equals(Request.RequestType.DEFEND_CASTLE)) {
			printHandling(req);
			req.markHandled();
		} else {
			super.handleRequest(req);
		}
	}
	
	@Override
	public String toString(){
		return "Comnder";
	}
}
