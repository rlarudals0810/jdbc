package koreait.jdbc.day4;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@Builder
public class JBuy {
	
	private int buySeq;
	private String customid;
	private String pcode;
	private int quantity;
	private Date buyDate;
	
}