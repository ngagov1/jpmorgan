package com.jpmorgan;

import com.jpmorgan.exception.StockException;


public interface StockFactory
{
	public Stock createStock() throws StockException;
}
