$(document).ready(function () {
    axios.get("/api/user/all-users").then(function (res){
        if (res.data.success) {
            for (var users of res.data.data) {
                $('#Mytable > tbody').append(`
                <tr>
                            
                            <td>${users.user.id}</td>
                            <td><img src="${users.user.image}" alt="không hiểu" style="width:250px; height:250px;"></td>
                            <td>${users.user.username}</td>
                            <td><p>${users.user.realname}</p></td>
                            <td>${users.user.createdDate}</td>
                            <td>${users.role.desc}</td>
                            <td><button class="btn btn-danger btn-ban-role" data-id="${users.user.id}">${users.status}</button> 
                            </tr>
                `)
            }

            $('.btn-ban-role').on('click',function () {
                var id = $(this).data('id');
                axios.get("/api/user/disable/" + id).then(function (value) {
                    console.log(value.data);
                    if(value.data.success){
                        swal (
                            "Thành công",
                            value.data.message,
                            'success'
                        ).then(function (value1) {
                            location.reload()
                        })
                    }else {
                        console.log(value.data.message)
                    }
                })
            })

            $('#Mytable').DataTable();
            // console.log($(".btn-remove-news"))
        }
    })

})