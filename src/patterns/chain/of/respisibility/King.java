package patterns.chain.of.respisibility;

public class King {
	 RequestHandler chain;
 
	  public King() {
	    buildChain();
	  }

	  private void buildChain() {
		//building chain of responsibility as Commander -> Officer -> Soldier
	    chain = new OrcCommander(new OrcOfficer(new OrcSoldier(null)));
	  }

	  public void makeRequest(Request req) {
	    chain.handleRequest(req);
	  }
}
