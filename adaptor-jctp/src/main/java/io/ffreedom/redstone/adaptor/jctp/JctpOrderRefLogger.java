package io.ffreedom.redstone.adaptor.jctp;

import org.eclipse.collections.api.map.primitive.MutableLongObjectMap;
import org.eclipse.collections.api.map.primitive.MutableObjectLongMap;

import io.ffreedom.common.collect.ECollections;
import io.ffreedom.redstone.adaptor.jctp.exception.OrderRefNotFoundException;

/**
 * 
 * @author phoneix
 *
 *         TODO - Persistence
 */

public class JctpOrderRefLogger {

	private MutableObjectLongMap<String> orderRefMappingToOrdSysId = ECollections.newObjectLongHashMap(1024);

	private MutableLongObjectMap<String> ordSysIdMappingToOrderRef = ECollections.newLongObjectHashMap(1024);

	private final static JctpOrderRefLogger INSTANCE = new JctpOrderRefLogger();

	private JctpOrderRefLogger() {
	}

	static void put(String orderRef, long ordSysId) {
		INSTANCE.orderRefMappingToOrdSysId.put(orderRef, ordSysId);
		INSTANCE.ordSysIdMappingToOrderRef.put(ordSysId, orderRef);
	}

	static long getOrdSysId(String orderRef) throws OrderRefNotFoundException {
		if (INSTANCE.orderRefMappingToOrdSysId.containsKey(orderRef))
			return INSTANCE.orderRefMappingToOrdSysId.get(orderRef);
		throw new OrderRefNotFoundException(orderRef);
	}

	static String getOrderRef(long ordSysId) throws OrderRefNotFoundException {
		if (INSTANCE.ordSysIdMappingToOrderRef.containsKey(ordSysId)) {
			return INSTANCE.ordSysIdMappingToOrderRef.get(ordSysId);
		}
		throw new OrderRefNotFoundException(ordSysId);
	}

}