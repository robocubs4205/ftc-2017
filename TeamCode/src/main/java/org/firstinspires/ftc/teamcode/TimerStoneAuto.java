package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

class TimerStoneAuto {
    @SuppressWarnings("FieldCanBeLocal")
    private final double drivePower = 0.75;
    private Robot robot = new Robot();
    private boolean isRedTeam;
    private final LinearOpMode outer;

    TimerStoneAuto(boolean isRedTeam, LinearOpMode outer) {
        this.isRedTeam = isRedTeam;
        this.outer = outer;
    }

    public void runOpMode() throws InterruptedException {
        robot.init(outer.hardwareMap);
        robot.gyro.calibrate();
        outer.waitForStart();
//  Jewel Knocker
        robot.jeweler.whackJewel(isRedTeam);

        robot.leftDrive.setPower(isRedTeam?-drivePower/5:-drivePower);
        robot.rightDrive.setPower(isRedTeam?-drivePower:-drivePower/5);
        outer.sleep((long) (Robot.timeForDistance(1, -drivePower) * 1000));
        robot.leftDrive.setPower(-drivePower);
        robot.rightDrive.setPower(-drivePower);
        outer.sleep((long) (Robot.timeForDistance(3, -drivePower) * 1000));
/*
        robot.leftDrive.setPower(0);
        robot.rightDrive.setPower(0);
        robot.glyphClamp.setPosition(0);
        robot.leftDrive.setPower(-drivePower);
        robot.rightDrive.setPower(-drivePower);
        sleep((long) (Robot.timeForDistance(1, drivePower) * 1000));
*/
        robot.leftDrive.setPower(0);
        robot.leftDrive.setPower(0);
    }
}
