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
package rafael.alcocer.caldera.gateway.authentication.authorization.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class GatewayAuthenticationAuthorizationFilter extends AbstractGatewayFilterFactory<Object> {

    private static final Logger LOGGER = LoggerFactory.getLogger(GatewayAuthenticationAuthorizationFilter.class);
    private static final String AUTHORIZATION = "Authorization";

    @Override
    public GatewayFilter apply(Object obj) {
        // Custom Pre Filter. Suppose we can extract JWT and perform Authentication
        return (exchange, chain) -> {
            LOGGER.info("##### Pre filter");
            return handle(exchange, chain);
        };
    }

    private Mono<Void> handle(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        HttpHeaders httpHeaders = request.getHeaders();

        if (!httpHeaders.containsKey(AUTHORIZATION)) {
            LOGGER.info("##### Header contains no " + AUTHORIZATION);

            response.setStatusCode(HttpStatus.UNAUTHORIZED);

            return response.setComplete();
        }

        // Custom Post Filter.Suppose we can call error response handler based on error
        // code.
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            LOGGER.info("##### Post filter");
        }));
    }
}
