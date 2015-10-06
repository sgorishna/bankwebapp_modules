package com.webapp.utils;

import java.util.HashMap;

import com.webapp.actions.AbstractServletHandler;

public class CacheImitation extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	private static HashMap<Long, byte[]> cache = new HashMap<Long, byte[]>();

	public static byte[] findInCache(long idCustomer) {

		return cache.get(idCustomer);

	}

	public static void putInCache(long idCustomer, byte[] data) {

		cache.put(idCustomer, data);

	}

	public static void removeFromCache(long idCustomer) {

		cache.remove(idCustomer);

	}

}
