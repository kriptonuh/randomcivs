<template>
    <div class="leaders-container" v-show="shouldRender">
        <div v-for="leader in leaders" class="leader noselect">
            <img class="leader-icon" :src="leader.icon" :alt="leader.icon">
            <div class="leader-description">
                <p class="leader-name">{{leader.name}}</p>
                <div class="civ-info">
                    <p class="civilization-name">ffff</p>
                    <img class="civilization-icon" :src="leader.iconCiv" :alt="leader.iconCiv">
                </div>
            </div>
        </div>
    </div>
</template>

<script>
	export default {
		name: "LeadersComponent",
		props: {
			leaders: Array,
			shouldRender: Boolean
		}
	}

</script>

<style scoped lang="less">

    .leaders-container {
        padding: 7px;
        display: inline-flex;
        flex-wrap: wrap;
        flex-flow: row wrap;
        max-width: 80%;
        justify-content: start;

        .leader {
            margin-left: 10px;
            width: calc(100% / 5 - 14px);
            height: 60px;
            display: flex;
            align-items: flex-start;
            border: #0b1d32 solid 1px;
            background: radial-gradient(at bottom, #1b487a, rgba(11, 29, 50, 0.8));
            border-radius: 5px;
            box-shadow: 0 0 10px 10px rgba(0, 0, 0, 0.2),
            inset 0 0 10px 10px rgba(56, 56, 56, 0.2);

            &:hover {
                background: radial-gradient(at top, #1b487a, rgba(11, 29, 50, 0.8));
            }
            .leader-icon {
                width: 50px;
                height: 50px;
                margin: 3px;
                border-radius: 50%;
            }

            .leader-description {
                width: calc(100% - 50px);
                display: flex;
                flex-direction: column;
                align-items: start;
                margin-left: 5px;
                box-sizing: border-box;

                .leader-name {
                    max-height: 30%;
                    text-align: left;
                    line-height: 1;
                    color: rgb(208, 213, 223);

                }

                .civ-info {
                    padding: 3px;
                    display: flex;
                    align-items: center;
                    justify-content: space-between;
                    width: 100%;
                    height: 26px;

                    .civilization-name {
                        text-align: right;
                        white-space: nowrap;
                        line-height: 1;
                        font-size: 0.75rem;
                        color: rgb(211, 216, 226);

                    }

                    .civilization-icon {
                        width: 17px;
                        height: 17px;
                        border-radius: 50%;
                        text-align: right;
                    }
                }
            }
        }
    }
    &:after{
        content: "";
        flex: auto;
    }
    .noselect {
        -webkit-touch-callout: none; /* iOS Safari */
        -webkit-user-select: none; /* Safari */
        -moz-user-select: none; /* Firefox */
        -ms-user-select: none; /* Internet Explorer/Edge */
        user-select: none; /* Non-prefixed version, currently
                                  supported by Chrome and Opera */
    }
</style>