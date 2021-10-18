/**
 * La clase modela un sencillo pod�metro que registra informaci�n
 * acerca de los pasos, distancia, ..... que una persona
 * ha dado en una semana. 
 * 
 * @david reguil�n    - pon aqu� tu nombre - 
 */
public class Podometro {

    // CONSTANTES

    private final char HOMBRE = 'H';
    private final char MUJER = 'M';
    private final double ZANCADA_HOMBRE = 0.45;
    private final double ZANCADA_MUJER = 0.41;
    private final int SABADO = 6;
    private final int DOMINGO = 7;

    // ATRIBUTOS

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
    public Podometro(String queMarca) 
    {
        altura = 0;
        sexo = 'M';
        longitudZancada = 0;
        totalPasosLaborables = 0;
        totalPasosSabado = 0;
        totalPasosDomingo = 0;
        totalDistanciaSemana = 0;
        totalDistanciaFinSemana = 0;
        tiempo = 0;
        caminatasNoche = 0;
        marca = queMarca;
    }

    /**
     * accesor para la marca
     *  
     */
    public String getMarca() 
    {
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
    public void configurar(double queAltura, char queSexo) 
    {
        altura = queAltura;
        sexo = queSexo;
        if(sexo == 'H'){
            longitudZancada = altura * ZANCADA_HOMBRE;
            Math.ceil(longitudZancada);
        }else{
            longitudZancada = altura * ZANCADA_MUJER;
            //Dando por hecho que el usuario va a introducir bien los valores
            Math.floor(longitudZancada);
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
    public void registrarCaminata(int pasos, int dia, int horaInicio,int horaFin) 
    {
        String diaSemana = null;
        int horaFinHoras = horaFin / 100;
        int horaFinPasado = horaFinHoras * 60;
        int horaFinMinutos = horaFin % 100;
        int horaInicioHoras = horaInicio / 100;
        int horaInicioPasado = horaInicioHoras * 60;
        int horaInicioMinutos = horaInicio % 100;
        tiempo = (horaFinPasado + horaFinMinutos) - (horaInicioPasado + horaInicioMinutos);
        switch(dia){
            case 1: 
            totalDistanciaSemana = (pasos * longitudZancada);
            totalPasosLaborables = pasos;
            diaSemana = "Lunes";
            tiempo = (horaFin/100) - (horaInicio/100);
            break;
            case 2: 
            totalDistanciaSemana = totalDistanciaSemana + (pasos * longitudZancada);
            totalPasosLaborables = totalPasosLaborables + pasos;
            diaSemana = "Martes";
            break;
            case 3: 
            totalDistanciaSemana = totalDistanciaSemana + (pasos * longitudZancada);
            totalPasosLaborables = totalPasosLaborables + pasos;
            diaSemana = "Miercoles";
            break;
            case 4: 
            totalDistanciaSemana = totalDistanciaSemana + (pasos * longitudZancada);
            totalPasosLaborables = totalPasosLaborables + pasos;
            diaSemana = "Jueves";
            break;
            case 5: 
            totalDistanciaSemana = totalDistanciaSemana + (pasos * longitudZancada);
            totalPasosLaborables = totalPasosLaborables + pasos;
            diaSemana = "Viernes";
            break;
            case 6: 
            totalDistanciaFinSemana = totalDistanciaFinSemana + (pasos * longitudZancada);
            totalPasosSabado = totalPasosSabado + pasos;
            diaSemana = "Sabado";
            break;
            case 7: 
            totalDistanciaFinSemana = totalDistanciaFinSemana + (pasos * longitudZancada);
            totalPasosDomingo = totalPasosDomingo + pasos;
            diaSemana = "Domingo";
            break;
        }

        if(horaInicio > 2100){
            caminatasNoche++;
        }
    }

    /**
     * Muestra en pantalla la configuraci�n del pod�metro
     * (altura, sexo y longitud de la zancada)
     * 
     * (ver enunciado)
     *  
     */
    public void printConfiguracion() {
        System.out.println("Configuraci�n del pod�metro\n" +"********************\n"+ "Altura: "+ altura/100 + " mtos\n" + "Sexo: " + sexo);
        System.out.println("Longitud zancada: " + String.format("%.2f", longitudZancada/100 ) + " mtos");

    }

    /**
     * Muestra en pantalla informaci�n acerca de la distancia recorrida,
     * pasos, tiempo total caminado, ....
     * 
     * (leer enunciado)
     *  
     */
    public void printEstad�sticas() {

        System.out.println("Estadisticas\n" + "**************************\n" 
            + "Distancia recorrida toda la semana: " + totalDistanciaSemana/1000);
        System.out.println("Distancia recorrida fin de semana: " + totalDistanciaFinSemana/1000);
        System.out.println("");
        System.out.println("N� pasos dias laborables: " + totalPasosLaborables);
        System.out.println("N� pasos dias Sabado: " + totalPasosSabado);
        System.out.println("N� pasos dias Domingo: " + totalPasosDomingo);
        System.out.println("");
        System.out.println("N� caminatas realizadas a partir de las 21h: " + caminatasNoche);
        int totalPasos =  totalPasosLaborables + totalPasosSabado + totalPasosDomingo;
        //si va a un paso por segundo
        //variables del tiempo
        int tiempoCaminado = totalPasos / 60; //Tiempo en minutos
        int tiempoHoras = tiempoCaminado / 60;//Tiempo en horas
        int tiempoMinutos = tiempoCaminado % 60; //Tiempo sobrante de las horas
        System.out.println("Tiempo total caminado en la semana: " + 
        tiempoHoras + "h y " + tiempoMinutos + "m");
    }

    /**
     *  Calcula y devuelve un String que representa el nombre del d�a
     *  en el que se ha caminado m�s pasos - "S�BADO"   "DOMINGO" o  "LABORABLES"
     */
    public String diaMayorNumeroPasos() {

        if(totalPasosLaborables > totalPasosSabado && totalPasosLaborables > totalPasosDomingo)
        {
            return "Laborables";
        }else
        {
            if(totalPasosSabado > totalPasosLaborables && totalPasosSabado > totalPasosDomingo){
                return "Sabado";
            }
            return null;
        }
    }

    /**
     * Restablecer los valores iniciales del pod�metro
     * Todos los atributos se ponen a cero salvo el sexo
     * que se establece a MUJER. La marca no var�a
     *  
     */    
    public void reset() {

        altura = 0;
        sexo = 'M';
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
