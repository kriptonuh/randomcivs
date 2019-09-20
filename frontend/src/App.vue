<template>
    <div class="app">
        <header>
            <Header/>
        </header>
        <menu class="menu" v-show="showMenu">
            <router-link v-on:click.native="" to="/createRoom">Создать игру</router-link>
            <router-link v-on:click.native="" to="/room/1">присоединиться к игре 1</router-link>
            <router-link v-on:click.native="" to="/room/2">присоединиться к игре 2</router-link>
        </menu>
        <main class="main-area">
            <router-view></router-view>
        </main>
        <video class="background-video" autoplay muted loop>
            <source src="./assets/video/civ_background_cycled.mp4" type="video/mp4"/>
        </video>
    </div>
</template>

<script>
	import Room from './components/Room.vue';
	import CreateRoom from './components/CreateRoom.vue';
	import VueRouter from "vue-router";
	import Vue from "vue";
	import Header from "./components/Header";

	const router = new VueRouter({
		mode: 'history',
		routes: [
			{
				path: '/createRoom',
				component: CreateRoom
			},
			{
				path: '/room/:id',
				component: Room,
				props: true
			}
		]
	});

	Vue.use(VueRouter);

	let showMenu = true;

	export default {
		name: 'app',
		components: {
			Room,
			Header
		},
		data: function () {
			return {
				showMenu: showMenu
			}
		},
		methods: {
			test: function (event) {
				// `this` внутри методов указывает на экземпляр Vue
				alert('Привет, ' + '!');
				// `event` — нативное событие DOM
				if (event) {
					alert(event.target.tagName)
				}
			}
		},
		router: router
	}
</script>

<style lang="less">
    //@color: #215181;

    // Mode: Mobile
    @mobile: 800px;
    @mobile-area: 800px;

    // Mode: Tablet
    @tablet: 1200px;
    @tablet-area: 1024px;

    // Mode: Desktop
    @desktop: 1400px;
    @desktop-area: 1350px;

    * {
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        box-sizing: border-box;
        margin: 0;
        padding: 0;
        color: #fff;
        font-family: 'Fira Code', monospace;
    }

    .main-area-template {
        padding: 13px;
        background-color: rgba(25, 55, 93, 0.8);
        outline: 4px solid #0b1d32;
        outline-offset: -14px;
        box-shadow: 0 0 10px 10px rgba(0, 0, 0, 0.2),
        inset 0 0 30px 30px rgba(0, 0, 0, 0.3);
    }

    .app {
        font-family: 'Avenir', Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #2c3e50;

        width: 100%;
        height: 100vh;
        align-items: center;
        display: flex;
        flex-direction: column;
        justify-content: center;
        overflow: hidden;

        header {
            height: 250px;
            .main-area-template;
        }

        .menu {
            margin: 2px 0;
            height: 60px;
            .main-area-template;
            outline: none;
            border-top: 4px solid #896714;
            border-bottom: 4px solid #705511;
            box-shadow: inset 0 0 10px 10px rgba(35, 35, 35, 0.3),
            0 0 10px 10px rgba(0, 0, 0.2, 0.2);
        }

        .main-area {
            top: 0;
            left: 0;
            height: 100%;
            .main-area-template;
        }

        .background-video {
            -o-object-fit: cover;
            object-fit: cover;
            position: absolute;
            width: 100%;
            height: 100%;
            top: 0;
            left: 0;
            z-index: -1;
        }
    }

    h1, h2 {
        font-weight: normal;
    }

    @media (max-width: @tablet) {
        header {
            width: 100%;
        }

        .main-area {
            width: 100%;
        }

        .menu {
            width: 100%;
        }

        img {
            height: 50px;
        }
    }

    @media (min-width: @desktop) {
        header {
            width: 70%;
        }

        .main-area {
            width: 70%;
        }

        .menu {
            width: 70%;
        }

        img {
            height: 80px;
        }
    }
</style>
