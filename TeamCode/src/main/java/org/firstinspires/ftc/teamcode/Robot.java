package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.REVERSE;


public class Robot {
    DcMotor leftDrive;
    DcMotor rightDrive;
    DcMotor liftMotor;
    Servo glyphClamp;
    DcMotor armExtend;
    Servo hooker;
    TouchSensor liftLowerLimit;
    Gyroscope gyro;
    DcMotor armLift;

    void init(HardwareMap hardwareMap) {
        leftDrive = hardwareMap.get(DcMotor.class,"leftDrive");
        rightDrive = hardwareMap.get(DcMotor.class,"rightDrive");
        rightDrive.setDirection(REVERSE);
        liftMotor = hardwareMap.get(DcMotor.class, "liftMotor");
        liftMotor.setDirection(REVERSE);
        glyphClamp = hardwareMap.get(Servo.class, "glyphMotor");
        armExtend = hardwareMap.get(DcMotor.class, "armExtend");
        hooker = hardwareMap.get(Servo.class, "hooker");
        hooker.scaleRange(-0.5,1.0);
        liftLowerLimit = hardwareMap.get(TouchSensor.class, "liftLowerLimit");
        gyro = hardwareMap.get(Gyroscope.class, "gyro");
        armLift = hardwareMap.get(DcMotor.class, "armLift");
        armLift.setDirection(REVERSE);
    }

    //Distance is in feet, returns time in seconds
    double timeForDistance(double distance, double power) {
        final double rpm = 152;
        final double wheelDiameter = 4.25; //Inches
        final double wheelCircumference = wheelDiameter * Math.PI; //Inches
        final double rate = wheelCircumference * rpm; //Inches per minute
        final double feetPerSecond = rate / 12 / 60;
        final double secondsPerFoot = 1 / feetPerSecond;
        return secondsPerFoot * distance / Math.abs(power);
    }
}
