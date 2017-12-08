package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

class TimerStoneAuto extends LinearOpMode {
    @SuppressWarnings("FieldCanBeLocal")
    private final double drivePower = 0.75;
    private Robot robot = new Robot();
    private boolean isRedTeam;

    TimerStoneAuto (boolean isRedTeam) {
        this.isRedTeam = isRedTeam;
    }

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        robot.gyro.calibrate();
        waitForStart();
//  Jewel Knocker
        robot.jewelSwivel.setPosition(0.8);
        sleep(1300L);
        robot.jeweler.setPosition(0.1);
        sleep(1500L);
        if (robot.jewelSensor.red() > 10){
            robot.jewelSwivel.setPosition(0.6);
        } else {
            robot.jewelSwivel.setPosition(0.95);
        }
        sleep(300L);
        robot.jeweler.setPosition(0.8);
        sleep(1300L);
        robot.jewelSwivel.setPosition(0.3);
        sleep(1300L);

        robot.leftDrive.setPower(isRedTeam?-drivePower/5:-drivePower);
        robot.rightDrive.setPower(isRedTeam?-drivePower:-drivePower/5);
        sleep((long) (Robot.timeForDistance(1, -drivePower) * 1000));
        robot.leftDrive.setPower(-drivePower);
        robot.rightDrive.setPower(-drivePower);
        sleep((long) (Robot.timeForDistance(3, -drivePower) * 1000));
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
