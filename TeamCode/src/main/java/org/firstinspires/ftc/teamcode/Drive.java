package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

final class Drive {
    private final DcMotor leftMotor;
    private final DcMotor rightMotor;

    Drive (DcMotor leftMotor, DcMotor rightMotor) {
        this.leftMotor = leftMotor;
        this.rightMotor = rightMotor;
    }

    void fromJoysticks (Gamepad gamepad) {
        leftMotor.setPower(Robot.motorPowerCurve(gamepad.left_stick_y));
        rightMotor.setPower(Robot.motorPowerCurve(gamepad.right_stick_y));
    }
}
