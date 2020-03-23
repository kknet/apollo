package io.redstone.core.order.structure;

import io.mercury.common.sequence.Serial;
import io.redstone.core.order.enums.OrdStatus;

public final class OrdReport implements Serial<OrdReport> {

	private long serialNumber = System.nanoTime();
	
	/**
	 * mapping to order ordSysId
	 */
	private long ordSysId;

	/**
	 * report epoch milliseconds
	 */
	private long epochMillis;

	/**
	 * order status of now report
	 */
	private OrdStatus ordStatus;

	/**
	 * broker return id
	 */
	private String brokerUniqueId;

	/**
	 * filled quantity
	 */
	private long filledQty;

	/**
	 * leaves quantity
	 */
	// private long leavesQty;

	/**
	 * order execute price
	 */
	private long executePrice;

	public long getOrdSysId() {
		return ordSysId;
	}

	public long getEpochMillis() {
		return epochMillis;
	}

	public OrdStatus getOrdStatus() {
		return ordStatus;
	}

	public String getBrokerUniqueId() {
		return brokerUniqueId;
	}

	public long getFilledQty() {
		return filledQty;
	}

	public long getExecutePrice() {
		return executePrice;
	}

	public OrdReport setOrdSysId(long ordSysId) {
		this.ordSysId = ordSysId;
		return this;
	}

	public OrdReport setEpochMillis(long epochMillis) {
		this.epochMillis = epochMillis;
		return this;
	}

	public OrdReport setOrdStatus(OrdStatus ordStatus) {
		this.ordStatus = ordStatus;
		return this;
	}

	public OrdReport setBrokerUniqueId(String brokerUniqueId) {
		this.brokerUniqueId = brokerUniqueId;
		return this;
	}

	public OrdReport setFilledQty(long filledQty) {
		this.filledQty = filledQty;
		return this;
	}

	public OrdReport setExecutePrice(long executePrice) {
		this.executePrice = executePrice;
		return this;
	}

	@Override
	public long serialNumber() {
		return serialNumber;
	}

}