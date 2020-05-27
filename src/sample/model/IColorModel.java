package sample.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import sample.controller.ColorController;

import java.awt.*;

public interface IColorModel {
    SimpleIntegerProperty getRedProperty();
    SimpleIntegerProperty getGreenProperty();
    SimpleIntegerProperty getBlueProperty();
    SimpleObjectProperty<Color> getColor();
}
