
public class ShippingDate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		yz.logistic.generic.ShippingDate shippingdate=new yz.logistic.generic.ShippingDate("2013/06/08", java.util.Locale.JAPANESE);
		
		System.out.println(shippingdate.getAsFormTitle());
		System.out.println(shippingdate.getWeekday());
		System.out.println(shippingdate.getWeekdayByLocale());
		System.out.println(shippingdate.getWeekdayEnglish());
		System.out.println(shippingdate.getYYYYMMDD());

	}

}
