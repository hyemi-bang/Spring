package com.ezen.springmvc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
//@Component 
// 어노테이션이 사용되어 이 클래스를 Spring 빈으로 선언, Spring이 해당 클래스의 인스턴스를 관리하도록 지시하는 것 
// 컴포넌트 추가해야 JSP에서 수거해서 생성자를 만들어준다 (?)
public class Cook {
	@Autowired
	Dish dish; //= new Dish();
	@Autowired
	Food food; //= new Food();
	
	private Cook() {} // 접근제어하면서 막아도 동작쓰한다.

	@Override
	public String toString() {
		return String.format("%s/%s", food, dish);
	}

}

// web.xml에 모든것을 등록해놓고 필요할때 찾아 사용한다