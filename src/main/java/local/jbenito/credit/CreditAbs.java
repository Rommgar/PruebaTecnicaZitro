package local.jbenito.credit;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public abstract class CreditAbs{
	public static final Locale US_US = new Locale("en","US");
	public static final DecimalFormat NUMBER_FORMAT = new DecimalFormat("#0.00;-#0.00",
			DecimalFormatSymbols.getInstance(US_US));
	public static final int MINOR = -1;
	public static final int MAJOR = 1;
	public static final int EQUALS = 0;
	public static final BigDecimal ZERO = BigDecimal.ZERO;
	protected BigDecimal credit;
	
	public CreditAbs() {
	}
	public CreditAbs(double credit) {
		this.credit = new BigDecimal(credit);
	}
	public CreditAbs(BigDecimal credit) {
		this.credit = credit;
	}

	public BigDecimal getCredit() {
		return credit;
	}

	public void setCredit(BigDecimal credit) {
		this.credit = credit;
	}
	public void setCredit(String credit) {
		this.credit = new BigDecimal(credit);
	}
	
	@Override
	public String toString() {
		return this.credit.toString();
	}
	
}
