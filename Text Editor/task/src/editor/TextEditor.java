package editor;

import javax.swing.*;

public class TextEditor extends JFrame {
    public TextEditor() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        initComponent();
        setVisible(true);
        setLayout(null);
    }

    private void initComponent() {
        setTitle("Text editor");

        JTextArea textArea = new JTextArea();
        textArea.setName("TextArea");

        add(textArea);
    }
}
