# Mutante
Proyecto que determina si una persona en es mutante a traves de su ADN

<h1> #Configuracion entorno de desarrollo local </h1>

Importar el proyecto dentro del IDE de desarrollo.

Ejecutar el comando: <em> mvn clean install </em> dentro de la carpeta raiz del proyecto.

Una vez que finaliza el build con éxito procederemos a levantar el proyecto con Springboot:

      -Primero instalar dentro del IDE el pluggin de Spring Tool 4 (Eclipse IDE --> Help --> Eclipse Marketplace --> Buscas Spring tool 4 --> click en install).
      -reiniciamos el IDE.
      -Una vez instalado el pluggin, hacemos click derecho sobre el proyecto --> Run As --> Spring Boot App.

Para saber que se ejecuto de forma correcta y levanto bien mostrara el siguiente mensaje:

"La aplicación está corriendo en el puerto: 8080" ( <em> puerto configurado localmente </em>).

<h1> #Configuracion de APIs </h1>

Instalamos postman desde <em> https://www.postman.com/downloads/ </em>

Levantar el proyecto localmente (pasos anteriormente explicados).

Una vez dentro de la aplicacion Postman: 
          
      -Creamos el entorno de pruebas:  New --> HTTP Request --> Seleccionamos una peticion de tipo POST--> colocamos esta url: http://localhost:8080/mutant .
      -Luego hacemos click en body --> seleccionamos raw --> copiamos y pegamos este JSON de ejemplo:
            {
                  "dna":["IRIIDD","BBBCCC","FFFGGG","HHHJJJ","IIIOOO","YYYUUU"]
            }
      -Apretamos SEND y en caso de ser mutante debe devolver 200 OK y en caso de ser humano 403-Forbidden.

Lo mismo para saber los datos de la peticion <em>/stats</em>  :

      -Creamos el entorno de pruebas:  New --> HTTP Request --> Seleccionamos una peticion de tipo GET--> colocamos esta url: http://localhost:8080/stats .
      -Luego hacemos click en body --> none.
      -Apretamos SEND y debe devolvernos estos datos a modo de ejemplo:
            {
                "count_human_dna": 3,
                "count_mutant_dna": 5,
                "ratio": 1.0
            }

<h1> #Configuracion de base de datos </h1>

La base de datos es MySql y los datos para acceder a la misma son:
      
      -HOST: 127.0.0.1
      -PORT: 3336
      -USERNAME: root
      -PASSWORD: admin123

