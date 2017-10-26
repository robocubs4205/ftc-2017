package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.REVERSE;

@SuppressWarnings("WeakerAccess")
abstract class RoboCubsOpMode extends OpMode {

    RoboCubsOpModeBase base = new RoboCubsOpModeBase();

    protected DcMotor leftDrive;
    protected DcMotor rightDrive;
    protected DcMotor liftMotor;
    protected Servo glyphClamp;
    protected DcMotor armExtend;
    protected Servo hooker;
    protected TouchSensor liftLowerLimit;
    protected Gyroscope gyro;
    protected DcMotor armLift;



    @Override
    public void init() {
        base.init(hardwareMap);
        leftDrive = base.leftDrive;
        rightDrive = base.rightDrive;
        liftMotor = base.liftMotor;
        glyphClamp = base.glyphClamp;
        armExtend = base.armExtend;
        hooker = base.hooker;
        liftLowerLimit = base.liftLowerLimit;
        gyro = base.gyro;
        armLift = base.armLift;
    }
}
