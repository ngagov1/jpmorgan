package com.jpmorgan;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

import org.apache.log4j.Logger;

import com.jpmorgan.exception.StockException;
import com.jpmorgan.util.RandomUtil;


public class StockMain
{
	private static Logger log = Logger.getLogger(StockMain.class);

	public static void main(final String[] args) throws StockException
	{
		final ArgumentParser parser = ArgumentParsers.newArgumentParser("StocksCalculator").defaultHelp(true)
				.description("Calculate checksum of given files.");
		parser.addArgument("-s", "--stocksymbol").required(true).choices("TEA", "POP", "ALE", "GIN", "JOE")
				.help("Specify stock symbol to use");
		parser.addArgument("-m", "--marketprice").type(Double.class).required(true).help("Provide marketprice");
		Namespace ns = null;
		try
		{
			ns = parser.parseArgs(args);
		}
		catch (final ArgumentParserException e)
		{
			parser.handleError(e);
			System.exit(1);
		}

		final String stockSymbol = ns.getString("stocksymbol");
		final Double marketprice = ns.getDouble("marketprice");
		log.info("stockSymbol=" + stockSymbol + ", marketprice=" + marketprice);
		final StockFactory factory = AbstractStockFactory.create(stockSymbol);
		final Stock stock = factory.createStock();
		final double dividendYield = StocksCalculator.calcDividendYield(marketprice, stock);
		log.info("dividendYield = " + dividendYield);
		final double priceEarningsRatio = StocksCalculator.priceEarningsRatio(marketprice, stock);
		log.info("priceEarningsRatio = " + priceEarningsRatio);
		final int tradesNumber = RandomUtil.randomWithRange(1, 20);
		final int quantity = RandomUtil.randomWithRange(1, 100);
		final List<StockTrade> trades = createTrades(tradesNumber, true, quantity);
		final double geometricMean = StocksCalculator.calculateGeometricMean(trades);
		final BigDecimal gMean = new BigDecimal(geometricMean);
		gMean.setScale(2, RoundingMode.HALF_UP);
		log.info("geometricMean = " + gMean.toEngineeringString());
		final double volumeWeightedStockPrice = StocksCalculator.calculateVolumeWeightedStockPrice(trades);
		final BigDecimal vWeightedStockPrice = new BigDecimal(volumeWeightedStockPrice);
		vWeightedStockPrice.setScale(2, RoundingMode.HALF_UP);
		log.info("volumeWeightedStockPrice = " + vWeightedStockPrice.toEngineeringString());
	}



	private static List<StockTrade> createTrades(final int number, final boolean isBuy, final int quantity)
	{
		final List<StockTrade> result = new ArrayList<StockTrade>();
		for (int i = 0; i < number; i++)
		{
			result.add(createTrade(isBuy, quantity));
		}
		return result;
	}

	private static StockTrade createTrade(final boolean isBuy, final int quantity)
	{
		final StockTrade stockTrade = new StockTrade();
		stockTrade.setBuy(isBuy);
		stockTrade.setQuantity(quantity);
		stockTrade.setTimestamp(new Date());
		stockTrade.setTradePrice(RandomUtil.randomWithRange(1, 200));
		log.info("Generating trade, quantity=" + quantity + ((isBuy) ? " buy " : "sell")
				+ DateFormat.getInstance().format(stockTrade.getTimestamp()) + ", tradePrice=" + stockTrade.getTradePrice());
		return stockTrade;
	}
}
