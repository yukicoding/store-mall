<template>

    <div style="margin: 100px;">
        <el-card shadow="always">
            <el-form style="width: 60%;margin: auto;" :model="book" :rules="rules" ref="ruleForm" label-width="100px"
                class="demo-ruleForm">
                <!--      readonly不可选-->
                <el-form-item label="编号">
                    <el-input v-model="book.id" disabled></el-input>
                </el-form-item>

                <el-form-item label="书本名称" prop="name">
                    <el-input v-model="book.name" disabled></el-input>
                </el-form-item>
                <el-form-item label="价格" prop="price">
                    <el-input v-model="book.price" disabled></el-input>
                </el-form-item>
                <el-form-item label="邮寄地址" prop="address">
                    <el-input v-model="book.address"></el-input>
                </el-form-item>

                <el-form-item label="支付方式">
                    <img src="../../assets/ali.png" alt="" @click="submitForm('ruleForm')">
                    <!-- <el-button type="primary" @click="submitForm('ruleForm')">购买</el-button> -->
                </el-form-item>
            </el-form>
        </el-card>

        <!--    <h3>aaa:{{this.$route.query.id}}</h3>-->
    </div>
</template>

<script>
import axios from 'axios';
import { Loading } from 'element-ui';

export default {

    data() {
        return {
            book: {},
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
            },
            flag: true,
            loadingInstance: ""
        };
    },
    methods: {
        createOrder(book) {
            axios.post('http://localhost:8081/order', {
                o_price: book.price,
                o_isPaid: "N",
                o_user: localStorage.getItem('username'),
                o_deliver: book.address,
                o_bookId: book.id,
                o_book: book.name
            }).then((res) => {

                if (res.data.status === 100) {
                    axios.post("http://localhost:8081/pay/alipay",
                        res.data.data).then((res2) => {

                            let routerData = this.$router.resolve({ path: "/payorder", query: { html: res2.data } })
                            window.open(routerData.href, '_ blank')
                            const options = {
                                lock: true,
                                text: '支付中......',
                                spinner: 'el-icon-loading',
                                background: 'rgba(0, 0, 0, 0.7)'
                            }
                            this.loadingInstance = Loading.service(options);

                            return res.data.data.o_order;
                        }).then((o_order) => {
                            this.flag = true;
                            const timer = setInterval(() => {
                                axios.get(`http://localhost:8081/pay/aliQuery/${o_order}`).then((res3) => {

                                    if (res3.data.alipay_trade_query_response.trade_status && res3.data.alipay_trade_query_response.trade_status === "TRADE_SUCCESS") {
                                        axios.put("http://localhost:8081/order", { o_isPaid: "Y", o_order }).then((res) => {
                                            this.flag = false;
                                            this.$nextTick(() => { // 以服务的方式调用的 Loading 需要异步关闭
                                                this.loadingInstance.close();
                                            });

                                        })
                                    }
                                })
                                if (!this.flag) {
                                    this.$message({
                                        message: `恭喜你，购买成功，将于3日之内送至${book.address}`,
                                        type: 'success'
                                    });
                                    clearInterval(timer)
                                    this.$router.push('/home')
                                }
                            }, 3000);


                        })

                }
            })


            // setTimeout(() => {
            //     this.$message({
            //         message: '恭喜你，这是一条成功消息',
            //         type: 'success'
            //     });
            //     // axios.get(`http://localhost:8081/order/${book.o_order}`)
            //     loadingModal.close();
            // }, 2000);
        },

        submitForm(formName) {
            // const h = this.$createElement;
            // this.$msgbox({
            //     title: '消息',
            //     message: h('p', null, [
            //         h('span', null, '内容可以是 '),
            //         h('i', { style: 'color: teal' }, )
            //     ]),
            //     showCancelButton: true,
            //     confirmButtonText: '确定',
            //     cancelButtonText: '取消',
            //     beforeClose: (action, instance, done) => {
            //         if (action === 'confirm') {
            //             instance.confirmButtonLoading = true;
            //             instance.confirmButtonText = '执行中...';
            //             setTimeout(() => {
            //                 done();
            //                 setTimeout(() => {
            //                     instance.confirmButtonLoading = false;
            //                 }, 300);
            //             }, 3000);
            //         } else {
            //             done();
            //         }
            //     }
            // }).then(action => {
            //     this.$message({
            //         type: 'info',
            //         message: 'action: ' + action
            //     });
            // });



            // const _this = this;
            // console.log(this.ruleForm)
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    this.createOrder(this.book)
                    // axios.put('http://localhost:8081/book/update', this.ruleForm).then(function (resp) {
                    //     if (resp.data == 'success') {
                    //         _this.$alert('《' + _this.ruleForm.name + '》修改成功！', '消息', {
                    //             confirmButtonText: '确定',
                    //             callback: action => {
                    //                 _this.$router.push('/UpdateOrder')
                    //             }
                    //         })
                    //     }
                    // })
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

    },
    mounted() {
        console.log(this.$route.params.book)
        this.book = this.$route.params.book
        // this.createOrder(this.$route.params.book)

    }
}

</script>
