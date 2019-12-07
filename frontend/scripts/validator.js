// Validate the answers
function validate(discipline, answer, id) {
    let questions = discipline.questions;
    let answerNr = id.substring(6);
    if (answer == questions[answerNr].answer) {
        document.getElementById(id).style.borderColor = "green";
    } else {
        document.getElementById(id).style.borderColor = "red";
    }
}
