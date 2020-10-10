package local.jbenito.credit;

import java.math.BigDecimal;

public class CreditBasic extends CreditImp implements CreditInt{
	
	public CreditBasic(double credit) {
		super(credit);
	}
	public CreditBasic(BigDecimal credit) {
		super(credit);
	}
	public CreditBasic(String credit) {
		super(credit);
	}
	
	@Override
	public void add(CreditInt augmend) {
		this.credit = this.credit.add(augmend.getCredit());
	}
	@Override
	public void subtract(CreditInt subtrahend) {
		this.credit = this.credit.subtract(subtrahend.getCredit());
	}
	@Override
	public void multiply(CreditInt multiplicand) {
		this.credit = this.credit.multiply(multiplicand.getCredit());
	}
	@Override
	public void normalizeCredit() {
		this.setCredit(CreditInt.NUMBER_FORMAT.format(this.credit));
	}
	@Override
	public boolean isCreditsZero() {
		return this.credit.compareTo(CreditInt.ZERO)<= CreditInt.MINOR? true: false;
	}
	@Override
	public boolean isInRange(CreditInt min, CreditInt max) {
		boolean greaterThanMin = (this.credit.compareTo(min.getCredit()) == CreditInt.MAJOR);
		boolean smallerThanMax = (this.credit.compareTo(max.getCredit())== CreditInt.MINOR);
		boolean equalsMin = (this.credit.compareTo(min.getCredit()) == CreditInt.EQUALS);
		boolean equalsMax = (this.credit.compareTo(max.getCredit()) == CreditInt.EQUALS);
		boolean isInRange = (greaterThanMin && smallerThanMax) || equalsMin || equalsMax;
		return isInRange;
	}
}
