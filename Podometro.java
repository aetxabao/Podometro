/**
 * La clase modela un sencillo pod�metro que registra informaci�n
 * acerca de los pasos, distancia, ..... que una persona
 * ha dado en una semana. 
 * 
 * @author  Grijalba Javier 
 */

public class Podometro
{
    //==========  ATRIBUTOS  ==============
    private final char HOMBRE = 'H';
    private final char MUJER = 'M';
    
    private final double ZANCADA_HOMBRE = 0.45;
    private final double ZANCADA_MUJER = 0.41;
    
    private final int SABADO = 6;
    private final int DOMINGO = 7;
    //---------------------------------------------
    private String marca;
    private double altura;
    private char sexo;
    private int longitudZancada;
    private int totalPasosLaborables;
    private int totalPasosSabado;
    private int totalPasosDomingo;
    private int totalDistaciaSemana;
    private int totalDistanciaFinSemana;
    private int tiempo;
    private int caminatasNoche;

    /**
     * Inicializa el pod�metro con la marca indicada por el par�metro.
     * El resto de atributos se ponen a 0 y el sexo, por defecto, es mujer
     */
    public Podometro(String marca)
    {
        this.marca = marca;
        altura = 0.0;
        sexo = 'M';
        longitudZancada = 0;
        totalPasosLaborables = 0;
        totalPasosSabado = 0;
        totalPasosDomingo = 0;
        totalDistaciaSemana = 0;
        totalDistanciaFinSemana = 0;
        tiempo = 0;
        caminatasNoche = 0;
    }

    /**
     * accesor para la marca 
     */
    public String getMarca()
    {
        return this.marca;
    }

    /**
     * Simula la configuraci�n del pod�metro.
     * Recibe como par�metros la altura y el sexo de una persona
     * y asigna estos valores a los atributos correspondiente.
     * Asigna adem�s el valor adecuado al atributo longitudZancada
     * 
     * (leer enunciado)
     */
    // no entiendo porque la altura en cm debe ser double, nadie dice 
    // tengo 190.5 cm de altura. Incluso todos los datos que se van
    // a pasar desde la demo son enteros. Supongo que es para obligarnos
    // a usar las funciones de redondeo.
    public void configurar(double queAltura, char queSexo)
    {
        sexo = queSexo;
        altura = queAltura;
        switch(sexo)
        {
            case 'H': longitudZancada = (int)Math.ceil(0.45 * altura);
            break;
            case 'M': longitudZancada = (int)Math.floor(0.41 * altura);
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
    public void registrarCaminata(int pasos, int dia, int horaInicio, int horaFin)
    {
        // separo horas y minutos con divisiones y modulos 
        int horaInicioHoras = horaInicio / 100;
        int horaInicioMinutos = horaInicio % 100;
        int horaFinHoras = horaFin / 100;
        int horaFinMinutos = horaFin % 100;
        // resuelvo cuantas horas han pasado y las paso a minutos
        int cuantosMinutos = (horaFinHoras - horaInicioHoras) * 60;
        // anado los minutos que han pasado y lo sumo todo al atributo 'tiempo'
        cuantosMinutos += horaFinMinutos - horaInicioMinutos;
        this.tiempo += cuantosMinutos;
        
        switch(dia)
        {
            // los dias laborables se pueden poner seguidos
            case 1: case 2: case 3: case 4: case 5:
                totalPasosLaborables += pasos;
                totalDistaciaSemana += pasos * longitudZancada; 
            break;
            // el Sabado
            case 6: 
                totalPasosSabado += pasos;
                totalDistanciaFinSemana += pasos * longitudZancada;
            break;
            // el Domingo
            case 7:
                totalPasosDomingo += pasos;
                totalDistanciaFinSemana += pasos * longitudZancada;
            break;
        }
        
        // los paseos nocturnos
        if(horaInicioHoras >= 21)
        {
            caminatasNoche++;
        }
    }
    
    public void registrarCaminata2(int pasos, int dia, int horaInicio, int horaFin)
    {
        //LocalTime
       

    }
    
     /**
     * Muestra en pantalla la configuraci�n del pod�metro
     * (altura, sexo y longitud de la zancada)
     * 
     * (ver enunciado)
     */
    public void printConfiguracion()
    {

        

    }

    /**
     * Muestra en pantalla informaci�n acerca de la distancia recorrida,
     * pasos, tiempo total caminado, ....
     * 
     * (leer enunciado)
     */
    public void printEstad�sticas()
    {

        

    }

    /**
     *  Calcula y devuelve un String que representa el nombre del d�a
     *  en el que se ha caminado m�s pasos - "S�BADO"   "DOMINGO" o  "LABORABLES"
     */
    public String diaMayorNumeroPasos()
    {

         
        return "";
    }
    
    /**
     * Restablecer los valores iniciales del pod�metro
     * Todos los atributos se ponen a cero salvo el sexo
     * que se establece a MUJER. La marca no var�a
     *  
     */    
    public void reset()
    {

        

    }

}
