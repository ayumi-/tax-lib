package models.rate;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.Logger;
import play.db.ebean.Model;

@Entity
public class TaxRate extends Model {
	private static final long serialVersionUID = -4881671193422216573L;
	
	@Id
	public Long id;
	public String type;
	public TaxItem taxItem;
	public Date startedDate;
	public Date endedDate;
	public int rate;
	public String unit;
	
	public TaxRate(TaxRateType type, TaxItem item, Date startedDate, Date endedDate, int rate, Unit unit) {
		this.type = type.name();
		this.taxItem = item;
		this.startedDate = startedDate;
		this.endedDate = endedDate;
		this.rate = rate;
		this.unit = unit.name();
	}
	
	public int getRate() {
		return rate;
	}
	
	public static Finder<Long, TaxRate> find = new Finder<Long, TaxRate>(
			Long.class, TaxRate.class	
		);
	
	public static TaxRate getTaxRate(TaxItem item, Date date) {
		Logger.info(date.toString());
		return find.where()
			.le("startedDate", date).ge("endedDate", date)
			.findList().get(0);
	}
}
