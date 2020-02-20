package at.aau.ase.androidnetworkwrapperexample.networking.kryonet;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import java.io.IOException;

import at.aau.ase.androidnetworkwrapperexample.networking.dto.BaseMessage;
import at.aau.ase.androidnetworkwrapperexample.networking.NetworkClient;

public class NetworkClientKryo implements NetworkClient {
    private Client client;

    public NetworkClientKryo(){
        client = new Client();
    }

    public void registerClass(Class c) {
        client.getKryo().register(c);
    }

    public void connect(String host) throws IOException {
        client.start();
        client.connect(5000, host, NetworkConstants.TCP_PORT, NetworkConstants.UDP_PORT);

        client.addListener(new Listener() {
            public void received(Connection connection, Object object) {
                receivedMessage(connection, object);
            }
        });
    }

    private void receivedMessage(Connection connection, Object object) {
        System.out.println(object);
        //        if (object instanceof SomeResponse) {
//            SomeResponse response = (SomeResponse)object;
//            System.out.println(response.text);
//        }
    }

    public void sendMessage(BaseMessage message) {
        client.sendTCP(message);
    }
}
