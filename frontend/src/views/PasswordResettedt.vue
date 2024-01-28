<template>
    <div class="reset-box">
    <h2>HyperMegaSuperUwUifiedSecrueSoftware© PasswordReset4500</h2>
    <form>
        <br><h1>Hallo</h1>
        <label>Dein neues Passwort:</label> admin<br>
        <button id="backToLogin" @click.prevent="backLogin">Zurück zum Login</button><br>
        <label for="fastLogin">DANGER:</label>
        <button id="fastLogin">Admin-Schnell-Login</button>
    </form>
  </div>
</template>

<script setup lang="ts">
import { useRouter } from 'vue-router';

const router = useRouter();
const backLogin = () => {
    router.push('/login');
};

defineExpose({
    backLogin
});
</script>

<style scoped>
h1 {
    color: #03e9f4;
    font-size: 1em;
}

h2 {
    margin: 0 0;
}

.reset-box {
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
    border: none;
    cursor: pointer;
    margin: 20px 15px 20px 0px;
}

button:hover {
    background: #03e9f4;
    color: #fff;
    border-radius: 5px;
    box-shadow: 0 0 5px #03e9f4, 0 0 25px #03e9f4, 0 0 50px #03e9f4,
        0 0 100px #03e9f4;
}

button[id="fastLogin"] {
    opacity: 0.6;
}

label[for="fastLogin"] {
    color: rgb(235, 123, 123);
    font-size: 0.7em;
    margin-top: 1em;
}
</style>