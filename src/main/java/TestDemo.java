import java.util.Random;

public class TestDemo {

	public static void main(String[] args) {
		

	}
	
	public int addPositive(int a, int b) {
		if (a>0 && b>0) {
			return a+b;
		} else {
			throw new IllegalArgumentException(
					"Both parameters must be positive"
					);
		}
	}
	public int randomNumberSquared() {
		int ret = getRandomInt();
		ret *= ret;
		return ret;

	}

	public int getRandomInt() {
		Random rand = new Random();
		return rand.nextInt(10) + 1;
	}

}
