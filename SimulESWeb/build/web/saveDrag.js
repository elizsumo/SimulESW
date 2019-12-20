/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//Chama a função que atualiza a página do tabuleiro individual quando necessário
checkBoard();

function enviarDatosAjaxServlet() {

    //aqui obtengo el valor del comentario ingresado
    var player = encodeURIComponent(document.getElementById("player").value);

    //aqui envio la fecha, el comentario y el nombre al servlet MiServlet
    //para almacenarlos en una sesion
    jmaki.doAjax({
        url : "ServletGetDrag",
        method : 'POST',
        content : {
            'player' : player
        },
        callback : function(req) {
            procesarRespuesta(req);
        }
    });
}

//submeter jogada
function procesarRespuesta(respuesta) {
    //aqui obtengo el archivo XML en una variable que envio el
    //servlet como respuesta
    var xml = respuesta.responseXML;

    //aqui obtengo el valor del tag respuesta que esta en el xml
    var res = valorXml(xml,'respuesta', 0);

    //si la respuesta es ok significa que no hay errores
    if(res == 'ok'){

        window.location.href="MessageSaveDrag.jsp";

    } else {
        //si hay errores entonces muestro un mensaje
        cargarContenidoDinamico('error', "Ocurrió un problema al enviar los datos, tal vez omitió el ingreso de alguno. Intente nuevamente.");
    }
}

function valorXml(xml, tagName, index) {
    //si el tag no existe retorno null, en caso contrario retorno el valor del tag
    if(xml.getElementsByTagName(tagName).length == 0)
        return null;
    return xml.getElementsByTagName(tagName)[index].childNodes[0].nodeValue;
}

function cargarContenidoDinamico(contenedor, texto) {
    //aqui agrego el texto al div contenedor
    document.getElementById(contenedor).innerHTML = texto;
}

// function shows how to scan table and display cell content
// (fired on button "Click" click :)
// this function should be customized for your needs
function read_table_content(id){
    // define local variables
    var message = ''; // final message
    var div_text;     // div content (inner text)
    var border;       // border color (green or blue)
    // set reference to the table
    var tbl = document.getElementById(id);
    // define number of table rows
    var tbl_rows = tbl.rows.length;
    // iterate through each table row
    for (var r=0; r<tbl_rows; r++){
        // set the number of cells in the current row
        var cells = tbl.rows[r].cells.length
        // iterate through each table cell
        for (var c=0; c<cells; c++){
            // set reference to the table cell
            var tbl_cell = tbl.rows[r].cells[c];
            // if cells isn't empty and hasn't forbid class
            if (tbl_cell.childNodes.length > 0 && tbl_cell.className != forbid){
                // cell can contain more then one DIV element
                for (var d=0; d<tbl_cell.childNodes.length; d++){
                    // childNodes should be DIVs, not \n childs
                    if (tbl_cell.childNodes[d].tagName == 'DIV'){ // and yes, is should be uppercase
                        // find the border color of DIV element (t1 - green, t2 - blue, t3 - orange)
                        if (tbl_cell.childNodes[d].className.indexOf('t1') > 0)      border = 'green';
                        else if (tbl_cell.childNodes[d].className.indexOf('t2') > 0) border = 'blue';
                        else border = 'orange';
                        // set message line if div contains form elements
                        if (tbl_cell.childNodes[d].getElementsByTagName('INPUT').length || tbl_cell.childNodes[d].getElementsByTagName('SELECT').length)
                            div_text = 'form element';
                        // for other divs that contains only text (cross browser)
                        else
                            div_text = '' + (tbl_cell.childNodes[d].innerText || tbl_cell.childNodes[d].textContent) + '';
                        // add line to the message
                        // message += 'row:' + r + ' col:' + c + ' ' + div_text + '\n';
                        if(tbl_cell.childNodes[d].id=='')
                        {
                            message += 'R' + r + ',C' + c +',V'+ div_text + '/';
                        }
                        else
                        {
                            message += 'R' + r + ',C' + c +',V'+ tbl_cell.childNodes[d].id + '/';
                        }
                        //aqui obtengo el valor del comentario ingresado
                        // var comentario = message += 'row:' + r + ' col:' + c + ' ' + div_text + ' (' + border + ')\n';

                        var player = encodeURIComponent(document.getElementById("player").value);
                        var usernameId = encodeURIComponent(document.getElementById("usernameId").value);


                    }
                }
            }

        }

    }

if (usernameId==0) {

        alert("Player does not join in this game");
    }

    else if (usernameId==1)
    {
        alert("You can only change your own table");
    }
    else if (usernameId==2)
    {
        alert("This move  is not enabled");
    }
       else {
        jmaki.doAjax({
            url : "ServletGetDrag",
            method : 'POST',
            content : {
                'player' : player,
                'configuration' : message,
                'update_board' : 1
            },
            callback : function(req) {
                procesarRespuesta(req);
            }
        });
    }

    // if table is empty print a nice message
    if (message == '') message = 'Individual Board Game is empty!';
// display message
//alert(message);
}

