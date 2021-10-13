/**
 * La clase modela un sencillo podómetro que registra información
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
     * Simula la configuración del podómetro.
     * Recibe como parámetros la altura y el sexo de una persona
     * y asigna estos valores a los atributos correspondiente.
     * Asigna además el valor adecuado al atributo longitudZancada
     * 
     * (leer enunciado)
     */
    public void configurar(double queAltura, char queSexo)
    {
        sexo = queSexo;
        
        switch(sexo)
        {
            // longitudZancada = altura por 0.45, redondeo hacia arriba y divido por 100 para metros.
            case 'H': longitudZancada = (Math.ceil(0.45 * queAltura)) / 100;
            break;
            case 'M': longitudZancada = (Math.floor(0.41 * queAltura)) / 100;
        }
        altura = queAltura / 100;
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
        
        double distancia = pasos * longitudZancada;
        totalDistanciaSemana += distancia;
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
    
     /**
     * Muestra en pantalla la configuración del podómetro
     * (altura, sexo y longitud de la zancada)
     * 
     * (ver enunciado)
     */
    public void printConfiguracion()
    {
        System.out.println("Configuracion del podometro");
        System.out.println("***************************");
        System.out.println("Altura: " + altura + " mtos");
        if(sexo == MUJER)
        {
            System.out.println("Sexo: MUJER");
        }
        else
        {
            System.out.println("Sexo: HOMBRE");
        }
        System.out.println("Longitud zancada : " + (longitudZancada) + " mtos");
        System.out.println();

    }

    /**
     * Muestra en pantalla información acerca de la distancia recorrida,
     * pasos, tiempo total caminado, ....
     * 
     * (leer enunciado)
     */
    public void printEstadísticas()
    {
        double distanciaSemana = (totalDistanciaSemana / 1000);
        
        System.out.println("Estadisticas");
        System.out.println("***************************");
        System.out.printf("Distancia recorrida toda la semana: %.4f\n",(totalDistanciaSemana / 1000) );
        System.out.printf("Distancia recorrida fin de semana: %.4f\n", (totalDistanciaFinSemana / 1000) );
        System.out.printf("\nNº pasos dias laborables: %d", totalPasosLaborables);
        System.out.printf("\nNº pasos SABADO: %d", totalPasosSabado);
        System.out.printf("\nNº pasos DOMINGO: %d", totalPasosDomingo);
        System.out.printf("\n\nNº de caminatas realizados a partir de las 21:00: %d", caminatasNoche);
        System.out.printf("\n\nTiempo total caminado en la semana: %dh. y %dm.\n", 
                          (tiempo / 60), (tiempo % 60));
    }
    

    /**
     *  Calcula y devuelve un String que representa el nombre del día
     *  en el que se ha caminado más pasos - "SÁBADO"   "DOMINGO" o  "LABORABLES"
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
            res = res.concat(" Laborables");
        }
        
        if(totalPasosSabado == pasosMax)
        {
            res = res.concat(" Sabado");
        }
        
        if(totalPasosDomingo == pasosMax)
        {
            res = res.concat(" Domingo");
        }
         
        return res;
    }
    
    /**
     * Restablecer los valores iniciales del podómetro
     * Todos los atributos se ponen a cero salvo el sexo
     * que se establece a MUJER. La marca no varía
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
        totalDistanciaSemana = 0;
        totalDistanciaFinSemana = 0;
        tiempo = 0;
        caminatasNoche = 0;
    }

}
