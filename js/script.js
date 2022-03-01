let inputTouched = {
    email: false,
    password: false
}

const inputEmail = document.getElementById("inputEmail")
const inputPassword = document.getElementById("inputPassword")
const inputWrapperEmail = document.getElementById("input-wrapper-email")
const inputWrapperPassword = document.getElementById("input-wrapper-password")
const warningEmail = document.getElementById("warningEmail")
const warningPassword = document.getElementById("warningPassword")
const emails = ["dogukanertunga@gmail.com", "123456789", "test@test.com"];
const pass = ["1234", "qwe321", "aaaa"];


const inputOnBlur = (ev) =>{
    if(inputTouched.email){
        if(!validateEmail(inputEmail.value) && !validatePhone(inputEmail.value)){
            warningEmail.style.display="block"
            inputEmail.style.borderBottom='2px solid #e87c03'
        }
        else{
            warningEmail.style.display="none"
            inputEmail.style.borderBottom="none"
        }
    }
    if(inputTouched.password){
        if(!(inputPassword.value.length >= 4 && inputPassword.value.length <= 60)){
            warningPassword.style.display="block"
            inputPassword.style.borderBottom='2px solid #e87c03'
        }
        else{
            warningPassword.style.display="none"
            inputPassword.style.borderBottom="none"
        }
    }
}

const inputOnFocus = (ev) =>{
    inputTouched[ev.name] = true;
}

const validateEmail = email => {
    const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}

const validatePhone = email => {
    const re = /^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{4,6}$/im;
    return re.test(String(email).toLowerCase());
}

const rememberCheck = document.getElementById("rememberMe");

if (localStorage.checkbox && localStorage.checkbox !== "") {
    rememberCheck.setAttribute("checked", "checked");
  inputEmail.value = localStorage.username;
} else {
    rememberCheck.removeAttribute("checked");
  inputEmail.value = "";
}

function unutamaBeni() {
  if (rememberCheck.checked && inputEmail.value !== "") {
    localStorage.username = inputEmail.value;
    localStorage.checkbox = rememberCheck.value;
  } else {
    localStorage.username = "";
    localStorage.checkbox = "";
  }  
}

function isUserRegistered() {
    var err1 = document.getElementById("err");
    var err2 = document.getElementById("errNotFind");
    var un = emails.indexOf(inputEmail.value);
    var pw = pass.indexOf(inputPassword.value);
    let isUser = false;
    if(un == -1){           //User not found.
        err2.style.display="block"
        console.log("User not found");

    }
    else if(un != pw){      //User found but password is wrong.
        err1.style.display="block"
        isUser = true;
        console.log("Wrong credentials");

    }
    else if(un == pw){      //User found, credentials are correct.
        isUser = true;
        document.location.href = '/mainPage.html'; 
    }
    return isUser;
}


let is_form_checked = false;
document.addEventListener('submit', e => {
    if(!is_form_checked) {
      e.preventDefault();
      //isUserRegistered();
      is_form_checked = true;
    }
  });

  function statusChangeCallback(response) {  // Called with the results from FB.getLoginStatus().
    console.log('statusChangeCallback');
    console.log(response);                   // The current login status of the person.
    if (response.status === 'connected') {   // Logged into your webpage and Facebook.
      testAPI();  
    } else {                                 // Not logged into your webpage or we are unable to tell.
      document.getElementById('status').innerHTML = 'Please log ' +
        'into this webpage.';
    }
  }
  
  
  function checkLoginState() {               // Called when a person is finished with the Login Button.
    FB.getLoginStatus(function(response) {   // See the onlogin handler
      statusChangeCallback(response);
      if(response.status == 'connected'){    // If facebook login is successful, then proceed to the main page.
        successLogin(); 
    }
    });    
  }
  
  window.fbAsyncInit = function() {
    FB.init({
      appId      : '473397624421876',
      cookie     : true,                     // Enable cookies to allow the server to access the session.
      xfbml      : true,                     // Parse social plugins on this webpage.
      version    : 'v13.0'           // Use this Graph API version for this call.
    });
  
  
    FB.getLoginStatus(function(response) {   // Called after the JS SDK has been initialized.
      statusChangeCallback(response);        // Returns the login status.
    });
  };
  
  function testAPI() {                      // Testing Graph API after login.  See statusChangeCallback() for when this call is made.
    console.log('Welcome!  Fetching your information.... ');
    FB.api('/me', function(response) {
    fbName = response.name;

      console.log('Successful login for: ' + response.name);
      document.getElementById('status').innerHTML =
        'Thanks for logging in, ' + response.name + '!';
    });
  }

  function successLogin() {
    document.location.href = 'mainPage.html'  
    }
