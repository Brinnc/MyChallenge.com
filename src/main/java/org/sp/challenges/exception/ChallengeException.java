package org.sp.challenges.exception;

public class ChallengeException extends RuntimeException{
	
	public ChallengeException(String msg) {
		super(msg);
	}
	
	public ChallengeException(String msg, Throwable e) {
		super(msg, e);
	}
}
