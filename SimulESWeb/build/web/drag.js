/*
Copyright (c) 2009, www.redips.net  All rights reserved.
Code licensed under the BSD License: http://www.redips.net/license/

http://www.redips.net/javascript/drag-and-drop-table-content/
version 1.3.3
Jul 15, 2009.
*/


// parameters that can be changed
var hover_color    = '#E7AB83';					// define hover color
var bound          = 25;								// bound width for autoscroll
var speed          = 20;								// scroll speed in milliseconds
var forbid         = 'forbid';					// cell class name where draggable element can not be dropped
var trash          = 'trash';						// cell class name where draggable element will be destroyed
var trash_ask      = true;							// confirm object deletion (ask a question "Are you sure?" before delete)
var drop_option   = '';
var single_content = false;							// enable dropping to already taken table cells
var operation_choose = 0;

// other parameters
var obj = false;                        // draggable object
var obj_margin;            						  // space from clicked point to the object bounds (top, right, bottom, left)
var mouseButton = 0;										// if mouseButton == 1 then first mouse button is pressed
var mouseX, mouseY;    			            // mouse coordinates (used in onmousedown, onmousemove and autoscroll)
var window_width= 0, window_height=0;   // window width and height (parameters are set in onload and onresize event handler)
var scroll_width, scroll_height;        // scroll width and height of the window (it is usually greater then window)
var edgeX=0, edgeY=0;                   // autoscroll bound values (closer to the page edge, faster scroll) calculated in onmousemove handler
var bgcolor_old; 										    // old cell background color
var tables;                             // table offsets and row offsets (initialized in onload event)
var autoscrollX_flag=autoscrollY_flag=0;// needed to prevent multiple calls of autoscrollX and autoscrollY from onmousemove event handler
var moved_flag = 0;
var cloned_flag=0;                      // if object is cloned, flag gets value 1
var cloned_id=0							// needed for increment ID of cloned elements

// selected, previous and started table, row and cell
var table = table_old = table_source = null;
var row   = row_old   = row_source   = null;
var cell  = cell_old  = cell_source  = null;

//
// event handlers
//
// onLoad event
window.onload = function (){
              
    // collect tables inside div with id=drag
    tables = document.getElementById('drag').getElementsByTagName('table');
    // set initial window width/height, scroll width/height and define onresize event handler
    // onresize event handler calls calculate columns
    handler_onresize();
    window.onresize = handler_onresize;
    // collect div elements inside tables (draggable elements)
    var divs = document.getElementById('drag').getElementsByTagName('div');
    // attach onmousedown event handler only to DIV elements that have "drag" in class name
    // allow other div elements inside <div id="drag" ...
    for (var i=0; i<divs.length; i++)
        if (divs[i].className.indexOf('drag') > -1)
            divs[i].onmousedown = handler_onmousedown;
    // collect images inside div=drag to prevent default action of onmousemove event (needed for IE to enable dragging on image)
    var imgs = document.getElementById('drag').getElementsByTagName('img');
    // set onmousemove event for images
    for (var i=0; i<imgs.length; i++) imgs[i].onmousemove = function(){
        return false
    };
    // dissable text selection for IE (but not for the form elements)
    document.onselectstart = function(e) {
        var evt = e || window.event; if (!isFormElement(evt)) return false
    }
    // attach onscroll event (needed for recalculating table cells positions)
    window.onscroll = calculate_cells;
}


// onresize window event handler
// this event handler sets window_width and window_height variables used in onmousemove handler
function handler_onresize(){
    // Non-IE
    if (typeof(window.innerWidth) == 'number'){
        window_width  = window.innerWidth;
        window_height = window.innerHeight;
    }
    // IE 6+ in 'standards compliant mode'
    else if (document.documentElement && (document.documentElement.clientWidth || document.documentElement.clientHeight)){
        window_width  = document.documentElement.clientWidth;
        window_height = document.documentElement.clientHeight;
    }
    // IE 4 compatible
    else if (document.body && (document.body.clientWidth || document.body.clientHeight)){
        window_width  = document.body.clientWidth;
        window_height = document.body.clientHeight;
    }
    // set scroll size (onresize, onload and onmouseup event)
    scroll_width  = document.documentElement.scrollWidth;
    scroll_height = document.documentElement.scrollHeight;
    // calculate colums and rows offset (cells dimensions)
    calculate_cells();
}



