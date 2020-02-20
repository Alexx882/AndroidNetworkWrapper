package at.aau.ase.androidnetworkwrapper.networking;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

import at.aau.ase.androidnetworkwrapper.networking.dto.TextMessage;
import at.aau.ase.androidnetworkwrapper.networking.kryonet.NetworkClientKryo;
import at.aau.ase.androidnetworkwrapper.networking.kryonet.NetworkServerKryo;

public class NetworkCommunicationIntegrationTest {
    private static final String REQUEST_TEST = "request test";
    private static final String RESPONSE_TEST = "response test";

    AtomicBoolean requestHandled;
    AtomicBoolean responseHandled;

    @Before
    public void setup(){
        requestHandled = new AtomicBoolean(false);
        responseHandled = new AtomicBoolean(false);
    }

    @Test
    public void NetworkConnection_OneClient_SendAndReceiveText() throws IOException, InterruptedException {
        startServer();
        startClient();

        // wait for server and client to handle messages
        Thread.sleep(1000);

        Assert.assertTrue(requestHandled.get());
        Assert.assertTrue(responseHandled.get());
    }

    private void startServer() throws IOException {
        NetworkServer server = new NetworkServerKryo();
        server.registerClass(TextMessage.class);

        server.start();
        server.registerCallback(argument -> {
                    Assert.assertTrue(argument instanceof TextMessage);
                    Assert.assertEquals(REQUEST_TEST, ((TextMessage)argument).text);
                    requestHandled.set(true);

                    server.broadcastMessage(new TextMessage(RESPONSE_TEST));
                }
        );
    }

    private void startClient() throws IOException {
        NetworkClient client = new NetworkClientKryo();
        client.registerClass(TextMessage.class);

        client.connect("localhost");
        client.registerCallback(argument ->
                {
                    Assert.assertTrue(argument instanceof TextMessage);
                    Assert.assertEquals(RESPONSE_TEST, ((TextMessage)argument).text);
                    responseHandled.set(true);
                }
        );

        client.sendMessage(new TextMessage(REQUEST_TEST));
    }
}
