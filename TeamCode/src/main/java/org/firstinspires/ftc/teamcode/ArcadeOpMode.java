package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.REVERSE;

/**
 * Created by Developer on 10/17/2017.
 */

@TeleOp(name="TeleOp")
public class ArcadeOpMode extends RoboCubsOpMode {
    final double drivePowerScale = 0.8;
    final double liftPowerScale = 1;
    final double armPowerScale = 1.0;

    @Override
    public void loop() {
        //Positive is forward
        double forwardPower = gamepad1.left_stick_y;
        //Positive is left
        double turnPower = gamepad1.left_stick_x;

        double leftPower = forwardPower - turnPower;
        double rightPower = forwardPower + turnPower;

        leftDrive.setPower(leftPower * drivePowerScale);
        rightDrive.setPower(rightPower * drivePowerScale);

        double liftMotorPower = 0;
        if (gamepad2.b){
            liftMotorPower = 1;
        }
        else if (gamepad2.a && !liftLowerLimit.isPressed()){
            liftMotorPower = -1;

        }
        liftMotor.setPower(liftMotorPower * liftPowerScale);

        double armMotorPower = gamepad2.right_stick_y;
        armMotor.setPower(armMotorPower * armPowerScale);
        //Negative is open
        double glyphClampPosition = glyphClamp.getPosition();
        if (gamepad2.y){
            glyphClampPosition = -1;
        }
        else if (gamepad2.x){
            glyphClampPosition = 1;
        }
        glyphClamp.setPosition(glyphClampPosition);

        //Positive is up
        double hookerPosition = hooker.getPosition();
        if(gamepad2.right_bumper) {
            hookerPosition = 1;
        }
        else if (gamepad2.right_trigger > 0.5) {
            hookerPosition = -1;
        }
        
        hooker.setPosition(hookerPosition);
    }


}
