package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.REVERSE;
import static java.lang.Thread.sleep;


public class Robot {
    Arm arm;
    Hooker hooker;
    Glypher glypher;
    Drive drive;

    DcMotor leftDrive;
    DcMotor rightDrive;
    DcMotor liftMotor;
    Servo glyphClamp;
    Servo glyphClamp2;
    private DcMotor armExtend;
    Servo hookerMotor;
    TouchSensor liftLowerLimit;
    GyroSensor gyro;
    private DcMotor armLift;
    ColorSensor jewelSensor;
    Servo jeweler;
    Servo jewelSwivel;

    void init(HardwareMap hardwareMap) {
        leftDrive = hardwareMap.get(DcMotor.class, "leftDrive");
        rightDrive = hardwareMap.get(DcMotor.class, "rightDrive");
        rightDrive.setDirection(REVERSE);
        liftMotor = hardwareMap.get(DcMotor.class, "liftMotor");
        liftMotor.setDirection(REVERSE);
        glyphClamp = hardwareMap.get(Servo.class, "glyphMotor");
        glyphClamp.setPosition(0.5);
        glyphClamp2 = hardwareMap.get(Servo.class, "glyphMotor2");
        glyphClamp2.setPosition(0.5);
        armExtend = hardwareMap.get(DcMotor.class, "armExtend");
        hookerMotor = hardwareMap.get(Servo.class, "hookerMotor");
        hookerMotor.setPosition(0.5);
        hookerMotor.scaleRange(.5,1);
        liftLowerLimit = hardwareMap.get(TouchSensor.class, "liftLowerLimit");
        gyro = hardwareMap.get(GyroSensor.class, "gyro");
        armLift = hardwareMap.get(DcMotor.class, "armLift");
        armLift.setDirection(REVERSE);
        jewelSensor = hardwareMap.get(ColorSensor.class, "jewelSensor");
        jeweler = hardwareMap.get(Servo.class, "jeweler");
        jeweler.setPosition(0.8);
        jewelSwivel = hardwareMap.get(Servo.class, "jewelSwivel");
        jewelSwivel.setPosition(0.2);

        arm = new Arm (armExtend, armLift);
        hooker = new Hooker(hookerMotor);
        glypher = new Glypher(glyphClamp, liftMotor, liftLowerLimit);
        drive = new Drive(leftDrive,rightDrive);
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
        final double maxTurnPower = 1.0;
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

    static double motorPowerCurve(double input) {
        final double power = 2;
        final double max = 0.6;
        return Math.signum(input) * Math.pow(Math.abs(input), power) * max;
    }
}
