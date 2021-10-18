/**
 * La clase modela un sencillo pod�metro que registra informaci�n
 * acerca de los pasos, distancia, ..... que una persona
 * ha dado en una semana. 
 * 
 * @author    - Xabi - 
 */

public class Podometro 
{
    private String marca;
    private String mayorNumeroPasos;
    private char sexo;
    private char mujer = 'm';
    private char hombre = 'h';
    private double altura;
    public double longitudZancada;  
    public double zancadaHombre = 0.45;
    public double zancadaMujer = 0.41;
    private int pasos;
    private int totalCaminado;
    private int totalPasosSabado;
    private int totalPasosDomingo;
    private int totalPasosLaborables;
    private int totalPasosFinDeSemana;
    private int totalPasosNoche;
    /**
     * Inicializa el pod�metro con la marca indicada por el par�metro.
     * El resto de atributos se ponen a 0 y el sexo, por defecto, es mujer
     */
    public Podometro(String queMarca) 
    {
       marca = queMarca;
       mayorNumeroPasos = "0";      
       sexo = mujer;
       altura = 0;
       longitudZancada = 0;
       pasos = 0;
       totalCaminado = 0;
       totalPasosSabado = 0;
       totalPasosDomingo = 0;
       totalPasosLaborables = 0;
       totalPasosFinDeSemana = 0;
       totalPasosNoche = 0;
    }

    /**
     * accesor para la marca
     *  
     */
    public String getMarca() 
    {

    return  marca;     
    
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
    if(queSexo == hombre)
    {
        longitudZancada = Math.ceil (queAltura * zancadaHombre);
    }
    else if(sexo == mujer)
    {
        longitudZancada = (Math.floor(queAltura * zancadaMujer)); 
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
        
    switch(dia)
    
    {
        case 1: String dia1 = "lunes";        
        case 2: String dia2 = "martes";       
        case 3: String dia3 = "miercoles";
        case 4: String dia4 = "jueves";
        case 5: String dia5 = "viernes";
        totalPasosLaborables += pasos;
        break;
        case 6: String dia6 = "sabado";
        totalPasosSabado += pasos;
        break;
        case 7: String dia7 = "domingo";
        totalPasosDomingo += pasos;
        break;
    }
        totalCaminado = totalPasosLaborables + totalPasosSabado + totalPasosDomingo;
        totalPasosFinDeSemana = totalPasosSabado + totalPasosDomingo;
    if(horaInicio > 2100)
    {
        totalPasosNoche++;
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
    System.out.println("Configuracion del podometro ");
    System.out.println("Altura: " + altura);
    System.out.println("Sexo: " + sexo);
    System.out.println("longitudZancada: " + longitudZancada);

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
    System.out.println("Estadisticas " );
    System.out.println("Pasos Totales Caminados: " + totalCaminado);
    System.out.println("Numero de pasos dias laborables: " + totalPasosLaborables);
    System.out.println("Numero de pasos el sabado: " + totalPasosSabado);
    System.out.println("Numero de pasos el Domingo: " + totalPasosDomingo);
    System.out.println("Numero de pasos fin de semana: " + totalPasosFinDeSemana);

    }
    
    /**
     *  Calcula y devuelve un String que representa el nombre del d�a
     *  en el que se ha caminado m�s pasos - "S�BADO"   "DOMINGO" o  "LABORABLES"
     */
    public String diaMayorNumeroPasos()
    {
    if(totalPasosLaborables > totalPasosFinDeSemana)
    {
        mayorNumeroPasos = "diasLaborables";
    }
    else if(totalPasosFinDeSemana > totalPasosLaborables)
    {
        mayorNumeroPasos = "diasFinDeSemana";
    }
    return mayorNumeroPasos;     
    
    }
    
    /**
     * Restablecer los valores iniciales del pod�metro
     * Todos los atributos se ponen a cero salvo el sexo
     * que se establece a MUJER. La marca no var�a
     *  
     */    
    public void reset()
    {     
       mayorNumeroPasos = "0";      
       sexo = mujer;
       altura = 0;
       longitudZancada = 0;
       pasos = 0;
       totalCaminado = 0;
       totalPasosSabado = 0;
       totalPasosDomingo = 0;
       totalPasosLaborables = 0;
       totalPasosFinDeSemana = 0;
       totalPasosNoche = 0;
    }

}
