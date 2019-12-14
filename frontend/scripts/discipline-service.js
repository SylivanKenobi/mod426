// gets the requested discipline from the backend
function httpGet(discipline) {
    return $.ajax({
        url: `http://localhost:8080/api/discipline/${discipline}`,
        type: 'GET',
        datatype: 'json',
    });
}
