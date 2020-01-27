package model.data_structures;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico <T extends Comparable<T>> implements IArregloDinamico<T> {
		/**
		 * Capacidad maxima del arreglo
		 */
        private int tamanoMax;
		/**
		 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
		 */
        private int tamanoAct;
        /**
         * Arreglo de elementos de tamaNo maximo
         */
        private int elementos[ ];

        /**
         * Construir un arreglo con la capacidad maxima inicial.
         * @param max Capacidad maxima inicial
         */
		public ArregloDinamico( int max )
        {
               elementos = new int[max];
               tamanoMax = max;
               tamanoAct = 0;
        }
        
		public void agregar( int dato )
        {
               if ( tamanoAct == tamanoMax )
               {  // caso de arreglo lleno (aumentar tamaNo)
                    tamanoMax = 2 * tamanoMax;
                    int [ ] copia = elementos;
                    elementos = new int[tamanoMax];
                    for ( int i = 0; i < tamanoAct; i++)
                    {
                     	 elementos[i] = copia[i];
                    } 
            	    System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
               }	
               elementos[tamanoAct] = dato;
               tamanoAct++;
       }

		public int darCapacidad() {
			return tamanoMax;
		}

		public int darTamano() {
			return tamanoAct;
		}

		public int darElemento(int i) {
			// TODO implementar
			
			return elementos[i];
		}

		public int buscar(int dato) {
			// TODO implementar
			// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
			
			for ( int i = 0; i < tamanoAct; i++)
            {
             	 if (elementos[i] == dato)
             	 {
             		 return dato;
             	 }
            } 
			
			return 0;
		}

		public int eliminar(int dato) {
			// TODO implementar
			// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
			
            int [ ] copia = elementos;
            elementos = new int[tamanoAct];
            boolean encontrado = false;
            int e = 0;


			for ( int i = 0; i < tamanoAct; i++)
            {
             	 if (copia[i] != dato)
             	 {
             		 elementos[i-e] = copia[i];
             	 }
             	 else
             	 {
             		 encontrado = true;
             		 e++;
             	 }
            } 
		
			if (encontrado)
		    {
        		tamanoAct--;
				return dato;
			}
			
			return 0;
			
		}


}
