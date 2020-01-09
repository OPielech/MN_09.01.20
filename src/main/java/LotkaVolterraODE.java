import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;

public class LotkaVolterraODE implements FirstOrderDifferentialEquations {

    private double[] params;

    public LotkaVolterraODE(double[] params) {
        this.params = params;
    }

    @Override
    public int getDimension() {
        return 2;
    }

    @Override
    public void computeDerivatives(double t, double[] x, double[] dxdt) throws MaxCountExceededException, DimensionMismatchException {
        dxdt[0] = (params[0]-params[1]*x[1])*x[0];//ofiary??
        dxdt[1] = (params[2]*x[0]-params[3])*x[1];//drapieżniki?
    }
}
