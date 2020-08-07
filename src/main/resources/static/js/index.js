$(function() {

    //loading.show();
    $.ajax({
        url:'/ajax/related-categories',
        method:'GET',
        success:function (response) {
            console.log(response)
            $('#related-categories').html(response)
            //loading.hide()
        },
        error:function (error) {
            console.log(error)
        }
    })

});