package controlLayer;

/**
 * DiscountLevels
 * 
 * @author futz
 * @version 1.0
 */

public enum DiscountLevels {
	
	LEVEL_1(0, 10000, 1),
	LEVEL_2(10001, 50000, 3),
	LEVEL_3(50001, 150000, 5),
	LEVEL_4(150001, 300000, 7),
	LEVEL_5(300001, 1000000, 10);
	
	private final double min;
	private final double max;
	private final int percentage;
	
	private DiscountLevels(double min, double max, int percentage) {
		this.min = min;
		this.max = max;
		this.percentage = percentage;
	}
	
	public double getMin() {
		return min;
	}
	
	public double getMax() {
		return max;
	}
	
	public int getPercentage() {
		return percentage;
	}

}
