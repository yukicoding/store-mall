<template>
  <el-container style="height: 600px; border: 1px solid #eee">
    <el-header style="text-align: right; font-size: 12px; background-color: #545c64 ">
      <!--     -->
      <div id="app">
        <el-menu
          :default-active="activeIndex2"
          class="el-menu-demo"
          mode="horizontal"
          @select="handleSelect"
          background-color="#545c64"
          text-color="#fff"
          style="height: 60px;width: auto"
        >
          <el-menu-item index="1">管理中心</el-menu-item>

          <el-menu-item index="2" @click="transf">主页信息</el-menu-item>
          <el-dropdown style="float:right">
              <span class="el-dropdown-link" style="color: #fff">
                   <i class="el-icon-setting"></i>
              </span>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item><span @click="left1">账号退出</span></el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </el-menu>
      </div>
    </el-header>
    <el-container>
      <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
        <el-menu router :default-openeds="['0','1']">
          <el-submenu v-for="(item,index) in $router.options.routes" v-if="item.meta.showNavMenu" :index="index+''">
            <template slot="title"><i class="el-icon-message"></i>{{item.name}}</template>
            <el-menu-item v-for="item2 in item.children" :index="item2.path"
                          :class="$route.path==item2.path?'is-active':''">{{item2.name}}
            </el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>

</template>

<script>
  export default {
    data() {
      return {
        activeIndex: '1',
        activeIndex2: '1'
      };
    },
    methods: {
      handleSelect(key, keyPath) {
        console.log(key, keyPath);
      },
      transf() {
        this.$router.push("/Home")
      },
      left1() {
        this.$router.push("/Login")
      }
    }
  }

</script>

<style>
  @import url("//unpkg.com/element-ui@2.15.7/lib/theme-chalk/index.css");
</style>
