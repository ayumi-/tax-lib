package models.calculator;

import java.math.BigDecimal;
import java.util.Date;

import models.rate.TaxItem;
import models.rate.TaxRate;

public enum CalculateConsumptionTax {
	外税 {
		@Override
		public BigDecimal calcConsumptionTax(Date effectiveDate,
				BigDecimal price, TaxItem item, boolean isTaxed) {
			TaxRate rate = findRate(item, effectiveDate);
			BigDecimal number = BigDecimal.valueOf(rate.getRate());
			BigDecimal p = BigDecimal.valueOf(100);
			
			return price.multiply(number).divide(p);
		}
	},
	内税 {
		@Override
		public BigDecimal calcConsumptionTax(Date effectiveDate,
				BigDecimal price, TaxItem item, boolean isTaxed) {
			// TODO スコープ外
			return null;
		}
	},
	非課税 {
		@Override
		public BigDecimal calcConsumptionTax(Date effectiveDate,
				BigDecimal price, TaxItem item, boolean isTaxed) {
			return BigDecimal.ZERO;
		}
	};
	
	public TaxRate findRate(TaxItem item, Date effectiveDate) {
		return TaxRate.getTaxRate(item, effectiveDate);
	}
	
	public abstract BigDecimal calcConsumptionTax(Date effectiveDate, BigDecimal price, TaxItem item, boolean isTaxed);

}
