# 12 - Preparciales Java

Solución de tres preparciales de Programación Avanzada (Java / POO), dos prácticas nuevas muy similares y un banco de 200 preguntas teóricas.

## Estructura

| Carpeta | Contenido |
|---|---|
| `Parcial1_Aerolinea/` | Aerolínea: `Vuelo` abstracta, `Nacional`/`Internacional`, excepción verificada, archivo binario y reporte de texto |
| `Parcial2_EstrategiaFantastica/` | Región, personajes (`Dragon`/`Soldado`), `Arma`, excepción por recursos insuficientes, guardado binario y de texto |
| `Parcial3_Profesores/` | `Profesor` abstracta, `ProfesorPlanta`/`ProfesorCatedra`, `Nomina` |
| `Practica1_Clinica/` | Práctica nueva (similar a Aerolínea) con `ENUNCIADO.md` y solución |
| `Practica2_TorneoRobots/` | Práctica nueva (similar a Estrategia Fantástica) con `ENUNCIADO.md` y solución |
| `Teoria_200_Preguntas/` | `Teoria_Java_200_Preguntas.pdf` (200 preguntas con clave de respuestas) y los scripts que lo generan |

Conceptos aplicados: clases y objetos, encapsulamiento, herencia, clases abstractas, polimorfismo, enums, excepciones propias, `ArrayList`, `LocalDate`, archivos de texto y serialización.

## Compilar y ejecutar

Se usa `ñ` en algunos identificadores, por eso se indica la codificación UTF-8.

```bash
cd Java/12-Preparciales/Parcial1_Aerolinea
javac -encoding UTF-8 -d out aerolinea/*.java
java -Dfile.encoding=UTF-8 -cp out aerolinea.InterfazConsola
```

Puntos de entrada:

| Proyecto | Paquete | Clase principal |
|---|---|---|
| Parcial1_Aerolinea | `aerolinea` | `InterfazConsola` |
| Parcial2_EstrategiaFantastica | `estrategia` | `App` |
| Parcial3_Profesores | `profesores` | `App` |
| Practica1_Clinica | `clinica` | `InterfazConsola` |
| Practica2_TorneoRobots | `robots` | `App` |

Los programas generan archivos (`.dat`, `.txt`) en el directorio de ejecución.

## Respuestas de la parte de conceptos

**Aerolínea (2530):** 1 b · 2 b · 3 d · 4 c · 5 d · 6 b · 7 c · 8 b · 9 c · 10 b

**Estrategia Fantástica (2510):** 1 b (Falso) · 2 a (Verdadero) · 3 d* · 4 a · 5 c · 6 c · 7 b · 8 b · 9 d · 10 a

\* La pregunta 3 es ambigua: la respuesta esperada es la d, pero `Throwable` es una clase, no una interfaz.

**Profesores (2022-30):** 1 d · 2 a (Falso) · 3 a (Falso) · 4 b (Verdadero) · 5 b (Polimorfismo) · 6 e · 7 a · 8 c · 9 c · 10 b (Verdadero)

## Regenerar el PDF

```bash
cd Teoria_200_Preguntas
pip install reportlab
python generar_pdf.py
```
