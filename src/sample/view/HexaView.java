package sample.view;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;
import sample.controller.ColorController;

import java.awt.*;

public class HexaView {
    private TextField textField;
    private ColorController controller;
    private SimpleObjectProperty<java.awt.Color> colorProperty;

    public HexaView(TextField t, SimpleObjectProperty<java.awt.Color> c, ColorController cont) {
        textField = t;
        colorProperty = c;
        controller = cont;

        // Prevent controller to update model when I change
        t.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if (t1.length() == 8) updateModel(t1);
            }
        });

        // Link the property to this view so it updates automatically
        colorProperty.addListener(new ChangeListener<java.awt.Color>() {
            @Override
            public void changed(ObservableValue<? extends java.awt.Color> observableValue, java.awt.Color color, java.awt.Color t1) {
                textField.setText(Integer.toHexString(t1.getRGB()));
            }
        });

        // Initialize
        textField.setText(Integer.toHexString(colorProperty.get().getRGB()));
    }

    private void updateModel(String s) {
        try {
            java.awt.Color col = new Color(Integer.valueOf(s.substring(2, 4), 16), Integer.valueOf(s.substring(4, 6), 16), Integer.valueOf(s.substring(6, 8), 16));
            controller.setColorProperty(colorProperty, col);
        } catch (Exception e) {
            updateModel("ff000000");
        }
    }
}
