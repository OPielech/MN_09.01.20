import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;
import org.apache.commons.math3.ode.FirstOrderIntegrator;
import org.apache.commons.math3.ode.nonstiff.EulerIntegrator;

import java.util.ArrayList;

public class TesterLotkaVolterra {
    public static void main(String[] args) {

        double [] params = new double[]{1.5, 1, 1, 3};//kolejne wartości a,b,c,d
        //warunki początkowe, ilosc ofiar a pozniej drapieznikow
        double [] xStart = new double[]{50,10};
        double [] xStop = new double[]{0,0};

        //bo lotkaVOlterra implementuje ten interfejs
        FirstOrderDifferentialEquations lotkaVolterra = new LotkaVolterraODE(params);
        FirstOrderIntegrator eulerInt = new EulerIntegrator(0.01);
        LotkaVolterraPath lotkaVolterraPath = new LotkaVolterraPath();
        eulerInt.addStepHandler(lotkaVolterraPath);
        //zaczynamy w 0, warunki poczatkowe, t koncowe, xStop
        eulerInt.integrate(lotkaVolterra, 0, xStart, 50, xStop);

        ArrayList<Double> time = lotkaVolterraPath.getTime();
        ArrayList<Double> preys = lotkaVolterraPath.getPreys();
        ArrayList<Double> predators = lotkaVolterraPath.getPredators();

        System.out.println("t, preys, predators");

        for (int i=0; i<time.size(); i++)
            System.out.println(time.get(i)+","+preys.get(i)+","+predators.get(i));



    }//end of main
}//end of class
