package models.calculator;

import java.math.BigDecimal;
import java.util.Date;

import models.rate.TaxItem;

public class ConsumptionTaxCalculator {
	
	private BigDecimal price;
	private Date effectiveDate;
	private TaxItem item;
	private boolean isTaxed;
	private CalculateConsumptionTax calculator;
	private RoundingAmount rounder;
	
	public ConsumptionTaxCalculator(BigDecimal price, Date effectiveDate, TaxItem item, boolean isTaxed, CalculateConsumptionTax calculator, RoundingAmount rounder) {
		this.price = price;
		this.effectiveDate = effectiveDate;
		this.item = item;
		this.isTaxed = isTaxed;
		this.calculator = calculator;
		this.rounder = rounder;
	}

	public BigDecimal getConsumptionTaxAmount() {
		return calculator.calcConsumptionTax(effectiveDate, price, item, isTaxed);
	}
	
	public BigDecimal getConsumptionTaxAmountRounded() {
		return rounder.round(getConsumptionTaxAmount());
	}
}
