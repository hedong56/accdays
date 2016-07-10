package com.accdays.basePoints;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
		
		Set<String> set=new HashSet<String>();
		set.add("123");
		set.add("123");
		System.out.println(set.size());// 1
	}

}
