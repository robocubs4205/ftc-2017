package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "BlueStoneRight")
public class BlueStoneRightAuto extends LinearOpMode {
    private final AudienceStoneAuto inner = new AudienceStoneAuto(false, this);

    @Override
    public void runOpMode() throws InterruptedException {
        inner.runOpMode();
    }
}
