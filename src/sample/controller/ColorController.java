package sample.controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class ColorController implements IColorController {
    public ColorController() {

    }

    @Override
    public void setSimpleProperty(SimpleIntegerProperty p, int value) {
        p.set(value);
    }

    @Override
    public void setColorProperty(SimpleObjectProperty<java.awt.Color> p, java.awt.Color color) {
        p.setValue(color);
    }
}
