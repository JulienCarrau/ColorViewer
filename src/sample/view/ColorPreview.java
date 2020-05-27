package sample.view;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import sample.controller.ColorController;

public class ColorPreview {
    private Pane pane;
    private SimpleObjectProperty<java.awt.Color> color;

    public ColorPreview(Pane p, SimpleObjectProperty<java.awt.Color> c) {
        pane = p;
        color = c;

        // Link the property to this view so it updates automatically
        color.addListener(new ChangeListener<java.awt.Color>() {
            @Override
            public void changed(ObservableValue<? extends java.awt.Color> observableValue, java.awt.Color color, java.awt.Color t1) {
                pane.setBackground(new Background(new BackgroundFill(new Color((double) t1.getRed() / 255, (double) t1.getGreen() / 255, (double) t1.getBlue() / 255, 1), null, null)));
            }
        });

        // Initialize
        pane.setBackground(new Background(new BackgroundFill(new Color((double) color.get().getRed() / 255, (double) color.get().getGreen() / 255, (double) color.get().getBlue() / 255, 1), null, null)));
    }
}
