package uiutils.panes;

import static auth.Styles.*;
import static auth.Dimensions.*;

public class TopPane extends Pane {
    public TopPane(double x, double width, double height) {
        super(x, 0, width, height, TOP_PANE_STYLE);
    }
    public TopPane(double x, double width, double height, String ID) {
        super(x, 0, width, height, TOP_PANE_STYLE, ID);
    }
}

