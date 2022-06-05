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
      <el-form label-width="100" :model="ruleForm" :rules="rules" ref="ruleForm" class="login_form">
        <!-- name -->
        <el-form-item label="" prop="username">
          <el-input v-model="ruleForm.username" placeholder="账号"></el-input>
        </el-form-item>

        <el-form-item label="" prop="password">
          <el-input type="password" v-model="ruleForm.password" placeholder="密码"></el-input>
        </el-form-item>

        <!--button -->
        <el-form-item class="btns">
          <el-button @click="submitForm(ruleForm.username)">立即登录</el-button>
          <el-button @click=resetForm() style="background-color:#c9cbcd ">注册</el-button>
        </el-form-item>
      </el-form>
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
          user: sessionStorage.getItem("success")
        },
        rules: {
          username: [
            {required: true, message: '账号不能为空', trigger: 'blur'}
          ],
          password: [
            {required: true, message: '密码不能为空', trigger: 'blur'}
          ]
        }
      }
    },
    methods: {
      submitForm(username) {
        var vm = this;
        axios.post('http://localhost:8081/login', this.ruleForm)
          .then(function (response) {
            if (response.data.state == 200) { // 登录成功
              vm.$notify.success({// 弹窗
                title: '登录',
                message: '登录成功！',
                position: 'bottom-right'
              });

              localStorage.setItem("username",username)
              // 登录成功后
              // console.log(sessionStorage.getItem("success"))
              vm.$router.push({
                path: '/Home',
                query: {
                  username: username
                }
              }); // 跳转页面
            } else if (response.data.state == 202) {
              vm.$message({
                type: 'error',
                message: '登录失败，用户名或密码错误！'
              });
            } else {
              vm.$message({
                type: 'error',
                message: '发生错误，登录失败！'
              });
            }
          })
          .catch(function (error) {
            console.log(error)
          })
      },
      resetForm(formName) {
        const vm = this;
        // 清除内容 this.$refs[formName].resetFields();
        vm.$router.push('/Register'); // 跳转页面
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
    padding: 0 20px;
    box-sizing: border-box;
  }

  .btns {
    display: flex;
    justify-content: center;
  }
</style>
