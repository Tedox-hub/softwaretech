<script setup lang="ts">
import MatrixBackground from './components/Matrix-Background.vue'
import { RouterLink, RouterView } from 'vue-router'

import { ref } from 'vue';
let username = ref(null);
let role = ref(null)

</script>

<template>
  <nav>
    <RouterLink :to="{ name: 'workspace', params: { user: 'UwU', role: 'admin' } }" >Workspace</RouterLink>
    <RouterLink to="/login">Login</RouterLink>
    <RouterLink to="/newuser">New User</RouterLink>
    <RouterLink to="/resetpassword">Reset Password</RouterLink>
    <RouterLink :to="{ name: 'workspace', params: { user: 'erina', role: 'admin' } }">User</RouterLink>
  </nav>
  <RouterView />
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

 .testbutton {
  margin-top: 6rem; 

 }

 header {
  line-height: 1.5;
  max-height: 100vh;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

nav {
  z-index: 1000;
  width: 100%;
  font-size: 12px;
  text-align: center;
  margin-top: 2rem;
  margin-left: 2rem;
  background: #3338;
  backdrop-filter: blur(10px);
  border-radius: 1rem;
}

nav a.router-link-exact-active {
  color: var(--color-text);
}

nav a.router-link-exact-active:hover {
  background-color: transparent;
}

nav a {
  display: inline-block;
  padding: 0 1rem;
  border-left: 1px solid var(--color-border);
}

nav a:first-of-type {
  border: 0;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }

  nav {
    text-align: left;
    margin-left: 1rem;
    font-size: 1rem;

    padding: 1rem 0;
    margin-top: 1rem;
  }
}
  

</style>
