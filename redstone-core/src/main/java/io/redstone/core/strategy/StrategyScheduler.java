package io.redstone.core.strategy;

import io.mercury.financial.market.impl.BasicMarketData;
import io.redstone.core.adaptor.AdaptorStatus;
import io.redstone.core.order.structure.OrdReport;

public interface StrategyScheduler {

	void onMarketData(BasicMarketData marketData);

	void onOrderReport(OrdReport orderReport);

	void onAdaptorStatus(int adaptorId, AdaptorStatus status);

	void addStrategy(Strategy strategy);

}
