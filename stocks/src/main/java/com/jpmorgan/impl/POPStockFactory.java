package com.jpmorgan.impl;

import com.jpmorgan.StockSymbol;
import com.jpmorgan.StockType;


public class POPStockFactory extends DefaultStockFactory
{

	@Override
	public StockType getStockType()
	{
		return StockType.Common;
	}

	@Override
	public double getLastDividend()
	{
		return 8.00;
	}

	@Override
	public double getParValue()
	{
		return 100.00;
	}

	@Override
	public double getFixedFividend()
	{
		return 0;
	}

	@Override
	public StockSymbol getStockSymbol()
	{
		return StockSymbol.POP;
	}

}
