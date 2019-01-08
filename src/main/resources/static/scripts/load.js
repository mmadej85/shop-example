function loadProductsData(){
    $.getJSON('/items',function (json) {
        var tr=[];
        for (var i = 0; i < json.length; i++) {
            tr.push('<tr>');
            tr.push("<td>" + json[i].id + "</td>");
            tr.push("<td>" + json[i].name + "</td>");
            tr.push("<td>" + json[i].price + "</td>");
            tr.push('</tr>');
        }
        $('table.products').append($(tr.join('')));
    });
}

function loadPromotionsData(){
    $.getJSON('/promotions',function (json) {
       var tr=[];
        for (var i = 0; i < json.length; i++) {
            tr.push('<tr>');
            tr.push("<td>" + json[i].item.name + "</td>");
            tr.push("<td>" + json[i].percentage + "%</td>");
            tr.push('</tr>');
        }
        $('table.promotions').append($(tr.join('')));
      });
}