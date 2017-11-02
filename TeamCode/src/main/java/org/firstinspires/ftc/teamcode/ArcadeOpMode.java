package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@SuppressWarnings("FieldCanBeLocal")
@TeleOp(name="TeleOp")
public class ArcadeOpMode extends OpMode {
    private Robot robot = new Robot();

    private final double drivePowerScale = 0.8;
    private final double liftPowerScale = 1;
    private final double armExtendPowerScale = 1.0;
    private final double armLiftPowerScale = 1.0;

    @Override
    public void init() {
        robot.init(hardwareMap);
    }

    @Override
    public void loop() {
        //Positive is forward
        double forwardPower = gamepad1.left_stick_y;
        //Positive is left
        double turnPower = gamepad1.left_stick_x;

        double leftPower = forwardPower - turnPower;
        double rightPower = forwardPower + turnPower;

        robot.leftDrive.setPower(leftPower * drivePowerScale);
        robot.rightDrive.setPower(rightPower * drivePowerScale);

        double liftMotorPower = 0;
        if (gamepad2.b){
            liftMotorPower = 1;
        }
        else if (gamepad2.a && !robot.liftLowerLimit.isPressed()){
            liftMotorPower = -1;

        }
        robot.liftMotor.setPower(liftMotorPower * liftPowerScale);

        double armExtendPower = gamepad2.right_stick_y;
        robot.armExtend.setPower(armExtendPower * armExtendPowerScale);
        //Negative is open
        double glyphClampPosition = robot.glyphClamp.getPosition();
        if (gamepad2.y){
            glyphClampPosition = -1;
        }
        else if (gamepad2.x){
            glyphClampPosition = 1;
        }
        robot.glyphClamp.setPosition(glyphClampPosition);

        //Positive is up
        double hookerPosition = robot.hooker.getPosition();
        if(gamepad2.right_bumper) {
            hookerPosition = 1;
        }
        else if (gamepad2.right_trigger > 0.5) {
            hookerPosition = -1;
        }

        robot.hooker.setPosition(hookerPosition);

        double armLiftPower = gamepad2.left_stick_y;
        robot.armLift.setPower(armLiftPower * armLiftPowerScale);
    }


}
