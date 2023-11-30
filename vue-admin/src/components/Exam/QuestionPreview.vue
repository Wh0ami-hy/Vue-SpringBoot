<template>
    <div class="questionInfo">
        <!-- 单选、多选渲染共用一套逻辑 -->
        <div v-for="(item, index) in this.questionContent" :key="index">
            <!-- 单选 -->
            <div v-if="item.type === 'SIGNAL_CHOICE'">
                <p>({{ item.score }}分) {{ index+1 + '、' + item.content }}</p>
                <ul>
                <li v-for="(option, optionIndex) in item.options" :key="optionIndex">
                    {{ String.fromCharCode(65 + optionIndex) }}、 {{ option.content }}
                </li>
                </ul>
                <p>答案： {{ getAnswer(item.options) }}</p>
            </div>
            <!-- 多选 -->
            <div v-if="item.type === 'MULTIPLE_CHOICE'">
                <p>({{ item.score }}分) {{ item.content }}</p>
                <ul>
                <li v-for="(option, optionIndex) in item.options" :key="optionIndex">
                    {{ String.fromCharCode(65 + optionIndex) }}、 {{ option.content }}
                </li>
                </ul>
                <p>答案： {{ getAnswer(item.options) }}</p>
            </div>
            <!-- 填空 -->
            <div v-if="item.type === 'COMPLETION'">
                <p>({{ item.score }}分) {{ index+1 + '、' + item.content }}</p>
                <p>答案： {{ item.options.map(option => option.answer).join('； ') }}</p>
            </div>
            <!-- 简答 -->
            <!-- 判断 -->

        </div>
    </div>
  
</template>

<script>
export default {
    name: 'QuestionPreview',
    data(){
        questionType: ['SIGNAL_CHOICE','MULTIPLE_CHOICE','COMPLETION','SUBJECTIVE'] // 没有判断题
  

        return{
            questionContent: [
        {
            "createdAt": null,
            "updatedAt": null,
            "id": null,
            "content": "1、程序状态字寄存器 PSW 中的 AC=1,表示( )。",
            "type": "SIGNAL_CHOICE",
            "score": 4,
            "options": [
                {
                    "createdAt": null,
                    "updatedAt": null,
                    "id": null,
                    "content": "计算结果有进位",
                    "questionId": null,
                    "answer": null
                },
                {
                    "createdAt": null,
                    "updatedAt": null,
                    "id": null,
                    "content": "计算结果有溢出",
                    "questionId": null,
                    "answer": null
                },
                {
                    "createdAt": null,
                    "updatedAt": null,
                    "id": null,
                    "content": "累加器 A 中的数据有奇数个 1",
                    "questionId": null,
                    "answer": null
                },
                {
                    "createdAt": null,
                    "updatedAt": null,
                    "id": null,
                    "content": "计算结果低 4 位向高位进位\n",
                    "questionId": null,
                    "answer": "1"
                }
            ]
        },
                {
            "createdAt": null,
            "updatedAt": null,
            "id": null,
            "content": "1、程序状态字寄存器 PSW 中的 AC=1,表示( )。",
            "type": "SIGNAL_CHOICE",
            "score": 4,
            "options": [
                {
                    "createdAt": null,
                    "updatedAt": null,
                    "id": null,
                    "content": "计算结果有进位",
                    "questionId": null,
                    "answer": null
                },
                {
                    "createdAt": null,
                    "updatedAt": null,
                    "id": null,
                    "content": "计算结果有溢出",
                    "questionId": null,
                    "answer": null
                },
                {
                    "createdAt": null,
                    "updatedAt": null,
                    "id": null,
                    "content": "累加器 A 中的数据有奇数个 1",
                    "questionId": null,
                    "answer": null
                },
                {
                    "createdAt": null,
                    "updatedAt": null,
                    "id": null,
                    "content": "计算结果低 4 位向高位进位\n",
                    "questionId": null,
                    "answer": "1"
                }
            ]
        },
                {
            "createdAt": null,
            "updatedAt": null,
            "id": null,
            "content": "1、程序状态字寄存器 PSW 中的 AC=1,表示( )。",
            "type": "SIGNAL_CHOICE",
            "score": 4,
            "options": [
                {
                    "createdAt": null,
                    "updatedAt": null,
                    "id": null,
                    "content": "计算结果有进位",
                    "questionId": null,
                    "answer": null
                },
                {
                    "createdAt": null,
                    "updatedAt": null,
                    "id": null,
                    "content": "计算结果有溢出",
                    "questionId": null,
                    "answer": null
                },
                {
                    "createdAt": null,
                    "updatedAt": null,
                    "id": null,
                    "content": "累加器 A 中的数据有奇数个 1",
                    "questionId": null,
                    "answer": null
                },
                {
                    "createdAt": null,
                    "updatedAt": null,
                    "id": null,
                    "content": "计算结果低 4 位向高位进位\n",
                    "questionId": null,
                    "answer": "1"
                }
            ]
        },
                {
            "createdAt": null,
            "updatedAt": null,
            "id": null,
            "content": "1、程序状态字寄存器 PSW 中的 AC=1,表示( )。",
            "type": "SIGNAL_CHOICE",
            "score": 4,
            "options": [
                {
                    "createdAt": null,
                    "updatedAt": null,
                    "id": null,
                    "content": "计算结果有进位",
                    "questionId": null,
                    "answer": null
                },
                {
                    "createdAt": null,
                    "updatedAt": null,
                    "id": null,
                    "content": "计算结果有溢出",
                    "questionId": null,
                    "answer": null
                },
                {
                    "createdAt": null,
                    "updatedAt": null,
                    "id": null,
                    "content": "累加器 A 中的数据有奇数个 1",
                    "questionId": null,
                    "answer": null
                },
                {
                    "createdAt": null,
                    "updatedAt": null,
                    "id": null,
                    "content": "计算结果低 4 位向高位进位\n",
                    "questionId": null,
                    "answer": "1"
                }
            ]
        },
        {
            "createdAt": null,
            "updatedAt": null,
            "id": null,
            "content": "总线路是用于传送信息的公共通信途径。总线可分为____、____和____。",
            "type": "COMPLETION",
            "score": null,
            "options": [
                {
                    "createdAt": null,
                    "updatedAt": null,
                    "id": null,
                    "content": null,
                    "questionId": null,
                    "answer": "数据总线"
                },
                {
                    "createdAt": null,
                    "updatedAt": null,
                    "id": null,
                    "content": null,
                    "questionId": null,
                    "answer": " 地址总线"
                },
                {
                    "createdAt": null,
                    "updatedAt": null,
                    "id": null,
                    "content": null,
                    "questionId": null,
                    "answer": " 控制总线</span>\n&nbsp;"
                }
            ]
        }]
        }
    },
    methods: {
        getAnswer(options) {
            let answers = options
                .filter(option => option.answer === "1")
                .map(option => String.fromCharCode(65 + options.indexOf(option)));
            return answers.join("、");
        }
    },
}
</script>

<style>

</style>