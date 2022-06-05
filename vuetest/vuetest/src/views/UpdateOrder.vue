<template>

  <div>
    <el-form style="width: 60%" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px"
             class="demo-ruleForm">
      <!--      readonly不可选-->
      <el-form-item label="编号">
        <el-input v-model="ruleForm.id"></el-input>
      </el-form-item>

      <el-form-item label="书本名称" prop="name">
        <el-input v-model="ruleForm.name"></el-input>
      </el-form-item>

      <el-form-item label="邮寄地址" prop="address">
        <el-input v-model="ruleForm.address"></el-input>
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
          address: ''
        },
        rules: {
          name: [
            { required: true, message: '书本名称不能为空', trigger: 'blur' }
          ],
          address: [
            { required: true, message: '邮寄地址不能为空', trigger: 'blur' }
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
                    _this.$router.push('/UpdateOrder')
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
