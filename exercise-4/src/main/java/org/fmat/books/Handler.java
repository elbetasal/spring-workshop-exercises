package org.fmat.books;

import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class Handler extends TextWebSocketHandler {

	@Override
	public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {

	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		session.sendMessage(new TextMessage("Respuesta desde el server:" + message.getPayload()    ));
	}

	@Override
	public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {

	}

	@Override
	public boolean supportsPartialMessages() {
		return false;
	}
}
