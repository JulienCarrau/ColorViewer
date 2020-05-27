package sample.view;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;
import sample.controller.ColorController;

public class ColorView {
    private TextField textField;
    private ColorController controller;
    private SimpleIntegerProperty linkedProperty;

    public ColorView(TextField t, SimpleIntegerProperty p, ColorController cont) {
        textField = t;
        linkedProperty = p;
        controller = cont;

        // Prevent controller to update model when I change
        t.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                Integer val;
                try {
                    val = Integer.parseInt(t1);
                    if (val > 255) val = 255;
                    if (val < 0) val = 0;
                } catch (Exception e) {
                    val = 0;
                }
                controller.setSimpleProperty(linkedProperty, val);
            }
        });

        // Link the property to this view so it updates automatically
        linkedProperty.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                t.setText(String.valueOf(t1.intValue()));
            }
        });

        // Initialize
        textField.setText(String.valueOf(linkedProperty.intValue()));
    }
}
