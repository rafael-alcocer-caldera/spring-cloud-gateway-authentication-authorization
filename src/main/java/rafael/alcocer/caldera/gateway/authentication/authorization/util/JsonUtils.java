/**
 * Copyright [20212] [RAFAEL ALCOCER CALDERA]
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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.SetMultimap;

import net.sf.json.JSONObject;

/**
 * Interface Multimap<K,V>

    All Known Subinterfaces:
        ListMultimap<K,V>, SetMultimap<K,V>, SortedSetMultimap<K,V>

    All Known Implementing Classes:
        ArrayListMultimap, ForwardingListMultimap, ForwardingMultimap, 
        ForwardingSetMultimap, ForwardingSortedSetMultimap, HashMultimap, 
        ImmutableListMultimap, ImmutableMultimap, ImmutableSetMultimap, 
        LinkedHashMultimap, LinkedListMultimap, TreeMultimap 
 */
public final class JsonUtils {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    
    /**
     * private static final Builder<String, JsonNode> STRING_TO_JSONNODE_MULTIMAP = new ImmutableListMultimap.Builder<String, JsonNode>();
     * Esta linea hace lo mismo que esta de arriba
     * 
     * Pero si dejo la variable ya construida como se ve aqui, static, se comparte y 
     * sobre la misma variable se crearian otros maps
     * 
     * ##### MultiMap1.entries: [name=["John","RAC"], age=30, cars=["Ford","BMW","Fiat"]]
     * ##### MultiMap2.entries: [name=["John","RAC"], name=["Juan","Pedro"], age=30, age=50, cars=["Ford","BMW","Fiat"], cars2=["Ford","BMW","Fiat"]]
     * 
     * Pero si utilizo los metodos builder() y getMultimapFromJsonNode(Buider, JsonNode), 
     * se crea una instancia para cada MultiMap:
     * 
     * ##### MultiMap1.entries: [name=["John","RAC"], age=30, cars=["Ford","BMW","Fiat"]]
     * ##### MultiMap2.entries: [name=["Juan","Pedro"], age=50, cars2=["Ford","BMW","Fiat"]]
     */
    //private static final Builder<String, JsonNode> STRING_TO_JSONNODE_MULTIMAP = ImmutableListMultimap.builder();

    private JsonUtils() {
    }
    
    /**
     * El siguiente metodo hace lo mismo:
     * 
     * public static <K, V> ImmutableListMultimap.Builder<K, V> builder() {
     *     return new ImmutableListMultimap.Builder<K, V>();
     * }
     * 
     * Regresa un Builder de ImmutableListMultimap.
     * 
     * @param <K>
     * @param <V>
     * @return ImmutableListMultimap.Builder<K, V>
     */
    public static <K, V> ImmutableListMultimap.Builder<K, V> immutableListMultimapBuilder() {
	return ImmutableListMultimap.builder();
    }
    
    /**
     * El siguiente metodo hace lo mismo:
     * 
     * public static <K, V> ImmutableSetMultimap.Builder<K, V> builder() {
     *     return new ImmutableSetMultimap.Builder<K, V>();
     * }
     * 
     * Regresa un Builder de ImmutableSetMultimap.
     * 
     * @param <K>
     * @param <V>
     * @return ImmutableSetMultimap.Builder<K, V>
     */
    public static <K, V> ImmutableSetMultimap.Builder<K, V> immutableSetMultimapBuilder() {
	return ImmutableSetMultimap.builder();
    }
    
    /**
     * 
     * @param jsonObject
     * @return Multimap<String, JsonNode>
     * @throws JsonMappingException
     * @throws JsonProcessingException
     */
    public static ListMultimap<String, JsonNode> getListMultimapFromJsonNode(JSONObject jsonObject) throws JsonMappingException, JsonProcessingException {
	ImmutableListMultimap.Builder<String, JsonNode> builder = immutableListMultimapBuilder();
	
	MAPPER.readTree(jsonObject.toString()).fields().forEachRemaining(entry -> builder.put(entry.getKey(), entry.getValue()));

	return builder.build();
    }
    
    /**
     * 
     * @param jsonObject
     * @return
     * @throws JsonMappingException
     * @throws JsonProcessingException
     */
    public static SetMultimap<String, JsonNode> getSetMultimapFromJsonNode(JSONObject jsonObject) throws JsonMappingException, JsonProcessingException {
	ImmutableSetMultimap.Builder<String, JsonNode> builder = immutableSetMultimapBuilder();
	
	MAPPER.readTree(jsonObject.toString()).fields().forEachRemaining(entry -> builder.put(entry.getKey(), entry.getValue()));

	return builder.build();
    }
    
    /**
     * 
     * @param json
     * @return Multimap<String, JsonNode>
     * @throws JsonMappingException
     * @throws JsonProcessingException
     */
    public static ListMultimap<String, JsonNode> getListMultimapFromJsonNode(String json) throws JsonMappingException, JsonProcessingException {
	ImmutableListMultimap.Builder<String, JsonNode> builder = immutableListMultimapBuilder();
	
	MAPPER.readTree(json).fields().forEachRemaining(entry -> builder.put(entry.getKey(), entry.getValue()));

	return builder.build();
    }
    
    /**
     * 
     * @param json
     * @return
     * @throws JsonMappingException
     * @throws JsonProcessingException
     */
    public static SetMultimap<String, JsonNode> getSetMultimapFromJsonNode(String json) throws JsonMappingException, JsonProcessingException {
	ImmutableSetMultimap.Builder<String, JsonNode> builder = immutableSetMultimapBuilder();
	
	MAPPER.readTree(json).fields().forEachRemaining(entry -> builder.put(entry.getKey(), entry.getValue()));

	return builder.build();
    }
}
