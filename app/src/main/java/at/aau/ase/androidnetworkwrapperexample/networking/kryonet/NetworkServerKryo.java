package at.aau.ase.androidnetworkwrapperexample.networking.kryonet;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

import java.io.IOException;

import at.aau.ase.androidnetworkwrapperexample.networking.dto.BaseMessage;
import at.aau.ase.androidnetworkwrapperexample.networking.NetworkServer;

public class NetworkServerKryo implements NetworkServer {
    private Server server;

    public NetworkServerKryo(){
        server = new Server();
    }

    public void registerClass(Class c) {
        server.getKryo().register(c);
    }

    public void start() throws IOException {
        server.start();
        server.bind(NetworkConstants.TCP_PORT, NetworkConstants.UDP_PORT);

        server.addListener(new Listener() {
            public void received(Connection connection, Object object) {
                receivedMessage(connection, object);
            }
        });
    }

    private void receivedMessage(Connection connection, Object object) {
        System.out.println(object);
//        if (object instanceof BaseMessage) {
//            BaseMessage request = (BaseMessage) object;
//            System.out.println(request.text);
//
//            BaseMessage response = new SomeResponse();
//            response.text = "Thanks";
//
//        }
    }

    public void sendMessage(BaseMessage message) {
//        connection.sendTCP(message);
    }


}
