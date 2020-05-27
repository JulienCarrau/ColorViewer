package sample.controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public interface IColorController {
    void setSimpleProperty(SimpleIntegerProperty p, int value);
    void setColorProperty(SimpleObjectProperty<java.awt.Color> p, java.awt.Color color);
}
