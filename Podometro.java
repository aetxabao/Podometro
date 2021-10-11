/**
 * La clase modela un sencillo pod�metro que registra informaci�n
 * acerca de los pasos, distancia, ..... que una persona
 * ha dado en una semana. 
 * 
 * @author    - I�igo_salinas - 
 */
public class Podometro {
    private final String HOMBRE="M";
    private final String MUJER="F";
    private final double ZANCADA_HOMBRE= 0.45;
    private final double ZANCADA_MUJER= 0.4; 
    private final int SABADO=6;
    private final int DOMINGO=7;
    
    private String marca;
    private double altura;
    private String sexo;
    private double longitudZancada;
    private double totalPasosLaborales;
    private double totalPasosSabado;
    private double totalPasosDomingo;
    private double totalDistanciaSemana; //km
    private double totalDistanciaFinSemana; //km
    private double tiempo;
    private double caminatasNoche;  //a partir de las 21 numero de caminatas dadas.
    
    

    /**
     * Inicializa el pod�metro con la marca indicada por el par�metro.
     * El resto de atributos se ponen a 0 y el sexo, por defecto, es mujer
     */
    public  Podometro(String queMarca) 
    {
        marca=queMarca;
        altura=0;
        sexo="F";  
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
        altura=ZANCADA_HOMBRE*altura;
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

       

    }
    
     /**
     * Muestra en pantalla la configuraci�n del pod�metro
     * (altura, sexo y longitud de la zancada)
     * 
     * (ver enunciado)
     *  
     */
    public void printConfiguracion() {

        

    }

    /**
     * Muestra en pantalla informaci�n acerca de la distancia recorrida,
     * pasos, tiempo total caminado, ....
     * 
     * (leer enunciado)
     *  
     */
    public void printEstad�sticas() {

        

    }

   

    /**
     *  Calcula y devuelve un String que representa el nombre del d�a
     *  en el que se ha caminado m�s pasos - "S�BADO"   "DOMINGO" o  "LABORABLES"
     */
    //public String diaMayorNumeroPasos() {

         

    //}
    
    
    /**
     * Restablecer los valores iniciales del pod�metro
     * Todos los atributos se ponen a cero salvo el sexo
     * que se establece a MUJER. La marca no var�a
     *  
     */    
    public void reset() {

        

    }

}
