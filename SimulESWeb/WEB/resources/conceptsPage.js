//Document   : conceptsPage
//Created on : May 3, 2010, 7:03 PM
//Author     : Grupo de Java PES

/*
 * Função: handleOnLoad
 *
 * Descrição:
 *   Função que atualiza a página 'Concepts' a cada 7 segundos.
 * 
 */
function handleOnLoad() {
    
    /*
     * Função: setTimeout
     *
     * Descrição:
     *   Dispara em um determinado tempo (ms) código ou outra função
     *
     * Parâmetros:
     *   Primeiro: funcão ou código
     *   Segundo : tempo em milisegundos (ms)
     */
    setTimeout( "refresh()", 7000 );
}

/*
 * Função: refresh
 *
 * Descrição:
 *   Atualiza a página corrente
 */
function refresh()
{
    hyperlink_submit(this, 'form1', null);
}