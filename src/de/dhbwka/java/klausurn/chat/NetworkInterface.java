package de.dhbwka.java.klausurn.chat;

/**
 * Created by cem on 05.10.16.
 */
public interface NetworkInterface {

    void addChat(ChatSession chat);

    void send(String message, String nickname);

    void send(String message);


}
