package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class Stone1Box1Auto extends LinearOpMode {
    @SuppressWarnings("FieldCanBeLocal")
    private final double drivePower = 0.75;
    private Robot robot = new Robot();
    private boolean blue;

    Stone1Box1Auto(boolean blue) {
        this.blue = blue;
    }

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        robot.gyro.calibrate();
        waitForStart();
        robot.leftDrive.setPower(drivePower);
        robot.rightDrive.setPower(drivePower);
        sleep((long) (Robot.timeForDistance(1, drivePower) * 1000));
        robot.turnToHeading(90);
        robot.leftDrive.setPower(drivePower);
        robot.rightDrive.setPower(drivePower);
        sleep((long) (Robot.timeForDistance(4, drivePower) * 1000));
        robot.leftDrive.setPower(0);
        robot.rightDrive.setPower(0);
    }
}
