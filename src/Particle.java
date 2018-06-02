public class Particle {
    private double fitness;
    private double[] velocity;
    private double[] position;

    public Particle() {
        super();
    }

    public Particle(double fitness, double[] velocity, double[] position) {
        super();
        this.fitness = fitness;
        this.velocity = velocity;
        this.position = position;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public double[] getVelocity() {
        return velocity;
    }

    public void setVelocity(double[] velocity) {
        this.velocity = velocity;
    }

    public double[] getPosition() {
        return position;
    }

    public void setPosition(double[] position) {
        this.position = position;
    }
}
