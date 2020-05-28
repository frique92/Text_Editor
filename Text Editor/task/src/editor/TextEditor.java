package editor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextEditor extends JFrame {
    public TextEditor() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);

        setLocationRelativeTo(null);

        initComponent();

        setVisible(true);
        setLayout(null);
    }

    private void initComponent() {
        setTitle("Text editor");

        //Menu
        JMenuBar menuBar = new JMenuBar();

        JMenu menuFile = new JMenu("File");
        menuFile.setName("MenuFile");
        menuFile.setMnemonic(KeyEvent.VK_F);

        JMenuItem menuSave = new JMenuItem("Save");
        menuSave.setName("MenuSave");
        menuFile.add(menuSave);

        JMenuItem menuLoad = new JMenuItem("Load");
        menuLoad.setName("MenuLoad");
        menuFile.add(menuLoad);

        JMenuItem menuExit = new JMenuItem("Exit");
        menuExit.setName("MenuExit");
        menuFile.addSeparator();
        menuFile.add(menuExit);

        menuBar.add(menuFile);
        setJMenuBar(menuBar);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());

        JPanel panelSetting = new JPanel();

        JTextField textFieldFile = new JTextField();
        textFieldFile.setName("FilenameField");
        textFieldFile.setColumns(20);

        JButton buttonSave = new JButton();
        buttonSave.setName("SaveButton");
        buttonSave.setText("Save");
        buttonSave.setPreferredSize(new Dimension(80, 20));

        JButton buttonLoad = new JButton();
        buttonLoad.setName("LoadButton");
        buttonLoad.setText("Load");
        buttonLoad.setPreferredSize(new Dimension(80, 20));

        panelSetting.add(textFieldFile);
        panelSetting.add(buttonSave);
        panelSetting.add(buttonLoad);

        JTextArea textAreaText = new JTextArea(24, 36);
        textAreaText.setName("TextArea");

        JScrollPane jScrollPaneText = new JScrollPane(textAreaText);
        jScrollPaneText.setName("ScrollPane");
        jScrollPaneText.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        mainPanel.add(panelSetting);
        mainPanel.add(jScrollPaneText);

        add(mainPanel, BorderLayout.CENTER);

        buttonSave.addActionListener(e -> saveFile(textFieldFile.getText(), textAreaText.getText()));
        menuSave.addActionListener(e -> saveFile(textFieldFile.getText(), textAreaText.getText()));
        buttonLoad.addActionListener(e -> textAreaText.setText(loadFile(textFieldFile.getText())));
        menuLoad.addActionListener(e -> textAreaText.setText(loadFile(textFieldFile.getText())));
        menuExit.addActionListener(e -> System.exit(0));


    }


    private String loadFile(String pathToFile) {

        try {
            return new String(Files.readAllBytes(Paths.get(pathToFile)));
        } catch(IOException e) {
            System.out.printf("An exception occurs %s", e.getMessage());
            return "";
        }
    }

    private void saveFile(String pathToFile, String text) {

        try (FileWriter writer = new FileWriter(pathToFile)) {
            writer.write(text);
        } catch (IOException e) {
            System.out.printf("An exception occurs %s", e.getMessage());
        }
    }
}
