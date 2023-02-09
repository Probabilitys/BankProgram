package com.example.bank_window;

import javafx.beans.property.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class AllView3 {
    private Pane root;
    TableView<BankAccount> accts = new TableView<>();

    public AllView3(AllController2 controller) {
        root = createNodeHierarchy(controller);

        TableColumn<BankAccount,Integer> acctnumCol
            = new TableColumn<>("Account Number");

        acctnumCol.setCellValueFactory(p -> {
            BankAccount ba = p.getValue();
            int bal = ba.getAcctNum();
            Property<Integer> result =
                new SimpleObjectProperty<>(bal);
            return result;
        });

        TableColumn<BankAccount,Integer> balanceCol = new TableColumn<>("Balance");
        balanceCol.setCellValueFactory(p -> new SimpleObjectProperty<>(p.getValue().getBalance()));

        TableColumn<BankAccount,String> foreignCol = new TableColumn<>("Owner Status");
        foreignCol.setCellValueFactory(p -> {
            BankAccount ba = p.getValue();
            String owner = ba.isForeign() ? "Foreign" : "Domestic";
            return new SimpleObjectProperty<>(owner);
        });

        accts.getColumns().addAll(acctnumCol, balanceCol, foreignCol);
        accts.setItems(controller.getAccountList());
        accts.setPrefSize(300, 200);
    }

    public Pane root() {
        return root;
    }

    private Pane createNodeHierarchy(AllController2 cont) {
        Button intbtn  = new Button("Add Interest");
        intbtn.setOnAction(e -> cont.interestButton());

        VBox p1 = new VBox(8);
        p1.setAlignment(Pos.TOP_CENTER);
        p1.setPadding(new Insets(10));
        Label title = new Label("Manage All Accounts");
        double size = title.getFont().getSize();
        title.setFont(new Font(size*2));
        title.setTextFill(Color.GREEN);
        p1.getChildren().addAll(title, accts, intbtn);
        return p1;
    }
}