package local.jbenito.credit;

import java.math.BigDecimal;

public class CreditBasic extends CreditImp {
	
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
	public void add(CreditImp augmend) {
		this.credit = this.credit.add(augmend.getCredit());
	}
	@Override
	public void subtract(CreditImp subtrahend) {
		this.credit = this.credit.subtract(subtrahend.getCredit());
	}
	@Override
	public void multiply(CreditImp multiplicand) {
		this.credit = this.credit.multiply(multiplicand.getCredit());
	}
	@Override
	public void normalizeCredit() {
		this.setCredit(CreditImp.NUMBER_FORMAT.format(this.credit));
	}
	@Override
	public boolean isCreditsZero() {
		return this.credit.compareTo(CreditImp.ZERO)<= CreditImp.MINOR? true: false;
	}
	@Override
	public boolean isInRange(CreditImp min, CreditImp max) {
		boolean greaterThanMin = (this.credit.compareTo(min.getCredit()) == CreditImp.MAJOR);
		boolean smallerThanMax = (this.credit.compareTo(max.getCredit())== CreditImp.MINOR);
		boolean equalsMin = (this.credit.compareTo(min.getCredit()) == CreditImp.EQUALS);
		boolean equalsMax = (this.credit.compareTo(max.getCredit()) == CreditImp.EQUALS);
		boolean isInRange = (greaterThanMin && smallerThanMax) || equalsMin || equalsMax;
		return isInRange;
	}
}
