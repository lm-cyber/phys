package library.collision;

class AxisData {
    private double penetration;
    private int referenceFaceIndex;

    /**
     * Default constructor
     */
    AxisData() {
        penetration = -Double.MAX_VALUE;
        referenceFaceIndex = 0;
    }

    /**
     * Sets penetration value.
     *
     * @param value Penetration value of type double.
     */
    public void setPenetration(double value) {
        penetration = value;
    }

    /**
     * Sets the reference face index variable to an int value.
     *
     * @param value Value to set index variable to.
     */
    public void setReferenceFaceIndex(int value) {
        referenceFaceIndex = value;
    }

    /**
     * Gets the penetration value stored.
     *
     * @return double penetration value.
     */
    public double getPenetration() {
        return penetration;
    }

    /**
     * Gets the referenceFaceIndex value stored.
     *
     * @return int referenceFaceIndex value.
     */
    public int getReferenceFaceIndex() {
        return referenceFaceIndex;
    }
}
