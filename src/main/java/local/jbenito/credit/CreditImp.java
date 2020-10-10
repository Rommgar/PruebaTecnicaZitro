package local.jbenito.credit;

import java.math.BigDecimal;


public abstract class CreditImp{
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
}
