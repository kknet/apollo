package io.ffreedom.redstone.adaptor.jctp;

import java.util.stream.Collectors;

import ctp.thostapi.CThostFtdcInputOrderActionField;
import ctp.thostapi.CThostFtdcInputOrderField;
import io.ffreedom.common.functional.Converter;
import io.ffreedom.jctp.JctpGateway;
import io.ffreedom.redstone.adaptor.jctp.converter.outbound.CtpOutboundCancelOrderConverter;
import io.ffreedom.redstone.adaptor.jctp.converter.outbound.CtpOutboundNewOrderConverter;
import io.ffreedom.redstone.adaptor.jctp.dto.CtpSubscribeMarketData;
import io.ffreedom.redstone.adaptor.jctp.exception.OrderRefNotFoundException;
import io.ffreedom.redstone.core.account.Account;
import io.ffreedom.redstone.core.adaptor.OutboundAdaptor;
import io.ffreedom.redstone.core.adaptor.dto.ReplyBalance;
import io.ffreedom.redstone.core.adaptor.dto.ReplyPositions;
import io.ffreedom.redstone.core.order.Order;

public class JctpOutboundAdaptor extends OutboundAdaptor<CtpSubscribeMarketData, ReplyPositions, ReplyBalance> {

	private Converter<Order, CThostFtdcInputOrderField> newOrderConverter = new CtpOutboundNewOrderConverter();

	private Converter<Order, CThostFtdcInputOrderActionField> cancelOrderConverter = new CtpOutboundCancelOrderConverter();

	private JctpGateway gateway;

	public JctpOutboundAdaptor(int adaptorId, String adaptorName, JctpGateway gateway) {
		super(adaptorId, adaptorName);
		this.gateway = gateway;
		init();
	}

	@Override
	public void init() {

	}

	@Override
	public String getAdaptorName() {
		return "Ctp_Outbound_Adaptor";
	}

	@Override
	public int getAdaptorId() {
		return 0;
	}

	@Override
	public boolean close() {
		return false;
	}

	@Override
	public boolean newOredr(Order order) {
		CThostFtdcInputOrderField ctpNewOrder = newOrderConverter.convert(order);
		JctpOrderRefLogger.put(ctpNewOrder.getOrderRef(), order.getOrdSysId());
		gateway.newOrder(ctpNewOrder);
		return true;
	}

	@Override
	public boolean cancelOrder(Order order) {
		try {
			CThostFtdcInputOrderActionField ctpCancelOrder = cancelOrderConverter.convert(order);
			String orderRef = JctpOrderRefLogger.getOrderRef(order.getOrdSysId());
			ctpCancelOrder.setOrderRef(orderRef);
			gateway.cancelOrder(ctpCancelOrder);
			return true;
		} catch (OrderRefNotFoundException e) {
			// TODO log
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean subscribeMarketData(CtpSubscribeMarketData subscribeMarketData) {
		try {
			gateway.subscribeMarketData(subscribeMarketData.getInstrumentSet().stream()
					.map(instrument -> instrument.getInstrumentCode()).collect(Collectors.toSet()));
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public ReplyPositions queryPositions(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReplyBalance queryBalance(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

}