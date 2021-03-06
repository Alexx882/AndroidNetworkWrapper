package at.aau.ase.androidnetworkwrapper;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnServer, btnClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnServer = findViewById(R.id.buttonServer);
        btnServer.setOnClickListener(v -> startServer());
        btnClient = findViewById(R.id.buttonClient);
        btnClient.setOnClickListener(v -> startClient());
    }

    private void startServer() {
        // todo
    }

    private void startClient() {
        // todo
    }

    /**
     * Used as test coverage example.
     */
    public int add(int i, int j) {
        return i + j;
    }
}
