package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.REVERSE;

/**
 * Created by Developer on 10/25/2017.
 */

@SuppressWarnings("WeakerAccess")
public class RoboCubsOpModeBase {
    protected DcMotor leftDrive;
    protected DcMotor rightDrive;
    protected DcMotor liftMotor;
    protected Servo glyphClamp;
    protected DcMotor armExtend;
    protected Servo hooker;
    protected TouchSensor liftLowerLimit;
    protected Gyroscope gyro;
    protected DcMotor armLift;

    public void init(HardwareMap hardwareMap) {
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
}
