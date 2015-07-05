package com.jpmorgan;

public class Stock
{
	private StockSymbol stockSymbol;
	private StockType stockType;
	private double fixedFividend;
	private double lastDividend;
	private double parValue;

	public StockSymbol getStockSymbol()
	{
		return stockSymbol;
	}

	public void setStockSymbol(final StockSymbol stockSymbol)
	{
		this.stockSymbol = stockSymbol;
	}

	public StockType getStockType()
	{
		return stockType;
	}

	public void setStockType(final StockType stockType)
	{
		this.stockType = stockType;
	}

	public double getLastDividend()
	{
		return lastDividend;
	}

	public void setLastDividend(final double lastDividend)
	{
		this.lastDividend = lastDividend;
	}

	public double getParValue()
	{
		return parValue;
	}

	public void setParValue(final double parValue)
	{
		this.parValue = parValue;
	}

	public double getFixedFividend()
	{
		return fixedFividend;
	}

	public void setFixedFividend(final double fixedFividend)
	{
		this.fixedFividend = fixedFividend;
	}


}
