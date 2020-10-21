(function($, win, doc) {

    $(doc).ready(function(){

        $(".todo-delete").on('click', function(){
            const id = $(this).prev().val();
            console.log("削除" + "(id : " + id + ")");
            $("#deleteId").val(id);
            $("form[name=deleteForm]").submit();
        });
    });
})(jQuery, window, document);
