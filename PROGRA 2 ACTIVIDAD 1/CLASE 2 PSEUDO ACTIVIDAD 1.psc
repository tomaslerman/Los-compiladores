Proceso Actividad1_Pila
	Dimension pila[10]
	Definir cantidad, opcion, valor Como Entero
	
	cantidad <- 0
	
	Repetir
		
		Escribir "------ MENU PILA ------"
		Escribir "1. Apilar"
		Escribir "2. Desapilar"
		Escribir "3. Ver Tope"
		Escribir "4. Ver si esta vacia"
		Escribir "5. Salir"
		
		Leer opcion
		
		Segun opcion Hacer
			
			1:
				Escribir "Ingrese valor a apilar:"
				Leer valor
				
				Si cantidad < 10 Entonces
					cantidad <- cantidad + 1
					pila[cantidad] <- valor
				SiNo
					Escribir "La pila esta llena"
				FinSi
				
			2:
				Si cantidad > 0 Entonces
					Escribir "Elemento desapilado: ", pila[cantidad]
					cantidad <- cantidad - 1
				SiNo
					Escribir "La pila esta vacia"
				FinSi
				
			3:
				Si cantidad > 0 Entonces
					Escribir "Elemento en el tope: ", pila[cantidad]
				SiNo
					Escribir "La pila esta vacia"
				FinSi
				
			4:
				Si cantidad = 0 Entonces
					Escribir "La pila esta vacia"
				SiNo
					Escribir "La pila tiene ", cantidad, " elementos"
				FinSi
				
		FinSegun
		
	Hasta Que opcion = 5

FinProceso
