package org.openjfx;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class PrimaryController {

    @FXML
    public ResourceBundle resources;

    @FXML
    public URL location;

    @FXML
    public TextField expenseIntField;

    @FXML
    public TextField expenseStrField;

    @FXML
    public Button expenseButton;

    @FXML
    public TextField incomeIntField;

    @FXML
    public TextField incomeStrField;

    @FXML
    public Button incomeButton;

    @FXML
    private TextArea textArea;


    @FXML
    void addExpense(ActionEvent event) {

        String content = expenseIntField.getText();
        String contentTextArea = textArea.getText();
        String contentDec = expenseStrField.getText();
        textArea.setText(contentTextArea + "\n" + "-" + content + "        " + contentDec);
        fileWriter("text.txt", textArea);

    }

    @FXML
    void addIncome(ActionEvent event) {

        String content = incomeIntField.getText();
        String contentTextArea = textArea.getText();
        String contentDec = incomeStrField.getText();
        textArea.setText(contentTextArea + "\n" + "+" + content + "        " + contentDec);
       fileWriter("text.txt", textArea);

    }

    public void fileWriter(String fileName, TextArea textArea) {
        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter(fileName));
            bf.write(textArea.getText());
            bf.flush();
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public PrimaryController() {
    }

    @FXML
    void initialize() {
        try {
            Scanner s = new Scanner(new File("text.txt")).useDelimiter("\\s+");
            while (s.hasNext()) {
                    textArea.appendText("\n" + s.next() + "        " + s.next());
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        }
    }
}

