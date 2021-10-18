/**
 * La clase modela un sencillo podómetro que registra información
 * acerca de los pasos, distancia, ..... que una persona
 * ha dado en una semana. 
 * 
 * @author    - Xabi - 
 */

public class Podometro 
{
    private String marca;
    private String mayorNumeroPasos;
    private char sexo,mujer,m,hombre,h;
    private double altura;
    public double longitudZancada;   
    private int pasos;
    private int totalCaminado;
    private int pasosSabado;
    private int pasosDomingo;
    private int pasosLaborables;
    private int pasosFinDeSemana;
    /**
     * Inicializa el podómetro con la marca indicada por el parámetro.
     * El resto de atributos se ponen a 0 y el sexo, por defecto, es mujer
     */
    public Podometro(String marca) 
    {
       mayorNumeroPasos = "0";      
       sexo = mujer;
       mujer = m;
       hombre = h;
       altura = 0;
       longitudZancada = 0;
       pasos = 0;
       totalCaminado = 0;
       pasosSabado = 0;
       pasosDomingo = 0;
       pasosLaborables = 0;
       pasosFinDeSemana = 0;
    }

    /**
     * accesor para la marca
     *  
     */
    public String getMarca() 
    {

    return  "marca";     
    
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
    if(queSexo == h)
    {
        longitudZancada = Math.ceil (altura *= 45);
    }
    else if(sexo == m)
    {
        longitudZancada = (Math.floor(queAltura * 41)); 
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

    public void registrarCaminata(int pasos, int dia, int horaInicio,int horaFin) 
    {
        
    switch(dia)
    
    {
        case 1: String dia1 = "lunes"; 
        break;
        case 2: String dia2 = "martes";
        break;
        case 3: String dia3 = "miercoles";
        break;
        case 4: String dia4 = "jueves";
        break;
        case 5: String dia5 = "viernes";
        break;
        case 6: String dia6 = "sabado";
        break;
        case 7: String dia7 = "domingo";
        break;
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
    System.out.println("Configuracion del podometro ");
    System.out.println("Altura: " + altura);
    System.out.println("Sexo: " + sexo);
    System.out.println("longitudZancada: " + longitudZancada);

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
    System.out.println("Estadisticas " );
    System.out.println("Pasos Totales Caminados: " + totalCaminado);
    System.out.println("Numero de pasos dias laborables: " + pasosLaborables);
    System.out.println("Numero de pasos el sabado: " + pasosSabado);
    System.out.println("Numero de pasos el Domingo: " + pasosDomingo);
    System.out.println("Numero de pasos fin de semana: " + pasosFinDeSemana);

    }
    
    /**
     *  Calcula y devuelve un String que representa el nombre del día
     *  en el que se ha caminado más pasos - "SÁBADO"   "DOMINGO" o  "LABORABLES"
     */
    public String diaMayorNumeroPasos()
    {
    return mayorNumeroPasos;     

    }
    
    /**
     * Restablecer los valores iniciales del podómetro
     * Todos los atributos se ponen a cero salvo el sexo
     * que se establece a MUJER. La marca no varía
     *  
     */    
    public void reset()
    {
    mayorNumeroPasos = "0";
    sexo = mujer;
    longitudZancada = 0;
    altura = 0;
    pasos = 0;
    totalCaminado = 0;
    pasosSabado = 0;
    pasosLaborables = 0;
    pasosDomingo = 0;
    pasosFinDeSemana = 0;
    }

}
