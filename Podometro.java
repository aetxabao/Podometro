/**
 * La clase modela un sencillo podómetro que registra información
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
     * Inicializa el podómetro con la marca indicada por el parámetro.
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
     * Simula la configuración del podómetro.
     * Recibe como parámetros la altura y el sexo de una persona
     * y asigna estos valores a los atributos correspondiente.
     * Asigna además el valor adecuado al atributo longitudZancada
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
     *  Recibe cuatro parámetros que supondremos correctos:
     *    pasos - el nº de pasos caminados
     *    dia - nº de día de la semana en que se ha hecho la caminata 
     *              (1 - Lunes, 2 - Martes - .... - 6 - Sábado, 7 - Domingo)
     *    horaInicio – hora de inicio de la caminata
     *    horaFin – hora de fin de la caminata
     *    
     *    A partir de estos parámetros el método debe realizar ciertos cálculos
     *    y  actualizará el podómetro adecuadamente  
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
     * Muestra en pantalla la configuración del podómetro
     * (altura, sexo y longitud de la zancada)
     * 
     * (ver enunciado)
     *  
     */
    public void printConfiguracion() {

        System.out.println("Configuración del podómetro\n" + 
            "**************************\n" + "Altura: " + altura / 100 + " mtos \n"
            + "Sexo: " + sexo + "\n" + "Longitud zancada: " + 
            Math.round(longitudZancada)/100.0 + " mtos");

    }

    /**
     * Muestra en pantalla información acerca de la distancia recorrida,
     * pasos, tiempo total caminado, ....
     * 
     * (leer enunciado)
     *  
     */
    public void printEstadísticas() {
        int totalPasos = totalPasosLaborables + totalPasosSabado + totalPasosDomingo;
        System.out.println("Estadísticas \n" + "***************************** \n" + 
                            "Distancia recorrida toda la semana: " + 
                            totalDistanciaSemana /1000 + 
                            "\n" + "Distancia recorrida fin de semana: " 
                            + totalDistanciaFinSemana /1000 + "\n\n" + "Nº pasos dias laborables: " +
                            totalPasosLaborables + "\n" + "Nº pasos sabado: " + 
                            totalPasosSabado + "\n" + "Nº pasos domingo: " + totalPasosDomingo
                            + "\n\n" + "Nº caminatas realizadas a partir de las 21h: " + 
                            caminatasNoche + "\n\n" + "Tiempo total caminado en la semana: "
                            + totalPasos + "\n"+ "Día/s con mas pasos caminados: " + 
                            diaMayorNumeroPasos());
    }


    /**
     *  Calcula y devuelve un String que representa el nombre del día
     *  en el que se ha caminado más pasos - "SÁBADO"   "DOMINGO" o  "LABORABLES"
     */
    public String diaMayorNumeroPasos() {

        return null;

    }

    /**
     * Restablecer los valores iniciales del podómetro
     * Todos los atributos se ponen a cero salvo el sexo
     * que se establece a MUJER. La marca no varía
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
