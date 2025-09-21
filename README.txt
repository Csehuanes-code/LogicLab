🧠⚙️ LogicLab – Plataforma Completa para Simulación de Circuitos Lógicos Digitales
Descripción General:

LogicLab es una aplicación desarrollada en Java con NetBeans que permite diseñar, visualizar, simular y analizar circuitos lógicos digitales de forma interactiva. Su arquitectura robusta basada en POO (Programación Orientada a Objetos) y su estructura modular hacen de LogicLab una herramienta ideal para el aprendizaje, la experimentación y la validación de sistemas digitales combinacionales.

La aplicación ha evolucionado para ser mucho más que un simple simulador: ahora traduce expresiones booleanas a diagramas visuales de compuertas y viceversa, permitiendo un análisis bidireccional de la lógica digital.

🔧 Características Destacadas:
Simulación completa de compuertas lógicas: AND, OR, NOT, NAND, NOR, XOR, XNOR, totalmente funcionales e integradas con visualización dinámica.

Conversión bidireccional:

De expresión booleana a circuito visual mediante el análisis sintáctico personalizado.

De circuito visual a expresión booleana, lo que permite validar la lógica del diseño implementado.

Gestión de componentes a través de la clase Circuito: Esta clase centraliza las funcionalidades del sistema: añadir, borrar, mover componentes, gestionar conexiones y manejar actualizaciones gráficas.

Guardar y cargar progreso: LogicLab permite guardar el estado completo del circuito en archivos externos, facilitando el trabajo por sesiones y el intercambio de diseños entre usuarios.

Amplia gama de clases, enumeraciones y archivos organizados: El proyecto cuenta con una estructura clara, escalable y mantenible, adecuada para futuras integraciones como circuitos secuenciales o simulación de memoria lógica.

Sistema de conexiones inteligente: El usuario puede arrastrar cables para conectar componentes. Si la conexión no es válida, se descarta automáticamente, garantizando integridad lógica.

Visualización del estado lógico: Cada señal lógica es representada con colores para indicar su valor booleano (por ejemplo, verde para verdadero, rojo para falso), facilitando el diagnóstico y depuración de circuitos.

🎓 Aplicaciones Académicas y Profesionales:
Ideal para cursos de Arquitectura de Computadores, Electrónica Digital, Estructuras Discretas, y Sistemas Embebidos.

Herramienta pedagógica para docentes en simulación de lógica combinacional.

Base para expandirse hacia simulación de circuitos secuenciales, flip-flops y memorias.

🛠️ Tecnologías y Diseño:
Lenguaje: Java (JDK 22/23)

Entorno de desarrollo: NetBeans

Interfaz gráfica: Swing personalizado sobre JPanel

Diseño estructural: Arquitectura orientada a objetos (POO), refactorizada para escalabilidad y mantenimiento

Persistencia de datos: Serialización o lectura/escritura de archivos para guardar proyectos