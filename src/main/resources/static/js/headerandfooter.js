$(document).ready(function () {
    function format(x) {
        x = x.toLocaleString('vi', {style : 'currency', currency : 'VND'});
        return x
    }
    $('.price-cart').each(function () {
        $(this).text(format(parseInt($(this).text())))
    })

    var ajax = new XMLHttpRequest();
    var list = []
    ajax.open("GET", "http://" + window.location.host + "/api/product/getall", true);
    ajax.onload = function () {
        list = JSON.parse(ajax.responseText).data
        var suggest = []
        for (var label of list) {
            suggest.push(reName(label))
        }

        function reName(label) {
            var obj = {}
            var money = format(parseInt(label.price))
            function format(x) {
                x = x.toLocaleString('vi', {style : 'currency', currency : 'VND'});
                return x
            }
            obj.label = "<img style='height: 50px;width: 50px' src='" + label.image + "'/> " + "<span style='font-size: 90%'; >" + label.name + "</span>" + "<span  style='font-size: 90%;color: red; font-weight: bold'> " +money+ "</span>"
            obj.value = label.name
            return obj
        }

        new Awesomplete(document.querySelector("#ajax-example input"), {list: suggest});
        // get img sp


    };
    ajax.send();



})

// function reName(label) {
//     var obj = {}
//     var money = format(parseInt(label.price))
//     function format(x) {
//         x = x.toLocaleString('vi', {style : 'currency', currency : 'VND'});
//         return x
//     }
//     obj.label = "<img style='height: 50px;width: 50px' src='"+label.image+"'/> "+"<span style='font-size: 90%'>"+label.name+"</span><span class='money' style='color: red;margin-left:10px'>"+money+"</span>"
//     obj.value = label.name
//     return obj
// }