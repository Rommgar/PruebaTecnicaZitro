package local.jbenito.credit;

import java.math.BigDecimal;

//import java.math.BigDecimal;

public class Credit extends CreditAbs implements CreditImp{
	
	public Credit() {
	}
	public Credit(double credit) {
		super(credit);
	}
	public Credit(BigDecimal credit) {
		super(credit);
	}
	
	public void add(CreditAbs augmend) {
		this.credit = this.credit.add(augmend.getCredit());
	}

	public void subtract(CreditAbs subtrahend) {
		this.credit = this.credit.subtract(subtrahend.getCredit());
	}

	public void multiply(CreditAbs multiplicand) {
		this.credit = this.credit.multiply(multiplicand.getCredit());
	}

	public void normalizeCredit() {
		this.setCredit(Credit.NUMBER_FORMAT.format(this.credit));
	}

	public boolean isCreditsZero() {
		return this.credit.compareTo(Credit.ZERO)<= Credit.MINOR? true: false;
	}
	public boolean isInRange(Credit min, Credit max) {
		boolean greaterThanMin = (this.credit.compareTo(min.getCredit()) == Credit.MAJOR);
		boolean smallerThanMax = (this.credit.compareTo(max.getCredit())== Credit.MINOR);
		boolean equalsMin = (this.credit.compareTo(min.getCredit()) == Credit.EQUALS);
		boolean equalsMax = (this.credit.compareTo(max.getCredit()) == Credit.EQUALS);
		boolean isInRange = (greaterThanMin && smallerThanMax) || equalsMin || equalsMax;
		return isInRange;
	}
	
}
