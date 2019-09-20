<template>
    <div class="member-list">
        <h2 class="member-list-title">Players:</h2>
        <div class="members" v-for="member in members" style="width: 20%">
            <div class="member">
                <p class="member-name">{{member.name}}:</p>
                <p class="member-bans">{{member.usedBans}}/5 bans</p>
                <img class="member-ready-icon" src="./../assets/logo.png" alt="./src/assets/logo.png"/>
            </div>
        </div>
    </div>
</template>

<script>
	export default {
		props: {
			members: Array
		},
		name: "MemberList"
	}
</script>

<style scoped lang="less">

    .member-list {
        display: flex;
        flex-direction: column;
        align-items: start;
        margin-left: 10%;
        margin-top: 0;
        width: 10%;

        .member-list-title {

        }

        .members {
            display: flex;
            flex-direction: column;
            flex-wrap: nowrap;

            .member {
                margin: 0px;
                display: flex;
                align-items: center;

                .member-name {
                    margin: 0px;
                    white-space: nowrap;
                }

                .member-bans {
                    margin-left: 20px;
                    margin-top: 0px;
                    margin-bottom: 0px;
                    white-space: nowrap;
                }

                .member-ready-icon{
                    width: 15px;
                    height: 15px;
                    margin: 0px 10px;
                }
            }
        }
    }

    @media (max-width: 850px) {
        .member-list {
            display: none;
        }
    }
</style>