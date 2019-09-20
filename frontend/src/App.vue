<template>
    <div class="app">
        <header>
            <p class="sid-meiers">SID MEIER'S</p>
            <div class="svg-block">
                <img class="civilization" src="./assets/header/civ.png" alt="civilization">
                <img class="vi" src="./assets/header/vi.png" alt="vi">
            </div>
            <p class="randomizer"></p>
        </header>
        <menu class="menu" v-show="showMenu">
            <router-link v-on:click.native="showMenu=false" to="/createRoom">Создать игру</router-link>
            <router-link v-on:click.native="showMenu=false" to="/room/1">присоединиться к игре 1</router-link>
            <router-link v-on:click.native="showMenu=false" to="/room/2">присоединиться к игре 2</router-link>
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
			Room
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
    @tablet: 1000px;
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
    }

    .main-area-template {
        background-color: #19375d;
        opacity: 0.7;
        outline: 4px solid #0b1d32;
        outline-offset: -14px;
        box-shadow: 0 0 10px 10px rgba(0, 0, 0.2, 0.3),
        inset 0 0 30px 30px rgba(0, 0, 0.3, 0.3);
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
            padding: 20px;
            height: 250px;
            .main-area-template;
            display: flex;
            flex-direction: column;
            align-items: center;

            .sid-meiers {
                font-weight: bolder;
                font-size: 1.7rem;
                font-family: 'Julius Sans One', sans-serif;
            }

            .svg-block {
                display: flex;
                align-items: center;
                margin: 10px;

                img {
                    margin: 0 20px;

                }
                img:hover {
                    fill: red;
                }


            }
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

        img {
            height: 80px;
        }
    }
</style>
