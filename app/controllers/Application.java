package controllers;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

import models.calculator.CalculateConsumptionTax;
import models.calculator.ConsumptionTaxCalculator;
import models.calculator.RoundingAmount;

import org.codehaus.jackson.node.ObjectNode;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.DateUtils;

public class Application extends Controller {
  
    public static Result calc(String itemName, Long price, String targetDate,
    		Boolean isTaxed, String roundingRule, String calculationType) throws ParseException {
    	
    	BigDecimal bigPrice = BigDecimal.valueOf(price.longValue());
    	Date effectiveDate = DateUtils.parse(targetDate);
    	RoundingAmount rounder = RoundingAmount.valueOf(roundingRule);
    	CalculateConsumptionTax calculator = CalculateConsumptionTax.valueOf(calculationType);
    	
    	ConsumptionTaxCalculator calc = new ConsumptionTaxCalculator(bigPrice, effectiveDate, null, isTaxed, calculator, rounder);
    	
    	ObjectNode json = Json.newObject();
    	json.put("consumptionTaxAmount", calc.getConsumptionTaxAmount());
    	json.put("consumptionTaxAmountRounded", calc.getConsumptionTaxAmountRounded());
    	
        return ok(json);
    }
  
}
