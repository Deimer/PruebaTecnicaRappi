# PruebaTecnicaRappi
Prueba técnica de proceso de selección para desarrollador Android en Rappi

1) Las capas de la aplicación (por ejemplo capa de persistencia, vistas, red, negocio, etc) y qué clases pertenecen a cual.

La aplicación esta diseñada bajo la arquitectura MVP que a su vez se compone de las carpetas model views presenter, además de las carpetas de data y events.
Views: La carpeta views representa la capa de vista que contiene las clases activities controladoras de la interfaz grafica que ve el usuario
(WelcomeActivity, LoginActivity, TimelineActivity, DetailActivity y VideoActivity) separadas en carpeta por lógica de funcionalidad,
en esta también están incluidas las clases adapters, fragments y dialogs que ayudan a mantener una mejor estructura del código
y responsabilidades de las funciones de cada clase.
Model: La carpeta model representa la capa lógica de la arquitectura, en el caso de esta app solo fue usada para contener las entidades 
que contendrían la información consultada del servicio.
Presenter: La carpeta presenter es la capa que se sitúa entre el modelo y la vista, permitiendo conectar la interfaz gráfica con los datos.
Data: Es la carpeta que representa la capa de red y/o persistencia, en este caso usada para contener las clases que permiten la consulta de datos
hacia el servicio rest dividido en adaptadores para cada funcionalidad.
Events: Esta carpeta es la capa que contiene las clases que bajo la arquitectura publish/subscribe o bus de mensaje, comunica de forma efectiva
componentes de la aplicación sin que ninguna de estas esté consciente de las otras inmediatamente.

2. La responsabilidad de cada clase creada.

WelcomeActivity: Es la activity que lanza el splash screen de la app
LoginActivity: Es la activity que valida la sesión del usuario mediante un login sencillo sin persistencia de datos (usuario: user123, password: clave123).
TimelineActivity: Es la activity que contiene el viewpager que muestra la información principal consultada en el servicio rest (películas y series).
TimelinePresenter: Es la interfaz que comunica ya sea la lista de los ítems consultados o un error de conexión por parte del adaptador de red.
DetailActivity: Es la activity que muestra los detalles de un ítem seleccionador por el usuario luego de consultarse la información en el servicio rest.
DetailPresenter: Es la interfaz que consulta al adaptador de red y comunica los detalles de información de cada ítem por separado a la vista.
VideoActivity: Es la activity que muestra los videos asociados a un ítem seleccionado por el usuario luego de consultarse la información en el servicio rest.
VideoPresenter: Es la interfaz que consulta al adaptador de red y comunica los videos de cada ítem por separado a la vista.

ApiService: Es la clase interfaz que posee los métodos para realizar la consulta al servidor y obtener un resultado.
RetrofitDetailAdapter: Es el adaptador de red que permite usar la clase ApiService para conectarse al endpoint que obtiene los detalles de un ítem.
RetrofitTimelineAdapter: Es el adaptador de red que permite usar la clase ApiService para conectarse al endpoint que obtiene los ítems mas populares, próximos y mejor valorados.
RetrofitVideoAdapter: Es el adaptador de red que permite usar la clase ApiService para conectarse al endpoint que obtiene los videos asociados a un ítem.

TabPagerTimelineAdapter: Es el adaptador que permite crear una nueva instancia para cada fragment a visualizar en el viewpager.
ItemRecyclerAdapter: Es el adaptador del recyclerview ubicado en la activity Timeline, este permitirá transformar la información del servicio rest en una lista de ítems visuales organizados.
TabMovies: Es la clase que permite hacer uso del adaptador de ítems para visualizar la informacion de los ítems "película" al usuario de una forma agradable.
TabSeries: Es la clase que permite hacer uso del adaptador de ítems para visualizar la información de los ítems "series" al usuario de una forma agradable.
CreateDialog: Esta clase permite crear un AlertDialog personalizado para visualizar las categorías en que se pueden filtrar los ítems y comunicar la opción del usuario
en tiempo real usando un bus de eventos.

Responda y escriba dentro del Readme con las siguientes preguntas: 

1. En qué consiste el principio de responsabilidad única? Cuál es su propósito?
Consiste en que una clase o función debe tener una y solo una responsabilidad. Su propósito es el de guiar a que las clases lógicas de una aplicación o proyecto solo deba realizar una única cosa.

2. Qué características tiene, según su opinión, un “buen” código o código limpio? 
Lo que considero como mayor ventaja al tratar de codificar un "buen" código limpio es la lógica detrás del código siguiendo unos patrones y técnicas que permitan el siempre leerlo de forma fácil, además de garantizar un fácil mantenimiento y testeo.

