<script setup lang="ts">
import HelloWorld from './components/HelloWorld.vue'
import TheWelcome from './components/TheWelcome.vue'
import MatrinBackground from './components/Matrix-Background.vue'
import LoginPage from './components/LoginPage.vue'
import PasswordReset from './components/PasswordReset.vue'
import NewUser from "./components/NewUser.vue"
import { ref } from 'vue';


const side = ref(0);

function itterate() {
  side.value+=1;
  side.value %= 3;
}
</script>

<template>
 
  
  <MatrinBackground>
    <LoginPage v-if="side == 0"></LoginPage>
    <PasswordReset v-if="side==1"></PasswordReset>
    <NewUser v-if="side==2"></NewUser>
  </MatrinBackground>
  <button class="movable-object littlebutton" @click="itterate">itterate</button>
  
</template>

<style scoped>

h1 {
    color: red;
}

h2 {
  margin: 0 0;
}

input {
  border: 0;
  border-bottom: 2px solid #1976D2;
  width: 80%;
  font-size: inherit;
  text-align: left;
  padding-left: 1rem;
  background: #000000cc;
	color: white;
  border-radius: 1rem;
}

input::placeholder {
 color: #eee;
}

input:focus {
 outline: 0;
	color: #BBDEFB;
}


.login-box{
  position: absolute;
  top: 50%;
  left: 50%;
  padding: 2.5rem;
  font-size: 30px;
  color: white;
  box-sizing: border-box;
  box-shadow: 0 50px 50px rgba(0, 0, 0, 0.6);
  transform: translate(-50%, -50%);
  border-radius: 15px;
  background: #3338;
  backdrop-filter: blur(10px)
}


button {  
        width: 100%;
        padding: 15px;   
        margin-top: 3rem; 
        border: none;   
        cursor: pointer;
        box-sizing: border-box;
        box-shadow: 0 15px 25px rgba(0, 0, 0, 0.6);
        border-radius: 10px;
        opacity: 0.3;
}

.littlebutton {
  width: unset;
  position: absolute;
}

  .login-box form a {
    position: relative;
    display: inline-block;
    padding: 10px 20px;
    color: #03e9f4;
    font-size: 16px;
    text-decoration: none;
    text-transform: uppercase;
    overflow: hidden;
    transition: 0.5s;
    margin-top: 3.5em;
    letter-spacing: 4px;
    background: #333;
    border-radius: 4px;
  }

  .login-box a:hover {
    background: #03e9f4;
    color: #fff;
    border-radius: 5px;
    box-shadow: 0 0 5px #03e9f4, 0 0 25px #03e9f4, 0 0 50px #03e9f4,
      0 0 100px #03e9f4;
  }


  .login-box a span {
    position: absolute;
    display: block;
  }

.login-box a span:nth-child(1) {
    top: 0;
    left: -100%;
    width: 100%;
    height: 2px;
    background: linear-gradient(90deg, transparent, #03e9f4);
    animation: btn-anim1 1s linear infinite;
  }

@keyframes btn-anim1 {
    0% {
      left: -100%;
    }
    100%,
    50% {
      left: 100%;
    }
  }
  
  .login-box a span:nth-child(2) {
    top: -100%;
    right: 0;
    width: 2px;
    height: 100%;
    background: linear-gradient(180deg, transparent, #03e9f4);
    animation: btn-anim2 1s linear infinite;
    animation-delay: 0.25s;
  }
    @keyframes btn-anim2 {
    0% {
      top: -100%;
    }
    100%,
    50% {
      top: 100%;
    }
  }


  .login-box a span:nth-child(3) {
    bottom: 0;
    right: -100%;
    width: 100%;
    height: 2px;
    background: linear-gradient(270deg, transparent, #03e9f4);
    animation: btn-anim3 1s linear infinite;
    animation-delay: 0.5s;
  }
  
  @keyframes btn-anim3 {
    0% {
      right: -100%;
    }
    100%,
    50% {
      right: 100%;
    }
  }
  
  .login-box a span:nth-child(4) {
    bottom: -100%;
    left: 0;
    width: 2px;
    height: 100%;
    background: linear-gradient(360deg, transparent, #03e9f4);
    animation: btn-anim4 1s linear infinite;
    animation-delay: 0.75s;
  }
  
  @keyframes btn-anim4 {
    0% {
      bottom: -100%;
    }
    100%,
    50% {
      bottom: 100%;
    }
  }

  body {
  margin: 0;
  overflow: hidden;
}
  

</style>
