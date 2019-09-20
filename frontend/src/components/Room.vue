<template>
    <div class="room">
        <h1 class="room-name">{{id}}</h1>
        <MemberList :members="members"/>
        <LeadersComponent :leaders="leaders" :should-render="showLeaders"/>
        <RandomResultComponent :randomResults="randomResults" :showRardomResults="showRardomResults"/>
    </div>
</template>

<style lang="less">

    .room {
        display: flex;
        flex-wrap: wrap;

        .room-name {
            width: 100%;
        }
    }
</style>


<script>
	import LeadersComponent from "./LeadersComponent";
	import MemberList from "./MemberList";
	import RandomResultComponent from "./RandomResultComponent";

	let memberTemplate = {
		name: "sanyan",
		usedBans: 0,
		isReady: true
	};
	let leaderTemplate = {
		name: "Алиенора Аквитанская",
		description: "Османская империя",
		leader: 'lol',
		icon: "./../src/assets/logo.png",
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
			MemberList,
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
		},
		mounted: function () {
			socket.onmessage = (function (message) {
				members = members.push(message.data);
			});

		}
	}


</script>