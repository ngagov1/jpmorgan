package com.jpmorgan.impl;

import com.jpmorgan.StockSymbol;
import com.jpmorgan.StockType;


public class TEAStockFactory extends DefaultStockFactory
{

	@Override
	public StockType getStockType()
	{
		return StockType.Common;
	}

	@Override
	public double getLastDividend()
	{
		return 0.00;
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
		return StockSymbol.TEA;
	}

}