//usado para submeter o tabuleiro quando o jogador termina seu produto
function save_table_content(id){
    // define local variables
    var message = ''; // final message
    var div_text;     // div content (inner text)
    var border;       // border color (green or blue)
    // set reference to the table
    var tbl = document.getElementById(id);
    // define number of table rows
    var tbl_rows = tbl.rows.length;
    // iterate through each table row
    for (var r=0; r<tbl_rows; r++){
        // set the number of cells in the current row
        var cells = tbl.rows[r].cells.length
        // iterate through each table cell
        for (var c=0; c<cells; c++){
            // set reference to the table cell
            var tbl_cell = tbl.rows[r].cells[c];
            // if cells isn't empty and hasn't forbid class
            if (tbl_cell.childNodes.length > 0 && tbl_cell.className != forbid){
                // cell can contain more then one DIV element
                for (var d=0; d<tbl_cell.childNodes.length; d++){
                    // childNodes should be DIVs, not \n childs
                    if (tbl_cell.childNodes[d].tagName == 'DIV'){ // and yes, is should be uppercase
                        // find the border color of DIV element (t1 - green, t2 - blue, t3 - orange)
                        if (tbl_cell.childNodes[d].className.indexOf('t1') > 0)      border = 'green';
                        else if (tbl_cell.childNodes[d].className.indexOf('t2') > 0) border = 'blue';
                        else border = 'orange';
                        // set message line if div contains form elements
                        if (tbl_cell.childNodes[d].getElementsByTagName('INPUT').length || tbl_cell.childNodes[d].getElementsByTagName('SELECT').length)
                            div_text = 'form element';
                        // for other divs that contains only text (cross browser)
                        else
                            div_text = '' + (tbl_cell.childNodes[d].innerText || tbl_cell.childNodes[d].textContent) + '';
                        // add line to the message
                        // message += 'row:' + r + ' col:' + c + ' ' + div_text + '\n';
                        if(tbl_cell.childNodes[d].id=='')
                        {
                            message += 'R' + r + ',C' + c +',V'+ div_text + '/';
                        }
                        else
                        {
                            message += 'R' + r + ',C' + c +',V'+ tbl_cell.childNodes[d].id + '/';
                        }
                        //aqui obtengo el valor del comentario ingresado
                        // var comentario = message += 'row:' + r + ' col:' + c + ' ' + div_text + ' (' + border + ')\n';

                         var player = encodeURIComponent(document.getElementById("player").value);
                        var usernameId = encodeURIComponent(document.getElementById("usernameId").value);


                    }
                }
            }

        }

    }

    if (usernameId==0) {

        alert("Player does not join in this game");
    }

    else if (usernameId==1)
    {
        alert("You can only change your own table");
    }
    else if (usernameId==2)
    {
        alert("This move  is not enabled");
    }

    else {
        jmaki.doAjax({
            url : "ServletGetDrag",
            method : 'POST',
            content : {
                'player' : player,
                'configuration' : message,
                'update_board' : 1
            },
            callback : function(req) {
                processResponse(req);
            }
        });
    }

    // if table is empty print a nice message
    if (message == '') message = 'Individual Board Game is empty!';
// display message
//alert(message);
}


// function shows how to scan table, prepare query string and sent to the multiple-parameters.php
// (fired on button "Save" click :)
function save_content()
{
    alert('probando');

}

function submit_content()
{
    alert('probando');

}

function processResponse(respuesta) {
   //aqui obtengo el archivo XML en una variable que envio el
    //servlet como respuesta
    var xml = respuesta.responseXML;

    //aqui obtengo el valor del tag respuesta que esta en el xml
    var res = valorXml(xml,'respuesta', 0);

    //si la respuesta es ok significa que no hay errores
    if(res == 'ok'){
       window.location.href="MessageSubmitInspect.jsp";

    } else {
        //si hay errores entonces muestro un mensaje
        cargarContenidoDinamico('error', "Ocurrió un problema al enviar los datos, tal vez omitió el ingreso de alguno. Intente nuevamente.");
    }
}

function loadDynamicContent(container, text)
{
    //here add the text to div container
    document.getElementById(container).innerHTML = text;
}


// A cada 4 segundos, uma função é chamada para verificar se o tabuleiro que está sendo visualizado foi alterado. Esta função permite que jogadores que
// estejam visitando o tabuleiro de um outro jogador, para acompanha a jogada por exemplo, não fique desatualizado das ações do Jogador da Vez.
function checkBoard() {
    setTimeout("getUpdateBoard()", 4000);
}

// Verifica através de um servlet request, passando para este servlet o username do usuário logado, se ele está desatualizado com a última versão de
// algum tabuleiro de algum jogador. Caso esteja, ele tratará de chamar a função que recarregará a página para que então esta seja atualizada.
function getUpdateBoard() {

    var username = encodeURIComponent(document.getElementById("username").value);

    jmaki.doAjax({
        url : "ServletGetDrag?player=" + username,
        method : 'GET',

        callback : function(req) {
            processCheckBoard(req);
        }
    });

    checkBoard();
}

// If something have changed do the update
function processCheckBoard(respuesta) {

    var player = encodeURIComponent(document.getElementById("player").value);
    var username = encodeURIComponent(document.getElementById("username").value);

    //aqui obtengo el archivo XML en una variable que envio el
    //servlet como respuesta
    var xml = respuesta.responseXML;

    //aqui obtengo el valor del tag respuesta que esta en el xml
    var res = valorXml(xml,'respuesta', 0);

    //si la respuesta es ok significa que no hay errores
    if(res == 1){
        window.location.href="IndividualBoardPage.jsp?id=" + player + "&username=" + username;
    }

}



