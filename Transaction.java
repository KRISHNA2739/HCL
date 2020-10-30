package practice;

public class Transaction {
	private final Trader trader;
	private final int year;
	private final int value;
	
	public Transaction(Trader trader, int year, int value) {
		
		this.trader = trader;
		this.year = year;
		this.value = value;
	}
	public Trader getTrader() {
		return trader;
	}

	public int getYear() {
		return year;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append(trader);
		builder.append(", year=");
		builder.append(year);
		builder.append(", value=");
		builder.append(value);
		builder.append("]");
		return builder.toString();
	}
	public int getValue() {
		return value;
	}

}
