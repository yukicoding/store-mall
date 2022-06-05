<template>

  <div>
    <el-form style="width: 60%" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px"
      class="demo-ruleForm">
      <!--      readonly不可选-->
      <el-form-item label="图书编号">
        <el-input v-model="ruleForm.id"></el-input>
      </el-form-item>

      <el-form-item label="书本名称" prop="name">
        <el-input v-model="ruleForm.name"></el-input>
      </el-form-item>

      <el-form-item label="作者" prop="author">
        <el-input v-model="ruleForm.author"></el-input>
      </el-form-item>
      <el-form-item label="出版社" prop="publish">
        <el-input v-model="ruleForm.publish"></el-input>
      </el-form-item>
      <el-form-item label="库存" prop="pages">
        <el-input v-model="ruleForm.pages"></el-input>
      </el-form-item>
      <el-form-item label="价钱" prop="price">
        <el-input v-model="ruleForm.price"></el-input>
      </el-form-item>
      <el-form-item label="内容" prop="content">
        <el-input v-model="ruleForm.content"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">修改</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>
    <!--    <h3>aaa:{{this.$route.query.id}}</h3>-->
  </div>
</template>

<script>
export default {
  data() {
    return {
      ruleForm: {
        id: '',
        name: '',
        author: '',
        publish: '',
        pages: '',
        price: '',
        content: ''
      },
      rules: {
        name: [
          { required: true, message: '书本名称不能为空', trigger: 'blur' }
        ],
        author: [
          { required: true, message: '作者不能为空', trigger: 'blur' }
        ]
      }
    };
  },
  methods: {
    submitForm(formName) {
      const _this = this;
      console.log(this.ruleForm)
      this.$refs[formName].validate((valid) => {
        if (valid) {
          axios.put('http://localhost:8081/book/update', this.ruleForm).then(function (resp) {
            if (resp.data == 'success') {
              _this.$alert('《' + _this.ruleForm.name + '》修改成功！', '消息', {
                confirmButtonText: '确定',
                callback: action => {
                  _this.$router.push('/Update')
                }
              })
            }
          })
        } else {
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  },
  created() {
    const _this = this
    axios.get('http://localhost:8081/book/findById/' + this.$route.query.id).then(function (resp) {
      _this.ruleForm = resp.data
    })
  }
}

</script>
