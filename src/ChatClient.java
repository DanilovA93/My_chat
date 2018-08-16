public class ChatClient {
    public static void main (String[] args) {
        GUI client = new GUI();
        WhoAreYou name = new WhoAreYou();
        name.giveName();
        client.go();
    }
}
