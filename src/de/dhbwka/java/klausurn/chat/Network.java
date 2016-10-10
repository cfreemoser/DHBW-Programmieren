package de.dhbwka.java.klausurn.chat;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Network implements NetworkInterface {
    private static Network instance = null;
    private List<ChatSession> chats = new ArrayList<>();

    private Network() {
    }

    public static Network getInstance() {
        if (instance == null) instance = new Network();
        return instance;
    }

    @Override
    public void addChat(ChatSession chat) {
        chats.add(chat);
    }

    @Override
    public void send(String message, String nickname) {
        String msg = nickname + " >> " + message;
        chats.forEach(chatSession -> chatSession.receive(msg));

    }

    @Override
    public void send(String message) {
        String msg = "INFO: " + message;
        chats.forEach(chatSession -> chatSession.receive(msg));
    }


    public List<String> whos() {
        return chats.stream().map(ChatSession::getNickname).collect(Collectors.toList());
    }

    public void remove(ChatSession chatSession) {
        chats.remove(chatSession);
    }
}
