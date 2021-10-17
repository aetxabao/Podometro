/**
 * La clase modela un  sencillo podómetro que registra información
 * acerca de los pasos, distancia, ..... que una persona
 * ha dado en una semana. 
 * 
 * @author    - pon aquí tu nombre - 
 */
public class Podometro {
    
    private final char HOMBRE = 'H';
    private final char MUJER = 'M';
    private final double ZANCADA_HOMBRE = 0.45;
    private final double ZANCADA_MUJER = 0.41;
    private final int SABADO = 6;
    private final int DOMINGO = 7;
    private String marca;
    private int altura;
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
        char sexo = 'M';
        int altura = 0;
        double longitudZancada = 0;
        int totalPasosLaborables = 0;
        int totalPasosSabado = 0;
        int totalPasosDomingo = 0;
        double totalDistanciaSemana = 0;
        double totalDistanciaFinSemana = 0;
        double tiempo = 0;
        int caminatasNoche = 0;
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
        altura = (int)queAltura;
        if(queSexo == 'M' || queSexo == 'H')
        {
            sexo = queSexo;
        }
        
        else 
        {
            System.out.println("Introduzca como sexo 'H' o 'M'");    
        }
        
        if(queSexo == 'M')
        {
            longitudZancada = Math.floor(altura * ZANCADA_MUJER);
        }
        
        else if(queSexo == 'H')
        {
            longitudZancada = Math.ceil(altura * ZANCADA_HOMBRE);
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
        int horasInicio = horaInicio / 100;
        int minsInicio = horaInicio % 100;
        int minutosInicio = horasInicio * 60;
        int tiempoInicio = minutosInicio + minsInicio;
        int horasFin = horaFin / 100;
        int minsFin = horaFin % 100;
        int minutosFin = horasFin * 60;
        int tiempoFin = minutosFin + minsFin;
        tiempo += (tiempoFin - tiempoInicio); 
        switch(dia){
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: totalPasosLaborables += pasos;
                    totalDistanciaSemana += (pasos * longitudZancada / 100);
                    break;
            case 6: totalPasosSabado += pasos;
                    totalDistanciaFinSemana += (pasos * longitudZancada / 100);
                    break;
            case 7: totalPasosDomingo += pasos;
                    totalDistanciaFinSemana += (pasos * longitudZancada / 100);
                    break;
        }
        
        if(horaInicio >= 2100)
        {
            caminatasNoche ++;
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
        System.out.println("Configuración del podómetro");
        System.out.println("***************************");
        System.out.println("Altura: " + ((double)altura / 100) + " mtos.");
        if(sexo == 'H') 
        {
            System.out.println("Sexo: HOMBRE");
            System.out.println("Longitud zancada: " + ((double)altura / 100 * 0.45) + " Mtos.");
        }
        else
        {
            System.out.println("Sexo: MUJER");
            System.out.println("Longitud zancada: " + ((double)altura / 100 * 0.41) + " Mtos.");
        }
    }

    /**
     * Muestra en pantalla información acerca de la distancia recorrida,
     * pasos, tiempo total caminado, ....
     * 
     * (leer enunciado)
     *  
     */
    public void printEstadísticas() {
        double totalDistancia = (totalDistanciaSemana + totalDistanciaFinSemana) / (double)1000;
        int tiempoHoras = (tiempo / 60);
        int tiempoMins = (tiempo % 60);
        String diaMax = ""; 
        if (totalPasosLaborables > totalPasosSabado && totalPasosLaborables > totalPasosDomingo)
        {
             diaMax = "LABORABLES"; 
        }
        else if (totalPasosSabado > totalPasosLaborables && totalPasosSabado > totalPasosDomingo)
        {
             diaMax = "SABADO"; 
        }
        else if(totalPasosDomingo > totalPasosLaborables && totalPasosDomingo > totalPasosSabado)
        {
            diaMax = "DOMINGO";
        }
        
        else if(totalPasosLaborables == totalPasosDomingo && totalPasosLaborables > totalPasosSabado)
        {
            diaMax = "LABORABLES Y DOMINGO";
        }
        
        else if(totalPasosSabado == totalPasosDomingo && totalPasosSabado > totalPasosLaborables)
        {
            diaMax = "SABADO Y DOMINGO";
        }
        
        else if(totalPasosSabado == totalPasosDomingo && totalPasosSabado > totalPasosLaborables)
        {
            diaMax = "LABORABLES Y SABADO";
        }
        
        System.out.println("Estadísticas");
        System.out.println("*********************************");
        System.out.println("Distancia recorrida toda la semana: " + totalDistancia + "Km");
        System.out.println("\n");
        System.out.println("Nº pasos días laborables: " + totalPasosLaborables);
        System.out.println("Nº pasos Sábado: " + totalPasosSabado);
        System.out.println("Nº pasos Domingo: " + totalPasosDomingo);
        System.out.println("\n");
        System.out.println("Nº de caminatas a partir de las 21h.: " + caminatasNoche);
        System.out.println("\n");
        System.out.println("Tiempo total caminado en la semana: " + tiempoHoras + "h. y " + tiempoMins + "m.");
        System.out.println("Dia/s con más pasos caminados: " + diaMax);
    }

   

    /**
     *  Calcula y devuelve un String que representa el nombre del día
     *  en el que se ha caminado más pasos - "SÁBADO"   "DOMINGO" o  "LABORABLES"
     */
    public String diaMayorNumeroPasos() {
        String diaMax = ""; 
        if (totalPasosLaborables > totalPasosSabado && totalPasosLaborables > totalPasosDomingo)
        {
             diaMax = "LABORABLES"; 
        }
        else if (totalPasosSabado > totalPasosLaborables && totalPasosSabado > totalPasosDomingo)
        {
             diaMax = "SABADO"; 
        }
        else if(totalPasosDomingo > totalPasosLaborables && totalPasosDomingo > totalPasosSabado)
        {
            diaMax = "DOMINGO";
        }
        
        else if(totalPasosSabado == totalPasosDomingo && totalPasosSabado > totalPasosLaborables)
        {
            diaMax = "LABORABLES Y SABADO";
        }
        
        else if(totalPasosLaborables == totalPasosDomingo && totalPasosLaborables > totalPasosSabado)
        {
            diaMax = "LABORABLES Y DOMINGO";
        }
        
        else if(totalPasosSabado == totalPasosDomingo && totalPasosSabado > totalPasosLaborables)
        {
            diaMax = "SABADO Y DOMINGO";
        }
        return diaMax;
    }
    
    
    /**
     * Restablecer los valores iniciales del podómetro
     * Todos los atributos se ponen a cero salvo el sexo
     * que se establece a MUJER. La marca no varía
     *  
     */    
    public void reset() {
        char sexo = 'M';
        int altura = 0;
        double longitudZancada = 0;
        int totalPasosLaborables = 0;
        int totalPasosSabado = 0;
        int totalPasosDomingo = 0;
        double totalDistanciaSemana = 0;
        double totalDistanciaFinSemana = 0;
        double tiempo = 0;
        int caminatasNoche = 0;
    }
}