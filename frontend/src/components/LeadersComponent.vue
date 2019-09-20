<template>
    <div class="leaders-container" v-show="shouldRender">
        <div v-for="leader in leaders" class="leader">
            <div class="icons">
                <img class="civilization-icon" :src="leader.icon" :alt="leader.icon">
                <img class="leader-icon" :src="leader.icon" :alt="leader.icon">
            </div>
            <div class="leader-description">
                <p class="leader-name">{{leader.name}}</p>
                <p class="leader-civilization">{{leader.description}}</p>

                <!--                <div class="unique-items-container">-->
                <!--                    <div v-for="uniqueItem in leader.uniqueItems" class="unique-item">-->
                <!--                        <img class="unique-item-icon" :src="leader.icon" :alt="leader.icon">-->
                <!--                        <p class="unique-item-description">{{uniqueItem.description}}</p>-->
                <!--                    </div>-->
                <!--                </div>-->

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

    * {
        //color: #000;
    }
    .leaders-container {
        display: flex;
        margin: 0 -10px;
        flex-wrap: wrap;
        max-width: 80%;

        .leader {
            width: 250px;
            height: 80px;
            margin: 5px;
            display: flex;
            align-items: center;

            .icons {
                display: flex;

                .leader-icon {
                    width: 50px;
                    height: 50px;
                    margin: 3px;
                }

                .civilization-icon {
                    width: 50px;
                    height: 50px;
                    margin: 3px;
                }
            }

            .leader-description {
                width: calc(100% - 100px);
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
                }

                .leader-civilization {
                    max-height: 30%;
                    margin: 2px 10px;
                    text-align: left;
                    line-height: 1;
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
</style>