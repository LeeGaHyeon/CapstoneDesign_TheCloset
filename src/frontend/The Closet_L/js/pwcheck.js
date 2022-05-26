function check_pw(){

    var pw = document.getElementById('pw').value;
    var pw2 = document.getElementById('pw2').value;
    var SC = ["!","@","#","$","%"];
    var check_SC = 0;

    if(document.getElementById('pw').value !='' && document.getElementById('pw2').value!=''){
        if(document.getElementById('pw').value==document.getElementById('pw2').value){
            document.getElementById('check').innerHTML='비밀번호가 일치합니다.'
            document.getElementById('check').style.color='blue';
        }
        else{
            document.getElementById('check').innerHTML='비밀번호가 일치하지 않습니다.';
            document.getElementById('check').style.color='red';
        }
    }
}

