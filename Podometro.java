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
        reset();
        this.marca = marca;
    }

    /**
     * accesor para la marca 
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
     */
    public void configurar(double queAltura, char queSexo)
    {
        sexo = queSexo;
        altura = queAltura;
        switch(sexo)
        {
            // longitudZancada = altura por 0.45, redondeado hacia arriba
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
        
        int distancia = pasos * longitudZancada;
        totalDistaciaSemana += distancia;
        switch(dia)
        {
            // los dias laborables se pueden poner seguidos
            case 1: case 2: case 3: case 4: case 5:
                totalPasosLaborables += pasos;
            break;
            // el Sabado
            case 6: 
                totalPasosSabado += pasos;
                totalDistanciaFinSemana += distancia;
            break;
            // el Domingo
            case 7:
                totalPasosDomingo += pasos;
                totalDistanciaFinSemana += distancia;
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
        System.out.println("Configuracion del podometro");
        System.out.println("***************************");
        System.out.println("Altura: " + altura);
        if(sexo == MUJER)
        {
            System.out.println("Sexo: MUJER");
        }
        else
        {
            System.out.println("Sexo: HOMBRE");
        }
        System.out.println("Longitud zancada : " + longitudZancada + " mtos");

    }

    /**
     * Muestra en pantalla informaci�n acerca de la distancia recorrida,
     * pasos, tiempo total caminado, ....
     * 
     * (leer enunciado)
     */
    public void printEstad�sticas()
    {
        
        System.out.println("Estadisticas");
        System.out.println("***************************");
        System.out.println("Distancia recorrida toda la semana: " + totalDistaciaSemana);
        System.out.println("Distancia recorrida fin de semana: " + totalDistanciaFinSemana);
        System.out.println("N� pasos dias laborables: " + totalPasosLaborables);
        System.out.println("N� pasos SABADO: " + totalPasosSabado);
        System.out.println("N� pasos DOMINGO: " + totalPasosDomingo);
        System.out.println("N� de caminatas realizados a partir de las 21:00: " + caminatasNoche);
        System.out.println("Tiempo total caminado en la semana: " 
                          + (tiempo / 60) + "h. y " + (tiempo % 60) + " m." );
        System.out.println("Dias con mas pasos caminados: " + diaMayorNumeroPasos());
    }
    

    /**
     *  Calcula y devuelve un String que representa el nombre del d�a
     *  en el que se ha caminado m�s pasos - "S�BADO"   "DOMINGO" o  "LABORABLES"
     */
    public String diaMayorNumeroPasos()
    {
        String res = "";
        // primero averiguo cual es el maximo numero de pasos
        // entre LABORABLES, SABADO Y DOMINGO.
        int pasosMax = totalPasosLaborables;
        
        if(totalPasosSabado > pasosMax)
        {
            pasosMax = totalPasosSabado;
        }
        
        if(totalPasosDomingo > pasosMax)
        {
            pasosMax = totalPasosDomingo;
        }
        
        // ahora anado a res aquellos que son iguales al maximo
        if(totalPasosLaborables == pasosMax)
        {
            res += " Laborables";
        }
        
        if(totalPasosSabado == pasosMax)
        {
            res = res.concat(" Sabado");
        }
        
        if(totalPasosDomingo == pasosMax)
        {
            res.concat(" Domingo");
        }
         
        return res;
    }
    
    /**
     * Restablecer los valores iniciales del pod�metro
     * Todos los atributos se ponen a cero salvo el sexo
     * que se establece a MUJER. La marca no var�a
     *  
     */    
    public void reset()
    {
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

}
