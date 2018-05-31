public class SVM {
    private double lambda;
    private double gamma;
    private double c;
    private double sigma;
    private double fitness;

    public SVM(Parameter parameter) {
        this.lambda = parameter.getLambda();
        this.gamma = parameter.getGamma();
        this.c = parameter.getC();
        this.sigma = parameter.getSigma();
    }

    public double getFitness() {
        return this.fitness;
    }


}
