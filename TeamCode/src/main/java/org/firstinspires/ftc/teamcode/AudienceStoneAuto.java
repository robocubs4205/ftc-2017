package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

class AudienceStoneAuto {

    private final LinearOpMode outer;

    private final double drivePower = 0.75;
    private final boolean isRedTeam;
    private Robot robot = new Robot();

    AudienceStoneAuto(boolean isRedTeam, LinearOpMode outer) {
        this.outer = outer;
        this.isRedTeam = isRedTeam;
    }

    public void runOpMode() throws InterruptedException {
        robot.init(outer.hardwareMap);
        robot.gyro.calibrate();
        outer.waitForStart();
//  Jewel Knocker
        robot.jeweler.whackJewel(isRedTeam);

//      robot.turnToHeading(20);
        robot.leftDrive.setPower(-drivePower);
        robot.rightDrive.setPower(-drivePower);
        outer.sleep((long) (Robot.timeForDistance(2, -drivePower) * 1000));
        robot.turnToHeading(isRedTeam?90:-90);
        robot.leftDrive.setPower(-drivePower);
        robot.rightDrive.setPower(-drivePower);
        outer.sleep((long) (Robot.timeForDistance(2.5, -drivePower) * 1000));
/*
        robot.leftDrive.setPower(drivePower);
        robot.rightDrive.setPower(drivePower);
        sleep((long) (Robot.timeForDistance(2, drivePower) * 1000));
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
