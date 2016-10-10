package de.dhbwka.java.klausurn.chat;

/**
 * Created by cem on 05.10.16.
 */
public class ChatSession extends ChatFrame {
    private String nickname;

    public ChatSession(String nickname) {
        super(nickname);
        this.nickname = nickname;
        Network.getInstance().addChat(this);
    }

    @Override
    protected void onSendMessage(String text) {
        Network.getInstance().send(text, nickname);
    }

    @Override
    protected void onNicknameChanged(String nick) {
        String oldNick = this.nickname;
        this.nickname = nick;
        newTitle(nickname);
        Network.getInstance().send("INFO: %old% HAS CHANGED HIS NICK TO %new%"
                .replace("%old%", oldNick)
                .replace("%new%", nickname));
    }

    @Override
    protected void onWhoClicked() {
        Network.getInstance()
                .whos()
                .stream()
                .map(a -> "#" + a)
                .reduce((acc, c) -> acc + c)
                .map(s -> "INFO: " + s)
                .ifPresent(this::addText);
    }

    @Override
    protected void onLogoffClicked() {
        Network.getInstance().remove(this);
        Network.getInstance().send(nickname + " HAS LOGGED OFF“");
        this.setVisible(false);
        this.dispose();
    }


    public String getNickname() {
        return nickname;
    }


    public void receive(String message) {
        addText(message);
        System.out.println(message);
    }


    @Override
    public void tick() {

    }
}
