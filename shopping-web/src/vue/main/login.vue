<template>
  <div class="loginDiv">
    <el-form class="loginForm" :inline="true">
      <el-col :span="24">
        <el-form-item label="用户">
          <el-input v-model="userName" placeholder="用户名"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="24">
        <el-form-item label="密码">
          <el-input v-model="password" placeholder="密码"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="24">
        <el-form-item>
          <el-button type="info" @click="login">登陆</el-button>
          <el-button type="info" @click="dialogFormVisible = true">注册</el-button>
        </el-form-item>
      </el-col>
    </el-form>
    <el-dialog title="用户注册" :visible.sync="dialogFormVisible" size="tiny">
      <el-form :model="form" :inline="true">
        <el-col :span="24">
          <el-form-item label="用户" required :label-width="formLabelWidth">
            <el-input v-model="form.userName" placeholder="用户名"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="密码" required :label-width="formLabelWidth">
            <el-input v-model="form.password" placeholder="密码"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="重复密码" required :label-width="formLabelWidth">
            <el-input v-model="form.passwordAgain" placeholder="请再次输入密码"></el-input>
          </el-form-item>
        </el-col>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="regist">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
  export default {
    data () {
      return {
        userName: '',
        password: '',
        dialogFormVisible: false,
        form: {
          userName: '',
          password: '',
          passwordAgain: ''
        },
        formLabelWidth: '80px'
      }
    },
    methods: {
      login () {
        this.$http.get(this.library.urlHead + '/login').then((reply) => {
          this.$message({
            message: '登陆成功',
            type: 'info'
          })
        }).catch(() => {
          this.$message({
            message: '正在开发, 可以先登录',
            type: 'info'
          })
          this.$router.push('/index')
        })
      },
      regist () {
        if (this.form.password !== this.form.passwordAgain || this.form.password === '' || this.form.passwordAgain === '') {
          this.$message({
            message: '请输入正确的信息',
            type: 'error'
          })
          return false
        }
        this.$http.post(this.library.urlHead + '/user/addUser', {userName: this.form.userName, password: this.form.password}).then((reply) => {
          this.$message({
            message: '注册成功',
            type: 'info'
          })
          this.dialogFormVisible = false
        }).catch(() => {
          this.$message({
            message: '注册失败',
            type: 'error'
          })
        })
      }
    }
  }
</script>
<style scoped>
  .loginDiv {
    width:100%;
    height:1000px;
    background:url(/static/images/index/loginBG.jpg) no-repeat top left; 
    background-size:100% 100%;
    overflow: hidden;
  }
  .loginForm {
    position:absolute;
    top:50%;
    left:50%;
    width:250px;
    height:250px;
    margin-top:-125px;
    margin-left:-125px;
  }
</style>

