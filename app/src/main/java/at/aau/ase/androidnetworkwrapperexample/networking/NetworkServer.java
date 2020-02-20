package at.aau.ase.androidnetworkwrapperexample.networking;

import java.io.IOException;

public interface NetworkServer {

    /**
     * Register a class for serialization.
     * @param c
     */
    void registerClass(Class c);

    /**
     * Starts the Server.
     * @throws IOException
     */
    void start() throws IOException;


}
