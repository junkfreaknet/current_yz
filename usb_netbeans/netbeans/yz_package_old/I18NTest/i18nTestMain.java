/*
 * Created on 2005/03/07
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author admnori
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
import java.util.Locale;
import java.util.ResourceBundle;

public class i18nTestMain {

	public static void main(String[] args) {
	    String language;
	    String country;
	    Locale locale;
	    if (args.length == 2) {
	      language = args[0];
	      country = args[1];
	    } else {
	      language = "en";
	      country = "US";
	    }
	    // ロケールを生成
	    locale = new Locale(language,country);
	    // 指定されたロケールのリソースバンドルを取得
	    ResourceBundle rb = ResourceBundle.getBundle("MyMessage" , locale);
	    // プロパティ名から値を取得して表示
	    System.out.println(rb.getString("message"));
	}
}
