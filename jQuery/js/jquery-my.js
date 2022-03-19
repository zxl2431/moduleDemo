function  jQuery(selector) {
    console.log(selector)
    var id = selector.substring(1);
    console.log(id);
    var element = document.getElementById(id);
    return element;

}

$=jQuery;