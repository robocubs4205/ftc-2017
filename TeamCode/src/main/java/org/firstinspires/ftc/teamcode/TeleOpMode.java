package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@SuppressWarnings("FieldCanBeLocal")
@TeleOp(name="TeleOp")
public class TeleOpMode extends OpMode {
    private Robot robot = new Robot();
    double dt = 0;

    @Override
    public void init() {
        robot.init(hardwareMap);
        robot.jewelSensor.enableLed(true);
    }

    @Override
    public void loop() {
        long startTime = System.nanoTime();
        robot.drive.fromJoysticks(gamepad1);

        if (gamepad2.b){
            robot.glypher.raise(1);
        }
        else if (gamepad2.a){
            robot.glypher.lower(1);
        }

        double armExtendPower = gamepad2.right_stick_y;
        robot.arm.extend(armExtendPower);

        if (gamepad2.y){
            robot.glypher.open(1, dt);
        }
        else if (gamepad2.x){
            robot.glypher.close(1, dt);
        }

        if(gamepad2.right_bumper) {
            robot.hooker.open(1, dt);
        }
        else if (gamepad2.right_trigger > 0.5) {
            robot.hooker.close(1, dt);
        }

        robot.arm.raise(gamepad2.left_stick_y);

        dt = ((double) (System.nanoTime() - startTime)) / 1000000000;
    }


}
