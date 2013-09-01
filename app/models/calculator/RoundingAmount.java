package models.calculator;

import java.math.BigDecimal;

public enum RoundingAmount {
	切り捨て {
		public BigDecimal round(BigDecimal d) {
			return d.setScale(0, BigDecimal.ROUND_DOWN);
		}
	},
	切り上げ {
		public BigDecimal round(BigDecimal d) {
			return d.setScale(0, BigDecimal.ROUND_UP);
		}
	},
	四捨五入 {
		public BigDecimal round(BigDecimal d) {
			return d.setScale(0, BigDecimal.ROUND_HALF_UP);
		}
	};
	
	public abstract BigDecimal round(BigDecimal d);
}
