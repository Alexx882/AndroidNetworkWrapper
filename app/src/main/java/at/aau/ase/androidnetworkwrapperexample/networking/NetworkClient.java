package at.aau.ase.androidnetworkwrapperexample.networking;

import at.aau.ase.androidnetworkwrapperexample.networking.dto.BaseMessage;

import java.io.IOException;

public interface NetworkClient {

    /**
     * Register a class for serialization.
     * @param c
     */
    void registerClass(Class c);

    /**
     * Connects to a host.
     * @param host
     * @throws IOException
     */
    void connect(String host) throws IOException;

    /**
     * Sends a message.
     */
    void sendMessage(BaseMessage message);

}
