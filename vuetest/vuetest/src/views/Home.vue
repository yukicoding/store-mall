<template>
  <div>

    <el-container style="text-align: center;margin: 0 auto">
      <el-header style="font-size: 12px; background-color: #545c64 ;height: 90px">
        <!--     -->
        <div id="app">
          <el-menu :default-active="activeIndex2" class="el-menu-demo" mode="horizontal" @select="handleSelect"
            background-color="#545c64" text-color="#fff">

            <div>
              <img src="../assets/水墨.png" width="80px" height="80px" style="float: left;margin-right: 15px" />
            </div>
            <span style="font-family: 微软雅黑;float: left;font-size: 50px;margin-top: 15px;text-shadow: 0 0 7px #fff">奇缘书城
            </span>
            <el-dropdown style="float:right;margin: 30px 0px 0px 10px">
              <span class="el-dropdown-link" style="color: #fff">
                <i class="el-icon-setting"></i>
              </span>
              <el-dropdown-menu slot="dropdown">
                <el-dropdown-item><span @click="left1">退出</span></el-dropdown-item>
                <el-dropdown-item><span @click="trans">注册</span></el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>
            <div style="float: right;margin-top: 30px">
              <el-menu-item index="1" @click="a">管理中心</el-menu-item>
            </div>
          </el-menu>

        </div>

      </el-header>
      <el-main>
        <!--轮播图-->
        <el-container>
          <el-carousel :interval="4000" type="card" height="200px" style="width:100%">
            <el-carousel-item v-for="(item, index) in list_img" :key="index">
              <h3 class="medium">
                <img :src="item.url">
              </h3>
            </el-carousel-item>
          </el-carousel>
        </el-container>

        <el-row>
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <div id="menu">
                <ul class="ss" list-style="none">
                  <li class="cc" v-for="(item, index) in list_img1" :key="index">
                    <el-divider></el-divider>
                    <el-card :body-style="{ padding: '0px' }">
                      <img :src="item.url" class="image">
                      <div style="padding: 14px;">

                        <div class="bottom clearfix">
                          <time class="time">{{ currentDate }}</time>
                          <el-button type="text"><span>书</span></el-button>
                        </div>
                      </div>
                    </el-card>
                  </li>
                </ul>

              </div>
            </div>
          </el-col>
          <el-col :span="12">
            <div class="grid-content bg-purple-light" border-style="solid" style="margin-top: -13px">

              <div>
                <div v-for="(item, index) in books" :key="index">
                  <el-card class="box-card" shadow="hover" style="margin:40px;border-radius: 20px;">
                    <div slot="header" class="clearfix a">

                      <el-button type="text" @click="open(item.id)">
                        <h1>
                          <li class="el-icon-platform-eleme"></li>
                          {{ item.name }}
                        </h1>
                      </el-button>
                      <!-- <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button> -->
                    </div>
                    <div class="text item" @click="open(item.id)">
                      <p>内容简介：{{ item.content }}</p>
                    </div>
                    <div class="bottom clearfix">
                      <span class="button" style="color:#909399">作者：{{ item.author }}</span>

                    </div>
                    <div style="margin-top: 20px; border-top: 1px solid rgb(235,238,245);">
                      <p>
                        评论：<input title="text" v-model="comment[index]" />
                        <el-button style=" width: 55px; height: 24px; line-height: 8px" size="mini"
                          @click="setComment(item.id, comment[index])">提交
                        </el-button>
                      </p>
                    </div>
                    <div>
                      <el-popover placement="right" width="400" trigger="click">
                        <el-table :data="gridData">
                          <el-table-column width="150" property="bid" label="ID"></el-table-column>
                          <el-table-column width="100" property="comments" label="内容"></el-table-column>
                        </el-table>
                        <el-button slot="reference" size="mini" @click="getComment(item.id)">查看评论</el-button>
                      </el-popover>
                    </div>
                  </el-card>
                </div>
                <el-pagination background layout="prev, pager, next" page-size="5" :total="total"
                  @current-change="page">
                </el-pagination>
              </div>
            </div>

          </el-col>

          <el-col :span="6">
            <div class="grid-content bg-purple">
              <div class="w" align="center">
                <h2 align="center">名家书法</h2>
                <div style="margin-left: 20px">

                  <el-checkbox-group v-model="checkList">
                    <div style="text-align: center">
                      <el-checkbox label="苏黄米蔡"></el-checkbox>
                      <el-checkbox label="颜柳欧赵"></el-checkbox>
                    </div>
                    <br /><br />
                    <div style="text-align: center">
                      <el-checkbox label="二王书法"></el-checkbox>
                      <el-checkbox label="入木三分"></el-checkbox>
                    </div>

                  </el-checkbox-group>

                </div>
              </div>
              <div style="margin-left: 20px">
                <el-collapse v-model="activeNames" @change="handleChange">
                  <!--        <el-collapse-item title="" Consistency" name="1">-->
                  <!--          <div>与现实生活一致：与现实生活的流程、逻辑保持一致，遵循用户习惯的语言和概念；</div>-->
                  <!--          <div>在界面中一致：所有的元素和结构需保持一致，比如：设计样式、图标和文本、元素的位置等。</div>-->
                  <!--        </el-collapse-item>-->
                  <br>
                  <el-collapse-item title="柳公权楷书欣赏《玄秘塔碑》高清全文" name="2">
                    <div>柳公权楷书欣赏《玄秘塔碑》全称《唐故左街僧录内供奉》</div>
                    <div>唐裴休撰文，柳公权书并篆额。为柳公权六十三岁那年所书。</div>
                  </el-collapse-item>
                  <el-collapse-item title="欧阳询书法欣赏《皇甫君碑》帖" name="3">
                    <div>欧阳询书法欣赏《皇甫君碑》帖高清晰书法图片32张欧阳询（557-641）;</div>
                    <div>字信本，公元557年出生于衡州（今衡阳），祖籍潭州临湘（今湖南长沙）;</div>
                    <div>楷书四大家（欧阳询、颜真卿、柳公权、赵孟頫）之一。隋时官太常博士，.</div>
                  </el-collapse-item>
                  <el-collapse-item title="赵孟頫行书字帖欣赏《高峰和尚行状》" name="4">
                    <div>孟頫行书字帖欣赏《高峰和尚行状》,彩色书法图片90张；</div>
                    <div>赵孟頫(1254—1322)字子昂，号松雪，浙江湖州人，是元代最显赫的书画家。</div>
                  </el-collapse-item>
                </el-collapse>
              </div>
              <!--<div class="demo-image__placeholder">-->
              <!--<div class="block">-->
              <!--<span class="demonstration"></span>-->
              <!--<span style="float:right">-->
              <!--<el-image :src="src"></el-image>-->
              <!--</span>-->
              <!--</div>-->
              <!--<div class="block">-->
              <!--<span class="demonstration">自定义</span>-->
              <!--<el-image :src="src">-->
              <!--<div slot="placeholder" class="image-slot">-->
              <!--加载中<span class="dot">...</span>-->
              <!--</div>-->
              <!--</el-image>-->
              <!--</div>-->
              <!--</div>-->
            </div>
          </el-col>
        </el-row>
      </el-main>

    </el-container>
    <router-view></router-view>
  </div>

