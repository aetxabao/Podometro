/**
 * La clase modela un sencillo podómetro que registra información
 * acerca de los pasos, distancia, ..... que una persona
 * ha dado en una semana. 
 * 
 * @author    - Andrei Valentin Grozavu - 
 */
public class Podometro {
    
    private final char hombre = 'H';
    private final char mujer = 'M';
    private final double zancadaH = 0.45;
    private final double zancadaM = 0.41;
    private final int sabado = 6;
    private final int domingo = 7;
    private String marca;
    private double altura;
    private char sexo;
    private double longitudZancada;
    private int totalPasosLaborales;
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
    public Podometro(String queMarca)
    {

        marca = queMarca;
        altura = 0;
        sexo = 'M';
        longitudZancada = 0;
        totalPasosLaborales = 0;
        totalPasosSabado = 0;
        totalPasosDomingo = 0;
        totalDistanciaSemana = 0;
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
        if (sexo == hombre){
            longitudZancada = Math.ceil (zancadaH * altura);
        }
        else if (sexo == mujer);{
            longitudZancada = Math.floor (zancadaM * altura);
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
    public void registrarCaminata(int pasos, int dia, int horaInicio, int horaFin) {

    {
        switch (dia){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                totalPasosLaborales += pasos;
                break;
            case 6: sabado:
                totalPasosSabado += pasos;
                break;
            case 7: domingo:
                totalPasosDomingo += pasos;
                break;

        }
        totalDistanciaSemana = totalPasosLaborales * longitudZancada / 100 / 1000;
        totalDistanciaFinSemana = (totalPasosSabado + totalPasosDomingo) * longitudZancada / 100 / 1000;
        
        int horasInicio = horaInicio / 100;
        int horasFin = horaFin / 100;
        int minsInicio = horaInicio % 100;
        int minsFin = horaFin % 100;
        int tiempoHoras = tiempo / 100;
        int tiempoMins = tiempo % 100;
        
        int minutosRecorrido = minsFin - minsInicio;
        int horasRecorrido = horasFin - horasInicio / 60;
        
        if(horaInicio >= 2100)
        {
            caminatasNoche ++;
        }
    }

    }
    
     /**
     * Muestra en pantalla la configuración del podómetro
     * (altura, sexo y longitud de la zancada)
     * 
     * (ver enunciado)
     *  
     */
    public void printConfiguracion() {

        System.out.println ("Configuración del podómetro");
        System.out.println ("********************************");
        System.out.println ("Altura: " + altura/100 + " mtos");
        System.out.println ("Sexo: " + sexo);
        System.out.println ("Longitud zancada: " + longitudZancada/100 + " mtos");

    }

    /**
     * Muestra en pantalla información acerca de la distancia recorrida,
     * pasos, tiempo total caminado, ....
     * 
     * (leer enunciado)
     *  
     */
    public void printEstadísticas() {
        
        System.out.println ("Estadisticas");
        System.out.println ("***********************************");
        System.out.println ("Distancia recorrida toda la semana:" + totalDistanciaSemana + " Km");
        System.out.println ("Distancia recorrida fin de semana:" + totalDistanciaFinSemana + "Km");
        
        System.out.println ("Nº pasos dias laborales:" +  totalPasosLaborales);
        System.out.println ("Nº pasos Sabado:" + totalPasosSabado);
        System.out.println ("Nº pasos Domingo:" + totalPasosDomingo);
        
        System.out.println ("Nº caminatas realizadas a partir de las 21h:" + caminatasNoche);
        
        System.out.println ("Tiempo total caminado en la semana: " + tiempo + "minutos");
        System.out.println ("Dia/s con más pasos caminados:"+diaMayorNumeroPasos());
        
        
                

    }

   

    /**
     *  Calcula y devuelve un String que representa el nombre del día
     *  en el que se ha caminado más pasos - "SÁBADO"   "DOMINGO" o  "LABORABLES"
     */
    public String diaMayorNumeroPasos() 
    {
        if (totalPasosLaborales > totalPasosSabado && totalPasosLaborales > totalPasosDomingo){
            return "Laborales";
        }else if (totalPasosSabado > totalPasosLaborales && totalPasosSabado > totalPasosDomingo){
            return "Sabado";
        }else if (totalPasosDomingo > totalPasosLaborales && totalPasosDomingo > totalPasosSabado){
            return "Domingo";
        }else if (totalPasosDomingo == totalPasosLaborales && totalPasosDomingo == totalPasosSabado){
            return "Laborales" + "Sabado" + "Domingo";
        }else if (totalPasosLaborales == totalPasosSabado){
            return "Laborales" + "Sabado";
        }else if (totalPasosLaborales == totalPasosDomingo){
            return "Laborales" + "Domingo";
        }else {
            return "Sabado" + "Domingo";
        }
    }
    
    
    /**
     * Restablecer los valores iniciales del podómetro
     * Todos los atributos se ponen a cero salvo el sexo
     * que se establece a MUJER. La marca no varía
     *  
     */    
    public void reset() {

        altura = 0;
        sexo = 'M';
        longitudZancada = 0;
        totalPasosLaborales = 0;
        totalPasosSabado = 0;
        totalPasosDomingo = 0;
        totalDistanciaSemana = 0;
        tiempo = 0;
        caminatasNoche = 0;

    }

}

