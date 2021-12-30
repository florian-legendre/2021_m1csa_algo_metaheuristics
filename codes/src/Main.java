import DataStructures.Matrix;
import DataStructures.Vector;
import UBQP.UBQP;

import java.io.File;
import java.util.Random;

public class Main {

    public static void main(String[] argv) {
        File f = new File("../res/partition6.txt");
        Matrix matrix = new Matrix(f, 1);
        Vector X = new Vector(new int[] {1, 1, 0, 1, 0, 0});
        UBQP ubqp = new UBQP(matrix, X);

        System.out.println(" ############## TESTING CUSTOM CLASSES FOR EXERCISE ############## ");
        matrix.print();
        X.print();
        System.out.println("f(X) = " + UBQP.f(matrix.getPrimitiveMatrix(), X.getPrimitiveVector()));
        System.out.println(" ################################################################# \n");


        System.out.println(" ##################### TESTING STEEPEST HILL ##################### ");
        ubqp.solve(8, 0, 0, "noRestarts");
        System.out.println(" ################################################################# \n");


        System.out.println(" ############## TESTING STEEPEST HILL WITH RESTARTS ############## ");
        ubqp.setVec(X.getPrimitiveVector());
        ubqp.solve(8, 3, 0, "withRestarts");
        System.out.println(" ################################################################# \n");


        System.out.println(" ############## TESTING TABU ALGORITHM ############## ");
        ubqp.setVec(X.getPrimitiveVector());
        ubqp.solve(8, 3, 5, "withRestarts");
        System.out.println(" #################################################### \n");
    }

}
