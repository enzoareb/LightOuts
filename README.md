# Ligths Out

***
La aplicación se  ve orientada a un juego llamado “Lights out”, el mismo consiste en apagar todas las luces de un tablero presionando las diferentes botones presentes en el mismo. La dificultad del juego radica en el hecho de que al presionar un botón, este cambia de estado entre on y off, así como también sus botones adyacentes (arriba, abajo, izquierda, derecha).
***

----------------------------------------------------
### Diseño

Para el desarrollo interfaz gráfica de la aplicación se utilizó la tecnología Window Builder, mediante el uso de la biblioteca Swing proporcionada por Java.
La estructura de la aplicación está conformada por diferentes paquetes que separan las funcionalidades de la misma. De esta manera podemos encontrar un paquete Visual donde se hayan las clases que se encargan de la representación gráfica de la aplicación; un paquete Logica donde se hayan las clases que se encargan de la estructuración lógica del problema que tiene detrás el juego; y un paquete Controlador que posee la clase Controlador que se encarga de enlazar la estructuración lógica con una representación visual.
Adicionalmente se tiene un paquete de recursos llamado Imagenes que posee las imágenes utilizadas para la interfaz visual; y un paquete Main que posee una clase principal para únicamente inicializar la aplicación.

-----------------------------------------------------
### Implementacion

La aplicación consta de 8 clases en diferentes paquetes acorde a su funcionalidad y responsabilidad, manteniendo de esta manera la estructura MVC (Modelo-Vista-Controlador)
Paquete Controlador
Clase Controlador: Se guardan las variables entre la parte lógica y la vista del juego. Se proporcionan métodos de get y set, tanto para que la vista las obtenga, o la lógica los modifique. En este proyecto funciona como intermediario entre ambas partes.
Paquete Logica
Clase Casillero: Es la parte lógica de un BotonVisual que mantiene datos de los botones en el tablero, como su ubicación (filas y columnas) y el estado del mismo.
Clase MainLogico: Se escriben todos los métodos que llevan el juego a cabo. Este se encarga principalmente de inicializar el tablero de juego (matriz cuadrada), de actualizar el estado del tablero y validar la partida. 
Paquete Main
Clase Main: En la clase Main se comienza creando un frame y un fondo, que forman parte de la ventana que configura los aspectos que se quieren para el tablero del juego. Luego el main crea un controlador, para después correr la pantalla en un try/catch.
Paquete Visual
Clase BotonVisual: Es una clase “personalizada” de botón que contiene JButton que se le agrega una fila y columna para poder pasar luego ese dato sin tener que arrastrar el JButton por todas las clases en caso de querer manejar su información.
Clase Fondo: Es una clase que extiende a la clase JPanel, sobreescribiendo métodos de la misma para que se pueda establecer una imagen de fondo en el frame de la aplicación.
Clase MainVisual: Se encarga de inicializar y establecer el frame y el resto de elementos visuales en la ventana.
Clase TableroDeBotones: Se incluyen los métodos donde se llena el tablero de BotonVisual, se setean sus respectivas imágenes acorde al estado lógico del tablero y se administran los eventos de cada uno de los botones.

---------------------------------------------------------------
### Desiciones

En primer lugar, se decidió que la interfaz gráfica de la aplicación ocupara la ventana completamente y que esta mantendría una correlación directa con la parte lógica siendo esta una matriz cuadrada de booleanos, que representan el estado del tablero.
Decidimos también agregar en el título el icono de la aplicación junto con un conteo de los movimientos realizados por el jugador.
Adicionalmente al evento principal impuesto sobre cada botón de cambiar de estado al presionarse, se decidió agregar un evento adicional que cambia la imagen del botón al posar el mouse sobre el mismo. En consecuencia, se decidió que la imagen de un botón encendido sea 5 pixeles más grande que uno apagado, ya que, de esa manera al presionar un botón y este al cambiar su imagen a uno apagado, da la sensación de que realmente está siendo presionado.
Nuestra decisión más importante fue acerca de la implementación de una jugada, ya que, debíamos transmitir desde la interfaz gráfica (ej, presionar un botón) a la parte lógica del programa (ej, actualizar estado del tablero). Esto fue posible gracias a la implementación del controlador que pasa los datos visuales a la lógica por medio del método agregarEventoBoton, más específicamente, en donde se llama al método realizarJugada. Este método llama a actualizarJugadaMatriz del Controlador al que se le pasan la fila y la columna del botón que se presionó, y este a su vez llama a actualizarEstadoTablero del MainLogico que actualiza el estado de la matriz. Una vez actualizada la matriz, el botón adquiere una nueva imagen acorde a la última actualización de la matriz. Esto se realiza por medio del método getEstadoBoton del Controlador que a su vez llama al método getEstadoCasillero del MainLogico que le devuelve el estado del casillero correspondiente a un botón visual. Esquemáticamente responde al siguiente comportamiento: 

--------------------------------------------------------------------

```
USUARIO PRESIONA BOTON --> CONTROLADOR --> ESTADO MATRIZ SE ACTUALIZA --> CONTROLADOR --> TABLERO SE ACTUALIZA
```

De igual manera se implementa las funcionalidades de ganar la partida cuando todos los casilleros de la matriz resultan estar en false, validándose la misma cada vez que se realiza una jugada, mostrando una ventana más pequeña dando el aviso de triunfo e informando la cantidad de movimientos realizados. Nuevamente el Controlador actúa de intermediario entre la parte visual y la lógica. 
