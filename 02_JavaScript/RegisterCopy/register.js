const userid = document.querySelector('input#userid');
const pwd1 = document.querySelector('input#pwd1');
const pwd2 = document.querySelector('input#pwd2');
const level = document.querySelector('input#level');
const fullname = document.querySelector('input#fullname');
const email = document.querySelector('input#email');
const tel = document.querySelector('input#tel');
const submitBtn = document.querySelector('button#submit_btn');
const mustInput = document.querySelectorAll('input[required]');


submitBtn.addEventListener('click', () => {
    chkRequired();
});

function idConfirm() {
    if (userid.value){}
};



function chkRequired() {
    for (var i = 0; i < mustInput.length; i++){
        if (mustInput[i].value == '') {
            console.log(mustInput[i].value);
            mustInput[i].nextElementSibling.setAttribute('display', 'block');
        }
    }
};