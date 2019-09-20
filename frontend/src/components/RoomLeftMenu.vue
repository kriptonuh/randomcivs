<template>
    <div class="left-menu-container">

        <div class="left-menu-module">
            <NotActiveButton message="Players:"/>
            <MemberList :members="members" current-member=""/>
        </div>
        <div class="left-menu-module">
            <NotActiveButton message="Bans:"/>
            <YourBansComponent :members="members"/>
        </div>
        <div class="left-menu-module ">
            <GreenButton/>
        </div>
    </div>
</template>

<script>
	import GreenButton from "./elements/GreenButton";
	import MemberList from "./MemberList";
	import NotActiveButton from "./elements/NotActiveButton";
	import YourBansComponent from "./YourBansComponent";

	export default {
		components: {
			GreenButton,
			MemberList,
			NotActiveButton,
			YourBansComponent
		},
		props: {
			members: Array,
			currentMember: Object
		},
		name: "RoomLeftMenu"
	}
</script>

<style scoped lang="less">

    .left-menu-container {
        display: flex;
        flex-direction: column;
        justify-content: space-between;
        align-items: center;
        margin-top: 0;
        width: 400px;
        height: 100%;
        background-color: rgba(9, 49, 73, 0.7);
        box-shadow: inset -40px 0 30px -40px rgba(0, 0, 0, 0.3),
        10px 0 10px -10px rgba(0, 0, 0, 0.3);
        border-right: rgba(20, 53, 92, 0.7) solid 3px;
        outline: 4px solid rgb(11, 62, 76);
        outline-offset: -7px;

        .left-menu-module {
            padding-top: 10px;
            padding-left: 3px;
            display: flex;
            justify-content: center;
            flex-direction: column;
            width: calc(100% - 20px);
        }
    }

    @media (max-width: 850px) {
        .left-menu-container {
            display: none;
        }
    }
</style>