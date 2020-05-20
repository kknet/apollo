package io.mercury.ftdc.gateway.bean;

public final class RspTraderConnect {

	private int FrontID;
	private int SessionID;
	private boolean Available;

	public RspTraderConnect(boolean Available) {
		this.Available = Available;
	}

	public int getFrontID() {
		return FrontID;
	}

	public int getSessionID() {
		return SessionID;
	}

	public boolean isAvailable() {
		return Available;
	}

	public RspTraderConnect setFrontID(int frontID) {
		FrontID = frontID;
		return this;
	}

	public RspTraderConnect setSessionID(int sessionID) {
		SessionID = sessionID;
		return this;
	}

}
