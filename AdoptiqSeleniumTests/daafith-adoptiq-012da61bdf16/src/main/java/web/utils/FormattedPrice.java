package web.utils;

import web.browsersession.Language;
import web.browsersession.TestConfiguration;

/**
 * 
 * Takes care of converting the price if necessary.
 */
public class FormattedPrice {

	private static final String COMMA = ",";
	private static final String DOT = ".";
	private final String price;
	
	public FormattedPrice(String price) {
		this.price = price;
	}
	
	/**
	 * Takes care of converting the price if necessary.
	 * @return price in the format of the language
	 */
	public String getPrice() {
		if (Language.EN.equals(TestConfiguration.getLanguage())) {
			final String priceWithDots = price.replace(COMMA, DOT);
			final int ind = priceWithDots.lastIndexOf(DOT);
			final String formattedPrice = new StringBuilder(priceWithDots).replace(ind, ind+1, COMMA).toString();
			return formattedPrice;
		}
		return price;
	}
	

}
