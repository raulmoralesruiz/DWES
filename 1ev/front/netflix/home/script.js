// Se definen los botones del formulario
const titleActiveUser = document.getElementById('titleActiveUser');
const divSuscription = document.getElementById('divSuscription');
const selectTipeSuscription = document.getElementById('selectTipeSuscription');

const divTablaProductos = document.getElementById('divTablaProductos');
const tablaProductos = document.getElementById('tablaProductos');

const divTablaVisuals = document.getElementById('divTablaVisuals');
const tablaVisuals = document.getElementById('tablaVisuals');


// Se definen los diferentes enlaces para realizar GET/POST
const url = "http://localhost:8080/netflix/";


let usuariosRegistrados = [];


const getIdActiveUserData = () => {

    let activeUser = sessionStorage.getItem('activeUser');
    let encontrado = false;

    titleActiveUser.textContent = `Welcome ${activeUser}`;
    let userObject;

    // Se realiza Fetch (GET) para obtener las categorías.
    fetch(`${url}/customer`)
        // Se obtiene promesa, tanto si el resultado es correcto o da error
        .then(res => res.ok ? Promise.resolve(res) : Promise.reject(res))
        // Se muestra resultado en formato JSON
        .then(res => res.json())
        .then(res => {
            // Se recorren todos los resultados
            for (let i = 0; i < res.length && !encontrado; i++) {
                // Se obtiene cada usuario
                let user = res[i];

                let username = user.username;
                let idUser = user.id;

                // Comprobar si el usuario del bucle coincide con el usuario activo.
                if (username == activeUser) {
                    // guardamos el objeto de usuario y cambiamos la bandera a true.
                    encontrado = true;
                    userObject = user;

                    // guardamos el objeto suscription
                    let suscriptionObject = user.suscription;

                    // guardamos el id del usuario activo
                    sessionStorage.setItem('idActiveUser', idUser);

                    // guardamos el objeto suscription en sessionStorage
                    sessionStorage.setItem('suscriptionActiveUser', suscriptionObject);

                    // si el objeto suscription no es nulo
                    if (suscriptionObject != null) {
                        // guardamos el tipo de suscripción
                        let typeOfSuscription = suscriptionObject.typeOfSuscription;

                        // guardamos el tipo de suscripción en sessionStorage
                        sessionStorage.setItem('suscriptionActiveUser', typeOfSuscription);
                    }
                }

            }
        });

}

// Se ejecuta la función anterior para cargar los usuarios registrados.
getIdActiveUserData();



// Función que comprueba la suscripción actual del cliente
const checkSuscription = () => {
    let resultado = false;

    let suscription = sessionStorage.getItem('suscriptionActiveUser');
    // console.log(suscription);

    if (suscription == "null") {
        console.log("El usuario no tiene suscripción activa");
    } else {
        resultado = true;
    }

    return resultado;
}

// checkSuscription();

if (!checkSuscription()) {
    // si el usuario no tiene suscripción, se muestra el divSuscription
    divSuscription.classList.remove("oculto");
}



