package org.sp.challenges.exception;

//게시판 예외 객체 정의
public class MemberException extends RuntimeException{
	
	public MemberException(String msg) {
		super(msg);
	}
	
	//Throwable은 예외의 최상위 객체임
	public MemberException(String msg, Throwable e) {
		super(msg, e);
	}
}
