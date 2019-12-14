// Method to create a dynamic form to answer questions
function createForm(discipline) {
    let questions = discipline.questions;
    //change name of variable str
    var questionAnswerForm = '';
    for (var i = 0; i < questions.length; i++) {
        questionAnswerForm += `<input  type=text value="${questions[i].question}" size='40' readonly style='background:transparent; border:none; color:white'></br>`
        questionAnswerForm += `<input  type=text size='40' id=${'answer' + i} onchange=validate(discipline,this.value,this.id)></br>`
        questionAnswerForm += `</br>`
    }
    questionAnswerForm += "<button type=\"reset\"  class=\"btn btn-secondary btn-sm\" id=\"reset\">Zurücksetzen</button>"
    document.getElementById('form').innerHTML = questionAnswerForm;
}

