package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.REVERSE;

@SuppressWarnings("WeakerAccess")
abstract class RoboCubsOpMode extends OpMode {
    protected DcMotor leftDrive;
    protected DcMotor rightDrive;
    protected DcMotor liftMotor;
    protected Servo glyphClamp;
    protected DcMotor armMotor;
    protected Servo hooker;
    protected TouchSensor liftLowerLimit;
    protected Gyroscope gyro;



    @Override
    public void init() {
        leftDrive = hardwareMap.get(DcMotor.class,"leftDrive");
        rightDrive = hardwareMap.get(DcMotor.class,"rightDrive");
        rightDrive.setDirection(REVERSE);
        liftMotor = hardwareMap.get(DcMotor.class, "liftMotor");
        liftMotor.setDirection(REVERSE);
        glyphClamp = hardwareMap.get(Servo.class, "glyphMotor");
        armMotor = hardwareMap.get(DcMotor.class, "armMotor");
        hooker = hardwareMap.get(Servo.class, "hooker");
        hooker.scaleRange(-0.5,1.0);
        liftLowerLimit = hardwareMap.get(TouchSensor.class, "liftLowerLimit");
        gyro = hardwareMap.get(Gyroscope.class, "gyro");


    }
}
