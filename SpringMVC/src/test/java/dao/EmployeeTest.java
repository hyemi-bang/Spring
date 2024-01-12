package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class EmployeeTest {
	
	EmployeeDAO dao = new EmployeeDAO();
	
	@Test
	public void test1() {
		//System.out.println("dao1 :" + dao);
		System.out.println(dao.getEmpByDept(30).toString());
		assertEquals(6, dao.getEmpByDept(30).size());
	}

	
	@Test
	public void test2() {
		System.out.println("dao :" + dao.getEmpByDept(99));
		assertNull(dao.getEmpByDept(99));
	}
	

}

