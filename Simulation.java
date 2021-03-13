public class Simulation {

    static double simulations() {
        double success = 0;
        double counter = 0;
        for (int i = 100000000; i != 0; --i) {
            if (simulation(52, 10, 2))
                success++;
            counter++;
        }
        return success / counter;
    }

    private static boolean simulation(int nbCardPack, int nbCardToDraw, int nbCardWaited) {
        if (nbCardWaited == 0)
            return true;
        if (nbCardToDraw == 0)
            return false;
        if (Functions.nbRandom(1, nbCardPack) <= nbCardWaited)
            return simulation(nbCardPack - 1, nbCardToDraw - 1, nbCardWaited -1);
        else
            return simulation(nbCardPack -1, nbCardToDraw - 1, nbCardWaited);
    }

    public static void main(String[] args) {
        System.out.println(simulations());
    }
}