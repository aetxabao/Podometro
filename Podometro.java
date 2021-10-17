/**
 * La clase modela un sencillo podómetro que registra información
 * acerca de los pasos, distancia, ..... que una persona
 * ha dado en una semana. 
 * 
 * @author    - Iñigo_salinas - 
 */
public class Podometro 
{
    // TODO void registrarCaminata intentar hacer con un swith
    // TODO String diaMayorNumeroPasos()
    private final String HOMBRE="H";
    private final String MUJER="M"; //char''
    private final double ZANCADA_HOMBRE= 0.45;
    private final double ZANCADA_MUJER= 0.4; 
    private final String SABADO= "6";
    private final String DOMINGO= "7";
    
    private String marca;
    private double altura;
    private char sexo='M';
    private double longitudZancada;
    private int totalPasosLaborales;
    private int totalPasosSabado;
    private int totalPasosDomingo;
    private double totalDistanciaSemana; //km
    private double totalDistanciaFinSemana; //km
    private int tiempo;
    private double caminatasNoche;  //a partir de las 21 numero de caminatas dadas.
    
    

    /**
     * Inicializa el podómetro con la marca indicada por el parámetro.
     * El resto de atributos se ponen a 0 y el sexo, por defecto, es mujer
     */
    public  Podometro(String queMarca) 
    {
        marca=queMarca;
        altura=0;
        String sexo ="M";  
        longitudZancada=0;
        totalPasosLaborales=0;
        totalPasosSabado=0;
        totalPasosDomingo=0;
        int totalDistanciaSemana=0;
        totalDistanciaFinSemana=0;
        tiempo=0;
        caminatasNoche=0;
        
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
        altura=queAltura;
        sexo=queSexo;                    
        if(queSexo=='M')
        {
            Math.ceil(longitudZancada =queAltura * ZANCADA_MUJER) ;
        }
        else
        {
            Math.ceil(longitudZancada=queAltura * ZANCADA_HOMBRE);
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
        int Tiempo;
        Tiempo=horaFin-horaInicio;
        tiempo=Tiempo;
        if(dia==6)
        {
            totalDistanciaFinSemana+=pasos;
        }
        if(dia==7)
        {
            totalDistanciaFinSemana+=pasos;
        }
        else
        {
            totalDistanciaSemana+=pasos;
        }
        if(horaInicio<21)
        {
            caminatasNoche++;
        }
        //TODO      ECHO PERO LO TENGO QU EINTENTAR HACER U¡CON UN SWITCH
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
        System.out.println("****************************");
        System.out.println("Altura: " +altura+ "mtos");
        System.out.println("Sexo: " +sexo);
        System.out.println("Longitud de zancada: " +longitudZancada+ "mtos");
        
    }

    /**
     * Muestra en pantalla información acerca de la distancia recorrida,
     * pasos, tiempo total caminado, ....
     * 
     * (leer enunciado)
     *  
     */
    public void printEstadísticas(int dia, int pasos, int pasosSabado, int pasosDomingo, int pasosSemana) 
    {
        
        if(dia==6)
        {
            pasos=pasosSabado;
        }
        if(dia==7)
        {
            pasos=pasosDomingo;
        }
        else
        {
            pasos=pasosSemana;
        }
        System.out.println("Estadisticas");
        System.out.println("****************************");
        System.out.println("Distancia recorrida toda la semana: " +totalDistanciaSemana);
        System.out.println("Distancia recorrida fin de semana: " +totalDistanciaFinSemana);
        System.out.println("Nº pasos dias laborales: " +pasosSemana);
        System.out.println("Nº pasos Sabado: " +pasosSabado);
        System.out.println("Nº pasos Domingo: " +pasosDomingo);
        System.out.println("Nº caminatas realizadas a partir de las 21h: " +caminatasNoche); //caminatas echas a partir de una hora
        System.out.println("Tiempo total caminado esta semana: " +tiempo);
        //System.out.println("Dia/s con mas pasos caminados: " +diaMayorNumeroPasos);       dia q mas se a caminado
    }

   

    /**
     *  Calcula y devuelve un String que representa el nombre del día
     *  en el que se ha caminado más pasos - "SÁBADO"   "DOMINGO" o  "LABORABLES"
     */
    public String diaMayorNumeroPasos() 
    {
        if(totalPasosSabado<totalPasosDomingo)
        {
            return DOMINGO;
        }
        else
        {
            return SABADO;
        }
        //if(totalPasosSabado<totalPasosLaborales)
        //{
            //return totalPasosLaborales;
        //}
        //TODO no se como se hace
    }
    
    
    /**
     * Restablecer los valores iniciales del podómetro
     * Todos los atributos se ponen a cero salvo el sexo
     * que se establece a MUJER. La marca no varía
     *  
     */    
    public void reset() 
    {
     altura=0;
        int sexo ='M';  
        longitudZancada=0;
        totalPasosLaborales=0;
        totalPasosSabado=0;
        totalPasosDomingo=0;
        int totalDistanciaSemana=0;
        totalDistanciaFinSemana=0;
        tiempo=0;
        caminatasNoche=0;   
    }

}
