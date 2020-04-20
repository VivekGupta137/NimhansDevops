package com.pe.nimhans.bcrypt;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.io.*;

public class TestBcrypt {
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String str = "test123";
		String encoded = encoder.encode(str);
		System.out.println(str+" ==  "+encoded);
	}	

}
