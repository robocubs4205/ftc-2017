package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

final class Arm {
    private final DcMotor armExtend;
    private final DcMotor armLift;

    private final double armExtendScale = 0.6;
    private final double armLiftScale = 1.0;

    Arm (DcMotor armExtend, DcMotor armLift) {
        this.armExtend = armExtend;
        this.armLift = armLift;
    }

    void raise (double speed) {
        armLift.setPower(speed * armLiftScale);
    }

    void lower (double speed) {
        armLift.setPower(-speed * armLiftScale);
    }

    void extend (double speed) {
        armExtend.setPower(speed * armExtendScale);
    }

    void retract (double speed) {
        armExtend.setPower(-speed * armExtendScale);
    }

    void stop () {
        armLift.setPower(0);
        armExtend.setPower(0);
    }
}
