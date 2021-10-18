/**
 * La clase modela un sencillo podómetro que registra información
 * acerca de los pasos, distancia, ..... que una persona
 * ha dado en una semana. 
 * 
 * @author    - Bautista Fernandez Brocos - 
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
    public Podometro(String queMarca) 
    {
        marca = queMarca;
        sexo = MUJER;
        longitudZancada = 0;
        totalPasosLaborables = 0;
        totalPasosSabado = 0;
        totalPasosDomingo = 0;
        totalDistanciaSemana = 0;
        totalDistanciaFinSemana = 0;
        tiempo = 0;
        caminatasNoche = 0;
        altura = 0;
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
     * (leer enunciado)
     *  
     */
    public void configurar(double queAltura, char queSexo) 
    {
        altura = queAltura;
        sexo = queSexo;
        if(sexo == HOMBRE)
        {
            longitudZancada= Math.ceil(altura * ZANCADA_HOMBRE);
        }
        if (sexo == MUJER)
        {
            longitudZancada = Math.floor( altura * ZANCADA_MUJER);
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
                            int horaFin) 
    {
        int tiempoMins = (horaFin /100 - horaInicio / 100) * 60;
        tiempo += tiempoMins;  
        int totalDistancia = 0;
        
        if(horaInicio > 2100)
        {
            caminatasNoche ++;
        }
        
        switch(dia)
        {
            case 6:
               totalPasosSabado += pasos;
               break;
            case 7:
               totalPasosDomingo += pasos;
               break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                totalPasosLaborables += pasos;
                break;
            }
            
        if (dia> 5)
        {
            totalDistanciaFinSemana += pasos * longitudZancada /100;
        }
        
        else
        {
            totalDistanciaSemana += pasos * longitudZancada /100;   
        }
    }
    
     /**
     * Muestra en pantalla la configuración del podómetro
     * (altura, sexo y longitud de la zancada)
     * 
     * (ver enunciado)
     *  
     */
    public void printConfiguracion() 
    {
        System.out.println("Configuracion del podometro");
        System.out.println("***************************");
        System.out.println("Altura: " + altura);
        System.out.println("Sexo: " + sexo);
        System.out.println("Longitud Zancada: " +longitudZancada);
    }

    /**
     * Muestra en pantalla información acerca de la distancia recorrida,
     * pasos, tiempo total caminado, ....
     * 
     * (leer enunciado)
     *  
     */
    public void printEstadísticas() 
    {
        System.out.println("Estadisticas");
        System.out.println("*******************");
        System.out.println("Distancia recorrida toda la semana: " +totalDistanciaSemana);
        System.out.println("Distancia recorrida fin de semana: " +totalDistanciaFinSemana);
        System.out.println("#################");
        System.out.println("Nº pasos dias laborales: " + totalPasosLaborables);
        System.out.println("Nº pasos SABADO: " + totalPasosSabado);
        System.out.println("Nº pasos DOMINGO: " + totalPasosDomingo);
        System.out.println("#################");
        System.out.println("Nº caminatas realizadas a partir de las 21h : " + caminatasNoche);
        System.out.println("#################");
        System.out.println("Tiempo total caminado en la semana: " + tiempo);
        System.out.println("Dia/s con mas pasos caminados: " + this.masPasos);
    }

    /**
     *  Calcula y devuelve un String que representa el nombre del día
     *  en el que se ha caminado más pasos - "SÁBADO"   "DOMINGO" o  "LABORABLES"
     */
    public String diaMayorNumeroPasos() 
    {
        String masPasos = "";
        if (totalPasosSabado > totalPasosLaborables && totalPasosSabado > totalPasosDomingo)
        {
            masPasos = "Sabado";
        }
        else if(totalPasosDomingo > totalPasosLaborables && totalPasosDomingo > totalPasosSabado)
        {
            masPasos = "Domingo";
        }
        else if(totalPasosLaborables > totalPasosDomingo && totalPasosLaborables > totalPasosSabado)
        {
            masPasos = "Laborables";
        }
        else if(totalPasosDomingo == totalPasosLaborables && totalPasosDomingo > totalPasosSabado)
        {
            masPasos = "Domingo y laborales";
        }
        else if(totalPasosDomingo == totalPasosSabado && totalPasosDomingo > totalPasosLaborables)
        {
            masPasos = "Sabado y Domingo";
        }
        else if(totalPasosSabado == totalPasosLaborables && totalPasosSabado > totalPasosDomingo)
        {
            masPasos = "Sabado y laborales";
        }
        return masPasos;
    }
    
    
    /**
     * Restablecer los valores iniciales del podómetro
     * Todos los atributos se ponen a cero salvo el sexo
     * que se establece a MUJER. La marca no varía
     *  
     */    
    public void reset() 
    {
        sexo = MUJER;
        longitudZancada = 0;
        totalPasosLaborables = 0;
        totalPasosSabado = 0;
        totalPasosDomingo = 0;
        totalDistanciaSemana = 0;
        totalDistanciaFinSemana = 0;
        tiempo = 0;
        caminatasNoche = 0;
        altura = 0;
    }

}

