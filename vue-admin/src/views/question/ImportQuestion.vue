<template>
    <div class="view2">
      <el-row :gutter="20">
        <el-col :span="12" :xs="24">
            <el-button type="warning" plain size="mini" @click="showContent">预览</el-button>
            <el-button type="primary" plain size="mini">导入</el-button>
        </el-col>
      </el-row>
      <el-row :gutter="20">
      <el-col :span="12" :xs="24">
        <TinymceEditor v-model="form.questionsText" ref="tinymceEditorRef"></TinymceEditor>
      </el-col>
      <el-col :span="12" :xs="24">
        <h3>预览区</h3>

        <div class="preview-container">
          <QuestionPreview></QuestionPreview>
        </div>

      </el-col>
    </el-row>
    </div>
</template>

<script>
import TinymceEditor from '@/components/Exam/TinymceEditor';
import QuestionPreview from '@/components/Exam/QuestionPreview';
import {parseQuestion} from '@/api/question';

export default {
  components: { TinymceEditor,QuestionPreview},
  data() {
    
    return {
      form: {
        questionsText: ''
      },
    }
  },
  methods: {
    showContent(){
      parseQuestion(this.form);
    },
  },

}




</script>

<style>
.preview-container {
  height: 450px; /* 设置容器的高度，可以根据需要进行调整 */
  overflow-y: auto; /* 启用纵向滚动条 */
}
</style>