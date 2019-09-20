<template>
    <div class="header-container">
        <p class="sid-meiers">SID MEIER'S</p>
        <div class="img-block">
            <img class="civilization" src="./../assets/header/civ.png" alt="civilization">
            <img class="vi" src="./../assets/header/vi.png" alt="vi">
        </div>
        <p class="randomizer">Nations randomizer</p>
    </div>
</template>

<script>
	export default {
		name: "Header"
	}
</script>

<style lang="less">


    .header-container {
        display: flex;
        flex-direction: column;
        align-items: center;
        padding: 15px;

        .sid-meiers {
            font-weight: bolder;
            font-size: 1.7rem;
            font-family: 'Julius Sans One', sans-serif;
            width: 100%;
        }

        .img-block {
            display: flex;
            align-items: center;
            margin: 10px;
            width: 100%;
            justify-content: center;

            .civilization{
                margin: 0 20px;
                max-width: 800px
            }
            .vi {
                margin: 0 20px;
                max-width: 150px

            }
        }

        .randomizer {
            margin-top: 10px;
            font-size: 2rem;
            font-family: 'Julius Sans One', sans-serif;
            font-weight: bolder;
            width: 100%;

        }
    }
</style>