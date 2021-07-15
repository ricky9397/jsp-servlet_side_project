$(document).ready(function(){
    $('#allCheck').change(function(){
        
        if(this.checked){
            $('.checkItem').prop('checked', true);
        } else {
            $('.checkItem').prop('checked', false);
        }
    });

    $('#form_check').submit(function(){
        if($('.check_1').is(':checked') == false){
            alert('모든 약관에 동의 하셔야 합니다.');
            return false;
        } else if($('.check_2').is(':checked') == false){
            alert('모든 약관에 동의 하셔야 합니다.');
            return false;
        } 
    });
})