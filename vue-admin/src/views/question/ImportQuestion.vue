<template>
     <div class="view2">
      <el-row :gutter="20">
        <el-col :span="12" :xs="24">
            <el-button type="warning" plain size="mini">预览</el-button>
            <el-button type="primary" plain size="mini" @click="doImport">导入</el-button>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12" :xs="24">
          <TinymceEditor v-model="form.noticeContent" ref="tinymceEditorRef"></TinymceEditor>
        </el-col>
        <el-col :span="12" :xs="24">
          <el-scrollbar :wrap-style="{ height: '400px' }" class="preview">
            <h1 slot="header">预览区</h1>
            <el-scrollbar-item v-for="(item, index) in list" :key="index">
              <BaseQuestionPreview
                :number="index + 1"
                :topic-type="item['type']"
                :question="item"
                :options="item['options']"
              ></BaseQuestionPreview>
            </el-scrollbar-item>
          </el-scrollbar>
        </el-col>
      </el-row>
    </div>
</template>

<script>
export default {

}
</script>

<style>

</style>