<script setup lang="ts">
import DropDownMenu from "@/components/DropDownMenu.vue"
import MatrixBackground from '../components/Matrix-Background.vue'
import { ref } from 'vue';
import { useRouter } from 'vue-router';
const name = ref('');
const router = useRouter();

const submit = () => {
  //Validierung
  router.push({name:'nextView', params: {name: name.value}});
}
</script>

<template>
  <MatrixBackground>
  <div class="login-box">
    <h2>HyperMegaSuperUwUifiedSecrueSoftware© UserCreator3000</h2>
    <form>
      <label> User: </label>
      <div class="user-box">
        <input
          type="user"
          placeholder="Enter Username"
          name="username"
          required
        />
      </div>
        <DropDownMenu :items="['Productowner', 'Tester', 'Dev','Admin']"></DropDownMenu>
      <div>
      
      </div>
    
      <RouterLink :to="{name: 'resetpassword'}" @click="submit">Continue</RouterLink>
      <RouterView/>
      
    </form>
  </div>
</MatrixBackground>
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
    border-bottom: 2px solid #03e9f4;
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
    color: #bbdefb;
  }

  .login-box {
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
    backdrop-filter: blur(10px);
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
</style>
