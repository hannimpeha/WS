package consoles;

import javax.swing.text.DocumentFilter;

public class ProtectedDocumentFilter extends DocumentFilter {

    private String userInput;

    public ProtectedDocumentFilter(String userInput) {
        this.userInput = userInput;
    }

    public String getUserInput() {
        return userInput;
    }

}
