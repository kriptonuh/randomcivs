<template>
    <div class="member-list-container">
        <span class="member-list-button">
            <h2>Players:</h2>
        </span>
        <div class="member-list">
            <ul class="members">
                <li class="member" v-for="member in members">
                    <p class="member-name">{{member.name}}:</p>
                    <p class="member-bans">Bans: {{member.usedBans}}/5</p>
                    <img class="member-ready-icon" src="./../assets/logo.png" alt="./src/assets/logo.png"/>
                </li>
            </ul>
        </div>

        <span class="member-list-button">
            <h2>Your bans:</h2>
        </span>
        <div class="member-list">
            <ul class="members">
                <li class="member" v-for="member in members">
                </li>
            </ul>
        </div>


        <span class="green-button-frame">
            <button class="green-button">
                Ready
            </button>
        </span>
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

<style scoped lang="less">

    .member-list-container {
        display: flex;
        flex-direction: column;
        margin-top: 0;
        width: 400px;
        height: 100%;
        background-color: rgba(9, 49, 73, 0.7);
        box-shadow: inset -40px 0 30px -40px rgba(0, 0, 0, 0.3),
        10px 0 10px -10px rgba(0, 0, 0, 0.3);
        border-right: rgba(20, 53, 92, 0.7) solid 3px;
        outline: 4px solid rgb(11, 62, 76);
        outline-offset: -7px;
        justify-content: flex-start;
        align-items: center;

        .green-button-frame {
            display: flex;
            align-items: center;
            margin-top: 10px;
            margin-left: 3px;
            width: calc(100% - 20px);
            height: 60px;
            background: linear-gradient(rgb(110, 91, 56), #705511);
            border: 2px solid rgb(178, 148, 97);
            border-radius: 5px;
            box-shadow: inset 0 -7px 10px -7px #000000,
            inset 0 3px 5px -3px #e2e2e2,
                inset -7px 0 7px -7px #000000,
            inset 7px 0 7px -7px #000000;

            .green-button {
                background: linear-gradient(rgb(8, 64, 51), rgb(2, 142, 98), rgb(8, 64, 51));
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
                font-size: 2rem;
                color: rgb(195, 200, 209);
                font-weight: bolder;

                &:hover {
                    background: linear-gradient(rgb(2, 99, 68), rgb(19, 151, 120), rgb(1, 91, 63));
                    color: rgb(223, 229, 239);
                }

                &:active {
                    background: linear-gradient(rgb(5, 40, 32), rgb(1, 60, 41), rgb(5, 38, 29));
                    color: rgb(92, 95, 99);
                    border: 2px solid rgb(196, 164, 107);
                    outline:none;
                }
                &:focus {
                    outline:none;
                }

            }
        }

        .member-list-button {
            margin-top: 10px;
            margin-left: 3px;
            background: radial-gradient(at bottom, rgba(12, 81, 81, 0.5), rgba(6, 36, 57, 1));
            border: rgb(11, 62, 76) solid 3px;
            width: calc(100% - 20px);
            height: 50px;
            border-radius: 5px;
            display: flex;
            align-items: center;
            flex-direction: column;
            box-shadow: inset 0 -5px 5px -5px #333,
            0px 0 10px 10px rgba(0, 0, 0, 0.3);

            h2 {
                margin: auto;
                font-size: 2rem;
                color: rgb(195, 200, 209);
                font-weight: bolder;
            }
        }

        .member-list {
            width: 100%;
            margin-top: 10px;
            display: flex;
            flex-direction: column;

            .members {
                width: 100%;

                .member {
                    padding: 10px 10px;
                    width: 100%;
                    list-style-type: none;
                    display: flex;
                    flex-direction: row;
                    justify-content: space-between;
                    align-items: center;
                    border-bottom: #0b1d32 solid 2px;


                    .member-name {
                        font-size: 1.5rem;
                        white-space: nowrap;
                        color: rgb(195, 200, 209);
                        text-align: left;
                    }

                    .member-bans {
                        margin-top: 0px;
                        margin-bottom: 0px;
                        white-space: nowrap;
                        font-size: 1.5rem;
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
    }

    @media (max-width: 850px) {
        .member-list-container {
            display: none;
        }
    }
</style>