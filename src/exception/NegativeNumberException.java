package exception;

public class NegativeNumberException extends Exception{
	public NegativeNumberException(double n) {
		super("You introduced" + n + " as the weight, this number is negative");
	}
}
