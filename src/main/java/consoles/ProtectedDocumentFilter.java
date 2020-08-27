package consoles;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class ProtectedDocumentFilter extends DocumentFilter {

    private UserInput userInput;
    private UserOutput userOutput;

    public ProtectedDocumentFilter(UserInput userInput, UserOutput userOutput) {
        this.userInput = userInput;
        this.userOutput = userOutput;
    }

    public UserInput getUserInput() {
        return userInput;
    }

    public UserOutput getUserOutput() {
        return userOutput;
    }

    @Override
    public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr) throws
    BadLocationException {
        if (offset >= getUserInput().getUserInputStart()) {
            super.insertString(fb, offset, string, attr);
        }
    }

    @Override
    public void remove(DocumentFilter.FilterBypass fb, int offset, int length) throws BadLocationException {
        if (offset >= getUserInput().getUserInputStart()) {
            super.remove(fb, offset, length); //To change body of generated methods, choose Tools | Templates.
        }
    }

    @Override
    public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (offset >= getUserInput().getUserInputStart()) {
            super.replace(fb, offset, length, text, attrs); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
