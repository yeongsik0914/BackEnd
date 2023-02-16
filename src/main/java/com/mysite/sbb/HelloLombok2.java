package com.mysite.sbb;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class HelloLombok2 {

	private int seq;
	private String title;
	private String writer;
	private String content;
	//private Date regdate;
	private int cnt;
	
	
	public static void main(String[] args) {
		//객체 생성 후 테스트
		HelloLombok2 lombok = new HelloLombok2();
		String pattern = "2023-02-06";
		//setter 입력
		lombok.setSeq(10);
		lombok.setTitle("제목");
		lombok.setWriter("글쓴이");
		lombok.setContent("내용");
		lombok.setCnt(3);
		//getter 출력
		System.out.println(lombok.getSeq());
		System.out.println(lombok.getTitle());
		System.out.println(lombok.getWriter());
		System.out.println(lombok.getCnt());
		//toString 출력
	}

}
