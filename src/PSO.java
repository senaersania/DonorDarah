import java.util.Vector;

public class PSO {
    private int iterasi;
    private int jumlahPartikel;
    private int DIMENSI_PARTIKEL = 4;
    private Vector<Parameter> parameters;
    private Vector<Particle> swarm;
    private Particle gBest;
    private Particle pBest;
    private double c1 = 2.05;
    private double c2 = 2.05;

    public PSO(int jumlahPartikel, int iterasi) {
        parameters = new Vector<>();
        swarm = new Vector<>();
        this.iterasi = iterasi;

        RandomGenerator lambda = new RandomGenerator(0.01, 5);
        RandomGenerator gamma = new RandomGenerator(0.0001, 10);
        RandomGenerator c = new RandomGenerator(0.01, 10000);
        RandomGenerator sigma = new RandomGenerator(1, 1000);

        for (int i = 0; i < jumlahPartikel; i++) {
            Parameter p = new Parameter();
            p.setLambda(lambda.getValue());
            p.setGamma(gamma.getValue());
            p.setC(c.getValue());
            p.setSigma(sigma.getValue());
            parameters.add(p);
        }

        for (int i = 0; i < jumlahPartikel; i++) {
            Particle particle =  new Particle();
            SVM svm = new SVM(parameters.get(i));
            particle.setFitness(svm.getFitness());

            double[] pos = new double[DIMENSI_PARTIKEL];
            double[] vel = new double[DIMENSI_PARTIKEL];
            for (int j = 0; j < DIMENSI_PARTIKEL; j++) {
                vel[j] = 0;
            }

            Velocity v = new Velocity(vel);
            particle.setVelocity(v);
        }


    }

}
