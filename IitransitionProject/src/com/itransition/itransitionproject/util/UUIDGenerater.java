package com.itransition.itransitionproject.util;

import java.util.UUID;

public class UUIDGenerater {

	public static String getUUID(){
		return UUID.randomUUID().toString();
	}
	
	public static String getMessage(String ref){
		return "��� ������������ ���������� �������� �� ������: http://localhost:8080/IitransitionProject/user?ref="+ref;
	}
}
