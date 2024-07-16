import Conversiones.ModeloConversion;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ModeloConversion driver = new ModeloConversion();
        int opcion;
        float cantidad = 0;
        String monedaPrincipal = "";
        String monedaCambio = "";
        int flag = 1;
        while (true){
            System.out.println("Seleccione una Opcion");
            System.out.println("""
                    1.-Dolar(USD) => Peso Mexicano(MXN) \n
                    2.-Peso Mexicano(MXN) => Dolar(USD) \n
                    3.-Dolar(USD) => Real Brasileño(BRL) \n
                    4.-Real Brasileño(BRL) => Dolar(USD) \n
                    5.-Dolar(USD) => Peso Colombiano(COP) \n
                    6.-Peso Colombiano(COP) => Dolar(USD) \n
                    7.-Dolar(USD) => Peso Argentino(ARS) \n
                    8.-Peso Argentino(ARS) => Dolar(USD) \n
                    9.-Dolar(USD) => Peso Chileno(CMF) \n
                    10.-Peso Chileno(CMF) => Dolar(USD) \n
                    """);

            try{
                opcion = teclado.nextInt();
                flag = 1;
                switch (opcion){
                    case 1:
                        monedaPrincipal = "USD";
                        monedaCambio = "MXN";
                        break;
                    case 2:
                        monedaPrincipal = "MXN";
                        monedaCambio = "USD";
                        break;
                    case 3:
                        monedaPrincipal = "USD";
                        monedaCambio = "BRL";
                        break;
                    case 4:
                        monedaPrincipal = "BRL";
                        monedaCambio = "USD";
                        break;
                    case 5:
                        monedaPrincipal = "USD";
                        monedaCambio = "COP";
                        break;
                    case 6:
                        monedaPrincipal = "COP";
                        monedaCambio = "USD";
                        break;
                    case 7:
                        monedaPrincipal = "USD";
                        monedaCambio = "ARS";
                        break;
                    case 8:
                        monedaPrincipal = "ARS";
                        monedaCambio = "USD";
                        break;
                    case 9:
                        monedaPrincipal = "USD";
                        monedaCambio = "CMF";
                        break;
                    case 10:
                        monedaPrincipal = "CMF";
                        monedaCambio = "USD";
                        break;
                    default:
                        System.out.println("Opcion invalida");
                        flag = 0;
                }
                if(flag == 1){
                    System.out.println("Ingresa la cantidad a convertir");
                    cantidad = teclado.nextInt();
                    driver.agregarConversion(monedaPrincipal,monedaCambio,cantidad);
                }
                System.out.println("Desea realizar otra conversion? 1 => Si : 0 => No");
                if(teclado.nextInt() == 0){
                    System.out.println("Historial de Conversiones:");
                    driver.mostrarListaConversiones();
                    break;
                }
            }catch(InputMismatchException e){
                System.out.println("Numero invalido "+e.getMessage());
                break;
            }catch(Exception e){
                System.out.println(e.getMessage());
                break;
            }
        }
    }
}