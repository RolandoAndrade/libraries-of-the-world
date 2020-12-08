package application.views;

import mdlaf.animation.MaterialUIMovement;
import mdlaf.components.button.MaterialButtonUI;
import mdlaf.utils.MaterialColors;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;

public class CustomButton extends MaterialButtonUI {

    //The propriety order inside the method installUI is important
    //because some propriety should be override
    @Override
    public void installUI(JComponent c) {
        super.mouseHoverEnabled = false;
        super.installUI(c);
        super.mouseHoverEnabled = true;
        super.colorMouseHoverNormalButton = MaterialColors.BLUE_300;
        super.background = MaterialColors.BLUE_400;
        c.setBackground(super.background);

        if (super.mouseHoverEnabled) {
            c.addMouseListener(
                    MaterialUIMovement.getMovement(c, this.colorMouseHoverNormalButton)
            );
        }
        //If you want use this style also for Default button
        // super.defaultBackground = MaterialColors.PURPLE_700;
        //super.colorMouseHoverDefaultButton = MaterialColors.PURPLE_500;
        super.borderEnabled = false;
    }
}