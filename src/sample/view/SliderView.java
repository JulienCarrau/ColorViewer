package sample.view;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Slider;
import sample.controller.ColorController;

public class SliderView {
    private Slider slider;
    private ColorController controller;
    private SimpleIntegerProperty linkedProperty;

    public SliderView(Slider s, SimpleIntegerProperty p, ColorController cont) {
        slider = s;
        linkedProperty = p;
        controller = cont;

        // Prevent controller to update model when I change
        s.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                Double val = t1.doubleValue() * 255 / 100;
                controller.setSimpleProperty(linkedProperty, val.intValue());
            }
        });

        // Link the property to this view so it updates automatically
        linkedProperty.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                slider.setValue(t1.doubleValue() * 100 / 255);
            }
        });

        // Initialize
        slider.setValue(linkedProperty.doubleValue() * 100 / 255);
    }
}