</template>

<script>
const axios = require("axios");
export default {
  name: 'Home',
  data() {
    return {
      list_img: [
        { url: require('../assets/2.jpg') },
        { url: require('../assets/3.jpg') },
        { url: require('../assets/4.png') },
        { url: require('../assets/back.png') }
      ],
      activeNames: ['2'],
      list_img1: [
        { url: require('../assets/22.jpg') },
        { url: require('../assets/htjlhs1.jpg') },
        { url: require('../assets/23.jpg') }
        // {url: require('../assets/09.jpg')}
      ],
      books: [],
      total: 0,
      address: "",
      comment: [],
      gridData: []
    }
  },
  created() { // 页面加载就调用方法判断
    axios.get('http://localhost:8081/book/findAll/1/5').then((res) => {
      console.log(res)
      this.books = res.data.content
      this.total = res.data.totalElements
    })
  },
  mounted() {
    console.log(this.books)
  },
  methods: {
    setComment(id, comment) {
      axios.get('http://localhost:8081/book/set/' + comment + '/' + id).then((res) => {
        alert("评论成功")
        this.comment = [];
      })
    },
    getComment(id) {
      let _this = this
      axios.get('http://localhost:8081/book/get/' + id).then((res) => {
        _this.gridData = res.data
        console.log(_this.gridData);
      })
    },
    handleChange(val) {
      console.log(val);
    },
    a() {
      this.$router.push("/Find")
    },
    trans() {
      this.$router.push("/Register")
    },
    left1() {
      this.$router.push("/Login")
    },
    page(current) {
      document.documentElement.scrollTop = 0;
      axios.get('http://localhost:8081/book/findAll/' + current + '/5').then((res) => {
        this.books = res.data.content
        this.total = res.data.totalElements
      })
    },
    // 监听输入框值
    onCommentInputChange() {
      console.log(document.getElementById("address").value)
      this.address = document.getElementById("address").value;
    },
    open(value) {
      let book = this.books.filter((item) => item.id === value)[0];
      console.log(book)
      this.$router.push({ name: "购买", params: { book } })
      // const h = this.$createElement;
      // this.$msgbox({
      //   title: '书本信息',
      //   message: h('p', null, [
      //     h('span', null, '书名：'),
      //     h('i', book.name),
      //     h('br', ''),
      //     h('span', null, '作者：'),
      //     h('i', book.author),
      //     h('br', ''),
      //     h('span', null, '价格：'),
      //     h('i', book.price),
      //     h('br', ''),
      //     // h('span', null, '库存'),
      //     // h('i', book.pages),
      //     // h('br', ''),
      //     h('div', '邮寄地址:'),
      //     h("input", {
      //       attrs: {
      //         placeholder: "请输入地址",
      //         class: "el-textarea__inner",
      //         autocomplete: "off",
      //         rows: 15,
      //         id: "address"
      //       },
      //       value: this.address,
      //       on: { input: this.onCommentInputChange }
      //     })
      //   ]),
      //   showCancelButton: true,
      //   confirmButtonText: '确定',
      //   cancelButtonText: '取消',
      //   beforeClose: async (action, instance, done) => {
      //     if (action === 'confirm') {
      //       if (this.address === '') {
      //         return this.$message({
      //           message: '请输入邮寄地址',
      //           type: 'warning'
      //         });
      //       }
      //       instance.confirmButtonLoading = true;
      //       instance.confirmButtonText = '执行中...';
      //       axios.put('http://localhost:8081/book/update', { ...book, pages: book.pages - 1 }).then((res) => {
      //         return res
      //       }).then((res) => {
      //         if (res.data === 'success') {

      //           setTimeout(() => {
      //             done();
      //             setTimeout(() => {
      //               instance.confirmButtonLoading = false;
      //               document.getElementById("address").value = "";
      //             }, 300);
      //           }, 3000);

      //         } else {
      //           this.$message({
      //             message: '网络问题，购买失败',
      //             type: 'warning'
      //           });
      //         }

      //       })

      //     } else {
      //       done()
      //     }
      //   }
      // }).then(async (action) => {
      //   this.$message({
      //     type: 'success',
      //     message: '购买成功: 您的地址是：' + this.address + ',24小时内为您安排发货'
      //   });
      //   document.getElementById("address").value = "";
      //   this.address = ""
      // });
    },
    buy(book) {
      axios.put('http://localhost:8081/book/update', { ...book, pages: book.pages - 1 }).then((res) => {
        if (res.data == 'success') {
          this.$message({
            message: '恭喜你，这是一条成功消息',
            type: 'success'
          });
        }
      })

    }


  }
}

</script>

<style>
.time {
  font-size: 13px;
  color: #999;
}

.bottom {
  margin-top: 13px;
  line-height: 12px;
}

.button {
  padding: 0;
  float: right;
}

.image {
  width: 100%;
  display: block;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both
}

.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}

ul {
  list-style: none;
}

.cc {
  margin-right: 60px;
}

.el-menu.el-menu--horizontal {
  border-bottom: solid 0px #e6e6e6;
}

.el-menu--horizontal>.el-menu-item.is-active {
  border-bottom: 0px solid #409EFF;
  color: #303133;
}

/*.el-menu--horizontal>.el-menu-item.is-active {*/
/*  border-bottom: 0px solid #409EFF;*/
/*  color: #303133;*/
/*}*/
</style>
