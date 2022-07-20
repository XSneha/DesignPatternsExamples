package patterns.chain.of.respisibility;

public class Request {
	public static enum RequestType {
		DEFEND_CASTLE, TORTURE_PRISONER, COLLECT_TAX
	}

	private final RequestType requestType;
	private final String requestDescription;
	private boolean handled;

	public Request(final RequestType requestType, final String requestDescription) {
		this.requestType = requestType;
		this.requestDescription = requestDescription;
	}

	public RequestType getRequestType() {
		return requestType;
	}

	public String getRequestDescription() {
		return requestDescription;
	}

	public void markHandled() { 
		this.handled = true; 
	}

	 public boolean isHandled() { 
		 return this.handled; 
	 }

	  @Override
	  public String toString() {
		  return getRequestDescription(); 
	  }
}
