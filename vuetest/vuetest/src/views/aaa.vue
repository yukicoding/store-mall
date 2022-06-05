<template>

  <el-row>
    <el-col :span="4"><div class="grid-content bg-purple">
      <div id="menu" >
        <ul class="ss" list-style="none" >
          <li class="cc" v-for="(item, index) in list_img" :key="index"><img :src="item.url" style="width: 175px; height: 149px;"></li>
        </ul>

      </div>
    </div>
    </el-col>
    <el-col :span="12"><div class="grid-content bg-purple-light" border-style="solid">
      <div class="a">
        <h1 align="center"><li class="el-icon-platform-eleme"></li>江南第一才子唐寅行书《诗笺》</h1>
        <p>江南第一才子唐寅行书《诗笺》书法图片10张唐寅（1470-1523）字伯虎，更字子畏，号桃花庵主，
          鲁国唐生，逃禅仙史，南京解元，江南第一风流才子等。“明四大家”之一，被誉为明中叶江南第一才子。他博学多能，
          吟诗作曲，能书善画，经历坎坷。是我国绘画史上杰出的大画家。</p>
      </div>
      <div class="b">
        <h1 align="center"><li class="el-icon-platform-eleme"></li>江南第一才子唐寅行书《诗笺》</h1>
        <p>江南第一才子唐寅行书《诗笺》书法图片10张唐寅（1470-1523）字伯虎，更字子畏，号桃花庵主，
          鲁国唐生，逃禅仙史，南京解元，江南第一风流才子等。“明四大家”之一，被誉为明中叶江南第一才子。他博学多能，
          吟诗作曲，能书善画，经历坎坷。是我国绘画史上杰出的大画家。 </p>
      </div>
      <div class="b">
        <h1 align="center"><li class="el-icon-platform-eleme"></li>江南第一才子唐寅行书《诗笺》</h1>
        <p>江南第一才子唐寅行书《诗笺》书法图片10张唐寅（1470-1523）字伯虎，更字子畏，号桃花庵主，
          鲁国唐生，逃禅仙史，南京解元，江南第一风流才子等。“明四大家”之一，被誉为明中叶江南第一才子。他博学多能，
          吟诗作曲，能书善画，经历坎坷。是我国绘画史上杰出的大画家。 </p>
      </div>
      <div class="b">
        <h1 align="center"><li class="el-icon-platform-eleme"></li>江南第一才子唐寅行书《诗笺》</h1>
        <p>江南第一才子唐寅行书《诗笺》书法图片10张唐寅（1470-1523）字伯虎，更字子畏，号桃花庵主，
          鲁国唐生，逃禅仙史，南京解元，江南第一风流才子等。“明四大家”之一，被誉为明中叶江南第一才子。他博学多能，
          吟诗作曲，能书善画，经历坎坷。是我国绘画史上杰出的大画家。 </p>
      </div>
      </div>
    </el-col>
    <el-col :span="8"><div class="grid-content bg-purple">
      <div class="w" align="center">
        <h2 align="center">名家书法</h2>
        <div style="margin-left: 30px">
           <span style="float:right">
      <el-checkbox-group v-model="checkList">
        <el-checkbox label="苏黄米蔡"></el-checkbox>
        <el-checkbox label="颜柳欧赵"></el-checkbox>

        <el-checkbox label="二王书法"></el-checkbox>
        <el-checkbox label="二s王书法"></el-checkbox>
      </el-checkbox-group>
             </span>
        </div>
      </div>
      <div style="margin-top: 20px">
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
      <div class="demo-image__placeholder">
        <div class="block">
          <span class="demonstration" ></span>
          <span style="float:right">
          <el-image :src="src"></el-image>
          </span>
        </div>
<!--        <div class="block">-->
<!--          <span class="demonstration">自定义</span>-->
<!--          <el-image :src="src">-->
<!--            <div slot="placeholder" class="image-slot">-->
<!--              加载中<span class="dot">...</span>-->
<!--            </div>-->
<!--          </el-image>-->
<!--        </div>-->
      </div>
    </div></el-col>
  </el-row>

</template>

<script>
    export default {
        name: "aaa",
  data() {
    return {
      activeNames: ['2'],
      list_img: [
        {url: require('../assets/22.jpg')},
        {url: require('../assets/htjlhs1.jpg')},
        {url: require('../assets/23.jpg')},
        {url: require('../assets/09.jpg')},
      ],
      checkList: ['二s王书法', '苏黄米蔡'],
      src: 'http://www.yac8.com/upFiles/images/wxgzh888.png'
    };
  },
            methods: {
      handleChange(val) {
        console.log(val);
      }

  }


    }



</script>

<style scoped>
ul{
  list-style: none;
}


/*element.style {*/
/*}*/
/*.el-checkbox__label {*/
/*  display: inline-block;*/
/*  padding-left: 50px;*/
/*  line-height:80px;*/
/*  font-size: 33px;*/
/*}*/
/*.el-checkbox {*/
/*  color: #606266;*/
/*  font-weight: 700;*/
/*  font-size: 45px;*/
/*  cursor: pointer;*/
/*  -webkit-user-select: none;*/
/*  -moz-user-select: none;*/
/*  -ms-user-select: none;*/
/*  user-select: none;*/
/*  margin-right: 30px;*/
/*}*/

</style>