// onmousedown handler
function handler_onmousedown(e){

    // define event (cross browser)
    var evt = e || window.event;
    // enable control for form elements
    if (isFormElement(evt)) return true;
    // set a reference to the moved object
    obj = this;
    // set clicked position
    mouseX = evt.clientX;
    mouseY = evt.clientY;
    // set current table, row and cell
    set_tcr(evt);
    // remember started table, row and cell
    table_source = table;
    row_source   = row;
    cell_source  = cell;
    // define pressed mouse button
    if (evt.which) mouseButton = evt.which;
    else           mouseButton = evt.button;
    // activate onmousemove and onmouseup event handlers on document level
    // if left mouse button is pressed
    if (mouseButton == 1){
        moved_flag = 1; // set moved_flag (if need to clone object in handler_onmousemove)
        document.onmousemove = handler_onmousemove;
        document.onmouseup   = handler_onmouseup; 
        myhandler_clicked(); // call myhandler

    }
    // remember background cell color
    bgcolor_old = tables[table].rows[row].cells[cell].style.backgroundColor;
    // define object offset
    var offset = box_offset(obj);
    // calculate ofsset from the clicked point inside element to the
    // top, right, bottom and left side of the element
    obj_margin = [mouseY-offset[0], offset[1]-mouseX, offset[2]-mouseY, mouseX-offset[3]];
    // disable text selection
    return false;
}



// onmouseup handler
function handler_onmouseup(e){
    // define destination table cell
    var destination_cell;
    // reset mouseButton variable
    mouseButton = 0;
    // reset left and top styles
    obj.style.left = 0;
    obj.style.top  = 0;
    // if object was dropped inside table then define a new location for destination cell
    if (table < tables.length)
        destination_cell = tables[table].rows[row].cells[cell];
    else // or use the last possible location (object was dropped outside table)
        destination_cell = tables[table_old].rows[row_old].cells[cell_old];
    // return background color for destination color (cell had hover color)
    destination_cell.style.backgroundColor = bgcolor_old;
    // detach onmousemove and onmouseup events
    document.onmousemove = null;
    document.onmouseup   = null;
    // document.body.scroll... only works in compatibility (aka quirks) mode,
    // for standard mode, use: document.documentElement.scroll...
    scroll_width  = document.documentElement.scrollWidth;
    scroll_height = document.documentElement.scrollHeight;
    // reset autoscroll flags
    autoscrollX_flag = autoscrollY_flag = 0;
    // reset old positions
    table_old = row_old = cell_old = null;
    // remove child if destination cell has "trash" in class names
    if (destination_cell.className.indexOf(trash) > -1){
        // remove child from DOM (node still exists in memory)
        obj.parentNode.removeChild(obj);
        // if parameter trash_ask is "true", confirm deletion (function trash_delete is at bottom of this script)
        if (trash_ask) 
        {
            if (drop_option=='correct' ||  drop_option=='discard')
            {
                setTimeout(trash_delete, 10);
            }
            else
            {
                // append removed object to the source table cell
                tables[table_source].rows[row_source].cells[cell_source].appendChild(obj);
                // and recalculate table cells because undelete can change row dimensions
                calculate_cells();
                alert('operation can not allow');
            }

        }

    }
    // else append object to the cell
    else destination_cell.appendChild(obj);
    // recalculate table cells and scrollers because cell content could change row dimensions
    calculate_cells();
}



