import java.util.ArrayList;
import java.util.List;

public class Binary extends Proba {

    private final List<StringBuilder> save = new ArrayList<>();
    private double proba = 0;
    private List<Double> probaBranch = new ArrayList<>();

    public double getProba() {
        return proba;
    }

    public List<StringBuilder> getSave() {
        return save;
    }

    protected void launch(double n, double r) {
        for (int i = (int) n; i != 0; --i) {
            probaBranch.add(1.0);
        }

        StringBuilder str = new StringBuilder();
        str.setLength((int)n);
        generateAllBinaryStrings(n, str, 0, r);
    }

    private void generateAllBinaryStrings(double n, StringBuilder str, int i, double r) {
        if (r == 0) {
            while (i < n) {
                str.setCharAt(i, '0');
                i++;
            }
            // Add proba here
            double probaTemp = probaBranch.get(0);
            // System.out.println("probaBranch(0) vaut " + probaBranch.get(0));
            for (int j = 1; j < probaBranch.size(); ++j) {
                probaTemp *= probaBranch.get(j);
                // System.out.println("probaBranch(" + j + ") vaut " + probaBranch.get(j));
            }
            // System.out.println("proba temp = " + probaTemp);
            proba += probaTemp;
        }

        if (i == n) {
            saveTheString(str);
            return;
        }

        str.setCharAt(i, '1');
        // System.out.println("bonne : " + r + " / " + (52 - i));

        // System.out.println("ajoute une probaBranch à la position " + i);
        probaBranch.set(i, r / (52 - i));
        generateAllBinaryStrings(n, str, i + 1, r-1);



        str.setCharAt(i, '0');
        // System.out.println("mauvaise : " + (52 - i - r) + " / " + (52 - i));

        // System.out.println("ajoute une probaBranch à la position " + i);
        probaBranch.set(i, 1 - r / (52 - i));
        generateAllBinaryStrings(n, str, i + 1, r);
    }

    private void saveTheString(StringBuilder str) {
        this.save.add(str);
        // System.out.println(str);
    }
} 