<template>
    <div class="leaders-container" v-show="shouldRender">
        <div v-for="leader in leaders" class="leader">
            <img class="leader-icon" :src="leader.icon" :alt="leader.icon">
            <div class="leader-description">
                <p class="leader-name">{{leader.name}}</p>
                <div class="civ-info">
                    <img class="civilization-icon" :src="leader.icon" :alt="leader.icon">
                    <p class="leader-civilization">{{leader.description}}</p>
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
        display: flex;
        margin: 15px 10px;
        flex-wrap: wrap;
        flex-flow: row wrap;
        max-width: calc(100% - 400px - 20px);
        justify-content: space-around;

        .leader {
            width: 280px;
            height: 80px;
            margin: 0px 16px;
            display: flex;
            align-items: flex-start;
            border: #0b1d32 solid 1px;
            background: radial-gradient(at bottom, #1b487a, rgba(11, 29, 50, 0.8));
            border-radius: 5px;
            box-shadow: 0 0 10px 10px rgba(0, 0, 0, 0.2),
            inset 0 0 10px 10px rgba(56, 56, 56, 0.2);

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
                    margin: 2px 10px;
                    text-align: left;
                    line-height: 1;
                    font-size: 1.3rem;
                }

                .civ-info {
                    display: flex;
                    align-items: center;

                    .leader-civilization {
                        max-height: 30%;
                        margin: 2px 10px;
                        text-align: right;
                        line-height: 1;
                        font-size: 1rem;
                    }

                    .civilization-icon {
                        width: 25px;
                        height: 25px;
                        margin: 3px;
                        border-radius: 50%;
                    }
                }
            }

            .unique-items-container {
                display: flex;
                flex-wrap: wrap;
                align-items: center;
                height: 30px;

                .unique-item {
                    display: flex;
                    margin: 0px 5px;

                    .unique-item-icon {
                        width: 20px;
                        height: 20px;
                    }

                    .unique-item-description {
                        margin: 0px 5px;
                    }
                }
            }
        }
    }

    .leaders-container::after {
        content: "";
        flex: auto;

        .leader::after {
            margin: 100px;
        }
    }
</style>