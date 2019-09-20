<template>
    <div class="result-component" v-show="showRardomResults">
        <div class="result" v-for=" randomResult in randomResults">
            <h2 class="member-name">{{randomResult.member.name}}</h2>
            <div class="result-option-list">
                <div class="result-option" v-for="resultOption in randomResult.options">
                    <img class="leader-icon" :src="resultOption.icon" :alt="resultOption.icon">
                    <div class="leader-description">
                        <p class="leader-name">{{resultOption.name}}</p>
                        <p class="leader-civilization">{{resultOption.description}}</p>

                        <!--                <div class="unique-items-container">-->
                        <!--                    <div v-for="uniqueItem in leader.uniqueItems" class="unique-item">-->
                        <!--                        <img class="unique-item-icon" :src="leader.icon" :alt="leader.icon">-->
                        <!--                        <p class="unique-item-description">{{uniqueItem.description}}</p>-->
                        <!--                    </div>-->
                        <!--                </div>-->

                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
	export default {
		props: {
			randomResults: Array,
			showRardomResults: Boolean
		},
		name: "RandomResultComponent"
	}
</script>

<style scoped lang="less">
    .result-component {
        width: 70%;
        display: flex;
        flex-wrap: wrap;
        justify-content: space-between;

        .result {
            display: flex;
            flex-direction: column;

            .result-option-list {
                display: flex;

                .result-option {
                    margin: 10px;
                    display: flex;
                    flex-wrap: wrap;
                    flex-direction: column;
                    align-items: center;
                    background: aliceblue;

                    .leader-icon {
                        width: 60px;
                        height: 60px;

                    }
                }
            }
        }
    }
</style>