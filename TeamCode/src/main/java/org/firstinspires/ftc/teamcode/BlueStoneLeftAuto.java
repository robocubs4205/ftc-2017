package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "BlueStoneLeft")
public class BlueStoneLeftAuto extends LinearOpMode {
    private final TimerStoneAuto inner = new TimerStoneAuto(false, this);

    @Override
    public void runOpMode() throws InterruptedException {
        inner.runOpMode();
    }
}
