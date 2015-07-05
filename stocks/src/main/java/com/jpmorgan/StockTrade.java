package com.jpmorgan;

import java.util.Date;


public class StockTrade
{

	private Date timestamp;

	private int quantity;

	private boolean isBuy;

	private double tradePrice;

	public Date getTimestamp()
	{
		return timestamp;
	}

	public void setTimestamp(final Date timestamp)
	{
		this.timestamp = timestamp;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(final int quantity)
	{
		this.quantity = quantity;
	}

	public boolean isBuy()
	{
		return isBuy;
	}

	public void setBuy(final boolean isBuy)
	{
		this.isBuy = isBuy;
	}

	public double getTradePrice()
	{
		return tradePrice;
	}

	public void setTradePrice(final double tradePrice)
	{
		this.tradePrice = tradePrice;
	}


}
