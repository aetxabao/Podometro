/**
 * La clase modela un sencillo pod�metro que registra informaci�n
 * acerca de los pasos, distancia, ..... que una persona
 * ha dado en una semana. 
 * 
 * @author    David Orayen
 */
public class Podometro {
    private final char HOMBRE = 'H';
    private final char MUJER = 'M';
    private final double ZANCADA_HOMBRE = 0.45;
    private final double ZANCADA_MUJER = 0.41;
    private final int SABADO = 6;
    private final int DOMINGO = 7;

    private String marca;
    private double altura;
    private char sexo;
    private double longitudZancada;
    private int totalPasosLaborables;
    private int totalPasosSabado;
    private int totalPasosDomingo;
    private double totalDistanciaSemana;
    private double totalDistanciaFinSemana;
    private int tiempo;
    private int caminatasNoche;

    /**
     * Inicializa el pod�metro con la marca indicada por el par�metro.
     * El resto de atributos se ponen a 0 y el sexo, por defecto, es mujer
     */
    public Podometro(String marca) {
        this.marca = marca;
        altura = 0;
        sexo = MUJER;
        longitudZancada = 0;
        totalPasosLaborables = 0;
        totalPasosSabado = 0;
        totalPasosDomingo = 0;
        totalDistanciaSemana = 0;   
        totalDistanciaFinSemana = 0;
        tiempo = 0;
        caminatasNoche = 0;
    }

    /**
     * accesor para la marca
     *  
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Simula la configuraci�n del pod�metro.
     * Recibe como par�metros la altura y el sexo de una persona
     * y asigna estos valores a los atributos correspondiente.
     * Asigna adem�s el valor adecuado al atributo longitudZancada
     * 
     * (leer enunciado)
     *  
     */
    public void configurar(double queAltura, char queSexo) {

        altura = queAltura;
        sexo = queSexo;

        if(queSexo == 'M'){
            longitudZancada = altura * ZANCADA_MUJER;
            Math.floor(longitudZancada);
        }else if(queSexo == 'H'){
            longitudZancada = altura * ZANCADA_HOMBRE;
            Math.ceil(longitudZancada);
        }else{
            System.out.println("Inserte un valor valido");
        }

    }

    /**
     *  Recibe cuatro par�metros que supondremos correctos:
     *    pasos - el n� de pasos caminados
     *    dia - n� de d�a de la semana en que se ha hecho la caminata 
     *              (1 - Lunes, 2 - Martes - .... - 6 - S�bado, 7 - Domingo)
     *    horaInicio � hora de inicio de la caminata
     *    horaFin � hora de fin de la caminata
     *    
     *    A partir de estos par�metros el m�todo debe realizar ciertos c�lculos
     *    y  actualizar� el pod�metro adecuadamente  
     *   
     *   (leer enunciado del ejercicio)
     */
    public void registrarCaminata(int pasos, int dia, int horaInicio,
    int horaFin) {
        String queDia;
        switch(dia){
            case 1: totalPasosLaborables = pasos;
                    totalDistanciaSemana =(longitudZancada * pasos);
                    queDia = "Lunes";
                break;
            case 2: totalPasosLaborables = totalPasosLaborables + pasos;
                    totalDistanciaSemana = (longitudZancada * pasos);
                    queDia = "Martes";
                break;
            case 3: totalPasosLaborables = totalPasosLaborables + pasos;
                    totalDistanciaSemana = (longitudZancada * pasos);
                    queDia = "Miercoles";
                break;
            case 4: totalPasosLaborables = totalPasosLaborables + pasos;
                    totalDistanciaSemana = (longitudZancada * pasos);
                    queDia = "Jueves";
                break;
            case 5: totalPasosLaborables = totalPasosLaborables + pasos;
                    totalDistanciaSemana = (longitudZancada * pasos);
                    queDia = "Viernes";
                break;
            case 6: totalPasosSabado = pasos;
                    totalDistanciaFinSemana = (longitudZancada * pasos);
                    queDia = "Sabado";
                break;
            case 7: totalPasosDomingo = pasos;
                    totalDistanciaFinSemana = (longitudZancada * pasos);
                    queDia = "Domingo";
                break;
        }
        if(horaInicio > 2100){
            caminatasNoche++;
        }
        
        tiempo = (horaFin / 100) - (horaInicio / 100); 
    }

    /**
     * Muestra en pantalla la configuraci�n del pod�metro
     * (altura, sexo y longitud de la zancada)
     * 
     * (ver enunciado)
     *  
     */
    public void printConfiguracion() {

        System.out.println("Configuraci�n del pod�metro\n" + 
            "**************************\n" + "Altura: " + altura / 100 + " mtos \n"
            + "Sexo: " + sexo + "\n" + "Longitud zancada: " + 
            Math.round(longitudZancada)/100.0 + " mtos");

    }

    /**
     * Muestra en pantalla informaci�n acerca de la distancia recorrida,
     * pasos, tiempo total caminado, ....
     * 
     * (leer enunciado)
     *  
     */
    public void printEstad�sticas() {
        int totalPasos = totalPasosLaborables + totalPasosSabado + totalPasosDomingo;
        System.out.println("Estad�sticas \n" + "***************************** \n" + 
                            "Distancia recorrida toda la semana: " + 
                            totalDistanciaSemana /1000 + 
                            "\n" + "Distancia recorrida fin de semana: " 
                            + totalDistanciaFinSemana /1000 + "\n\n" + "N� pasos dias laborables: " +
                            totalPasosLaborables + "\n" + "N� pasos sabado: " + 
                            totalPasosSabado + "\n" + "N� pasos domingo: " + totalPasosDomingo
                            + "\n\n" + "N� caminatas realizadas a partir de las 21h: " + 
                            caminatasNoche + "\n\n" + "Tiempo total caminado en la semana: "
                            + totalPasos + "\n"+ "D�a/s con mas pasos caminados: " + 
                            diaMayorNumeroPasos());
    }


    /**
     *  Calcula y devuelve un String que representa el nombre del d�a
     *  en el que se ha caminado m�s pasos - "S�BADO"   "DOMINGO" o  "LABORABLES"
     */
    public String diaMayorNumeroPasos() {

        return null;

    }

    /**
     * Restablecer los valores iniciales del pod�metro
     * Todos los atributos se ponen a cero salvo el sexo
     * que se establece a MUJER. La marca no var�a
     *  
     */    
    public void reset() {
        altura = 0;
        sexo = MUJER;
        longitudZancada = 0;
        totalPasosLaborables = 0;
        totalPasosSabado = 0;
        totalPasosDomingo = 0;
        totalDistanciaSemana = 0;   
        totalDistanciaFinSemana = 0;
        tiempo = 0;
        caminatasNoche = 0;
    }

}
