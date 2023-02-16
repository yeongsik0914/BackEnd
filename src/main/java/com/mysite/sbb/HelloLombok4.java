package com.mysite.sbb;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
//@NoArgsConstructor
@RequiredArgsConstructor	// 생성자 생성시 필드이름앞에 final 이 들어있는 필드만 아규먼트로 생성
//@AllArgsConstructor
public class HelloLombok4 {

	private final String hello;		//필드 : private
	private int lombok;			//필드
	
	/*
	 	@RequiredArgsConstructor : 필드 이름 앞에 final 키가 할당된 필드만 아규먼트로 등록
	 	public HelloLomBok4(String hello) {
	 		this.hello = hello;
	 	}
	 */
	
	public static void main(String[] args) {
		// @RequiredArgsConstructor 테스트 
		HelloLombok4 lombok4 = new HelloLombok4("안녕");
		
		//toString() 메소드 호출
		System.out.println(lombok4);
	}

}
