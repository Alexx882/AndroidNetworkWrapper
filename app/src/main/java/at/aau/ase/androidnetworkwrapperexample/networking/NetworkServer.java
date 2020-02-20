package at.aau.ase.androidnetworkwrapperexample.networking;

import java.io.IOException;

import at.aau.ase.androidnetworkwrapperexample.networking.dto.BaseMessage;

public interface NetworkServer {

    /**
     * Register a class for serialization.
     *
     * @param c
     */
    void registerClass(Class c);

    /**
     * Starts the Server.
     *
     * @throws IOException
     */
    void start() throws IOException;

    /**
     * Registers a callback which gets called if a message is received.
     *
     * @param callback
     */
    void registerCallback(Callback<BaseMessage> callback);

    /**
     * Sends a message to all clients.
     *
     * @param message
     */
    void broadcastMessage(BaseMessage message);

}
