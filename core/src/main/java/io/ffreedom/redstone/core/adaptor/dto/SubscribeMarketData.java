package io.ffreedom.redstone.core.adaptor.dto;

import org.eclipse.collections.api.set.ImmutableSet;

import io.ffreedom.common.collections.ImmutableSets;
import io.ffreedom.polaris.financial.Instrument;

public class SubscribeMarketData {

	private ImmutableSet<Instrument> instrumentSet;

	protected SubscribeMarketData(Instrument... instruments) {
		this.instrumentSet = ImmutableSets.newImmutableSet(instruments);
	}

	public static SubscribeMarketData build(Instrument... instruments) {
		return new SubscribeMarketData(instruments);
	}

	public ImmutableSet<Instrument> getInstrumentSet() {
		return instrumentSet;
	}

}