// onmousemove handler for the document level
// activated after left mouse button is pressed on draggable element
function handler_onmousemove(e){
    // define event (FF & IE)
    var evt = e || window.event;
    // if moved_flag is set and object has clone in class name, then duplicate object
    if (moved_flag == 1 && obj.className.indexOf('clone') > -1){
        moved_flag = 0;
        if (drop_option=='build' ||  drop_option=='correct')
        {
            clone_obj();
        }
    }
    // set left and top styles for the moved element if element is inside window
    // this conditions will stop element on window bounds
    if (evt.clientX > obj_margin[3] && evt.clientX < window_width - obj_margin[1])  obj.style.left = (evt.clientX - mouseX) + "px";
    if (evt.clientY > obj_margin[0] && evt.clientY < window_height - obj_margin[2])	obj.style.top  = (evt.clientY - mouseY) + "px";
    // set current table, row and cell
    set_tcr(evt);
    // if new location is inside table and new location is different then old location
    // set background colors for the previous and new table cell
    if (table < tables.length && (table != table_old || cell != cell_old || row != row_old)){
        // set cell background color to the previous cell
        if (table_old != null && row_old != null && cell_old != null)
            tables[table_old].rows[row_old].cells[cell_old].style.backgroundColor = bgcolor_old;
        // remember background color before setting the new background color
        bgcolor_old = tables[table].rows[row].cells[cell].style.backgroundColor;
        // set background color to the current table cell
        tables[table].rows[row].cells[cell].style.backgroundColor = hover_color;
        // remember current position (for table, row and cell)
        table_old=table; row_old=row; cell_old=cell;
    }
    // test if is still first mouse button pressed (in case when user release mouse button out of a window)
    if (evt.which) mouseButton = evt.which;
    else           mouseButton = evt.button;
    // if first mouse button is released
    if (mouseButton != 1){
        handler_onmouseup(evt);	return;
    }
    // calculate horizontally crossed page bound
    edgeX = bound - (window_width/2  > evt.clientX ? evt.clientX-obj_margin[3] : window_width - evt.clientX - obj_margin[1]);
    // if element crosses page bound then set scroll direction and call auto scroll
    if (edgeX > 0){
        // in case when object is only half visible (page is scrolled on that object)
        if (edgeX > bound) edgeX = bound;
        // set scroll direction: negative - left, positive - right
        edgeX *= evt.clientX < window_width/2 ? -1 : 1;
        // remove onscroll event handler and call autoscrollY function only once
        if (autoscrollX_flag++ == 0) {
            window.onscroll = null; autoscrollX()
        }
    }
    else edgeX = 0;
    // calculate vertically crossed page bound
    edgeY = bound - (window_height/2 > evt.clientY ? evt.clientY-obj_margin[0] : window_height - evt.clientY - obj_margin[2]);
    // if element crosses page bound then set scroll direction and call auto scroll
    if (edgeY > 0){
        // in case when object is only half visible (page is scrolled on that object)
        if (edgeY > bound) edgeY = bound;
        // set scroll direction: negative - up, positive - down
        edgeY *= evt.clientY < window_height/2 ? -1 : 1;
        // remove onscroll event handler and call autoscrollY function only once
        if (autoscrollY_flag++ == 0) {
            window.onscroll = null; autoscrollY()
        }
    }
    else edgeY = 0;
}

// horizontal auto scroll function
function autoscrollX(call){
    // define old scroll position and current scroll position
    var old = 0;
    var scrollPosition = getScrollPosition('X');
    // mouse button should be pressed and
    // if moved element is over left or right margin
    // scroll_width - window_width returns maximum horizontal scroll position
    if (mouseButton == 1 && ((edgeX < 0 && scrollPosition > 0) || (edgeX > 0 && scrollPosition < (scroll_width - window_width)))){
        // horizontal window scroll
        window.scrollBy(edgeX, 0);
        // set previous scroll position and new after window is scrolled
        old = scrollPosition;
        scrollPosition = getScrollPosition('X');
        // set style left for the moved element
        obj.style.left = (parseInt(obj.style.left) + scrollPosition - old) + "px";
        // move X point
        mouseX -= scrollPosition - old;
        // recursive autoscroll call
        setTimeout("autoscrollX('recursive')", speed);
    }
    // autoscroll stopped by moving element out of the page edge
    // or element faced maximum position (left or right)
    else{
        // recalculate cell positions if call was function itself (spare CPU if moving object across bound)
        if (call == 'recursive') calculate_cells();
        // return onscroll event handler and reset auto scroll flag
        window.onscroll  = calculate_cells;
        autoscrollX_flag = 0;
    }
}



