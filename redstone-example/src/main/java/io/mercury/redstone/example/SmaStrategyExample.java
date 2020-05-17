package io.mercury.redstone.example;

import io.mercury.financial.instrument.Instrument;
import io.mercury.financial.market.impl.BasicMarketData;
import io.mercury.indicator.event.SmaEvent;
import io.mercury.indicator.impl.ma.SmaPoint;
import io.mercury.redstone.core.order.Order;
import io.mercury.redstone.engine.impl.strategy.StrategySimpleImpl;

public class SmaStrategyExample extends StrategySimpleImpl<BasicMarketData> implements SmaEvent {

	public SmaStrategyExample(int strategyId, int subAccountId, Instrument instrument) {
		super(strategyId, "SmaStrategyExample", subAccountId, instrument);
	}

	@Override
	protected void handleMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub
	}

	@Override
	protected void handleOrder(Order order) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onCurrentPointAvgPriceChanged(SmaPoint point) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStartSmaPoint(SmaPoint point) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onEndSmaPoint(SmaPoint point) {
		// TODO Auto-generated method stub
	}

	@Override
	public String eventName() {
		// TODO Auto-generated method stub
		return null;
	}


}
