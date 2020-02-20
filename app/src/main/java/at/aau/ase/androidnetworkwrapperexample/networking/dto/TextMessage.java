package at.aau.ase.androidnetworkwrapperexample.networking.dto;

public class TextMessage extends BaseMessage {

    public TextMessage() {
    }

    public TextMessage(String text) {
        this.text = text;
    }

    public String text;

}
