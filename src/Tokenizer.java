public class Tokenizer {
    String input;

    int cursor = 0;

    public Tokenizer(String input) {
        this.input = input;
    }

    public boolean isEnd() {
        return this.cursor == this.input.length();
    }

    public Token getToken() {
        while (this.cursor < this.input.length()) {
            switch (this.input.charAt(this.cursor)) {
                case ' ' -> this.cursor += 1;

                case '+' -> {
                    this.cursor += 1;

                    return new Token("+");
                }

                case '-' -> {
                    this.cursor += 1;

                    return new Token("-");
                }

                case '/' -> {
                    this.cursor += 1;

                    return new Token("/");
                }

                case '*' -> {
                    this.cursor += 1;

                    return new Token("*");
                }

                default -> {
                    if (!Character.isDigit(this.input.charAt(this.cursor))) {
                        // Invalid token.
                        return null;
                    }

                    var cursorStart = this.cursor;

                    this.cursor += 1;

                    while (this.cursor < this.input.length() && Character.isDigit(this.input.charAt(this.cursor))) {
                        this.cursor += 1;
                    }

                    return new Token(this.input.substring(cursorStart, this.cursor));
                }
            }
        }

        return null;
    }
}
