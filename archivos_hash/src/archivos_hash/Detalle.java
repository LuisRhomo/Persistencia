package archivos_hash;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;

public class Detalle {

    public static String linea, linea2;
    public static int[] numID = new int[10];
    public static String[][] horarioEmp = new String[5][2];
    public static File archivo, archivo2 = null;
    public static FileReader fr, fr2 = null;
    public static BufferedReader br, br2 = null;
    public static int idHorario = 0;
    public static int claveEmp = 0;

    public static void main(String[] args) {
        procesar_datos();
        obtener_horario();
    }

    public static void procesar_datos() {
        int numIndx = 0;
        try {
            archivo = new File("E:\\Users\\JOSE LUIS\\Desktop\\Hash\\EMPLEADOS.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            // Proceso para ubicar en el arreglo los empleados mediante la función hash
            // módulo, en este caso módulo 10
            while ((linea = br.readLine()) != null) {
                //Obtenemos el valor del índice a partir de la clave del empleado
                System.out.print("Linea " + linea);
                Thread.sleep(1000);
                numIndx = Integer.parseInt(linea.substring(0, 6)) % 10;
                System.out.print(" numIndx " + numIndx);
                //System.out.println(numIndx +"   " +linea.substring(1,6));
                //Se verifica que la posicion del índice en el arreglo se encuentre vacía
                //en cuyo caso se agrega el valor de la clave del empleado a esa posición
                if (numID[numIndx] == 0) {
                    numID[numIndx] = Integer.parseInt(linea.substring(0, 6));
                    System.out.println(" numID " + numID[numIndx]);
                } else {
                    //Si no se encuentra vacía, se barre secuencialmente el arreglo hasta encontrar
                    //la primer posición vacía para agregar en ella el valor de la clave del empleado
                    int exito = 0;
                    for (int i = numIndx + 1; i < numID.length; i++) {
                        if (numID[i] == 0) {
                            numID[i] = Integer.parseInt(linea.substring(0, 6));
                            System.out.println(" numID " + numID[numIndx]);
                            exito++;
                            // Como ya se tuvo éxito, nos salimos de la estructura repetitiva
                            System.out.print(" " + i + "\n");
                            break;
                        }
                    }
                    //Si no hubo alguna posoción vacía en el rango de la búsqueda en el arreglo,
                    //se busca para ubicar la clave del empleado, al inicio del arreglo
                    if (exito == 0) {
                        for (int i = 0; i < numIndx; i++) {
                            if (numID[i] == 0) {
                                numID[i] = Integer.parseInt(linea.substring(0, 6));
                                System.out.println(" numID " + numID[numIndx]);
                                System.out.print(" " + i + "\n");
                                break;
                            }
                        }
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void obtener_horario() {
        //En este paso se muestra còmo quedaron las claves del empleado despuès de la 
        //función Hash
        for (int i = 0; i < numID.length; i++) {
            //System.out.println("Nuevo método   " + numID[i]);
        }
        String estadoRegistro;
        // El primer paso es leer los datos del array o del combo box
        for (int i = 0; i < 10; i++) {
            try {
                archivo = new File("E:\\Users\\JOSE LUIS\\Desktop\\Hash\\Horarios_Empleados.txt");
                fr = new FileReader(archivo);
                br = new BufferedReader(fr);
                // Proceso para ubicar el ID del horario activo para la clave del empleado del array, 
                // esto lo obtendremos del archivo Horarios_Empleados.txt
                while ((linea = br.readLine()) != null) {
                    // Iniciamos leyendo el array con las claves de los empleados
                    // Obtenemos la clave del empleado y el estado del registro
                    claveEmp = Integer.parseInt(linea.substring(1, 7));
                    estadoRegistro = linea.substring(15, 16);
                    System.out.println("Linea : " + linea + " claveEmp " + claveEmp);
                    Thread.sleep(1000);
                    // Si la siguiente condición se cumple, entonces tendremos el id del horario
                    // del empleado en cuestión
                    if (claveEmp == numID[i] && estadoRegistro.trim().equals("A")) {
                        idHorario = Integer.parseInt(linea.substring(0, 1));
                        //fr.close();
                        // Al tener el Id del horario, procedemos a salir del for
                        // obtenemos el detalle del horario del empleado
                        archivo2  = new File("E:\\Users\\JOSE LUIS\\Desktop\\Hash\\Detalle_Horarios.txt");
                        fr2 = new FileReader(archivo2);
                        br2 = new BufferedReader(fr2);
                        //Se procede a leer el archivo que contiene el detalle del horario y
                        //buscar y extraer de él, a partir del Id del Horario, la hora de entrada
                        //y la hora de salida de los 5 días laborales del empleado en proceso
                        while ((linea2 = br2.readLine()) != null) {
                            System.out.println("Linea 2 " + linea2 + " idHorario " + idHorario);
                            Thread.sleep(1000);
                            if (idHorario == Integer.parseInt(linea2.substring(0, 1)) && linea2.substring(10, 11).trim().equals("A")) {
                                //Con la sentencia switch, se ubica la hora de entrada y salida
                                //por dìa de la semana. Se asume que en esta empresa, los empleados
                                //laboran de lunes a viernes exclusivamente
                                switch (Integer.parseInt(linea2.substring(1, 2))) {
                                    case 2:
                                        horarioEmp[0][0] = linea2.substring(2, 6);
                                        horarioEmp[0][1] = linea2.substring(6, 10);
                                        break;
                                    case 3:
                                        horarioEmp[1][0] = linea2.substring(2, 6);
                                        horarioEmp[1][1] = linea2.substring(6, 10);
                                        break;
                                    case 4:
                                        horarioEmp[2][0] = linea2.substring(2, 6);
                                        horarioEmp[2][1] = linea2.substring(6, 10);
                                        break;
                                    case 5:
                                        horarioEmp[3][0] = linea2.substring(2, 6);
                                        horarioEmp[3][1] = linea2.substring(6, 10);
                                        break;
                                    case 6:
                                        horarioEmp[4][0] = linea2.substring(2, 6);
                                        horarioEmp[4][1] = linea2.substring(6, 10);
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }
                        //Se muestra el detalle del horario del empleado en proceso
                        for (int j = 0; j < 5; j++) {
                            for (int k = 0; k < 2; k++) {
                                System.out.println("Detalle del horario  " + horarioEmp[j][k]);
                            }
                        }
                        
                        break;
                    }
                   
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != fr) {
                        fr.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
