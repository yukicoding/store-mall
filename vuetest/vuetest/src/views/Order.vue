<template>

  <div>
    <el-table :data="tableData" border>
      <el-table-column fixed prop="o_order" label="订单编号">
      </el-table-column>
      <el-table-column prop="o_book" label="书本名称">
      </el-table-column>
      <el-table-column prop="o_deliver" label="邮寄地址">
      </el-table-column>
      <el-table-column prop="o_price" label="购买价格">
      </el-table-column>
      <el-table-column prop="o_isPaid" label="支付" :formatter="formatter">
        <template slot-scope="scope">
          <el-tag type="success" v-if="scope.row.o_isPaid === 'Y'">已支付</el-tag>
          <el-tag type="info" v-else>标签二</el-tag>

        </template>
      </el-table-column>
      <el-table-column prop="o_createAt" label="支付时间">

      </el-table-column>

      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button @click="handleClick(scope.row)" type="text" size="small"
            style="background-color: deepskyblue; color: #fff; width: 40px; height: 25px; line-height: 8px">修改
          </el-button>
          <el-button @click="deleteData(scope.row)" type="text" size="small"
            style="background-color: red; color: #fff; width: 40px; height: 25px; line-height: 8px">删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  methods: {
    handleClick(order) {
      this.$alert('暂时不支持修改！', '消息', {
        confirmButtonText: '确定',
        callback: action => {
          window.location.reload()
        }
      })
      // this.$router.push({
      //   path: '/UpdateOrder',
      //   query: {
      //     order
      //   }
      // })

    },
    formatter(row, column) {
      return row.is
      console.log(row, column)
    },

    deleteData(row) {
      this.$alert('暂时不支持删除！', '消息', {
        confirmButtonText: '确定',
        callback: action => {
          window.location.reload()
        }
      })
      // const _this = this
      // axios.delete('http://localhost:8081/book/deleteById/' + row.id).then(function (resp) {
      //   _this.$alert('《' + row.name + '》删除成功！', '消息', {
      //     confirmButtonText: '确定',
      //     callback: action => {
      //       window.location.reload()
      //     }
      //   })
      // })
    },
    page(current) {
      // const _this = this
      // axios.get('http://localhost:8081/book/findAll/' + current + '/5').then(function (resp) {
      //   _this.tableData = resp.data.content
      //   _this.total = resp.data.totalElements
      // })
    }
  },
  mounted() {
    axios.get('http://localhost:8081/order').then(res => {
      console.log(res)
      this.tableData = res.data.data
    });
    // const _this = this
    // axios.get('http://localhost:8081/book/getAddress').then(function (resp) {
    //   _this.tableData = resp.data
    //   _this.total = resp.data.totalElements
    // })
  },
  data() {
    return {
      total: null,
      tableData: null
    }
  }
}
</script>
