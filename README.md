Trabajo Práctico Anual Profesor: Macrino/Weingand
Materia: Programación avanzada Universidad Del Salvador – Sede Pilar

Trabajo Práctico Anual

Se solicita el desarrollo del presente software en base a las condiciones y requisitos a continuación
descriptos, el mismo podrá ser realizado de manera grupal de no más de 4 integrantes con el uso de
repositorio, con entrega obligatoria.
● Las fechas de entregas parciales y final serán informadas durante el transcurso de la cursada.
Requerimiento:
Elaborar un sistema con una interfaz gráfica y siguiendo el patrón de diseño DAO y MVC que permita
realizar las 4 acciones básicas de Alta, Baja, Modificación y Consulta sobre los objetos persistibles
para el servicio de una aerolínea.
El propósito del sistema es un aplicativo que permita:
1) Registrar, Modificar, Eliminar y Consultar clientes.
2) Registrar, Modificar, Eliminar y Consultar líneas aéreas (“proveedores”, serán las que
emitirán los vuelos y cada línea podrá tener 0 o más vuelos asignados).
3) Registrar, Modificar, Eliminar y Consultar vuelos.
4) Registrar, Modificar, Eliminar y Consultar ventas (es la relación entre un cliente y un
vuelo).
5) El objeto de intercambio dentro del sistema serán los vuelos (productos), un cliente podrá
tener 0 o más vuelos asignados, y un vuelo podrá tener 0 a N (siendo N la cantidad máxima
de asientos para ese vuelo) asignados.

Objetos persistibles:
Cliente:
⮚ Nombre y Apellido (String)
⮚ DNI (String)
⮚ Pasaporte (Objeto Pasaporte)
● Número de pasaporte (String)
● País de Emisión (ver restricciones)
● Autoridad de Emisión (String)
● Fecha de Emisión (Date)
● Fecha de Vencimiento (Date)
⮚ CUIT /CUIL (String)
⮚ Fecha de Nacimiento (Date)
⮚ E-mail (String)
⮚ Teléfono (Objeto teléfono)
● Número personal (String)
● Número celular (String)
● Número laboral (String)

Trabajo Práctico Anual Profesor: Macrino/Weingand
Materia: Programación avanzada Universidad Del Salvador – Sede Pilar
⮚ Número de pasajero frecuente (Objeto PasajeroFrecuente)
● Alianza (ver restricciones)
● Aerolínea (ver restricciones)
● Número (String)
● Categoría (String)
⮚ Dirección completa (Objeto Dirección)
● Calle (String)
● Altura (String)
● Ciudad (String)
● Provincia (ver restricciones)
● País (ver restricciones)
● Código postal (String)

Líneas Aéreas:
⮚ Nombre aerolínea (String)
⮚ Alianza (ver restricciones)
⮚ Vuelos
Vuelos:
⮚ Número de vuelo (ver restricciones)
⮚ Cantidad de asientos (Integer)
⮚ Aeropuerto de salida (Objeto Aeropuerto)
● Identificación del aeropuerto (String) – (Ver restricciones)
● Ciudad (String)
● Provincia (Ver restricciones)
● País (ver restricciones)
⮚ Aeropuerto de llegada (Objeto Aeropuerto)
⮚ Fecha y hora de salida (Date)
⮚ Fecha y hora de llegada (Date)
⮚ Tiempo de vuelo (String)
Ventas:
⮚ Cliente
⮚ Vuelo
⮚ Aerolínea
⮚ Fecha y hora de venta (Date)
⮚ Forma de pago (String) – (Ver restricciones)

