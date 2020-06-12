package com.nomedaempresa.cursomc.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class URL {
	
	public static String decodeParam(String s) {
		try {
			return URLDecoder.decode(s, "UTF-8");
		} 
		catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	public static List<Integer> decodeIntList(String s) {
		/*
		String[] vet = s.split(",");
		List<Integer> list = new ArrayList<>();
		for (int i=0; 1<vet.length; i++) {
			list.add(Integer.parseInt(vet[i]));
		}
		return list;
		*/
		// OU a expressao lambda abaixo
		return Arrays.asList(s.split(",")).stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());
		// Arrays.asList converte um vetor para lista
		/*
		 * [0]=1
		 * [1]=3
		 * [2]=4
		 * para 
		 * (1,3,4)
		 */
		
	}
}
