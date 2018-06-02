public class SVM {
    private double lambda;
    private double gamma;
    private double c;
    private double sigma;
    private double fitness;

    public SVM(double[] parameter) {
        this.lambda = parameter[0];
        this.gamma = parameter[1];
        this.c = parameter[2];
        this.sigma = parameter[3];
    }

    public double getFitness() {
        return this.fitness;
    }


}
