package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.*;

@TeleOp(name="Teleop")
public class TeleOpOpMode extends RoboCubsOpMode{

    @Override
    public void loop() {
        double leftPower = gamepad1.left_stick_y;
        double rightPower = gamepad1.right_stick_y;

        leftDrive.setPower(leftPower);
        rightDrive.setPower(rightPower);
    }
}
