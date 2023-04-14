/*
 * $Id: Test.java,v 1.1 2006/04/15 14:40:06 platform Exp $
 * Created on 2006-4-15
 */
package org.json.simple	;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import javafx.animation.PathTransition;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.Yytoken;
import org.junit.Test;

public class TestJson {

	@Test
	public void testDecode() throws Exception{
		System.out.println("=======decode=======");
		String s="[0,10]";
		Object obj=JSONValue.parse(s);
		JSONArray array=(JSONArray)obj;
		System.out.println("======the 2nd element of array======");
		System.out.println(array.get(1));
		System.out.println();
		assertEquals("10",array.get(1).toString());
	}
	
	@Test
	public void testJSONArrayCollection() {
		final ArrayList<String> testList = new ArrayList<String>();
		testList.add("First item");
		testList.add("Second item");
		final JSONArray jsonArray = new JSONArray(testList);
		
		assertEquals("[\"First item\",\"Second item\"]", jsonArray.toJSONString());
	}

	@Test
	public void testWrongInputException() {
		String s="//mnbvv";
		Object obj=JSONValue.parse(s);
	}

	@Test
	public void testObject() {
		String s="[{\"firstName\":\"Reza\", \"lostName\":\"Shokri\"}, {\"firstName\":\"Ali\", \"lostName\":\"Karimlou\"}]";
		Object obj=JSONValue.parse(s);
		JSONArray array = (JSONArray)obj;
		System.out.println(array.get(0).toString());
		System.out.println(array.get(1).toString());
	}

	@Test
	public void testArrayToJson() {
		int[] nums = {1, 2, 3, 4};
		String s = JSONArray.toJSONString(nums);
		Object obj=JSONValue.parse(s);
		JSONArray array=(JSONArray)obj;
		System.out.println(array.get(1));
		assertEquals("2",array.get(1).toString());
	}

	@Test
	public void testToken() {
		Yytoken token = new Yytoken(Yytoken.TYPE_LEFT_BRACE, null);
		System.out.println(token.toString());
	}
}
