<template>
    <div class="member-list">
        <ul class="members">
            <li class="member" v-for="member in members">
                <p class="member-name">{{member.name}}:</p>
                <p class="member-bans">Bans: {{member.usedBans}}/5</p>
                <img class="member-ready-icon" src="../../assets/logo.png" alt="./src/assets/logo.png"/>
            </li>
        </ul>
    </div>
</template>

<script>
	export default {
		props: {
			members: Array,
			currentMember: Object
		},
		name: "MemberList"
	}
</script>

<style lang="less">
    .member-list {
        width: 100%;
        display: flex;
        flex-direction: column;

        .members {
            width: 100%;

            .member {
                padding: 7px 7px;
                width: 100%;
                list-style-type: none;
                display: flex;
                flex-direction: row;
                justify-content: space-between;
                align-items: center;
                border-bottom: #0b1d32 solid 2px;


                .member-name {
                    font-size: 1rem;
                    white-space: nowrap;
                    color: rgb(195, 200, 209);
                    text-align: left;
                }

                .member-bans {
                    margin-top: 0px;
                    margin-bottom: 0px;
                    white-space: nowrap;
                    font-size: 1rem;
                    color: rgb(195, 200, 209);
                    text-align: right;
                }

                .member-ready-icon {
                    width: 20px;
                    height: 20px;
                }
            }
        }
    }

    @media (max-width: 850px) {
        .left-menu-container {
            display: none;
        }
    }
</style>