// vertical auto scroll function
function autoscrollY(call){
    var top;     // top style
    var old = 0; // define old scroll position
    // define current scroll position
    var scrollPosition = getScrollPosition('Y');
    // mouse button should be pressed and
    // if moved element is over page top or page bottom
    // scroll_height - window_height returns maximum vertical scroll position
    if (mouseButton == 1 && ((edgeY < 0 && scrollPosition > 0) || (edgeY > 0 && scrollPosition < (scroll_height - window_height)))){
        // vertical window scroll
        window.scrollBy(0, edgeY);
        // set previous scroll position and new after window is scrolled
        old = scrollPosition;
        scrollPosition = getScrollPosition('Y');
        // set top style of the object
        top = (isNaN(parseInt(obj.style.top)) ? 0 : parseInt(obj.style.top));
        // set style top for the moved element
        obj.style.top = (top + scrollPosition - old) + "px";
        // move Y point
        mouseY -= scrollPosition - old;
        // recursive autoscroll call
        setTimeout("autoscrollY('recursive')", speed);
    }
    // autoscroll stopped by moving element out of the page edge
    // or element faced maximum position (top or bottom)
    else{
        // recalculate cell positions if call was function itself (spare CPU if moving object across bound)
        if (call == 'recursive') calculate_cells();
        // return onscroll event handler and reset auto scroll flag
        window.onscroll  = calculate_cells;
        autoscrollY_flag = 0;
    }
}



// function returns scroll position in array (variables scrollX & scrollY) set_scroll_position)
// input parameter is dimension (X or Y)
function getScrollPosition(d){
    var scrollX, scrollY; // define scroll position variables
    // Netscape compliant
    if (typeof(window.pageYOffset) == 'number'){
        scrollX = window.pageXOffset;
        scrollY = window.pageYOffset;
    }
    // DOM compliant
    else if (document.body && (document.body.scrollLeft || document.body.scrollTop)){
        scrollX = document.body.scrollLeft;
        scrollY = document.body.scrollTop;
    }
    // IE6 standards compliant mode
    else if (document.documentElement && (document.documentElement.scrollLeft || document.documentElement.scrollTop)){
        scrollX = document.documentElement.scrollLeft;
        scrollY = document.documentElement.scrollTop;
    }
    // needed for IE6 (when vertical scroll bar was on the top)
    else scrollX = scrollY = 0;
    // return scroll position
    if (d == 'X') return scrollX;
    else          return scrollY
}



//
// other functions
//



// calculate table colums and row offsets (cells dimensions)
function calculate_cells(){
    // local variables used in for loops
    var i, j;
    // open loop for each HTML table inside id=drag (tables variable is initialized in onload event)
    for (i=0; i<tables.length; i++){
        // define row offsets variable
        var row_offset = new Array();
        // collect table rows and initialize row offsets array
        var tr = tables[i].getElementsByTagName('tr');
        // backward loop has better perfomance
        for (j=tr.length-1; j>=0; j--) row_offset[j] = box_offset(tr[j]);
        // save table informations (table offset and row offsets)
        tables[i].offset     = box_offset(tables[i]);
        tables[i].row_offset = row_offset;
    }
}



