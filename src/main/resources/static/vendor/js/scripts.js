$("#validationDefaultPassword").change(function(){
    checkPassword($("#validationDefaultPassword").val());
});
function checkPassword(password){
    if(!/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,25}$/.test(password)){            
        alert('숫자+영문자+특수문자 조합으로 8자리 이상 사용해야 합니다.');
        $('#validationDefaultPassword').val('').focus();
        return false;
    }
    return true;    
}

$(function(){
    $('#validationDefaultPassword').keyup(function(){
        $('#uncorrect').html('');
    });

    $('#validationDefaultRePassword').keyup(function(){
        if($('#validationDefaultPassword').val() != $('#validationDefaultRePassword').val()){
            $('#uncorrect').html('Password is different.');
            $('#uncorrect').attr('color', '#EA1111');
        } else{
            $('#uncorrect').html('It matches.');
            $('#uncorrect').attr('color', '#128036');
        }
    });
});