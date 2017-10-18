package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.REVERSE;

/**
 * Created by Developer on 10/17/2017.
 */

@TeleOp(name="ArcadeDrive")
public class ArcadeOpMode extends RoboCubsOpMode {
    @Override
    public void loop() {
        //Positive is forward
        double forwardPower = gamepad1.left_stick_y;
        //Positive is left
        double turnPower = gamepad1.left_stick_x;

        double leftPower = forwardPower - turnPower;
        double rightPower = forwardPower + turnPower;

        leftDrive.setPower(leftPower);
        rightDrive.setPower(rightPower);
    }
}
