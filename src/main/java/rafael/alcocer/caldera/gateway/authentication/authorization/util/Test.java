/**
 * Copyright [2022] [RAFAEL ALCOCER CALDERA]
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package rafael.alcocer.caldera.gateway.authentication.authorization.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Multimap;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

public class Test {

    private static final String JSON1 = "{\"name\":\"John\",\"age\":30,\"cars\":[\"Ford\",\"BMW\",\"Fiat\"],\"name\":\"RAC\"}";
    private static final String JSON2 = "{\"name\":\"Juan\",\"age\":50,\"cars2\":[\"Ford\",\"BMW\",\"Fiat\"],\"name\":\"Pedro\"}";

    public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
	Test test = new Test();
	test.go3();
	System.out.println("################");
	test.go5();
    }

    public void go3() throws JsonMappingException, JsonProcessingException {
	System.out.println(JSON1);
	
	JSONObject jsonObject1 = JSONObject.fromObject(JSON1);
	JSONObject jsonObject2 = JSONObject.fromObject(JSON2);

	System.out.println("net.sf.json.JSONObject1: " + jsonObject1);
	System.out.println("net.sf.json.JSONObject2: " + jsonObject2);

	Multimap<String, JsonNode> multiMap1 = JsonUtils.getListMultimapFromJsonNode(jsonObject1);
	System.out.println("##### MultiMap1.entries: " + multiMap1.entries());

	Multimap<String, JsonNode> multiMap2 = JsonUtils.getListMultimapFromJsonNode(jsonObject2);
	System.out.println("##### MultiMap2.entries: " + multiMap2.entries());

	System.out.println(multiMap1.keys());
	System.out.println(multiMap2.keys());
    }

    public void go4() throws JsonMappingException, JsonProcessingException {
	JSONObject jsonObject1 = JSONObject.fromObject(JSON1);
	JSONObject jsonObject2 = JSONObject.fromObject(JSON2);

	System.out.println("net.sf.json.JSONObject1: " + jsonObject1);
	System.out.println("net.sf.json.JSONObject2: " + jsonObject2);

	Multimap<String, JsonNode> multiMap1 = JsonUtils.getListMultimapFromJsonNode(jsonObject1.toString());
	System.out.println("##### MultiMap1.entries: " + multiMap1.entries());

	Multimap<String, JsonNode> multiMap2 = JsonUtils.getListMultimapFromJsonNode(jsonObject2.toString());
	System.out.println("##### MultiMap2.entries: " + multiMap2.entries());

	System.out.println(multiMap1.keys());
	System.out.println(multiMap2.keys());
    }
    
    public void go5() throws JsonMappingException, JsonProcessingException {
	JsonConfig jsonConfig = new JsonConfig();
	jsonConfig.setExcludes(new String[] { "category", "goodsNo", "categoryId",
			"price1", "stock", "description", "role", "sellTime",
			"sellNum", "score", "age" });
	
	//JSONArray a = JSONArray.fromObject(JSON1, jsonConfig);
	JSONObject jsonObject1 = JSONObject.fromObject(JSON1, jsonConfig);
	
	Multimap<String, JsonNode> multiMap1 = JsonUtils.getListMultimapFromJsonNode(jsonObject1.toString());
	System.out.println("##### MultiMap1.entries: " + multiMap1.entries());
    }
}
