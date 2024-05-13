import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorServer extends UnicastRemoteObject implements ICalculatorService {

    protected CalculatorServer() throws RemoteException {
        super();
    }

    @Override
    public double calcularAreaCuadrado(double lado) throws RemoteException {
        return lado * lado;
    }

    @Override
    public double calcularAreaCirculo(double radio) throws RemoteException {
        return Math.PI * radio * radio;
    }

    public static void main(String[] args) {
        try {
            // Crear e iniciar el servidor
            CalculatorServer server = new CalculatorServer();
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            java.rmi.Naming.rebind("CalculatorService", server);
            System.out.println("Servidor encendido, utilizando el puerto 1099...");
        } catch (Exception e) {
            System.err.println("Error en el servidor: " + e.toString());
            e.printStackTrace();
        }
    }
}