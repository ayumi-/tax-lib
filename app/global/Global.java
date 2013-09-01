package global;

import java.text.ParseException;

import models.rate.TaxRate;
import models.rate.TaxRateType;
import models.rate.Unit;
import play.Application;
import play.GlobalSettings;
import utils.DateUtils;

public class Global extends GlobalSettings {
	
	@Override
	public void onStart(Application app) {
		super.onStart(app);
		
		// マスタデータ
		try {
			TaxRate rate1 = new TaxRate(TaxRateType.一般税率, null, DateUtils.parse("2013/01/01"), DateUtils.parse("2013/07/31"), 5, Unit.PERCENT);
			TaxRate rate2 = new TaxRate(TaxRateType.一般税率, null, DateUtils.parse("2013/08/01"), DateUtils.parse("2014/01/01"), 8, Unit.PERCENT);
			
			rate1.save();
			rate2.save();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
