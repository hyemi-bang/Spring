package commons;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {

	Calculator calculator = new Calculator(); 
	// 폴더명이 달라고 패키지가 같으면 같은 위치에 있다고 생각하여  import 사용하지 않아도 된다.

	@Test // 테스트라고 어노테이션 붙여줘야한다.
	public void test1() {
		// assertEquals(except, actual) : 내가 기대하는값, 실제 계산값 기대한 값이 나오면 테스트 성공 아니면 실패
		assertEquals(5, calculator.diff(15,10)); 
		
		
	}
	
	@Test //
	public void test2() {
		
		assertEquals(5, calculator.diff(10,15)); 
		
		
	}

}
