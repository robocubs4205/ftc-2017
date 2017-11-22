package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Servo;

final class Hooker {
    private final Servo servo;

    Hooker (Servo servo) {
        this.servo = servo;
    }

    void open (double speed, double dt) {
        double currentPosition = servo.getPosition();
        servo.setPosition(currentPosition + speed * dt);
    }

    void close (double speed, double dt) {
        double currentPosition = servo.getPosition();
        servo.setPosition(currentPosition - speed * dt);
    }
}
