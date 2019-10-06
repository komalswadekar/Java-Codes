import java.math.*;

public class ExtraLongFactorials {

	static void extraLongFactorials(int n) {

		BigInteger x = BigInteger.valueOf(n);
		BigInteger factorial = BigInteger.valueOf(1);
		while (x.compareTo(BigInteger.valueOf(1)) != -1) {
			factorial = factorial.multiply(x);
			x = x.subtract(new BigInteger("1"));
		}
		System.out.println(factorial);
	}

	public static void main(String[] args) {
		int n = 25;
		extraLongFactorials(n);
	}
}
