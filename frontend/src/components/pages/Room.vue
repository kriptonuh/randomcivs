<template>
    <div class="room">
<!--        <h1 class="room-name">{{id}}</h1>-->
        <RoomLeftMenu :members="members"/>
        <LeadersComponent :leaders="leaders" :should-render="showLeaders"/>
        <RandomResultComponent :randomResults="randomResults" :showRardomResults="showRardomResults"/>
    </div>
</template>

<style lang="less">

    .room {
        height: 100%;
        display: flex;
        flex-wrap: wrap;

        .room-name {
            width: 100%;
        }
    }
</style>


<script>
	import LeadersComponent from "../blocks/LeadersBlock";
	import RandomResultComponent from "../blocks/RandomResultBlock";
	import RoomLeftMenu from "../blocks/RoomLeftMenuBlock";

	let memberTemplate = {
		name: "sanyan",
		usedBans: 0,
		isReady: true
	};
	let leaderTemplate = {
		name: "Алиенора Аквитанская",
		description: "Османская империя",
		leader: 'lol',
		icon: "./../src/assets/leaders/Icon_leader_cleopatra.png",
		iconCiv: "./../src/assets/nations/Australian_(Civ6).png",
		uniqueItems: [
			{
				description: "blabla"
			},
			{
				description: "blabla"
			},
			{
				description: "blabla"
			},
			{
				description: "blabla"
			}
		]
	};


	let members = [];
	let leaders = [];
	let randomResults = [];
	let showLeaders = true;
	let showRardomResults = false;

	let socket = null;
	export default {
		props: {
			id: String
		},
		components: {
			LeadersComponent,
			RoomLeftMenu,
			RandomResultComponent
		},
		name: "Room",
		data() {
			return {
				members: members,
				leaders: leaders,
				showLeaders: showLeaders,
				showRardomResults: showRardomResults,
				randomResults: randomResults
			}
		},
		methods: {},
		created: function () {
			socket = new WebSocket("ws://" + location.hostname + ":" + 9000 + "/randomizer");

			if(leaders.length ===0) {
				for (let i = 0; i < 46; i++) {
					leaders.push(leaderTemplate)
				}
				for (let i = 0; i < 8; i++) {
					members.push(memberTemplate)
				}
				for (let i = 0; i < 8; i++) {
					let randomResult = {};
					randomResult.member = memberTemplate;

					let options = [];
					for (let i = 0; i < 3; i++) {
						options.push(leaderTemplate)
					}
					randomResult.options = options;
					randomResults.push(randomResult)
				}
			}
		},
		mounted: function () {
			socket.onmessage = (function (message) {
				members = members.push(message.data);
			});

		}
	}


</script>