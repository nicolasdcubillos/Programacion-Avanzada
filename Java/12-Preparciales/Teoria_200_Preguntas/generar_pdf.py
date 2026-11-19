"""Genera Teoria_Java_200_Preguntas.pdf a partir de preguntas.py.

Uso: python generar_pdf.py   (requiere reportlab)
"""
import random
import re
from pathlib import Path

from reportlab.lib import colors
from reportlab.lib.pagesizes import A4
from reportlab.lib.styles import ParagraphStyle, getSampleStyleSheet
from reportlab.lib.units import cm
from reportlab.platypus import (KeepTogether, PageBreak, Paragraph,
                                SimpleDocTemplate, Spacer)

from preguntas import TEMAS

SALIDA = Path(__file__).with_name("Teoria_Java_200_Preguntas.pdf")
LETRAS = "abcd"


def fmt(texto):
    texto = texto.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;")
    return re.sub(r"`([^`]*)`", r'<font name="Courier">\1</font>', texto)


def construir():
    rng = random.Random(2025)
    estilos = getSampleStyleSheet()
    titulo = ParagraphStyle("t", parent=estilos["Title"], fontSize=24, spaceAfter=14)
    sub = ParagraphStyle("s", parent=estilos["Normal"], fontSize=12, alignment=1, spaceAfter=6)
    h1 = ParagraphStyle("h1", parent=estilos["Heading1"], fontSize=16, spaceBefore=10,
                        spaceAfter=8, textColor=colors.HexColor("#1f3a5f"))
    preg = ParagraphStyle("p", parent=estilos["Normal"], fontSize=10.5, leading=14,
                          fontName="Helvetica-Bold", spaceBefore=6)
    opc = ParagraphStyle("o", parent=estilos["Normal"], fontSize=10, leading=13, leftIndent=18)
    resp = ParagraphStyle("r", parent=estilos["Normal"], fontSize=9.5, leading=12.5, spaceAfter=3)

    preguntas, claves = [], []
    n = 0
    for nombre, items in TEMAS:
        preguntas.append(("tema", nombre))
        claves.append(("tema", nombre))
        for texto, correcta, incorrectas, expl in items:
            n += 1
            opciones = [correcta] + list(incorrectas)
            if correcta in ("Verdadero", "Falso"):
                opciones = ["Verdadero", "Falso"]
            else:
                rng.shuffle(opciones)
            letra = LETRAS[opciones.index(correcta)]
            preguntas.append(("q", n, texto, opciones))
            claves.append(("a", n, letra, correcta, expl))
    assert n == 200, n

    historia = [Spacer(1, 6 * cm),
                Paragraph("Banco de 200 preguntas teóricas de Java", titulo),
                Paragraph("Programación Avanzada — Programación orientada a objetos", sub),
                Paragraph("Clases y objetos · Excepciones · Archivos · Colecciones · Herencia · "
                          "Polimorfismo · Interfaces · Enums · UML", sub),
                Spacer(1, 1 * cm),
                Paragraph("Primero aparecen las 200 preguntas (selección múltiple y verdadero/falso) "
                          "y al final la clave de respuestas con una breve explicación.", sub),
                PageBreak()]

    for item in preguntas:
        if item[0] == "tema":
            historia.append(Paragraph(fmt(item[1]), h1))
        else:
            _, i, texto, opciones = item
            bloque = [Paragraph(f"{i}. {fmt(texto)}", preg)]
            for k, o in enumerate(opciones):
                bloque.append(Paragraph(f"{LETRAS[k]}) {fmt(o)}", opc))
            historia.append(KeepTogether(bloque))
    historia.append(PageBreak())
    historia.append(Paragraph("Clave de respuestas", titulo))
    for item in claves:
        if item[0] == "tema":
            historia.append(Paragraph(fmt(item[1]), h1))
        else:
            _, i, letra, correcta, expl = item
            historia.append(Paragraph(
                f"<b>{i}. {letra})</b> {fmt(correcta)} — <i>{fmt(expl)}</i>", resp))

    def pie(canvas, doc):
        canvas.setFont("Helvetica", 8)
        canvas.drawCentredString(A4[0] / 2, 1.2 * cm, f"Java — 200 preguntas teóricas · página {doc.page}")

    SimpleDocTemplate(str(SALIDA), pagesize=A4, leftMargin=2 * cm, rightMargin=2 * cm,
                      topMargin=2 * cm, bottomMargin=2 * cm,
                      title="200 preguntas teóricas de Java",
                      author="Programación Avanzada").build(historia, onFirstPage=pie, onLaterPages=pie)
    print("PDF generado:", SALIDA)


if __name__ == "__main__":
    construir()
