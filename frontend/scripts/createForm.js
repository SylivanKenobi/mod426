function createForm(questions) {

    var str = '';
    for(var i = 0; i < questions.length; i++)
    {
        str += `<input  type=text value="${questions[i].question}" size='40' readonly style='background:transparent; border:none; color:white'></br>`
        str += `<input  type=text size='40'></br>`
        str += `</br>`
    }
    str += "<button type=\"reset\"  id=\"reset\">Zurücksetzen</button>"
    document.getElementById('form').innerHTML = str;

}

