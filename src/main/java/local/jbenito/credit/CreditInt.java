package local.jbenito.credit;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public interface CreditInt {
	public static final Locale US_US = new Locale("en","US");
	public static final DecimalFormat NUMBER_FORMAT = new DecimalFormat("#0.00;-#0.00",
			DecimalFormatSymbols.getInstance(US_US));
	public static final int MINOR = -1;
	public static final int MAJOR = 1;
	public static final int EQUALS = 0;
	public static final BigDecimal ZERO = BigDecimal.ZERO;
	
	void add(CreditInt augmend);
	void subtract(CreditInt subtrahend);
	void multiply(CreditInt multiplied);
	void normalizeCredit();
	boolean isCreditsZero();
	boolean isInRange(CreditInt min, CreditInt max);
	public BigDecimal getCredit();
	public void setCredit(BigDecimal credit);
	public void setCredit(String credit);
}
