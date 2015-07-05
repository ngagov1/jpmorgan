package com.jpmorgan;

import com.jpmorgan.exception.StockException;
import com.jpmorgan.impl.ALEStockFactory;
import com.jpmorgan.impl.GINStockFactory;
import com.jpmorgan.impl.JOEStockFactory;
import com.jpmorgan.impl.POPStockFactory;
import com.jpmorgan.impl.TEAStockFactory;


public class AbstractStockFactory
{

	public static StockFactory create(final String strStockSymbol) throws StockException
	{
		final StockSymbol stockSymbol = StockSymbol.valueOf(strStockSymbol);
		if (stockSymbol == null)
		{
			throw new StockException("incorrect stockSymbol " + strStockSymbol);
		}
		StockFactory stockFactory = null;
		switch (stockSymbol)
		{
			case TEA:
			{
				stockFactory = new TEAStockFactory();
				break;
			}
			case POP:
			{
				stockFactory = new POPStockFactory();
				break;
			}
			case ALE:
			{
				stockFactory = new ALEStockFactory();
				break;
			}
			case GIN:
			{
				stockFactory = new GINStockFactory();
				break;
			}
			case JOE:
			{
				stockFactory = new JOEStockFactory();
				break;
			}
			default:
			{
				stockFactory = null;
				break;
			}
		}
		return stockFactory;
	}
}
