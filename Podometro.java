/** 
 * @Donovan Yaguana Bonilla
 */
public class Podometro {
    /** 
     * constantes
     */
    private final char HOMBRE= 'H';
    private final char MUJER = 'M';
    private final double ZANCADA_HOMBRE = 0.45;
    private final double ZANCADA_MUJER  = 0.41;
    private final int SABADO= 6;
    private final int DOMINGO = 7;
    /**
     * atributos
     */
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
     * Inicializar
     */
    public Podometro(String queMarca) 
    {
        marca= queMarca;
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
     */
    public String getMarca() 
    {
        return marca;     
    }

    /**
     *  Configuración metodo
     */
    public void configurar(double queAltura, char queSexo) 
    {
        altura=queAltura;
        sexo=queSexo;
        if (sexo== 'M'){
            longitudZancada= Math.floor( ZANCADA_MUJER *altura)/100.0;
        }
        if (sexo== 'H'){
            longitudZancada= Math.ceil( ZANCADA_HOMBRE *altura)/100.0;
        }
    }

    /**
     *  Estadísticas metodo
     */
    public void registrarCaminata(int pasos, int dia, int horaInicio, int horaFin) 
    {
        switch (dia){
            case 1:

            case 2: 

            case 3: 

            case 4: 

            case 5: totalPasosLaborables += pasos;
                break;

            case 6: totalPasosSabado += pasos;
                break;

            case 7: totalPasosDomingo += pasos;
                break;
        }

        totalDistanciaSemana = ((totalPasosLaborables * longitudZancada)/1000);
        totalDistanciaFinSemana = (((totalPasosSabado + totalPasosDomingo)* longitudZancada)/1000);

        int minutosInicio= horaInicio%100;
        int minutosFinal= horaFin%100;
        int horasInicio= horaInicio/100;
        int horasFinal= horaFin/100;
        int minutosRecorrido;
        int horasRecorrido;

        minutosRecorrido= minutosFinal -minutosInicio;
        horasRecorrido= (horasFinal -horasInicio)*60;

        tiempo= horasRecorrido + minutosRecorrido;
        if (minutosFinal==0){
            horasFinal--;
            minutosFinal = 60;
        }

        if (horaInicio>=2100){
            caminatasNoche++;
        }
    }

    /**
     *  Impreso configuración  
     */
    public void printConfiguracion() {
        System.out.println ("Configuración del podómetro");
        System.out.println ("********************************");
        System.out.println ("Altura: " + altura/100 + " mtos");
        System.out.println ("Sexo: " + sexo);
        System.out.println ("Longitud zancada: " + longitudZancada + " cms");
    }

    /**
     * Impreso estadísticas
     */
    public void printEstadísticas() {
        System.out.println ("Estadistícas");
        System.out.println ("***********************************");
        System.out.println ("Distancia recorrida toda la semana: " 
            +totalDistanciaSemana + " Km");
        System.out.println ("Distancia recorrida fin de semana: " 
            +totalDistanciaFinSemana + " Km");
        System.out.println ("Nº pasos días laborables: "
            + totalPasosLaborables);
        System.out.println ("Nº pasos SÁBADO: " +totalPasosSabado);
        System.out.println ("Nº pasos DOMINGO: " +totalPasosDomingo);
        System.out.println ("Nº caminatas realizadas a partir de las 21h.: "
            + caminatasNoche);
        System.out.println ("Tiempo total caminado en la semana: " + tiempo + " minutos");
        System.out.println ("Día/s con más pasos caminados: " +diaMayorNumeroPasos());
    }

    /**
     *  Método mayor dia de pasos
     */
    public String diaMayorNumeroPasos() 
    {
        if (totalPasosLaborables > totalPasosSabado && totalPasosLaborables>totalPasosDomingo){
            return "LABORABLES";
        } else if (totalPasosLaborables == totalPasosSabado){
            return "LABORABLES" + " y SÁBADO";
        }
        else if (totalPasosLaborables == totalPasosDomingo){
            return "LABORABLES" + " y DOMINGO";
        }
        else if (totalPasosLaborables == totalPasosSabado && totalPasosLaborables == totalPasosDomingo){
            return "LABORABLES," + " SÁBADO" + " y DOMINGO";
        }
        else if (totalPasosSabado > totalPasosLaborables && totalPasosSabado > totalPasosDomingo){
            return "SÁBADO";
        }
        else if (totalPasosSabado == totalPasosDomingo){
            return "SÁBADO" + " y DOMINGO";
        }
        else if (totalPasosDomingo >totalPasosLaborables && totalPasosDomingo>totalPasosSabado){
            return "DOMINGO";
        }
        return diaMayorNumeroPasos();
    }

    /**
     * Reinicio de valores
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
