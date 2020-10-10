package local.jbenito.credit;

import java.math.BigDecimal;


public abstract class CreditImp implements CreditInt{
	protected BigDecimal credit;
	
	public CreditImp(String credit) {
		this.credit = new BigDecimal(credit);
	}
	public CreditImp(double credit) {
		this.credit = new BigDecimal(credit);
	}
	public CreditImp(BigDecimal credit) {
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
	public abstract void add(CreditImp augmend);
	@Override
	public abstract void subtract(CreditImp subtrahend);
	@Override
	public abstract void multiply(CreditImp multiplied);
	@Override
	public abstract void normalizeCredit();
	@Override
	public abstract boolean isCreditsZero();
	@Override
	public abstract boolean isInRange(CreditImp min, CreditImp max);
	
}
