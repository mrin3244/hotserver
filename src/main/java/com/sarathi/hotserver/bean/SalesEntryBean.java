package com.sarathi.hotserver.bean;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SalesEntryBean {
	
	private Map<Integer, Integer> items;
	
	private int rebate;

}
