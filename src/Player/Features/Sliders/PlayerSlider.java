package Player.Features.Sliders;

import Player.Features.Feature;
import javafx.scene.Node;
import javafx.scene.control.Slider;

public abstract class PlayerSlider extends Feature {
    static final double[] DEFAULT_MIN_MAX_CURRENT = {0, 5, 1};

    private Slider mySlider;

    PlayerSlider() {
        double[] minMaxCurrent = getMinMaxCurrentVals();
        if (minMaxCurrent == null || minMaxCurrent.length != 3)
            minMaxCurrent = DEFAULT_MIN_MAX_CURRENT;
        mySlider = new Slider(minMaxCurrent[0], minMaxCurrent[1], minMaxCurrent[2]);
        mySlider.setMinorTickCount(0);
        mySlider.setMajorTickUnit(1.0f);
        mySlider.setSnapToTicks(true);
        mySlider.setShowTickLabels(true);
        mySlider.setShowTickMarks(true);
        mySlider.valueProperty().addListener((ov, old_val, new_val) -> handleItemSelected(new_val));
    }

    abstract protected void handleItemSelected(Number item);

    abstract protected double[] getMinMaxCurrentVals();

    @Override
    public Node getMainComponent() {
        return mySlider;
    }

}
