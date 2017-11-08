package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.REVERSE;
import static java.lang.Thread.sleep;


public class Robot {
    DcMotor leftDrive;
    DcMotor rightDrive;
    DcMotor liftMotor;
    Servo glyphClamp;
    DcMotor armExtend;
    Servo hooker;
    TouchSensor liftLowerLimit;
    GyroSensor gyro;
    DcMotor armLift;

    void init(HardwareMap hardwareMap) {
        leftDrive = hardwareMap.get(DcMotor.class, "leftDrive");
        rightDrive = hardwareMap.get(DcMotor.class, "rightDrive");
        rightDrive.setDirection(REVERSE);
        liftMotor = hardwareMap.get(DcMotor.class, "liftMotor");
        liftMotor.setDirection(REVERSE);
        glyphClamp = hardwareMap.get(Servo.class, "glyphMotor");
        glyphClamp.setPosition(0.5);
        armExtend = hardwareMap.get(DcMotor.class, "armExtend");
        hooker = hardwareMap.get(Servo.class, "hooker");
        hooker.setPosition(0.5);
        hooker.scaleRange(.5,1);
        liftLowerLimit = hardwareMap.get(TouchSensor.class, "liftLowerLimit");
        gyro = hardwareMap.get(GyroSensor.class, "gyro");
        armLift = hardwareMap.get(DcMotor.class, "armLift");
        armLift.setDirection(REVERSE);
    }

    //Distance is in feet, returns time in seconds
    static double timeForDistance(double distance, double power) {
        final double rpm = 152;
        final double wheelDiameter = 4.25; //Inches
        final double wheelCircumference = wheelDiameter * Math.PI; //Inches
        final double rate = wheelCircumference * rpm; //Inches per minute
        final double feetPerSecond = rate / 12 / 60;
        final double secondsPerFoot = 1 / feetPerSecond;
        return secondsPerFoot * distance / Math.abs(power);
    }

    void turnToHeading(double heading) throws InterruptedException {
        final double maxTurnPower = 0.5;
        final double angleForMaxPower = 45;
        leftDrive.setPower(0);
        rightDrive.setPower(0);

        double currentAngle = gyro.getHeading();
        while (heading - currentAngle > 180) {
            heading -= 360;
        }
        while (currentAngle - heading > 180) {
            heading += 360;
        }


        while (Math.abs(heading - currentAngle) > 5) {
            double turnPower = clampMagnitude((heading - currentAngle) * maxTurnPower / angleForMaxPower, maxTurnPower);
            leftDrive.setPower(turnPower);
            rightDrive.setPower(-turnPower);
            sleep(20L);
            currentAngle = gyro.getHeading();
        }
        leftDrive.setPower(0);
        rightDrive.setPower(0);
    }

    private static double clampMagnitude(double value, double maxMagnitude) {
        return Math.max(Math.min(value, maxMagnitude), -maxMagnitude);
    }
}
