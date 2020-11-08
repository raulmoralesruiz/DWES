// Se definen los botones del formulario

// ----- GET
const botonGetCustomers = document.getElementById('botonGetCustomers');
const botonGetProducts = document.getElementById('botonGetProducts');
const botonGetVisuals = document.getElementById('botonGetVisuals');
const botonGetSuscriptions = document.getElementById('botonGetSuscriptions');

// ----- POST
const botonPostProduct = document.getElementById('botonPostProduct');




// Se definen los objetos tabla
const tabla = document.getElementById('tablaListado'); /* Borrar cuando se creen todas las específicas */
const tablaCustomers = document.getElementById('tablaCustomers');
const tablaProducts = document.getElementById('tablaProducts');
const tablaVisuals = document.getElementById('tablaVisuals');
const tablaSuscriptions = document.getElementById('tablaSuscriptions');


// Se definen los diferentes enlaces para realizar GET/POST
const url = "http://localhost:8080/netflix";





botonGetCustomers.addEventListener('click', (e) => {
    e.preventDefault();

    // Se eliminan las celdas cada vez que se pulsa el botón GET DATA
    let celdas = document.getElementsByClassName("celda");
    while (celdas.length) celdas[0].parentElement.removeChild(celdas[0]);

    // Se elimina la clase oculto para mostrar la tabla
    tablaCustomers.classList.remove("oculto");

    // Se ocultan las demás tablas
    tablaProducts.classList.add("oculto");
    tablaVisuals.classList.add("oculto");
    tablaSuscriptions.classList.add("oculto");


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
                let idCustomer = customer.id;
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
                let tdIdCustomer = document.createElement("td");
                let tdUsername = document.createElement("td");
                let tdName = document.createElement("td");
                let tdSurname = document.createElement("td");
                let tdAddress = document.createElement("td");
                let tdCity = document.createElement("td");
                let tdDni = document.createElement("td");

                // Se asigna el valor a cada campo
                tdIdCustomer.textContent = idCustomer;
                tdUsername.textContent = username;
                tdName.textContent = name;
                tdSurname.textContent = surname;
                tdAddress.textContent = address;
                tdCity.textContent = city;
                tdDni.textContent = dni;

                // Se inserta cada celda en la fila creada
                tr.appendChild(tdIdCustomer);
                tr.appendChild(tdUsername);
                tr.appendChild(tdName);
                tr.appendChild(tdSurname);
                tr.appendChild(tdAddress);
                tr.appendChild(tdCity);
                tr.appendChild(tdDni);

                // Se inserta la fila creada en la tabla
                tablaCustomers.appendChild(tr);

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
    tablaProducts.classList.remove("oculto");

    // Se ocultan las demás tablas
    tablaCustomers.classList.add("oculto");
    tablaVisuals.classList.add("oculto");
    tablaSuscriptions.classList.add("oculto");


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
                tablaProducts.appendChild(tr);

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
    tablaSuscriptions.classList.remove("oculto");

    // Se ocultan las demás tablas
    tablaCustomers.classList.add("oculto");
    tablaVisuals.classList.add("oculto");
    tablaProducts.classList.add("oculto");


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
                tablaSuscriptions.appendChild(tr);

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
    tablaVisuals.classList.remove("oculto");

    // Se ocultan las demás tablas
    tablaCustomers.classList.add("oculto");
    tablaProducts.classList.add("oculto");
    tablaSuscriptions.classList.add("oculto");


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
                tablaVisuals.appendChild(tr);

                //BORRAR
                // console.log(visual);
            }
        });

});



// Botón que crea un producto (se inserta mediante post en spring)
botonPostProduct.addEventListener('click', () => {

    // Se guardan los valores de cada campo insertados en el formulario
    const inputTitle = document.getElementById('title').value;
    const inputCategory = document.getElementById('selectCategory').value;
    const inputContent = document.getElementById('selectTipeContent').value;
    const inputSuscription = document.getElementById('selectTipeSuscription').value;

    // Se realiza fetch (POST) para insertar el producto
    fetch(`${url}/products/`, {
            // se especifica el tipo de método
            method: 'POST',
            // se especifica el cuerpo del json (valores obtenidos antes)
            body: JSON.stringify({
                // idProduct: inputId, (ID autogenerado)
                title: inputTitle,
                categoria: inputCategory,
                tipoContenido: inputContent,
                tipoSuscripcion: inputSuscription
            }),
            // se especifica en la cabecera que el tipo de contenido es json
            headers: {
                "Content-type": "application/json"
            }
        })
        // Si hay algún error, guardamos el código correspondiente.
        .then(res => {
            if (!res.ok) throw Error(res.status);
            return res;
        })
        // Se obtiene promesa, tanto si el resultado es correcto o da error
        .then(res => res.ok ? Promise.resolve(res) : Promise.reject(res))
        // Se muestra resultado en formato JSON
        .then(res => res.json())
        // Se informa mediante alerta si el producto se ha creado correctamente.
        .then(res => alert("Producto creado correctamente."))
        // Se informa mediante alerta si el producto no se ha creado correctamente.
        .catch(error => {
            if (error == 'Error: 400') {
                alert(error + `. Faltan campos por rellenar.`);
            } else if (error == 'Error: 409') {
                alert(error + `. El producto introducido ya existe.`);
            }
        });
});