// function sets current table, row and cell
// please note that variables used in this function (table, cell and row)
// are defined at the beginning of the script (global scope)
function set_tcr(evt){
    // define variables for left & right cell offset
    var offsetLeft, offsetRight;
    // define current cell (needed for some test at the function bottom
    var cell_current;
    // find table below draggable object
    for (table=0; table < tables.length; table++){
        // mouse pointer is inside table
        if (tables[table].offset[3] < evt.clientX  &&  evt.clientX < tables[table].offset[1] &&
            tables[table].offset[0] < evt.clientY  &&  evt.clientY < tables[table].offset[2]){
            // row offsets for the selected table (row bounds)
            var row_offset = tables[table].row_offset;
            // find the current row (loop will stop at the current row; row_offset[row][0] is row top offset)
            for (row=0; row<row_offset.length-1 && row_offset[row][0] < evt.clientY; row++)
                if (evt.clientY <= row_offset[row][2]) break;
            // do loop - needed for rowspaned cells (if there is any)
            do{
                // set the number of cells in the selected row
                var cells = tables[table].rows[row].cells.length - 1;
                // find current cell (X mouse position between cell offset left and right)
                for (cell = cells; cell >= 0; cell--){
                    // row left offset + cell left offset
                    offsetLeft = row_offset[row][3] + tables[table].rows[row].cells[cell].offsetLeft;
                    // cell right offset is left offset + cell width
                    offsetRight = offsetLeft + tables[table].rows[row].cells[cell].offsetWidth;
                    // is mouse pointer is between left and right offset, then cell is found
                    if (offsetLeft <= evt.clientX && evt.clientX < offsetRight) break;
                }
            } // mouse pointer is inside table but cell not found (hmm, rowspaned cell - try in upper row)
            while (cell == -1 && row-- > 0)
            // set current cell
            cell_current = tables[table].rows[row].cells[cell];
            // if current cell is marked as 'forbid', then return previous location
            if (cell_current.className.indexOf(forbid) > -1) {
                table=table_old; row=row_old; cell=cell_old; break;
            }
            // if single_content == true and current cell has child nodes then test if cell is occupied
            if (single_content == true &&	cell_current.childNodes.length > 0){
                // if cell has only one node and that is text node then break - because this is empty cell
                if (cell_current.childNodes.length == 1 && cell_current.firstChild.nodeType == 3) break;
                // define and set has_content flag to false
                var has_content = false;
                // open loop for each child node and jump out if 'drag' className found
                for (var i=cell_current.childNodes.length-1; i>=0 ; i--){
                    if (cell_current.childNodes[i].className && cell_current.childNodes[i].className.indexOf('drag') > -1) {
                        has_content = true; break;
                    }
                }
                // if cell has content and old position exists ...
                if (has_content && table_old != null && row_old != null && cell_old != null){
                    // .. and current position is different then source position then return previous position
                    if (table_source != table || row_source != row || cell_source != cell) {
                        table=table_old; row=row_old; cell=cell_old; break;
                    }
                }
            }
            // break table loop
            break;
        }
    }
}



// calculate object (box) offset (top, right, bottom, left)
// function returns array of box bounds
// used in calculate_cells and onmousedown event handler
function box_offset(box){
    var oLeft = 0 - getScrollPosition('X'); // define offset left (take care of scroll position)
    var oTop  = 0 - getScrollPosition('Y'); // define offset top (take care od scroll position)
    // remember box object
    var box_old = box;
    // loop to the root element and return box offset (top, right, bottom, left)
    do {
        oLeft += box.offsetLeft; oTop += box.offsetTop
    } while (box = box.offsetParent);
    // return box offset array
    //       top               right,                     bottom             left
    return [ oTop, oLeft + box_old.offsetWidth, oTop + box_old.offsetHeight, oLeft ];
}

// clone object
function clone_obj(){
    // clone div object and append to the div element (id="obj_new")
    var obj_new = obj.cloneNode(true);
    document.getElementById('obj_new').appendChild(obj_new);
    // offset of the original object
    var offset = box_offset(obj);
    // offset of the new object (cloned)
    var offset_dragged = box_offset(obj_new);
    // calculate top and left offset of the new object
    obj_new.style.top   = (offset[0] - offset_dragged[0]) + "px";
    obj_new.style.left  = (offset[3] - offset_dragged[3]) + "px";
    // set onmouse down event for the new object
    obj_new.onmousedown = handler_onmousedown;
    // remove clone from the class name of the new object
    obj_new.className = obj_new.className.replace('clone', '');
    // append 'd' to the innerHTML of the new object 'Clone' -> 'Cloned'
    obj_new.innerHTML += '*';
    // set new position because div is appended to div id="obj_new"
    mouseX -= parseInt(obj_new.style.left);
    mouseY -= parseInt(obj_new.style.top);
    // replace reference with new object
    obj = obj_new;
}



// delete object
function trash_delete(){
    var div_text; // div content (inner text)
    var border;   // border color (green or blue)
    // find the border color of DIV element (t1 - green, t2 - blue, t3 - orange)
    if (obj.className.indexOf('t1') > 0)      border = 'green';
    else if (obj.className.indexOf('t2') > 0) border = 'gray';
    else border = 'white';
    // set div text (cross browser)
    if (obj.getElementsByTagName('INPUT').length || obj.getElementsByTagName('SELECT').length)
        div_text = 'form element';
    else
        div_text = '"' + (obj.innerText || obj.textContent) + '"';
    // ask if user is sure
    if (!confirm('Delete '+div_text+' ('+border+') from\n table '+table_source+', row '+row_source+' and column '+cell_source+'?')){
        // append removed object to the source table cell
        tables[table_source].rows[row_source].cells[cell_source].appendChild(obj);
        // and recalculate table cells because undelete can change row dimensions
        calculate_cells();
    }
}



