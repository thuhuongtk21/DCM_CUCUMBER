package test;

import java.util.ArrayList;
import java.util.List;

public class AddToList {

	public static void main(String[] args) {
		String test = "test1; test2; test3; tes, t4";
		String[] myArray = test.split(", ");
		List<String> myList = new ArrayList<>();
		for (String str : myArray) {
		    myList.add(str);
		}
		System.out.println(myList);
		System.out.println(myList.size());

	}

}
