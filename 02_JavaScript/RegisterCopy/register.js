const userid = document.querySelector('input#userid');
const pwd1 = document.querySelector('input#pwd1');
const pwd2 = document.querySelector('input#pwd2');
const level = document.querySelector('input#level');
const fullname = document.querySelector('input#fullname');
const email = document.querySelector('input#email');
const tel = document.querySelector('input#tel');
const submitBtn = document.querySelector('button#submit_btn');

submitBtn.addEventListener('click', () => {
    idConfirm();
    pwd1Confirm();
    pwd2Confirm();
    fullnameConfirm();
    emailConfirm();
    telConfirm();
});

function idConfirm() {
    // Null, Undefined, "", 0 = false.
    const mustUserid = document.querySelector('span.must_userid');
    const overlap = document.querySelector('span.overlap');

    mustUserid.style.display = 'none';
    overlap.style.display = 'none';

    if (!userid.value) {
        mustUserid.style.display = 'block';
        // 하나라도 잘못된것이 있으면 제출을 막기위해서 잘못된 상황일경우 false를 반환한다.
        return false;
    } else {
        // 아이디가 중복일경우
        if (!idCheck(userid.value)) {
            overlap.style.display = 'block';
            return false;
        };
    };
    // 잘못된 사항없이 통과했을 경우
    return true;
};

function pwd1Confirm() {
    const mustPwd1 = document.querySelector('span.must_pwd1');
    const regPwd = document.querySelector('span.reg_pwd');

    mustPwd1.style.display = 'none';
    regPwd.style.display = 'none';

    if (!pwd1.value) {
        mustPwd1.style.display = 'block';
        return false;
    } else {
        if (!pwdLetterCheck(pwd1.value)) {
            regPwd.style.display = 'block';
            return false;
        };
    };
    return true;
};

function pwd2Confirm() {
    const mustPwd2 = document.querySelector('span.must_pwd2');
    const same = document.querySelector('span.same');
    
    mustPwd2.style.display = 'none';
    same.style.display = 'none';

    if (!pwd2.value) {
        mustPwd2.style.display = 'block';
        return false;
    } else {
        if (pwd1.value && pwd2.value) {
            if (pwd2.value != pwd1.value) {
                same.style.display = 'block';
                return false;
            };
            return false;
        };
    };
    return true;
};

function fullnameConfirm() {
    const mustFullname = document.querySelector('span.must_fullname');
        
    mustFullname.style.display = 'none';

    if (!fullname.value) {
        mustFullname.style.display = 'block';
        return false;
    }
    return true;
};

function emailConfirm() {
    const mustEmail = document.querySelector('span.must_email');
    const regEmail = document.querySelector('span.reg_email');
        
    mustEmail.style.display = 'none';
    regEmail.style.display = 'none';

    if (!email.value) {
        mustEmail.style.display = 'block';
        return false;
    } else {
        if (!emailCheck(email.value)) {
            regEmail.style.display = 'block';
            return false;
        };
    };
    return true;
};

function telConfirm() {
    const regTel = document.querySelector('span.reg_tel');
            
    regTel.style.display = 'none';

    if (!telCheck(tel.value)) {
        regTel.style.display = 'block';
        return false;
    }
    return true;
};

function idCheck(id) {
    return true;
};

function pwdLetterCheck(pw) {
    // Regex. 정규표현식.
    const reg = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z])(?=.*[!@#$%^&*()_+=\[{\]};:<>|./?,-]).{8,15}$/;
    return reg.test(pw);
}

function emailCheck(email) {
    const reg = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
    return reg.test(email);
}

function telCheck(tel) {
    const reg = /^\d{2,3}-\d{3,4}-\d{4}$/;
    return reg.test(tel);
}