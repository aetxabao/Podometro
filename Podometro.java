/**
 * La clase modela un sencillo pod�metro que registra informaci�n
 * acerca de los pasos, distancia, ..... que una persona
 * ha dado en una semana. 
 * 
 * @author    - I�igo_salinas - 
 */
public class Podometro 
{
    // TODO void registrarCaminata intentar hacer con un swith
    private final char HOMBRE='H';
    private final char MUJER='M'; //char''
    private final double ZANCADA_HOMBRE= 0.45;
    private final double ZANCADA_MUJER= 0.4; 
    private final int SABADO= 6;
    private final int DOMINGO= 7;
    
    private String marca;
    private double altura;
    private char sexo;
    private double longitudZancada;
    private int totalPasosLaborales;
    private int totalPasosSabado;
    private int totalPasosDomingo;
    private double totalDistanciaSemana; //km
    private double totalDistanciaFinSemana; //km
    private int tiempo;
    private int caminatasNoche;  //a partir de las 21 numero de caminatas dadas.
    
    

    /**
     * Inicializa el pod�metro con la marca indicada por el par�metro.
     * El resto de atributos se ponen a 0 y el sexo, por defecto, es mujer
     */
    public  Podometro(String queMarca) 
    {
        marca=queMarca;
        altura=0;
        sexo ='M';  
        longitudZancada=0;
        totalPasosLaborales=0;
        totalPasosSabado=0;
        totalPasosDomingo=0;
        totalDistanciaSemana=0;
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
        altura=queAltura;
        sexo=queSexo;                    
        if(queSexo==MUJER)
        {
            Math.ceil(longitudZancada =queAltura * ZANCADA_MUJER) ;
        }
        else
        {
            Math.ceil(longitudZancada=queAltura * ZANCADA_HOMBRE);
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
                            int horaFin) 
    {
        int Tiempo;
        Tiempo=horaFin-horaInicio;
        tiempo=Tiempo;
         switch (tiempo)
         {
             case 1:
                 dia=6; 
                 totalDistanciaFinSemana+=pasos;
                 totalPasosSabado+=pasos;
                 break;
             case 2:
                 dia=7;
                 totalDistanciaFinSemana+=pasos;
                 totalPasosDomingo+=pasos;
                 break;
             case 3:
                 dia=1&2&3&4&5;
                 totalDistanciaSemana+=pasos;
                 totalPasosLaborales+=pasos;
                 break;
                 
         }
        
        if(horaInicio>=21)
        {
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
    public void printConfiguracion() 
    {
        System.out.println("Configuracion del podometro");
        System.out.println("****************************");
        System.out.println("Altura: " +altura/100+ "mtos");
        System.out.println("Sexo: " +sexo);
        System.out.println("Longitud de zancada: " +longitudZancada/100+ "mtos");
        
    }

    /**
     * Muestra en pantalla informaci�n acerca de la distancia recorrida,
     * pasos, tiempo total caminado, ....
     * 
     * (leer enunciado)
     *  
     */
    public void printEstad�sticas() 
    { 
        
        System.out.println("Estadisticas");
        System.out.println("****************************");
        System.out.println("Distancia recorrida toda la semana: " +totalDistanciaSemana);
        System.out.println("Distancia recorrida fin de semana: " +totalDistanciaFinSemana);
        System.out.println("N� pasos dias laborales: " +totalPasosLaborales);
        System.out.println("N� pasos Sabado: " +totalPasosSabado);
        System.out.println("N� pasos Domingo: " +totalPasosDomingo);
        System.out.println("N� caminatas realizadas a partir de las 21h: " +caminatasNoche); //caminatas echas a partir de una hora
        System.out.println("Tiempo total caminado esta semana: " +tiempo);
        System.out.println("Dia/s con mas pasos caminados: " +diaMayorNumeroPasos());   
    }

   

    /**
     *  Calcula y devuelve un String que representa el nombre del d�a
     *  en el que se ha caminado m�s pasos - "S�BADO"   "DOMINGO" o  "LABORABLES"
     */
    public String diaMayorNumeroPasos() 
    {
        String diaMasCaminado;
        if(totalPasosLaborales>totalPasosSabado && totalPasosLaborales>totalPasosDomingo)
        {
             diaMasCaminado="LABORABLES";
        }
        
        if(totalPasosSabado>totalPasosLaborales && totalPasosSabado>totalPasosDomingo)
        {
             diaMasCaminado="SABADO";
        }
        
        if(totalPasosDomingo>totalPasosLaborales && totalPasosDomingo>totalPasosSabado)
        {
             diaMasCaminado="DOMINGO";
        }
        
        if(totalPasosLaborales==totalPasosDomingo && totalPasosLaborales>totalPasosSabado)
        {
             diaMasCaminado="LABORABLES Y DOMINGO";
        }
        
        else
        {
             diaMasCaminado="SABADO Y DOMINGO ";
        }
        return diaMasCaminado;
    }
    
    
    /**
     * Restablecer los valores iniciales del pod�metro
     * Todos los atributos se ponen a cero salvo el sexo
     * que se establece a MUJER. La marca no var�a
     *  
     */    
    public void reset() 
    {
        altura=0;
        sexo ='M';  
        longitudZancada=0;
        totalPasosLaborales=0;
        totalPasosSabado=0;
        totalPasosDomingo=0;
        totalDistanciaSemana=0;
        totalDistanciaFinSemana=0;
        tiempo=0;
        caminatasNoche=0;   
    }

}
