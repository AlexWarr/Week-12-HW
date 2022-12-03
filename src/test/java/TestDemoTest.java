import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import java.util.stream.Stream;
import static org.junit.jupiter.params.provider.Arguments.*;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

class TestDemoTest {
	
	private TestDemo testDemo;
	TestDemo mockDemo;
	
	@BeforeEach
	void setUp() throws Exception {
		testDemo  = new TestDemo();
		mockDemo  = spy(testDemo);
	}

	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, Boolean expectExeption) {
		if(!expectExeption) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	static Stream<Arguments> argumentsForAddPositive(){
		Stream<Arguments> stream = Stream.of(
		arguments(2, 4, 6, false),
		arguments(-1, 2, 6, true),
		arguments(2, 0, 6, true),
		arguments(4, 6, 10, false)
		);
		return stream;
	}
	@Test
	void assertThatNumberSquaredIsCorrect(){
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}

}
