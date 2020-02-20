package at.aau.ase.androidnetworkwrapperexample.networking;

/**
 * Used for callbacks.
 * Alternative to java.util.function.Consumer<T> which is available from API 24 upwards.
 */
public interface Callback<T> {

    public void callback(T argument);

}
