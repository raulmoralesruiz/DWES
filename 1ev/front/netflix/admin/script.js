// Se definen los botones del formulario
const botonGetCustomers = document.getElementById('botonGetCustomers');
const botonGetProducts = document.getElementById('botonGetProducts');
const botonGetVisuals = document.getElementById('botonGetVisuals');
const botonGetSuscriptions = document.getElementById('botonGetSuscriptions');


// Se define el objeto tabla
const tabla = document.getElementById('tablaListado');


// Se definen los diferentes enlaces para realizar GET/POST
const url = "http://localhost:8080/netflix";






botonGetCustomers.addEventListener('click', (e) => {
    e.preventDefault();

    // Se eliminan las celdas cada vez que se pulsa el botón GET DATA
    let celdas = document.getElementsByClassName("celda");
    while (celdas.length) celdas[0].parentElement.removeChild(celdas[0]);

    // Se elimina la clase oculto para mostrar la tabla
    tabla.classList.remove("oculto");


    // Se realiza Fetch (GET) para obtener las categorías.
    fetch(`${url}/customer`)
        // Se obtiene promesa, tanto si el resultado es correcto o da error
        .then(res => res.ok ? Promise.resolve(res) : Promise.reject(res))
        // Se muestra resultado en formato JSON
        .then(res => res.json())
        .then(res => {
            // Se recorren todos los resultados
            for (let i = 0; i < res.length; i++) {
                // Se obtiene cada usuario
                let customer = res[i];

                // Se guardan los valores correspondientes para cada campo
                let username = customer.username;
                let name = customer.name;
                let surname = customer.surname;
                let address = customer.address;
                let city = customer.city;
                let dni = customer.dni;

                // Se crea un objeto de tipo "tr" (fila) y se le añade la clase "celda"
                let tr = document.createElement("tr");
                tr.classList.add("celda");

                // Se crean las celdas para cada campo
                let tdUsername = document.createElement("td");
                let tdName = document.createElement("td");
                let tdSurname = document.createElement("td");
                let tdAddress = document.createElement("td");
                let tdCity = document.createElement("td");
                let tdDni = document.createElement("td");

                // Se asigna el valor a cada campo
                tdUsername.textContent = username;
                tdName.textContent = name;
                tdSurname.textContent = surname;
                tdAddress.textContent = address;
                tdCity.textContent = city;
                tdDni.textContent = dni;

                // Se inserta cada celda en la fila creada
                tr.appendChild(tdUsername);
                tr.appendChild(tdName);
                tr.appendChild(tdSurname);
                tr.appendChild(tdAddress);
                tr.appendChild(tdCity);
                tr.appendChild(tdDni);

                // Se inserta la fila creada en la tabla
                tabla.appendChild(tr);

                //BORRAR
                // console.log(customer);
            }
        });

});


botonGetProducts.addEventListener('click', (e) => {
    e.preventDefault();

    // Se eliminan las celdas cada vez que se pulsa el botón GET DATA
    let celdas = document.getElementsByClassName("celda");
    while (celdas.length) celdas[0].parentElement.removeChild(celdas[0]);

    // Se elimina la clase oculto para mostrar la tabla
    tabla.classList.remove("oculto");


    // Se realiza Fetch (GET) para obtener las categorías.
    fetch(`${url}/products`)
        // Se obtiene promesa, tanto si el resultado es correcto o da error
        .then(res => res.ok ? Promise.resolve(res) : Promise.reject(res))
        // Se muestra resultado en formato JSON
        .then(res => res.json())
        .then(res => {
            // Se recorren todos los resultados
            for (let i = 0; i < res.length; i++) {
                // Se obtiene cada usuario
                let product = res[i];

                // Se guardan los valores correspondientes para cada campo
                let id = product.idProduct;
                let title = product.title;
                let category = product.categoria;
                let typeContent = product.tipoContenido;
                let typeSuscription = product.tipoSuscripcion;

                // Se crea un objeto de tipo "tr" (fila) y se le añade la clase "celda"
                let tr = document.createElement("tr");
                tr.classList.add("celda");

                // Se crean las celdas para cada campo
                let tdId = document.createElement("td");
                let tdTitle = document.createElement("td");
                let tdCategory = document.createElement("td");
                let tdTypeContent = document.createElement("td");
                let tdTypeSuscription = document.createElement("td");

                // Se asigna el valor a cada campo
                tdId.textContent = id;
                tdTitle.textContent = title;
                tdCategory.textContent = category;
                tdTypeContent.textContent = typeContent;
                tdTypeSuscription.textContent = typeSuscription;

                // Se inserta cada celda en la fila creada
                tr.appendChild(tdId);
                tr.appendChild(tdTitle);
                tr.appendChild(tdCategory);
                tr.appendChild(tdTypeContent);
                tr.appendChild(tdTypeSuscription);

                // Se inserta la fila creada en la tabla
                tabla.appendChild(tr);

                //BORRAR
                // console.log(product);
            }
        });

});


