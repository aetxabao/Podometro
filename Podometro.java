/**
 * La clase modela un sencillo pod?metro que registra informaci?n
 * acerca de los pasos, distancia, ..... que una persona
 * ha dado en una semana. 
 * 
 * @author    - Carlos Conde Zudaire - 
 */
public class Podometro{
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
     * Inicializa el pod?metro con la marca indicada por el par?metro.
     * El resto de atributos se ponen a 0 y el sexo, por defecto, es mujer
     */
    public Podometro(String queMarca){
        marca = queMarca;
        altura = 0;
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

    /**
     * accesor para la marca
     *  
     */
    public String getMarca(){
        return marca;
    }

    /**
     * Simula la configuraci?n del pod?metro.
     * Recibe como par?metros la altura y el sexo de una persona
     * y asigna estos valores a los atributos correspondiente.
     * Asigna adem?s el valor adecuado al atributo longitudZancada
     * 
     * (leer enunciado)
     *  
     */
    public void configurar(double queAltura, char queSexo){
        altura = queAltura;
        sexo = queSexo;
        if(sexo == 'H'){
            longitudZancada = Math.ceil(altura*ZANCADA_HOMBRE);
        }
        if(sexo == 'M'){
            longitudZancada = Math.floor(altura*ZANCADA_MUJER);
        }
    }

    /**
     *  Recibe cuatro par?metros que supondremos correctos:
     *    pasos - el n? de pasos caminados
     *    dia - n? de d?a de la semana en que se ha hecho la caminata 
     *              (1 - Lunes, 2 - Martes - .... - 6 - S?bado, 7 - Domingo)
     *    horaInicio ? hora de inicio de la caminata
     *    horaFin ? hora de fin de la caminata
     *    
     *    A partir de estos par?metros el m?todo debe realizar ciertos c?lculos
     *    y  actualizar? el pod?metro adecuadamente  
     *   
     *   (leer enunciado del ejercicio)
     */
    public void registrarCaminata(int pasos, int dia, int horaInicio,
    int horaFin){
        if(horaInicio >= 2100){
            caminatasNoche++;
        }
        switch(dia){
            case DOMINGO:
                totalPasosDomingo = totalPasosDomingo + pasos;
                break;
            case SABADO:
                totalPasosSabado = totalPasosSabado + pasos;
                break;
            default:
                totalPasosLaborables = totalPasosLaborables + pasos;
        }
        if(dia == 6 || dia == 7){
            totalDistanciaFinSemana = (totalDistanciaFinSemana + (pasos*longitudZancada)/100000);
        }
        else{
            totalDistanciaSemana = (totalDistanciaSemana + (pasos*longitudZancada)/100000);
        }
    }

    /**
     * Muestra en pantalla la configuraci?n del pod?metro
     * (altura, sexo y longitud de la zancada)
     * 
     * (ver enunciado)
     *  
     */
    public void printConfiguracion(){
        System.out.println("Configuración del podómetro");
        System.out.println("*********************************");
        System.out.println("Altura: " + altura/100 + " mtos");
        System.out.println("Sexo: " + sexo);
        System.out.println("Longitud zancada: " + longitudZancada/100 + " mtos");
    }

    /**
     * Muestra en pantalla informaci?n acerca de la distancia recorrida,
     * pasos, tiempo total caminado, ....
     * 
     * (leer enunciado)
     *  
     */
    public void printEstadísticas(){
        double totalDistanciaTodaSemana = totalDistanciaSemana + totalDistanciaFinSemana;
        System.out.println("Estadísticas");
        System.out.println("*********************************");
        System.out.println("Distancia recorrida toda la semana: " + totalDistanciaTodaSemana + " Km");
        System.out.println("Distancia recorrida fin de semana: " + totalDistanciaFinSemana + " Km");
        System.out.println();
        System.out.println("Nº pasos días laborables: " + totalPasosLaborables);
        System.out.println("Nº pasos SÁBADO: " + totalPasosSabado);
        System.out.println("Nº pasos DOMINGO: " + totalPasosDomingo);
        System.out.println();
        System.out.println("Nº caminatas realizadas a partir de las 21h: " + caminatasNoche);
        System.out.println();
        System.out.println("Tiempo total caminado en la semana: " + tiempo/60 + "h y " + tiempo%60 + "m");
        System.out.println("Día/s con más pasos caminados: " + diaMayorNumeroPasos());
    }

    /**
     *  Calcula y devuelve un String que representa el nombre del d?a
     *  en el que se ha caminado m?s pasos - "S?BADO"   "DOMINGO" o  "LABORABLES"
     */
    public String diaMayorNumeroPasos(){
        if(totalPasosLaborables > totalPasosSabado && totalPasosLaborables > totalPasosDomingo){
            return "LABORABLES";
        }
        else if(totalPasosSabado > totalPasosLaborables && totalPasosSabado > totalPasosDomingo){
            return "SÁBADO";
        }
        else if(totalPasosDomingo > totalPasosLaborables && totalPasosDomingo > totalPasosSabado){
            return "DOMINGO";
        }
        else if(totalPasosLaborables == totalPasosSabado){
            return "LABORABLES " + " SÁBADO";
        }
        else if(totalPasosLaborables == totalPasosDomingo){
            return "LABORABLES " + " DOMINGO";
        }
        else if(totalPasosSabado == totalPasosDomingo){
            return "SÁBADO " + " DOMINGO";
        }
        else
        {
            return "LABORABLES " + " SÁBADO " + " DOMINGO";
        }
    }

    /**
     * Restablecer los valores iniciales del pod?metro
     * Todos los atributos se ponen a cero salvo el sexo
     * que se establece a MUJER. La marca no var?a
     *  
     */    

    public void reset() {
        altura = 0;
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
