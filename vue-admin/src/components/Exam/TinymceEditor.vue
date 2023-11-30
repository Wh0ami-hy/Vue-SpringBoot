<template>
  <div class="tinymce-editor">
    <Editor v-model="myValue" :init="init" :disabled="disabled" ref="editorRef"
      :key="timestamp" @onClick="onClick">
    </Editor>
  </div>
</template>

<script>
import tinymce from 'tinymce/tinymce'
import Editor from '@tinymce/tinymce-vue'
import 'tinymce/themes/silver/theme'

export default {
  name: 'TinymceEditor',
  components: {
    Editor
  },
  props: {
    // 传入一个value，使组件支持v-model绑定
    value: {
      type: String,
      default: ''
    },
    disabled: {
      type: Boolean,
      default: false
    },
    menubar: { // 菜单栏      
      type: String,
      default: 'file edit insert view format table'
    },
    // 相关插件配置
    plugins: {
      type: [String, Array],
      default:
        'lists advlist image imagetools table autolink preview'
    },
    // 工具栏配置
    toolbar: {
      type: [String, Array],
      default:
        'undo redo |  formatselect | fontsizeselect | bold italic underline forecolor backcolor | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | lists image table preview'
    },
    // 富文本高度
    height: {
      type: Number,
      default: 500
    }
  },
  data () {
    return {
      // 当前时间戳,是为了解决回显问题
      timestamp: 0,
      //初始化配置
      init: {
        // language_url: '/tinymce/langs/zh-Hans.js', // 根据自己文件的位置，填写正确的路径，注意/可以直接访问到public文件
        // language: 'zh_CN',
        skin_url: '/tinymce/skins/ui/oxide', // 根据自己文件的位置，填写正确的路径。路径不对会报错
        height: this.height,
        plugins: this.plugins,
        toolbar: this.toolbar,
        branding: false,
        menubar: false,
        resize: false,
      },
      myValue: this.value
    }
  },
  methods: {
    // 需要什么事件可以自己增加 可用的事件参照文档=> https://github.com/tinymce/tinymce-vue
    onClick (e) {
      this.$emit('onClick', e, tinymce)
    },
    // 可以添加一些自己的自定义事件，如清空内容
    clear () {
      this.myValue = ''
    },

    // 解决切换页签后数据回显问题
    setTinymceContent () {
      setTimeout(() => {
        this.timestamp = new Date().getTime()
      }, 10)
    }
  },
  watch: {
    value: {
      handler (newValue) {
        this.myValue = newValue
      },
      immediate: true
    },
    myValue (newValue) {
      this.$emit('input', newValue)
    }
  }
}
</script>

<style>

</style>