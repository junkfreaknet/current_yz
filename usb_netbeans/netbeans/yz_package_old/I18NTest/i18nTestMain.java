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
	    // ���P�[���𐶐�
	    locale = new Locale(language,country);
	    // �w�肳�ꂽ���P�[���̃��\�[�X�o���h�����擾
	    ResourceBundle rb = ResourceBundle.getBundle("MyMessage" , locale);
	    // �v���p�e�B������l���擾���ĕ\��
	    System.out.println(rb.getString("message"));
	}
}
