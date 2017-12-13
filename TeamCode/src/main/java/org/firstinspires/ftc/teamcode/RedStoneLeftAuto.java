package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "RedStoneLeft")
public class RedStoneLeftAuto extends LinearOpMode {

    AudienceStoneAuto inner = new AudienceStoneAuto(true, this);

    @Override
    public void runOpMode() throws InterruptedException {
        inner.runOpMode();
    }
}
