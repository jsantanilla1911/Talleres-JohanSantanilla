package uniandes.dpoo.estructuras.logica;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre arreglos de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos arregloEnteros y arregloCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre arreglos (ie., no haga cosas como construir listas para evitar la manipulación de arreglos).
 */
public class SandboxArreglos
{
    /**
     * Un arreglo de enteros para realizar varias de las siguientes operaciones.
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private int[] arregloEnteros;

    /**
     * Un arreglo de cadenas para realizar varias de las siguientes operaciones
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private String[] arregloCadenas;

    /**
     * Crea una nueva instancia de la clase con los dos arreglos inicializados pero vacíos (tamaño 0)
     */
    public SandboxArreglos( )
    {
        arregloEnteros = new int[]{};
        arregloCadenas = new String[]{};
    }

    /**
     * Retorna una copia del arreglo de enteros, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de enteros
     */
    public int[] getCopiaEnteros()
    {
    	int[] arregloCopia = arregloEnteros.clone();
        return arregloCopia;
    }

    /**
     * Retorna una copia del arreglo de cadenas, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de cadenas
     */
    public String[] getCopiaCadenas( )
    {
    	String[] arregloCopia = arregloCadenas.clone();
        return arregloCopia;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de enteros
     * @return
     */
    public int getCantidadEnteros( )
    {
    	int retorno = arregloEnteros.length;
        return retorno;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de cadenas
     * @return
     */
    public int getCantidadCadenas( )
    {
    	int retorno = arregloCadenas.length;
        return retorno;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param entero El valor que se va a agregar.
     */
    public void agregarEntero( int entero )
    {
    	int[] arregloNuevo = new int[arregloEnteros.length + 1];
    	for(int i = 0; i < arregloEnteros.length; i++) {
    		arregloNuevo[i] = arregloEnteros[i];
    	}
    	arregloNuevo[arregloNuevo.length - 1]= entero;
    	arregloEnteros = arregloNuevo;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena( String cadena )
    {
    	String[] arregloNuevo = new String[arregloCadenas.length + 1];
    	for(int i = 0; i < arregloCadenas.length; i++) {
    		arregloNuevo[i] = arregloCadenas[i];
    	}
    	arregloNuevo[arregloNuevo.length - 1]= cadena;
    	arregloCadenas = arregloNuevo;
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de enteros
     * @param valor El valor que se va eliminar
     */
    public void eliminarEntero( int valor )
    {
    	int cantidad = 0;
    	for(int entero: arregloEnteros) {
    		if (entero != valor) {
    			cantidad ++;
    		}
    		
    	}
    	int[] arregloNuevo = new int [cantidad];
    	for (int entero: arregloEnteros) {
    		for (int i = 0; i < arregloNuevo.length; i++) {
    			if (entero != valor) {
    				arregloNuevo[i] = entero;
    			}
    		}
    		
    	}
    	arregloEnteros = arregloNuevo;
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {
    	 {
    	    	int cantidad = 0;
    	    	for(String valor: arregloCadenas) {
    	    		if (valor != cadena) {
    	    			cantidad ++;
    	    		}
    	    		
    	    	}
    	    	String[] arregloNuevo = new String [cantidad];
    	    	for (String valor: arregloCadenas) {
    	    		for (int i = 0; i < arregloNuevo.length; i++) {
    	    			if (valor != cadena) {
    	    				arregloNuevo[i] = valor;
    	    			}
    	    		}
    	    		
    	    	}
    	    	arregloCadenas = arregloNuevo;
    	    }
    }

    /**
     * Inserta un nuevo entero en el arreglo de enteros.
     * 
     * @param entero El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en el arreglo aumentado. Si la posición es menor a 0, se inserta el valor en la primera posición. Si la
     *        posición es mayor que el tamaño del arreglo, se inserta el valor en la última posición.
     */
    public void insertarEntero( int entero, int posicion )
    {
    	if (posicion < 0){
    		posicion = 0;
    	}
    	if (posicion >= arregloEnteros.length) {
    		agregarEntero(entero);
    	}
    	else {
    		int anterior = arregloEnteros[posicion];
    		arregloEnteros[posicion] = entero;
    		for(int i = posicion + 1; i< arregloEnteros.length; i++) {
    			int temp = arregloEnteros[i];
    			arregloEnteros[i] = anterior;
    			anterior = temp;
    		}
    		agregarEntero(anterior);
    	}
    	
    }

    /**
     * Elimina un valor del arreglo de enteros dada su posición.
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si el parámetro posicion no corresponde a ninguna posición del arreglo de enteros, el método
     *        no debe hacer nada.
     */
    /*public void eliminarEnteroPorPosicion( int posicion)
    {
    	if (posicion < 0 || posicion >= arregloEnteros.length) {return;}
    	for(int i = posicion ; i< arregloEnteros.length -1; i++) {
    			arregloEnteros[i] = arregloEnteros[i+1];
    		}
    	arregloEnteros[arregloEnteros.length - 1] = Integer.MIN_VALUE;
    	eliminarEntero(Integer.MIN_VALUE);
    }*/
    public void eliminarEnteroPorPosicion(int posicion) {
        if (posicion < 0 || posicion >= arregloEnteros.length) {
            return;
        }

        int[] nuevo = new int[arregloEnteros.length - 1];

        
        for (int i = 0; i < posicion; i++) {
            nuevo[i] = arregloEnteros[i];
        }

        
        for (int i = posicion; i < nuevo.length; i++) {
            nuevo[i] = arregloEnteros[i + 1];
        }

        arregloEnteros = nuevo;
    }

    /**
     * Reinicia el arreglo de enteros con los valores contenidos en el arreglo del parámetro 'valores' truncados.
     * 
     * Es decir que si el valor fuera 3.67, en el nuevo arreglo de enteros debería quedar el entero 3.
     * @param valores Un arreglo de valores decimales.
     */
    public void reiniciarArregloEnteros( double[] valores )
    {
    	int[] arregloNuevo = new int[valores.length];
    	for(int i = 0; i < valores.length; i++) {
    		arregloNuevo[i] = (int) valores[i];
    	}
    	arregloEnteros = arregloNuevo;
    }

    /**
     * Reinicia el arreglo de cadenas con las representaciones como Strings de los objetos contenidos en el arreglo del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Un arreglo de objetos
     */
    public void reiniciarArregloCadenas( Object[] objetos )
    {
    	String[] arregloNuevo = new String[objetos.length];
    	for(int i = 0; i < objetos.length; i++) {
    		arregloNuevo[i] =  objetos[i].toString();
    	}
    	arregloCadenas = arregloNuevo;
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos( )
    {
    	for(int i = 0; i <arregloEnteros.length; i ++) {
    		if(arregloEnteros[i] < 0) {
    			arregloEnteros[i] = arregloEnteros[i] * -1;
    		}
    		
    	}
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores queden organizados de menor a mayor.
     */
    public void organizarEnteros( )
    {
    	
    	for(int i = 0; i < arregloEnteros.length; i ++) {
    		int menor = arregloEnteros[i];
    		int posmenor = i;
    		for (int j = i; j< arregloEnteros.length; j++) {
    			if (arregloEnteros[j] < menor) {
    				menor = arregloEnteros[j];
    				posmenor = j;
    			}
    		arregloEnteros[posmenor] = arregloEnteros[i];
    		arregloEnteros[i] = menor;
    			
    		}
    		
    	}
    }

    /**
     * Modifica el arreglo de cadenas para que todos los valores queden organizados lexicográficamente.
     */
    public void organizarCadenas( )
    {
    	for(int i = 0; i < arregloCadenas.length; i ++) {
    		
    		String menor = arregloCadenas[i];
    		int posmenor = i;
    		for (int j = i; j< arregloCadenas.length; j++) {
    			
    			if (arregloCadenas[j].compareTo(menor) < 0) {
    				menor = arregloCadenas[j];
    				posmenor = j;
    			}
    		arregloCadenas[posmenor] = arregloCadenas[i];
    		arregloCadenas[i] = menor;
    			
    		}
    		
    	}
    }

    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en el arreglo de enteros
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones( int valor )
    {
    	int cantidad = 0;
    	for (int entero: arregloEnteros) {
    		if(entero == valor) {cantidad ++;}
    	}
        return cantidad;
    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en el arreglo de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones( String cadena )
    {
    	int cantidad = 0;
    	for (String cad: arregloCadenas) {
    		if(cad.equalsIgnoreCase(cadena)) {cantidad ++;}
    	}
        return cantidad;
    }

    /**
     * Busca en qué posiciones del arreglo de enteros se encuentra el valor que se recibe en el parámetro
     * @param valor El valor que se debe buscar
     * @return Un arreglo con los números de las posiciones del arreglo de enteros en las que se encuentra el valor buscado. Si el valor no se encuentra, el arreglo retornado
     *         es de tamaño 0.
     */
    public int[] buscarEntero( int valor )
    {
    	int cantidad = contarApariciones(valor);
    	int[] retorno = new int[cantidad];
    	if (cantidad == 0) {return retorno;}
    	int anteriorAparicion = 0;
    	for (int j = 0; j < retorno.length; j++) {
    		for (int i = anteriorAparicion; i<arregloEnteros.length; i++) {
            	if(arregloEnteros[i] == valor) {
            		retorno[j] = i;
            		anteriorAparicion = i+1;
            		break;
            	}
    		}       	
        }
    	return retorno;
    }

    /**
     * Calcula cuál es el rango de los enteros (el valor mínimo y el máximo).
     * @return Un arreglo con dos posiciones: en la primera posición, debe estar el valor mínimo en el arreglo de enteros; en la segunda posición, debe estar el valor máximo
     *         en el arreglo de enteros. Si el arreglo está vacío, debe retornar un arreglo vacío.
     */
    public int[] calcularRangoEnteros( )
    {
    	int[] retorno = new int[2];
    	if (arregloEnteros.length == 0) {
    		retorno = new int[0]; //Forzamos que el arreglo retorne vacio
    		return retorno;
    	}
    	else {
    		
    		int menor = arregloEnteros[0];
    		int mayor = arregloEnteros[0];
    		for(int i = 0; i<arregloEnteros.length; i++ ) {
    			if (arregloEnteros[i] < menor) {
    				menor = arregloEnteros[i];
    			}
    			if (arregloEnteros[i] > mayor) {
    				mayor = arregloEnteros[i];
    			}
    		
    		
    		}
    		retorno[0] = menor;
    		retorno[1] = mayor;
    		return retorno;
    	}
        
    }

    /**
     * Calcula un histograma de los valores del arreglo de enteros y lo devuelve como un mapa donde las llaves son los valores del arreglo y los valores son la cantidad de
     * veces que aparece cada uno en el arreglo de enteros.
     * @return Un mapa con el histograma de valores.
     */
    public HashMap<Integer, Integer> calcularHistograma( )
    {
        
        return Histograma(arregloEnteros);
    }
    
    public HashMap<Integer, Integer> Histograma(int[] arreglo)
    {
        HashMap<Integer, Integer> retorno = new HashMap<Integer, Integer>();
        for (int entero : arreglo) {
        	if (retorno.containsKey(entero)){
        		int valor = retorno.get(entero);
        		retorno.put(entero, valor + 1);
        	}
        	retorno.putIfAbsent(entero, 1);
        }
        return retorno;
    }

    /**
     * Cuenta cuántos valores dentro del arreglo de enteros están repetidos.
     * @return La cantidad de enteos diferentes que aparecen más de una vez
     */
    
    public int contarEnterosRepetidos( )
    {
    	int cantidad = 0;
    	HashMap<Integer, Integer> mapa = calcularHistograma();
    	for(Map.Entry<Integer, Integer> pareja : mapa.entrySet()) {
    		int valor = pareja.getValue();
    		if (valor > 1) {
    			cantidad ++;
    		}
    	}	
        return cantidad;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica si son iguales, es decir que contienen los mismos elementos exactamente en el mismo orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los arreglos son idénticos y false de lo contrario
     */
    public boolean compararArregloEnteros( int[] otroArreglo )
    {
    	if (arregloEnteros.length != otroArreglo.length) {return false;}
    	else {
    		for (int i = 0; i < arregloEnteros.length; i++) {
    			if (arregloEnteros[i] != otroArreglo[i]) {
    				return false;
    			}
    		}
    	}
        return true;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica que tengan los mismos elementos, aunque podría ser en otro orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos en los dos arreglos son los mismos
     */

    
    public boolean mismosEnteros( int[] otroArreglo )
    {
    	HashMap <Integer, Integer> elementosOtro = Histograma(otroArreglo); 
    	HashMap <Integer, Integer> elementosEnteros = calcularHistograma();
    	Set<Integer> elem1 = new TreeSet<Integer>(elementosOtro.keySet());//sacamos los valores presentes en ambos arreglos con un keySet
    	Set<Integer> elem2 = new TreeSet<Integer>(elementosEnteros.keySet());
    	return elem1.equals(elem2); //Comparamos
    }

    /**
     * Cambia los elementos del arreglo de enteros por una nueva serie de valores generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando Math.random().
     * 
     * Los números en el arreglo deben quedar entre el valor mínimo y el máximo.
     * @param cantidad La cantidad de elementos que debe haber en el arreglo
     * @param minimo El valor mínimo para los números generados
     * @param maximo El valor máximo para los números generados
     */
    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
    	int[] arregloNuevo = new int[cantidad];
    	for (int i = 0; i < cantidad;i++) {
    		arregloNuevo[i] =  minimo + (int)(Math.random() * ((maximo - minimo)+1));
    	}
    	arregloEnteros = arregloNuevo;
    }

};
