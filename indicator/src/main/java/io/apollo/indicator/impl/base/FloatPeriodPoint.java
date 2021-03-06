package io.apollo.indicator.impl.base;

import java.time.ZonedDateTime;

import io.gemini.definition.market.data.MarketData;
import io.gemini.definition.market.vector.TimePointSerial;

public abstract class FloatPeriodPoint<M extends MarketData> extends BasePoint<TimePointSerial, M> {

	protected FloatPeriodPoint(int index, TimePointSerial serial) {
		super(index, serial);
	}

	public ZonedDateTime timePoint() {
		return serial.timePoint();
	}

}