<template>
        <span class="green-button-frame">
            <button class="green-button">
                Ready
            </button>
        </span>
</template>

<script>
	export default {
		props: {
			message: String
		},
		name: "GreenButton"
	}
</script>

<style scoped lang="less">
    .green-button-frame {
        display: flex;
        align-items: center;
        width: 100%;
        height: 50px;
        background: linear-gradient(rgb(110, 91, 56), #705511);
        border: 2px solid rgb(178, 148, 97);
        border-radius: 5px;
        box-shadow: inset 0 -7px 10px -7px #000000,
        inset 0 3px 5px -3px #e2e2e2,
            inset -7px 0 7px -7px #000000,
        inset 7px 0 7px -7px #000000;

        .green-button {
            background: linear-gradient(rgb(8, 64, 51), rgb(2, 142, 88), rgb(8, 64, 51));
            width: 100%;
            height: 100%;
            border-radius: 25px;
            border: 2px solid rgb(169, 141, 92);
            box-shadow: inset 0 -7px 10px -7px #000000,
            inset 0 3px 5px -3px #e2e2e2,
                inset -7px 0 7px -7px #000000,
            inset 7px 0 7px -7px #000000;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            margin: auto;
            font-size: 1.4rem;
            color: rgb(195, 200, 209);
            font-weight: bolder;

            &:hover {
                background: linear-gradient(rgb(2, 75, 52), rgb(19, 151, 110), rgb(1, 91, 63));
                color: rgb(223, 229, 239);
            }

            &:active {
                background: linear-gradient(rgb(5, 40, 32), rgb(1, 60, 41), rgb(5, 38, 29));
                color: rgb(92, 95, 99);
                border: 2px solid rgb(124, 104, 68);
                outline: none;
            }

            &:focus {
                outline: none;
            }
        }

        &:active {
            border: 2px solid rgb(124, 104, 68);
            background: linear-gradient(rgb(63, 52, 32), #211905);
        }
    }
</style>