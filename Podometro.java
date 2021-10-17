/**
 * La clase modela un sencillo podómetro que registra información
 * acerca de los pasos, distancia, ..... que una persona
 * ha dado en una semana. 
 * 
 * @author    David Orayen
 */
public class Podometro {
    // Constantes
    
    private final char HOMBRE = 'H';
    private final char MUJER = 'M';
    private final double ZANCADA_HOMBRE = 0.45;
    private final double ZANCADA_MUJER = 0.41;
    private final int SABADO = 6;
    private final int DOMINGO = 7;
    
    // Variables
    
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
    
    // Constructor
    
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
    
    // Getters
    
    /**
     * accesor para la marca
     *  
     */
    public String getMarca() {
        return marca;
    }
    
    // Métodos
    
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

        if(queSexo == MUJER){
            longitudZancada = altura * ZANCADA_MUJER;
            longitudZancada = Math.floor(longitudZancada);
        }else if(queSexo == HOMBRE){
            longitudZancada = altura * ZANCADA_HOMBRE;
            longitudZancada = Math.ceil(longitudZancada);
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
        
        int minutosInicio = ( ( (horaInicio/100) * 60) + (horaInicio % 100) );
        int minutosFinal =  ( ( (horaFin/100) * 60) + (horaFin % 100) );
        // int minutosTotales = ( ( (horaInicio/100) * 60) + (horaInicio % 100) ) + ( ( (horaFin/100) * 60) + (horaFin % 100) );
        switch(dia){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5: totalPasosLaborables = totalPasosLaborables + pasos;
                    totalDistanciaSemana += longitudZancada * pasos /100000;
                break;
            case 6: totalPasosSabado = totalPasosSabado + pasos;
                    totalDistanciaFinSemana += longitudZancada * pasos /100000;
                break;
            case 7: totalPasosDomingo = totalPasosDomingo + pasos;
                    totalDistanciaFinSemana += longitudZancada * pasos /100000;
                break;
        }
        if((horaInicio >= 2100 && horaInicio<=2359) && (horaFin >= 2100 && horaFin <=2359)){
            caminatasNoche++;
        }
        tiempo = tiempo + (minutosFinal - minutosInicio); 
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
            longitudZancada / 100  + " mtos \n" );

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
        double distanciaTotal = totalDistanciaSemana + totalDistanciaFinSemana;
        int horas = tiempo / 60;
        int minutos = tiempo % 60;
        System.out.println("Estadísticas \n" + "************************* \n" + 
                            "Distancia recorrida toda la semana: " + 
                            distanciaTotal  + " Km" +
                            "\n" + "Distancia recorrida fin de semana: " 
                            + totalDistanciaFinSemana +" Km"+ "\n\n" + "Nº pasos días laborables: " +
                            totalPasosLaborables + "\n" + "Nº pasos SÁBADO: " + 
                            totalPasosSabado + "\n" + "Nº pasos DOMINGO: " + totalPasosDomingo
                            + "\n\n" + "Nº caminatas realizadas a partir de las 21h: " + 
                            caminatasNoche + "\n\n" + "Tiempo total caminado en la semana: "
                            + horas + "h. y " + minutos + "m.");
         
    }


    /**
     *  Calcula y devuelve un String que representa el nombre del día
     *  en el que se ha caminado más pasos - "SÁBADO"   "DOMINGO" o  "LABORABLES"
     */
    public String diaMayorNumeroPasos() {
        String resultado = "";

        if((totalPasosLaborables >= totalPasosSabado) && (totalPasosLaborables >= totalPasosDomingo)){
            resultado = resultado + "LABORABLES ";
        }
        if((totalPasosSabado >= totalPasosDomingo) && (totalPasosSabado >= totalPasosLaborables)){
            resultado = resultado + "SÁBADO ";
        }
        if((totalPasosDomingo >= totalPasosSabado) && (totalPasosDomingo >= totalPasosLaborables)){
            resultado = resultado + "DOMINGO ";
        }
        
        return resultado;
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
