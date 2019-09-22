<template>
        <span class="non-clickable-button" :customStyle="customStyle">
            {{message}}
        </span>
</template>

<script>
	export default {
		props: {
			message: String,
			customStyle: String
		},
		name: "NotActiveButton"
	}
</script>

<style scoped lang="less">

    .non-clickable-button {
        background: radial-gradient(at bottom, rgba(12, 81, 81, 0.5), rgba(6, 36, 57, 1));
        border: rgb(11, 62, 76) solid 3px;
        width: 100%;
        height: 40px;
        border-radius: 5px;
        display: flex;
        align-items: center;
        flex-direction: column;
        box-shadow: inset 0 -5px 5px -5px #333,
        0px 0 10px 10px rgba(0, 0, 0, 0.3);

        font-size: 1.4rem;
        color: rgb(195, 200, 209);
        font-weight: bolder;
        justify-content: center;
    }
</style>