botonGetSuscriptions.addEventListener('click', (e) => {
    e.preventDefault();

    // Se eliminan las celdas cada vez que se pulsa el botón GET DATA
    let celdas = document.getElementsByClassName("celda");
    while (celdas.length) celdas[0].parentElement.removeChild(celdas[0]);

    // Se elimina la clase oculto para mostrar la tabla
    tabla.classList.remove("oculto");


    // Se realiza Fetch (GET) para obtener las categorías.
    fetch(`${url}/suscription`)
        // Se obtiene promesa, tanto si el resultado es correcto o da error
        .then(res => res.ok ? Promise.resolve(res) : Promise.reject(res))
        // Se muestra resultado en formato JSON
        .then(res => res.json())
        .then(res => {
            // Se recorren todos los resultados
            for (let i = 0; i < res.length; i++) {
                // Se obtiene cada suscripción
                let suscription = res[i];

                // Se guardan los valores correspondientes para cada campo
                let idSuscription = suscription.idSuscription;
                let start = suscription.start;
                let end = suscription.end;
                let typeOfSuscription = suscription.typeOfSuscription;
                let idCustomer = suscription.idCustomer;

                // Se crea un objeto de tipo "tr" (fila) y se le añade la clase "celda"
                let tr = document.createElement("tr");
                tr.classList.add("celda");

                // Se crean las celdas para cada campo
                let tdIdSuscription = document.createElement("td");
                let tdStart = document.createElement("td");
                let tdEnd = document.createElement("td");
                let tdTypeOfSuscription = document.createElement("td");
                let tdIdCustomer = document.createElement("td");

                // Se asigna el valor a cada campo
                tdIdSuscription.textContent = idSuscription;
                tdStart.textContent = start;
                tdEnd.textContent = end;
                tdTypeOfSuscription.textContent = typeOfSuscription;
                tdIdCustomer.textContent = idCustomer;

                // Se inserta cada celda en la fila creada
                tr.appendChild(tdIdSuscription);
                tr.appendChild(tdStart);
                tr.appendChild(tdEnd);
                tr.appendChild(tdTypeOfSuscription);
                tr.appendChild(tdIdCustomer);

                // Se inserta la fila creada en la tabla
                tabla.appendChild(tr);

                //BORRAR
                // console.log(suscription);
            }
        });

});


botonGetVisuals.addEventListener('click', (e) => {
    e.preventDefault();

    // Se eliminan las celdas cada vez que se pulsa el botón GET DATA
    let celdas = document.getElementsByClassName("celda");
    while (celdas.length) celdas[0].parentElement.removeChild(celdas[0]);

    // Se elimina la clase oculto para mostrar la tabla
    tabla.classList.remove("oculto");


    // Se realiza Fetch (GET) para obtener las categorías.
    fetch(`${url}/visual`)
        // Se obtiene promesa, tanto si el resultado es correcto o da error
        .then(res => res.ok ? Promise.resolve(res) : Promise.reject(res))
        // Se muestra resultado en formato JSON
        .then(res => res.json())
        .then(res => {
            // Se recorren todos los resultados
            for (let i = 0; i < res.length; i++) {
                // Se obtiene cada suscripción
                let visual = res[i];

                // Se guardan los valores correspondientes para cada campo
                let idVisual = visual.idVisual;
                let inicio = visual.inicio;
                let fin = visual.fin;
                let producto = visual.producto.idProduct;
                let idCustomer = visual.idCustomer;

                // Se crea un objeto de tipo "tr" (fila) y se le añade la clase "celda"
                let tr = document.createElement("tr");
                tr.classList.add("celda");

                // Se crean las celdas para cada campo
                let tdIdVisual = document.createElement("td");
                let tdInicio = document.createElement("td");
                let tdFin = document.createElement("td");
                let tdProducto = document.createElement("td");
                let tdIdCustomer = document.createElement("td");

                // Se asigna el valor a cada campo
                tdIdVisual.textContent = idVisual;
                tdInicio.textContent = inicio;
                tdFin.textContent = fin;
                tdProducto.textContent = producto;
                tdIdCustomer.textContent = idCustomer;

                // Se inserta cada celda en la fila creada
                tr.appendChild(tdIdVisual);
                tr.appendChild(tdInicio);
                tr.appendChild(tdFin);
                tr.appendChild(tdProducto);
                tr.appendChild(tdIdCustomer);

                // Se inserta la fila creada en la tabla
                tabla.appendChild(tr);

                //BORRAR
                // console.log(visual);
            }
        });

});