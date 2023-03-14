public class Main {
    public static void main(String[] args) {
        var tokenizer = new Tokenizer("1 + 11");

        while (!tokenizer.isEnd()) {
            System.out.println(tokenizer.getToken());
        }
    }
}