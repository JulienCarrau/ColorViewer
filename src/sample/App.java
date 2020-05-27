package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import sample.controller.ColorController;
import sample.model.ColorModel;
import sample.view.ColorPreview;
import sample.view.ColorView;
import sample.view.HexaView;
import sample.view.SliderView;

public class App {
    // Model
    private ColorModel colorModel;

    // Controller
    private ColorController colorController;

    // View elements (sliders)
    @FXML private Slider redSlider, greenSlider, blueSlider;
    private SliderView redSlideView, greenSlideView, blueSlideView;

    // View elements (textFields)
    @FXML private TextField redField, greenField, blueField, colorField;
    private ColorView redTextView, greenTextView, blueTextView;
    private HexaView hexaTextView;

    // View elements (color preview)
    @FXML private Pane colorPreview;
    private ColorPreview colorPreviewPane;

    public void initialize() {
        colorModel = new ColorModel();

        colorController = new ColorController();

        // Create my text views
        redTextView = new ColorView(redField, colorModel.getRedProperty(), colorController);
        greenTextView = new ColorView(greenField, colorModel.getGreenProperty(), colorController);
        blueTextView = new ColorView(blueField, colorModel.getBlueProperty(), colorController);
        hexaTextView = new HexaView(colorField, colorModel.getColor(), colorController);

        // Create my slider views
        redSlideView = new SliderView(redSlider, colorModel.getRedProperty(), colorController);
        greenSlideView = new SliderView(greenSlider, colorModel.getGreenProperty(), colorController);
        blueSlideView = new SliderView(blueSlider, colorModel.getBlueProperty(), colorController);

        // Create my color preview view
        colorPreviewPane = new ColorPreview(colorPreview, colorModel.getColor());
    }
}
