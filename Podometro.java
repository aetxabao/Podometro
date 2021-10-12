/**
 * La clase modela un sencillo pod�metro que registra informaci�n
 * acerca de los pasos, distancia, ..... que una persona
 * ha dado en una semana. 
 * 
 * @author    Sergio  Cobos 
 */
public class Podometro {
    private final char HOMBRE='H';
    private final char MUJER='M';
    private final double ZANCADA_HOMBRE=0.45;
    private final double ZANCADA_MUJER=0.41;
    private final int SABADO=6;
    private final int DOMINGO=7;

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
     * Inicializa el pod�metro con la marca indicada por el par�metro.
     * El resto de atributos se ponen a 0 y el sexo, por defecto, es mujer
     */
    public Podometro(String queMarca) {
        marca = queMarca;
        sexo = MUJER;
        altura = 0;
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
    public String getMarca() {
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
    public void configurar(double queAltura, char queSexo) {
        altura = queAltura;
        sexo = queSexo;
        if(sexo==HOMBRE)
        {
            longitudZancada = Math.ceil(altura*ZANCADA_HOMBRE*100.0)/100.0;
        }
        else if(sexo==MUJER)
        {
            longitudZancada = Math.floor(altura*ZANCADA_MUJER*100.0)/100.0;
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
    int horaFin) {

        if(horaInicio>=2100)
        {
            caminatasNoche++;
        }

        switch(dia)
        {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5: totalPasosLaborables+=pasos;
                break;
            case 6: totalPasosSabado+=pasos;
                break;
            case 7: totalPasosDomingo+=pasos;
        }
        
        totalDistanciaSemana=((totalPasosLaborables+totalPasosSabado+totalPasosDomingo)*longitudZancada)/1000;
        totalDistanciaFinSemana=((totalPasosSabado+totalPasosDomingo)*longitudZancada)/1000;
        
        int hInicio = horaInicio/100;
        int minInicio = horaInicio%100;
        int hFin = horaFin/100;
        int minFin = horaFin%100;
        if(minFin==0)
        {
            minFin = 60;
            hFin--;
        }
        int duracionH = hFin - hInicio;
        int duracionMin = minFin - minInicio;
        tiempo += duracionH*60 +duracionMin;
    }

    /**
     * Muestra en pantalla la configuraci�n del pod�metro
     * (altura, sexo y longitud de la zancada)
     * 
     * (ver enunciado)
     *  
     */
    public void printConfiguracion() {
        System.out.println("Configuraci�n del pod�metro");
        System.out.println("***************************");
        System.out.println("Altura: "+altura+" mtos");
        System.out.println("Sexo: "+sexo);
        System.out.println("Longitud zancada: "+longitudZancada+" mtos");
    }

    /**
     * Muestra en pantalla informaci�n acerca de la distancia recorrida,
     * pasos, tiempo total caminado, ....
     * 
     * (leer enunciado)
     *  
     */
    public void printEstad�sticas() {
        System.out.println("Estad�sticas");
        System.out.println("*************************");
        System.out.println("Distancia recorrida toda la semana: "+totalDistanciaSemana+" Km");
        System.out.println("Distancia recorrida fin de semana: "+totalDistanciaFinSemana+" Km");
        System.out.println();
        System.out.println("N� pasos d�as laborables: "+totalPasosLaborables);
        System.out.println("N� pasos S�BADO: "+totalPasosSabado);
        System.out.println("N� pasos DOMINGO: "+totalPasosDomingo);
        System.out.println();
        System.out.println("N� caminatas realizadas a partir de las 21h: "+caminatasNoche);
        System.out.println();
        System.out.println("Tiempo total caminado en la semana: "+tiempo/60+" horas y "+tiempo%60+" minutos");
        System.out.println("D�a/s con m�s pasos caminados: "+diaMayorNumeroPasos());

    }

    /**
     *  Calcula y devuelve un String que representa el nombre del d�a
     *  en el que se ha caminado m�s pasos - "S�BADO"   "DOMINGO" o  "LABORABLES"
     */
    public String diaMayorNumeroPasos() {
        if(totalPasosLaborables>totalPasosSabado && totalPasosLaborables>totalPasosDomingo)
        {
            return "LABORABLES";
        }
        else if(totalPasosSabado>totalPasosLaborables && totalPasosSabado>totalPasosDomingo)
        {
            return "S�BADO";
        }
        else if(totalPasosDomingo>totalPasosLaborables && totalPasosDomingo>totalPasosSabado)
        {
            return "DOMINGO";
        }
        else if(totalPasosLaborables==totalPasosSabado)
        {
            return "LABORABLES" + " S�BADO";
        }
        else if(totalPasosLaborables==totalPasosDomingo)
        {
            return "LABORABLES" + " DOMINGO";
        }
        else if(totalPasosSabado==totalPasosDomingo)
        {
            return "S�BADO" + " DOMINGO";
        }
        else 
        {
            return "LABORABLES" + " S�BADO" + " DOMINGO";
        }
    }

    /**
     * Restablecer los valores iniciales del pod�metro
     * Todos los atributos se ponen a cero salvo el sexo
     * que se establece a MUJER. La marca no var�a
     *  
     */    
    public void reset() {
        sexo = MUJER;
        altura = 0;
        longitudZancada = 0;
        totalPasosLaborables = 0;
        totalPasosSabado = 0;
        totalPasosDomingo = 0;
        totalDistanciaSemana = 0;
        totalDistanciaFinSemana = 0;
        caminatasNoche = 0;
        tiempo = 0;
    }

}
