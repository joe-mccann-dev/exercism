public class Twofer {
    public String twofer(String name) {
        String recipient = name == null ? "you" : name;
        return String.format("One for %s, one for me.", recipient);
    }
}
