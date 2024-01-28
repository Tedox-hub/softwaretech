<template>
    <MatrixBackground>
    <div class="reset-box">
    <h2>HyperMegaSuperUwUifiedSecrueSoftware© PasswordReset4500</h2>
    <form>
        <br><h1>Hallo {{ $route.params.name }}</h1>
        <div class="user-box">
            <input type="user" placeholder="Enter Usernname" name="username" required v-model="user">
        </div>
        <button id="resetPW">Passwort zurücksetzen</button>
            <button id="backToLogin" @click.prevent="backLogin">Zurück zum Login</button><br>
            <label for="fastLogin">DANGER:</label>
            <button id="fastLogin">Admin-Schnell-Login</button>
        </form>
      </div>
    </MatrixBackground>
</template>

<script setup lang="ts">
import { useRouter } from 'vue-router';
import { ref } from 'vue';

const user = ref("");


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
    color: #BBDEFB;
}



</style>