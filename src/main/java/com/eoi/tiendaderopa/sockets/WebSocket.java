package com.eoi.tiendaderopa.sockets;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocket implements WebSocketMessageBrokerConfigurer {
    //portfolio is the HTTP URL for the endpoint to which a WebSocket (or SockJS) client needs to connect for the WebSocket handshake.
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/websockethandshake");
    }


    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        //STOMP messages whose destination header begins with /app are routed to @MessageMapping methods in @Controller classes.
        config.setApplicationDestinationPrefixes("/mensajes");
        //Use the built-in message broker for subscriptions and broadcasting and route messages whose destination header begins with /topic or /queue to the broker.
        config.enableSimpleBroker("/topic", "/queue");

    }

}