Trabajo Práctico Anual Profesor: Macrino/Weingand
Materia: Programación avanzada Universidad Del Salvador – Sede Pilar
Restricciones:
1) Se deberá tener una tabla paramétrica de “países” con la lista de todos los países
existentes, más la palabra “otro” al final de la tabla.
2) Se deberá tener un archivo de texto “provincias.txt” con la lista de todas las provincias de
la República Argentina.
3) Se deberá contar con la información de todas las alianzas aéreas posibles
(https://www.infoviajera.com/2015/08/listado-de-alianzas-de-aerolineas-actualizado/).
4) Se deberá contar con una tabla paramétrica de “aerolíneas” con la lista de todas las
aerolíneas posibles.
5) Toda tabla paramétrica, podrá ser administrada desde un perfil administrador
únicamente.
Restricciones del sistema:
1) La existencia de un asiento libre antes de realizarse la venta.
2) Se deberá validar antes de realizar una venta que la fecha de emisión del pasaporte sea
ANTERIOR a la fecha del día de la venta y se deberá validar que la fecha de vencimiento sea
por lo menos 6 meses posterior a la fecha de finalización del vuelo.
3) Existe solo una categoría de asiento (económica)
4) Todos los vuelos son one-way es decir, un solo tramo de ida.
5) Se deberá validar que al momento de iniciar el vuelo, el cliente tenga más de 18 años de
edad.
6) En todos los casos que se requiera seleccionar un país se deberá utilizar un menú
desplegable completado con la lista de países del archivo antes mencionado, en el caso de
seleccionar “otro” deberá mostrar un campo de texto para ingresar el país no existente en la
lista.
7) Cuando se seleccione Argentina como país deberá mostrar un menú desplegable con las
provincias del archivo de texto, si el país fuera otro diferente a Argentina deberá mostrar un
campo de texto para incluir la provincia/estado.
8) La alianza aérea deberá ser una de las incluidas.
9) La aerolínea deberá ser una de las incluidas en la tabla paramétrica.
10) Los números de vuelo deberán formarse como:
a. Las primeras 2 letras del nombre de la aerolínea, en el caso que sea un nombre
compuesto (Ej. Aerolíneas Argentinas) se formará con la primer letra de los primeras
2 palabras (en el ejemplo: AA)
b. Un guion medio (-)
c. El valor número del número con una longitud de 4 dígitos
d. Ejemplo: AR-1234
11) La identificación del aeropuerto serán 3 letras.
(http://www.genteparaviajar.com/aeropuertos.html)
12) La forma de pago podrá ser “Contado efectivo” o “Tarjeta de Crédito/Débito”, si la forma
de pago es con tarjeta de crédito el mismo puede ser en cuotas 3-6 (sin interés), 12 o 24 (con
un 10% de interés).
13) Durante el primer cuatrimestre se deberá almacenar toda la información de los objetos
persistibles en archivos de texto individuales por cada objeto.
14) Durante el segundo cuatrimestre se introducirá la persistencia en base de datos y
frameworks de desarrollo.
15) Se deberá poder filtrar los objetos de acuerdo a lo especificado para cada objeto.
16) Se deberá validar que cuando se ingrese un valor que no corresponde con el campo, el
sistema devuelva el error correspondiente.
17) El sistema deberá llevar el control para no sobrevender vuelos.

Trabajo Práctico Anual Profesor: Macrino/Weingand
Materia: Programación avanzada Universidad Del Salvador – Sede Pilar
18) En caso de alguna acción de anomalía el sistema deberá manejar las mismas sin
problema alguno hacia el comportamiento de los datos, asegurando la calidad de los mismos
y mostrando siempre al usuario un error por pantalla que informe el fallo y los posibles
datos de error.

IMPORTANTE:
✔ Las restricciones del sistema podrán ser modificadas con el correr de la cursada para
agregarle/quitarle complejidad al sistema de acuerdo al grado de avance del mismo y, en
caso de ser requerida una modificación, será discutido en clases.
✔ Quien falle la fecha de entrega parcial, tendrá 1 semana de tiempo extra.
✔ La fecha de entrega final es impostergable y en caso de no cumplirla perderá la condición de
regular y recursará la materia.
Suerte y ¡manos a la obra!
