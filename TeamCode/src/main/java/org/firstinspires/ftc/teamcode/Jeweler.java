package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.Servo;

final class Jeweler {

    private final Servo vertical;
    private final Servo horizontal;
    private final ColorSensor colorSensor;
    private final int ballPresentBrightnessThreshold = 10;
    private final int redColorThreshold = 10;

    Jeweler (Servo vertical, Servo horizontal, ColorSensor colorSensor) {
        this.vertical = vertical;
        this.horizontal = horizontal;
        this.colorSensor = colorSensor;
    }

    void whackJewel (boolean isRedTeam) {
        horizontal.setPosition(0);
        vertical.setPosition(0);
        if (colorSensor.alpha() > ballPresentBrightnessThreshold) {
            //Ball is visible
            if (colorSensor.red() > redColorThreshold) {
                //Red ball
                horizontal.setPosition(isRedTeam?0.2:-0.2);
            }
            else {
            horizontal.setPosition(isRedTeam?-0.2:0.2);
            }
        }
        vertical.setPosition(1);
        horizontal.setPosition(-1);
    }
}
