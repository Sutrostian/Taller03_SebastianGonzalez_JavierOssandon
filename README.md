# 🧙Taller 3 - Programación Orientada a Objetos

**Carrera:** Ingeniería Civil Industrial
**Universidad:** Universidad Católica del Norte (UCN)

---

## Descripción del Proyecto

Este proyecto corresponde al Taller 3 de Programación Orientada a Objetos (POO) y consiste en el desarrollo de un sistema de gestión de magos y hechizos utilizando los principios fundamentales de la orientación a objetos.

El sistema permite administrar magos y distintos tipos de hechizos, considerando herencia, polimorfismo, interfaces, clases abstractas y persistencia de datos mediante archivos de texto.

### Funcionalidades principales

* Crear magos.
* Crear hechizos.
* Buscar magos y hechizos.
* Modificar magos y hechizos.
* Eliminar magos y hechizos.
* Asignar hechizos a magos.
* Quitar hechizos de magos.
* Mostrar información de magos y hechizos.
* Guardar y cargar información desde archivos de texto.
* Calcular el puntaje total de un mago según los hechizos que posee.

### Tipos de hechizos implementados

* HechizoFuego
* HechizoTierra
* HechizoPlanta
* HechizoAgua

---

## Integrantes

| Nombre                   | RUT          | Carrera                     | GitHub      |
| ------------------------ | ------------ | --------------------------- | ----------- |
| Sebastián Gonzalez Rossi | 21.186.016-2 | Ingeniería Civil Industrial | @Sutrostian |
| Javier Ossandón Calderón | 21.979.689-7 | Ingeniería Civil Industrial | @itsvoiiid  |

---

## Estructura del Proyecto

### Paquete `domain`

Contiene las entidades principales del sistema.

#### Hechizo (Clase Abstracta)

Clase base para todos los tipos de hechizos.

**Atributos:**

* nombreHechizo
* tipo
* dano

#### HechizoFuego

Hereda de Hechizo.

**Atributos:**

* duracionQuemadura

#### HechizoTierra

Hereda de Hechizo.

**Atributos:**

* mejoraDefensa

#### HechizoPlanta

Hereda de Hechizo.

**Atributos:**

* duracionStun
* cantPlantas

#### HechizoAgua

Hereda de Hechizo.

**Atributos:**

* cantidadHeal
* presionAgua

#### Mago

Representa a los magos registrados en el sistema.

**Atributos:**

* nombreMago
* hechizos

#### ICalcularP

Interfaz encargada de definir el método para calcular el puntaje de un hechizo.

---

### Paquete `logic`

Contiene la lógica de negocio del sistema.

#### ISistema

Interfaz que define las operaciones disponibles para la administración de magos y hechizos.

#### SistemaI

Clase que implementa la interfaz ISistema y administra:

* Magos.
* Hechizos.
* Persistencia de datos.
* Búsquedas.
* Modificaciones.
* Eliminaciones.
* Cálculo de puntajes.

---

## Relaciones Principales

* SistemaI implementa la interfaz ISistema.
* Hechizo implementa la interfaz ICalcularP.
* HechizoFuego hereda de Hechizo.
* HechizoTierra hereda de Hechizo.
* HechizoPlanta hereda de Hechizo.
* HechizoAgua hereda de Hechizo.
* SistemaI administra múltiples Magos.
* SistemaI administra múltiples Hechizos.
* Un Mago puede utilizar múltiples Hechizos.

---

## Persistencia de Datos

El sistema utiliza archivos de texto para almacenar información.

### Hechizos.txt

Contiene la información de todos los hechizos registrados en el sistema.

### Magos.txt

Contiene la información de todos los magos registrados y los hechizos asociados a cada uno.

---

## Instrucciones de Ejecución

### Requisitos

* Java JDK 8 o superior.
* Eclipse IDE (recomendado).

### Ejecución

1. Clonar el repositorio:

```bash
git clone [URL_DEL_REPOSITORIO]
```

2. Importar el proyecto en Eclipse.

3. Verificar que los archivos:

```text
Hechizos.txt
Magos.txt
```

se encuentren en la raíz del proyecto.

4. Ejecutar la clase principal del sistema.

5. Utilizar las opciones disponibles para gestionar magos y hechizos.

---

## Diagramas UML

El repositorio incluye:

* Diagrama de Clases UML.
* Modelo de Dominio.

Los diagramas representan la estructura completa del sistema, incluyendo clases, interfaces, herencia, agregaciones y multiplicidades.

---

## Tecnologías Utilizadas

* Java
* Programación Orientada a Objetos (POO)
* UML
* Eclipse IDE
* Archivos de Texto para Persistencia de Datos
