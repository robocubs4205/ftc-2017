package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@SuppressWarnings("FieldCanBeLocal")
@TeleOp(name="TeleOp")
public class TeleOpMode extends OpMode {
    private Robot robot = new Robot();

    private final double liftPowerScale = 1;
    private final double armExtendPowerScale = 0.6;
    private final double armLiftPowerScale = 1.0;

    @Override
    public void init() {
        robot.init(hardwareMap);
        robot.jewelSensor.enableLed(true);
    }

    @Override
    public void loop() {
        robot.leftDrive.setPower(Robot.motorPowerCurve(gamepad1.left_stick_y));
        robot.rightDrive.setPower(Robot.motorPowerCurve(gamepad1.right_stick_y));

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
            glyphClampPosition += 0.01;
            if (glyphClampPosition > 1.0 )
                glyphClampPosition = 1;
        }
        else if (gamepad2.x){
            glyphClampPosition -= 0.01;
            if (glyphClampPosition < 0 )
                glyphClampPosition = 0;
        }
        robot.glyphClamp.setPosition(glyphClampPosition);

        //Positive is closed
        double hookerPosition = robot.hooker.getPosition();
        if(gamepad2.right_bumper) {
            hookerPosition += 0.01;
            if (hookerPosition > 1.0 )
                hookerPosition = 1;
        }
        else if (gamepad2.right_trigger > 0.5) {
            hookerPosition -= 0.01;
            if (hookerPosition < 0 )
                hookerPosition = 0;
        }
        robot.hooker.setPosition(hookerPosition);

        double armLiftPower = gamepad2.left_stick_y;
        robot.armLift.setPower(armLiftPower * armLiftPowerScale);
    }


}
