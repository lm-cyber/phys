package library.rays;


public class RayAngleInformation {
    private final Ray RAY;
    private final double ANGLE;

    /**
     * Constructor to store ray information.
     *
     * @param ray   Ray of intersection.
     * @param angle Angle the ray is set to.
     */
    public RayAngleInformation(Ray ray, double angle) {
        this.RAY = ray;
        this.ANGLE = angle;
    }

    /**
     * Getter for RAY.
     *
     * @return returns RAY.
     */
    public Ray getRAY() {
        return RAY;
    }

    /**
     * Getter for ANGLE.
     *
     * @return returns ANGLE.
     */
    public double getANGLE() {
        return ANGLE;
    }
}
