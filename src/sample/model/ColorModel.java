package sample.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class ColorModel implements IColorModel {
    private SimpleIntegerProperty red, green, blue; // Between 0 and 255
    private SimpleObjectProperty<java.awt.Color> color;
    private ChangeListener updateColor;

    public ColorModel() {
        red = new SimpleIntegerProperty(0);
        green = new SimpleIntegerProperty(0);
        blue = new SimpleIntegerProperty(0);
        color = new SimpleObjectProperty<>(new java.awt.Color(red.intValue(), green.intValue(), blue.intValue()));

        // When a component changes, update color
        updateColor = new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                color.setValue(new java.awt.Color(red.intValue(), green.intValue(), blue.intValue()));
            }
        };

        red.addListener(updateColor);
        green.addListener(updateColor);
        blue.addListener(updateColor);

        color.addListener(new ChangeListener<java.awt.Color>() {
            @Override
            public void changed(ObservableValue<? extends java.awt.Color> observableValue, java.awt.Color color, java.awt.Color t1) {
                red.set(t1.getRed());
                green.set(t1.getGreen());
                blue.set(t1.getBlue());
            }
        });
    }

    @Override
    public SimpleIntegerProperty getRedProperty() {
        return red;
    }

    @Override
    public SimpleIntegerProperty getGreenProperty() {
        return green;
    }

    @Override
    public SimpleIntegerProperty getBlueProperty() {
        return blue;
    }

    @Override
    public SimpleObjectProperty<java.awt.Color> getColor() {
        return color;
    }
}
