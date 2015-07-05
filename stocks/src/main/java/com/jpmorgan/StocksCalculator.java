package com.jpmorgan;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;



public class StocksCalculator
{
	public static double calcDividendYield(final Double marketPrice, final Stock stock)
	{
		double result = 0.00;
		if (StockType.Preferred == stock.getStockType())
		{
			result = ((new BigDecimal(stock.getFixedFividend()).multiply(new BigDecimal(stock.getParValue()))).divide(
					new BigDecimal(marketPrice), 2, RoundingMode.HALF_EVEN)).doubleValue();
		}
		else
		{
			result = (new BigDecimal(stock.getLastDividend()).divide(new BigDecimal(marketPrice), 2, RoundingMode.HALF_EVEN))
					.doubleValue();
		}
		return result;
	}

	public static double priceEarningsRatio(final Double marketPrice, final Stock stock)
	{
		if (stock.getLastDividend() == 0.0)
		{
			return 0.0;
		}
		final double result = new BigDecimal(marketPrice)
				.divide(new BigDecimal(stock.getLastDividend()), 2, RoundingMode.HALF_EVEN).doubleValue();
		return result;
	}

	public static double calculateGeometricMean(final List<StockTrade> trades)
	{
		double result = 1.0;
		BigDecimal res = new BigDecimal(result);
		for (final StockTrade trade : trades)
		{
			res = res.multiply(new BigDecimal(trade.getTradePrice()));
		}

		result = Math.sqrt(res.doubleValue());
		return result;
	}

	public static double calculateVolumeWeightedStockPrice(final List<StockTrade> trades)
	{
		double result = 0.0;
		BigDecimal res = new BigDecimal(result);
		BigDecimal divider = new BigDecimal(result);
		for (final StockTrade trade : trades)
		{
			res = res.add(new BigDecimal(trade.getQuantity()).multiply(new BigDecimal(trade.getTradePrice())));
			divider = divider.add(new BigDecimal(trade.getQuantity()));
		}

		res = res.divide(divider, 2, RoundingMode.HALF_EVEN);
		result = res.doubleValue();
		return result;
	}
}
