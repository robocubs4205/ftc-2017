package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

final class Glypher {
    private final Servo clampServo;
    private final DcMotor liftMotor;
    private final TouchSensor lowerLimitSwitch;

    private final double liftPowerScale = 1;

    Glypher (Servo clampServo, DcMotor liftMotor, TouchSensor lowerLimitSwitch) {
        this.clampServo = clampServo;
        this.liftMotor = liftMotor;
        this.lowerLimitSwitch = lowerLimitSwitch;
    }

    void raise (double speed) {
        liftMotor.setPower(speed * liftPowerScale);
    }

    void lower (double speed) {
        if (!lowerLimitSwitch.isPressed()) {
            liftMotor.setPower(-speed *  liftPowerScale);
        }

        else {
            liftMotor.setPower(0);
        }
    }

    void open (double speed, double dt) {
        double currentPosition = clampServo.getPosition();
        clampServo.setPosition(currentPosition + speed * dt);
    }

    void close (double speed, double dt) {
        double currentPosition = clampServo.getPosition();
        clampServo.setPosition(currentPosition - speed * dt);
    }

    void openFully () {
        clampServo.setPosition(1);
    }

    void closeFully () {
        clampServo.setPosition(-1);
    }
}
