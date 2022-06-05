<template>
  <div class="login_container">
    <div>
      <img src="../assets/1111.png" style="width: 100% ;height: 100%">
    </div>
    <div class="login_box">
      <!-- 头像 -->

      <div class="avator_box">
        <div>
          <img src="../assets/水墨.png" alt width="170p7x" height="170px" style=""/>
        </div>
      </div>
      <!-- 输入表单 -->
      <div style="margin-top: 300px">
        <el-form label-width="100" :model="ruleForm" :rules="rules" ref="ruleForm" class="login_form" style="top: 78px">
          <!-- name -->
          <el-form-item label="" prop="username">
            <el-input v-model="ruleForm.username" placeholder="昵称"></el-input>
          </el-form-item>

          <el-form-item label="" prop="password">
            <el-input type="password" v-model="ruleForm.password" placeholder="密码"></el-input>
          </el-form-item>
          <el-form-item label="" prop="email">
            <el-input v-model="ruleForm.email" placeholder="邮箱@qq.com"></el-input>
          </el-form-item>

          <el-form-item label="" prop="yz">
            <el-input v-model="ruleForm.yz" placeholder="验证码" style="width: 300px;float: left"></el-input>
            <el-button @click="submit(ruleForm.email)" style="float: right">获取验证</el-button>
          </el-form-item>
          <!--button -->
          <el-form-item class="btns">
            <el-button @click="resetForm" style="background-color:#c9cbcd ">登录</el-button>
            <el-button @click="submitForm('ruleForm')">立即注册</el-button>
          </el-form-item>
        </el-form>
      </div>

    </div>
  </div>
</template>

<script>
  import axios from 'axios';
  import Cookies from 'js-cookie';

  export default {
    data() {
      return {
        ruleForm: {
          username: '',
          password: '',
          email: '',
          yz: ''
        },
        rules: {
          username: [
            {required: true, message: '昵称不能为空', trigger: 'blur'}
          ],
          password: [
            {required: true, message: '密码不能为空', trigger: 'blur'}
          ],
          email: [
            {required: true, message: '邮箱不能为空', trigger: 'blur'}
          ]
        }
      }
    },
    methods: {
      submit() {
        var vm = this;
        axios.post('http://localhost:8081/email', this.ruleForm)
          .then(function (response) {
            if (response.data == 'success') { // 登录成功
              vm.$notify.success({// 弹窗
                title: '发送',
                message: '发送成功！',
                position: 'bottom-right'
              });
            } else if (response.data == 'error1') {
              {
                vm.$message({
                  type: 'error',
                  message: '已有账号，注册失败！',
                  position: 'bottom-right'
                });
                vm.$router.push('/Login'); // 跳转页面
              }
            } else {
              alert("信息不能为空")
            }
          })
      },
      submitForm(formName) {
        const _this = this
        this.$refs[formName].validate((valid) => {
          if (valid) {
            axios.post('http://localhost:8081/register', this.ruleForm).then(function (resp) {
              if (resp.data == 'success') {
                _this.$alert('《' + _this.ruleForm.username + '》注册成功！', '消息', {
                  confirmButtonText: '确定',
                  callback: action => {
                    _this.$router.push('/Login')
                  }
                })
              } else {
                _this.$alert('《' + _this.ruleForm.username + '》注册失败！', '消息', {
                  confirmButtonText: '确定'
                })
              }
            })
          }
        });
      },
      resetForm() {
        this.$router.push('/Login')
      }
    },
    created() {
      // const _this = this
      // axios.get('http://localhost:8181/book/findById/'+this.$route.query.id).then(function(resp) {
      //   _this.ruleForm = resp.data
      // })
    }
  }

</script>

<style scoped>
  .login_container {
    background-color: #c9cbcd;
    height: 100%;
  }

  .login_box {
    width: 450px;
    height: 300px;
    background-color: rgba(0, 0, 0, 0);
    border-radius: 3px;
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);
  }

  .avator_box {
    height: 160px;
    width: 160px;
    border: 1px solid #eee;
    border-radius: 50%;
    padding: 10px;
    box-shadow: 0 0 10px #ddd;
    position: absolute;
    left: 50%;
    transform: translate(-50%, -50%);
  }

  .login_form {
    background-color: rgba(0, 0, 0, 0);
    position: absolute;
    bottom: 0;
    width: 100%;
    padding: 0px 20px;
    box-sizing: border-box;
  }

  .btns {
    display: flex;
    justify-content: center;
  }

  /*element.style {*/
  /*  margin-top: 100px;*/
  /*}*/
</style>