// function returns true or false if source tag name is form element
function isFormElement(evt){
    // declare form element and source tag name
    var formElement;
    var srcName;
    // set source tag name for IE and FF
    if (evt.srcElement)	srcName = evt.srcElement.tagName;
    else                srcName = evt.target.tagName;
    // set flag (true or false) for form elements
    switch(srcName){
        case 'INPUT':
        case 'SELECT':
        case 'OPTION':
            formElement = true;
            break;
        default:
            formElement = false;
    }
    // return formElement flag
    return formElement;
}

// function shows how to scan table and display cell content
// (fired on button "Click" click :)
// this function should be customized for your needs
function table_content(id){
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
                        else if (tbl_cell.childNodes[d].className.indexOf('t2') > 0) border = 'gray';
                        else border = 'white';
                        // set message line if div contains form elements
                        if (tbl_cell.childNodes[d].getElementsByTagName('INPUT').length || tbl_cell.childNodes[d].getElementsByTagName('SELECT').length)
                            div_text = 'form element';
                        // for other divs that contains only text (cross browser)
                        else
                            div_text = '"' + (tbl_cell.childNodes[d].innerText || tbl_cell.childNodes[d].textContent) + '"';
                        // add line to the message
                        // add line to the message
                        if(tbl_cell.childNodes[d].id=='')
                        {
                            message += 'row:' + r + ' col:' + c + ' ' + div_text + ' (' + border + ')\n';
                        }
                        else
                        {
                            message += 'row:' + r + ' col:' + c + ' ' + tbl_cell.childNodes[d].id + ' (' + border + ')\n';
                        }
                    }
                }
            }
        }
    }
    // if table is empty print a nice message
    if (message == '') message = 'Individual Board is empty!';
    // display message
    alert(message);
}



// functions toggles trash_ask defined at the top
function toggle_confirm(chk){
    trash_ask = chk.checked;
}

// function toggles single_content defined at the top
function toggle_dropping(chk){
    single_content = !chk.checked;
}



function myhandler_clicked()   {
    if (drop_option=='inspect')
    {
        new_obj();
    }
//    else if (drop_option=='inspect')
//        {
//            alert('otros');
//        }
}


function aleatorio(inferior,superior){
    numPossibilidades = superior - inferior;
    aleat = Math.random() * numPossibilidades;
    aleat = Math.floor(aleat);
    return parseInt(inferior) + aleat;
}




// function sets drop_option parameter defined at the top
function set_drop_option(radio_button){
  
    if(drop_option=='')
    {
        drop_option = radio_button.value;
    }
    else
    {
        alert('the operation '+  drop_option +' has already been chose');
    }
}

// change object
function new_obj(){

    if(!obj.id =='')
    {
        alert('the artifact has already been inspected');
    }
    else
    {
        // clone object and append to the div element (id="obj_new")
        var obj_new = obj.cloneNode(true);
        document.getElementById('obj_new').appendChild(obj);
        // offset of the original object
        var offset = box_offset(obj);
        // offset of the new object (cloned)
        var offset_dragged = box_offset(obj);
        // calculate top and left offset of the new object
        obj.style.top   = (offset[0] - offset_dragged[0]) + "px";
        obj.style.left  = (offset[3] - offset_dragged[3]) + "px";
        // set onmouse down event for the new object
        obj.onmousedown = handler_onmousedown;
        // remove clone from the class name of the new object
        obj.className = obj.className.replace('drag t1', '');

        var ramdomValue = aleatorio(1,10);

        if(ramdomValue>=3)
        {
            //chage obj to img
            obj.innerHTML = '<img src="icon_smile.gif"/>';

            // set id for cloned element
            obj.id = 'C' + cloned_id;
        }
        else
        {
            //chage obj to img
            obj.innerHTML = '<img src="icon_angry.gif"/>';

            // set id for cloned element
            obj.id = 'B' + cloned_id;
        }

        // increment cloned_id
        cloned_id++;
        // set new position because div is appended to div id="obj_new"
        mouseX -= parseInt(obj_new.style.left);
        mouseY -= parseInt(obj_new.style.top);
     
    }

}





