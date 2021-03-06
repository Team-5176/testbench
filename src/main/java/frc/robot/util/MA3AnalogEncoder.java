package frc.robot.util;

import edu.wpi.first.wpilibj.*;

// https://github.com/Team254/FRC-2016-Public/blob/master/src/com/team254/lib/util/MA3AnalogEncoder.java

/**
 * A 10-bit analog MA3 absolute encoder.
 * http://cdn.usdigital.com/assets/datasheets/MA3_datasheet.pdf
 */
public class MA3AnalogEncoder {

    private final AnalogInput mAnalogInput;

    protected Notifier notifier_;
    protected Rotation2d rotation_ = new Rotation2d();
    protected Rotation2d home_ = new Rotation2d();
    protected int num_rotations_ = 0;
    protected double maxv;
    protected double calibrationK;

    private CrashTrackingRunnable read_thread_ = new CrashTrackingRunnable() {
        @Override
        public void runCrashTracked() {
            Rotation2d new_rotation = Rotation2d.fromRadians(2 * Math.PI * mAnalogInput.getVoltage() / maxv);

            // Check for rollover
            synchronized (MA3AnalogEncoder.this) {
                double relative_angle = rotation_.getRadians()
                        + rotation_.inverse().rotateBy(new_rotation).getRadians();
                if (relative_angle > Math.PI) {
                    ++num_rotations_;
                } else if (relative_angle < -Math.PI) {
                    --num_rotations_;
                }
                rotation_ = new_rotation;
            }
        }
    };

    public MA3AnalogEncoder(int port, double maxv, double calibrationK) {
        mAnalogInput = new AnalogInput(port);
        this.maxv = maxv;
        this.calibrationK = calibrationK;
        notifier_ = new Notifier(read_thread_);
        notifier_.startPeriodic(0.01); // 100 Hz
    }

    public synchronized Rotation2d getCalibratedAngle() {
        return home_.rotateBy(rotation_);
    }

    public synchronized void zero() {
        num_rotations_ = 0;
        home_ = rotation_.inverse();
    }

    public synchronized Rotation2d getRawAngle() {
        return rotation_;
    }

    public synchronized double getContinuousAngleDegrees() {
        return getRawAngle().getDegrees() + num_rotations_ * 360.0 + home_.getDegrees();
    }

    public synchronized double get5176Angle() {
        double degrees = getRawAngle().getDegrees();
        // sanity checks
        if (degrees > 180d) degrees = 180d;
        if (degrees < -180d) degrees = -180d;
        double corrected = degrees + 180d + calibrationK;
        if (corrected < 0d) {
            corrected += 360d;
        } else if (corrected > 360d) {
            corrected -= 360d;
        }
        return corrected;
    }

}