selectTipeSuscription.addEventListener('change', (e) => {
    const idActiveUser = sessionStorage.getItem('idActiveUser');
    const urlSuscription = `http://localhost:8080/netflix/suscription/c${idActiveUser}`;

    const valueSuscription = selectTipeSuscription.value;
    // console.log(selectTipeSuscription.value);


    // Se realiza fetch (POST) para insertar el producto
    fetch(urlSuscription, {
            // se especifica el tipo de método
            method: 'POST',
            // mode: 'no-cors',
            // se especifica el cuerpo del json (valores obtenidos antes)
            body: JSON.stringify({
                start: "2020-01-01T01:00:00",
                end: "2021-01-01T01:00:00",
                typeOfSuscription: valueSuscription
            }),
            // se especifica en la cabecera que el tipo de contenido es json
            headers: {
                "Content-type": "application/json",
                "Access-Control-Allow-Origin": "*"
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
        .then(res => alert("Suscripción aplicada correctamente."))
        // Se informa mediante alerta si el producto no se ha creado correctamente.
        .catch(error => {
            console.log(error);
            // if (error == 'Error: 400') {
            //     alert(error + `. Faltan campos por rellenar.`);
            // } else if (error == 'Error: 409') {
            //     alert(error + `. El producto introducido ya existe.`);
            // }
        });

});




// Mostrar productos diposnibles según tipo de suscripción.
const showProducts = () => {

    let hayProductos = false;

    const suscription = sessionStorage.getItem('suscriptionActiveUser');
    const urlBasic = "http://localhost:8080/netflix/products/basic/";
    const urlPremium = "http://localhost:8080/netflix/products/premium/";
    let urlFinal;

    if (suscription == "BASIC" || suscription == "PREMIUM") {

        if (suscription == "BASIC") {
            urlFinal = urlBasic;
        } else {
            urlFinal = urlPremium;
        }

        fetch(urlFinal)
            // Se obtiene promesa, tanto si el resultado es correcto o da error
            .then(res => res.ok ? Promise.resolve(res) : Promise.reject(res))
            // Se muestra resultado en formato JSON
            .then(res => res.json())
            .then(res => {
                // Se recorren todos los resultados
                for (let i = 0; i < res.length; i++) {
                    // Se obtiene cada producto
                    let product = res[i];

                    // Se guardan los valores correspondientes para cada campo
                    let id = product.idProduct;
                    let title = product.title;
                    let category = product.categoria;
                    let content = product.tipoContenido;
                    let suscription = product.tipoSuscripcion;

                    // Se crea un objeto de tipo "tr" (fila) y se le añade la clase "celda"
                    let tr = document.createElement("tr");
                    tr.classList.add("celda");

                    // Se crean las celdas para cada campo
                    let tdId = document.createElement("td");
                    let tdTitle = document.createElement("td");
                    let tdCategory = document.createElement("td");
                    let tdContent = document.createElement("td");
                    let tdSuscription = document.createElement("td");

                    // Se asigna el valor a cada campo
                    tdId.textContent = id;
                    tdTitle.textContent = title;
                    tdCategory.textContent = category;
                    tdContent.textContent = content;
                    tdSuscription.textContent = suscription;

                    // Se inserta cada celda en la fila creada
                    tr.appendChild(tdId);
                    tr.appendChild(tdTitle);
                    tr.appendChild(tdCategory);
                    tr.appendChild(tdContent);
                    tr.appendChild(tdSuscription)

                    // Se inserta la fila creada en la tablaProductos
                    tablaProductos.appendChild(tr);
                }

            })
            .then(hayProductos = true)
            .catch(error => console.log(error));
    }

    // Si hay productos para mostrar, se muestra la tabla de productos.
    if (hayProductos) {
        // Se eliminan las celdas cada vez que se pulsa el botón GET DATA
        let celdas = document.getElementsByClassName("celda");
        while (celdas.length) celdas[0].parentElement.removeChild(celdas[0]);

        // Se elimina la clase oculto para mostrar la tabla
        divTablaProductos.classList.remove("oculto");
    }

}

showProducts();





// Mostrar productos diposnibles según tipo de suscripción.
const showVisuals = () => {

    let hayVisualizaciones = false;

    const idActiveUser = sessionStorage.getItem('idActiveUser');
    const urlCustomerVisuals = `http://localhost:8080/netflix/visual/c${idActiveUser}`;

    fetch(urlCustomerVisuals)
        // Se obtiene promesa, tanto si el resultado es correcto o da error
        .then(res => res.ok ? Promise.resolve(res) : Promise.reject(res))
        // Se muestra resultado en formato JSON
        .then(res => res.json())
        .then(res => {
            // Se recorren todos los resultados
            for (let i = 0; i < res.length; i++) {


                // Se obtiene cada producto
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
            }

        })
        .catch(error => {
            /* Si el cliente no tiene visualizaciones se oculta la tabla visuals */
            divTablaVisuals.classList.add("oculto");
        })

}

showVisuals();