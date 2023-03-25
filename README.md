# Service School Tasks

Tablas:

Estudiantes
(nombre, apellido materno, paterno, matricula, correo, fecha nacimiento, contraseña)

Tareas:
(id, titulo, descripción, fechaIni, fechaFin, FK_estudiante, FK_Docente)

Docentes
(nombre, apellido materno, paterno, numTrabajador, correo, fecha nacimiento, contraseña)


Servicios:
- Todos los estudiantes que tengan tareas con profesor en específico.
- Todos los profesores que aignó tarea(s) con un alumno en específico.
- Contar cuántas tareas tiene el estudiante con un profesor en específico.
- Servicio que consulte todas las tareas que hay dentro de un periodo de fecha ( Fecha Incio - Fecha Fin)

Rutas 

> 1. localhost:8080/api-agenda/task/t/{teacher}
> 1. localhost:8080/api-agenda/task/a/{student}
> 3. localhost:8080/api-agenda/task/count/{profesor}

Formato YYYY-MM-DD
>  4. localhost:8080/api-agenda/task/date/{fehcaInicio}_{FechaFin} 

