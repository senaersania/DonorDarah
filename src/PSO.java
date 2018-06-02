import java.util.ArrayList;
import java.util.List;

public class PSO {
    private int jumlahPartikel;
    private int DIMENSI_PARTIKEL = 4;
    private List<Particle> swarm = new ArrayList<>();
    private Particle gBest;
    private int gBestIndex;
    private List<Particle> pBest;
    private double c1 = 2.05;
    private double c2 = 2.05;
    private RandomGenerator _r;

    public PSO(int jumlahPartikel, int maksIterasi) {
        this.jumlahPartikel = jumlahPartikel;
        generasiPartikel();

        int iterasi = 0;
        while (iterasi < maksIterasi) {
            for (int i = 0; i < jumlahPartikel; i++) {
                Particle current = swarm.get(i);
                SVM svm = new SVM(current.getPosition());
                current.setFitness(svm.getFitness());
                if (pBest.get(i).getFitness() < current.getFitness()) {
                    pBest.set(i, current);
                }

                if (gBest.getFitness() < current.getFitness()) {
                    gBest = current;
                }
            }
            iterasi++;
        }
    }

    private void generasiPartikel() {
        RandomGenerator lambda = new RandomGenerator(0.01, 5);
        RandomGenerator gamma = new RandomGenerator(0.0001, 10);
        RandomGenerator c = new RandomGenerator(0.01, 10000);
        RandomGenerator sigma = new RandomGenerator(1, 1000);

        for (int i = 0; i < jumlahPartikel; i++) {
            double[] posisiAwal = new double[DIMENSI_PARTIKEL];
            posisiAwal[0] = lambda.getValue();
            posisiAwal[1] = gamma.getValue();
            posisiAwal[2] = c.getValue();
            posisiAwal[3] = sigma.getValue();

            double[] kecepatanAwal = new double[DIMENSI_PARTIKEL];
            for (int j = 0; j < DIMENSI_PARTIKEL; j++) {
                kecepatanAwal[j] = 0;
            }

            Particle particle = new Particle();
            particle.setVelocity(kecepatanAwal);
            particle.setPosition(posisiAwal);
            swarm.add(particle);
        }

        pBest = swarm;

        gBest = swarm.get(0);
        Particle current;
        for (int i = 0; i < jumlahPartikel; i++) {
            current = swarm.get(i);
            if(current.getFitness() > gBest.getFitness()) {
                gBest = current;
                gBestIndex = i;
            }
        }
    }

    void updateGBest() {
        for (int i = 0; i < pBest.size(); i++) {
            if (pBest.get(i).getFitness() > gBest.getFitness()) {
                gBest = pBest.get(i);
                gBestIndex = i;
            }
        }
    }

    void updateVelocity() {
        double[] newVelocity = new double[DIMENSI_PARTIKEL];
        double[] newPosition = new double[DIMENSI_PARTIKEL];

        _r = new RandomGenerator(0,1);
        double[] gBestPosition = gBest.getPosition();
        for (int i = 0; i < swarm.size(); i++) {
            double[] currentPosition = swarm.get(i).getPosition();
            double[] currentVelocity = swarm.get(i).getVelocity();
            double[] pBestPosition = pBest.get(i).getPosition();
            for (int j = 0; j < DIMENSI_PARTIKEL; j++) {
                double inertia = currentVelocity[j];
                double personalInfluence = (c1*_r.getValue())*(pBestPosition[j] - currentPosition[j]);
                double socialInfluence = (c2*_r.getValue())*(gBestPosition[j] - currentPosition[j]);
                newVelocity[j] = 0.729844 * (inertia + personalInfluence + socialInfluence) ;

                newPosition[j] = currentPosition[j] + currentVelocity[j];
            }
        }
    }

}
