package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Move forward")
public class MoveForwardAuto extends LinearOpMode {
    @SuppressWarnings("FieldCanBeLocal")
    private final double drivePower = 0.75;
    private Robot robot = new Robot();
    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        waitForStart();
        robot.leftDrive.setPower(drivePower);
        robot.rightDrive.setPower(drivePower);
        sleep((long) (Robot.timeForDistance(2, drivePower) * 1000));
    }
}
