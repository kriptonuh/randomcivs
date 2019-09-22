<template>
    <div class="create-room-form">
        <div class="common-settings">
<!--            <select v-model="selected">-->
<!--                <option disabled value="">Выберите один из вариантов</option>-->
<!--                <option>A</option>-->
<!--                <option>Б</option>-->
<!--                <option>В</option>-->
<!--            </select>-->
            <span>Выбрано: {{selected}}</span>
        </div>
        <div class="content-settings">

        </div>
        <GreenButton message="Create"/>
    </div>
</template>

<style lang="less">
    .create-room-form {
        margin: auto;
        width: 40%;
        display: flex;
        flex-direction: column;
    }
    select{
        color: black;
    }

</style>


<script>

	import GreenButton from "../elements/GreenButton";

	let selected = 'A';

	export default {
		name: "CreateRoom",
		props: {},
		data() {
			return {
				selected: ''
			}
		},
		components:{
		    GreenButton
        }
	}
</script>