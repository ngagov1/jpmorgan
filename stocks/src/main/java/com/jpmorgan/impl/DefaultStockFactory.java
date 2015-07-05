package com.jpmorgan.impl;

import com.jpmorgan.Stock;
import com.jpmorgan.StockFactory;
import com.jpmorgan.StockSymbol;
import com.jpmorgan.StockType;
import com.jpmorgan.exception.StockException;


public abstract class DefaultStockFactory implements StockFactory
{
	public Stock createStock() throws StockException
	{
		final Stock stock = new Stock();
		stock.setStockSymbol(getStockSymbol());
		stock.setFixedFividend(getFixedFividend());
		stock.setLastDividend(getLastDividend());
		stock.setParValue(getParValue());
		stock.setStockType(getStockType());
		return stock;
	}

	public abstract StockSymbol getStockSymbol();

	public abstract StockType getStockType();

	public abstract double getLastDividend();

	public abstract double getParValue();

	public abstract double getFixedFividend();

}
