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
	import GreenButton from "../elements/GreenButton";
	import MemberList from "./MemberListBlock";
	import NotActiveButton from "../elements/NotActiveButton";
	import YourBansComponent from "./MemberBansBlock";

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
        align-items: center;
        width: 20%;
        height: 100%;
        background-color: rgba(9, 49, 73, 0.7);
        box-shadow: inset -40px 0 30px -40px rgba(0, 0, 0, 0.3),
        10px 0 10px -10px rgba(0, 0, 0, 0.3);
        border-right: rgba(20, 53, 92, 0.7) solid 3px;
        outline: 3px solid rgb(11, 62, 76);
        outline-offset: -7px;

        .left-menu-module {
            padding-top: 10px;
            padding-left: 3px;
            margin-bottom: 10px;
            display: flex;
            justify-content: center;
            flex-direction: column;
            width: calc(100% - 12px);
        }
    }

    @media (max-width: 850px) {
        .left-menu-container {
            display: none;
        }
    }
</style>