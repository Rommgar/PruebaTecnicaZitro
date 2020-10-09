package local.jbenito.credit;

public interface CreditImp {
	void add(CreditAbs augmend);
	void subtract(CreditAbs subtrahend);
	void multiply(CreditAbs multiplied);
	void normalizeCredit();
	boolean isCreditsZero();
}
