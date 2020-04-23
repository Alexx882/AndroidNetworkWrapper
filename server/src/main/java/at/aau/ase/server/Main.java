package at.aau.ase.server;

public class Main {
    public static void main(String[] args) {
        System.out.println("server started");
    }

    /**
     * Smelly implementation of signum.
     * @param i
     * @return
     */
    public int sig(int i) {
        return i > 0 ? 1 : (i < 0) ? -1 : 0;
    }
}
