package org.sp.challenges.domain;

import lombok.Data;

@Data
public class Challenge {
	private int challenge_idx;
	private Member member;
	private String title;
	private String writer;
	private String regdate;
	private String period;
	private int joins;
	private int hit;
	private String content;
	private String filename;
}
