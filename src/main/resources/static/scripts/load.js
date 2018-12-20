var url = '/items';
function loadData(){
    $.getJSON(url,function (json) {
        var tr=[];
        for (var i = 0; i < json.length; i++) {
            tr.push('<tr>');
            tr.push("<td>" + json[i].name + "</td>");
            tr.push("<td>" + json[i].price + "</td>");
            tr.push('</tr>');
        }
        $('table').append($(tr.join('')));
    });
}