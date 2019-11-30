// gets the object from the backend
function httpGet(discipline)
{
    $.getJSON("http://localhost:8080/api/discipline/" + discipline, function(discipline) {
        console.log(discipline);
    });
}
