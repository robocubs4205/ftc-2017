package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

final class Glypher {
    private final Servo rightClampServo;
    private final Servo leftClampServo;
    private final DcMotor liftMotor;
    private final TouchSensor lowerLimitSwitch;

    private final double liftPowerScale = 1;

    Glypher (Servo rightClampServo, Servo leftClampServo, DcMotor liftMotor, TouchSensor lowerLimitSwitch) {
        this.rightClampServo = rightClampServo;
        this.leftClampServo = leftClampServo;
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
        double currentRightPosition = rightClampServo.getPosition();
        double currentLeftPosition = leftClampServo.getPosition();
        rightClampServo.setPosition(currentRightPosition + speed * dt);
        leftClampServo.setPosition(currentLeftPosition - speed * dt);
    }

    void close (double speed, double dt) {
        open(-speed, dt);
    }

    void openFully () {
        rightClampServo.setPosition(1);
        leftClampServo.setPosition(-1);
    }

    void closeFully () {
        rightClampServo.setPosition(-1);
        leftClampServo.setPosition(1);
    }
    void stop(){
        liftMotor.setPower(0);
    }
}
