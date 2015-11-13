# jpmorgan
============================
cd stocks
mvn clean package
Usage:
java -jar target/stocks-0.0.1-SNAPSHOT.jar (displays the help usage)
java -jar target/stocks-0.0.1-SNAPSHOT.jar -m 1 -s POP
arguments:
-m [--marketprice] Market Price
-s [--stocksymbol] Stock Symbol (TEA, POP, ALE, GIN, JOE)
Calculates the dividend yield, P/E ratio, geometric mean, volume weighted stock price
