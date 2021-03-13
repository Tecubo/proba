public class Proba {

    public void askTree(Binary bin) {
        System.out.println("How many cards to draw ?");
        double n = Functions.askInt(1, 52);
        double r = askNbCardsWaited(n);
        bin.launch(n, r);
        // System.out.println(bin.getSave());
        System.out.println("La probabilité vaut " + bin.getProba());
    }

    public int askNbCardsWaited(double n) {
        System.out.println("How many cards expected ?");
        int r = Functions.askInt(1, 4);
        if (r > n) {
            System.out.println("Number of cards expected has to be lower than or equal to number of cards to draw");
            return askNbCardsWaited(n);
        }
        return r;
    }
}