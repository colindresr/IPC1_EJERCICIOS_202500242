Algoritmo PiramideAsteriscos
    Definir num, i, j Como Entero
    
    Escribir "Ingrese el número de niveles de la pirámide:"
    Leer num
    
    Si num <= 0 Entonces
        Escribir "Error: El número de niveles debe ser mayor a 0"
    SiNo

        Para i <- 1 Hasta num Con Paso 1 Hacer

            Para j <- 1 Hasta (num - i) Con Paso 1 Hacer
                Escribir Sin Saltar " "
            FinPara
            
            Para j <- 1 Hasta (2 * i - 1) Con Paso 1 Hacer
                Escribir Sin Saltar "*"
            FinPara
            
            Escribir ""
        FinPara
    FinSi
FinAlgoritmo