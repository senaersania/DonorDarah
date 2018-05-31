public class Particle {
    private double fitness;
    private Velocity velocity;
    private Position position;

    public Particle() {
        super();
    }

    public Particle(double fitness, Velocity velocity, Position position) {
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

    public Velocity getVelocity() {
        return velocity;
    }

    public void setVelocity(Velocity velocity) {
        this.velocity = velocity;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
