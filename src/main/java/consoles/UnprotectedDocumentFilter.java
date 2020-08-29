package consoles;

import javax.swing.text.DocumentFilter;

public class UnprotectedDocumentFilter extends DocumentFilter {

    private String userOutput;

    public UnprotectedDocumentFilter(String userOutput) {
        this.userOutput = userOutput;
    }

    public String getUserOutput() {
        return userOutput;
    }
}
