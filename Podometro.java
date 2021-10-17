/**
 * La clase modela un sencillo podómetro que registra información
 * acerca de los pasos, distancia, ..... que una persona
 * ha dado en una semana. 
 * 
 * @author Carlos Alonso
 */
public class Podometro
 {
    private final char HOMBRE = 'H';
    private final char MUJER = 'M';
    private final double ZANCADA_HOMBRE = 0.45;
    private final double ZANCADA_MUJER = 0.41;
    private String marca;
    private double altura;
    private final int SABADO = 6;
    private final int DOMINGO = 7;
    private char sexo;
    private int tiempo;
    private int caminatasNoche;
    private double longitudZancada;
    private int totalPasosLaborables;
    private int totalPasosSabado;
    private int totalPasosDomingo;
    private double totalDistanciaSemana;
    private double totalDistanciaFinSemana;
   
    /**
     * Inicializa el podómetro con la marca indicada por el parámetro.
     * El resto de atributos se ponen a 0 y el sexo, por defecto, es mujer
     */
    public Podometro(String queMarca)
    {
        marca = queMarca;
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
    public String getMarca()
    {
        return marca;
    }

    /**
     * Simula la configuración del podómetro.
     * Recibe como parámetros la altura y el sexo de una persona
     * y asigna estos valores a los atributos correspondiente.
     * Asigna además el valor adecuado al atributo longitudZancada
     * 
     */
    public void configurar(double queAltura, char queSexo)
    {
        altura = queAltura;
        sexo = queSexo;
        if (sexo == HOMBRE) 
        {
            longitudZancada = Math.ceil(ZANCADA_HOMBRE * altura);
        }
        else if (sexo == MUJER)
        {
            longitudZancada = Math.floor(ZANCADA_MUJER * altura);
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
     */
   public void registrarCaminata(int pasos, int dia,
                                   int horaInicio, int horaFin)
   {
    {
        switch (dia){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                totalPasosLaborables += pasos;
                break;
            case 6: sabado:
                totalPasosSabado += pasos;
                break;
            case 7: domingo:
                totalPasosDomingo += pasos;
                break;

        }
        totalDistanciaSemana = totalPasosLaborables * longitudZancada / 100 / 1000;
        totalDistanciaFinSemana = (totalPasosSabado + totalPasosDomingo)
        * longitudZancada / 100 / 1000;
        
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
     */
    public void printConfiguracion()
    {
        String sexoTexto;
        if (sexo == MUJER) 
        {
            sexoTexto = "MUJER";
        } 
        else 
        {
            sexoTexto = "HOMBRE";
        }
        
        System.out.println("Configuración del podómetro ***************************");
        System.out.println("Altura: " + altura + " metros");
        System.out.println("Sexo: " + sexoTexto);
        System.out.println("Longitud zancada: " + longitudZancada/100 + " metros");
    }

    /**
     * Muestra en pantalla información acerca de la distancia recorrida,
     * pasos, tiempo total caminado, ....
     * 
     */
    public void printEstadísticas()
    {
        System.out.println("Estadísticas");
        System.out.println("******************************");
        System.out.println("Distancia recorrida toda la semana: "
        + totalDistanciaSemana + " Km");
        System.out.println("Distancia recorrida fin de semana: " 
        + totalDistanciaFinSemana + " Km");
            
        System.out.println("Nº de pasos en días laborables: " + totalPasosLaborables);
        System.out.println("Nº de pasos SÁBADO: " + totalPasosSabado);
        System.out.println("Nº de pasos DOMINGO: " + totalPasosDomingo);
        
        System.out.println("Nº de caminatas realizadas a partir de las 21h.: "
        + caminatasNoche);
        
        System.out.println("Tiempo total caminado en la semana: "
        + (tiempo/100) + "h. y " + (tiempo%100) + "m.");
        System.out.println("Día/s con más pasos caminados: "
        + diaMayorNumeroPasos());
    }
   
    /**
     *  Calcula y devuelve un String que representa el nombre del día
     *  en el que se han caminado más pasos - "SÁBADO"  ,  "DOMINGO" o  "LABORABLES"
     */
    public String diaMayorNumeroPasos()
    {
        if (totalPasosLaborables > totalPasosSabado && totalPasosLaborables > totalPasosDomingo) 
        {
            return "LABORALES";
        } 
        else if (totalPasosSabado > totalPasosLaborables && totalPasosSabado > totalPasosDomingo) 
        {
            return "SABADO";
        } 
        else if (totalPasosDomingo > totalPasosLaborables && totalPasosDomingo > totalPasosSabado) 
        {
            return "DOMINGO";
        } 
        else if (totalPasosDomingo == totalPasosLaborables && totalPasosDomingo == totalPasosSabado) 
        {
            return "LABORALES " + "SABADO " + "DOMINGO";
        } 
        else if (totalPasosDomingo == totalPasosLaborables) 
        {
            return "LABORALES " + "DOMINGO";
        } 
        else if (totalPasosSabado == totalPasosLaborables) 
        {
            return "SABADO " + "LABORALES";
        } 
        else {
            return "SABADO " + "DOMINGO";
        }
    }
    
    /**
     * Restablecer los valores iniciales del podómetro
     * Todos los atributos se ponen a cero salvo el sexo
     * que se establece a MUJER. La marca no varía
     *  
     */    
    public void reset()
    {
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