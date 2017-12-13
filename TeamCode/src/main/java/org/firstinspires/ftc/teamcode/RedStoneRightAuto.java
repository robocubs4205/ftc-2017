package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "RedStoneRight")
public class RedStoneRightAuto extends LinearOpMode {
    private final TimerStoneAuto inner = new TimerStoneAuto(true, this);

    @Override
    public void runOpMode() throws InterruptedException {
        inner.runOpMode();
    }
}
